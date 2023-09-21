public class dz_1 {
    public static void main(String[] args) {
        int funt_sum = 25, shil_sum = 0, pens_sum = 0, funt_st = 21, shil_st = 9, pens_st = 14, sum;
        sum = (funt_sum*240+shil_sum*20+pens_sum) - (funt_st*240+shil_st*20+pens_st);
        System.out.println(sum==0?("Сдачи нет"):(sum<0?("Ошибка"):(sum/240 +" фунтов"+ "\n" + (sum%240)/20 +" шилингов"+ "\n" + (sum%20)+" пенсов")));
    }
}
