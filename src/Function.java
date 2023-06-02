public abstract class Function {
    public abstract double valueAt(double x);

    public abstract String toString();

    public abstract Function derivative();

    public double bisectionMethod(double a, double b, double epsilon) {
        double left = a;
        double right = b;
        double mid;
        while (right-left > epsilon) {
            mid = (left + right) / 2;
            if (valueAt(left) * valueAt(mid) > 0) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (left + right) / 2;
    }

    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a, b, Math.pow(10,-5));
    }

    public double newtonRaphsonMethod(double a, double epsilon) {
        while (!(Math.abs(this.valueAt(a)) < Math.abs(epsilon))) {
            double functionValue = valueAt(a); // Calculate the value of the function at x0
            double derivativeValue = derivative().valueAt(a); // Calculate the value of the derivative at x0
            a -= (functionValue/derivativeValue); // Calculate the next approximation
        }
        return a;
    }

    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, Math.pow(10,-5));
    }

    public Function taylorPolynomial(int n) {
            // Array to store coefficients of the Taylor polynomial
            double[] coefficients = new double[n + 1];

            // Initialize the current function as the instance of the function the method is called on
            Function currentFunction = this;

            // Loop through from 0 to n to calculate each coefficient
            for (int i = 0; i <= n; i++) {
                // Calculate the i-th coefficient by evaluating the derivative at x = 0
                // and dividing by i factorial
                double coefficient = currentFunction.valueAt(0) / factorial(i);

                // Store the coefficient in the array
                coefficients[i] = coefficient;

                // Update currentFunction to the derivative for the next iteration
                currentFunction = currentFunction.derivative();
            }

            // Return a new Polynomial function with the calculated coefficients
            return new Polynomial(coefficients);
    }

// Helper function to calculate factorial of an integer
    public static double factorial(int n) {
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
