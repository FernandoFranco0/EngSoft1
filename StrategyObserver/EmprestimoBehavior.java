package StrategyObserver;

import ElementosSistemas.Livro;
import ElementosSistemas.Usuario;

public interface EmprestimoBehavior {
    public void Alugar(Usuario Usuario, Livro Livro);
    public void Devolver(Usuario Usuario, Livro Livro);
}
