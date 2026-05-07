package labpractice7;
import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        String[] parts;

        String op = line.contains("+") ? "\\+" : "-";
        parts = line.split(op);

        try {
            int num1 = Integer.parseInt(parts[0]);
            int num2 = Integer.parseInt(parts[1]);

            if (line.contains("+")) {
                if (num1 == 0 || num2 == 0) throw new AddZeroException();
            } else {
                if (num1 == 0 || num2 == 0) throw new SubtractZeroException();
            }

            if (num1 < 0 || num1 > 1000 || num2 < 0 || num2 > 1000 || (num1+num2>1000&&line.contains("+")) || (num1-num2<0&&line.contains("-"))) {
                throw new OutOfRangeException();
            }

            if (line.contains("+")) System.out.println(num1 + num2);
            else System.out.println(num1 - num2);

        } catch (AddZeroException e) {
            System.out.println("AddZeroException");
        } catch (SubtractZeroException e) {
            System.out.println("SubtractZeroException");
        } catch (OutOfRangeException e) {
            System.out.println("OutOfRangeException");
        } finally {
            sc.close();
        }
    }
}

class OutOfRangeException extends Exception {}
class AddZeroException extends Exception {}
class SubtractZeroException extends Exception {}