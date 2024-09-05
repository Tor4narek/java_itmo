
// Класс Cell
// Мы описываем пустую клетку, её можно вывести, обновить по правилам из условия, узнать соседей,возратить тип клетки.
public class Cell {
    protected int Xcoord, Ycoord; // кооридинаты клетки
    protected static int[] Around = new int[4]; // массив для хранения информации об обитателях вокруг клетки
    protected static int cell = 0, snake = 1, rabbit = 2, grass = 3; // статические переменные для индексов этого массива (клетка, трава, удав, кролик) "константы"
    // конструктор клетки, получает на вход координаты
    public Cell (int x, int y){
        Xcoord = x;
        Ycoord = y;
    }
    // метод, возращающий тип клетки, для того чтобы не хранить вычисляемые значения
    public int CellType(){
        return cell;
    }
    // метод для обновления клетки по правилам, получает на вход массив текущего поля и саму клетку
    public Cell Update(Cell[][] X, Cell MyCell){
        Neighbors(X); // считаем, кто находится вокруг клетки
        if (Around[snake] >= 2) // если хотя бы вокруг две змеи, то клетка станет змей
            return new Snake(Xcoord,Ycoord);
        else
        if (Around[rabbit] >= 2) // если хотя бы вокруг два кролика, то клетка станет кроликом
            return new Rabbit(Xcoord,Ycoord);
        else
        if (Around[grass] > 0) // если есть трава, то станет травой
            return new Grass(Xcoord, Ycoord);
        return MyCell; // если ни одно условие не выполнилось, то клетка останется пустой
    }
    // Метод получает массив текущего состояния острова, считает соседей, и вычитает центральную клетку
    protected void Neighbors(Cell[][] Mass) {
        Clean(); // сначала чистим массив, потом идём по всем соседям клетки по кругу
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                Around[Mass[Xcoord + i][Ycoord + j].CellType()]++;
            }
        }
        // Вычитаем центральную клетку
        Around[Mass[Xcoord][Ycoord].CellType()]--;
    }

    // вспомогательный метод для очистки массива с информацией о соседях
    private static void Clean(){
        Around[cell] = 0;
        Around[snake] = 0;
        Around[rabbit] = 0;
        Around[grass] = 0;
    }
    // вывод клетки
    public void print(){
        System.out.print("\uD83D\uDFEB");
    }
}

