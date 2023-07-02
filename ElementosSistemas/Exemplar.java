package ElementosSistemas;

import Fabricas.FabricaElementosSistema;

public class Exemplar {
    private int Id;
    private Livro Livro;
    private Emprestimo Emprestimo;

    public Exemplar(int id, Livro livro) {
        Id = id;
        Livro = livro;
        Emprestimo = FabricaElementosSistema.NovoEmprestimo(null, this, null, null);
    }

    public String MostrarInfo(){
        String Msg = "";
        Msg += "Id do exemplar: " + Id;
        Msg += Emprestimo.MostrarInfo();
        return Msg;
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
