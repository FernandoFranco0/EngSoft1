package Estado;

import ElementosSistemas.Emprestimo;

public class ExemplarEmprestado implements IEstadoExemplar{

    public void MostrarInfo(Emprestimo E) {
        System.out.print(" -- Exemplar emprestado para " + E.getUsuarioNome() + 
                         " em " + E.getDataEmprestimo() + " ate " + E.getDataDevolucao());
    }
  
    public void Alugar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Alugar'");
    }
    
    public void Devolver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Devolver'");
    }
    
}