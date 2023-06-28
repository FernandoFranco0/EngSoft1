package Estado;

import ElementosSistemas.Emprestimo;

public class ExemplarEmprestado implements IEstadoExemplar{

    public void MostrarInfo(Emprestimo E) {
        System.out.print(" -- Exemplar emprestado para " + E.getUsuarioNome() + 
                         " em " + E.getDataEmprestimo() + " ate " + E.getDataDevolucao());
    }
    
    public void Devolver(Emprestimo E) {
        E.setEstado(new ExemplarDisponivel());
    }
    
}