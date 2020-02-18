package Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable{
    
    @FXML private TextField textUsuario;
    
    @FXML private PasswordField textSenha;
    
    @FXML private Label erro;
    
    @FXML private Button entrarTabela;
    
    @FXML private void entrar(){
       
        String usuario;
        String senha;
        
        usuario = textUsuario.getText();
        senha = textSenha.getText();
        
        if(usuario.equals("aluno") && senha.equals("ifsp")){
            
            System.out.println("coé");
      
            Stage telaInicial;
            
            Stage telaTabela = new Stage();
      
            Parent root = null;
      
            try{ 
                root = FXMLLoader.load(getClass().getResource("/view/Tabela.fxml"));
        
                Scene cena = new Scene(root);
      
                telaTabela.setScene(cena);
                
                telaInicial = (Stage) entrarTabela.getScene().getWindow();
      
                telaInicial.close();
        
                telaTabela.show();
      
            }
            catch(IOException e){
            
               System.out.println("Erro ao gerar a tela");
               System.out.println(e.getMessage());
               e.printStackTrace();
            }
        }
        else{
            
            erro.setText("Dados Incorretos !!");
        }
            
        
    };
     
    @Override
    public void initialize (URL url, ResourceBundle rb){
        
        
        
    }        
}
