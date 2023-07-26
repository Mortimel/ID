/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package id.ficha2;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author BrunoOliveira
 */
public class Ficha2 {

    public static void main(String[] args) {
        
        Frame app = new Frame();
        app.setVisible(true);
    }
    static String ler_ficheiro(String nomeF) throws FileNotFoundException{
        String linha;
        StringBuilder texto = new StringBuilder(); //permite concatenar várias Strings
        Scanner input = new Scanner(new FileInputStream(nomeF));
        
        while ((input.hasNextLine())){
                
            linha = input.nextLine();
            texto.append(linha).append("\n");
            
        }
        input.close();
        return texto.toString(); //converter String «Builder para String
    }
    
    static void separa_ficheiro(String nomeF) throws FileNotFoundException, IOException{
        String linha;
        String []campos;
        Scanner input = new Scanner(new FileInputStream(nomeF));
        BufferedWriter mulheres = new BufferedWriter(new FileWriter("mulheres.txt"));
        BufferedWriter homens = new BufferedWriter(new FileWriter("homens.txt"));
        while ((input.hasNextLine())){
            //completar
            linha = input.nextLine();
            String []x = linha.split(";");
            if (x[2].equals("F"))
                mulheres.write(x[0]+ "\n");
            else 
                homens.write(x[0]+ "\n");
        }
        mulheres.close();
        homens.close();
        input.close();
    }   
    
    static double calcula_MediaIdade(String genero) throws FileNotFoundException{
        
        String linha;
        int soma = 0;
        int conta = 0;
        Scanner input = new Scanner(new FileInputStream("alunos.txt"));
        while ((input.hasNextLine())){
            linha = input.nextLine();
            String []x = linha.split(";");
            if (x[2].equals(genero)){
                
                conta++;
                soma = soma + Integer.parseInt(x[3]);   
            }
                  
        } 
        input.close();
        return soma/conta;
    }
}
