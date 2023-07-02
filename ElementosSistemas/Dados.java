package ElementosSistemas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Fabricas.FabricaDecorator;
import Fabricas.FabricaElementosSistema;
import Fabricas.FabricaObserver;


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

        Livro L = FabricaElementosSistema.NovoLivro(100, "Engenharia de Software", "AddisonWesley", 6, autores, 2000);

        ArrayList<Exemplar> Exemplares = new ArrayList<Exemplar>();

        Exemplares.add(FabricaElementosSistema.NovoExemplar(1, L));        
        Exemplares.add(FabricaElementosSistema.NovoExemplar(2, L));

        L.setListaExemplarDisponiveis(Exemplares);

        HashLivros.put(100, L);
        
        // --------------------------------------------------------------------------------------------------------
        
        autores = new ArrayList<String>();
        autores.add("Grady Booch");
        autores.add("James Rumbaugh");
        autores.add("Ivar Jacobson");

        L = FabricaElementosSistema.NovoLivro(101, "UML - Guia do Usuário" ,"Campus", 7, autores, 2000);

        Exemplares = new ArrayList<Exemplar>();

        Exemplares.add(FabricaElementosSistema.NovoExemplar(3, L));

        L.setListaExemplarDisponiveis(Exemplares);

        HashLivros.put(101, L);
        
        // --------------------------------------------------------------------------------------------------------

        autores = new ArrayList<String>();
        autores.add("Steve McConnell");

        L = FabricaElementosSistema.NovoLivro(200, "Code Complete", "Microsoft Press", 2, autores, 2014);

        Exemplares = new ArrayList<Exemplar>();

        Exemplares.add(FabricaElementosSistema.NovoExemplar(4, L));        

        L.setListaExemplarDisponiveis(Exemplares);

        HashLivros.put(200, L);
        
        // --------------------------------------------------------------------------------------------------------

        autores = new ArrayList<String>();
        autores.add("Robert Martin");

        L = FabricaElementosSistema.NovoLivro(201, "Agile Software Development, Principles, Patterns, and Practices", "Prentice Hall", 1, autores, 2002);

        Exemplares = new ArrayList<Exemplar>();
  
        Exemplares.add(FabricaElementosSistema.NovoExemplar(5, L));

        L.setListaExemplarDisponiveis(Exemplares);

        HashLivros.put(201, L);
        
        // --------------------------------------------------------------------------------------------------------

        autores = new ArrayList<String>();
        autores.add("Martin Fowler");

        L = FabricaElementosSistema.NovoLivro(300, "Refactoring: Improving the Design of Existing Code", "Addison-Wesley Professional", 1, autores, 1999);

        Exemplares = new ArrayList<Exemplar>();

        Exemplares.add(FabricaElementosSistema.NovoExemplar(6, L));        
        Exemplares.add(FabricaElementosSistema.NovoExemplar(7, L));

        L.setListaExemplarDisponiveis(Exemplares);

        HashLivros.put(300, L);
        
        // --------------------------------------------------------------------------------------------------------

        autores = new ArrayList<String>();
        autores.add("Norman Fenton");
        autores.add("James Bieman");

        L = FabricaElementosSistema.NovoLivro(301, "Software Metrics: A Rigorous and Practical Approach", "CRC Press", 3, autores, 2014);

        Exemplares = new ArrayList<Exemplar>();

        L.setListaExemplarDisponiveis(Exemplares);

        HashLivros.put(301, L);
        
        // --------------------------------------------------------------------------------------------------------

        autores = new ArrayList<String>();
        autores.add("Erich Gamma");
        autores.add("Richard Helm");
        autores.add("Ralph Johnson");
        autores.add("John Vlissides");


        L = FabricaElementosSistema.NovoLivro(400, "Design Patterns: Elements of Reusable Object-Oriented Software", "Addison-Wesley Professional", 1, autores, 1994);

        Exemplares = new ArrayList<Exemplar>();

        Exemplares.add(FabricaElementosSistema.NovoExemplar(8, L));        
        Exemplares.add(FabricaElementosSistema.NovoExemplar(9, L));

        L.setListaExemplarDisponiveis(Exemplares);

        HashLivros.put(400, L);
        
        // --------------------------------------------------------------------------------------------------------

        autores = new ArrayList<String>();
        autores.add("Martin Fowler");

        L = FabricaElementosSistema.NovoLivro(401, "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison-Wesley Professional", 3, autores, 2003);

        Exemplares = new ArrayList<Exemplar>();

        L.setListaExemplarDisponiveis(Exemplares);

        HashLivros.put(401, L);
        
        // --------------------------------------------------------------------------------------------------------

    }

    public void CarregarUsuarios(){
        HashUsuario.put(123, FabricaElementosSistema.NovoUsuario(123, "João da Silva", FabricaObserver.NovoObserverNada(), FabricaDecorator.NovoGradManager() ) );
        HashUsuario.put(456, FabricaElementosSistema.NovoUsuario(456, "Luiz Fernando Rodrigues", FabricaObserver.NovoObserverNada(), FabricaDecorator.NovoPosGradManager() ) );
        HashUsuario.put(789, FabricaElementosSistema.NovoUsuario(789, "Pedro Paulo", FabricaObserver.NovoObserverNada(), FabricaDecorator.NovoGradManager() ) );        
        HashUsuario.put(100, FabricaElementosSistema.NovoUsuario(100, "Professor", FabricaObserver.NovoObserverProfessor(), FabricaDecorator.NovoProfessorManager() ) );
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
