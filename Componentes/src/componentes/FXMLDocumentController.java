package componentes;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import modelo.categoria;

public class FXMLDocumentController implements Initializable {
    
    //COMBO BOX
    
    @FXML private Button capturarCombo;
    @FXML private Label lbRespCombo; 
    
    @FXML private ComboBox<categoria> comboBox;
    
    private List<categoria> escolha = new ArrayList<>();
    private ObservableList<categoria> obsEscolha;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        carregarComboCategorias();
    }
    
    //CHECK BOX
    
    //@FXML private Button capturarCheck;
    @FXML private CheckBox cb1;
    @FXML private CheckBox cb2;
    @FXML private Label lbRespCheck; 
    
    //RADIO BUTTON 
    
    @FXML private ToggleGroup toggleRadioOpt;
    @FXML private RadioButton r1;
    @FXML private RadioButton r2;
    //@FXML private Button capturarRadio;
    @FXML private Label lbRespRadio; 
    
    
    @FXML private void capturarCombo(ActionEvent event){
        
        lbRespCombo.setText(this.comboBox.getValue().getNome());
    }
    
    @FXML private void capturarCheck(){
        boolean java = this.cb1.selectedProperty().getValue();
        boolean php = this.cb2.selectedProperty().getValue();
        
        if(java == true && php == false){
            
            lbRespCheck.setText("Selecionou: Java");  
        }
        else if(java == false && php == true){
            
            lbRespCheck.setText("Selecionou: Php");
        }   
        else if(java == true && php == true){
            
            lbRespCheck.setText("Selecionou: Java e Php");
        }   
        else{
            
            lbRespCheck.setText("Nenhum item selecionado");
        }     
    }
    
    @FXML private void capturarRadio(){
        RadioButton radioSelecionado = (RadioButton) this.toggleRadioOpt.getSelectedToggle();
        
        lbRespRadio.setText(radioSelecionado.getText());
    }
    
    
   // @Override
    //public void initialize(URL url, ResourceBundle rb) {
        // TODO
    //}    
    
    public void carregarComboCategorias(){
        categoria cat1 = new categoria(1, "Cachorro");
        categoria cat2 = new categoria(1, "Gato");
        
        this.escolha.add(cat1);
        this.escolha.add(cat2);
        
        this.obsEscolha = FXCollections.observableArrayList(this.escolha);
        
        this.comboBox.setItems(this.obsEscolha);
    }
    
}
