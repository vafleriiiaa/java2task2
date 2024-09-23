import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {

    public static void main(String[] args){
        ex20();
    }

    // Задача №1: Найти большее из двух чисел
    static int ex1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи два числа:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a == b){
            System.out.println("Числа равны");
            return -1;
        }
        return a > b ? a : b;
    }

    // Задача №2: Деление двух чисел
    static float ex2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи делимое и делитель:");
        float a = sc.nextFloat();
        float b = sc.nextFloat();
        if(b == 0){
            System.out.println("Деление на ноль нельзя");
            return -1;
        }
        return a / b;
    }

    // Задача №3: Конвертация строки в число
    static int ex3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи строку для преобразования в число:");
        String s = sc.nextLine();
        try{
            return Integer.parseInt(s);
        } catch(NumberFormatException e){
            System.out.println("Невозможно преобразовать строку в число");
            return -1;
        }
    }

    // Задача №4: Проверка возраста
    static void ex4(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи возраст:");
        int age = sc.nextInt();
        if(age < 0 || age > 150){
            System.out.println("Возраст введен некорректно!");
        }
    }

    // Задача №5: Нахождение корня числа
    static float ex5(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи число:");
        float num = sc.nextFloat();
        if(num < 0){
            System.out.println("Число отрицательное");
            return -1;
        }
        return (float)Math.sqrt(num);
    }

    // Задача №6: Вычисление факториала
    static int ex6(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи число для факториала:");
        int n = sc.nextInt();
        if(n < 0){
            System.out.println("Факториал из отрицательного числа");
            return -1;
        }
        int fact = 1;
        for(int i = 1; i <= n; i++) fact *= i;
        return fact;
    }

    // Задача №7: Проверка массива на наличие нулей
    static void ex7(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи числа массива через пробел:");
        String[] input = sc.nextLine().split(" ");
        for(String num : input){
            if(num.equals("0")){
                System.out.println("Массив содержит нули");
                return;
            }
        }
        System.out.println("Массив не содержит нулей");
    }

    // Задача №8: Возведение числа в степень
    static int ex8(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи основание и степень:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(b < 0){
            System.out.println("Отрицательная степень");
            return -1;
        }
        return (int)Math.pow(a, b);
    }

    // Задача №9: Обрезка строки до заданной длины
    static String ex9(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи строку:");
        String s = sc.nextLine();
        System.out.println("Введи количество символов:");
        int n = sc.nextInt();
        if(n > s.length()){
            return "В строке меньше нужного количества символов";
        }
        return s.substring(0, n);
    }

    // Задача №10: Поиск элемента в массиве
    static int ex10(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи элементы массива через пробел:");
        String[] arr = sc.nextLine().split(" ");
        System.out.println("Введи элемент для поиска:");
        String find = sc.next();
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(find)){
                System.out.println("Элемент найден на позиции " + i);
                return i;
            }
        }
        System.out.println("Элемент не найден");
        return -1;
    }

    // Задача №11: Конвертация числа в двоичный формат
    static String ex11(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи число для конвертации в двоичный:");
        int num = sc.nextInt();
        if(num < 0){
            System.out.println("Отрицательные числа не поддерживаются");
            return "-1";
        }
        return Integer.toBinaryString(num);
    }

    // Задача №12: Проверка делимости
    static boolean ex12(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи два числа:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(b == 0){
            System.out.println("Деление на ноль невозможно");
            return false;
        }
        return a % b == 0;
    }

    // Задача №13: Получение элемента массива по индексу
    static int ex13(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи элементы массива через пробел:");
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("Введи индекс:");
        int index = sc.nextInt();
        if(index < 0 || index >= arr.length){
            System.out.println("Индекс вне диапазона массива");
            return -1;
        }
        return arr[index];
    }

    // Задача №14: Проверка сложности пароля
    static class WeakPasswordException extends Exception {
        public WeakPasswordException(String message){
            super(message);
        }
    }

    static boolean ex14(String password) throws WeakPasswordException {
        if(password.length() < 8){
            throw new WeakPasswordException("Пароль короткий");
        }
        return true;
    }

    // Задача №15: Проверка корректности даты
    static boolean ex15(String date) throws Exception {
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch(DateTimeParseException e){
            throw new Exception("Формат неверный");
        }
        return true;
    }

    // Задача №16: Объединение двух строк
    static String ex16(String s1, String s2){
        if(s1 == null || s2 == null){
            System.out.println("Одна или две строки равны null");
            return "-1";
        }
        return s1 + s2;
    }

    // Задача №17: Остаток от деления
    static int ex17(int a, int b){
        if(b == 0){
            System.out.println("Деление на ноль невозможно");
            return -1;
        }
        return a % b;
    }

    // Задача №18: Нахождение квадратного корня
    static double ex18(double a){
        if(a < 0){
            System.out.println("Корень отрицательного числа найти нельзя");
            return -1;
        }
        return Math.sqrt(a);
    }

    // Задача №19: Конвертация Цельсия в Фаренгейт
    static double ex19(double celsius){
        if(celsius < -273.15){
            System.out.println("Температура не может быть меньше абсолютного нуля");
            return -1;
        }
        return (celsius * 9 / 5) + 32;
    }

    // Задача №20: Проверка пустой строки или null
    static String ex20(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи строку:");
        String s = sc.nextLine();
        if(s == null || s.trim().isEmpty()){
            System.out.println("Строка не может быть пустой или равной null");
            return "-1";
        }
        return "Строка валидна";
    }
}
