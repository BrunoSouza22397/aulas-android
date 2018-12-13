package bruno.souza.exspinnerlistviewstringarraytarde.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Contato implements Parcelable {
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

    protected Contato(Parcel in) {
        nome = in.readString();
        idade = in.readInt();
        email = in.readString();
        telefone = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeInt(idade);
        dest.writeString(email);
        dest.writeString(telefone);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Contato> CREATOR = new Parcelable.Creator<Contato>() {
        @Override
        public Contato createFromParcel(Parcel in) {
            return new Contato(in);
        }

        @Override
        public Contato[] newArray(int size) {
            return new Contato[size];
        }
    };
}