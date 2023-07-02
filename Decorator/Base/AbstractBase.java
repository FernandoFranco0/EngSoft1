package Decorator.Base;

import Decorator.Status.Devedor;
import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Usuario;

public abstract class AbstractBase {

    protected AbstractBase previous;

    public AbstractBase(AbstractBase h) {
		this.previous = h;
	}

    public abstract String Alugar(AbstractBase base, Usuario Usuario, Livro Livro);
    public abstract String Devolver(Usuario Usuario, Livro Livro);
    public abstract String Reservar(Usuario Usuario, Livro Livro);
    public abstract Emprestimo CriarEmprestimo(Usuario Usuario, Exemplar Exemplar);

    public AbstractBase removeDevedor(){
        if(previous == null)
            return this;
        else if (this instanceof Devedor) 
            return previous;
        else{
            this.previous = previous.removeDevedor();
            return this;
        }
    };

    public AbstractBase removeEmprestimoMax(){
        if(previous == null)
            return this;
        else if (this instanceof Devedor) 
            return previous;
        else{
            this.previous = previous.removeEmprestimoMax();
            return this;
        }
    };

    public AbstractBase removeReservaMax(){
        if(previous == null)
            return this;
        else if (this instanceof Devedor) 
            return previous;
        else{
            this.previous = previous.removeReservaMax();
            return this;
        }
    };

    public abstract String getNome();

}

