package Comandos;

import ElementosSistemas.BibliotecaFacade;

public class CSair implements CComando {

    
    public String Executar(String ParamOne, String ParamTwo) {
        return BibliotecaFacade.ObterInstancia().Sair();
    }
    
}
