package Decorator.Manager;

import Fabricas.FabricaDecorator;

public class GradManager extends AlunoManager {

    public GradManager(){
        this.g = FabricaDecorator.NovoGrad();
        this.EmprestimoMax = 3;
    }
    
}
