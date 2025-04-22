package ra.dev.music_store.controller;

import ra.dev.music_store.model.CD;
import ra.dev.music_store.model.CDLibrary;
import ra.dev.music_store.model.Song;
import ra.dev.music_store.service.CDLibraryService;
import ra.dev.music_store.service.CDService;
import ra.dev.music_store.service.SongService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryController {
    private final Scanner sc = new Scanner(System.in);
    private final CDLibraryService libraryService = new CDLibraryService();
    private final CDService cdService = new CDService();
    private final SongService songService = cdService.getSongService();

    public static void main(String[] args) {
        new LibraryController().run();
    }

    public void run() {
        int choice;
        do {
            showMenu();
            choice = readInt(1, 11);
            switch (choice) {
                case 1 -> createLibraryFlow();
                case 2 -> addCdToLibraryFlow();
                case 3 -> listAllCdsFlow();
                case 4 -> selectCdFlow();
                case 5 -> renameCdFlow();
                case 6 -> addSongFlow();
                case 7 -> overwriteSongFlow();
                case 8 -> deleteSongFlow();
                case 9 -> showAllSongsFlow();
                case 10 -> getSongByIndexFlow();
                case 11 -> System.out.println("Exiting...");
            }
        } while (choice != 11);
    }

    private void showMenu() {
        System.out.println("""
                -------------------------------
                -----Welcome to CD Library-----
                -------------------------------
                Choose an option:
                1. Create new Library
                2. Add CD to Library
                3. List all CDs
                4. Select CD
                5. Rename current CD
                6. Add song to current CD
                7. Overwrite song in current CD
                8. Delete song from current CD
                9. Show all songs in current CD
                10. Get song by index in current CD
                11. Exit
                """);
    }

    private int readInt(int lower, int upper) {
        while (true) {
            try {
                System.out.printf("Enter a number (%d-%d): ", lower, upper);
                int res = sc.nextInt();
                sc.nextLine();
                if (res >= lower && res <= upper) return res;
                System.out.printf("Please enter a number between %d and %d\n", lower, upper);
            } catch (InputMismatchException e) {
                System.out.println("Input must be a valid number.");
                sc.next();
            }
        }
    }

    private String readString() {
        while (true) {
            try {
                String res = sc.nextLine().trim();
                if (res.isEmpty()) throw new IllegalArgumentException("Input cannot be empty. Please enter again:");
                return res.substring(0,1).toUpperCase() + res.substring(1).toLowerCase();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void createLibraryFlow() {
        libraryService.setLibrary(new CDLibrary());
        System.out.println("New CD library created.");
    }

    private void addCdToLibraryFlow() {
        if (!libraryService.hasLibrary()) {
            System.out.println("Please create the library first.");
            return;
        }
        System.out.println("Enter CD title to add:");
        CD cd = new CD(readString());
        boolean added = libraryService.addCd(cd);
        System.out.println(added ? "✅ CD added to library." : "❌ Library is full.");
    }

    private void listAllCdsFlow() {
        if (!libraryService.hasLibrary() || libraryService.cdsCount() == 0) {
            System.out.println("No CDs in library.");
            return;
        }
        CD[] cds = libraryService.listAllCds();
        for (int i = 0; i < cds.length; i++) {
            System.out.printf("%d. %s (Songs: %d)\n", i+1, cds[i].getTitle(), cds[i].getCounter());
        }
    }

    private void selectCdFlow() {
        if (!libraryService.hasLibrary() || libraryService.cdsCount() == 0) {
            System.out.println("No CDs to select.");
            return;
        }
        System.out.printf("Enter CD index to select (1 to %d):\n", libraryService.cdsCount());
        int idx = readInt(1, libraryService.cdsCount()) - 1;
        CD cd = libraryService.getCdByIndex(idx);
        if (cd != null) {
            cdService.setCd(cd);
            System.out.println("Selected CD: " + cd.getTitle());
        } else {
            System.out.println("Invalid CD index.");
        }
    }

    private void renameCdFlow() {
        if (!cdService.hasCd()) {
            System.out.println("No CD selected.");
            return;
        }
        System.out.println("Enter new title for current CD:");
        String newTitle = readString();
        cdService.rename(newTitle);
        System.out.println("CD renamed to: " + cdService.getTitle());
    }

    // Song flows use songService internally
    private void addSongFlow() {
        if (!cdService.hasCd()) {
            System.out.println("You must select a CD first.");
            return;
        }
        System.out.println("Enter song title:");
        String title = readString();
        System.out.println("Enter artist:");
        String artist = readString();
        Song song = new Song(title, artist);
        boolean added = songService.addSong(song);
        System.out.println(added ? "✅ Song added!" : "❌ No more space in the CD");
    }

    private void overwriteSongFlow() {
        if (!cdService.hasCd() || songService.songsCount() == 0) {
            System.out.println("No songs to overwrite.");
            return;
        }
        System.out.printf("Enter position to overwrite (1 to %d): ", songService.songsCount());
        int pos = readInt(1, songService.songsCount());
        System.out.println("Enter new song title:");
        String title = readString();
        System.out.println("Enter artist:");
        String artist = readString();
        Song song = new Song(title, artist);
        boolean overwritten = songService.overwriteSong(pos, song);
        System.out.println(overwritten ? "✅ Song overwritten!" : "❌ Invalid position");
    }

    private void deleteSongFlow() {
        if (!cdService.hasCd() || songService.songsCount() == 0) {
            System.out.println("No songs to delete.");
            return;
        }
        System.out.printf("Enter position to delete (1 to %d): ", songService.songsCount());
        int pos = readInt(1, songService.songsCount());
        boolean deleted = songService.deleteSong(pos);
        System.out.println(deleted ? "✅ Song deleted." : "❌ Invalid position");
    }

    private void showAllSongsFlow() {
        if (!cdService.hasCd() || songService.songsCount() == 0) {
            System.out.println("No songs to show.");
            return;
        }
        Song[] songs = songService.getAllSongs();
        for (int i = 0; i < songService.songsCount(); i++) {
            System.out.printf("%d. %s\n", i+1, songs[i]);
        }
    }

    private void getSongByIndexFlow() {
        if (!cdService.hasCd() || songService.songsCount() == 0) {
            System.out.println("No songs in the CD.");
            return;
        }
        System.out.printf("Enter song index (1 to %d): ", songService.songsCount());
        int index = readInt(1, songService.songsCount()) - 1;
        Song song = songService.getSongByIndex(index);
        System.out.println(song != null ? song : "Invalid index or no song found.");
    }

    private void getSongsCountFlow() {
        System.out.println("Total songs: " + songService.songsCount());
    }
}
