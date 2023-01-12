package Modele;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Classe {

    /**
     * Constructeur créant un objet Classe dans le but de l'afficher
     * @param name nom de la classe
     * @param nomPackage nom du package de la classe
     */

    public Classe(String name, String nomPackage) {
        this.nomClasse=name;
        this.nomPackage=nomPackage;
        this.typeClasse="Class";
        this.attributs=new ArrayList<>();
        this.constructeurs=new ArrayList<>();
        this.methodes=new ArrayList<>();
        this.interfaces = new ArrayList<>();
    }

    protected String fileName;
    protected String typeClasse;
    protected String nomClasse;
    protected String nomPackage;
    protected List<String> attributs;
    protected List<String> constructeurs;
    protected List<String> methodes;
    protected Classe parents;

    protected List<Classe> interfaces;

    public String getTypeClasse() {
        return this.typeClasse;
    }

    public String getNomClasse() {
        return this.nomClasse;
    }

    public String getNomPackage() {
        return this.nomPackage;
    }

    public List<String> getAttributs() {
        return this.attributs;
    }

    public List<String> getConstructeurs() {
        return this.constructeurs;
    }

    public List<String> getMethodes() {
        return this.methodes;
    }

    public Classe getParents() {
        return this.parents;
    }

    public String getFileName() { return this.fileName; }

    public List<Classe> getInterfaces(){ return this.interfaces; }

    /**
     * Methode permettant d afficher les informations d une classe dans un terminal sous forme de texte
     * @return informations de la classe
     */

    public String toString() {
        // Affichage du type de la classe
        String res="<<Java "+this.typeClasse+">>\n";
        // Affichage de son nom et de son package
        res+=this.nomClasse + "\n";
        res+=this.nomPackage + "\n";
        res+="_________\n";
        // Affichage de la liste de ses attributs
        res+=this.attributs.toString() + "\n";
        res+="_________\n";
        // Affichage de la liste de ses constructeurs
        res+=this.constructeurs.toString() + "\n";
        res+="_________\n";
        // Affichage de la liste de ses méthodes
        res+=this.methodes.toString() + "\n";
        res+="_________\n";
        if(this.parents!=null) {
            res += "Parents de " + this.nomClasse + "\n";
            res += this.parents.toString() + "\n";
        }
        return res;
    }

    /**
     * Methode permettant de déterminer le parent d une classe afin de pouvoir l'afficher correctement au bon endroit
     * @throws ClassNotFoundException
     */

    public void determinerParent() throws ClassNotFoundException {
        Class c = Class.forName(this.nomPackage+"."+this.nomClasse);
        Class p = c.getSuperclass();
        // si le parent existe
        if(p!=null){
            // si le parent est une interface
            if(p.isInterface()){
                this.parents = new Interface(p.getSimpleName(),p.getPackageName());
            } else {
                // si le parent est une classe abstraite
                if(p.toGenericString().contains("abstract")){
                    this.parents = new Abstract(p.getSimpleName(),p.getPackageName());
                } else {
                    // si le parent est une classe concrete
                    this.parents = new Classe(p.getSimpleName(),p.getPackageName());
                }
            }
        }
        // si c possède une ou plusieurs interfaces
        if(c.getInterfaces()!=null){
            for(Class i: c.getInterfaces()){
                this.interfaces.add(new Interface(i.getSimpleName(),i.getPackageName()));
            }
        }
    }

    /**
     * Methode permettant de creer une classe a afficher
     * @param cheminClasse chemin vers le fichier de cette classe
     * @return classe a afficher
     */

    public static Classe creerClasse(String cheminClasse) {
        Classe res=null;

        try {
            Class classe=null;
            if(!cheminClasse.contains("\\"))
                classe = Class.forName(cheminClasse);
            else{

                //fonctionnalite permettant de lire une classe externe au projet

                String className= Path.of(cheminClasse).getFileName().toString().replace(".java", "");

                BufferedReader bufferedReader=new BufferedReader(new FileReader(cheminClasse));
                BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("src/java/ClassesChargees/"+className+".java"));
                bufferedWriter.write("package ClassesChargees;\n");
                String line="";
                // tant que le fichier lu n'est pas vide
                while((line=bufferedReader.readLine())!=null){
                    // on récupère le package, s'il existe
                    if(!line.contains("package"))
                        bufferedWriter.write(line+"\n");
                }
                bufferedWriter.flush();
                bufferedWriter.close();
                classe=Class.forName("ClassesChargees."+className);

                /*
                URL classUrl=new File(cheminClasse).toURI().toURL();
                ClassLoader classLoader=new URLClassLoader(new URL[]{classUrl});
                classe=classLoader.loadClass("test.Classe1");
                 */
            }

            System.out.println();
            Field[] attributs = classe.getDeclaredFields();
            Constructor[] constructeurs = classe.getDeclaredConstructors();
            Method[] methodes = classe.getDeclaredMethods();
            String parametres;

            // si il s'agit d'une interface
            if (classe.isInterface())
                res = new Interface(classe.getSimpleName(),classe.getPackageName());
            else
                // si il s'agit d'une classe abstraite
                if (classe.toGenericString().contains("abstract"))
                    res = new Abstract(classe.getSimpleName(),classe.getPackageName());
                 else {
                     // sinon si il s'agit d'une classe concrète
                    res = new Classe(classe.getSimpleName(),classe.getPackageName());
                }

                 // On récupère le nom de la classe
                res.nomClasse = classe.getName();
                while (res.nomClasse.contains("."))
                    res.nomClasse = res.nomClasse.substring(res.nomClasse.indexOf(".")).substring(1);

                // On récupère le package de la classe
                res.nomPackage = classe.getPackageName();

                // On récupère les attributs de la classe
                String attribut = "";
                for (Field field : attributs) {
                    attribut = Modifier.toString(field.getModifiers()) + " " + field.getName() + ":" + field.getType();
                    while (attribut.contains("."))
                        attribut = Modifier.toString(field.getModifiers()) + " " + field.getName() + ":" + attribut.substring(attribut.indexOf(".")).substring(1);
                    res.attributs.add(attribut);
                }

                String constructeur = "";
                for (Constructor constructor : constructeurs) {
                    String nomConstructeur = constructor.getName() + "(";
                    while (nomConstructeur.contains("."))
                        nomConstructeur = nomConstructeur.substring(nomConstructeur.indexOf(".")).substring(1);
                    constructeur = Modifier.toString(constructor.getModifiers()) + " " + nomConstructeur;
                    if (constructor.getParameterCount() > 0) {
                        parametres = constructor.getParameters()[0].getType().getName();
                        while (parametres.contains("."))
                            parametres = parametres.substring(parametres.indexOf(".")).substring(1);
                        constructeur += parametres;
                        for (int i = 1; i < constructor.getParameterCount(); i++) {
                            parametres = "," + constructor.getParameters()[i].getType().getName();
                            while (parametres.contains("."))
                                parametres = "," + parametres.substring(parametres.indexOf(".")).substring(1);
                            constructeur += parametres;
                        }
                    }
                    res.constructeurs.add(constructeur + ")");
                }

                // On récupère les méthodes et les paramètres
                String methode;
                for (Method method : methodes) {
                    String nomMethode = method.getName() + "(";
                    while (nomMethode.contains("."))
                        nomMethode = nomMethode.substring(nomMethode.indexOf(".")).substring(1);
                    methode = Modifier.toString(method.getModifiers()) + " " + nomMethode;
                    if (method.getParameterCount() > 0) {
                        parametres = method.getParameters()[0].getType().getName();
                        while (parametres.contains("."))
                            parametres = parametres.substring(parametres.indexOf(".")).substring(1);
                        methode += parametres;
                        for (int i = 1; i < method.getParameterCount(); i++) {
                            parametres = "," + method.getParameters()[i].getType().getName();
                            while (parametres.contains("."))
                                parametres = "," + parametres.substring(parametres.indexOf(".")).substring(1);
                            methode += parametres;
                        }
                    }
                    String returnType = method.getReturnType().getName();
                    while (returnType.contains(".")) {
                        returnType = returnType.substring(returnType.indexOf('.')).substring(1);
                    }
                    res.methodes.add(methode + "):" + returnType);
                }

                // On récupère les parents de la classe
                Class p = classe.getSuperclass();
                if (p != null) {
                    if (p.toGenericString().contains("abstract")) {
                        res.parents = new Abstract(p.getSimpleName(),p.getPackageName());
                    } else {
                        res.parents = new Classe(p.getSimpleName(), p.getPackageName());
                    }
                }

                // On récupère l'interface de la classe si elle existe
                if (classe.getInterfaces() != null) {
                    for (Class i : classe.getInterfaces()) {
                        res.interfaces.add(new Interface(i.getSimpleName(),i.getPackageName()));
                    }
                }

            }
        // si on ne trouve pas la classe
        catch (ClassNotFoundException classNotFoundException){
            System.out.println("Classe introuvable");
        }
        // si on ne trouve pas le fichier
        catch (IOException ioException){
            System.out.println("Fichier introuvable");
        }
        /*
        catch (URISyntaxException uriSyntaxException){

        }

         */

        // on trie les attributs, méthodes et constructeurs
        res.attributs.sort(Comparator.naturalOrder());
        res.constructeurs.sort(Comparator.naturalOrder());
        res.methodes.sort(Comparator.naturalOrder());

        return res;
    }
}
