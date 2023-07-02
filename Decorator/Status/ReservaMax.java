package Decorator.Status;

import Decorator.Base.AbstractBase;
import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Usuario;

public class ReservaMax extends AbstractBase {

    public ReservaMax(AbstractBase h) {
        super(h);
    }

    public String Alugar(AbstractBase base, Usuario Usuario, Livro Livro) {
        return previous.Alugar(base, Usuario, Livro);
    }

    @Override
    public String Devolver(Usuario Usuario, Livro Livro) {
        return previous.Devolver(Usuario, Livro);
    }

    @Override
    public String Reservar(Usuario Usuario, Livro Livro) {
        return "Maximo de reservas";
    }

    @Override
    public Emprestimo CriarEmprestimo(Usuario Usuario, Exemplar Exemplar) {
        return previous.CriarEmprestimo(Usuario, Exemplar);
    }

    @Override
    public String getNome() {
        return previous.getNome() + "ReservaMax ";
    }

    
    
}
