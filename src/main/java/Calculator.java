public class Calculator {
    public int add(int a, int b) {
        return a+b;
    }

    public int subtract(int a, int b) {
        return a-b;
    }

    public int multiply(int a, int b) {
        return a*b;
    }

    public int divide(int a, int b) {
        return a/b;
    }

    public int[] generateArray() {
        return new int[] {1,2,3};
    }

    public String generateMultiLineString() {
        return "Line1\nLine2\nLine3";
    }

    public int generateRandomNumber() {
        return (int) (Math.random() * 100); // Example range: 0-99
    }

}
