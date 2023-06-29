package ElementosSistemas;
import java.util.ArrayList;
import java.util.List;

import StrategyObserver.Observer.ObserverBehavior;
import StrategyObserver.Observer.Subject;

public class Livro implements Subject{
    private int Id;
    private String Titulo;
    private String Editora;
    private int Edicao;
    private List<String> Autores;
    private int AnoPublicacao;

    // isso aqui é basicamente um hack para o alugar, mas não precisa para o resto pois esta sendo feito com o state
    private List<Exemplar> ListaExemplarIndisponiveis;    
    private List<Exemplar> ListaExemplarDisponiveis;

    private List<Reserva> ListaReservas;
    private ArrayList<ObserverBehavior> Observers;

    public Livro(int id, String titulo, String editora, int edicao, List<String> autores, int anoPublicacao) {
        Id = id;
        Titulo = titulo;
        Editora = editora;
        Edicao = edicao;
        Autores = autores;
        AnoPublicacao = anoPublicacao;
        ListaExemplarDisponiveis = new ArrayList<Exemplar>();
        ListaExemplarIndisponiveis = new ArrayList<Exemplar>();
        ListaReservas = new ArrayList<Reserva>();
        Observers = new ArrayList<ObserverBehavior>();
    }

    public String ComandoLiv(){
        String Msg = "";
        Msg += "Titulo: " + Titulo + "\n";
        Msg += "Quantidade de reservars: " + ListaReservas.size() + "\n";
        if(ListaReservas.size() > 0){
            Msg +="Reservador por: ";
            for(Reserva R : ListaReservas){
                Msg += R.getUsuario() + ", ";
            }
        }

        Msg += "\n";

        for(Exemplar E : ListaExemplarIndisponiveis){
            Msg += E.MostrarInfo();
        }

        Msg += "\n";

        for(Exemplar E : ListaExemplarDisponiveis){
            Msg += E.MostrarInfo();
        }

        Msg += "\n";

        return Msg;
    }

    public boolean RemoverReserva(Usuario U){

        for(Reserva R : ListaReservas) {
            if(R.getUsuario().equals(U)){
                ListaReservas.remove(R);
                return true;
            }
        }

        return false;
    }

    public void ExemplarDisponivel(Exemplar E){
        ListaExemplarIndisponiveis.remove(E);
        ListaExemplarDisponiveis.add(E);
    }

    public void ExemplarIndisponivel(Exemplar E){
        ListaExemplarIndisponiveis.add(E);
        ListaExemplarDisponiveis.remove(E);
    }

    public boolean TemExemplares(){

        if( ListaExemplarDisponiveis.size() <= 0){
            return false;
        }

        return true;
    }

    public boolean ExemplaresNaoReservado(){
        if(ListaExemplarDisponiveis.size() > 0)
            return true;

        return false;
    }

    public Exemplar GetExemplarDisponivel(){
        return ListaExemplarDisponiveis.get(0);
    }

    public boolean EExemplar(Exemplar E){
        if(ListaExemplarIndisponiveis.indexOf(E) >= 0  || ListaExemplarDisponiveis.indexOf(E) >= 0)
            return true;
        
        return false;
    }

    public void Reservar(Reserva R){
        ListaReservas.add(R);

        if(ListaReservas.size() >= 2)
            notifyObservers();
    }
    
    public void RemoverReserva(Reserva R){
        int i = ListaReservas.indexOf(R);
		if (i >= 0) {
			ListaReservas.remove(i);
		}
    }

    public String registerObserver(ObserverBehavior o) {
        Observers.add(o);
        return "Professor adicionado com sucesso";
    }

    public void removeObserver(ObserverBehavior o) {
        int i = Observers.indexOf(o);
		if (i >= 0) {
			Observers.remove(i);
		}
    }

    public void notifyObservers() {
        for (int i = 0; i < Observers.size(); i++) {
			ObserverBehavior observer = Observers.get(i);
			observer.Update(this);
		}
    }

    // --------------------------getters and setters-------------------------

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return Titulo;
    }
    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getEditora() {
        return Editora;
    }
    public void setEditora(String editora) {
        Editora = editora;
    }

    public int getEdicao() {
        return Edicao;
    }
    public void setEdicao(int edicao) {
        Edicao = edicao;
    }

    public List<String> getAutores() {
        return Autores;
    }
    public void setAutores(List<String> autores) {
        Autores = autores;
    }

    public List<Exemplar> getListaExemplarIndisponiveis() {
        return ListaExemplarIndisponiveis;
    }
    public void setListaExemplarIndisponiveis(List<Exemplar> listaExemplarIndisponiveis) {
        ListaExemplarIndisponiveis = listaExemplarIndisponiveis;
    }

    public List<Exemplar> getListaExemplarDisponiveis() {
        return ListaExemplarDisponiveis;
    }
    public void setListaExemplarDisponiveis(List<Exemplar> listaExemplarDisponiveis) {
        ListaExemplarDisponiveis = listaExemplarDisponiveis;
    }

    public List<Reserva> getListaReservas() {
        return ListaReservas;
    }
    public void setListaReservas(List<Reserva> listaReservas) {
        ListaReservas = listaReservas;
    }

    public ArrayList<ObserverBehavior> getObservers() {
        return Observers;
    }
    public void setObservers(ArrayList<ObserverBehavior> observers) {
        Observers = observers;
    }
}