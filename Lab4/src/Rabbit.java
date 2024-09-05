// Класс Rabbit
// Наследуется от класса Змеи, переопределяются методы, CellType, Update,print
public class Rabbit extends Snake{
    // конструктор кролика, наследующий x, y и возраст, равный 1, у змеи (с помощью super)
    public Rabbit (int x, int y){
        super(x,y);
    }
    // переопределённый CellType из пустой клетки
    public int CellType(){
        return rabbit;
    }
    // переопределённый update из пустой клетки
    public Cell Update(Cell[][] X, Cell A) {
        Neighbors(X); // считаем, кто находится вокруг клетки
        Age++; // увеличиваем возраст кролика на 1
        if (Around[snake] >= Around[rabbit] && Around[snake]!=0 || Age > 3) // если вокруг змей не меньше, чем кроликов,
            // и хотя бы есть одна змея, то кролика съедают. Или кролик может умереть от старости
            return new Cell(Xcoord, Ycoord);
        return A; // если ни одно условие не выполнилось, то клетка останется пустой
    }
    // переопределённый print из пустой клетки
    public void print(){
        System.out.print("\uD83D\uDC30");
    }
}