/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package id.ficha3;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author BrunoOliveira
 */
public class Ficha3 {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        ficha3b("datas.txt","out.txt");
        ficha3c("ficheiro3.txt","novo.txt");
        Scanner palavra = new Scanner(System.in);
        String palavra;
        System.out.println("Palavra a procurar: ");
        Palavra = palavra.nextLine();
        ArrayList res = Wrappers.procura_nomes(palavra);
        System.out.println(res);
    }
    public static void ficha3a(){
        String telef = "919191919 929992221 91111111111 239494582 9199999999 967779999";
        String er = "\\b91|92|93|96[0-9]{7}\\b";
        Pattern p = Pattern.compile(er);
        Matcher m = p.matcher(telef);
        while(m.find()){
            System.out.println("Numero de telemovel: " + m.group() + "\n");
        } 
    }
    public static void ficha3b(String fileIn, String fileOut) throws FileNotFoundException, IOException{
        
        Scanner ler = new Scanner(new FileInputStream(fileIn));
        BufferedWriter out = new BufferedWriter(new FileWriter(fileOut));
        String er = "\\b[0-9]{2}[-/]{2}[-/][0-9]{4}\\b";
        String linha;
        Pattern p = Pattern.compile(er);
        while (ler.hasNextLine()){
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            while (m.find()){
                System.out.println("Data Valida: " + m.group() + "\n");
            }
        } 
        ler.close();
        out.close();
    } 
    public static void ficha3c(String fileIn, String fileOut) throws FileNotFoundException, IOException{
        Scanner ler = new Scanner(new FileInputStream(fileIn));
        BufferedWriter out = new BufferedWriter(new FileWriter(fileOut));
        String linha;
        String result = null;
        String er = "\\b[a-zA-Zéá]*(ch)[a-zA-Zéá]*\\b";
        Pattern p = Pattern.compile(er);
        int conta = 0;
        while (ler.hasNextLine()){
            linha = ler.nextLine();
            Matcher m = p.matcher(linha);
            while (m.find()){
                conta++;
                result = linha.replace(m.group(1),"X");
            }out.write(result);
        } 
        out.write("Foram encontradas "+ conta + " substituições");
        ler.close();
        out.close();   
    }
}



