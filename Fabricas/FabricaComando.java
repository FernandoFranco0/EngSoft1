package Fabricas;
import Comandos.*;

public class FabricaComando {
    
    static public CConsultarLivro NovoComandoConsultarLivro(){
        return new CConsultarLivro();
    }

    static public CConsultarProfessor NovoComandoConsultarProfessor(){
        return new CConsultarProfessor();
    }

    static public CConsultarUsuario NovoComandoConsultarUsuario(){
        return new CConsultarUsuario();
    }

    static public CEmprestimo NovoComandoEmprestimo(){
        return new CEmprestimo();
    }

    static public CDevolver NovoComandoDevolver(){
        return new CDevolver();
    }

    static public CObservar NovoComandoObservar(){
        return new CObservar();
    }

    static public CReservar NovoComandoReservar(){
        return new CReservar();
    }

    static public CSair NovoComandoSair(){
        return new CSair();
    }

}
