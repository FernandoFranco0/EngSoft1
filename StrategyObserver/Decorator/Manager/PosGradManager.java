package StrategyObserver.Decorator.Manager;

import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Usuario;
import StrategyObserver.EmprestimoBehavior;
import StrategyObserver.Decorator.Base.AbstractBase;
import StrategyObserver.Decorator.Base.PosGrad;
import StrategyObserver.Decorator.Status.Devedor;
import StrategyObserver.Decorator.Status.EmprestimoMax;
import StrategyObserver.Decorator.Status.ReservaMax;

public class PosGradManager implements EmprestimoBehavior {

    AbstractBase g = new PosGrad();

    public String Alugar(Usuario Usuario, Livro Livro) {
        if(Usuario.IsDevedor())
            g = new Devedor(g);
            
        String Msg = g.Alugar(g, Usuario, Livro);

        if(Usuario.QuantidadeEmprestimos() >= 4)
            g = new EmprestimoMax(g);

        return Msg;
    }

    public String Devolver(Usuario Usuario, Livro Livro) {
        return g.Devolver(Usuario, Livro);
    }

    public String Reservar(Usuario Usuario, Livro Livro) {
        String Msg = g.Reservar(Usuario, Livro);

        if(Usuario.getListReserva().size() >= 3)
            g = new ReservaMax(g);
        
        return Msg;
    }

    public Emprestimo CriarEmprestimo(Usuario Usuario, Exemplar Exemplar) {
        return g.CriarEmprestimo(Usuario, Exemplar);
    }    
}
