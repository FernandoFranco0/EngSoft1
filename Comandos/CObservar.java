package Comandos;

import ElementosSistemas.BibliotecaFacade;

public class CObservar implements CComando {

    public String Executar(String ParamOne, String ParamTwo) {
        return BibliotecaFacade.ObterInstancia().Observar((Integer.parseInt(ParamOne)), (Integer.parseInt(ParamTwo)));
    }
    
}
