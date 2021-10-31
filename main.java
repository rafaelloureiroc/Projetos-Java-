
package com.mycompany.principal;

import java.util.Scanner;

public class main {
    private static String[] nomes;
	private static float[] AV1;
	private static float[] AV2;
	
	
	private static int qtde = 0;

	private static final int QTDE_MAX = 100;
        private static final int valor_media = 2;
	
	
	private static void impressao(){
		System.out.println("---- notas dos alunos ----");
		for (int j = 0; j < qtde; j++) {
			impressao(j);
		}
		System.out.println("-----------------------------------");
	}
	
	private static float media(int idx){
		return (AV1[idx] + AV2[idx]) / valor_media;
	}
	
	private static String obterSituacao(float media){
		if (media < 4){
                        return "Reprovado";
                }
                if (media >= 4 && media < 7){
                        return "Prova final";
                }
        return "Aprovado";
        }
	
	private static void impressao(int index){
		float media = media(index);
		
		String situacao = obterSituacao(media);		

		System.out.println(
				index + " - " + 
				"Nome: " + nomes[index] + " - " + 
				"AV1: " + AV1[index] + " - " + 
				"AV2: " + AV2[index] + " - " +
				"Media: " + media + " - " +
				situacao
				);
	}
	
	public static void main(String[] args){

		nomes = new String[QTDE_MAX];
		AV1 = new float[QTDE_MAX];
		AV2 = new float[QTDE_MAX];
                
		int opcao = 0;
		
		Scanner in = new Scanner(System.in);

		do {
			System.out.println("[1] Registrar as notas de um novo aluno");
			System.out.println("[2] Consultar boletim de um aluno.");
			System.out.println("[3] Consultar notas da turma.");
			System.out.println("[4] Sair");
			System.out.println("Informe a opção desejada: ");
			opcao = in.nextInt();
                        
                        

			switch (opcao) {
			case 1:
				if(qtde < QTDE_MAX) {
					System.out.println("Informe o seu nome: ");
					nomes[qtde] = in.next();
					
					System.out.println("Informe a sua nota AV1: ");
					AV1[qtde] = in.nextFloat();
					
					System.out.println("Informe a sua nota AV2: ");
					AV2[qtde] = in.nextFloat();
					
					impressao(qtde);
					
					qtde++;
				} else {
					System.out.println("Impossível realizar o cadastramento!!!");
				}
				break;

			case 2:
				System.out.println("Informe o código do aluno: ");
				int codigo = in.nextInt();

				if(codigo >= 0 && codigo < qtde) {
					impressao(codigo);
				} else {
					System.out.println("O código " + codigo + " é inválido!!");
				}				
				break;

			case 3:
				impressao();			
				break;

			case 4:
				System.out.println("sair");
				break;

			default:
				System.out.println("Opção inválida!!!");
				break;
			}			
		} while (opcao != 4);
		
		in.close();
		
		System.out.println("Período finalizado !");
     
        }  
}
