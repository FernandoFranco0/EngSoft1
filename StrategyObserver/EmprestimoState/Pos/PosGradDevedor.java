package StrategyObserver.EmprestimoState.Pos;

import java.util.List;

import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Reserva;
import ElementosSistemas.Usuario;
import StrategyObserver.EmprestimoBehavior;

public class PosGradDevedor implements EmprestimoBehavior {

    public void Alugar(Usuario Usuario, Livro Livro) {
        System.out.println("Usuario devedor, emprestimo não realizado");;
    }

    public void Devolver(Usuario Usuario, Livro Livro) {

        for(Emprestimo E : Usuario.getEmprestimosAtuais()){

            Exemplar Exemp = E.getExemplar();
            
            if(Livro.equals(Exemp.getLivro())){
                Usuario.RetirarEmpre(E);
                Livro.ExemplarDisponivel(Exemp);

                if(!Usuario.IsDevedor())
                    Usuario.setEmprestimoManager(new PosGradOk());

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
    
}
