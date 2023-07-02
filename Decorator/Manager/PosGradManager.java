package Decorator.Manager;

import Fabricas.FabricaDecorator;

public class PosGradManager extends AlunoManager {

    public PosGradManager(){
        this.g = FabricaDecorator.NovoPosGrad();
        this.EmprestimoMax = 4;
    }
}
