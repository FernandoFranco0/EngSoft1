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

    public String Alugar(Usuario Usuario, Livro Livro) {

        if(Usuario.IsDevedor()){    
            Usuario.setEmprestimoManager(new ProfessorDevedor());
            return "Usuario Devedor";
        }

        if (!Livro.TemExemplares()){
            return "Sem Exemplares";
        }

        Usuario.RemoverReserva(Livro);
        Livro.RemoverReserva(Usuario);

        Exemplar ParaAlugar = Livro.GetExemplarDisponivel();
        
        Livro.ExemplarIndisponivel(ParaAlugar);

        Usuario.RegistrarEmprestimo(CriarEmprestimo(Usuario, ParaAlugar));

        return "Emprestimo realizado com sucesso";
    }

    public String Devolver(Usuario Usuario, Livro Livro) {

        for(Emprestimo E : Usuario.getEmprestimosAtuais()){

            Exemplar Exemp = E.getExemplar();
            
            if(Livro.equals(Exemp.getLivro())){
                Usuario.RetirarEmpre(E);
                Livro.ExemplarDisponivel(Exemp);

                if(!Usuario.IsDevedor())
                    Usuario.setEmprestimoManager(new ProfessorOk());
                else
                    Usuario.setEmprestimoManager(new ProfessorDevedor());

                return "Devolvido com sucesso";
            }
        }

        return "Erro, ususario não tem esse livro";
    }

    public String Reservar(Usuario Usuario, Livro Livro) {

        if(Usuario.getListReserva().size() >= 3){
            return "Limite de reservas";
        }

        List<Reserva> a = Usuario.getListReserva();
        a.add(new Reserva(Livro, Usuario, null));

        Usuario.setListReserva(a);

        return "Reserva realizada";   
    }

    public Emprestimo CriarEmprestimo(Usuario Usuario, Exemplar Exemplar) {
        LocalDate Hoje = java.time.LocalDate.now();
        return new Emprestimo(Usuario, Exemplar, Hoje, Hoje.plusDays(7));
    }
}
