public class Main {
    public static void main(String[] args) {
        StudentList list = new StudentList();
        list.append(new Student("Тигран", 19, (100+90+60) / 3, "Дизайнер"));
        list.append(new Student("Ян", 18, (103+91+75) / 3, "Инженер"));
        list.append(new Student("Егор", 18, (102+96+30) / 3, "Веб-разработчик"));
        list.append(new Student("Ульяна", 19, (61+67+89) / 3, "Бэкэнд-разработчик"));
        list.append(new Student("Гриша", 18, (100+90+60) / 3, "Веб-разработчик"));
        list.append(new Student("Макс", 18, (100+100+100) / 3, "Системный администратор"));
        list.append(new Student("Алина", 20, (90+90+90) / 3, "Дизайнер"));
        list.append(new Student("Настя", 19, (67+90+60) / 3, "Бэкэнд-разработчик"));
        list.append(new Student("Алина", 19, (103+95+99) / 3, "Инженер"));


        list.print();
        System.out.println("Сортировка по невозрастанию:");
        list.sorted(Student::nonIncreasingName);
        list.print();
        System.out.println("Сортировка по неубыванию:");
        list.sorted(Student::nonDecreasingName);
        list.print();

        System.out.println("Фильтр по специализации Инженер");
        list.filtration("Инженер", (a, b) -> b.getSPEC().compareTo(a) == 0).print();
        System.out.println("Фильтр по среднему баллу не менее 90");
        list.filtration(90, (cnst, std) -> std.getGPA() >= cnst).print();

    }
}
