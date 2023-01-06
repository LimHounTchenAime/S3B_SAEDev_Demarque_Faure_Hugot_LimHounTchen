package Modele;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Classe {

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
        return res;
    }

    public void determinerParent() throws ClassNotFoundException {
        Class c = Class.forName(this.fileName);
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

    public static Classe creerClasse(String cheminClasse) {
        Classe res=null;

        try {


            Class classe = Class.forName(cheminClasse);
            Field[] attributs = classe.getDeclaredFields();
            Constructor[] constructeurs = classe.getDeclaredConstructors();
            Method[] methodes = classe.getDeclaredMethods();
            String parametres;

            if (classe.isInterface())
                res = new Interface("", "");
            else
                if (classe.toGenericString().contains("abstract"))
                    res = new Abstract("", "");
                 else {
                    res = new Concrete("", "");
                }

                res.nomClasse = classe.getName();
                if (res.nomClasse.contains("."))
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
                        res.interfaces.add(new Interface("", ""));
                    }
                }

            }
        catch (ClassNotFoundException classNotFoundException){
            System.out.println("Classe introuvable");
        }

        res.attributs.sort(Comparator.naturalOrder());
        res.constructeurs.sort(Comparator.naturalOrder());
        res.methodes.sort(Comparator.naturalOrder());

        return res;
    }
}
