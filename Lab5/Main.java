public class Main {
public static void main(String[] args){
    ListString lst = new ListString("1");
    ListString lst3 = new ListString("1111aijncxjancckjdnckjnckjnfvo111pvklkvmvnkcjncjknckv111dfvnj111d");
    ListString lst4 = new ListString("000");
    ListString lst5 = new ListString("%%%");
    ListString lst6 = new ListString("111");

    System.out.println(lst3.substring(5,10));
    lst4.append('2');
    lst4.append("qwerty");
    lst4.append(lst);
    lst4.insert(2,lst5);
    lst4.insert(3,"");
//    lst4.insert(4," ");
    System.out.println(lst4);
    lst3.replace(lst6,"999999999999999999");

    lst3.replace(lst6,"999999999999999999");

    System.out.println(lst3);


}
}
