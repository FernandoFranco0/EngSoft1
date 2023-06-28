package StrategyObserver.EmprestimoState.Professor;

import java.time.LocalDate;
import java.util.List;

import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Reserva;
import ElementosSistemas.Usuario;
import StrategyObserver.EmprestimoBehavior;


public class ProfessorOk implements EmprestimoBehavior {
    public void Alugar(Usuario Usuario, Livro Livro) {

        if(Usuario.IsDevedor()){
            System.out.println("Usuario Devedor");
            Usuario.setEmprestimoManager(new ProfessorDevedor());
            return;
        }

        if (!Livro.TemExemplares()){
            System.out.println("Sem Exemplares");
            return;
        }

        Exemplar ParaAlugar = Livro.GetExemplarDisponivel();
        
        Livro.ExemplarIndisponivel(ParaAlugar);

        Usuario.RegistrarEmprestimo(CriarEmprestimo(Usuario, ParaAlugar));
    }

    public void Devolver(Usuario Usuario, Livro Livro) {

        for(Emprestimo E : Usuario.getEmprestimosAtuais()){

            Exemplar Exemp = E.getExemplar();
            
            if(Livro.equals(Exemp.getLivro())){
                Usuario.RetirarEmpre(E);
                Livro.ExemplarDisponivel(Exemp);

                if(!Usuario.IsDevedor())
                    Usuario.setEmprestimoManager(new ProfessorOk());
                else
                    Usuario.setEmprestimoManager(new ProfessorDevedor());

                return;
            }
        }

        System.out.println("Erro, ususario não tem esse livro");
        return;
    }

    public void Reservar(Usuario Usuario, Livro Livro) {

        if(Usuario.getListReserva().size() >= 3){
            System.out.println("Limite de reservas");    
            return;
        }

        List<Reserva> a = Usuario.getListReserva();
        a.add(new Reserva(Livro, Usuario, null));

        Usuario.setListReserva(a);

        System.out.println("Reserva realizada");    
    }

    public Emprestimo CriarEmprestimo(Usuario Usuario, Exemplar Exemplar) {
        LocalDate Hoje = java.time.LocalDate.now();
        return new Emprestimo(Usuario, Exemplar, Hoje, Hoje.plusDays(7));
    }
}
