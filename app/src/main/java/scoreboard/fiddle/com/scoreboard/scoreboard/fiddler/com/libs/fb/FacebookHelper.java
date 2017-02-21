package scoreboard.fiddle.com.scoreboard.scoreboard.fiddler.com.libs.fb;

import android.content.Context;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.internal.ImageRequest;

import org.json.JSONObject;

/**
 * Created by jojomampilly on 2/21/17.
 */

public class FacebookHelper {


    public void loadFacebookProfile(){

        if (AccessToken.getCurrentAccessToken() != null) {

            GraphRequest request = GraphRequest.newMeRequest(
                    AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(JSONObject me, GraphResponse response) {

                            if (AccessToken.getCurrentAccessToken() != null) {

                                if (me != null) {

                                    String profileImageUrl = ImageRequest.getProfilePictureUri(me.optString("id"), 500, 500).toString();



                                }
                            }
                        }
                    });
            GraphRequest.executeBatchAsync(request);
        }
    }

    public void getFacebookProfile(Context context){


        FacebookSdk.sdkInitialize(context);
        CallbackManager callbackManager = CallbackManager.Factory.create();
        ProfileTracker profileTracker;

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(
                    Profile oldProfile,
                    Profile currentProfile) {

                System.out.println(currentProfile.getName());
                // App code
            }
        };
    }
}
