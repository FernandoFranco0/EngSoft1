package Decorator.Status;

import Decorator.Base.AbstractBase;
import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Usuario;

public class EmprestimoMax extends AbstractBase {

    public EmprestimoMax(AbstractBase h) {
        super(h);
    }

    @Override
    public String Alugar(AbstractBase base, Usuario Usuario, Livro Livro) {
        return "Usuario tem o max não aluga";
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
        return previous.getNome() + "EmprestimoMax ";
    }   
    
}
