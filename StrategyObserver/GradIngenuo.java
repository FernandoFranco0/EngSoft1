package StrategyObserver;

import java.time.LocalDate;
import java.util.List;

import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Reserva;
import ElementosSistemas.Usuario;

public class GradIngenuo {

    public void Alugar(Usuario Usuario, Livro Livro, LocalDate Hoje) {

        boolean TemReserva = false;
        for(Reserva R : Usuario.getListReserva()) {
            if(R.getLivro().equals(Livro)){
                TemReserva = true;
                Usuario.getListReserva().remove(R);
                break;
            }
        }

        for(Emprestimo E : Usuario.getEmprestimosAtuais()){
            if(Hoje.isAfter(E.getDataDevolucao())){
                System.out.println("Devedor. Retorne o livro");
                return;
            }
        }

        List<Exemplar> Exemplaresdis = Livro.getListaExemplarDisponiveis();
        if(Exemplaresdis.size() <= 0){
            System.out.println("Sem Exemplares");
            return;
        }

        if(Usuario.getEmprestimosAtuais().size() >= 3){
            System.out.println("Numero maximo de emprestimos");
            return;
        }

        if(!TemReserva && (Exemplaresdis.size() <= Livro.getListaReservas().size())){
            System.out.println("Todos exemplares reservados");
            return;
        }

        // chegar se ja tem um emprestismo desse livro


        Exemplar Ex = Exemplaresdis.get(0);
        Exemplaresdis.remove(Ex);
        Livro.setListaExemplarDisponiveis(Exemplaresdis);

        List<Exemplar> ExempalresInd = Livro.getListaExemplarIndisponiveis();

        ExempalresInd.add(Ex);

        Livro.setListaExemplarIndisponiveis(ExempalresInd);

        Emprestimo E = new Emprestimo(); 
        
        List<Emprestimo> UserEmpre = Usuario.getEmprestimosAtuais();

        UserEmpre.add(E);

        Usuario.setEmprestimosAtuais(UserEmpre);
        
    }
    
    public void Devolver(Usuario Usuario, Exemplar exemplar) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Devolver'");
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
