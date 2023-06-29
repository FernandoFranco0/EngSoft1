package ElementosSistemas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import StrategyObserver.Decorator.Manager.GradManager;
import StrategyObserver.Decorator.Manager.PosGradManager;
import StrategyObserver.Decorator.Manager.ProfessorManager;
import StrategyObserver.Observer.ObserverBehavior;
import StrategyObserver.Observer.ObserverNada;
import StrategyObserver.Observer.ObserverProfessor;


public class Dados {
    private HashMap<Integer,Usuario> HashUsuario;
    private HashMap<Integer,Livro> HashLivros;
    private List<Reserva> ListaReservas;

    // Padrão Singleton
    private static Dados Instancia;
    private Dados(){
        CarregarLivros();
        CarregarUsuarios();
        ListaReservas = new ArrayList<Reserva>();
    }
    
    public static Dados ObterInstancia(){
        if(Instancia == null)
            Instancia = new Dados();
        
        return Instancia;
    }

    public Usuario getUsuario(int Id){
        return HashUsuario.get(Id);
    }

    public Livro getLivro(int Id){
        return HashLivros.get(Id);
    }

    public void CarregarLivros(){

        ArrayList<String> autores = new ArrayList<String>();
        autores.add("Ian Sommervile");

        Livro L = new Livro(100, "Engenharia de Software", "AddisonWesley", 6, autores, 2000);

        ArrayList<Exemplar> Exemplares = new ArrayList<Exemplar>();

        Exemplares.add(new Exemplar(1, L));        
        Exemplares.add(new Exemplar(2, L));

        L.setListaExemplarDisponiveis(Exemplares);

        HashLivros.put(100, L);
        
        // --------------------------------------------------------------------------------------------------------
        
        autores = new ArrayList<String>();
        autores.add("Grady Booch");
        autores.add("James Rumbaugh");
        autores.add("Ivar Jacobson");

        L = new Livro(101, "UML - Guia do Usuário" ,"Campus", 7, autores, 2000);

        Exemplares = new ArrayList<Exemplar>();

        Exemplares.add(new Exemplar(3, L));

        L.setListaExemplarDisponiveis(Exemplares);

        HashLivros.put(101, L);
        
        // --------------------------------------------------------------------------------------------------------

        autores = new ArrayList<String>();
        autores.add("Steve McConnell");

        L = new Livro(200, "Code Complete", "Microsoft Press", 2, autores, 2014);

        Exemplares = new ArrayList<Exemplar>();

        Exemplares.add(new Exemplar(4, L));        

        L.setListaExemplarDisponiveis(Exemplares);

        HashLivros.put(200, L);
        
        // --------------------------------------------------------------------------------------------------------

        autores = new ArrayList<String>();
        autores.add("Robert Martin");

        L = new Livro(201, "Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall", 1, autores, 2002);

        Exemplares = new ArrayList<Exemplar>();
  
        Exemplares.add(new Exemplar(5, L));

        L.setListaExemplarDisponiveis(Exemplares);

        HashLivros.put(201, L);
        
        // --------------------------------------------------------------------------------------------------------

        autores = new ArrayList<String>();
        autores.add("Martin Fowler");

        L = new Livro(300, "Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", 1, autores, 1999);

        Exemplares = new ArrayList<Exemplar>();

        Exemplares.add(new Exemplar(6, L));        
        Exemplares.add(new Exemplar(7, L));

        L.setListaExemplarDisponiveis(Exemplares);

        HashLivros.put(300, L);
        
        // --------------------------------------------------------------------------------------------------------

        autores = new ArrayList<String>();
        autores.add("Norman Fenton");
        autores.add("James Bieman");

        L = new Livro(301, "Software Metrics: A Rigorous and Practical Approach", "CRC Press", 3, autores, 2014);

        Exemplares = new ArrayList<Exemplar>();

        L.setListaExemplarDisponiveis(Exemplares);

        HashLivros.put(301, L);
        
        // --------------------------------------------------------------------------------------------------------

        autores = new ArrayList<String>();
        autores.add("Erich Gamma");
        autores.add("Richard Helm");
        autores.add("Ralph Johnson");
        autores.add("John Vlissides");


        L = new Livro(400, "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional", 1, autores, 1994);

        Exemplares = new ArrayList<Exemplar>();

        Exemplares.add(new Exemplar(8, L));        
        Exemplares.add(new Exemplar(9, L));

        L.setListaExemplarDisponiveis(Exemplares);

        HashLivros.put(400, L);
        
        // --------------------------------------------------------------------------------------------------------

        autores = new ArrayList<String>();
        autores.add("Martin Fowler");

        L = new Livro(401, "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison-Wesley Professional", 3, autores, 2003);

        Exemplares = new ArrayList<Exemplar>();

        L.setListaExemplarDisponiveis(Exemplares);

        HashLivros.put(401, L);
        
        // --------------------------------------------------------------------------------------------------------

    }

    public void CarregarUsuarios(){
        HashUsuario.put(123, new Usuario(123, "João da Silva", new ObserverNada(), new GradManager() ) );
        HashUsuario.put(456, new Usuario(456, "Luiz Fernando Rodrigues", new ObserverNada(), new PosGradManager() ) );
        HashUsuario.put(789, new Usuario(789, "Pedro Paulo", new ObserverNada(), new GradManager() ) );        
        HashUsuario.put(100, new Usuario(100, "Professor", new ObserverProfessor(), new ProfessorManager() ) );
    }



    // --------------------------getters and setters-------------------------

    public HashMap<Integer, Usuario> getHashUsuario() {
        return HashUsuario;
    }
    public void setHashUsuario(HashMap<Integer, Usuario> hashUsuario) {
        HashUsuario = hashUsuario;
    }
    
    public HashMap<Integer, Livro> getHashLivros() {
        return HashLivros;
    }
    public void setHashLivros(HashMap<Integer, Livro> hashLivros) {
        HashLivros = hashLivros;
    }
    
    public List<Reserva> getListaReservas() {
        return ListaReservas;
    }
    public void setListaReservas(List<Reserva> listaReservas) {
        ListaReservas = listaReservas;
    } 
}
