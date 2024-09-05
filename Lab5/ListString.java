//Класс ListString - должен описывать новый тип данных, который работает как строка, но удобнее
public class ListString {
    //В нашем классе строка будет состоять из блоков, которые будут содержать символы
    private static class StringItem{
        private static final int SIZE = 16;
        private char[] symbols;
        private byte size;
        private StringItem next;
        //Конструктор по умолчанию
        public StringItem(){
        //1. Инициализация переменной symbols
             symbols = new char[SIZE];
        //2. Инициализация переменных next и size
            next = null;
            size = 0;
        }
        // Копирующий конструктор
        public StringItem(StringItem item){
            //1. Выделяем память под символьный массив и инициализируем переменную symbols
            symbols = new char[SIZE];
            //2. Инициализируем переменную next и size
            next = item.next;
            size = item.size;
            //3. Копируем значения из item в текущий объект с помощью метода copyArray
            copyArray(item.symbols,this.symbols,0,item.size-1,0);
              }
            // метод для соединения двух соседних блоков
            private int join(){
                int counter = this.size;
                // Проверяем, что следующий блок существует и сумма размеров текущего и следующего блока не превышает SIZE
                while (this.next != null && this.size + this.next.size <= SIZE) {
                    // Копируем символы из следующего блока в текущий блок, начиная с конца текущего блока
                    copyArray(this.next.symbols, this.symbols, 0, this.next.size - 1, this.size);
                    // Увеличиваем счетчик символов в текущем блоке и переходим к следующему блоку
                    counter += this.next.size;
                    this.size += this.next.size;
                    this.next = this.next.next;
                }
                return counter;
            }
        // метод для копирования символов из одного блока в другой
        private void copyArray(char[] from,char[] to, int start_index, int finish_index, int copy_start){
            for (int i = start_index, j = copy_start; i <= finish_index; i++, j++) {
                to[j] = from[i];
            }
                //from - массив, откуда копируем, to - массив куда, start_index и finish_index - границы копирования
                //copy_start - индекс начала вставки
            }
        //  метод для разделения блока на два по индексу
        private void split(int index){
            //1. Создаем новый блок в ссылку записываем ссылку из item
            StringItem NewItem = new StringItem();
            NewItem.next = next;
            next = NewItem;
            // 2. все символы начиная с index до size копируем в новый блок
            copyArray(symbols, NewItem.symbols,index,size-1,0);
            // 3. Уменьшаем size исходного блока тем самым убираем ненужные символы
            NewItem.size = (byte) (size-index);
            size = (byte) index;

            }
    }
    private StringItem head; // хранит объект с которого начинается строка, если строка пустая head = null;
    //конструктор по умолчанию
    public ListString(){
        // инициализация переменной head
        head = null;
    }

    //конструктор, приобразуюший строку в ListString
    public ListString(String s) {
        int len = s.length();
        if(len!=0){
        int start = 0;
        head = new StringItem();
        StringItem currentBlock = head;
        while (currentBlock!=null) {
            int blockSize = Math.min(len, 16);
            currentBlock.size = (byte) blockSize;
            s.getChars(start, start + blockSize, currentBlock.symbols, 0);
            len -= blockSize;
            start += blockSize;
            if (len > 0) {
                currentBlock.next = new StringItem();
            } else {
                currentBlock.next = null;
            }
            currentBlock = currentBlock.next;
        }
    }}

    // 1. Используем метод getChars() // явно копируем если символов меньше 16ти
    //2. на каждый промежуток в 16 символов вызываем метод и передаем в качестве параметра новый блок(перед этим считаем сколько символов в строке)
    public void print(){
        StringItem currentBlock = head;
        while (currentBlock!=null){
            for(int i=0;i<currentBlock.size;i++){
                System.out.println(currentBlock.symbols[i]);

            }
            System.out.println("________");
            currentBlock=currentBlock.next;
        }
    }
    // копирующий конструктор
    public ListString(ListString s){
        if(s.head!=null){
            StringItem oldCurrentBlock = s.head;
            head = new StringItem(oldCurrentBlock);
            StringItem currentBlock= head;
            while (oldCurrentBlock.next!=null){
                currentBlock.next = new StringItem(oldCurrentBlock.next);
                currentBlock = currentBlock.next;
                oldCurrentBlock = oldCurrentBlock.next;
            }
        }
//        1. инициализируем head
//        2. проверяем s на пустоту
//        3. копируем блоки(копирующий конструктор)

    }
    // Метод, который возращает последний блок строки
    private StringItem getLastBlock(){
        StringItem currentBlock = head;
        while (currentBlock.next!=null){
            currentBlock = currentBlock.next;
        }
//        1. Идем по блокам пока current!=null
//        2. Возращаем блок
        return currentBlock;
    }

    // Метод для проверки валидности index
    private BlockIndex indexValid(int index) {
        int counter = 0;
        StringItem currentBlock = head;
        StringItem lastBlock = null;
        BlockIndex Bindex = null;
        if(index<=0){
            Bindex = new BlockIndex(-1, null);
        }
        else{
        int ind = index-1;
        // Продолжаем перебирать блоки, пока не достигнем нужного индекса или не пройдем все блоки
        while (currentBlock != null) {
            // Если суммарный индекс в текущем блоке плюс его размер больше или равен заданному индексу,
            // это означает, что нужный индекс находится внутри текущего блока
            if (counter + currentBlock.size > ind) {
                // Вычисляем индекс внутри текущего блока
                int innerIndex = ind - counter;
                // Создаем объект BlockIndex с этим индексом и ссылкой на текущий блок
                Bindex = new BlockIndex(innerIndex, lastBlock);
                break; // Прекращаем перебор блоков
            }
            // Увеличиваем суммарный индекс на размер текущего блока и переходим к следующему блоку
            counter += currentBlock.size;
            lastBlock = currentBlock;
            currentBlock = currentBlock.next;
        }

        // Если индекс находится за пределами всех блоков, создаем объект BlockIndex с индексом -1 и ссылкой на null
        if (Bindex == null) {
            Bindex = new BlockIndex(-1, null);
        }}

        // Возвращаем объект BlockIndex
        return Bindex;
    }


    //        2. Если индекса не существует выполняем создаем объект класса BlockIndex и заполняем его index = -1, item = null
//        3. Если индекс есть возращаем блок и высчитываем где именно в блоке находиться индекс и тоже возращаем
//            3.1 возврат осуществляется с помошью класса BlockIndex. Создаем объект класса заполняем index и item и возращаем объект
    // Статический класс будет хранить информацию об валидности индекса, будет хранить блок в котором индекс и расположение индекса в блоке
    private static class BlockIndex{
        private int index;
        private StringItem item;
        // конструктор
        public BlockIndex(int index, StringItem item){
            this.index = index;
            this.item = item;
        }
    }
    //Mетод length возращает реальную длину строки и уменьшает строку
    public int length(){
    int counter = 0;
    StringItem currentBlock = head;
    while(currentBlock != null){
       // Прибавляем к counter вызов join на CurrentBlock
        counter+= currentBlock.join();
        currentBlock = currentBlock.next;
        }
   // возвращаем Counter
        return counter;
   // идем по блокам  и на каждом вызываем join, прибавляя счетчик
    }
    //Метод char charAt(int index) - возращает символ в позиции index
    public char charAt(int index){
       // 1. Проверяем валидность index
        BlockIndex bindex_0 = indexValid(index);
        if(bindex_0.index==-1){
            throw new InvalidIndexException(index);
        }
        BlockIndex bindex = new BlockIndex(bindex_0.index,bindex_0.item==null?head:bindex_0.item.next);
        return bindex.item.next.symbols[bindex.index];

       // 2. в полученном блоке находим символ и возращаем его
    }
//    //Заменить в строке символ в позиции index на символ ch
  public void setCharAt(int index, char ch)
    {
        BlockIndex bindex_0 = indexValid(index);
        if(bindex_0.index==-1){
            throw new InvalidIndexException(index);
        }
        BlockIndex bindex = new BlockIndex(bindex_0.index,bindex_0.item==null?head:bindex_0.item.next);
        bindex.item.symbols[bindex.index]=ch;

////       1. Проверяем валидность index
////        2. В полученном блоке заменяем символ
    }
////    Взятие подстроки, от start до end, не
////    включая end, возвращается новый объект
////    ListString, исходный не изменяется. Если end
////    не существующая позиция, то возвращается
////    подстрока от start до конца строки
    public ListString substring(int s, int e) {  // написать все случаи три случая они в одном блоке, они в разных и end не существует, они в разных end и существует
//        //возращаем строку
//        1. Найти позицию start
        if(s==e){
            return new ListString();
        }
        else if(e<s){
            int fin = e;
            e = s; s = fin;
        }
            ListString substring = new ListString();
            BlockIndex start_0 = indexValid(s);
            BlockIndex end_0 = indexValid(e);
            if(start_0.index==-1){
                throw new InvalidIndexException(s);
            }
            else{
                BlockIndex start = new BlockIndex(start_0.index,start_0.item==null?head:start_0.item.next);
                BlockIndex end = new BlockIndex(end_0.index,end_0.index==-1?null:end_0.item==null?head:end_0.item.next);
                // start и end в одном блоке
                if(start.item==end.item){
                    substring.head= new StringItem();
                    substring.head.copyArray(start.item.symbols, substring.head.symbols,start.index,end.index,0);
                    substring.head.size=(byte) (end.index-start.index);
                }
                else {
                    // Обработка случая, когда начальный и конечный индексы находятся в разных блоках
                    StringItem current = new StringItem();
                    substring.head = current;
                    // Копирование символов из первого блока
                    current.copyArray(start.item.symbols, current.symbols, start.index, start.item.size - 1, 0);
                    current.size = (byte) (start.item.size - start.index);
                    // Переход к следующему блоку после начального
                    StringItem nextItem = start.item.next;
                    // копирование блоков
                        while (nextItem != end.item) {
                            current.next = new StringItem(nextItem);
                            current = current.next;
                            current.size = nextItem.size;
                            nextItem = nextItem.next;
                        }
                        // Копирование символов из последнего блока
                    if(end.item!=null){
                    current.next = new StringItem();
                    current = current.next;
                    current.copyArray(end.item.symbols, current.symbols, 0, end.index, 0);
                    current.size = (byte) (end.index);
                    }
                    }
                }
//        2. Найти позицию End
//        3. Создать пустую строку ListSrting
//        4. Добавить блок и скопировать туда символы, которые нужны
//        5. Скопировать блок целиком(если нужно)
//        6. Добавить блок и скопировать символы которые нужны
//        7. Вернуть результат
        return substring;
    }
//   // Метод для добавления в конец строки символ (в конец символьного массива последнего блока, если там есть свободное место, иначе в начало символьного массива нового блока)
   public void append(char ch){

        StringItem lastBlock = this.getLastBlock();
        if(lastBlock.size== StringItem.SIZE){
            StringItem newBlock = new StringItem();
            newBlock.symbols[0]=ch;
            newBlock.size=1;
            lastBlock.next=newBlock;
        }
        else{
            lastBlock.symbols[lastBlock.size]=ch;
            lastBlock.size++;
        }
//        1. Находим последний блок (getLastBlock(this))
//        2. Если он заполнен полностью создаем новый блок
//        3. Если нет то кладем символ в конец строки
    }
    public void append(ListString s){
        if(s.head!=null){
            StringItem lastBlock = this.getLastBlock();
            ListString newString = new ListString(s);
            lastBlock.next = newString.head;
        }
//        1. Проверяем строку на пустоту
//        2. находим последний блок текущей строки(getLastBlock(string))
//        3. Передаем ссылку на первый блок входящей строки в последний блок текущей строки
    }
   public void append(String s){
       if(!s.isEmpty()){
           StringItem lastBlock = this.getLastBlock();
           ListString newString = new ListString(s);
           lastBlock.next = newString.head;
       }
        //проверяем что строка не пустая
        //Создаем ListString в качестве параметра передаем строку
        //вызываем метод append передаем в качестве параметра ListString
   }
//    //Метод, который вставляет в строку в позицию index строку ListString (разбить блок на два по позиции index и строку вставить между этими блоками)
    public void insert(int index, ListString string){ // не все так просто!!!
        if(string.head!=null){
//    1. Проверярем index (indexValid(index))
        BlockIndex bindex_0 = indexValid(index);
        if(bindex_0.index==-1){
            throw new InvalidIndexException(index);
        }
        BlockIndex bindex = new BlockIndex(bindex_0.index,bindex_0.item==null?head:bindex_0.item.next);
        StringItem last = bindex_0.item;
        ListString newString = new ListString(string);
        insert(bindex,newString,index,last);
//    2. Копируем ListString c помощью конструктора
//    3. Вызываем метод insert(Bindex, newstring,index)
    }}
    public void insert(int index, String  string){ // не все так просто!!!
        if(string.length()!=0){
        BlockIndex bindex_0 = indexValid(index);
        if(bindex_0.index==-1){
            throw new InvalidIndexException(index);
        }
        BlockIndex bindex = new BlockIndex(bindex_0.index,bindex_0.item==null?head:bindex_0.item.next);
        StringItem last = bindex_0.item;
        ListString newString = new ListString(string);
        insert(bindex,newString,index,last);
//        1. Проверярем index (indexValid(index))
//        2. Преобразуем String в ListString
//        3. Вызываем метод insert(Bindex, newstring,index)
    }}
     private void insert(BlockIndex Bindex,ListString string, int index, StringItem last){
//        1. Если index = 1, значит мы вставляем в начало
         if(index==1){
             string.getLastBlock().next = Bindex.item;
             head = string.head;
         }
//         1.1 Записываем в конечный блок string в next Bindex.Block (getLastBlock)
//        2. Если index не равен 1, но Bindex равен 0, тогда
         if(index!=1 && Bindex.index==0){
             last.next=string.head;
             string.getLastBlock().next = Bindex.item;
         }
//            2.1 Вызываем метод  indexValid(index-1), чтобы получить предыдущий блок
//            2.2 В предыдущий блок в next записываем ссылку на string.head
//            2.3 Записываем в конечный блок string в next Bindex.Block (getLastBlock)
//        3. Если Bindex по середине блока
         if(Bindex.index!=0 && index!=1){
             Bindex.item.split(Bindex.index);
             StringItem next = Bindex.item.next;
             Bindex.item.next = string.head;
             string.getLastBlock().next = next;

         }
//            3.1 делим Bindex.block с помощью split
//            3.2 в ссылку первой части блока записываем string.head
//            3.3 Записываем в конечный блок string в next вторую часть блока (getLastBlock)
     }
//
//
//    // переопределяем метод torString(). Перевод ListStirng в String
    public String toString(){
//        1. делаем массив char по длине ListString
            int len = this.length();
            char[] charString = new char[len];
            int startCopy = 0;
            StringItem currentBlock = this.head;
            while (currentBlock!=null){
                currentBlock.copyArray(currentBlock.symbols,charString,0,currentBlock.size-1,startCopy);
                startCopy +=(currentBlock.size);
                currentBlock = currentBlock.next;
            }
//        2. проходим по всему ListString и собираем в него все char
        return String.valueOf(charString);
//        3. встроенным в java методом делаем из массива char одну строку и возвращаем её
        }
//    // метод для копирования символов из одного массива в другой (5 параметров)
//
//
//    //Метод заменяет последнее вхождение строки string в объекте на строку newstring. Если строки string в объекте нет, то объект не изменяеться
    public void replace(ListString string, ListString newstring){

        int len = string.length();
        if(len<this.length()){
        BlockIndex start = new BlockIndex(0,head);
        BlockIndex end_0 = indexValid(len);
        BlockIndex end = new BlockIndex(end_0.index,end_0.item==null?head:end_0.item.next);
        ListString newstr = new ListString(newstring);
        if(findSum(string, len, start, end)){
            replace(start,end,newstr);
        }}
    }
    public void replace(ListString string, String newstring){
        int len = string.length();
        if(len<this.length()){
        BlockIndex start = new BlockIndex(0,head);
        BlockIndex end_0 = indexValid(len);
        ListString newsrt = new ListString(newstring);
        BlockIndex end = new BlockIndex(end_0.index,end_0.item==null?head:end_0.item.next);

        if(findSum(string, len, start, end)){
            replace(start,end,newsrt);
        }}
    }
//    public void replace(ListString string, String newstring) {
////        1. Переводим строку в ListString
////        2. Вызываем метод  replace(string ,newstring) передаем в качестве параметра строку ListString // лучше так не делать
//    }
    // hashSum - сумма хеша в строке

//        Идем по блокам по массивам посимвольно и сумируем хеши
    // hashSum - сумма хеша в подстроке
    //в делит два действия
      //      1.
//Вспомогательный метод для подсчёта хэша подстроки определённой длины от заданного старта
private int hashSum(BlockIndex Start, int StringLen){
    int HashSum = 0; // искомая сумма
    BlockIndex Current = new BlockIndex(Start.index, Start.item); // создаём копию старта
//    if (Start.item != null) // если он null, то останемся в head, иначе попадём в следующий
//        Current.item = Start.item.next;
    for (int i = 0; i < StringLen; i++){
        if (Current.item == null) // если мы дошли до конца строки, а i < StringLen, то возвращаем -1 вместо суммы
            return -1;
        HashSum += Current.item.symbols[Current.index]; // прибавляем хэш к сумме
        // обновляем положение текущего символа
        if (Current.index == Current.item.size - 1) {
            // если символ был последним в айтеме, то идём в следующий айтем
            Current.index = 0;
            Current.item = Current.item.next;
        }
        else
            // иначе просто увеличиваем индекс
            Current.index++;
    }
    return HashSum; // возвращаем результат
}
    private boolean findSum(ListString string, int stringLen, BlockIndex start,BlockIndex end){
        BlockIndex start0= new BlockIndex(0,string.head);
        int stringHash = hashSum(start0,stringLen);
        start0 = new BlockIndex(start.index,start.item);
        BlockIndex end0 = new BlockIndex(end.index,end.item);
        int currentHashSum = hashSum(start,stringLen);
        int startHash = start.item.symbols[start.index];
        int endHash;
        int count = 0;
        boolean isHash = false;
        while (end0.item!=null){

            end0.index++;
            if(end0.index==end0.item.size){
                end0.index = 0;
                end0.item = end0.item.next;
            }
            start0.index++;
            if(start0.index==start0.item.size){
                start0.index=0;
                start0.item= start0.item.next;
            }
            if(end0.item==null){
                break;
            }
            endHash = end0.item.symbols[end0.index];
            currentHashSum = currentHashSum-startHash+endHash;
            startHash =  start0.item.symbols[start0.index];
            count++;
            if(currentHashSum==stringHash && equal(start0,string)){
                start.index = start0.index;
                start.item = start0.item;
                end.index = end0.index;
                end.item = end0.item;
                isHash=true;
                //start  = new BlockIndex(start0.index,start0.item);
                //end  = new BlockIndex(end0.index,end0.item);
            }
        }
        if(isHash){
            return true;
        }
        return false;


    }
    private boolean equal(BlockIndex start, ListString string){
        BlockIndex startCopy = new BlockIndex(start.index, start.item);
        BlockIndex stringItem = new BlockIndex(0,string.head);
        while (stringItem.item!=null){
            if(startCopy.item.symbols[startCopy.index]!=stringItem.item.symbols[stringItem.index]){
                return false;
            }
            stringItem.index++;
            startCopy.index++;
            if(stringItem.index==stringItem.item.size){
                stringItem.index = 0;
                stringItem.item = stringItem.item.next;
            }
            if(startCopy.index==startCopy.item.size){
                startCopy.index = 0;
                startCopy.item = startCopy.item.next;
            }
        }
    return true;
    }
    private void replace(BlockIndex start, BlockIndex end, ListString string){
        // start и end в одном блоке
        if(string.head==null){
            if(start.item==end.item){
                StringItem StartNext = new StringItem();
                end.item.split(end.index+1);
                StartNext.next = end.item.next;
                start.item.copyArray(start.item.symbols,StartNext.symbols,0,start.index,0);
                StartNext.size = (byte) start.index;
                start.item.size = (byte) start.index;
            }
            if(start.item!=end.item) {
                start.item.size = (byte) start.index;
                StringItem newEnd = new StringItem();
                newEnd.copyArray(end.item.symbols,newEnd.symbols,end.index+1,end.item.size-1,0);
                newEnd.next = end.item.next;
                start.item.next = newEnd;
                newEnd.size = (byte) ((byte)end.item.size-1-end.index);
            }
        }
        else{
        if(start.item==end.item){
            StringItem StartNext = new StringItem();
            StartNext.next = start.item.next;
            start.item.next = string.head;
            start.item.copyArray(start.item.symbols,StartNext.symbols,end.index+1,end.item.size-1,0);
            StartNext.size = (byte) ((byte)end.item.size-1-end.index);
            start.item.size = (byte) start.index;
            string.getLastBlock().next=StartNext;
        }
        if(start.item!=end.item) {
            start.item.size = (byte) start.index;
            start.item.next = string.head;
            StringItem newEnd = new StringItem();
            end.item.copyArray(end.item.symbols,newEnd.symbols,end.index+1,end.item.size-1,0);
            newEnd.size = (byte) ((byte)end.item.size-1-end.index);
            string.getLastBlock().next=newEnd;
        }
        }

    // В одном блоке
    // в соседних блоках
    // целый блок
    // start в начале то нужен предыдущий
    }}

//        старт = 1 находится в head под номером 0
//        находим блок где находиться end и позицию в этом блоке
//        Цикл пока (currentBlockEnd !=null) {
//            if(hashS==sum) {
//
//            }
//            if(hashS!=sum){
//            hashS-currentBlockStart[currentBlockStartIndex]
//            hashS+currentBlockEnd[currentBlockEndIndex]
//            start.updatePos
//            end.updatePos}
//
//        }
//    Метод для посимовольного нахождения вхождения
//    private void findLastHash(BlockIndex start, BlockIndex end){

//        }
//        }
//    }
//
//}}
