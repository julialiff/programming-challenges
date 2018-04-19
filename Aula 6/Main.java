import java.util.Scanner;

class Main
{
    public static void main (String args[])
    {
        int x = 0;
        Scanner scan = new Scanner (System.in);
        while (scan.hasNext()){
            x = scan.nextInt();
            if (x==0) break;
            executar(x);
        }
    }

    static void executar(int totalCidades){
        int m = 0;
        boolean continua = true;
        while(continua) {
            m++;
            continua = testaM(m, totalCidades);
        }
        System.out.println("" + m);
    }

    static boolean testaM(int m, int acesas){
        int apagar = 1;
        int wellington = 13;
        while(acesas > 1) {
            if (apagar == wellington) return true;
            if (apagar < wellington) wellington--;
            apagar--;
            acesas--;
            //atualiza qual sera apagada
            apagar = (apagar + m) % acesas;
            if (apagar == 0) apagar = acesas;
            if(apagar < 0) apagar = 1;

        }
        // return true caso wellington nao seja a ultima
        return false;
    }
}