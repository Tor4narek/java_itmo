// Обобщенный метод раз
public class Main {
    public static <T extends Comparable <T>> void Split(List<T> A, List<T> Min, List<T> Max){
      Position current = A.First();
      Position min = A.First();
      // цикл для поиска минимального элементв
      while (!current.equal(A.End())){
          if(A.Retrieve(current).compareTo(A.Retrieve(min))<=0){
              min = current;
          }
          current = A.Next(current);
      }
      current = A.First();
        // цикл раскидывает объекты списка по другим спискам
        while (!current.equal(A.End())){
           if(A.Retrieve(current).compareTo(A.Retrieve(min))<=0)
               Min.Insert(A.Retrieve(current),Min.End());
           else
               Max.Insert(A.Retrieve(current),Max.End());
           current = A.Next(current);
        }
        A.Makenull();
    }
    public static void main(String[] args){
        Obj[] nums = new Obj[12];
        Obj[] nums2 = new Obj[12];
        Obj[] nums3 = new Obj[12];
        List<Obj> A = new List<Obj>(nums);
        List<Obj> B = new List<Obj>(nums2);
        List<Obj> C = new List<Obj>(nums3);
        A.Insert(new Obj(22), A.End());
        A.Insert(new Obj(44), A.End());
        A.Insert(new Obj(100), A.First());
        A.Insert(new Obj(11), A.End());
        A.Insert(new Obj(13), A.End());
        A.Insert(new Obj(13), A.First());
        A.Printlist();

        A.Printlist();
        Split(A,B,C);
        B.Printlist();
        C.Printlist();

        Integer[] numsInt = new Integer[12];
        Integer[] numsInt2 = new Integer[12];
        Integer[] numsInt3 = new Integer[12];
        List<Integer> AInt = new List<Integer>(numsInt); // создаём лист для чисел
        List<Integer> AInt2 = new List<Integer>(numsInt2); // создаём лист для чисел
        List<Integer> AInt3 = new List<Integer>(numsInt3); // создаём лист для чисел

        // работаем с листом чисел
        AInt.Insert(22, A.End()); // показываем, что работает добавление в пустой список
        AInt.Insert(44, A.End()); // показываем, что работает добавление в конец
        AInt.Insert(11, A.First()); // показываем, что работает добавление в начало
        AInt.Printlist(); // выводим
        Split(AInt,AInt2,AInt3);

        AInt2.Printlist();
        AInt3.Printlist();

        String[] words = new String[12];
        String[] words2 = new String[12];
        String[] words3 = new String[12];
        List<String> AStr= new List<String>(words); // создаём лист для строк
        List<String> AStr2= new List<String>(words2); // создаём лист для строк
        List<String> AStr3= new List<String>(words3); // создаём лист для строк
        // работаем с листом строк
        AStr.Insert("Hello", C.End());
        AStr.Insert("World", C.End());
        AStr.Insert("my", C.End()); // добавляем строки
        AStr.Insert("World", C.End());
        AStr.Printlist();
        Split(AStr,AStr2,AStr3);

        AStr2.Printlist();
        AStr3.Printlist();








    }
    //_______________________________________________________
}