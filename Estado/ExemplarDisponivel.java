package Estado;

import ElementosSistemas.Emprestimo;

public class ExemplarDisponivel implements IEstadoExemplar{

    public void MostrarInfo(Emprestimo E) {
        System.out.print(" -- Esta disponivel");
    }
    
    public void Devolver(Emprestimo E) {
        System.out.println("Erro. Exemplar já estava disponivel");
    }
    
}
