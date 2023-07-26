package id.Ficha1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author BrunoOliveira
 */
public class Ficha1 {

    public static void main(String[] args) {
        System.out.println("Ola Mundo;");
        minhafunc1();
        minhafunc2();

    }

    public static void minhafunc1(){
        Scanner dados = new Scanner(System.in) ;
        int idade;
        String nome;
        System.out.print("Introduza o seu nome: ");
        nome = dados.nextLine();
        System.out.print("Introduza a sua idade: ");
        idade = dados.nextInt();

        System.out.println("O meu nome é " + nome + " e tenho " + idade + " anos.");

    }


    public static void minhafunc2(){
        ArrayList<Aluno> turma = new ArrayList();
        Aluno a;
        String nome, local,genero;
        int idade, h = 0, m =0, somah =0, somam=0, num = 3;
        Scanner ler = new Scanner (System.in);
        for (int i =0; i < num; i++){
            System.out.print("Nome: ");
            nome = ler.nextLine();
            System.out.print("Local: ");
            local = ler.nextLine();
            System.out.print("Genero: ");
            genero = ler.nextLine();
            System.out.print("Idade: ");
            idade = ler.nextInt();
            a = new Aluno (nome, local, genero, idade);
            turma.add(a);
            if (genero.equals("F")){
                m++;
                somam += idade;
            }
            else {
                h++;
                somah += idade;
            }
        }
        for (int i= 0; i < num; i++){
            turma.get(i).imprime();
            System.out.println("Media idade mulheres: " + somah);
            System.out.println("Media idade homens: " + somam);
        }
    }
}