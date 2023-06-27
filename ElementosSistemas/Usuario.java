package ElementosSistemas;

import java.util.List;

import StrategyObserver.EmprestimoBehavior;
import StrategyObserver.Observer.ObserverBehavior;

public class Usuario {
    private int Id;
    private String Nome;
    private List<Reserva> ListReserva; 


    // ----------------------------
    // hack para alugar devolver etc, para corrigir adicionar novas funções dentro de Estado (talvez)
    private List<Emprestimo> EmprestimosPassados;
    private List<Emprestimo> EmprestimosAtuais;
    // ----------------------------
    private ObserverBehavior ObserverManager;
    private EmprestimoBehavior EmprestimoManager;

    public String getNome() {
        return Nome;
    }  

    public List<Reserva> getListReserva() {
        return ListReserva;
    }
    public void setListReserva(List<Reserva> listReserva) {
        ListReserva = listReserva;
    }

    public List<Emprestimo> getEmprestimosPassados() {
        return EmprestimosPassados;
    }
    public void setEmprestimosPassados(List<Emprestimo> emprestimosPassados) {
        EmprestimosPassados = emprestimosPassados;
    }

    public List<Emprestimo> getEmprestimosAtuais() {
        return EmprestimosAtuais;
    }
    public void setEmprestimosAtuais(List<Emprestimo> emprestimosAtuais) {
        EmprestimosAtuais = emprestimosAtuais;
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
