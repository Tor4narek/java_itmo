// Домино
// Лабораторная 3
// 1. Игральная кость домино - от 0 до 6 каждая часть.
//Все кости уникальны. Всего 28 штук
//пусто 1 = 1 пусто!
//2. Набор домино
//3. Последовательность костей из набора берем случайную кость и добавляем в конец последовательности.
//Важно знать где конец
//На последовательности из 28 костей организовать выбрасывание костей по правилу
//Есть например число N = 2, я должен выкинуть из полседовательности кость.
//Если есть последоватльность
//Например выбрасываем 3/4  выводим оставшиеся и потом заново
//Массив только 1\
//
//Доминошка - два числа в одной переменной + ссылка на предыдущий
//        Метод для добавления ссылки в доминошку
//        В наборе храняться доминошки с числами и нулями как ссылки на предыдущий
//        Последовательность
//        Метод для выбора начала
//        Метод для создания последовательности
//        Проверка что не ссылка 0
//        Проверка что новый не тукущий
//        Заполнение
//        Заполняем ссылки рандомно
//
//Класс Домино
//Хранинит две приватные переменные
//    1.Переменная(bone) хранит число, сотоящее из двух цифр, которые нарисованы на кости.(Например 26 - значит, что на косте цифра 2 и 6)
//    2.Переменная(index) будет хранить индекс предыдущего элемента в наборе
//Конструктор( int b1-первая цифра, int b2-вторая цифра,int i)
//    1.Выделяем память под число на кости
//    2.Выделяем память под индекс предыдыдущего элмента в наборе
//Метод добавляения ссылки в кость(int i)
//    1.Возращаем домино с заполненой переменной index



 class domino {
    private int bone;
    private int index;
    public domino(int b){
        bone=b;
        index=0;
    }
    public void AddIndex(int i){
        index=i;
    }

}


