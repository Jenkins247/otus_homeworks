package hometask2.animals.birds;

import hometask2.impl.Flying;
import hometask2.animals.Animal;

public class Duck extends Animal implements Flying {
    @Override
    public void say() {
        System.out.println("Кря");
    }

    @Override
    public void fly() {
        System.out.println("Я лечу");
    }
}
