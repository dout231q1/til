import java.time.LocalDate;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;

    public Livro(String titulo, String autor, LocalDate dataPublicacao){
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public LocalDate getDate() {
        return dataPublicacao;
    }
    public void setDate(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public String toString(){
        return titulo + " - " + autor + " - " + "(" + dataPublicacao + ")";
    }
}
