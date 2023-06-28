package ElementosSistemas;

import java.time.LocalDate;

import Estado.IEstadoExemplar;

public class Emprestimo {

    private Usuario Usuario;
    private Exemplar Exemplar;
    

    private LocalDate DataEmprestimo;
    private LocalDate DataDevolucao;
    private IEstadoExemplar Estado;


    public Emprestimo(ElementosSistemas.Usuario usuario, ElementosSistemas.Exemplar exemplar,
            LocalDate dataEmprestimo) {
        Usuario = usuario;
        Exemplar = exemplar;
        DataEmprestimo = dataEmprestimo;
    }
    
    public String getUsuarioNome() {
        return Usuario.getNome();
    }
    public String getLivroNome() {
        return Exemplar.getTitulo();
    }
    public LocalDate getDataEmprestimo() {
        return DataEmprestimo;
    }
    public LocalDate getDataDevolucao() {
        return DataDevolucao;
    }

    public void setExemplar(Exemplar exemplar) {
        Exemplar = exemplar;
    }
    public Exemplar getExemplar() {
        return Exemplar;
    }
    
    public void MostrarInfo(){
        Estado.MostrarInfo(this);
    }
    
    public void Finalizar(){
        Estado.Devolver();
    }
    
}