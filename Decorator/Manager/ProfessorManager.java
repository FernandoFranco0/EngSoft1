package Decorator.Manager;

import Decorator.Base.AbstractBase;
import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Usuario;
import Fabricas.FabricaDecorator;

public class ProfessorManager implements EmprestimoBehavior {

    protected AbstractBase Base = FabricaDecorator.NovoProfessor();

    public String Alugar(Usuario Usuario, Livro Livro) {
        if(Usuario.IsDevedor())
            Base = FabricaDecorator.NovoDevedor(Base);
            
        String Msg = Base.Alugar(Base, Usuario, Livro);

        return Msg;
    }

    public String Devolver(Usuario Usuario, Livro Livro) {

        String Msg = Base.Devolver(Usuario, Livro);

        if(!Usuario.IsDevedor())
            Base = Base.removeDevedor();

        return Msg;
    }

    public String Reservar(Usuario Usuario, Livro Livro) {
        String Msg = Base.Reservar(Usuario, Livro);

        if(Usuario.QuantidadeReservas() >= 3)
            Base = FabricaDecorator.NovoReservaMax(Base);
        
        return Msg;
    }

    public Emprestimo CriarEmprestimo(Usuario Usuario, Exemplar Exemplar) {
        return Base.CriarEmprestimo(Usuario, Exemplar);
    }    

}
