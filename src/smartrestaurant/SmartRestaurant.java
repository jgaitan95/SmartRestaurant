/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartrestaurant;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Scanner;

/*


*/
public class SmartRestaurant extends Application {
    ArrayList<Dish> items = new ArrayList<>();
    
    String name, description, picture, price;
    static int count = 0;
    static ArrayList<Scene> scene = new ArrayList<>();
    static ArrayList<GridPane> gpane = new ArrayList<>();
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try{
            Scanner sc = new Scanner(getClass().getResourceAsStream("/resources/config.txt"));

            while(sc.hasNextLine()){
                name = sc.nextLine().substring(6);
                System.out.println(name);
                description = sc.nextLine().substring(13);
                System.out.println(description);
                picture = sc.nextLine().substring(9);
                System.out.println(picture);
                price = sc.nextLine().substring(7);
                System.out.println(price);

                Dish newDish = new Dish(name, description,picture,price);
                items.add(newDish);

            }

            //Fill GridPanes

            for(int i = 0; i < items.size(); i++){
                GridPane grdp = new GridPane();
                Dish dish = new Dish();
                dish = items.get(i);
                
                
                
                
                //Description Text
                Label dishDSC = new Label("Description: " + dish.getDescription());
                dishDSC.setWrapText(true);
                grdp.add(dishDSC, 1, 4);
                
                
                //NAME Text
                Text dishNAME = new Text(0, 0, dish.getName());
                grdp.add(dishNAME, 0, 0);
                dishNAME.setFont(Font.font("Calibri", FontWeight.BOLD,
                FontPosture.ITALIC, 50));
                dishNAME.setFill(Color.GOLD);
                dishNAME.setStroke(Color.DARKRED);
                dishNAME.setStrokeWidth(1);
                dishNAME.setUnderline(false);
                

                
                
                //PRICE Text
                Text dishPRICE = new Text("Price: " + dish.getPrice());
                grdp.add(dishPRICE, 1, 5);
                dishPRICE.setFont(Font.font("Calibri", FontWeight.BOLD,
                FontPosture.ITALIC, 50));
                dishPRICE.setFill(Color.GOLD);
                dishPRICE.setStroke(Color.DARKRED);
                dishPRICE.setStrokeWidth(1);
                dishPRICE.setUnderline(false);
                
                
                //Import Picture
                ImageView picView = new ImageView();
                Image pic = new Image(dish.getPicture());
                System.out.println("Pic is Displayed");
                picView.setImage(pic);
                picView.setFitHeight(300);
                picView.setFitWidth(400);
                grdp.add(picView, 0, 4);
                
                
                //Buttons
                Button nextbtn = new Button("Next Item ==>>");
                grdp.add(nextbtn, 1, 6);
                Button prevbtn = new Button("<<==Previous Item");
                grdp.add(prevbtn, 0, 6);
                
                /*nextbtn.setLayoutX(20);
                nextbtn.setLayoutY(500);
                prevbtn.setLayoutX(375);
                prevbtn.setLayoutY(500);
                //dish.Dish().addAll(nextbtn, prevbtn);
                */

                
                //Button Handles
                nextbtn.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent e){
                        if(count != items.size() - 1){

                            count++;

                            
                            primaryStage.setScene(scene.get(count));
                            primaryStage.show();   
                        } else {
                            count = 0;
                            
                            
                            

                            primaryStage.setScene(scene.get(count));
                            primaryStage.show();
                        }
                    }
                });
                prevbtn.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent e){
                        if(count != 0){

                            count--;

                            
                            primaryStage.setScene(scene.get(count));
                            primaryStage.show();   
                        } else {
                            count = items.size() - 1;
                            
                            
                            

                            primaryStage.setScene(scene.get(count));
                            primaryStage.show();
                        }
                        
                    }
                });
                gpane.add(grdp);
                scene.add(new Scene(gpane.get(i), 673, 500));       
            }
            
            primaryStage.setTitle("Smart Restaurant Menu");
            
            primaryStage.setScene(scene.get(0));
            primaryStage.show();
        }   catch(Exception ex) {
                System.out.println("Exception: " + ex + " caught");
        }
    }
    
    
    
    
}
/*
            //Scene 1
            Button btn1 = new Button();
            btn1.setText("Previous");
            btn1.setOnAction(e ->primaryStage.setScene(scene4));

            Button btn2 = new Button();
            btn2.setText("Next");
            btn2.setOnAction(e -> primaryStage.setScene(scene2));

            //Scene 2
            Button btn3 = new Button();
            btn3.setText("Previous");
            btn3.setOnAction(e -> primaryStage.setScene(scene1));

            Button btn4 = new Button();
            btn4.setText("Next");
            btn4.setOnAction(e -> primaryStage.setScene(scene3));

            //Scene 3
            Button btn5 = new Button();
            btn5.setText("Previous");
            btn5.setOnAction(e -> primaryStage.setScene(scene2));

            Button btn6 = new Button();
            btn6.setText("Next");
            btn6.setOnAction(e -> primaryStage.setScene(scene4));

            //Scene 4
            Button btn7 = new Button();
            btn7.setText("Previous");
            btn7.setOnAction(e -> primaryStage.setScene(scene3));

            Button btn8 = new Button();
            btn8.setText("Next");
            btn8.setOnAction(e -> primaryStage.setScene(scene1));

                    /*new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Next");
            }
            });*/

                    /*new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println("Previous");
            }

            });*/

/*
            Group root1 = new Group();
            btn1.setLayoutX(20);
            btn1.setLayoutY(500);
            btn2.setLayoutX(675);
            btn2.setLayoutY(500);
            root1.getChildren().addAll(btn1, btn2);
            scene1 = new Scene(root1, 750, 550);    


            Group root2 = new Group();
            btn3.setLayoutX(20);
            btn3.setLayoutY(500);
            btn4.setLayoutX(675);
            btn4.setLayoutY(500);
            root2.getChildren().addAll(btn3, btn4);
            scene2 = new Scene(root2, 750, 550);


            Group root3 = new Group();
            btn5.setLayoutX(20);
            btn5.setLayoutY(500);
            btn6.setLayoutX(675);
            btn6.setLayoutY(500);
            root3.getChildren().addAll(btn5, btn6);
            scene3 = new Scene(root3, 750, 550);  


            Group root4 = new Group();
            btn7.setLayoutX(20);
            btn7.setLayoutY(500);
            btn8.setLayoutX(675);
            btn8.setLayoutY(500);
            root4.getChildren().addAll(btn7, btn8);
            scene4 = new Scene(root4, 750, 550);  



            GridPane gridgpane = new GridPane();
            gridgpane.setPadding(new Insets(5));
            gridgpane.setHgap(10);
            gridgpane.setVgap(10);

            int i = 0;

        /*        final ImageView imv1 = new ImageView();
                final Image image1 = new Image(SmartRestaurant.class.getResourceAsStream("/smartrestaurant/2-mac-cheese.jpg"));
                imv1.setImage(image1);
                imv1.setFitHeight(300);
                imv1.setFitWidth(400);

                final ImageView imv2 = new ImageView();
                final Image image2 = new Image(SmartRestaurant.class.getResourceAsStream("/smartrestaurant/wings.jpg"));
                imv2.setImage(image2);
                imv2.setFitHeight(300);
                imv2.setFitWidth(400);

                final ImageView imv3 = new ImageView();
                final Image image3 = new Image(SmartRestaurant.class.getResourceAsStream("/smartrestaurant/fries_20and_20burger_1_.jpg"));
                imv3.setImage(image3);
                imv3.setFitHeight(300);
                imv3.setFitWidth(400);

                final ImageView imv4 = new ImageView();
                final Image image4 = new Image(SmartRestaurant.class.getResourceAsStream("/smartrestaurant/tacos.jpg"));
                imv4.setImage(image4);
                imv4.setFitHeight(300);
                imv4.setFitWidth(400);
        */
/*
                final HBox pictureRegion = new HBox();

                pictureRegion.getChildren().add(imv1);
                gridgpane.add(pictureRegion, 1, 10);


        /*        String[] arrTitle = new String []{
                new String("Mac n' Cheese"),
                new String("Buffalo Wings"),
                new String("Burger and Fries"),
                new String("Mexican Tacos")
                };
        */



         /*       String[] arrDesc = new String []{
                new String("Home-\nmade delicious mac n'\ncheese"),
                new String("Buffalo\nWings w/your style of\nsauce(s)"),
                new String("Burger\ncooked to perfection\nw/cajun fries"),
                new String("3 Tacos\nw/your choice of meat\ninside")
                };    

                String[] arrPrice = new String []{
                new String("6.99"),
                new String("7.99"),
                new String("8.99"),
                new String("9.99")
                };
        */

/*
                Text desc = new Text(425, 130, "Description: " + arrDesc[i]);
                root1.getChildren().add(desc);

                desc.setFont(Font.font("Calibri", FontWeight.BOLD,
                FontPosture.ITALIC, 30));
                desc.setFill(Color.GOLD);
                desc.setStroke(Color.DARKBLUE);
                desc.setStrokeWidth(1);
                desc.setUnderline(false);

                Text text = new Text(15, 75, arrTitle[i]);
                root1.getChildren().add(text);
                text.setFont(Font.font("Verdana", FontWeight.BOLD,
                FontPosture.ITALIC, 50));
                text.setFill(Color.GOLD);
                text.setStroke(Color.DARKBLUE);
                text.setStrokeWidth(1);
                text.setUnderline(false);

                Text price = new Text(425, 400, "Price: " + arrPrice[i]);
                root1.getChildren().add(price);

                price.setFont(Font.font("Calibri", FontWeight.BOLD,
                FontPosture.ITALIC, 30));
                price.setFill(Color.GOLD);
                price.setStroke(Color.DARKBLUE);
                price.setStrokeWidth(1);
                price.setUnderline(false);


                root1.getChildren().add(gridgpane);        
                primaryStage.setScene(scene1);
                primaryStage.show();


        }
        }

*/