/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Parker
 */
public class AboutController extends BaseController implements Initializable {

    @FXML
    WebView wv;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        wv.getEngine().loadContent(openAbout());
    }    

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        aboutScene = stage.getScene();
    }

    @Override
    public void openAction(ActionEvent event) {
        
    }

    @Override
    public void saveAction(ActionEvent event) {
        
    }
    
    public String openAbout(){
        File file = new File("C:\\Users\\Parker\\Documents\\NetBeansProjects\\Pwjb78FinalProject\\src\\Main\\about.txt");
        String bodyText = "";
        try
        {
            if(file != null)
            {
                BufferedReader reader = null;
                bodyText = "";
                String line = "";
                
                try
                {
                    reader = new BufferedReader(new FileReader(file));
                    
                    while((line = reader.readLine()) != null)
                    {
                        bodyText += line + "\n";
                    }
                }
                catch(FileNotFoundException ex){
                    System.out.println("file not found");
                }
                catch(IOException ex){
                    System.out.println("IO exception");
                }
                finally
                {
                    if(reader != null)
                    {
                        try{
                            reader.close();
                        }
                        catch(IOException ex)
                        {
                            System.out.println("io exception");
                        }
                    }
                }   
            }  
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return bodyText;
    }
    
}
