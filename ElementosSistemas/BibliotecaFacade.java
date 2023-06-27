package ElementosSistemas;
import java.util.*;
import Comandos.*;

public class BibliotecaFacade{
    
    private Dados db;
    private HashMap<String, CComando> HashComando;
    private boolean Running;
    
    // Padrão Singleton
    private static BibliotecaFacade Instancia;
    private BibliotecaFacade(){
        db = Dados.ObterInstancia();

        HashComando = new HashMap<String,CComando>();
        HashComando.put("liv",new CConsultarLivro());
        HashComando.put("ntf",new CConsultarProfessor());
        HashComando.put("usu",new CConsultarUsuario());        
        HashComando.put("emp",new CEmprestimo());
        HashComando.put("dev",new CDevolver());
        HashComando.put("obs",new CObservar());
        HashComando.put("res",new CReservar());
        HashComando.put("sai",new CSair());
    }
    public static BibliotecaFacade ObterInstancia(){
        if(Instancia == null)
            Instancia = new BibliotecaFacade();
        
        return Instancia;
    }
    //
    
    public void CarregarLivros(){

    }

    public void CarregarUsuarios(){

    }
    
    public void Run(){
        Running = true;
        while(Running)
            ExecutarComando();
    }

    public void Stop(){
        Running = false;
    }

    public void ExecutarComando(){
        Console C = new Console();
        String Entrada = C.Ler();
        String[] Params = Entrada.split(" ", 2);

        String Msg = HashComando.get(Params[0]).Executar(Params[1]);
        C.Exibir(Msg);
    }

    
    
}