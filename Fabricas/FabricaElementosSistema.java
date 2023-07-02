package Fabricas;

import java.time.LocalDate;
import java.util.List;

import Decorator.Manager.EmprestimoBehavior;
import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Reserva;
import ElementosSistemas.Usuario;
import Observer.ObserverBehavior;

public class FabricaElementosSistema {

    static public Reserva NovaReserva(Livro livro, Usuario usuario, LocalDate data){
        return new Reserva(livro, usuario, data);
    }

    static public Emprestimo NovoEmprestimo(Usuario usuario, Exemplar exemplar, LocalDate dataEmprestimo, LocalDate dataDevolucao){
        return new Emprestimo(usuario, exemplar, dataEmprestimo, dataDevolucao);
    }

    static public Livro NovoLivro(int id, String titulo, String editora, int edicao, List<String> autores, int anoPublicacao){
        return new Livro(id, titulo, editora, edicao, autores, anoPublicacao);
    }

    static public Exemplar NovoExemplar(int id, Livro livro){
        return new Exemplar(id, livro);
    }

    static public Usuario NovoUsuario(int id, String nome, ObserverBehavior observerManager,EmprestimoBehavior emprestimoManager){
        return new Usuario(id, nome, observerManager, emprestimoManager);
    }
}
