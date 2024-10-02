package homeWork;

public class Fork {
    private Integer number;

    public Fork(Integer number){
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(number+1);
    }
}
