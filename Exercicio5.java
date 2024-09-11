import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string para inverter: ");
        String input = scanner.nextLine();
        scanner.close();

        String inverso = inverterString(input);
        System.out.println("String invertida: " + inverso);
    }

    private static String inverterString(String s) {
        char[] caracteres = s.toCharArray();
        int esquerda = 0;
        int direita = caracteres.length - 1;

        while (esquerda < direita) {
            char temp = caracteres[esquerda];
            caracteres[esquerda] = caracteres[direita];
            caracteres[direita] = temp;
            esquerda++;
            direita--;
        }

        return new String(caracteres);
    }
}