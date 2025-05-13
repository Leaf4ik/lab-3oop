import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Выберите операцию:");
        System.out.println("1 — найти палиндромы");
        System.out.println("2 — удалить анаграммы");
        System.out.print("Ваш выбор: ");
        int variant = Integer.parseInt(in.nextLine());

        System.out.print("Введите текст: ");
        String text = in.nextLine();

        Processor processor = ProcessorFactory.createProcessor(variant, text);
        System.out.println();
        processor.execute();

        in.close();
    }
}
