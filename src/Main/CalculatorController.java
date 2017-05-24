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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Parker
 */
public class CalculatorController extends BaseController implements Initializable {
    
    @FXML
    private Label output;
    private Label history;
    private String equation;
    private boolean switchParenth = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void start(Stage stage)
    {
        this.stage = stage;
        calcScene = stage.getScene();
    }
    
    public Label getOutput()
    {
        return output;
    }

    public void setOutput(Label output) {
        this.output = output;
    }
    
    public void openAction(ActionEvent event){
        
    }
    
    public void saveAction(ActionEvent event){
        
    }
    
    public void backspaceAction(ActionEvent event){
        if(output.getText().length() > 0)
        {
            output.setText(output.getText().substring(0, output.getText().length()-1));
        } 
    }
    
    public void clearAction(ActionEvent event){
        output.setText("");
    }
    
    public void parenthesisAction(ActionEvent event){
        if(switchParenth == true)
        {
            output.setText(output.getText() + ")");
            switchParenth = false;
        }
        else
        {
            output.setText(output.getText() + "(");
            switchParenth = true;
        } 
    }
    
    public void moduloAction(ActionEvent event){
        output.setText(output.getText() + "%");
    }
    
    public void divisionAction(ActionEvent event){
        output.setText(output.getText() + "/");
    }
    
    public void sevenAction(ActionEvent event){
        output.setText(output.getText() + "7");
    }
    
    public void eightAction(ActionEvent event){
        output.setText(output.getText()+ "8");
    }
    
    public void nineAction(ActionEvent event){
        output.setText(output.getText() + "9");
    }
    
    public void multiplyAction(ActionEvent event){
        output.setText(output.getText() + "*");
    }
    
    public void fourAction(ActionEvent event){
        output.setText(output.getText() + "4");
    }
    
    public void fiveAction(ActionEvent event){
        output.setText(output.getText()+ "5");
    }
    
    public void sixAction(ActionEvent event){
        output.setText(output.getText() + "6");
    }
    
    public void minusAction(ActionEvent event){
        output.setText(output.getText() + "-");
    }
    
    public void oneAction(ActionEvent event){
        output.setText(output.getText() + "1");
    }
    
    public void twoAction(ActionEvent event){
        output.setText(output.getText() + "2");
    }
    
    public void threeAction(ActionEvent event){
        output.setText(output.getText() + "3");
    }
    
    public void additionAction(ActionEvent event){
        output.setText(output.getText() + "+");
    }
    
    public void negAction(ActionEvent event){
        
    }
    
    public void zeroAction(ActionEvent event){
        output.setText(output.getText() + "0");
    }
    
    public void decimalAction(ActionEvent event){
        output.setText(output.getText() + ".");
    }
    
    public void equalsAction(ActionEvent event){
        equation = output.getText();
    }
    
    public void calculate(String equation)
    {
        
    }
}
