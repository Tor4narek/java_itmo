
// Класс Grass
// Наследуется от класса Cell, переопределяются методы, CellType, Update,print
public class Grass extends Cell{
    // конструктор травы, наследующий x и y из супер-класса
    public Grass (int x, int y){
        super(x,y);
    }
    // переопределённый CellType из пустой клетки
    public int CellType(){
        return grass;
    }
    // переопределённый Update из пустой клетки
    public Cell Update(Cell[][] X, Cell A) {
        Neighbors(X); // считаем, кто находится вокруг клетки
        if (Around[rabbit] > Around[grass]) // если кроликов вокруг больше, чем травы, то её съедают
            return new Cell(Xcoord, Ycoord);
        return A; // иначе ничего не меняется
    }
    // переопределённый print из пустой клетки
    public void print(){
        System.out.print("\uD83C\uDF3F");
    }
}

