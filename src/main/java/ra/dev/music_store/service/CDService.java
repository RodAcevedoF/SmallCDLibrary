package ra.dev.music_store.service;

import ra.dev.music_store.model.CD;

/**
 * Servicio para gestionar operaciones propias de un CD,
 * delegando las acciones sobre canciones al SongService.
 */
public class CDService {
    private CD currentCd;
    private final SongService songService;

    public CDService() {
        this.songService = new SongService();
    }

    public boolean hasCd() {
        return currentCd != null;
    }

    public CD createCd(String title) {
        currentCd = new CD(title);
        songService.setCd(currentCd);
        return currentCd;
    }

    public void setCd(CD cd) {
        this.currentCd = cd;
        songService.setCd(cd);
    }

    public CD getCurrentCd() {
        return currentCd;
    }

    public String getTitle() {
        return currentCd != null ? currentCd.getTitle() : null;
    }

    public void rename(String newTitle) {
        if (currentCd != null) {
            currentCd.setTitle(newTitle);
        }
    }

    public SongService getSongService() {
        return songService;
    }
}
