public class Pile {

    private int sticks;

    public Pile(int numOfSticks) {
        this.sticks = numOfSticks;
    }

    public int getSticks() {
        return this.sticks;
    }

    public void removeSticks(int num) {
        this.sticks -= num;
    }
    
}
