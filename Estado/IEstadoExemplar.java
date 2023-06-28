package Estado;

import ElementosSistemas.Emprestimo;

public interface IEstadoExemplar {
    public String MostrarInfo(Emprestimo E);
    public String Devolver(Emprestimo E);
}
