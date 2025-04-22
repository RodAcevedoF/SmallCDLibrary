package ra.dev.music_store.model;

public class CD {

    private Song[] songs;
    private String title;
    private int counter;

    public CD(String title) {
        this.songs = new Song[10];
        this.title = title;
        this.counter = 0;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return String.format("""
                *******************
                ******CD info******
                *******************
                Title: %s
                Songs number: %d
                """, getTitle(), getCounter());
    }
}
