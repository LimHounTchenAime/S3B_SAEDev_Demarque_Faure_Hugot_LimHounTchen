package Modele;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PreviewApparence extends Pane {

    Rectangle font;

    double posX,posY;
    
    double saveX,saveY;

    Boolean voir;

    public PreviewApparence(){
        this.voir=false;
        this.font=new Rectangle(10,10,0,0);
        this.font.setFill(Color.rgb(100,100,100,0.2));
        this.getChildren().addAll(font);
        this.setVisible(voir);
    }

    public void suivre(){
        this.setLayoutX((posX-10)-this.saveX);
        this.setLayoutY((posY-10)-this.saveY);
    }

    public void changerSave(double X,double Y){
        this.saveX=X;
        this.saveY=Y;
    }
    
    public void updatePos(double x,double y){
        this.posX=x;
        this.posY=y;
    }

    public void activerSuivi(int X,int Y,boolean v){
        this.voir=v;
        if(this.voir==false){
            this.font.setHeight(0);
            this.font.setWidth(0);
        }else{
            this.font.setHeight(Y);
            this.font.setWidth(X);
        }
        this.setVisible(this.voir);
    }
}
