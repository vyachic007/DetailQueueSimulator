package by.slava_borisov.lab1;

import by.slava_borisov.lab1.array.ArrayQueue;
import by.slava_borisov.lab1.linked.LinkedQueue;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Queue queue = new ArrayQueue();
        Queue queue = new LinkedQueue();

        queue.init();

        int currentTime = 0;
        Detail currentProcessing = null;
        int remainingTime = 0;

        boolean running = true;
        while (running) {
            System.out.println("\n///////////////////////");
            System.out.println("Модельное время: " + currentTime + " ////");
            System.out.println("///////////////////////");
            System.out.println("\nВыберите действие:");
            System.out.println("1 — Постановка детали на обработку");
            System.out.println("2 — Переход к следующему моменту времени");
            System.out.println("3 — Снятие детали с обработки (отказ установки)");
            System.out.println("4 — Сброс процесса моделирования");
            System.out.println("5 — Показать список обрабатываемых деталей");
            System.out.println("0 — Выход");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Ошибка: нужно ввести число от 0 до 5.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    String code;
                    while (true) {
                        System.out.print("Введите код детали (4 символа): ");
                        code = scanner.nextLine();
                        if (code.length() == 4) break;
                        System.out.println("Ошибка: код должен быть ровно 4 символа.");
                    }

                    int time = -1;
                    while (true) {
                        System.out.print("Введите время обработки (целое число): ");
                        if (scanner.hasNextInt()) {
                            time = scanner.nextInt();
                            scanner.nextLine();
                            if (time > 0) break;
                            else System.out.println("Ошибка: время должно быть положительным.");
                        } else {
                            System.out.println("Ошибка: нужно ввести целое число.");
                            scanner.nextLine();
                        }
                    }

                    Detail newDetail = new Detail(code, time);
                    if (queue.enqueue(newDetail)) {
                        System.out.println("Деталь добавлена в очередь.");
                    } else {
                        System.out.println("Очередь полна. Деталь не добавлена.");
                    }
                    break;

                case 2:
                    currentTime++;
                    System.out.println("Модельное время увеличено на 1 единицу.");

                    if (currentProcessing == null && !queue.isEmpty()) {
                        currentProcessing = queue.dequeue();
                        remainingTime = currentProcessing.getTime();
                        System.out.println("Начата обработка детали: " + currentProcessing);
                    }

                    if (currentProcessing != null) {
                        remainingTime--;
                        if (remainingTime <= 0) {
                            System.out.println("Обработка завершена: " + currentProcessing);
                            currentProcessing = null;
                        }
                    }
                    break;

                case 3:
                    if (currentProcessing != null) {
                        System.out.println("Обработка детали прервана (отказ установки): " + currentProcessing);
                        currentProcessing = null;
                        remainingTime = 0;
                    } else {
                        System.out.println("Сейчас нет детали на обработке.");
                    }
                    break;

                case 4:
                    queue.init();
                    currentProcessing = null;
                    remainingTime = 0;
                    currentTime = 0;
                    System.out.println("Процесс моделирования сброшен.");
                    break;

                case 5:
                    System.out.println("Список деталей в очереди:");
                    for (Detail d : queue.toArray()) {
                        System.out.println(d);
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Выход из программы.");
                    break;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }

        scanner.close();
    }
}
