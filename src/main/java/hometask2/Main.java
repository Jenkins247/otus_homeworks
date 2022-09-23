package hometask2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();

        while (true) {
            System.out.println("Введите команду:");
            String inputString = scanner.next().toUpperCase(Locale.ROOT).trim();

            try {
                Commands command = Commands.valueOf(inputString);

                switch (command) {
                    case ADD:
                        animals.add(initAnimal());
                        break;
                    case LIST:
                        for (Animal animal : animals) {
                            System.out.println(animal.toString());
                        }
                        break;
                    case EXIT:
                        System.exit(0);


                }
            } catch (IllegalArgumentException e) {
                System.out.println("Неверная команда. Доступные команды: add/list/exit. Попробуйте снова.");
                continue;
            }

        }


    }


    private static Animal initAnimal() {

        Animal animal = null;

        while (animal == null) {

            System.out.println("Какое животное (cat/dog/duck)?");
            String animalType = scanner.next().toLowerCase(Locale.ROOT).trim();

            switch (animalType) {
                case "cat":
                    animal = new Cat();
                    break;
                case "dog":
                    animal = new Dog();
                    break;
                case "duck":
                    animal = new Duck();
                    break;
                default:
                    System.out.println("Такого животного нет в списке. Попробуйте снова.");


            }
        }


        System.out.println("Введите имя: ");
        animal.setName(scanner.next());
        System.out.println("Введите возраст: ");
        animal.setAge(scanner.nextInt());
        System.out.println("Введите вес: ");
        animal.setWeight(scanner.nextInt());
        System.out.println("Введите цвет: ");
        animal.setColor(scanner.next());
        System.out.println("Животное добавлено.");

        return animal;
    }


}



