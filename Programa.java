import Decorator.*;
import Decorator.Base.AbstractBase;
import Decorator.Base.Grad;
import Decorator.Status.Devedor;

public class Programa {
    public static void main(String[] args) {
        AbstractBase g = new Grad();
        System.out.println(g.getNome());
        g = new Devedor(g);
        System.out.println(g.getNome());
        g = g.removeDevedor();
        System.out.println(g.getNome());
        g = g.removeDevedor();
        System.out.println(g.getNome());
    }
}