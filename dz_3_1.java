public class dz_3_1 {
    public static void main(String[] args) {
        int st = 100;
        int sd= 100-st;
        if (sd<0)
            System.out.println("Ошибка");
        if (sd==0)
            System.out.println("Сдачи нет");
        if(sd % 50 == 0)
        {
            System.out.println("50 - " + sd / 50);
        }
        else
        {
            if(sd > 50)
            {
                System.out.println("50 - " + sd / 50);
                sd%=50;
            }
            if(sd % 25 == 0)
            {
                System.out.println("25 - " + sd / 25);
            }
            else
            {
                if(sd > 25)
                {
                    System.out.println("25 - " + sd / 25);
                    sd%=25;
                }
                if(sd % 10 == 0)
                {
                    System.out.println("10 - " + sd / 10);
                }
                else
                {
                    if(sd > 10)
                    {
                        System.out.println("10 - " + sd / 10);
                        sd%=10;
                    }
                    if(sd % 5 == 0)
                    {
                        System.out.println("5 - " + sd / 5);
                    }
                    else
                    {
                        if(sd > 5)
                        {
                            System.out.println("5 - " + sd / 5);
                            sd%=5;
                        }
                        System.out.println("1 - " + sd);
                    }
                }
            }
        }


    }
}
