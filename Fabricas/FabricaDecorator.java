package Fabricas;

import Decorator.Status.*;
import Decorator.Base.*;
import Decorator.Manager.*;


public class FabricaDecorator {

    static public Devedor NovoDevedor(AbstractBase b){
        return new Devedor(b);
    }

    static public EmprestimoMax NovoEmprestimoMax(AbstractBase b){
        return new EmprestimoMax(b);
    }

    static public ReservaMax NovoReservaMax(AbstractBase b){
        return new ReservaMax(b);
    }

    static public Grad NovoGrad(){
        return new Grad();
    }

    static public PosGrad NovoPosGrad(){
        return new PosGrad();
    }

    static public Professor NovoProfessor(){
        return new Professor();
    }

    static public GradManager NovoGradManager(){
        return new GradManager();
    }

    static public PosGradManager NovoPosGradManager(){
        return new PosGradManager();
    }

    static public ProfessorManager NovoProfessorManager(){
        return new ProfessorManager();
    }
}
