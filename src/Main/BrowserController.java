/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Parker
 */
public class BrowserController extends BaseController implements Initializable {

    @FXML
    private WebView wv;
    
    @FXML
    private TextField tf;
    
    @FXML
    private ImageView google;
    @FXML
    private ImageView gmail;
    @FXML
    private ImageView reddit;
    @FXML
    private ImageView stackOverflow;
    @FXML
    private ImageView voat;
    @FXML 
    private ImageView fourchan;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        google.setImage(new Image(getClass().getResource("google.png").toString()));
        gmail.setImage(new Image(getClass().getResource("mail.png").toString()));
        reddit.setImage(new Image(getClass().getResource("reddit.png").toString()));
        stackOverflow.setImage(new Image(getClass().getResource("stackoverflow.png").toString()));
        voat.setImage(new Image(getClass().getResource("voat.png").toString()));
        fourchan.setImage(new Image(getClass().getResource("4chan.png").toString()));
    }    

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        browserScene = stage.getScene();
        wv.getEngine().load("https://www.google.com/#spf=1");
    }

    @Override
    public void openAction(ActionEvent event) {
    }

    @Override
    public void saveAction(ActionEvent event) {
    }
    
    @FXML
    public void backHandler(ActionEvent event){
        wv.getEngine().getHistory().go(-1);
    }
    
    @FXML
    public void forwardHandler(ActionEvent event){
        wv.getEngine().getHistory().go(1);
    }
    
    @FXML
    public void searchHandler(ActionEvent event){
        wv.getEngine().load(tf.getText());
    }
    
    @FXML 
    public void googleHandler(MouseEvent event){
        wv.getEngine().load("https://www.google.com");
    }
    
    @FXML 
    public void mailHandler(MouseEvent event){
        wv.getEngine().load("https://mail.google.com");
    }
    
    @FXML 
    public void soHandler(MouseEvent event){
        wv.getEngine().load("http://www.stackoverflow.com");
    }
    
    @FXML 
    public void redditHandler(MouseEvent event){
        wv.getEngine().load("https://www.reddit.com");
    }
    
    @FXML 
    public void voatHandler(MouseEvent event){
        wv.getEngine().load("https://www.voat.co");
    }
    
    @FXML 
    public void chanHandler(MouseEvent event){
        wv.getEngine().load("https://www.4chan.org");
    }
}
