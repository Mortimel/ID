/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.f4;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author jlope
 */
public class Livro {



    public Livro() {
        this.m_isbn = "";
        this.m_titulo = "";
        this.m_autor = "";
        this.m_preco_bertrand = 0;
    }

    public Livro(String m_isbn, String m_titulo, String m_autor, double m_preco) {
        this.m_isbn = m_isbn;
        this.m_titulo = m_titulo;
        this.m_autor = m_autor;
        this.m_preco_bertrand = m_preco;
    }

    public static Livro criaLivro(String isbn, String fileIn) throws FileNotFoundException, IOException {
        HttpRequestFunctions.httpRequest1("https://www.bertrand.pt/pesquisa/", isbn, fileIn);
        Livro retval = new Livro();
        retval.setM_isbn(isbn);
        retval.setM_titulo(WrappersBertrand.obtem_titulo(fileIn));
        retval.setM_autor(WrappersBertrand.obtem_autor(fileIn));
        retval.setM_preco_bertrand(WrappersBertrand.obtem_preco(fileIn));
        WrappersBertrand.obtem_link_e_acede_pagina_livro(fileIn);
        retval.setM_link_capa(WrappersBertrand.obtem_capa(fileIn));
        retval.setM_editora(WrappersBertrand.obtem_editora(fileIn));
        retval.setM_paginas(WrappersBertrand.obtem_paginas(fileIn));
        HttpRequestFunctions.httpRequest1("https://www.bertrand.pt/pesquisa/", isbn, fileIn);
        retval.setM_preco_wook(WrappersWook.obtem_preco2(isbn, fileIn));
        return retval;
    }

    public void printLivro() {
        System.out.println("isbn: " + this.getM_isbn());
        System.out.println("titulo: " + this.getM_titulo());
        System.out.println("autor: " + this.getM_autor());
        System.out.println("preco bertrand: " + this.getM_preco_bertrand() + "€");
        System.out.println("preco wook: "+this.getM_preco_wook()+"€");
        System.out.println("link capa: " + this.getM_link_capa());
        System.out.println("editora: " + this.getM_editora());
        System.out.println("paginas: " + this.getM_paginas());
        
    }

    
    public double getM_preco_bertrand() {
        return m_preco_bertrand;
    }

    public void setM_preco_bertrand(double m_preco_bertrand) {
        this.m_preco_bertrand = m_preco_bertrand;
    }

    public double getM_preco_wook() {
        return m_preco_wook;
    }

    public void setM_preco_wook(double m_preco_wook) {
        this.m_preco_wook = m_preco_wook;
    }
    
    public String getM_editora() {
        return m_editora;
    }

    public void setM_editora(String m_editora) {
        this.m_editora = m_editora;
    }

    public int getM_paginas() {
        return m_paginas;
    }

    public void setM_paginas(int m_paginas) {
        this.m_paginas = m_paginas;
    }

    public String getM_link_capa() {
        return m_link_capa;
    }

    public void setM_link_capa(String m_link_capa) {
        this.m_link_capa = m_link_capa;
    }

    public String getM_isbn() {
        return m_isbn;
    }

    public void setM_isbn(String m_isbn) {
        this.m_isbn = m_isbn;
    }

    public String getM_titulo() {
        return m_titulo;
    }

    public void setM_titulo(String m_titulo) {
        this.m_titulo = m_titulo;
    }

    public String getM_autor() {
        return m_autor;
    }

    public void setM_autor(String m_autor) {
        this.m_autor = m_autor;
    }

    private String m_isbn;
    private String m_titulo;
    private String m_autor;
    private double m_preco_bertrand;
    private double m_preco_wook;
    private String m_editora;
    private int m_paginas;
    private String m_link_capa;

}
