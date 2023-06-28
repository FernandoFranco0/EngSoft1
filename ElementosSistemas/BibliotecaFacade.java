package ElementosSistemas;
import java.util.*;
import Comandos.*;

public class BibliotecaFacade{
    
    private boolean Running;
    private Dados Registros;
    private HashMap<Integer,Usuario> HashUsuario;
    private HashMap<Integer,Livro> HashLivros;
    private List<Reserva> ListaReservas;

    // Padrão Singleton
    private static BibliotecaFacade Instancia;

    private BibliotecaFacade(){
        Registros = Dados.ObterInstancia();
    }

    public static BibliotecaFacade ObterInstancia(){
        if(Instancia == null)
            Instancia = new BibliotecaFacade();
        
        return Instancia;
    }
    
    public void Run(){
        Running = true;
        Console C = new Console();

        while(Running)
            C.LerExecutar();
            
    }

    public String ConsultarLivro(int ParamOne){
        Livro L = Registros.getLivro(ParamOne);
        return L.ComandoLiv();
    }
    
    public String ConsultarProfessor(int ParamOne){
        Usuario U = Registros.getUsuario(ParamOne);
        return U.ComandoNtf();
    }

    public String ConsultarUsuario(int ParamOne){
        Usuario U = Registros.getUsuario(ParamOne);
        return U.ComandoUsu();
    }

    public String Devolver(int ParamOne, int ParamTwo){
        Usuario U = Registros.getUsuario(ParamOne);
        Livro L = Registros.getLivro(ParamTwo);

        return U.Devolver(L);
    }

    public String Emprestimo(int ParamOne, int ParamTwo){
        Usuario U = Registros.getUsuario(ParamOne);
        Livro L = Registros.getLivro(ParamTwo);

        return U.Alugar(L);

    }

    public String Observar(int ParamOne, int ParamTwo){
        Usuario U = Registros.getUsuario(ParamOne);
        Livro L = Registros.getLivro(ParamTwo);

        return L.registerObserver(U.getObserverManager());
    }

    public String Reservar(int ParamOne, int ParamTwo){
        Usuario U = Registros.getUsuario(ParamOne);
        Livro L = Registros.getLivro(ParamTwo);

        return U.Reservar(L);
    }

    public String Sair(){
        Running = false;
        return "Saiu com sucesso";
    }
    
    
}