/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ficha3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author BrunoOliveira
 */
public class Wrappers {
    static ArrayList procura_nomes(String procura) throws FileNotFoundException, IOException{
        String link = "https://eden.dei.uc.pt/~abs/ID/pessoas.html";
        String pesquisa ="";
        HttpRequestFunctions.httpRequest1(link, pesquisa, "pessoas.html");
        ArrayList lista = new ArrayList();
        Scanner input = new Scanner(new FileInputStream("pessoas.html"));
        String er = "<tr>\\s*<td\\s*>[0-9]+</td><td\\s*>([a-z-A-Z\\s]*)" + procura + "[a-zA-Z\\s]" ; 
        Pattern p = Pattern.compile(er);
        Matcher m;
        String linha;
        while((input.hasNextLine())){
            linha = input.nextLine();
            m = p.matcher(linha);
            if (m.find()){
                lista.add(m.group(1));
            }
        }
        input.close();
        return lista;
    }
    static ArrayList procura_por_cidade(String procura) throws FileNotFoundException{
        ArrayList lista = new ArrayList();
        Scanner input = new Scanner(new FileInputStream("pessoas.html"));
        String er = "<tr>\\s*<td\\s*>[0-9]+</td><td\\s*>([a-z-A-Z\\s]*)</td><td>[0-9]+</td><td>[a-zA-Z\\s]*" + procura + "[a-zA-Z\\s,]*</td>" ; 
        Pattern p = Pattern.compile(er);
        Matcher m;
        String linha;
        while((input.hasNextLine())){
            linha = input.nextLine();
            m = p.matcher(linha);
            if (m.find()){
                lista.add(m.group(1));
            }
        }
        input.close();
        return lista;
    }
    
    static String procura_nome_por_id(String procura) throws FileNotFoundException{      
        Scanner input = new Scanner(new FileInputStream("pessoas.html"));
        String er = "<tr>\\s*<td\\s*>" + procura + "+</td><td\\s*>[a-zA-Z\\s,]*</td>" ; 
        Pattern p = Pattern.compile(er);
        Matcher m;
        String linha;
        while((input.hasNextLine())){
            linha = input.nextLine();
            m = p.matcher(linha);
            if (m.find()){
                return(m.group(1));
            }
        }
        input.close();
        return null;
    }
    static String procura_cidade_por_id(String procura) throws FileNotFoundException{
        Scanner input = new Scanner(new FileInputStream("pessoas.html"));
        String er = "<tr>\\s*<td\\s*>" + procura + "+</td><td\\s*>[a-zA-Z\\s,]*</td>" ; //mudar a er para o da cidade
        Pattern p = Pattern.compile(er);
        Matcher m;
        String linha;
        while((input.hasNextLine())){
            linha = input.nextLine();
            m = p.matcher(linha);
            if (m.find()){
                return(m.group(1));
            }
        }
        input.close();
        return null;
    }
}
