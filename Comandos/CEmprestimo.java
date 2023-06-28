package Comandos;

import ElementosSistemas.BibliotecaFacade;

public class CEmprestimo implements CComando {

    public String Executar(String ParamOne, String ParamTwo) {
        return BibliotecaFacade.ObterInstancia().Emprestimo((Integer.parseInt(ParamOne)), (Integer.parseInt(ParamTwo)));
    }
    
}
