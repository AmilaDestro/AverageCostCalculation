package main;


import logic.PaidService;
import logic.FixedHourlyCostPaidService;
import logic.FixedMonthlyCostPaidService;
import java.util.Arrays;
import java.util.Comparator;


public class Main{

    private static PaidService[] elements = new PaidService[]{
            new FixedHourlyCostPaidService("service1", "Google Orkut", 11),
            new FixedHourlyCostPaidService("service2", "Google Voice", 9.4),
            new FixedMonthlyCostPaidService("service5", "Youtube", 8064),
            new FixedHourlyCostPaidService("service3", "Mandrill", 11.2),
            new FixedHourlyCostPaidService("service4", "Google Finance", 7.8),
            new FixedMonthlyCostPaidService("service7", "Google Building Maker", 5347),
            new FixedMonthlyCostPaidService("service6", "LinkedIn", 6863)
    };


    public static void arraySorting(){
        //сортировка массива по убыванию среднемесячных затрат
       Arrays.sort(elements, new Comparator<PaidService>() {
           @Override
           public int compare(PaidService o1, PaidService o2) {
               if (o1.calculateAverageMonthlyCosts() < o2.calculateAverageMonthlyCosts()){
                   return 1;}
               else if (o1.calculateAverageMonthlyCosts() > o2.calculateAverageMonthlyCosts()){
                   return -1;}
               else {
                   return 0;
               }
           }
       });
       //упорядочивание данных по названию сервиса, когда сумма затрат совпадает
       for(int i = 0; i < elements.length; i++){
           if (i == elements.length - 1){
               break;
           }
           if(elements[i].calculateAverageMonthlyCosts() == elements[i + 1].calculateAverageMonthlyCosts()){
               if(elements[i].getName().compareTo(elements[i+1].getName()) > 0){
                   PaidService check = elements[i];
                   elements[i] = elements[i + 1];
                   elements[i + 1] = check;
               }
           }
       }
    }

    public static void allDataOutput(){
        //вывод содержания отсортированного массива на экран
        for (PaidService cur: elements){
            System.out.println(cur.toString());
        }
    }

    public static void namesOutput(){
        for (int i = 0; i < 5; i++){
            System.out.println(elements[i].getName());
        }
    }

    public static void idOutput(){
        PaidService[] last3Ids = new PaidService[3];
        for (int i = 0, j = elements.length - 1; i < last3Ids.length; i++, j--){
            last3Ids[i] = elements[j];
        }

        for (int i = last3Ids.length - 1; i >= 0; i--){
            System.out.println(last3Ids[i].getId());
        }
    }


    public static void main(String[] args){
        arraySorting();
        allDataOutput();
        System.out.println();
        namesOutput();
        System.out.println();
        idOutput();
    }
}
