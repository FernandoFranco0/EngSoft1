package ElementosSistemas;

import java.time.LocalDate;

import Estado.IEstadoExemplar;

public class Emprestimo {

    private Usuario Usuario;
    private Exemplar Exemplar;
    private LocalDate DataEmprestimo;
    private LocalDate DataDevolucao;
    private IEstadoExemplar Estado;

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

    public void MostrarInfo(){
        Estado.MostrarInfo(this);
    }
    
}