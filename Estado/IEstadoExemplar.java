package Estado;

import ElementosSistemas.Emprestimo;

public interface IEstadoExemplar {
    public void MostrarInfo(Emprestimo E);
    public void Devolver(Emprestimo E);
}
