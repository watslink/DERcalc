package DERcalc;

public class Person {
    private boolean sex; //false=male true=female
    private int age;
    private double weight; // en kg
    private double size; // en m
    private double IMC;
    private double DERkcal=0;
    private double DERMJ=0;


    public Person(boolean sex, int age, double weight, double size) {
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.size = size;
        this.calcIMC();
        this.calcDERMJ();
        this.calcDERkcal();
    }

    void calcIMC(){
        this.IMC = this.weight/Math.pow(this.size, 2);
    }
    //equations de Henry selon age et sexe, 0 si non concerné
    void calcDERMJ() {

        if(sex){
            System.out.println("femme");
            if(age >= 60){
                System.out.println("+60ans");
                this.DERMJ = 0.0356*weight + 1.76*size + 0.0448;
            }
            else if(age <60 && age >50){
                System.out.println("entre 50 et 60");
                this.DERMJ = 0.0342*weight + 2.10*size - 0.0486;
            }
            else this.DERMJ = 0;
        }
        if(!sex){
            System.out.println("homme");
            if(age >= 60){
                System.out.println("+60ans");
                this.DERMJ = 0.0478*weight + 2.26*size - 1.07;
            }
            else this.DERMJ = 0;
        }
    }

    //conversion MJ en kcal
    void calcDERkcal() {
        this.DERkcal = this.DERMJ*238.85;
    }
    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getIMC() {
        return IMC;
    }

    public double getDERkcal() {
        return DERkcal;
    }

    public double getDERMJ() {
        return DERMJ;
    }

}
