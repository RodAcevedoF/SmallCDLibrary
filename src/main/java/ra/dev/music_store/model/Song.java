package ra.dev.music_store.model;

public class Song {

    private String title;
    private String artist;

    public Song (String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return String.format("""
                *******************
                *****Song info*****
                *******************
                Title: %s
                Artist: %s
                """, getTitle(), getArtist());
    }
}
