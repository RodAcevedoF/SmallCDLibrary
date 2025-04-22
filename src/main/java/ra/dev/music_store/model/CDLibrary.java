package ra.dev.music_store.model;

public class CDLibrary {
    private CD[] cds;
    private int counter;

    public CDLibrary() {
        this.cds = new CD[10];
        this.counter = 0;
    }

    public CD[] getCds() {
        return cds;
    }

    public void setCds(CD[] cds) {
        this.cds = cds;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
