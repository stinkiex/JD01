import java.util.*;

public class Task3 {
    public static void task3() {
        System.out.println("\n\nСортировщик целых чисел. Целое число - число типа INT и меньше чем  2.147.483.647");
            int[] numbers = new int[0];
            Scanner sc = new Scanner(System.in);
            int error=0;
        for (int i = 0; ; i++) {
                numbers = Arrays.copyOf(numbers,numbers.length+1);
                System.out.println("\nВведите "+(i+1)+"-e ЦЕЛОЕ число.");
                if (error<3){
                    try {
                        numbers[i] = Integer.parseInt(sc.nextLine());
                    }catch(InputMismatchException|NumberFormatException e1){
                        System.out.println("Вы ввели не целое число. Количество оставшихся ошибок: "+(2-error));
                        numbers = Arrays.copyOf(numbers,numbers.length-1);
                        error++;
                        i--;
                    }
                }else {
                    sc.close();
                    break;
                }
        }

        System.out.println("введено " +(numbers.length-1)+" чисел");
        ArrayList<Integer> list =new ArrayList<Integer>(numbers.length);
        for(int i=0;i<(numbers.length-1);i++){
            list.add(numbers[i]);
        }
        Collections.sort(list);
        Collections.reverse(list);
        for (int i=0; i<list.size();i++) {
            System.out.println(list.get(i));
        }



    }

}
