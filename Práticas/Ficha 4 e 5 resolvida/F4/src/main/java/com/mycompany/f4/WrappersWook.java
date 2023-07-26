/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.f4;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author jlope
 */
public class WrappersWook {

    public static double obtem_preco2(String isbn,String fileIn) throws IOException {
        String link = "https://www.wook.pt/pesquisa/";
        HttpRequestFunctions.httpRequest1(link, isbn, "wook.txt");
        String er = "<span class=\"price-rpl\">([^€]+)€</span> corresponde ao preço de venda em wook.pt";
        return Double.parseDouble(WrappersBase.matchIntoString(er, "wook.txt").replaceAll(",", "."));
    }

}