/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsceneswitch;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.image.Image;

/**
 *
 * @author j_cas
 */
public class Login extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        System.out.println("THIS IS A TEST FOR GIT 1");
        
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Inicio de sesión");
        stage.setResizable(false);
        Image icon = new Image(getClass().getResourceAsStream("/testsceneswitch/Icons/login.png"));
        stage.getIcons().add(icon);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
        public void handle(WindowEvent we) {
             stage.close();
     
          }
      });    
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
