package Decorator.Base;

public class PosGrad extends Aluno {

    public PosGrad() {
        super();
        this.MaxDiasEmprestados = 4;
    }

    @Override
    public String getNome(){
        return "PosGrad ";
    };
    
}
