package StrategyObserver.Observer;

import ElementosSistemas.Livro;

public class ObserverNada extends ObserverBehavior {

    public ObserverNada(){
        super();
    }

    @Override
    public void Update(Livro l) {}


    @Override
    public String MostrarInfo() { return "";}
    
}
