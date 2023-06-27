package StrategyObserver.Observer;

import ElementosSistemas.Livro;

public abstract class ObserverBehavior {
    
    protected int VezesNotificado;

    protected ObserverBehavior() {
		VezesNotificado = 0;
	}

    abstract public void Update(Livro l);    
    abstract public void MostrarInfo();

}
