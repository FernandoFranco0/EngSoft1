package EmprestimoState;

import ElementosSistemas.Emprestimo;
import ElementosSistemas.Exemplar;
import ElementosSistemas.Livro;
import ElementosSistemas.Usuario;

public interface EmprestimoBehavior {
    public String Alugar(Usuario Usuario, Livro Livro);
    public String Devolver(Usuario Usuario, Livro Livro);
    public String Reservar(Usuario Usuario, Livro Livro);
    public Emprestimo CriarEmprestimo(Usuario Usuario, Exemplar Exemplar);
}
