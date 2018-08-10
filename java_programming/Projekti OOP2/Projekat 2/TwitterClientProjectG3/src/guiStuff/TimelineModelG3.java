package guiStuff;
import java.util.List;

import javax.ejb.Init;
import javax.naming.InitialContext;
import javax.swing.table.AbstractTableModel;

import bean.TweetG3Bean;
import bean.TweetG3BeanRemote;
import entity.TweetG3;
import entity.UserG3;

/**
 * Custom model objekat za rad sa JTable komponentom.
 * 
 * @author <a href="barugdzicnenad@gmail.com">Nenad Barugdzic</a>
 */
@SuppressWarnings("serial")
public class TimelineModelG3 extends AbstractTableModel {
	private List<TweetG3> timelineTweets;
	private static final String SERVER_PROJECT = "TwitterServerProjectG3";
	private static InitialContext ctx;
	private TweetG3BeanRemote tweetBean;
	private String statefulName = "ejb:/" + SERVER_PROJECT + "//" + TweetG3Bean.class.getSimpleName()
			+ "!" + TweetG3BeanRemote.class.getName() + "?stateful";
	
	@Init
	public void init(){
		getTimelineTweets();
	}
	
	public List<TweetG3> getTimelineTweets(){
		if (timelineTweets==null)
		try{
			LoginUserFrameG3 frame = new LoginUserFrameG3();
			ctx= new InitialContext();
			// Ovo za userRemote proveriti
			tweetBean = (TweetG3BeanRemote) ctx.lookup(statefulName);
			timelineTweets = tweetBean.getTimelineTweets(null);
			
		}catch(Exception e){
			System.out.println("Greska u initu TimelineModelG3");
		}
		return timelineTweets;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if (getTimelineTweets()!=null){
			return getTimelineTweets().size();
		}else {
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return timelineTweets.get(rowIndex).getTweetText();
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Tweets";
		default: // 3
			return "Tweets";
		}
	}

}
