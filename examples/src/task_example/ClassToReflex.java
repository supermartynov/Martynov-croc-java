package task_example;

class ClassToReflex {
    private static int a;

    private static int b;

    public ClassToReflex() {
        System.out.println("Вызвался конструктор");
    }

    public  int getA() {
        return a;
    }

    public  void setA(int a) {
        ClassToReflex.a = a;
    }

    public  void setB(int b) {
        ClassToReflex.b = b;
    }
}
