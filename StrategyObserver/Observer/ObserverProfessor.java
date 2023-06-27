package StrategyObserver.Observer;

import ElementosSistemas.Livro;

public class ObserverProfessor extends ObserverBehavior {
    
    public ObserverProfessor(){
        super();
    }

    @Override
    public void Update(Livro l) {
        VezesNotificado++;
    }

    @Override
    public void MostrarInfo() {
        System.out.println("Notificado " + VezesNotificado + " vezes");
    }
    
}
