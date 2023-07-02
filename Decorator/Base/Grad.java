package Decorator.Base;

public class Grad extends Aluno {

    public Grad() {
        super();
        this.MaxDiasEmprestados = 3;
    }

    @Override
    public String getNome(){
        return "Grad ";
    };
    
}
