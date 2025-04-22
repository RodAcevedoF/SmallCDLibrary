package ra.dev.music_store.service;

import ra.dev.music_store.model.CD;
import ra.dev.music_store.model.Song;

/**
 * Servicio dedicado exclusivamente a la gestión de canciones
 * en el CD activo.
 */
public class SongService {
    private CD cd;

    public void setCd(CD cd) {
        this.cd = cd;
    }

    public boolean hasCd() {
        return cd != null;
    }

    public int songsCount() {
        return cd != null ? cd.getCounter() : 0;
    }

    public Song[] getAllSongs() {
        return cd != null ? cd.getSongs() : new Song[0];
    }

    public Song getSongByIndex(int index) {
        if (cd == null || index < 0 || index >= cd.getCounter()) {
            return null;
        }
        return cd.getSongs()[index];
    }

    public boolean addSong(Song song) {
        if (!hasCd()) return false;
        if (cd.getCounter() < cd.getSongs().length) {
            cd.getSongs()[cd.getCounter()] = song;
            cd.setCounter(cd.getCounter() + 1);
            return true;
        }
        return false;
    }

    public boolean overwriteSong(int pos, Song song) {
        if (!hasCd() || pos < 1 || pos > cd.getCounter()) {
            return false;
        }
        cd.getSongs()[pos - 1] = song;
        return true;
    }

    public boolean deleteSong(int pos) {
        if (!hasCd() || pos < 1 || pos > cd.getCounter()) {
            return false;
        }
        for (int i = pos - 1; i < cd.getCounter() - 1; i++) {
            cd.getSongs()[i] = cd.getSongs()[i + 1];
        }
        cd.getSongs()[cd.getCounter() - 1] = null;
        cd.setCounter(cd.getCounter() - 1);
        return true;
    }
}
