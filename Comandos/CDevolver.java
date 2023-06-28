package Comandos;

import ElementosSistemas.BibliotecaFacade;

public class CDevolver implements CComando {

    public String Executar(String ParamOne, String ParamTwo) {
        return BibliotecaFacade.ObterInstancia().Devolver((Integer.parseInt(ParamOne)), (Integer.parseInt(ParamTwo)));
    }

}
