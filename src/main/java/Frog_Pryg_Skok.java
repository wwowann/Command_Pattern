public class Frog_Pryg_Skok {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;
    private int position;


    public Frog_Pryg_Skok() {
        position = 5;

    }

    public boolean jump(int steps) {
       if (position + steps >= MIN_POSITION &&
                position + steps <= MAX_POSITION) {
          position += steps;
            return true;
        } else
           System.out.println("SOS!!! Попытка покинуть дистанцию");
            return false;
    }

    public int getPosition() {
        return position;
    }
}


