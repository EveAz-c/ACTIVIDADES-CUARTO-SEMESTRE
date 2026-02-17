import java.util.Scanner;
public class CalculatorWithoutException {
        public static void main(String[] args) {
            if (args.length != 3) {
                System.out.println("Uso: java CalculadoraSinExcepciones operando1 operador operando2");
                System.exit(1);
            }

            if (!esEntero(args[0]) || !esEntero(args[2])) {
                System.out.println("Error: Operando no numérico. Debe ingresar números enteros.");
                System.exit(1);
            }

            int operando1 = convertirAEntero(args[0]);
            int operando2 = convertirAEntero(args[2]);

            String operadorStr = args[1];
            if (operadorStr.length() != 1) {
                System.out.println("Error: El operador debe ser un solo carácter (+, -, ., /)");
                System.exit(1);
            }
            char operador = operadorStr.charAt(0);

            if (operador == '/' && operando2 == 0) {
                System.out.println("Error: División por cero.");
                System.exit(1);
            }

            int resultado = 0;
            switch (operador) {
                case '+':
                    resultado = operando1 + operando2;
                    break;
                case '-':
                    resultado = operando1 - operando2;
                    break;
                case '.':
                    resultado = operando1 * operando2;
                    break;
                case '/':
                    resultado = operando1 / operando2;
                    break;
                default:
                    System.out.println("Error: Operador inválido. Use +, -, . o /");
                    System.exit(1);
            }

            System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + resultado);
        }

        private static boolean esEntero(String cadena) {
            if (cadena == null || cadena.isEmpty()) {
                return false;
            }
            int indice = 0;
            if (cadena.charAt(0) == '-') {
                if (cadena.length() == 1) {
                    return false;
                }
                indice = 1;
            }
            for (int i = indice; i < cadena.length(); i++) {
                if (!Character.isDigit(cadena.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        private static int convertirAEntero(String cadena) {
            int signo = 1;
            int indice = 0;
            if (cadena.charAt(0) == '-') {
                signo = -1;
                indice = 1;
            }
            int valor = 0;
            for (int i = indice; i < cadena.length(); i++) {
                valor = valor * 10 + (cadena.charAt(i) - '0');
            }
            return signo * valor;
        }
    }
