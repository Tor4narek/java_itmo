import javax.sound.midi.Track;

//Шахматная доска. 3л 1к, Положение фигуры - пара целых числел, не надо проверять, что все фигуры в пределах доски и не стрят друг на друге на голове,
// вывести какая из лодей атакакует короля, с помощью условного оператора и условных вырадений решить задачу,
//функция Math.abs - возращает число если оно неотрицательное,противополодное по знаку если оно отрицательно
public class dz_4 {
    public static void main(String[] args) {
        int l1 = 28, l2 = 84, l3 = 46, k = 11;
        if (((l1 / 10) == (k / 10))) {
                    if(((l1/10)==(l2/10)) & ((l2/10)!=(l3/10))){
                        if(Math.abs((l1%10)-(k%10)) < Math.abs((l2%10)-(k%10))){
                            System.out.println("Ладья 1 атакует короля");
                        }
                    }
                    if(((l1/10)==(l3/10)) & ((l3/10)!=(l2/10))){
                        if(Math.abs((l1%10)-(k%10)) < Math.abs((l3%10)-(k%10))){
                            System.out.println("Ладья 1 атакует короля");
                        }
                    }
                    if(((l1/10)==(l2/10)) & ((l2/10)==(l3/10))){
                        if((Math.abs((l1%10)-(k%10)) < Math.abs((l2%10)-(k%10))) & (Math.abs((l1%10)-(k%10)) < Math.abs((l3%10)-(k%10))))
                            System.out.println("Ладья 1 атакует короля");
                    }
                    else if(((l1/10)!=(l3/10)) & ((l1/10)!=(l2/10))){
                        System.out.println("Ладья 1 атакует короля");
                    }
        }
        if (((l1 % 10) == (k % 10))) {
            if(((l1%10)==(l2%10)) & ((l2%10)!=(l3%10))){
                if(Math.abs((l1/10)-(k/10)) < Math.abs((l2/10)-(k/10))){
                    System.out.println("Ладья 1 атакует короля");
                }
            }
            if(((l1%10)==(l3%10)) & ((l3%10)!=(l2%10))){
                if(Math.abs((l1/10)-(k/10)) < Math.abs((l3/10)-(k/10))){
                    System.out.println("Ладья 1 атакует короля");
                }
            }
            if(((l1%10)==(l2%10)) & ((l2%10)==(l3%10))){
                if((Math.abs((l1/10)-(k/10)) < Math.abs((l2/10)-(k/10))) & (Math.abs((l1/10)-(k/10)) < Math.abs((l3/10)-(k/10))))
                    System.out.println("Ладья 1 атакует короля");
            }
            else if(((l1%10)!=(l3%10)) & ((l1%10)!=(l2%10))){
                System.out.println("Ладья 1 атакует короля");
            }
        }
        if (((l2 / 10) == (k / 10))) {
            if(((l2/10)==(l1/10)) & ((l2/10)!=(l3/10))){
                if(Math.abs((l2%10)-(k%10)) < Math.abs((l1%10)-(k%10))){
                    System.out.println("Ладья 2 атакует короля");
                }
            }
            if(((l2/10)==(l3/10)) & ((l2/10)!=(l1/10))){
                if(Math.abs((l2%10)-(k%10)) < Math.abs((l3%10)-(k%10))){
                    System.out.println("Ладья 2 атакует короля");
                }

            }
            if(((l1/10)==(l2/10)) & ((l2/10)==(l3/10))){
                if((Math.abs((l2%10)-(k%10)) < Math.abs((l1%10)-(k%10))) & (Math.abs((l2%10)-(k%10)) < Math.abs((l3%10)-(k%10))))
                    System.out.println("Ладья 2 атакует короля");
            }
            else if(((l2/10)!=(l3/10)) & ((l2/10)!=(l1/10))){
                System.out.println("Ладья 2 атакует короля");
            }
        }
        if (((l2 % 10) == (k % 10))) {
            if(((l2%10)==(l1%10)) & ((l2%10)!=(l3%10))){
                if(Math.abs((l2/10)-(k/10)) < Math.abs((l1/10)-(k/10))){
                    System.out.println("Ладья 2 атакует короля");
                }
            }
            if(((l2%10)==(l3%10)) & ((l2%10)!=(l1%10))){
                if(Math.abs((l2/10)-(k/10)) < Math.abs((l3/10)-(k/10))){
                    System.out.println("Ладья 2 атакует короля");
                }

            }
            if(((l1%10)==(l2%10)) & ((l2%10)==(l3%10))){
                if((Math.abs((l2/10)-(k/10)) < Math.abs((l1/10)-(k/10))) & (Math.abs((l2/10)-(k/10)) < Math.abs((l3/10)-(k/10))))
                    System.out.println("Ладья 2 атакует короля");
            }
            else if(((l2%10)!=(l3%10)) & ((l2%10)!=(l1%10))){
                System.out.println("Ладья 2 атакует короля");
            }
        }
        if (((l3 / 10) == (k / 10))) {
            if(((l3/10)==(l2/10)) & ((l3/10)!=(l1/10))){
                if(Math.abs((l3%10)-(k%10)) < Math.abs((l2%10)-(k%10))){
                    System.out.println("Ладья 3 атакует короля");
                }
            }
            if(((l3/10)==(l1/10)) & ((l3/10)!=(l2/10))){
                if(Math.abs((l3%10)-(k%10)) < Math.abs((l1%10)-(k%10))){
                    System.out.println("Ладья 3 атакует короля");
                }
            }
            if(((l3/10)==(l2/10)) & ((l2/10)==(l1/10))){
                if((Math.abs((l3%10)-(k%10)) < Math.abs((l1%10)-(k%10))) & (Math.abs((l3%10)-(k%10)) < Math.abs((l2%10)-(k%10))))
                    System.out.println("Ладья 3 атакует короля");
            }
            else if(((l3/10)!=(l1/10)) & ((l3/10)!=(l2/10))){
                System.out.println("Ладья 3 атакует короля");
            }
        }
        if (((l3 % 10) == (k % 10))) {
            if(((l3%10)==(l2%10)) & ((l3%10)!=(l1%10))){
                if(Math.abs((l3/10)-(k/10)) < Math.abs((l2/10)-(k/10))){
                    System.out.println("Ладья 3 атакует короля");
                }
            }
            if(((l3%10)==(l1%10)) & ((l3%10)!=(l2%10))){
                if(Math.abs((l3/10)-(k/10)) < Math.abs((l1/10)-(k/10))){
                    System.out.println("Ладья 3 атакует короля");
                }
            }
            if(((l3%10)==(l2%10)) & ((l2%10)==(l1%10))){
                if((Math.abs((l3/10)-(k/10)) < Math.abs((l1/10)-(k/10))) & (Math.abs((l3/10)-(k/10)) < Math.abs((l2/10)-(k/10))))
                    System.out.println("Ладья 3 атакует короля");
            }
            else if(((l3%10)!=(l1%10)) & ((l3%10)!=(l2%10))){
                System.out.println("Ладья 3 атакует короля");
            }
        }
        else{
            System.out.println("Никто не атакует короля");
        }


}
}
