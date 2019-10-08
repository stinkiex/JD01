import java.util.Scanner;

public class MultiplicationTable {
    public int x;


    public static void multiplicationTable(int x){
        int multy=1; //ПРоизведение цифр числа "Х";
        int x2 = x; //
        int[] num2 = new int[10];
        for (int i=0; i<=9;i++){
          num2[i]=i+1;
        }
        for (int i=0;i<x ; i++){
            for(int j=0;j<10;j++){
            System.out.print((i+1) +" x "+num2[j]+" = "+ (i+1)*num2[j]+"\t");
            }
            System.out.println("\n");
        }
        int num2length=(int)String.valueOf(x).length();
        int[] digits = new int[num2length];
        for(int i=0; i<num2length;i++){
            digits[i]= x%10;
            x=x/10;
            multy=multy*digits[i];
            System.out.print("После "+ (i+1)+" перемножения произведение цифр числа "+ x2 +" = "+multy+"\n");
        }
        System.out.println("\nПроизведение  цифр числа "+x2+" равно "+multy);

    }

}
