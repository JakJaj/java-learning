import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList();
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            songs.add(new Song(title,duration));
            return true;
        }
        return false;
    }
    private Song findSong(String title){
        for(Song element: songs){
            if(element.getTitle().equals(title)){
                return element;
            }
        }
        return null;
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
        if(trackNumber > songs.size() || trackNumber <= 0){
            return false;
        }
        playlist.add(songs.get(trackNumber - 1));
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist){
        if(findSong(title) != null){
            playlist.add(findSong(title));
            return true;
        }
        return false;
    }
}
