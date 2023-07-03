import ElementosSistemas.BibliotecaFacade;

public class Programa {
    public static void main(String[] args) {
        BibliotecaFacade b = BibliotecaFacade.ObterInstancia();

        b.Run();
    }
}