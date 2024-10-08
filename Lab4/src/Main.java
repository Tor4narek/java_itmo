//Остров размером 20x20 квадратов заселен разными взаимодействующими формами жизни.
//        Удавы поедают кроликов, а сами кролики питаются травой. Имеется по несколько
//        представителей каждого вида (количество и положение представителей каждого вида
//        задается в конструкторе острова). Большинство квадратов имеет восемь соседних (кроме
//        квадратов на границах острова), как показано на рисунке:
//        Здесь квадрат Y граничит с восемью соседними квадратами X, а вся структура представляет собой
//        уменьшенную модель шахматной доски.
//        Предусмотрены следующие правила определения того, кто продолжит существование по
//        прошествии единицы времени в зависимости от состава соседних квадратов:
//        
//        квадрат с удавом становится пустым, если количество удавов в соседних квадратах больше
//        5 (погибает от перенаселения) или его возраст становится больше 6 единиц времени
//        (умирает от старости), иначе квадрат не изменяется;
//        
//        квадрат с кроликом становится пустым, если количество удавов в соседних квадратах
//        больше или равно количеству кроликов (кролика съедают) или его возраст становится
//        больше 3 единиц времени (умирает от старости), иначе квадрат не изменяется;
//        
//        квадрат с травой становится пустым, если вокруг квадратов с травой меньше, чем
//        квадратов с кроликами (трава съедается кроликами), иначе квадрат не изменяется;
//        
//        пустой квадрат заполняется удавом, если вокруг не менее 2 удавов, заполняется кроликом,
//        если вокруг не менее 2 кроликов, заполняется травой, если она есть в каком-либо соседнем
//        квадрате, иначе квадрат не изменяется.
//        Промоделируйте N шагов. В ходе моделирования необходимо выдавать на экран текущее
//        состояние острова в каждую единицу времени, различая пустые квадраты, квадраты, заполненные
//        травой, удавами и кроликами.
public class Main {
    public static void main(String[] args) {
        Island MyIsland = new Island(); // создаём остров
        MyIsland.print(); // выводим начальное состояние острова
        int Time = 10; // выбираем, сколько будет идти симуляция
        int i; // итератор
        for (i = 0; i < Time; i++){
            MyIsland.Update(); // обновляем остров
            System.out.println();
            MyIsland.print(); // выводим остров
        }
    }

}

