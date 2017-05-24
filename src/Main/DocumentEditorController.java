package Main;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author Parker
 */
public class DocumentEditorController extends BaseController implements Initializable 
{
    private FileChooser fileChooser = new FileChooser();

    @FXML
    private TextField textField;
    
    @FXML
    private String bodyText;
    
    @FXML 
    private HTMLEditor htmlEditor;
    
    
    @FXML
    @Override
    public void openAction(ActionEvent event)
    {
        
        File file;
        
        try
        {
            file = fileChooser.showOpenDialog(Pwjb78Main.getStage());
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
                    htmlEditor.setHtmlText(bodyText);
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
    }
    
    @FXML
    @Override 
    public void saveAction(ActionEvent event)
    {
        File file;
        FileWriter writer = null;
        FileChooser.ExtensionFilter ef = new FileChooser.ExtensionFilter("Text files", "*.txt");
        FileChooser.ExtensionFilter af = new FileChooser.ExtensionFilter("Java file", "*.java");
        FileChooser.ExtensionFilter rf = new FileChooser.ExtensionFilter("C++ file", "*.cpp");
        FileChooser.ExtensionFilter tf = new FileChooser.ExtensionFilter("Other", ".");
        fileChooser.getExtensionFilters().addAll(ef, af, rf, tf);
        fileChooser.setInitialFileName(textField.getText());
        
        file = fileChooser.showSaveDialog(Pwjb78Main.getStage());
        
        if(file != null)
        {
            System.out.println(file.getName());
            try
            {
                writer = new FileWriter(file);
                writer.write(htmlEditor.getHtmlText());
            }
            catch(IOException ex)
            {
                System.out.println("file writer io exception");
            }
            catch(Exception ex)
            {
                System.out.println("writer: unknown exception caught");
            }
            finally
            {
                if(writer != null)
                {
                    try
                    {
                        writer.close();
                    }
                    catch(IOException ex)
                    {
                        System.out.println("writer: close error");
                    }
                    catch(Exception ex)
                    {
                        System.out.println("writer: close exception");
                    }
                }
            }
        }
    }
    
    @Override
    public void start(Stage stage)
    {
        this.stage = stage;
        editorScene = stage.getScene();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}
