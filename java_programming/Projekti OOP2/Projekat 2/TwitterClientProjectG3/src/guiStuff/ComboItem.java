package guiStuff;
/*
* @author <a href="barugdzicnenad@gmail.com">Nenad Barugdzic</a>
* */
public class ComboItem {

    private int id;
    private String tweetname;

    public ComboItem(int id, String tweetname) {
        this.id = id;
        this.tweetname = tweetname;
    }

    public int getId() {
        return this.id;
    }

    public void setTweetname(String tweetname) {
        this.tweetname = tweetname;
    }
    
    public String getTweetname(){
    	return tweetname;
    }

    @Override
    public String toString() {
        return id + ", " + tweetname;
    }
}
