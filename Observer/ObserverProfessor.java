package Observer;

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
    public String MostrarInfo() {
        return "Notificado " + VezesNotificado + " vezes" ;
    }
    
}
