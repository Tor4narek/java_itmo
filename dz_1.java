public class dz_1 {
    public static void main(String[] args) {
        int funt_sum = 10, shil_sum = 3, pens_sum = 0, funt_st = 5, shil_st = 2, pens_st = 0, sum;
        sum = (funt_sum*240+shil_sum*20+pens_sum)>=(funt_st*240+shil_st*20+pens_st)?((funt_sum*240+shil_sum*20+pens_sum)==(funt_st*240+shil_st*20+pens_st)?(0):((funt_sum*240+shil_sum*20+pens_sum) - (funt_st*240+shil_st*20+pens_st))):(-1);
        funt_sum = sum/240;
        shil_sum = (sum-funt_sum*240)/20;
        pens_sum = sum-(funt_sum*240)-(shil_sum*20);
        System.out.println(sum==0?("Сдачи нет"):(sum<0?("Ошибка"):(funt_sum+ "\n" +shil_sum+ "\n" + pens_sum)));
    }
}
