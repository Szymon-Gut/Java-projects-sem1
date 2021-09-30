package pl.edu.pw.mini.po.additional;

public class Human {

//    public static String greetings = "Hello"; // wystarczy statycznosc
    public static final String GREETINGS = "Hello"; // final sprawia ze nie jest juz zmieniane (nie tylko statyczne)
//    cos co jest statyczny to ma byc statyczne itp
    public static int counter;

    public int id;
    public int age;//(=0) domyslnie
//    public int age = 125;

//    protected String name;
//    String surname;
    public String name;// = null(domyslnie)
    public String surname;
    public double weight;

    private String nationalID = "11231";
    protected int salary;

    public Human() {
        System.out.println("Constructor");
    }

    {//szczegolny przypadek (niezalezny) pojdzie jako pierwszy
        System.out.println("init.");
    }
    public Human(int age, String name, String surname) {
        this.id = ++counter;
        this.age = age;
        this.name = name;
        this.surname = surname;
    }
//    public Human(int id, int age, String name, String surname, double weight){
//        super();
//        this.id = id;
//        this.age = age;
//        this.name = name;
//        this.surname = surname;
//        this.weight = weight;
//    }
    public static void MyFirstStaticMethod(int... values){
//        age = 6; // a non-static field can not be referred from a static one
    }

    //KONSTRUKTOR ALT + INS (generator)


    /**
     * (Przykladowy docs) to jest to i to
     * @param value Podaj wart.
     */
    public void myMethod(int value){
        submethodFirst();
        counter = 1;
    }

    public void myMethod(int value, double weight, int... values){ //przeciazenie - overloading
//        values[0]

    }
    private void submethodFirst() { // prywatna bo tylko wykorzystywana w tej classie (wyzej)

    }

    public void setNationalID(){ // zawsze robic z automatu (generator alt+ins)
        this.nationalID = nationalID;
    }
    public String getNationalID(){
        return nationalID;//niejawny this.nationalID
    }
}