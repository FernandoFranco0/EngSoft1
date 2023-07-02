package Fabricas;

import Observer.ObserverNada;
import Observer.ObserverProfessor;

public class FabricaObserver {

    static public ObserverNada NovoObserverNada(){
        return new ObserverNada();
    }

    static public ObserverProfessor NovoObserverProfessor(){
        return new ObserverProfessor();
    }
}
