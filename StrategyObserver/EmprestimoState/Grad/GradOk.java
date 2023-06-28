package StrategyObserver.EmprestimoState.Grad;

import java.time.LocalDate;
import java.util.List;

import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Reserva;
import ElementosSistemas.Usuario;
import StrategyObserver.EmprestimoBehavior;

public class GradOk implements EmprestimoBehavior{
    
    public void Alugar(Usuario Usuario, Livro Livro) {

        if(Usuario.IsDevedor()){
            System.out.println("Usuario Devedor");
            Usuario.setEmprestimoManager(new GradDevedor());
            return;
        }

        if (!Livro.TemExemplares()){
            System.out.println("Sem Exemplares");
            return;
        }

        if(!Usuario.TemReserva(Livro) && !Livro.ExemplaresNaoReservado() ) {
            System.out.println("Todos exemplares reservados");
            return;
        }

        if (Usuario.JaTemLivro(Livro)){
            System.out.println("Já pegou esse livro");
            return;
        }

        Exemplar ParaAlugar = Livro.GetExemplarDisponivel();
        
        Livro.ExemplarIndisponivel(ParaAlugar);

        Usuario.RegistrarEmprestimo(CriarEmprestimo(Usuario, ParaAlugar));

        if(Usuario.QuantidadeEmprestimos() >= 3)
            Usuario.setEmprestimoManager(new GradMax());
    }

    public void Devolver(Usuario Usuario, Livro Livro) {

        for(Emprestimo E : Usuario.getEmprestimosAtuais()){

            Exemplar Exemp = E.getExemplar();
            
            if(Livro.equals(Exemp.getLivro())){
                Usuario.RetirarEmpre(E);
                Livro.ExemplarDisponivel(Exemp);

                if(!Usuario.IsDevedor())
                    Usuario.setEmprestimoManager(new GradOk());
                else
                    Usuario.setEmprestimoManager(new GradDevedor());

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
        return new Emprestimo(Usuario, Exemplar, Hoje, Hoje.plusDays(3));
    }

}
