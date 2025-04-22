package ra.dev.music_store.service;

import ra.dev.music_store.model.CD;
import ra.dev.music_store.model.CDLibrary;

/**
 * Servicio para gestionar la colección de CDs (CDLibrary).
 */
public class CDLibraryService {
    private CDLibrary library;

    public void setLibrary(CDLibrary library) {
        this.library = library;
    }

    public boolean hasLibrary() {
        return library != null;
    }

    public boolean addCd(CD cd) {
        if (!hasLibrary() || library.getCounter() >= library.getCds().length) {
            return false;
        }
        library.getCds()[library.getCounter()] = cd;
        library.setCounter(library.getCounter() + 1);
        return true;
    }

    public CD getCdByIndex(int index) {
        if (!hasLibrary() || index < 0 || index >= library.getCounter()) {
            return null;
        }
        return library.getCds()[index];
    }

    public boolean deleteCd(int index) {
        if (!hasLibrary() || index < 0 || index >= library.getCounter()) {
            return false;
        }
        for (int i = index; i < library.getCounter() - 1; i++) {
            library.getCds()[i] = library.getCds()[i + 1];
        }
        library.getCds()[library.getCounter() - 1] = null;
        library.setCounter(library.getCounter() - 1);
        return true;
    }

    public CD[] listAllCds() {
        if (!hasLibrary()) return new CD[0];
        CD[] cds = new CD[library.getCounter()];
        System.arraycopy(library.getCds(), 0, cds, 0, library.getCounter());
        return cds;
    }

    public int cdsCount() {
        return hasLibrary() ? library.getCounter() : 0;
    }
}
