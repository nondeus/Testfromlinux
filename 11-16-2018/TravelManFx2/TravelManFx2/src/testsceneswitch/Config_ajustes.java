/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testsceneswitch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josimar
 */
public class Config_ajustes {
     java.util.Properties props = new java.util.Properties();
      OutputStream output = null;
       InputStream input = null;
       
       
       
       
       
       
       public boolean CreatePropertiesFolder(){
              boolean estate=true;
              File file = new File(System.getProperty("user.home")+"\\TravelMan");
       
           if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Failed to create directory!");
                estate=false;
            }
        }
           return estate;
       }
         public void storeproperties(){
            if(CreatePropertiesFolder()==true){
                try {
             output = new FileOutputStream(System.getProperty("user.home")+"\\TravelMan"+"\\config.properties");
             props.store(output,null);
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Config_ajustes.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Config_ajustes.class.getName()).log(Level.SEVERE, null, ex);
         }
            }
         }
       
       
         public void setPropertiesValues(String name,String value){
        props.setProperty(name, value);
    }
         
         public String GetPropertie(String Name){
        System.out.println("Propierdad "+props.getProperty(Name));
        
        return props.getProperty(Name);
    }
         
         
         
        public void LoadProperties(){
         try {
             props.clear();
             input = new FileInputStream(System.getProperty("user.home")+"\\TravelMan"+"\\config.properties");
             props.load(input);
             
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Properties.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Properties.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
       public boolean LoadProperties_2(){
           boolean resultado=false;
         try {
             props.clear();
              File f = new File(System.getProperty("user.home")+"\\TravelMan"+"\\config.properties");
              if(f.exists()==true){
                  input = new FileInputStream(System.getProperty("user.home")+"\\TravelMan"+"\\config.properties");
                  props.load(input);
                  resultado=true;
              }
             
             
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Properties.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Properties.class.getName()).log(Level.SEVERE, null, ex);
         }
            return resultado;
    }
}
