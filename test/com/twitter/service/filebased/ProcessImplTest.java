package twitter.service.filebased;

import com.twitter.domain.user.User;
import com.twitter.service.filebased.ProcessImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class ProcessImplTest {

    private ProcessImpl process = new ProcessImpl();
    private HashMap<String, User> users = new HashMap<>();

    @Before
    public void setUp() throws Exception {
        users = process.loadUsers();
    }

    @Test
    public void testUserLoaded(){
        Assert.assertEquals(users.size(),3);
    }


    @Test
    public void testTweetsLoaded(){
        Assert.assertEquals(users.get("Alan").getTweets().size(),2);
        Assert.assertEquals(users.get("Ward").getTweets().size(),1);
        Assert.assertEquals(users.get("Martin").getTweets().size(),0);
    }
}
