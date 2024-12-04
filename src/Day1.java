import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
    /*Take in two lists/arrays of numbers, each containing the same number of integers, sort the arrays
    by smallest to largest, then compare the "distance" between each pair.  Then, sum the distances.

    We'll assume that we will be given valid data.
     */

    private int[] trueChart1;
    private int[] trueChart2;

    public int[] getTrueChart1() {
        return trueChart1;
    }

    public int[] getTrueChart2() {
        return trueChart2;
    }

    public int compareDistance(int n1, int n2) {
        if (n1 > n2) {
            return n1 - n2;
        } else if (n2 > n1) {
            return n2 - n1;
        } else return 0;
    }

    public int[] sortArr(int[] arr) {
        boolean swapsHappened = true;
        while (swapsHappened) {
            swapsHappened = false; // Setting the swap tracker variable false here.
            for (int i = 0; i < arr.length - 1; i++) {
                // Let's do a simple bubble sort.  Not very fast or efficient, but it works.
                // Compare the value at i with the value at i+1 and swap their positions if the first is larger.
                int num1 = arr[i];
                int num2 = arr[i + 1];
                if (num1 > num2) {
                    arr[i] = num2;
                    arr[i + 1] = num1;
                    // When a swap has taken place, set swapsHappened to true.
                    swapsHappened = true;
                }
                // Exit the loop if we reach the end and swapsHappened is still false.
            }
        }
        // Return the sorted array.
        return arr;
    }

    public int compareCharts(int[] chart1, int[] chart2) {
        int chartLength = chart1.length;
        int distanceSum = 0;
        // Sort the charts.
        int[] sortedChart1 = sortArr(chart1);
        int[] sortedChart2 = sortArr(chart2);
        for (int i = 0; i < chartLength; i++) {
            distanceSum += compareDistance(sortedChart1[i], sortedChart2[i]);
        }
        return distanceSum;
    }


    public void parseFileData1() throws FileNotFoundException {
        // Pull in the text file.
        // We'll need a scanner.
        Scanner fileParser = new Scanner(new File("C:\\JavaDev\\personal\\AdventOfCode2024\\src\\inputs\\adventofcode.com_2024_day_1_input.txt"));
        // Get the number of lines in the file and create an array with that many lines.
        // Or, hardcode it, since it's 1000 lines of data and then a blank line.
        trueChart1 = new int[1000];
        trueChart2 = new int[1000];
        for (int i = 0; i < 1000; i++) {
            String[] line = fileParser.nextLine().split(" {3}");
            trueChart1[i] = Integer.parseInt(line[0]);
            trueChart2[i] = Integer.parseInt(line[1]);
        }
        // I should probably dispose of the Scanner, but I don't want to.
    }

    public int solvePuzzle() throws FileNotFoundException {
        parseFileData1();
        int[] sortsy1 = sortArr(trueChart1);
        int[] sortsy2 = sortArr(trueChart2);
        int output = compareCharts(sortsy1, sortsy2);
        return output;
    }

    // For part two of the puzzle, we'll need to have the data parsed, though not necessarily sorted.
    // Though that can't hurt.

    // Method to add up everything in an array.
    private int sumArr(int[] input) {
        int output = 0;
        for (int item : input) {
            output += item;
        }
        return output;
    }

    // Method to get how many times a number exists in an array.
    public int getSimilarityScore(int num, int[] arr){
        int counter = 0;
        for(int item : arr){
            if(item == num){
                counter++;
            }
        }
        return counter;
    }

    //TODO fix this, it doesn't get the right answer.  Even after a rewrite!  THINK!!!
    public int solvePartTwo() throws FileNotFoundException {
        parseFileData1(); // Probably not necessary.
        for(int i = 0; i < 1000; i++){
            int workingNum = trueChart1[i];
            int newValue = getSimilarityScore(workingNum, trueChart2);
            trueChart1[i] = newValue;
        }
        return sumArr(trueChart1);
    }
}