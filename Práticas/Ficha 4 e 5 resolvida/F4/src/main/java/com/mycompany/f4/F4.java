/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.f4;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jlope
 */
public class F4 {

    public static void main(String[] args) throws IOException {
        String fileIn = "livro.txt";

        ArrayList<String> codes = new ArrayList<>();
//            codes.add("9789897224607");
//            codes.add("9789722000321");
//            codes.add("9789722126052");
//            codes.add("9789722038942");
            codes.add("9789897226755");
//            codes.add("9789722063883");
//            codes.add("9789722129220");
//            codes.add("9789722532877");
//            codes.add("9789892314044");
//            codes.add("9789722533492");
//            codes.add("9789892348568");
//            codes.add("9789899039353");
//            codes.add("9789898857071");
//            codes.add("9789722055932");
//            codes.add("9788416987719");
        
        ArrayList<Livro> livs = new ArrayList<>(); 
        for(int i = 0; i < codes.size(); ++i){
            livs.add(Livro.criaLivro(codes.get(i), fileIn));
        }
        
        for(Livro itr: livs){
            itr.printLivro();
            System.out.println("");
        }
        
        
        
    }
    
    
    
}
