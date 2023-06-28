package Estado;

import ElementosSistemas.Emprestimo;

public class ExemplarEmprestado implements IEstadoExemplar{

    public String MostrarInfo(Emprestimo E) {
        return " -- Exemplar emprestado para " + E.getUsuarioNome() + " em " + E.getDataEmprestimo() + " ate " + E.getDataDevolucao();
    }
    
    public String Devolver(Emprestimo E) {
        E.setEstado(new ExemplarDisponivel());
        return "Emprestimo agora está devolvido";
    }
    
}