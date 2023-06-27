package ElementosSistemas;

import java.util.List;

import StrategyObserver.EmprestimoBehavior;
import StrategyObserver.Observer.ObserverBehavior;

public class Usuario {
    private int Id;
    private String Nome;
    private List<Reserva> ListReserva; 
    // ----------------------------
    // hack, para corrigir adicionar novas funções dentro de Estado
    private List<Emprestimo> EmprestimosPassados;
    private List<Emprestimo> EmprestimosAtuais;
    // ----------------------------
    private ObserverBehavior ObserverManager;
    private EmprestimoBehavior EmprestimoManager;

    public String getNome() {
        return Nome;
    }  


    // mudar para a classe de mensagem

    public void ComandoUsu(){
        System.out.println("Emprestimos finalizados: ");
        for(Emprestimo E : EmprestimosPassados){
            System.out.println("Livro: " + E.getLivroNome() +
                               " pego emprestado em " + E.getDataEmprestimo() + " ate" + E.getDataDevolucao());
        }
        System.out.println();

        System.out.println("Emprestimos ativos: ");
        for(Emprestimo E : EmprestimosAtuais){
            System.out.println("Livro: " + E.getLivroNome() +
                               " pego emprestado em " + E.getDataEmprestimo() + " ate" + E.getDataDevolucao());
        }
        System.out.println();

        System.out.println("Reservas: ");
        for(Reserva R : ListReserva){
            System.out.println("Reservou o Livro " + R.getLivroNome() + " em " + R.getData());
        }
    }

    public void ComandoNtf(){
        ObserverManager.MostrarInfo();
    }

    public void Alugar(Livro Livro){
        EmprestimoManager.Alugar(this, Livro);
    }

    public void Devolver(Livro Livro){
        EmprestimoManager.Devolver(this, Livro);
    }

    public void Reservar(Livro L){
        if(ListReserva.size() < 3){
            Reserva R = new Reserva(L, this, null); // variavel data atual ?
            ListReserva.add(R); 
            L.Reservar(R);
        }
        else{
            // mensagem erro
        }
    }
}
