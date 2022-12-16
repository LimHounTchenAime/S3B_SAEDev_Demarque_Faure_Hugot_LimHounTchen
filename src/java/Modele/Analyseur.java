package Modele;

import java.lang.reflect.*;

public class Analyseur {
    public static void analyserClasse(String nomClasse){
        try {
            Class classe = Class.forName(nomClasse);
            Field[] attributs = classe.getDeclaredFields();
            Constructor[] constructeurs = classe.getDeclaredConstructors();
            Method[] methodes = classe.getDeclaredMethods();
            Parameter[] parametres;

            System.out.println("class " + classe.getName() + "\n");
            for (Field field : attributs) {
                System.out.println(Modifier.toString(field.getModifiers()) + " " + field.getType() + " " + field.getName());
            }
            System.out.println();
            for (Constructor constructor : constructeurs) {
                System.out.print(Modifier.toString(constructor.getModifiers()) + " " + constructor.getName() + " (");
                parametres = constructor.getParameters();
                if (parametres != null)
                    System.out.print(parametres[0].getType() + " " + parametres[0].getName());
                for (int i = 1; i < parametres.length; i++) {
                    System.out.print(", " + parametres[i].getType() + " " + parametres[i].getName());
                }
                System.out.print(")");
            }
            System.out.println();
            for (Method method : methodes) {
                System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getName() + " ");
                parametres = method.getParameters();
                if (parametres != null)
                    System.out.print(parametres[0].getType() + " " + parametres[0].getName());
                for (int i = 1; i < parametres.length; i++) {
                    System.out.print(", " + parametres[i].getType() + " " + parametres[i].getName());
                }
                System.out.print(")");
            }
        }
        catch (ClassNotFoundException classNotFoundException){
            System.out.println("class not found");
        }
    }
}
