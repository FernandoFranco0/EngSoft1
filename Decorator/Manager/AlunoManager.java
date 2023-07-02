package Decorator.Manager;

import Decorator.Base.AbstractBase;
import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Usuario;
import Fabricas.FabricaDecorator;

public abstract class AlunoManager implements EmprestimoBehavior {

    protected AbstractBase Base;
    protected int EmprestimoMax;
    

    public String Alugar(Usuario Usuario, Livro Livro) {
        if(Usuario.IsDevedor())
            Base = FabricaDecorator.NovoDevedor(Base);
            
        String Msg = Base.Alugar(Base, Usuario, Livro);

        if(Usuario.QuantidadeEmprestimos() >= EmprestimoMax)
            Base = FabricaDecorator.NovoEmprestimoMax(Base);

        return Msg;
    }

    public String Devolver(Usuario Usuario, Livro Livro) {

        String Msg = Base.Devolver(Usuario, Livro);

        if(!Usuario.IsDevedor())
            Base = Base.removeDevedor();
        
        Base = Base.removeEmprestimoMax();
        
        return Msg;
    }

    public String Reservar(Usuario Usuario, Livro Livro) {
        String Msg = Base.Reservar(Usuario, Livro);

        if(Usuario.getListReserva().size() >= EmprestimoMax)
            Base = FabricaDecorator.NovoReservaMax(Base);
        
        return Msg;
    }

    public Emprestimo CriarEmprestimo(Usuario Usuario, Exemplar Exemplar) {
        return Base.CriarEmprestimo(Usuario, Exemplar);
    }
    
}
