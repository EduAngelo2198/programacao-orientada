package projeto;

public class Pessoas {
    
    private String nome;
    private int idade;
    private String sexo;
    private String hobbie;  
    
    public Pessoas(String nome, int idade, String sexo, String hobbie) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.hobbie = hobbie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getHobbie() {
        return hobbie;
    }

    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }
    
   
    
    
    
}
