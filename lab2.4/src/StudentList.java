public class StudentList {
    private static final int SIZE = 20;
    private final Student[] Students = new Student[SIZE];
    private int space = 0;

    public void append(Student std) {
        Students[space++] = std;
    }
    // сортировка методом простой вставки
    public void sorted(SortInterface sort) {
        int i = 1;
        while (i < space) { // идем по списку студентов
            Student current = Students[i]; // текущий студент
            int j = i - 1; // чтобы идти от конца к началу
            while (j >= 0 && sort.sortFunction(current, Students[j])) { // пока существует j и выполняется условие сортировки
                Students[j + 1] = Students[j]; // вставляем
                j--;
            }
            Students[j + 1] = current;
            i++;
        }
    }
    public <T> StudentList filtration(T filter, FilterInterface<T> func) { // на вход сам фильтр и функция
        StudentList newList = new StudentList(); // создаем новый список студентов
        int i = 0;
        while (i < space) { // идем по всем студентам старого списка
            if (func.filterFunction(filter, Students[i])) { // если студент соответствует критерию
                newList.append(new Student(Students[i])); // добавляем его копию в новый список
            }
            i++;
        }
        return newList;
    }
    public void print() {
        for (int i = 0; i < space; i++) {
            System.out.println(Students[i]);
        }
        System.out.println('\n');
    }
}
