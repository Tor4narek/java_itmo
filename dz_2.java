public class dz_2 {
    public static void main(String[] args) {
        int  st=27;
        int sd = 100-st;
        System.out.println(sd==0?("Сдачи нет"):(sd<0?("Ошибка"):("Сдача есть")));
        System.out.println(sd>=50?"50 - "+sd/50:"");
        sd = sd%50;
        System.out.println(sd>=25?"25 - "+sd/25:"");
        sd = sd%25;
        System.out.println( sd >=10?"10 - "+sd/10:"");
        sd = sd%10;
        System.out.println(sd>=5?"5 - "+ sd/5:"");
        sd = sd%5;
        System.out.println(sd>=1?"1 - "+ sd:"");

    }
}