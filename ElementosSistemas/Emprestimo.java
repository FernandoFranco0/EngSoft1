package ElementosSistemas;

import java.time.LocalDate;

import Estado.ExemplarEmprestado;
import Estado.IEstadoExemplar;

public class Emprestimo {

    private Usuario Usuario;
    private Exemplar Exemplar;
    private LocalDate DataEmprestimo;
    private LocalDate DataDevolucao;
    private IEstadoExemplar Estado;

    public Emprestimo(Usuario usuario, Exemplar exemplar, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        Usuario = usuario;
        Exemplar = exemplar;
        DataEmprestimo = dataEmprestimo;
        DataDevolucao = dataDevolucao;

        Estado = new ExemplarEmprestado();

    }

    public void MostrarInfo(){
        Estado.MostrarInfo(this);
    }
    
    public void Finalizar(){
        Estado.Devolver(this);
    }

    public String getUsuarioNome(){
        return Usuario.getNome();
    }

    public String getExemplarNome(){
        return Exemplar.getTitulo();
    }


    // --------------------------getters and setters-------------------------


    public Usuario getUsuario() {
        return Usuario;
    }
    public void setUsuario(Usuario usuario) {
        Usuario = usuario;
    }

    public Exemplar getExemplar() {
        return Exemplar;
    }
    public void setExemplar(Exemplar exemplar) {
        Exemplar = exemplar;
    }

    public LocalDate getDataEmprestimo() {
        return DataEmprestimo;
    }
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        DataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return DataDevolucao;
    }
    public void setDataDevolucao(LocalDate dataDevolucao) {
        DataDevolucao = dataDevolucao;
    }

    public IEstadoExemplar getEstado() {
        return Estado;
    }
    public void setEstado(IEstadoExemplar estado) {
        Estado = estado;
    }
    
}