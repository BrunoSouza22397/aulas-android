package bruno.souza.exspinnerlistviewstringarraytarde.model;

public class Contato {
    private String nome;
    private int idade;
    private String email;
    private String telefone;

    public Contato() {
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome = " + nome +
                "\nIdade = " + idade +
                "\nIdade em meses = " + calcIdadeMeses() +
                "\nEmail = " + email +
                "\nTelefone = " + telefone;
    }
    public int calcIdadeMeses(){
        return this.idade*12;
    }
}
