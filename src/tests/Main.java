package tests;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {
    static List<Student> students;
    DecimalFormat df = new DecimalFormat( "#.##" );

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        создание списка студентов
        students = new ArrayList<>();

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

        System.out.println("Введите имя и фамилию студента, оценки которого вы ходите узнать");
        String name = in.nextLine();
        System.out.println(averageMark(name));
    }


    private static Map<String, Double> averageMark(String name) {
        Map<String, Double> avMark = new HashMap<String, Double>();
        for (final Student st : students) {
            if (st.name.equals(name)) {
                avMark.put("Математика", (DoubleStream.of(st.marks.get("Математика")).sum()/st.marks.get("Математика").length));
                avMark.put("Информатика", (DoubleStream.of(st.marks.get("Информатика")).sum()/st.marks.get("Информатика").length));
                avMark.put("Физика", (DoubleStream.of(st.marks.get("Физика")).sum()/st.marks.get("Физика").length));
                avMark.put("Философия", (DoubleStream.of(st.marks.get("Философия")).sum()/st.marks.get("Философия").length));
                avMark.put("Иностранный язык", (DoubleStream.of(st.marks.get("Иностранный язык")).sum()/st.marks.get("Иностранный язык").length));
                avMark.put("История", (DoubleStream.of(st.marks.get("История")).sum()/st.marks.get("История").length));
            }
        }
        return avMark;
    }
}
