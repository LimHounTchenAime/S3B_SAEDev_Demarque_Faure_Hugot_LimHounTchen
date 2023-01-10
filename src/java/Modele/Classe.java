package Modele;

import java.lang.reflect.*;
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
        this.attributs=new ArrayList<>();
        this.constructeurs=new ArrayList<>();
        this.methodes=new ArrayList<>();
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

    /**
     * TODO
     * Constructeur ayant pour but de tester la méthode toString dans un programme
     * principal.
     * A remplacer par le constructeur utilisant un nom de fichier ayant les
     * informations sur une classe
     */

    //public Classe(String nomFichier);

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
        String res="<<Java "+this.typeClasse+">>\n";
        res+=this.nomClasse + "\n";
        res+=this.nomPackage + "\n";
        res+="________________\n";
        res+=this.attributs.toString() + "\n";
        res+="________________\n";
        res+=this.constructeurs.toString() + "\n";
        res+="________________\n";
        res+=this.methodes.toString() + "\n";
        res+="_________\n";
        res+="Parents de " + this.nomClasse + "\n";
        res+=this.parents.toString() + "\n";
        return res;
    }

    /**
     * Methode permettant de déterminer le parent d une classe afin de pouvoir l'afficher correctement au bon endroit
     * @throws ClassNotFoundException
     */

    public void determinerParent() throws ClassNotFoundException {
        Class c = Class.forName(this.nomPackage+"."+this.nomClasse);
        Class p = c.getSuperclass();
        if(p!=null){
            if(p.isInterface()){
                this.parents = new Interface(p.getSimpleName(),p.getPackageName());
            } else {
                if(p.toGenericString().contains("abstract")){
                    this.parents = new Abstract(p.getSimpleName(),p.getPackageName());
                } else {
                    this.parents = new Classe(p.getSimpleName(),p.getPackageName());
                }
            }
        }

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
                while((line=bufferedReader.readLine())!=null){
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

            if (classe.isInterface())
                res = new Interface(classe.getSimpleName(),classe.getPackageName());
            else
                if (classe.toGenericString().contains("abstract"))
                    res = new Abstract(classe.getSimpleName(),classe.getPackageName());
                 else {
                    res = new Classe(classe.getSimpleName(),classe.getPackageName());
                }

                res.nomClasse = classe.getName();
                while (res.nomClasse.contains("."))
                    res.nomClasse = res.nomClasse.substring(res.nomClasse.indexOf(".")).substring(1);

                res.nomPackage = classe.getPackageName();

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

                Class p = classe.getSuperclass();
                if (p != null) {
                    if (p.isInterface()) {
                        res.parents = new Interface(p.getSimpleName(),p.getPackageName());
                    } else {
                        if (p.toGenericString().contains("abstract")) {
                            res.parents = new Abstract(p.getSimpleName(),p.getPackageName());
                        } else {
                            res.parents = new Classe(p.getSimpleName(), p.getPackageName());
                        }
                    }
                }

                if (classe.getInterfaces() != null) {
                    for (Class i : classe.getInterfaces()) {
                        res.interfaces.add(new Interface(classe.getSimpleName(),classe.getPackageName()));

                    }
                }

            }
        catch (ClassNotFoundException classNotFoundException){
            System.out.println("Classe introuvable");
        }
        catch (IOException ioException){
            System.out.println("Fichier introuvable");
        }
        /*
        catch (URISyntaxException uriSyntaxException){

        }

         */

        res.attributs.sort(Comparator.naturalOrder());
        res.constructeurs.sort(Comparator.naturalOrder());
        res.methodes.sort(Comparator.naturalOrder());

        return res;
    }
}
