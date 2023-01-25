import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs; // created reference of Songs arraylist
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>(); // creating reference
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    public boolean findSong(String title)
    {
        for(Song s:songs)
        {
            if(s.getTitle().equals(title))
                return true;
        }
        return false;
    }

    public void addSongtoAlbum(String title,double duration){
        Song s = new Song(title,duration);
        if(findSong(s.getTitle())==true)
        {
            System.out.println("Songs already present in album");
        }
        else
        {
            songs.add(s);
            System.out.println("New Song has been added");
        }
       return;
    }

    public void addToPlayListFromAlbum(String title,LinkedList<Song> playList)
    {
        if(findSong(title) == true) {
            for(Song song: songs)
            {
                if(song.getTitle().equals(title)){
                    playList.add(song);
                    System.out.println("Song has been added to your playlist");
                    break;
                }
            }
        }
        else
        {
            System.out.println("Song is not present in the Albumb");
        }

    }

    public void addToPlayListFromAlbum(int trackNo,LinkedList<Song> playList)
    {
        int index = trackNo -1;
        if(index>=0 && index<songs.size()){
            playList.add(songs.get(index));
            System.out.println("Song has been added to your playlist");

        }
        else{
            System.out.println("Invalid track number");
        }
        return;
    }

    public void removeFromplayList(String title,LinkedList<Song> playList)
    {
        if(findSong(title) == true) {
            for(Song song: songs)
            {
                if(song.getTitle().equals(title)){
                    playList.remove(song);
                    System.out.println("Song has been removed from your playlist");
                    break;
                }
            }
        }
        else
        {
            System.out.println("Song is not present in the Albumb");
        }
    }

}
