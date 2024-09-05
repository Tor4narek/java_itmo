// Класс  Student
public class Student {
    private final String NAME; // имя
    private final int AGE; // возраст
    private final int GPA; // средний балл
    private final String SPEC; // специлизация

    // Конструктор
    public Student(String name, int age, int gpa, String specialization) {
        this.NAME = name;
        this.AGE = age;
        this.GPA = gpa;
        this.SPEC = specialization;
    }

    // Копирующий конструктор
    public Student(Student std){
        this(std.NAME,std.AGE,std.GPA,std.SPEC);
    }

    // Переопределяем toString
    public String toString() {
        return NAME + ": " + AGE + " лет, " + GPA + " GPA, " + SPEC;
    }
    // Геттер имени
    public String getNAME() {
        return NAME;
    }
    // Геттер возраста
    public int getAGE() {
        return AGE;
    }
    // Геттер GPA
    public float getGPA() {
        return GPA;
    }
    // Геттер специализации
    public String getSPEC() {
        return SPEC;
    }

    // Сравнение по неубыванию имени
    public boolean nonDecreasingName(Student std) {
        int cName = this.NAME.compareTo(std.NAME);
        if (cName < 0) return true; // если имя "меньше", возвращает истину
        if (cName == 0) return this.AGE <= std.AGE; // если имена одинаковые сравнивает по возрасту
        return false;
    }

    // Сравнение по невозрастанию имени
    public boolean nonIncreasingName(Student std) {
        int cName = this.NAME.compareTo(std.NAME);
        if (cName > 0) return true; // если имя "больше", возвращает истину
        if (cName == 0) return this.AGE >= std.AGE; // если имена одинаковые сравнивает по возрасту
        return false;
    }
}
