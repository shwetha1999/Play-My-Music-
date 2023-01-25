import java.util.*;

public class Main {
    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album album1 = new Album("VijayPrakash's Songs","Vijay Prakash");
        album1.addSongtoAlbum("JayHo",5);
        album1.addSongtoAlbum("open hair",4.6);
        album1.addSongtoAlbum("Singara Siriye",4.5);

        Album album2 = new Album("Arijit's Songs","Arijit Singh");
        album2.addSongtoAlbum("Kesariya",5);
        album2.addSongtoAlbum("Jeena Jeena",4.6);
        album2.addSongtoAlbum("Gerua",4.5);4


        albums.add(album1);
        albums.add(album2);

        System.out.println(album1.findSong("JayHo"));

        LinkedList<Song> myPlayList = new LinkedList<>();

        album1.addToPlayListFromAlbum("JayHo", myPlayList);
        album1.addToPlayListFromAlbum("open hair", myPlayList);
        album2.addToPlayListFromAlbum("Jeena Jeena", myPlayList);
        album1.addToPlayListFromAlbum("Kesariya", myPlayList);
        album1.removeFromplayList("Jeena Jeena", myPlayList);
        album1.addToPlayListFromAlbum("Singara Siriye",myPlayList);

        play(myPlayList);
    }

    public static void printMenu() {

        System.out.println("1 - Play next song");
        System.out.println("2 - Play previous song");
        System.out.println("3 - Repeat the current song");
        System.out.println("4 - Show menu again");
        System.out.println("5 - Delete the current song");
        System.out.println("6 - Print all the songs in the playList");
        System.out.println("7 - Exit");

    }
    public static void printsongs(LinkedList<Song> playList){
        for(Song song: playList)
        {
            System.out.println(song);
        }
        return;
    }

    //List Itterator - itr points between the node
    public static void play(LinkedList<Song> playList)
    {
         ListIterator<Song> itr = playList.listIterator();
         Scanner sc = new Scanner(System.in);
         boolean isForward = false;
         if(playList.size()>0)
         {
             System.out.print("Currently playing: ");
             System.out.println(itr.next());
             isForward  = true;
         }
         else {
             System.out.println("PlayList is Empty");
             return ;
         }
        System.out.println("Enter yout choice");
         printMenu();

         boolean quit = false;
         while(!quit){
            int choice = sc.nextInt();
            switch(choice)
             {
                 case 1:
                     if(isForward == false)
                     {// if itr has moved to previous node previously, if we moved to next also same node will be preinted
                         // to avoid this we have to perform this step
                         itr.next();
                         isForward =true;
                     }

                     if(itr.hasNext())
                     {
                         System.out.println(itr.next());
                     }
                     else
                     {
                         System.out.println("you have reached the end of the playList");
                     }
                     break;
                 case 2:
                     if(isForward == true)
                     {
                         itr.previous();
                         isForward = false;
                     }
                     if(itr.hasPrevious())
                     {
                         System.out.println(itr.previous());
                     }
                     else
                     {
                         System.out.println("you have reached the starting of the playList");
                     }
                     break;
                 case 3:
                     if(isForward == true){
                         if(itr.hasPrevious()){
                             System.out.println(itr.previous());
                             isForward = true;
                         }
                     }
                     else if(isForward == false){
                         if (itr.hasNext()) {
                             System.out.println(itr.next());
                             isForward = false;
                         }
                     }
                     else {
                             System.out.println("No song present ");
                         }
                     break;
                 case 4:
                     printMenu();
                     break;
                 case 5:
                     break;
                 case 6:
                     printsongs(playList);
                     break;
                 case 7:
                     quit = true;
                     break;
             }
         }

    }

    }



