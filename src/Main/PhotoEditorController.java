/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Parker
 */
public class PhotoEditorController extends BaseController implements Initializable {
    
    final DoubleProperty zoomAmount = new SimpleDoubleProperty(200);
    
    @FXML
    Canvas canvas;
    
    @FXML
    ImageView iv;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        photoScene = stage.getScene();
    }
    
    @FXML
    @Override
    public void openAction(ActionEvent event) {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter ef = new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.jpeg", ".png", "*.gif");
        fc.getExtensionFilters().add(ef);
        File file;
        
        try
        {
            file = fc.showOpenDialog(Pwjb78Main.getStage());
            
            if(file != null)
            { 
                Image img = new Image(file.toURI().toString());
                iv.setImage(img);
                
                file = null;
            }  
            
        }
        catch(Exception ex)
        {
            System.out.println("issue opening media");
        }
    }

    @FXML
    @Override
    public void saveAction(ActionEvent event) {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter ef = new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.jpeg", ".png", "*.gif");
        fc.getExtensionFilters().add(ef);
        File file;
        
        try {
            file = fc.showSaveDialog(Pwjb78Main.getStage());
            ImageIO.write(SwingFXUtils.fromFXImage(iv.getImage(), null), ".png", file);
        }
        catch(IOException ex)
        {
            System.out.println("saving image issue");
        }
    }
}
