package bruno.souza.calculategrades.model;

public class Student {
    private String name;
    private double n1;
    private double n2;
    private String sex;
    private double nf;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getNf() {
        return nf;
    }

    //calculos
    public void calcularMediaAritmetica(double n1, double n2){
        this.nf = Double.parseDouble(String.valueOf((n1 + n2) / 2));
    }
    public String verificarConceito(double v){
        if(v < 6){
            return "D";
        }else if(v < 8){
            return "C";
        }else if(v < 9){
            return "B";
        }else if(v >= 9){
            return "A";
        }else{
            return "Error";
        }
    }
}
