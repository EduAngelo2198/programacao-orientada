package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import projeto.Pessoas;
import projeto.categoria;

public class TabelaController implements Initializable {

    //TEXT FIELD
    
    @FXML private TextField textNome;  
    @FXML private TextField textIdade;
    @FXML private Label erro;
    
    //TABELA
    
    @FXML private TableView<Pessoas> tabelaPessoas;
    
    //COLUNAS DA TABELA
    
    @FXML private TableColumn<Pessoas, String> colunaNome;
    @FXML private TableColumn<Pessoas, String> colunaIdade;
    @FXML private TableColumn<Pessoas, String> colunaSexo;
    @FXML private TableColumn<Pessoas, String> colunaHobbie;
    
    //RADIO BUTTON
    
    @FXML private ToggleGroup opcSexo;
    @FXML private RadioButton opcMasc;
    @FXML private RadioButton opcFem;
    @FXML private RadioButton opcNDA;
    
    //COMBO BOX
    
    @FXML private ComboBox<categoria> cbHobbies;
    
    //VETOR COMBO BOX CATEGORIAS
    
    private List<categoria> hobbies = new ArrayList<>();
    private ObservableList<categoria> escolhaHobbie;
    
    //VETOR COMPONENTES DA TABELA
    
    private List<Pessoas> ListaPessoas = new ArrayList();
    private ObservableList<Pessoas> observableListaPessoas;
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        carregarComboCategorias();
        
        this.colunaNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        this.colunaIdade.setCellValueFactory(new PropertyValueFactory<>("Idade"));
        this.colunaSexo.setCellValueFactory(new PropertyValueFactory<>("Sexo"));
        this.colunaHobbie.setCellValueFactory(new PropertyValueFactory<>("Hobbie"));
        
    }    
    
    @FXML private void cadastrar(){
        
        String nome;
        String idade;
        String hobbie = "";
        String sexo = "";
        
        //PEGAR TEXT FIELDS
        
        nome = textNome.getText();
        idade = textIdade.getText();
        
        //INTANCIAR RADIO E PEGAR VALOR
        
        RadioButton radioSelecionado = (RadioButton) this.opcSexo.getSelectedToggle();
        
        boolean radio = false;
              
        if(radioSelecionado == null){
            
            radio = true;
        }
        else
        {
          sexo = radioSelecionado.getText();  
        }
        
        //PEGAR VALOR COMBOBOX
                       
        boolean box = false;
        
        if(this.cbHobbies.getSelectionModel().isEmpty()){
            
            box = true;
            
        }
        else{
            
            hobbie = this.cbHobbies.getValue().getNome();
        }  
        
        //INSTANCIAR PESSOA E ADICIONAR NO VETOR        
        
        if(nome.equals("") || idade.equals("")|| radio == true || box == true){
            
            erro.setText("Preencha Corretamente !!");
           
            System.out.println("Preencha corretamente");
        }
        else{
            
            erro.setText("");
            
            int idade1;
            
            idade1 = Integer.parseInt(textIdade.getText());
            
            Pessoas pessoa = new Pessoas(nome,idade1, sexo, hobbie);
        
            this.ListaPessoas.add(pessoa);
        
            this.observableListaPessoas = 
                FXCollections.observableArrayList(this.ListaPessoas);
        
            this.tabelaPessoas.setItems(observableListaPessoas);
        
            limparCampos();
        }
        
        
    }
    
    //LIMPAR CAMPOS
    
    private void limparCampos(){
        this.textNome.setText("");
        this.textIdade.setText("");
        this.opcSexo.selectToggle(null);
        this.cbHobbies.getSelectionModel().clearSelection();
    }
    
    //LIMPAR TABELA
    
    @FXML private void cleanTabela(){
        
        if(this.ListaPessoas.size() > 0){
            
            this.ListaPessoas.clear();
            
            this.observableListaPessoas.clear();
            
            this.tabelaPessoas.setItems(observableListaPessoas);
        }
        
    }
    
    //CATEGORIAS HOBBIES
    
    public void carregarComboCategorias(){
        categoria cat1 = new categoria(1, "Esportes");
        categoria cat2 = new categoria(1, "Séries e filmes");
        categoria cat3 = new categoria(1, "Jogos");
        
        this.hobbies.add(cat1);
        this.hobbies.add(cat2);
        this.hobbies.add(cat3);
        
        this.escolhaHobbie = FXCollections.observableArrayList(this.hobbies);
        
        this.cbHobbies.setItems(this.escolhaHobbie);
    }
          
}
    
