package Decorator.Base;

import java.time.LocalDate;
import java.util.List;

import ElementosSistemas.BibliotecaFacade;
import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Reserva;
import ElementosSistemas.Usuario;
import Fabricas.FabricaElementosSistema;

public abstract class Aluno extends AbstractBase {

    protected int MaxDiasEmprestados;

    public Aluno() {
        super(null);
    }

    @Override
    public String Alugar(AbstractBase base, Usuario Usuario, Livro Livro) {

        if (!Livro.TemExemplares()){
            return "Sem Exemplares";
        }

        if(!Usuario.TemReserva(Livro) && !Livro.ExemplaresNaoReservado() ) {
            return "Todos exemplares reservados";
        }

        if (Usuario.JaTemLivro(Livro)){
            return "Já pegou esse livro";
        }

        Usuario.RemoverReserva(Livro);
        Livro.RemoverReserva(Usuario);
        
        base = base.removeReservaMax();

        Exemplar ParaAlugar = Livro.GetExemplarDisponivel();
        
        Livro.ExemplarIndisponivel(ParaAlugar);

        Usuario.RegistrarEmprestimo(CriarEmprestimo(Usuario, ParaAlugar));

        return "Emprestimo realizado com sucesso";
    }

    @Override
    public String Devolver(Usuario Usuario, Livro Livro) {
        for(Emprestimo E : Usuario.getEmprestimosAtuais()){

            Exemplar Exemp = E.getExemplar();
            
            if(Livro.equals(Exemp.getLivro())){
                Usuario.RetirarEmpre(E);
                Livro.ExemplarDisponivel(Exemp);

                return "Devolvido com sucesso";
            }
        }
        return "Erro, usuario não tem esse livro";
    }

    @Override
    public String Reservar(Usuario Usuario, Livro Livro) {
        LocalDate Hoje = java.time.LocalDate.now();
        Reserva R = FabricaElementosSistema.NovaReserva(Livro, Usuario, Hoje);

        Usuario.GuardarReserva(R);
        Livro.Reservar(R);
        BibliotecaFacade.ObterInstancia().GuardarReserva(R);

        return "Reserva realizada";   
    }

    @Override
    public Emprestimo CriarEmprestimo(Usuario Usuario, Exemplar Exemplar) {
        LocalDate Hoje = java.time.LocalDate.now();
        return FabricaElementosSistema.NovoEmprestimo(Usuario, Exemplar, Hoje, Hoje.plusDays(MaxDiasEmprestados));
    }

    
    public String getNome(){
        return "Aluno ";
    };
}
