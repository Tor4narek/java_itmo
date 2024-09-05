public class Position {
    int position;
    public Position(int i){
        position = i;
    }
    public boolean equal (Position p) {
        // если содержимое равно, то возвращает true;
        return p.position == this.position;
    }

}
