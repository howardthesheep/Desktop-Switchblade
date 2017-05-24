package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Parker
 */
public abstract class BaseController implements Initializable {
   protected static DocumentEditorController editor;
    protected static CalculatorController calculator;
    protected static MusicPlayerController music;
    protected static PhotoEditorController photo;
    protected static BrowserController browser;
    protected static AboutController about;
    protected static VideoPlayerController video;
    protected static Scene calcScene, editorScene, musicScene, photoScene, browserScene, aboutScene, videoScene;
    protected Stage stage;
    
    public abstract void start(Stage stage);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public abstract void openAction(ActionEvent event);

    @FXML
    public abstract void saveAction(ActionEvent event);
    
    @FXML
    public void editorSwitch(ActionEvent event){
        try {
            if(editorScene == null){
                Parent editorRoot;
                System.out.println("editorScene is null"); 
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocumentEditor.fxml"));
                editorRoot = loader.load(); 
                editor = loader.getController(); 
                editorScene = new Scene(editorRoot);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        
        stage.setScene(editorScene);
        editor.start(stage);
    }
    
    @FXML
    public void musicSwitch(ActionEvent event){
        try {
            if(musicScene == null)
            {
                Parent musicRoot;
                System.out.println("musicScene is null");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMusicPlayer.fxml"));
            
                musicRoot = loader.load();
                music = loader.getController();
                musicScene = new Scene(musicRoot);
            }
        }
        catch(IOException ex){
            System.out.println("Couldn't load FXML");
        }
        stage.setScene(musicScene);
        music.start(stage);
    }
    
    @FXML
    public void photoSwitch(ActionEvent event){
        try {
            if(photoScene == null)
            {
                Parent photoRoot;
                System.out.println("photoscene is null");
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLPhotoEditor.fxml"));
                photoRoot = loader.load();
                photo = loader.getController();
                photoScene = new Scene(photoRoot);
            }
        }
        catch(IOException ex){
                ex.printStackTrace();
        }
        
        stage.setScene(photoScene);
        photo.start(stage);
    }
    
    @FXML
    public void calcSwitch(ActionEvent event){
        try {
            if(calcScene == null){
                Parent calcRoot;
                System.out.println("calcScene is null"); 
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLCalculator.fxml"));
                calcRoot = loader.load(); 
                calculator = loader.getController(); 
                calcScene = new Scene(calcRoot);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        
        stage.setScene(calcScene);
        calculator.start(stage);
    }
    
    @FXML
    public void videoSwitch(ActionEvent event){
        try {
            if(videoScene == null)
            {
                Parent videoRoot;
                System.out.println("videoScene == null");
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLVideoPlayer.fxml"));
                videoRoot = loader.load();
                video = loader.getController();
                videoScene = new Scene(videoRoot);
            }         
        } catch(IOException ex){
            System.out.println("issue switching to videoPlayer");
        }
        stage.setScene(videoScene);
        video.start(stage);
    }
    
    @FXML 
    public void aboutSwitch(ActionEvent event){
        try {
            if(aboutScene == null)
            {
                Parent aboutRoot;
                System.out.println("aboutScene == null");
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAbout.fxml"));
                aboutRoot = loader.load();
                about = loader.getController();
                aboutScene = new Scene(aboutRoot);
            }         
        } catch(IOException ex){
            System.out.println("issue switching to about");
        }
        stage.setScene(aboutScene);
        about.start(stage);
    }
    
    @FXML
    public void browserSwitch(ActionEvent event)
    {
        try {
            if(browserScene == null)
            {
                Parent browserRoot;
                System.out.println("Browserscene is null");
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLBrowser.fxml"));
                browserRoot = loader.load();
                browser = loader.getController();
                browserScene = new Scene(browserRoot);
            }
        } catch(IOException ex){
            ex.printStackTrace();
        }
        
        stage.setScene(browserScene);
        browser.start(stage);
    }
    
     public static DocumentEditorController getEditor() {
        return editor;
    }

    public static void setEditor(DocumentEditorController d) {
        editor = d;
    }
    
    
}
