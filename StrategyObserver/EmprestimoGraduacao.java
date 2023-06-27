package StrategyObserver;

import ElementosSistemas.Livro;
import ElementosSistemas.Usuario;

public class EmprestimoGraduacao implements EmprestimoBehavior {

    public void Alugar(Usuario Usuario, Livro Livro) {
        // if Exemplar disponivel
        // jeito facil de fazer é utilizar 2 listas em livro de sobre os exemplares ocupados ou não mas ai não usa o state

        // for Emprestimo in Usuario, chegar se ta atrasado -> manter variavel dia atual ?

        
    }
    

    public void Devolver(Usuario Usuario, Livro Livro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Devolver'");
    }
    
}
