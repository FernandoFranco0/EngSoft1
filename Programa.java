import StrategyObserver.Decorator.*;
import StrategyObserver.Decorator.Base.AbstractBase;
import StrategyObserver.Decorator.Base.Grad;
import StrategyObserver.Decorator.Status.Devedor;

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