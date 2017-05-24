/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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
public class MusicPlayerController extends BaseController implements Initializable
{
    private int min, sec;
    Timer t;
    TimerTask tt;
    
    @FXML
    MediaView mediaView;
    
    @FXML
    Slider volume;
    
    @FXML
    MediaPlayer mediaPlayer;
    
    @FXML 
    Label timeLabel; 
    
    @FXML
    Label nowPlaying;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        musicScene = stage.getScene();
    }

    @Override
    public void openAction(ActionEvent event)
    {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter ef = new FileChooser.ExtensionFilter("Audio Files", "*.mp3", "*.mp4");
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
                setLabel();
                volume.setValue(mediaPlayer.getVolume());
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
    public void handlePlay(ActionEvent event)
    {
        if(mediaPlayer != null)
        {
            mediaPlayer.play();   
        }
    }
    
    @FXML
    public void handlePause(ActionEvent event){
        if(mediaPlayer != null){
            mediaPlayer.pause();
            
        }
    }
    
    @FXML
    public void handleStop(ActionEvent event){
        if(mediaPlayer != null){
            mediaPlayer.stop();
            
            min = 0;
            sec = 0;
        }
    }
    
    public void setLabel()
    {
        if(mediaPlayer != null)
        {
            int d = mediaPlayer.getMedia().getSource().lastIndexOf("/");
            nowPlaying.setText(mediaPlayer.getMedia().getSource().substring(d+1));
            
            t = new Timer();
            
            tt = new TimerTask() {
                
                @Override
                public void run() {
                    sec = (int)mediaPlayer.getCurrentTime().toSeconds()%60;
                    min = (int)mediaPlayer.getCurrentTime().toMinutes();
                    
                    Platform.runLater(() -> {
                        if(sec < 10)
                        {
                            timeLabel.setText(min + ":" + "0" + sec);
                        }
                        timeLabel.setText(min + ":" + sec);
                    });
                }
            };
            
            t.scheduleAtFixedRate(tt, 1000, 1000);
        }
    }
}
