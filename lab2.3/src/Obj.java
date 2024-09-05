public class Obj implements Comparable<Obj>{
    private int num; // храним натуральное число
    public Obj(int n){
        num = n;
    }
    public int compareTo(Obj o) {
        return this.dels() - o.dels();
    }
    public String toString(){
        return num+"";
    }
    public int dels() {
        int count = 0; // Инициализация счетчика делителей
        int sqr = (int) Math.sqrt(num); // Вычисление квадратного корня из num
        int i;
        for ( i = 1; i < sqr; i++) {
            if (num % i == 0) { // Проверка, является ли i делителем num
                    count += 2; // Иначе увеличиваем счетчик на 2 (для i и num/i)
            }
        }
        if(i*i==num){
            count++;
        }
        return count; // Возвращаем количество делителей
    }
}
