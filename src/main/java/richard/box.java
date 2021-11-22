package richard;

import processing.core.PApplet;

public class box extends PApplet {
    public static void main(String[] args) {

        int xCoord = 0;
        int[] x = {30, 34, 55, 89, 97, 60, 23, 76, 34, 69};
        int[] y = {-26, -37, -1, -68, -73, -51, -88, -99, -84, -12};
        int smallestPosition = 0;

        for (int i = 1; i < x.length; i++) {

            if (x[i] < x[smallestPosition]) {

                smallestPosition = i;

            }
        xCoord = x[smallestPosition];
        }

        int largestPositionY = 0;
        int yCoord = 0;
        for (int i = 1; i < y.length; i++) {

            if (y[i] > y[largestPositionY]) {

                largestPositionY = i;

            }
            yCoord = y[largestPositionY];
        }
        System.out.println("(" + xCoord + ", " + yCoord + ")");
    }
}



