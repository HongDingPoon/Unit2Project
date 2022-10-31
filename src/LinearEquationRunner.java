import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.print("Enter coordinate 1: ");
        String coordinate1 = scan.nextLine();

        // Takes in coordinate 1
        String subString1 = coordinate1.substring(1, coordinate1.indexOf(","));
        String subString2 = coordinate1.substring(coordinate1.indexOf(",") + 2, coordinate1.length()-1);
        int int1 = Integer.parseInt(subString1);
        int int2 = Integer.parseInt(subString2);

        System.out.print("Enter coordinate 2: ");
        String coordinate2 = scan.nextLine();

        // Takes in coordinate 2
        String subString3 = coordinate2.substring(1, coordinate2.indexOf(","));
        String subString4 = coordinate2.substring(coordinate2.indexOf(",") + 2, coordinate2.length()-1);
        int int3 = Integer.parseInt(subString3);
        int int4 = Integer.parseInt(subString4);

        // Checks if x1 = x2
        if (int1 == int3) {
            System.out.println("These points are on a vertical line: x = " + int1);
        } else {
            LinearEquation obj = new LinearEquation(int1, int2, int3, int4);

            System.out.println();
            System.out.println(obj.lineInfo());
            System.out.println();

            System.out.print("Enter a value for x: ");
            double xValue = scan.nextDouble();
            System.out.println();
            System.out.println("The point on the line is " + obj.coordinateForX(xValue));
        }

    }
}

