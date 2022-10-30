
public class LinearEquation {
    // Instance Variables
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    // Creates a LinearEquation object
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    // Calculates and returns distance between (x1, y1) and (x2, y2), rounded to the nearest hundredth
    public double distance() {
        double distance = Math.pow(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2), 0.5);
        return roundedToHundredth(distance);
    }


    // Calculates and returns the y-intercept of the line between (x1, y1) and (x2, y2), rounded to the nearest hundredth
    public double yIntercept() {
        return roundedToHundredth(y1 - slope() * x1);
    }


    // Calculates and returns the slope of the line between (x1, y1) and (x2, y2), rounded to the nearest hundredth
    public double slope() {
        return roundedToHundredth((double) ( y1-y2) / (x1-x2));
    }


    // Returns a String that represents the linear equation of the line through points (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form
    public String equation() {
        // for non-whole numbers slope
        if (slope() != (int) slope()) {
            // for both negative slope
            if ((y1-y2) < 0 & (x1-x2) < 0 ) {
                // for 0 or negative y-intercept
                if (yIntercept() == 0) {
                    return "y = " + Math.abs(y1-y2) + "/" + Math.abs(x1-x2) + "x";
                } else if (yIntercept() < 0) {
                    return "y = " + Math.abs(y1-y2) + "/" + Math.abs(x1-x2) + "x - " + Math.abs(yIntercept());
                }
                return "y = " + Math.abs(y1-y2) + "/" + Math.abs(x1-x2) + "x + " + yIntercept();
            }
            // for negative slope denominator
            if ((x1-x2) < 0) {
                return "y = " + (y1 - y2) + "/" + Math.abs(x1 - x2) + "x";
            } else if (yIntercept() < 0) {
                // for negative y-intercept
                return "y = " + (y1-y2) + "/" + Math.abs(x1-x2) + "x - " + Math.abs(yIntercept());
            }
            // for positive y-intercept
            return "y = " + (y1-y2) + "/" + Math.abs(x1-x2) + "x + " + yIntercept();
        } else if (slope() == 1) {
            if (yIntercept() == 0) {
                // for slope is 1 and no y-intercept
                return "y = x";
            } else if (yIntercept() < 0) {
                // for slope is 1 and negative y-intercept
                return "y = x -" + Math.abs(yIntercept());
            }
        }


        // for whole numbers slope
        if (slope() == -1) {
            if (yIntercept() == 0) {
                return "y = -x";
            }
            return "y = -x + " + yIntercept();
        }
        if (y2 == y1) {
            return "y = " + y2;
        }

        if (yIntercept() == 0) {
            return "y = " + (int) slope() + "x";
        }
        if (yIntercept() < 0) {
            return "y = " + (int) slope() + "x - " + Math.abs(yIntercept());
        }
        return "y = " + (int) slope() + "x + " + yIntercept();
    }





    // Returns a String of the coordinate point on the line that has the given x value, with  both x and y coordinates as decimals to the nearest hundredth
    public String coordinateForX(double xValue) {
        double yValue = (xValue * slope()) + yIntercept();
        yValue = roundedToHundredth(yValue);
        return "(" + xValue + ", " + yValue + ")";
    }



    // returns the value toRound rounded to the nearest hundredth
    public double roundedToHundredth(double toRound) {
        return Math.round(toRound*100)/100.0;
    }



    // Returns a string that includes all information about the linear equation
    public String lineInfo() {
        return "The two points are: " + "(" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")" + "\n" +
                "The equation of the line between these points is: " + equation() + "\n" +
                "The slope of this line is: " + slope() + "\n" + "The y-intercept of this line is: "
                + yIntercept() + "\n" + "The distance between the two points is " + distance();
    }



}
