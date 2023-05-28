public abstract class Function {
    protected double[] f;

    public Function(double... f) {
        this.f = f;
    }

    public abstract double valueAt(double x);

    public abstract String toString();

    public abstract Function derivative();

    public double bisectionMethod(double a, double b, double epsilon) {
        double left = a;
        double right = b;
        double mid = (left + right) / 2;
        while (Math.abs(this.valueAt(mid)) > epsilon) {
            if (this.valueAt(mid) * this.valueAt(left) > 0) {
                left = mid;
            } else {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }

    public double bisectionMethod(double a, double b) {
        double left = a;
        double right = b;
        double mid = (left + right) / 2;
        while (Math.abs(this.valueAt(mid)) > 10e-5) {
            if (this.valueAt(mid) * this.valueAt(left) > 0) {
                left = mid;
            } else {
                right = mid;
            }
            mid = (left + right) / 2;
        }
        return mid;
    }

    public double newtonRaphsonMethod(double a, double epsilon) {
        double x0 = a; // Initial guess

        while (true) {
            double functionValue = this.valueAt(x0); // Calculate the value of the function at x0
            double derivativValue = this.derivative().valueAt(x0); // Calculate the value of the derivative at x0
            double xk = x0 - functionValue / derivativValue; // Calculate the next approximation

            if (Math.abs(xk - x0) < epsilon) {
                return xk; // Return the root approximation
            }

            x0 = xk; // Update the approximation for the next iteration
        }
    }

    public double newtonRaphsonMethod(double a) {
        double x0 = a; // Initial guess

        while (true) {
            double functionValue = this.valueAt(x0); // Calculate the value of the function at x0
            double derivativValue = this.derivative().valueAt(x0); // Calculate the value of the derivative at x0
            double xk = x0 - functionValue / derivativValue; // Calculate the next approximation

            if (Math.abs(xk - x0) < 10e-5) {
                return xk; // Return the root approximation
            }

            x0 = xk; // Update the approximation for the next iteration
        }
    }

    public Function taylorPolynomial(int n) {
    return null;
    }
}