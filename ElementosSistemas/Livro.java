package ElementosSistemas;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import StrategyObserver.Observer.ObserverBehavior;
import StrategyObserver.Observer.Subject;

public class Livro implements Subject{
    private int Id;
    private String Titulo;
    private String Editora;
    private int Edicao;
    private List<String> Autores;
    private List<Exemplar> ListaExemplar;
    private List<Reserva> ListaReservas;
    private ArrayList<ObserverBehavior> Observers;

    public void ComandoLiv(){
        System.out.println("Titulo: " + Titulo);
        System.out.println("Quantidade de reservars: " + ListaReservas.size());
        if(ListaReservas.size() > 0){
            System.out.println("Reservador por: ");
            for(Reserva R : ListaReservas){
                System.out.println(R.getUsuario() + " ");
            }
        }

        for(Exemplar E : ListaExemplar){
            E.MostrarInfo();
        }
    }

    public String getTitulo() {
        return Titulo;
    }

    public void registerObserver(ObserverBehavior o) {
        Observers.add(o);
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

        if(ListaReservas.size() >= 2)
            notifyObservers();
    }
}