import java.util.Scanner;
public class CalculatorWithException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el primer número: ");
        String num1Str = scanner.nextLine();

        System.out.print("Ingresa el operador (+, -, ., /): ");
        String operator = scanner.nextLine();

        System.out.print("Ingresa el segundo número: ");
        String num2Str = scanner.nextLine();

        try {
            int op1 = Integer.parseInt(num1Str);
            int op2 = Integer.parseInt(num2Str);
            int result = 0;

            switch (operator.charAt(0)) {
                case '+': result = op1 + op2; break;
                case '-': result = op1 - op2; break;
                case '.': result = op1 * op2; break;
                case '/':
                    if (op2 == 0) throw new ArithmeticException("División por cero");
                    result = op1 / op2;
                    break;
                default:
                    System.out.println("Operador inválido");
                    System.exit(1);
            }

            System.out.println(op1 + " " + operator + " " + op2 + " = " + result);
        } catch (NumberFormatException e) {
            System.out.println("Error: Debes ingresar números enteros.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
