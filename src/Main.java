import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello world!");
        Day1 day1 = new Day1();
        int[] arr1 = {3, 4, 2, 1, 3, 3};
        int[] arr2 = {4, 3, 5, 3, 9, 3};
        int dayOneAnswer = day1.compareCharts(arr1, arr2);
        System.out.println(dayOneAnswer);
        if(dayOneAnswer == 11){
            System.out.println("Day 1 passes!");
        } else{
            System.out.println("Day 1 fails!");
        }
        dayOneAnswer = day1.solvePuzzle();
        System.out.println("The answer for day 1 is: " + dayOneAnswer);
    }
}