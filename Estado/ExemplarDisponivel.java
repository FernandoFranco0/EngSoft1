package Estado;

import ElementosSistemas.Emprestimo;

public class ExemplarDisponivel implements IEstadoExemplar{

    public String MostrarInfo(Emprestimo E) {
        return " -- Esta disponivel";
    }
    
    public String Devolver(Emprestimo E) {
        return "Erro. Exemplar já estava disponivel";
    }
    
}
