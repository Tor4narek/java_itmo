//Класс Island
//В классе описывается остров
//Он состоит из клеток, на которые модно добавить змей, кроликов и траву
//Обитатели добавляются сразу при создании острова с помощью приватного класса
//Есть метод для вывода острова
//Метод для обновления острова
public class Island {
    private Cell Current[][], Next[][]; // два двумерных массива клеток, отвечающих за текущее и будущее состояние острова
    // конструктор острова
    public Island(){
        Current = new Cell[22][22]; // массивы 22*22, чтобы было удобно всё считать у крайних клеток
        Next = new Cell[22][22];
        int i, j; // итераторы
        for (i = 0; i<22; i++){
            for (j = 0; j<22; j++){
                Current[i][j] = new Cell(i, j); // заполняем массивы пустыми клетками
                Next[i][j] = new Cell(i, j);
            }
        }
        AddStart();
    }
    //Метод раставляет объекты по острову
    private void AddStart(){
        Current[1][1] = new Snake(1, 1);
        Current[1][2] = new Snake(1, 2);
        Current[3][4] = new Snake(3, 4);
        Current[6][8] = new Snake(6, 8);
        Current[8][8] = new Snake(8, 8);
        Current[9][7] = new Snake(9, 7);
        Current[12][4] = new Snake(12, 4);
        Current[1][20] = new Rabbit(1, 20);
        Current[4][18] = new Rabbit(4, 18);
        Current[6][20] = new Rabbit(6, 20);
        Current[8][20] = new Rabbit(8, 20);
        Current[18][1] = new Grass(18, 1);
        Current[19][2] = new Grass(19, 2);
        Current[20][4] = new Grass(20, 4);
        Current[20][3] = new Grass(20, 3);
    }
    // метод для вывода текущего состояния острова
    public void print(){
        int i, j; // итераторы
        for (i = 1; i<21; i++){ // не выводим рамку, которую добавили сами
            for (j = 1; j<21; j++){
                Current[i][j].print();
            }
            System.out.println();
        }
    }
    // метод для обновления всего острова
    public void Update(){
        int i, j; // итераторы
        for (i = 1; i<21; i++){
            for (j = 1; j<21; j++){
                Next[i][j] = Current[i][j].Update(Current, Current[i][j]);
                // проходимся по всему массиву Current и в массив Next записываем поэлементно обновлённые клетки
            }
        }
        // меняем местами Next и Current, делая все обновлённые значения текущими
        Cell[][] Temporary = Next; // чтобы не потерять данные создаём временный массив
        Next = Current;
        Current = Temporary;
    }
}
