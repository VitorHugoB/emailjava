/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Vitor
 */
public class FXMLDocumentController implements Initializable {
    JavaMailApp novoemail = new JavaMailApp();
    
    @FXML
    private TextField txassunto;
    @FXML
    private TextField txremetente;
    @FXML
    private TextField txsenha;
    @FXML
    private TextField txdestinatario;
    @FXML
    private Button btnenviar;
    @FXML
    private TextArea txmensagem;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void enviaremail(ActionEvent event) {
        novoemail.setAssunto(txassunto.getText());
        novoemail.setEmailremetente(txremetente.getText());
        novoemail.setSenha(txsenha.getText());
        novoemail.setEmaildestinatario(txdestinatario.getText());
        novoemail.setMensagem(txmensagem.getText());
        
        novoemail.geraremail();
    }
    
}
