
// Класс Snake
// Наследуется от класса Cell, переопределяются методы, CellType, Update,print, добавляется возраст змеи
public class Snake extends Cell{
    protected int Age; // переменная отвечает за возраст змеи
    // конструктор змеи, наследующий x и y из супер-класса и добавляющий возраст равный 1
    public Snake (int x, int y){
        super(x,y);
        Age = 1;
    }
    // переопределённый CellType из пустой клетки
    public int CellType(){
        return snake;
    }
    // переопределённый Update из пустой клетки
    public Cell Update(Cell[][] X, Cell A) {
        Neighbors(X); // считаем, кто находится вокруг клетки
        Age++; // увеличиваем возраст змеи на 1
        if (Around[snake] > 5 || Age > 6) // если слишком много змей вокруг или возраст больше 6, то клетка пустеет
            return new Cell(Xcoord, Ycoord);
        return A; // если ни одно условие не выполнилось, то клетка останется пустой
    }
    // переопределённый print из пустой клетки
    public void print(){
        System.out.print("\uD83D\uDC0D");
    }
}
