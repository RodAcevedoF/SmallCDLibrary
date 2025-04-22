package ra.dev.music_store;

import ra.dev.music_store.controller.LibraryController;

public class Main {
    public static void main(String[] args) {
        LibraryController controller = new LibraryController();
        controller.run();
    }

}