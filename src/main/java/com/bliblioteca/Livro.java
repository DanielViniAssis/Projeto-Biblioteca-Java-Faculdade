package com.bliblioteca;
public class Livro{
    private String titulo;
    private String autor;
    private int paginas;
    private int anoDeLancamento;
    private boolean emprestado;

    public Livro(String titulo, String autor, int paginas, int anoDeLancamento){

        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.anoDeLancamento = anoDeLancamento;
        this.emprestado = false;
    }
    
    //get para salvar os dados
    public String getTitulo(){
        return titulo;
    }
    
    public String getAutor(){
        return autor;
    }
    
    public int getPaginas(){
        return paginas;
    }
    
    public int getAnoDeLancamento(){
        return anoDeLancamento;
    }

    public boolean isEmprestado(){
        return emprestado;
    }

    //set para editar dados
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setPaginas(int paginas){
        this.paginas = paginas;
    }

    public void setAnoDeLancamento(int anoDeLancamento){
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setEmprestado(boolean emprestado){
        this.emprestado = emprestado;
    }

}

