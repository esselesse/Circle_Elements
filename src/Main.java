import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import static java.lang.Math.*;

/**
 * Created by esselesse on 26.11.2016.
 */
public class Main {
    static double radius;
    static double n;

    public static void main(String[] args) {
        // без защиты от неправильного ввода и эксепшенов
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Radius");
        radius = sc.nextDouble();
        System.out.println("Enter N");
        n = sc.nextDouble();

        // определяем угол обзора элемента
        double alpha = 2*toDegrees(asin(n/(2*radius)));

        // определяем угол обзора расстояния между элементами
        double beta = 2*toDegrees(asin(n/(2*5*radius)));

        // считаем, сколько влезет пар элементов n и 0.2n в 360-beta градусов
        int count = 0;
        double currentAngle = 0;
        while (currentAngle<360-beta){
            currentAngle+=alpha+beta;
            count++;
        }
        count--;

        System.out.println("There is " + count + " elements is possible");

        // а здесь определим расстояние между элементами для равномерного распределения по радиусу
        double temp = (360-count*alpha)/count; // угол обзора нового расстояния между элементами
        double newLength = sin(toRadians(temp/2))*radius*2;

        System.out.println("The length between elements is " + new BigDecimal(newLength).setScale(3, RoundingMode.HALF_DOWN).doubleValue()+ " for uniform distribution");


    }
}
