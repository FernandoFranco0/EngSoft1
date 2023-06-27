package ElementosSistemas;

import java.time.LocalDate;

public class Reserva {
    private Livro Livro;
    private Usuario Usuario;
    private LocalDate Data;
    

    public Reserva(Livro livro, Usuario usuario, LocalDate data) {
        Livro = livro;
        Usuario = usuario;
        Data = data;
    }

    public LocalDate getData() {
        return Data;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public String getLivroNome(){
        return Livro.getTitulo();
    }
}
