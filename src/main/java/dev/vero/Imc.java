package dev.vero;

public class Imc {
    public static double CalculateIMC(double weight, double height) {
        if (weight <= 0 || height <= 0) {
            throw new IllegalArgumentException("Weight and height must be greater than zero");
        }
        return weight / Math.pow(height, 2);
    }

    public static String classifyIMC(double imc) {
        if (imc < 16) {
            return "Severe Underweight";
        } else if (imc >= 16 && imc < 16.99) {
            return "Moderate Underweight";
        } else if (imc >= 17 && imc < 18.49) {
            return "Mild Underweight";
        } else if (imc >= 18.5 && imc < 24.99) {
            return "Normal weight";
        } else if (imc >= 25 && imc < 29.99) {
            return "Overweight";
        } else if (imc >= 30 && imc < 34.99) {
            return "Mild Obesity";
        } else if (imc >= 35 && imc < 39.99) {
            return "Moderate Obesity";
        } else {
            return "Morbid Obesity";
        }
    }

    public static void main(String[] args) {
        double weight = 70;
        double height = 1.58;

        try {
            double imc = CalculateIMC(weight, height);
            String classification = classifyIMC(imc);

            System.out.println("Weight: " + weight + " kg");
            System.out.println("Height: " + height + " m");
            System.out.println("IMC: " + imc);
            System.out.println("Classification: " + classification);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}