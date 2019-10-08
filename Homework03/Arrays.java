public class Arrays {

    public static void arrays(){
        int[]myArray = new int[(int)(2+Math.random()*20)];
        int length= myArray.length;
        int ii=0;
        for(int i=0;i<length;i++) {
            myArray[i] = (int) (1 + Math.random() * 20);
        }
        System.out.print("\n\nПереберём все элементы массива с for:");
        for (int i=1;i<length;i++) {
            System.out.println("Элемент №" + i + ": " + myArray[i]);
        }

        System.out.println("\nПереберём все элементы массива с while:");
        while(ii<length){
            System.out.println("Элемент №" + ii + ": " + myArray[ii]);
            ii++;
        }
        System.out.println("\nПереберём все элементы массива с do while:");
        ii=0;
                do {
            System.out.println("Элемент №" + ii + ": " + myArray[ii]);
            ii++;
        } while(ii<length);

        System.out.println("\nПереберём все элементы массива с foreach:");
        for (int j:myArray
        )
            System.out.println(j);

        System.out.println("\nВыведим каждый второй элементы массива:");
        for (int i=1;i<length;) {
            System.out.println("Элемент №" + (i) + ": " + myArray[i]);
            i=i+2;
        }

    }

}
