// Абстрактный тип данных (АТД) «Список»
public class List <T extends Comparable <T>> {

    private T[] obj; // массив объектов
    private int[] next; // массив ссылок
    private int start; // начало списка объектов
    private int space; // начало списка свободных

    public List (T[] array) {
        obj = array;
        int len = array.length;
        next = new int[len];
        start = -1; // -1 т.к список пустой
        int i;
        for (i = 0; i < len-1; i++) // расставляем ссылки для пустого списка
            next[i] = i+1;
        next[i] = -1; // конец пустого списка
        space = 0; // начало пустого списка
    }

    // возвращает позицию после последнего
    public Position End () {
        return new Position(-1);
    }

    // возвращает 1-ую позицию в списке L. Если список пустой, то возвращается End(L).
    public Position First () {
        return new Position(start); // если список пустой, то старт = -1
    }

    // возвращает прошлую позицию для текущей, если позиции есть, и -1, если её нет
    // старт не приходит и список не пустой

    // метод Before для получения прошлой позиции для текущей, если позиция сущесвтует. -1 если позиции нет
    // Идем по позициям, запоминаем текущую и слудующую позиции и возращаем прошлую для следующей позиции
    private int Before(Position P) {
        int current = start, nextPos = next[current]; // текущая и следующая позиции
        while (nextPos != -1) {
            if (nextPos == P.position)
                return current; // возвращаем прошлое для текущей позиции
            current = nextPos;
            nextPos = next[current];
        }
        return -1; // дошли до конца и не нашли нужную позицию в полных
    }

    // вставка в позицию
    // 1. Рассматриваем случай, когда лист полный (space =-1), выкидываем исключение
    // 2. Рассматриваем случай, когда вставлка в позицию End(L):
            // 2.1 Проверяем список на пустоту, перезаписываем start как space, space сдвигаем, следующий за start станет -1, записываем объект в позицию start
            // 2.2 Если списко не пустой, то ищуем последню позицию,находим следующую за ней, вставляем элемент и перезаписываем start, space
    // 3. Рассматриваем случай, когда вставка в любую другую позицию
    // Находим позицию перед нашей позицией, проверяем сущесвует ли она, если не сущесвтует, то ничего не делаем,
    // если существует, то проверяем не равна ли данная позиция start, если равна но приравниваем before к start
    // если существует, но данная позиция не равна start, nj
    public void Insert (T element, Position P) {
        if (P.position == -1) { // вставим x в позицию End(L)
            if (start == -1) { // список пустой
                start = space; // первым элементом станет первый из пустых
                space = next[space]; // переносим первый пустой в следующий для него
                next[start] = -1; // меняем ссылку для первого элемента на -1, потому что пока он последний
                obj[start] = element; // складываем элемент
            }
            else { // список не пустой
                int current = findLast();
                next[current] = space; // новый элемент запишем в первый из пустых
                obj[space] = element; // записываем элемент
                int spCopy = space;
                space = next[space]; // первый элемент из пустых переносим в следующий
                next[spCopy] = -1; // новый элемент последний, поэтому ссылка у него -1
            }
            return;
        }
        int before;
        if (P.position == start) // если позиция равна старту, то before приравниваем к старту
            before = start;
        else{
            before = Before(P);
            if(before==-1){ // проверяем существует ли позиция
                return;
            }
            else{
                before = next[before];
            }
        }
        obj[space] = obj[before]; // в первый пустой объект записываем старое содержание позиции
        obj[before] = element; // в нужную позицию записываем новое значение
        int nextspacecopy = next[space];
        next[space] = next[before]; // меняем ссылку для старого элемента
        next[before] = space; // меняем ссылку для нового элемента
        space = nextspacecopy; // обновляем позицию первого пустого элемента
        // если позиции p в списке L нет, то результат неопределен (ничего не делать)
    }

    // Delete(p, L) – удалить элемент списка L в позиции p.
    // Результат неопределен, если в списке L нет позиции p или p=End(L) (ничего не делать).
    public void Delete (Position P) {
        if (P.position != -1) { // если позиция не -1
            if (P.position == start) { // если удаляем первый элемент
                int nextstartcopy = next[start];
                next[start] = space;
                space = start;
                start = nextstartcopy;
                return;
            }
            int real = Before(P);
            if (real != -1) { // если позиция существует, то начинаем удаление
                // удаляем не первый элемент
                int real_next = next[real]; // удаляемый элемент
                next[real] = next[real_next];
                int spacecopy = space;
                space = real_next;
                next[real_next] = spacecopy;
            }
        }
    }

    // возвращает позицию в списке L объекта x. Если объекта в списке нет, то возвращается позиция End(L).
    // Если несколько значений, совпадает со значением x, то возвращается первая позиция от начала.
    public Position Locate (T X) {
        int current = start; // текущая позиция
        while (current != -1) { // идём до конца
            if (obj[current].compareTo(X) == 0) // если объект совпал с искомым
                return new Position(current); // возвращаем позицию найденного элемента
            current = next[current]; // обновляем ссылку
        }
        return new Position(-1); // если не нашли, то End(L)
    }

    // возвращается объект списка L в позиции p
    public T Retrieve (Position p) {
        if (p.position == -1) // Результат неопределен, если p=End(L)
            throw new MyException(p);
        if (p.position == start) // позиция в старте, то отдаём объект из старта
            return obj[start];
        int real = Before(p); // проверяем, что позиция существует
        if (real != -1) // если позиция существует, то отдаём объект из неё
            return obj[p.position];
        throw new MyException(p); // в L нет позиции p
    }

    // возвращает следующую за p позицию в списке L. Если p – последняя позиция в списке L,
    // то Next(p, L) = End(L). Результат неопределен, если p нет в списке или p=End(L) (выбросить исключение)
    public Position Next (Position P) {
        if (P.position == -1) // после после последнего исключение
            throw new MyException(P);
        if (P.position == start)
            return new Position(next[start]); // если позиция равна старту, то возвращаем следующий от старта
        int before = Before(P); // IsReal возвращает нам позицию до p, если p существует
        if (before != -1)
            return new Position(next[P.position]); // если позиция существует, то возвращаем следующую от неё
        throw new MyException(P);
    }

    // возвращает предыдущую перед p позицию в списке L.
    // Результат неопределен, если p = 1, p = End(L) или позиции p нет в списке L (выбросить исключение).
    public Position Previous (Position p) {
        if (p.position == start || p.position == -1) // у первого и после последнего нет прошлых
            throw new MyException(p);
        int before = Before(p); // IsReal возвращает нам позицию до p, если p существует
        if (before == -1)
            throw new MyException(p); // если не существует, то исключение
        return new Position(before);
    }

    // делает список пустым.
    public void Makenull () {
        if(start!=-1){
        next[findLast()] = space; // соединяем список полных и список пустых
        space = start; // переносим начало пустого в общее начало
        start = -1; // список пустой, поэтому старт станет -1
    }
    }

    // вспомогательный метод, ищущий последний существующий объект
    private int findLast () {
        int current = start, nextPos = next[start]; // текущая и следующая позиции
        while (nextPos != -1) { // идём до последнего элемента
            current = nextPos;
            nextPos = next[nextPos];
        }
        return current;
    }

    // вывод списка на печать в порядке расположения элементов в списке.
    public void Printlist () {

            int current = start; // текущая и следующая позиции
            while (current != -1) {
                System.out.print(obj[current] + " "); // печатаем объекты
                current = next[current]; // идём по ссылкам
            }
            System.out.println();
        }


}
