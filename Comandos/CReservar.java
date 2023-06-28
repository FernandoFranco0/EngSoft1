package Comandos;

import ElementosSistemas.BibliotecaFacade;

public class CReservar implements CComando {

    
    public String Executar(String ParamOne, String ParamTwo) {
        return BibliotecaFacade.ObterInstancia().Reservar((Integer.parseInt(ParamOne)), (Integer.parseInt(ParamTwo)));
    }
    
}
