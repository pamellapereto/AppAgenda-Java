package controller;
public class Lista {
    //DECLARACAO DE ID
    private int id;
    private String nome;

    public Lista(String nome) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //GETTER AND SETTER DE ID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public void cadastroSucesso() {
        System.out.print("Lista cadastrada com sucesso!");
    }
    public void cadastroErro() {
        System.out.print("Erro ao cadastrar lista!");
    }
}
