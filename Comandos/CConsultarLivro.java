package Comandos;

import ElementosSistemas.BibliotecaFacade;

public class CConsultarLivro implements CComando {

    public String Executar(String ParamOne, String ParamTwo) {
        return BibliotecaFacade.ObterInstancia().ConsultarLivro(Integer.parseInt(ParamOne));
    }    
    
}
