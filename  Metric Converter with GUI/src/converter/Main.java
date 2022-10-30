package converter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
   public void start(Stage stage) {

      TextField textField1 = new TextField();
      TextField textField2 = new TextField();
      TextField textField3 = new TextField();
      Button button = new Button("Submit");
      button.setTranslateX(250);
      button.setTranslateY(75);
      //labels
      Label label1 = new Label("sourceNum: ");
      Label label2 = new Label("sourceMetric: ");
      Label label3 = new Label("targetMetric: ");
      
      //Setting the message with read data
      Text text = new Text("");
      //Setting font to the label
      Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10);
      text.setFont(font);
      text.setTranslateX(15);
      text.setTranslateY(125);
      text.setFill(Color.BROWN);
      text.maxWidth(580);
      text.setWrappingWidth(580);
      //Displaying the message
      button.setOnAction(e -> {
         //Retrieving data
         float sourceNum = Float.parseFloat(textField1.getText());
         String sourceMetric = textField2.getText();
         float targetNum = 0;
         String targetMetric = textField3.getText();
         String res = Float.toString(convertHelper(sourceNum, sourceMetric, targetNum, targetMetric));
        text.setText(res);
      });
      //Adding labels for nodes
      HBox box = new HBox();
      box.setPadding(new Insets(25, 5 , 5, 50));
      box.getChildren().addAll(label1, textField1, label2, textField2, label3, textField3);
      Group root = new Group(box, button, text);
      //Setting the stage
      Scene scene = new Scene(root, 595, 150, Color.BEIGE);
      stage.setTitle("Metric Converter");
      stage.setScene(scene);
      stage.show();
   }
   private float convertHelper(float sourceNum, String sourceMetric, float targetNum, String targetMetric) {
    switch(sourceMetric){
            case "km":
            switch(targetMetric){
                case "m":
                    targetNum = sourceNum * 1000;
                    break;
                case "mile":
                    targetNum = (float) (sourceNum * 0.62);
                    break;
                default:
                    System.out.println("I don't know that, please give me something else"); 
                    break; 
            }
            break;    
            case "kg":
            switch(targetMetric){
                case "lb":
                    targetNum = (float)(sourceNum * 2.20);
                    break;
                default:
                    System.out.println("I don't know that, please give me something else"); 
                    break; 
            }
            break;
            case "liter":
            switch(targetMetric){
                case "gallon":
                    targetNum = (float)(sourceNum * 0.26);
                    break;
                default:
                    System.out.println("I don't know that, please give me something else"); 
                    break; 
            }
            break;
            case "celsius":
            switch(targetMetric){
                case "fahrenheit":
                    targetNum = (float)(sourceNum * 1.8 + 32);
                    break;
                default:
                    System.out.println("I don't know that, please give me something else"); 
                    break; 
            }
            break;
            default:
                System.out.println("I don't know that, please give me something else"); 
                break; 
        }
        return targetNum;
}
public static void main(String args[]){
      launch(args);
   }
}