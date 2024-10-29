public class ScoreTotal {
    private int winTimes;
    private int lostTimes;

    public ScoreTotal() {
        this.winTimes = 0;
        this.lostTimes = 0;
    }
    public void countWins(){
        winTimes++;
    }

    public void countLost(){
        lostTimes++;
    }

    public int getWinTimes() {
        return winTimes;
    }

    public int getLostTimes() {
        return lostTimes;
    }
}
