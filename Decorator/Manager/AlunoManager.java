package Decorator.Manager;

import Decorator.Base.AbstractBase;
import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Usuario;
import Fabricas.FabricaDecorator;

public class AlunoManager implements EmprestimoBehavior {

    AbstractBase g;
    protected int EmprestimoMax;
    

    public String Alugar(Usuario Usuario, Livro Livro) {
        if(Usuario.IsDevedor())
            g = FabricaDecorator.NovoDevedor(g);
            
        String Msg = g.Alugar(g, Usuario, Livro);

        if(Usuario.QuantidadeEmprestimos() >= EmprestimoMax)
            g = FabricaDecorator.NovoEmprestimoMax(g);

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
            g = FabricaDecorator.NovoReservaMax(g);
        
        return Msg;
    }

    public Emprestimo CriarEmprestimo(Usuario Usuario, Exemplar Exemplar) {
        return g.CriarEmprestimo(Usuario, Exemplar);
    }
    
}
