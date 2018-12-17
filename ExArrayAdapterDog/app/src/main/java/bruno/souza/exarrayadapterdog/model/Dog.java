package bruno.souza.exarrayadapterdog.model;

public class Dog {
    private String race;
    private int age;
    private String key;

    public Dog() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Key: " + key +
                "\nRaça: " + race +
                "\nIdade: " + age +
                "\nIdade em anos humanos: "+calcDogAge();
    }
    public int calcDogAge(){
        return this.age*7;
    }
}
