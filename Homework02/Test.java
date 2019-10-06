public class Test {
/*
Ошибка NullPointerException.
Возникла из-за того, что в переменной z хранится значение,
а в переменной k ранится ссылка.


 */
    private Integer k;
    private int z;
    private int i;

    public void method() {
        i = k + z;
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.method();
        System.out.println(t.i);
    }

}
