package Modele;

import java.lang.reflect.*;
import java.util.ArrayList;

public class Concrete extends Classe{
    public Concrete() {
        this.typeClasse="Classe";
        this.nomClasse="Test";
        this.attributs=new ArrayList<String>();
        this.constructeurs=new ArrayList<String>();
        this.methodes=new ArrayList<String>();
    }

    public static Concrete analyserClasse(String cheminClasse){

            Concrete res=new Concrete();

            try {
                Class classe = Class.forName(cheminClasse);
                Field[] attributs = classe.getDeclaredFields();
                Constructor[] constructeurs = classe.getDeclaredConstructors();
                Method[] methodes = classe.getDeclaredMethods();
                String parametres="";

                res.nomClasse = classe.getName();
                while (res.nomClasse.contains("."))
                    res.nomClasse = res.nomClasse.substring(res.nomClasse.indexOf('.', 1)).substring(1);


                for (Field field : attributs) {
                    String type = field.getType().getName();
                    while(type.contains("."))
                        type=type.substring(type.indexOf('.')).substring(1);
                    res.attributs.add(Modifier.toString(field.getModifiers()) + " " + field.getName() + ":" + type);
                }
                for (Constructor constructor : constructeurs) {
                            String modifier=Modifier.toString(constructor.getModifiers());
                            String constructeur=constructor.getName() + "(";
                            while(constructeur.contains("."))
                                constructeur=constructeur.substring(constructeur.indexOf(".")).substring(1);
                            if(constructor.getParameters().length>0) {
                                parametres = constructor.getParameterTypes()[0].getTypeName();
                                while (parametres.contains("."))
                                    parametres = parametres.substring(parametres.indexOf(".")).substring(1);
                                constructeur += parametres;
                                for (int i = 1; i < constructor.getParameterTypes().length; i++) {
                                    parametres = "," + constructor.getParameterTypes()[i].getTypeName();
                                    while (parametres.contains("."))
                                        parametres = "," + parametres.substring(parametres.indexOf(".")).substring(1);
                                    constructeur += parametres;
                                }
                            }

                            constructeur+=")";
                            res.constructeurs.add(modifier+" "+constructeur);
                        }
                parametres="";
                for (Method method : methodes) {
                    String modifier=Modifier.toString(method.getModifiers());
                    String methode=method.getName()+"(";
                    while(methode.contains("."))
                        methode=methode.substring(methode.indexOf(".")).substring(1);
                    if(method.getParameters().length>0) {
                        parametres = method.getParameterTypes()[0].getTypeName();
                        while (parametres.contains("."))
                            parametres = parametres.substring(parametres.indexOf(".")).substring(1);
                        methode+=parametres;
                        for (int i = 1; i < method.getParameterTypes().length; i++) {
                            parametres = "," + method.getParameterTypes()[i].getTypeName();
                            while (parametres.contains("."))
                                parametres = ","+parametres.substring(parametres.indexOf(".")).substring(1);
                            methode+=parametres;
                        }
                    }

                    String returnType=method.getReturnType().getName();
                    while(returnType.contains("."))
                        returnType=returnType.substring(returnType.indexOf('.')).substring(1);
                    methode+="):"+returnType;
                    res.methodes.add(modifier+" "+methode);
                }
                res.nomPackage = classe.getPackageName();
            }
            catch (ClassNotFoundException classNotFoundException){
                System.out.println("Classe non trouvée");
            }
        return res;
    }
}
