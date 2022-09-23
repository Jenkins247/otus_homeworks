package hometask2;

public class Duck extends Animal implements Flying{
    @Override
    public void say() {
        System.out.println("Кря");
    }

    @Override
    public void fly() {

    }
}
