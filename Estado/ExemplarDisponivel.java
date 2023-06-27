package Estado;

import ElementosSistemas.Emprestimo;

public class ExemplarDisponivel implements IEstadoExemplar{

    public void MostrarInfo(Emprestimo E) {
        System.out.print(" -- Esta disponivel");
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
