package main;


import logic.PaidService;
import logic.FixedHourlyCostPaidService;
import logic.FixedMonthlyCostPaidService;
import java.util.Arrays;


public class Main {
    private static PaidService[] elements = new PaidService[] {
            new FixedHourlyCostPaidService("service1", "Google Orkut", 11),
            new FixedHourlyCostPaidService("service2", "Google Voice", 9.4),
            new FixedMonthlyCostPaidService("service5", "Youtube", 8064),
            new FixedHourlyCostPaidService("service3", "Mandrill", 11.2),
            new FixedHourlyCostPaidService("service4", "Google Finance", 7.8),
            new FixedMonthlyCostPaidService("service7", "Google Building Maker", 5347),
            new FixedMonthlyCostPaidService("service6", "LinkedIn", 6863)
    };


    private static void arraySorting() {
        // Сортировка массива по убыванию среднемесячных затрат.
       Arrays.sort(elements, (o1, o2) -> {
           if (o1.calculateAverageMonthlyCosts() < o2.calculateAverageMonthlyCosts()){
               return 1;
           } else if (o1.calculateAverageMonthlyCosts() > o2.calculateAverageMonthlyCosts()){
               return -1;
           } else {
               return 0;
           }
       });
       // Упорядочивание данных по названию сервиса, когда сумма затрат совпадает.
       for (int i = 0; i < elements.length; i++) {
           if (i == elements.length - 1) {
               break;
           }
           if (elements[i].calculateAverageMonthlyCosts() == elements[i + 1].calculateAverageMonthlyCosts()) {
               if (elements[i].getName().compareTo(elements[i+1].getName()) > 0) {
                   PaidService check = elements[i];
                   elements[i] = elements[i + 1];
                   elements[i + 1] = check;
               }
           }
       }
    }


    private static void allDataOutput() {
        /*
         * Вывод содержания отсортированного массива на экран, которое включает в себя
         * значения полей id, name и среднемесянче затраты.
         */
        for (PaidService element : elements) {
            System.out.println(element.toString());
        }
    }


    private static void namesOutput() {
        // Вывод первых 5 значений свойства name элементов из упорядоченного массива.
        for (int i = 0; i < 5; i++) {
            System.out.println(elements[i].getName());
        }
    }


    private static void idOutput() {
        // Вывод последних трех значений свойства id элементов из упорядоченного массива.
        for (int i = elements.length - 3; i <= elements.length - 1; i++) {
            System.out.println(elements[i].getId());
        }
    }


    private static void compareTwoServices() {
        /*
         * Сравнение ежемесячных затрат на сервисы Youtube и Mandrill. Для удобства объекты, у которых значения
         * полей name соответствуют указанным, заносятся в отдельный массив.
         */
        PaidService[] services = new PaidService[2];
        int j = 0;
        for (PaidService element : elements) {
            if (element.getName().equals("Mandrill") || element.getName().equals("Youtube")) {
                services[j] = element;
                j++;
            }
        }

        if (services[0].calculateAverageMonthlyCosts() > services[1].calculateAverageMonthlyCosts()) {
            System.out.println(services[0].getName());
            System.out.println(services[1].getName());
        } else if (services[0].calculateAverageMonthlyCosts() == services[1].calculateAverageMonthlyCosts()) {
            System.out.println(services[0].getName() + " / " + services[1].getName());
        } else {
            System.out.println(services[1].getName());
            System.out.println(services[0].getName());
        }
    }


    public static void main(String[] args) {
        arraySorting();
        allDataOutput();
        System.out.println();
        namesOutput();
        System.out.println();
        idOutput();
        System.out.println();
        compareTwoServices();
    }
}
