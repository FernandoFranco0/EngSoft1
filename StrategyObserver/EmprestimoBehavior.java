package StrategyObserver;

import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Usuario;

public interface EmprestimoBehavior {
    public void Alugar(Usuario Usuario, Livro Livro);
    public void Devolver(Usuario Usuario, Livro Livro);
    public void Reservar(Usuario Usuario, Livro Livro);
    public Emprestimo CriarEmprestimo(Usuario Usuario, Exemplar Exemplar);
}
