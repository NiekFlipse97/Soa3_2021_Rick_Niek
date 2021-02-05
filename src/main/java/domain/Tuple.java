package domain;

public class Tuple {

    private boolean isPremium;
    private int sixOrMore;

    public Tuple(boolean isPremium, int sixOrMore) {
        this.isPremium = isPremium;
        this.sixOrMore = sixOrMore;
    }

    public boolean getIsPremium() {
        return isPremium;
    }

    public boolean getSixOrMore() {
        return sixOrMore > 5;
    }

}
