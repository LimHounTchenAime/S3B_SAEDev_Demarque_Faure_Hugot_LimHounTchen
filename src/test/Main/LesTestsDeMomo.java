package Main;

import Modele.Classe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LesTestsDeMomo {

    @Test
    void determinerParent() throws ClassNotFoundException {
        Classe c = new Classe("Concrete", "Modele");
        c.determinerParent();
        Class c2 = Class.forName(c.getParents().getFileName());

        System.out.println(c.getParents().getNomClasse()+" - "+c2.getSimpleName());
        System.out.println(c.getParents().getNomPackage()+" - "+c2.getPackageName());
        assertEquals(c.getParents().getNomClasse(), c2.getSimpleName());
        assertEquals(c.getParents().getNomPackage(), c2.getPackageName());

    }
}