package StrategyObserver.Decorator.Status;

import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Usuario;
import StrategyObserver.Decorator.Base.AbstractBase;

public class Devedor extends AbstractBase {

    public Devedor(AbstractBase h) {
        super(h);
    }

    @Override
    public String Alugar(AbstractBase base, Usuario Usuario, Livro Livro) {
        return "Usuario devedor não aluga";
    }

    @Override
    public String Devolver(Usuario Usuario, Livro Livro) {
        return previous.Devolver(Usuario, Livro);
    }

    @Override
    public String Reservar(Usuario Usuario, Livro Livro) {
        return previous.Reservar(Usuario, Livro);
    }

    @Override
    public Emprestimo CriarEmprestimo(Usuario Usuario, Exemplar Exemplar) {
        return previous.CriarEmprestimo(Usuario, Exemplar);
    }

    @Override
    public String getNome() {
        return previous.getNome() + "Devedor ";
    }
    
}
