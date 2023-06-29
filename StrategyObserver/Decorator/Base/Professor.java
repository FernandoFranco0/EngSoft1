package StrategyObserver.Decorator.Base;

import java.time.LocalDate;
import java.util.List;

import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Reserva;
import ElementosSistemas.Usuario;

public class Professor extends AbstractBase {

    public Professor() {
        super(null);
    }

    @Override
    public String Alugar(AbstractBase base, Usuario Usuario, Livro Livro) {

        if (!Livro.TemExemplares()){
            return "Sem Exemplares";
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

        List<Reserva> a = Usuario.getListReserva();
        a.add(new Reserva(Livro, Usuario, null));

        Usuario.setListReserva(a);

        return "Reserva realizada";   
    }

    @Override
    public Emprestimo CriarEmprestimo(Usuario Usuario, Exemplar Exemplar) {
        LocalDate Hoje = java.time.LocalDate.now();
        return new Emprestimo(Usuario, Exemplar, Hoje, Hoje.plusDays(7));
    }

    
    public String getNome(){
        return "Professor ";
    };
    
}
