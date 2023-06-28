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

    // --------------------------getters and setters-------------------------

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    public Livro getLivro() {
        return Livro;
    }
    public void setLivro(Livro livro) {
        Livro = livro;
    }

    public Emprestimo getEmprestimo() {
        return Emprestimo;
    }
    public void setEmprestimo(Emprestimo emprestimo) {
        Emprestimo = emprestimo;
    }

}
