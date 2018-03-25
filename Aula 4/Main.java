import java.util.Scanner;

public class Main {

	//TODO : DADOS DO TERMINAL, nao esqueca de inicializa-los (se necessario)
	static char[][] terminal = new char[10][10];
	static int cursorX = 0;
	static int cursorY = 0;
	static boolean modoDeSobrescrita = true;

	public static void main (String args[]) 
	{
		Scanner scan = new Scanner (System.in);
		int N = scan.nextInt();
		int numeroDoTeste = 1;
		while (N != 0){
			String linha = scan.nextLine();
			cursorX = 0;
			cursorY = 0;
			iniciarTerminal();
			System.out.println("Case " + numeroDoTeste);
			for (int contLinhas = 0; contLinhas < N; contLinhas++){
				linha = scan.nextLine();
				executar(linha);
			}
			imprimirTerminal();
			modoDeSobrescrita = true;
			N = scan.nextInt();
			numeroDoTeste++;
		}
	}		  	

	static void iniciarTerminal(){
		for(int i=0; i < 10; i++){
			for(int j=0; j < 10; j++){
				terminal[i][j] = ' ';
			}
		}
	}

	static void imprimirTerminal(){
		System.out.println("+----------+");
		for (int i=0;i<10;i++){
			System.out.print("|");
			for (int j=0;j<10;j++){
				System.out.print(terminal[i][j]);
			}
			System.out.println("|");
		}
		System.out.println("+----------+");
	}

	static void escreverNoTerminal(char digito){
		if(modoDeSobrescrita){
			terminal[cursorX][cursorY] = digito;
		}else{
			for(int aux=9; aux > cursorY; aux --)// empurra
				terminal[cursorX][aux] = terminal[cursorX][aux-1];
			// escreve
			terminal[cursorX][cursorY] = digito;
		}
		if (cursorY < 9){
			cursorY++;
		}
	}

	static void executar(String linha){
		char chararray[] = linha.toCharArray();
		// System.out.println(linha);
		for(int i=0; i < chararray.length; i++){
			// System.out.println("i = " + i);
			if(chararray[i] == '^'){ // comando
				i++;
				if(chararray[i] >= '0' && chararray[i] <= '9'){
					cursorX = chararray[i] - '0';
					i++;
					cursorY = chararray[i] - '0';
				}else{
					switch(chararray[i]){
					case 'b': cursorY = 0; //inicio da linha atual
							  break;
					case 'c': iniciarTerminal();
							  break;
					case 'd': if(cursorX < 9) cursorX++; //mover uma linha para baixo
							  break;
					case 'e': for(int aux = cursorY; aux < 10; aux++) terminal[cursorX][aux] = ' '; // apaga o digito atual e os da direita da linha que estamos
							  break;
					case 'h': cursorX = 0; 
							  cursorY = 0;
							  break;
					case 'i': modoDeSobrescrita = false;
							  break;
					case 'l': if(cursorY > 0) cursorY--; //mover coluna para a esquerda
							  break;
					case 'o': modoDeSobrescrita = true;
					  		  break;
					case 'r': if(cursorY < 9) cursorY++; //mover coluna para a direita
							  break; 
					case 'u': if(cursorX > 0) cursorX--; //mover uma linha para cima 
							  break;
					case '^': escreverNoTerminal('^');
							  break;
					}
				}
				
			}else{ //coisas a escrever
				 escreverNoTerminal(chararray[i]);
			}
		}
	}
}