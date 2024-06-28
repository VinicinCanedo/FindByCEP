package br.com.viacep.main;

import br.com.viacep.models.ConsultaCep;
import br.com.viacep.models.Endereco;
import br.com.viacep.models.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ConsultaCep consulta = new ConsultaCep();


        System.out.println("Digite o CEP do endereço desejado: ");
        String digiteCep = sc.next();


        try{
            Endereco novoEndereco = consulta.buscaEndereco(digiteCep);
            System.out.println(novoEndereco);
            GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
            geradorDeArquivo.salvaJson(novoEndereco);

        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando Consulta");
        }


    sc.close();
    }
}
