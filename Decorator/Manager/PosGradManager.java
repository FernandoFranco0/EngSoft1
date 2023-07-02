package Decorator.Manager;

import Fabricas.FabricaDecorator;

public class PosGradManager extends AlunoManager {

    public PosGradManager(){
        this.Base = FabricaDecorator.NovoPosGrad();
        this.EmprestimoMax = 4;
    }
}
