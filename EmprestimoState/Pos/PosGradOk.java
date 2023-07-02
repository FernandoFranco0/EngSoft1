package EmprestimoState.Pos;

import java.time.LocalDate;
import java.util.List;

import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Reserva;
import ElementosSistemas.Usuario;
import EmprestimoState.EmprestimoBehavior;

public class PosGradOk implements EmprestimoBehavior{
    
    public String Alugar(Usuario Usuario, Livro Livro) {

        if(Usuario.IsDevedor()){
            Usuario.setEmprestimoManager(new PosGradDevedor());
            return "Usuario Devedor";
        }

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

        Exemplar ParaAlugar = Livro.GetExemplarDisponivel();
        
        Livro.ExemplarIndisponivel(ParaAlugar);

        Usuario.RegistrarEmprestimo(CriarEmprestimo(Usuario, ParaAlugar));

        if(Usuario.QuantidadeEmprestimos() >= 4)
            Usuario.setEmprestimoManager(new PosGradMax());
        
        return "Emprestimo realizado com sucesso";
    }

    public String Devolver(Usuario Usuario, Livro Livro) {

        for(Emprestimo E : Usuario.getEmprestimosAtuais()){

            Exemplar Exemp = E.getExemplar();
            
            if(Livro.equals(Exemp.getLivro())){
                Usuario.RetirarEmpre(E);
                Livro.ExemplarDisponivel(Exemp);

                if(!Usuario.IsDevedor())
                    Usuario.setEmprestimoManager(new PosGradOk());
                else
                    Usuario.setEmprestimoManager(new PosGradDevedor());

                return "Devolvido com sucesso";
            }
        }

        System.out.println("Erro, ususario não tem esse livro");
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
        return new Emprestimo(Usuario, Exemplar, Hoje, Hoje.plusDays(4));
    }

}