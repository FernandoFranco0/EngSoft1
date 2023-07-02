package Decorator.Manager;

import Decorator.Base.AbstractBase;
import Decorator.Base.Grad;
import Decorator.Status.Devedor;
import Decorator.Status.EmprestimoMax;
import Decorator.Status.ReservaMax;
import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Usuario;
import EmprestimoState.EmprestimoBehavior;

public class AlunoManager implements EmprestimoBehavior {

    AbstractBase g = new Grad();
    protected int EmprestimoMax;
    

    public String Alugar(Usuario Usuario, Livro Livro) {
        if(Usuario.IsDevedor())
            g = new Devedor(g);
            
        String Msg = g.Alugar(g, Usuario, Livro);

        if(Usuario.QuantidadeEmprestimos() >= EmprestimoMax)
            g = new EmprestimoMax(g);

        return Msg;
    }

    public String Devolver(Usuario Usuario, Livro Livro) {

        String Msg = g.Devolver(Usuario, Livro);

        if(!Usuario.IsDevedor())
            g = g.removeDevedor();
        
        g = g.removeEmprestimoMax();
        
        return Msg;
    }

    public String Reservar(Usuario Usuario, Livro Livro) {
        String Msg = g.Reservar(Usuario, Livro);

        if(Usuario.getListReserva().size() >= EmprestimoMax)
            g = new ReservaMax(g);
        
        return Msg;
    }

    public Emprestimo CriarEmprestimo(Usuario Usuario, Exemplar Exemplar) {
        return g.CriarEmprestimo(Usuario, Exemplar);
    }
    
}
