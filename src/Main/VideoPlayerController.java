/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Parker
 */
public class VideoPlayerController extends BaseController implements Initializable {

    private MediaPlayer mediaPlayer;
    Dimension base = new Dimension(800,800);
    
    @FXML
    private Button playPause;
    @FXML
    private Button stop;
    @FXML
    private MediaView mediaView;
    private boolean fullScreen = false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        videoScene = stage.getScene();
    }

    @Override
    public void openAction(ActionEvent event) {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter ef = new FileChooser.ExtensionFilter("Video Files", "*.avi", "*.flv", "*.mp4");
        fc.getExtensionFilters().add(ef);
        File file;
        
        try
        {
            file = fc.showOpenDialog(Pwjb78Main.getStage());
            
            if(file != null)
            { 
                Media media = new Media(file.toURI().toString());
                
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setAutoPlay(true);
                mediaView.setMediaPlayer(mediaPlayer);
                file = null;
            }  
            
        }
        catch(Exception ex)
        {
            System.out.println("issue opening media");
        }
    }

    @Override
    public void saveAction(ActionEvent event) {
        
    }
    
    @FXML
    public void handlePlayPause(ActionEvent event)
    {
        if(mediaPlayer != null)
        {
            if(playPause.getText().equals("►"))
            {
                mediaPlayer.pause();
                playPause.setText("||");
            }
            else if(playPause.getText().equals("||"))
            {
                mediaPlayer.play();
                playPause.setText("►");
            }
        }
    }
    
    @FXML
    public void handleStop(ActionEvent event){
        if(mediaPlayer != null){
            mediaPlayer.stop();
        }
    }
    
    @FXML
    public void handleFullScreen(ActionEvent event){
        if(mediaPlayer != null && fullScreen == false){
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            mediaView.setFitHeight(screen.getHeight());
            mediaView.setFitWidth(screen.getWidth());
            fullScreen = true;
        }
    }
    
    @FXML
    public void endFullScreen(KeyEvent event){
        System.out.println("deeeee");
        if(event.getCode().equals(event.getCode().ESCAPE) && fullScreen == true)
        {
            
            mediaView.setFitHeight(base.getHeight());
            mediaView.setFitWidth(base.getWidth());
            fullScreen = false;
        }
    }
    
}
