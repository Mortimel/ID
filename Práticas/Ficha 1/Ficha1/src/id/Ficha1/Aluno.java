package id.Ficha1;

/**
 *
 * @author BrunoOliveira
 */
public class Aluno {
    String nome;
    String local;
    String genero;
    int idade;

    public Aluno(String nome, String local, String genero, int idade){
        this.nome = nome;
        this.local = local;
        this.genero = genero;
        this.idade = idade;
    }

    public String getNome(){
        return nome;
    }

    public String getLocal(){
        return local;
    }

    public String getGenero(){
        return genero;
    }

    public int getIdade(){
        return idade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setLocal(String local){
        this.local = local;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void imprime(){
        System.out.println("Dados do aluno: ");
        System.out.println("\t Nome: " + this.nome);
        System.out.println("\t Localidade: " +  this.local);
        System.out.println("\t Genero: " + this.genero);
        System.out.println("\t Idade: " + this.idade);
    }
}


