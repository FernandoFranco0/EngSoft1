package Decorator.Manager;

import Decorator.Base.AbstractBase;
import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Usuario;
import Fabricas.FabricaDecorator;

public class ProfessorManager implements EmprestimoBehavior {

    AbstractBase g = FabricaDecorator.NovoProfessor();

    public String Alugar(Usuario Usuario, Livro Livro) {
        if(Usuario.IsDevedor())
            g = FabricaDecorator.NovoDevedor(g);
            
        String Msg = g.Alugar(g, Usuario, Livro);

        return Msg;
    }

    public String Devolver(Usuario Usuario, Livro Livro) {

        String Msg = g.Devolver(Usuario, Livro);

        if(!Usuario.IsDevedor())
            g = g.removeDevedor();

        return Msg;
    }

    public String Reservar(Usuario Usuario, Livro Livro) {
        String Msg = g.Reservar(Usuario, Livro);

        if(Usuario.getListReserva().size() >= 3)
            g = FabricaDecorator.NovoReservaMax(g);
        
        return Msg;
    }

    public Emprestimo CriarEmprestimo(Usuario Usuario, Exemplar Exemplar) {
        return g.CriarEmprestimo(Usuario, Exemplar);
    }    
    
}
