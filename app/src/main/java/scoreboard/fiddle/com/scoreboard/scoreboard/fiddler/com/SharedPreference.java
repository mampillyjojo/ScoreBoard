package scoreboard.fiddle.com.scoreboard.scoreboard.fiddler.com;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import scoreboard.fiddle.com.scoreboard.R;

/**
 * Created by jojomampilly on 2/21/17.
 */

public class SharedPreference {

    private final String DEFAULT_SHARED_PREFERENCE_KEY = "key1";
    private static final String FB_TOKEN = "fbToken";

    public static void  setFacebookToken(Activity actvity, String fbToken){

        SharedPreferences sharedPref = actvity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(FB_TOKEN, fbToken);
        editor.commit();

    }
}
