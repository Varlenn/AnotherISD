package tests;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {

    static Scanner in = new Scanner(System.in);
    static List<Student> students;
    static DecimalFormat df = new DecimalFormat("#.##");
    static boolean debtMarker;
    static int choice = -1;
    static List<String> studSubjects = new ArrayList<>();

    public static void main(String[] args) {

//        создание списка студентов
        students = new ArrayList<>();
        studSubjects.add("Математика");
        studSubjects.add("Информатика");
        studSubjects.add("Физика");
        studSubjects.add("Философия");
        studSubjects.add("Иностранный язык");
        studSubjects.add("История");

//        заполнение данных о студентах
        Map<String, double[]> mark1 = new HashMap<String, double[]>();
        mark1.put("Математика", new double[]{2, 2, 2});
        mark1.put("Информатика", new double[]{2, 2, 2});
        mark1.put("Физика", new double[]{2, 2, 2});
        mark1.put("Философия", new double[]{4, 5, 5});
        mark1.put("Иностранный язык", new double[]{3, 4, 3});
        mark1.put("История", new double[]{3, 2, 5});
        Student student1 = new Student("Иван Иванов", "0033", 1, mark1);

        Map<String, double[]> mark2 = new HashMap<>();
        mark2.put("Математика", new double[]{5, 5, 5});
        mark2.put("Информатика", new double[]{5, 4, 5});
        mark2.put("Физика", new double[]{5, 5, 5});
        mark2.put("Философия", new double[]{2, 3, 5});
        mark2.put("Иностранный язык", new double[]{3, 4, 4});
        mark2.put("История", new double[]{4, 4, 4});
        Student student2 = new Student("Олег Сидоров", "3011", 2, mark2);

        Map<String, double[]> mark3 = new HashMap<>();
        mark3.put("Математика", new double[]{5, 5, 5});
        mark3.put("Информатика", new double[]{4, 5, 4});
        mark3.put("Физика", new double[]{5, 3, 5});
        mark3.put("Философия", new double[]{2, 2, 2});
        mark3.put("Иностранный язык", new double[]{2, 3, 2});
        mark3.put("История", new double[]{2, 2, 2});
        Student student3 = new Student("Глеб Глебов", "1066", 2, mark3);

        Map<String, double[]> mark4 = new HashMap<>();
        mark4.put("Математика", new double[]{4, 3, 3});
        mark4.put("Информатика", new double[]{4, 5, 3});
        mark4.put("Физика", new double[]{3, 5, 3});
        mark4.put("Философия", new double[]{3, 3, 3});
        mark4.put("Иностранный язык", new double[]{4, 4, 4});
        mark4.put("История", new double[]{4, 4, 5});
        Student student4 = new Student("Денис Денисов", "6123", 1, mark4);

//        добавление созданных студентов в список
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);


//        System.out.println("Выберите, что хотите сделать\n(0 - выйти, 1 - узнать оценки студента; \n2 - вывести количество студентов, имеющих задолженность;" +
//                "\n3 - вывести количество студентов, не имеющих задолженность;\n4 - вывести количество студентов, имеющих более трех задолжностей.)");
//        choice = in.nextInt();
        while (choice != 0) {
            System.out.println("\nВыберите, что хотите сделать\n(0 - выйти, 1 - узнать оценки студента;\n2 - узнать оценки студента по конкретному предмету;" +
                    "\n3 - вывести количество студентов, имеющих задолженность;" +
                    "\n4 - вывести количество студентов, не имеющих задолженность;\n5 - вывести количество студентов, имеющих более трех задолжностей.)");
            choice = in.nextInt();
            userChoice();
        }

//        System.out.println("Введите имя и фамилию студента, оценки которого вы ходите узнать");
//        String name = in.nextLine();
//
////        System.out.println("Введите предмет");
////        String subject = in.nextLine();
////        averageMark(name, subject);
//
//        averageMark(name);
//
//        System.out.println("\nКоличество студентов, не имеющих задолженность: " + debtSearch(false));
//        System.out.println("Количество задолжников: " + debtSearch(true));
//
//        System.out.println("\nКоличество студентов, имеющих более 3 долгов: " + debtSearch());
    }


    private static void userChoice() {
        switch (choice) {
            case 0 -> {
            }
            case 1 -> {
                System.out.println("Введите имя и фамилию студента, оценки которого вы ходите узнать");
                in.nextLine();
                String name = in.nextLine();
                averageMark(name);
            }
            case 2 -> {
                System.out.println("Введите предмет");
                in.nextLine();
                String subject = in.nextLine();
                if (!studSubjects.contains(subject)) {
                    System.out.println("Такого предмета не существует, выберите из существующих:\n" + studSubjects);
                    break;
                }
                System.out.println("Введите имя и фамилию студента, оценки которого вы ходите узнать");
                String name = in.nextLine();
                averageMark(name, subject);
            }
            case 3 -> System.out.println("Количество задолжников: " + debtSearch(true));
            case 4 -> System.out.println("\nКоличество студентов, не имеющих задолженность: " + debtSearch(false));
            case 5 -> System.out.println("\nКоличество студентов, имеющих более 3 долгов: " + debtSearch());
            default -> System.out.println("Такого действия не существует, выберите правильное");
        }
    }

    private static void averageMark(String name, String subject) {
        Map<String, String> avMark = new HashMap<String, String>();
        List<String> names = new ArrayList<>();
        for (final Student st : students) {
            if (st.name.equals(name)) {
                if (st.marks.containsKey(subject)) {
                    avMark.put(subject, df.format(DoubleStream.of(st.marks.get(subject)).sum() / st.marks.get(subject).length));
                }
            }
            names.add(st.name);
        }
        if (!names.contains(name)) {
            System.out.println("Студента с таким именем не существует");
            return;
        }

        System.out.println(avMark);
    }

    private static void averageMark(String name) {
        Map<String, String> avMark = new HashMap<String, String>();
        List<String> names = new ArrayList<>();
        for (final Student st : students) {
            if (st.name.equals(name)) {
                avMark.put("Математика", df.format(DoubleStream.of(st.marks.get("Математика")).sum() / st.marks.get("Математика").length));
                avMark.put("Информатика", df.format(DoubleStream.of(st.marks.get("Информатика")).sum() / st.marks.get("Информатика").length));
                avMark.put("Физика", df.format(DoubleStream.of(st.marks.get("Физика")).sum() / st.marks.get("Физика").length));
                avMark.put("Философия", df.format(DoubleStream.of(st.marks.get("Философия")).sum() / st.marks.get("Философия").length));
                avMark.put("Иностранный язык", df.format(DoubleStream.of(st.marks.get("Иностранный язык")).sum() / st.marks.get("Иностранный язык").length));
                avMark.put("История", df.format(DoubleStream.of(st.marks.get("История")).sum() / st.marks.get("История").length));
            }
            names.add(st.name);
        }
        if (!names.contains(name)) {
            System.out.println("Студента с таким именем не существует");
            return;
        }
        System.out.println(avMark);
    }


    public static int debtSearch(boolean debt) {
        int sum = 0;
        Map<String, Double> avMark = new HashMap<String, Double>();

        for (final Student st : students) {
            debtMarker = false;
            avMark.put("Математика", (DoubleStream.of(st.marks.get("Математика")).sum() / st.marks.get("Математика").length));
            avMark.put("Информатика", (DoubleStream.of(st.marks.get("Информатика")).sum() / st.marks.get("Информатика").length));
            avMark.put("Физика", (DoubleStream.of(st.marks.get("Физика")).sum() / st.marks.get("Физика").length));
            avMark.put("Философия", (DoubleStream.of(st.marks.get("Философия")).sum() / st.marks.get("Философия").length));
            avMark.put("Иностранный язык", (DoubleStream.of(st.marks.get("Иностранный язык")).sum() / st.marks.get("Иностранный язык").length));
            avMark.put("История", (DoubleStream.of(st.marks.get("История")).sum() / st.marks.get("История").length));


            for (Double c : avMark.values()) {
                if (c < 2.60) {
                    debtMarker = true;
                }
            }
            if (debtMarker) {
                sum++;
            }
        }
        if (!debt) {
            sum = students.size() - sum;
        }
        return sum;
    }


    public static int debtSearch() {
        int sum = 0;
        int t = 0;
        Map<String, Double> avMark = new HashMap<String, Double>();

        for (final Student st : students) {
            debtMarker = false;
            avMark.put("Математика", (DoubleStream.of(st.marks.get("Математика")).sum() / st.marks.get("Математика").length));
            avMark.put("Информатика", (DoubleStream.of(st.marks.get("Информатика")).sum() / st.marks.get("Информатика").length));
            avMark.put("Физика", (DoubleStream.of(st.marks.get("Физика")).sum() / st.marks.get("Физика").length));
            avMark.put("Философия", (DoubleStream.of(st.marks.get("Философия")).sum() / st.marks.get("Философия").length));
            avMark.put("Иностранный язык", (DoubleStream.of(st.marks.get("Иностранный язык")).sum() / st.marks.get("Иностранный язык").length));
            avMark.put("История", (DoubleStream.of(st.marks.get("История")).sum() / st.marks.get("История").length));


            for (Double c : avMark.values()) {
                if (c < 2.60) {
                    t++;
                    debtMarker = true;
                }
            }
            if (debtMarker && t > 3) {
                sum++;
            }

        }

        return sum;
    }
}




