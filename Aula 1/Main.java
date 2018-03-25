import java.util.Scanner;

class Main
{
    public static void main (String args[])
    {
      try{
          int i, j, x1, x2, tamAux, tam;
          Scanner scan = new Scanner (System.in);

          // se desejar, declare outras variaveis aqui
          while (scan.hasNext()){
            i = scan.nextInt();
            j = scan.nextInt();
            scan.nextLine();
              //TODO: ENTRADA LIDA, IMPLEMENTE AQUI O CODIGO PARA TRATAR x1 E x2
            if (i < j) {
              x1 = i;
              x2 = j;
            } else {
              x1 = j;
              x2 = i;
            }

          tam = 0;
          tamAux = 0;
          while(x1 <= x2){
            tamAux = tresN(x1);
            if (tamAux > tam) tam = tamAux;
            x1++;
          }
          System.out.println(i + " " + j + " " + tam);
      }
    } catch (Exception e){
      //
    }
  }

  public static int tresN(int n) {
    int cont = 0;
    while (n > 1) {
      if (n % 2 != 0) {
        n = 3 * n + 1;
      } else {
        n = n / 2;
      }
      cont++;
    }
    cont++;
    return cont;
  }

}
