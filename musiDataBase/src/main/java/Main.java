import Model.Artist;
import Model.DataModel;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataModel dataSource = new DataModel();
        if(!dataSource.open()){
            System.out.println("Couldnt open a connection");

        }
        List<Artist> artistList = dataSource.queryArtists(DataModel.ORDER_BY_NONE);
        if(artistList == null){
            System.out.println("No artists");
        }
        for (Artist artist :
                artistList) {
            System.out.println("ID: " + artist.getId() + " Name: " + artist.getName());
        }
        System.out.println("--------------");
        List<String> albums = dataSource.queryAlbumsForArtist("Iron Maiden",DataModel.ORDER_BY_ASC);
        for(String album: albums){
            System.out.println(album);
        }

        dataSource.insertSong("Touch of Gray", "Grateful Dead", "In The Dark",1);

        dataSource.close();

    }
}
