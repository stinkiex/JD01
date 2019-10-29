public class Task1 {
    public static void task1(){
        int a= (int)(1+Math.random()*999);
        double resultD, c = (1+Math.random()*999);
        int result, b=0;
//try-catch:
        try {
            result = a / b;
            System.out.println(result);
        }catch (ArithmeticException e){
            System.out.println("TRY and CATCH На ноль делить нельзя\n");
        }
//try-finally:
        try {
            resultD = c / b; // При делении на ноль типа  double результатом буде бесконечность (INFINITY)
            System.out.println(resultD); }
        finally {
            System.out.println("TRY and FINALLY Вот такой вот результат\n");
        }
//try-catch-finally
        try {
            result = a / b;
            System.out.println(result);
        }catch (ArithmeticException e){
            System.out.println("TRY and CATCH and FINALLY На ноль делить нельзя");
        }finally {
            System.out.println("TRY and CATCH and FINALLY Вот такой вот результат\n");
        }
    }
}
