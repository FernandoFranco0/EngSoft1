package ElementosSistemas;

import Estado.*;

public class Exemplar {
    private int Id;
    private Livro Livro;
    private Emprestimo Emprestimo;

    public void MostrarInfo(){
        System.out.print("Id do exemplar: " + Id);
        Emprestimo.MostrarInfo();
    }

    public String getTitulo(){
        return Livro.getTitulo();
    }

    public Livro getLivro() {
        return Livro;
    }

    public void setLivro(Livro livro) {
        Livro = livro;
    }

}
