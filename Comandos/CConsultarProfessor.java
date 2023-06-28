package Comandos;

import ElementosSistemas.BibliotecaFacade;

public class CConsultarProfessor implements CComando {

    
    public String Executar(String ParamOne, String ParamTwo) {
        return BibliotecaFacade.ObterInstancia().ConsultarProfessor(Integer.parseInt(ParamOne));
    }
    
}
