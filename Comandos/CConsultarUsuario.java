package Comandos;

import ElementosSistemas.BibliotecaFacade;

public class CConsultarUsuario implements CComando {

    
    public String Executar(String ParamOne, String ParamTwo) {
        return BibliotecaFacade.ObterInstancia().ConsultarUsuario(Integer.parseInt(ParamOne));
    }
    
}
