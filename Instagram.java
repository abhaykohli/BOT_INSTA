
import java.io.File;
import java.io.IOException;

import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramLikeRequest;
import org.brunocvcunha.instagram4j.requests.InstagramPostCommentRequest;
import org.brunocvcunha.instagram4j.requests.InstagramRequest;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.InstagramTagFeedRequest;
import org.brunocvcunha.instagram4j.requests.InstagramUploadPhotoRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedItem;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;

public class Instagram {

	public static void main(String[] args) {
		Instagram4j instagram = Instagram4j.builder().username("").password("").build();
		instagram.setup();
		try {
			instagram.login();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	
		try {
		InstagramSearchUsernameResult userResult = instagram.sendRequest(new InstagramSearchUsernameRequest(""));
		System.out.println("ID for @ is " + userResult.getUser().getPk());
		System.out.println("Number of followers: " + userResult.getUser().getFollower_count());
		
		
		}
		catch(IOException e)
		{
			System.out.println(e);
			
		}
		try {
           
            
            InstagramFeedResult tagFeed = instagram.sendRequest(new InstagramTagFeedRequest("csgo"));
            for (InstagramFeedItem feedResult : tagFeed.getItems()) {
                System.out.println("Post ID: " + feedResult.getPk());
                instagram.sendRequest(new InstagramLikeRequest(feedResult.getPk()));
                instagram.sendRequest(new InstagramPostCommentRequest(feedResult.getPk(),  "));
                Thread.sleep(27000);
            }

        } catch (IOException|InterruptedException e) {
        	
        }  
			
			
}
	
		
		
	}



