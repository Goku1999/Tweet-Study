import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TweetManager 
{

	public static ArrayList<String> getTweets(String topic) 
	{
		try
		{
			ConfigurationBuilder conf=new ConfigurationBuilder();
			conf.setDebugEnabled(true).setOAuthConsumerKey("eXontXrTi9oJZF3c8GXDYCE8q").setOAuthConsumerSecret("dQvCWKBFXpptfzIgqA4efLpikIiZElKXuzuXbGZAvtgDRzaNW0").setOAuthAccessToken("387459869-zsX6P1jCKhZxXaZIZ2EuG2Om4EYwgPBGqJ0NKIFv").setOAuthAccessTokenSecret("A6DbNSQD5zeZJJNXOh2GuOdv9Vkx6qlpZJheTfvY3uYXb");
	        TwitterFactory tf=new TwitterFactory(conf.build());
	        twitter4j.Twitter twitter=tf.getInstance();
	        ArrayList<String> tweetList = new ArrayList<String>();
	        Query querry=new Query(topic);
	        querry.setCount(100);
	        querry.setLang("en");
	        List<Status> status=twitter.search(querry).getTweets();
	        for(Status  s:status)
	        {
	            tweetList.add(s.getUser().getName()+","+s.getText());
	        }
	        return tweetList;
		} 
		catch (TwitterException te) 
		{
			return null;
		}
	}
}