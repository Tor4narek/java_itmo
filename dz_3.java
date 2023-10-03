public class dz_3 {
    public static void main(String[] args) {
        int st = 27;
        int sd;
        sd = 100-st;
        if (sd > 0)
        {
            if(sd >= 50) {
                System.out.print("\n50 - " + sd / 50);
                sd %= 50;
            }
            if (sd > 0) {
                if (sd >= 25) {
                    System.out.print("\n25 - " + sd / 25);
                    sd %= 25;
                }
                if (sd > 0) {
                    if (sd >= 10) {
                        System.out.print("\n10 - " + sd / 10);
                        sd %= 10;
                    }
                    if (sd > 0) {
                        if (sd > 5) {
                            System.out.print("\n5 - " + sd / 5);
                            sd %= 5;
                        }
                        System.out.print("\n1 - " + sd);
                    }
                }
            }
        }
        else
        if (sd == 0)
            System.out.print("Сдачи нет");
        else
            System.out.print("Ошибка");

    }
}
