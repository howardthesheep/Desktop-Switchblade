package Main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Pwjb78Main extends Application
{
    private static Stage primaryStage;
    private static Parent root;
    
    @Override
    public void start(Stage stage) throws Exception
    {
        primaryStage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocumentEditor.fxml"));
        root = loader.load();
        
        BaseController.setEditor(loader.getController());
        
        BaseController.editorScene = new Scene(root);
        
        primaryStage.setScene(BaseController.editorScene);
        primaryStage.show();
       
        BaseController.editor.start(stage); 
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
    public static Stage getStage()
    {
        return primaryStage;
    }
    
    public static void setStage(Stage stage)
    {
        primaryStage = stage;
    }
    
    public static Parent getRoot()
    {
        return root;
    }
    
    public static void setRoot(Parent par)
    {
        root = par;
    }
    
//    public static void reload()
//    {
            //used to reload the main scene in the event of changing programs
//       primaryStage.setScene(scene);
//       
//    }

}
