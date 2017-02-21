package scoreboard.fiddle.com.scoreboard.scoreboard.fiddler.com.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import scoreboard.fiddle.com.scoreboard.R;
import scoreboard.fiddle.com.scoreboard.scoreboard.fiddler.com.SharedPreference;
import scoreboard.fiddle.com.scoreboard.scoreboard.fiddler.com.home.HomeActivity;

/**
 * Created by jojomampilly on 2/20/17.
 */

public class LoginActivity extends Activity {

    User user = null;
    CallbackManager callbackManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        user = new User();
//
//        LoginLayoutBinding binding = DataBindingUtil.setContentView(this, R.layout.login_layout);
//        binding.setUser(user);

        setContentView(R.layout.login_layout);



        initUI();

    }

    public void initUI(){


        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this,user.getUsername(),Toast.LENGTH_SHORT).show();

                loginInToHome();
            }
        });

        handleFacebookLogin();


    }

    public void handleFacebookLogin(){
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
     //   loginButton.setReadPermissions("user_friends");
        loginButton.setReadPermissions("public_profile");
     //   loginButton.setReadPermissions("email");
     //   loginButton.setReadPermissions("user_birthday");

       // loginButton.setReadPermissions("profile");

        // If using in a fragment
        //loginButton.setFragment(this);
        // Other app specific specialization

        // Callback registration
        callbackManager = CallbackManager.Factory.create();


        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Toast.makeText(LoginActivity.this,AccessToken.getCurrentAccessToken()+"",Toast.LENGTH_SHORT).show();
            //    System.out.println("Facebook Login name ::"+Profile.getCurrentProfile().getName());


            }

            @Override
            public void onCancel() {
                // App code
                Log.v("LoginActivity", "cancel");

            }

            @Override
            public void onError(FacebookException exception) {
                // App
                Log.v("LoginActivity", exception.getCause().toString());

            }
        });
    }

    public void loginInToHome(){
        Intent startHomeActivity = new Intent(this, HomeActivity.class);
        startActivity(startHomeActivity);
        this.finish();
    }

//    public void loadFacebookProfile(LoginResult loginResult){
//        GraphRequest request = GraphRequest.newMeRequest(
//                loginResult.getAccessToken(),
//                new GraphRequest.GraphJSONObjectCallback() {
//                    @Override
//                    public void onCompleted(JSONObject object, GraphResponse response) {
//                        Log.v("LoginActivity", response.toString());
//
//                        // Application code
//                        try {
//                            String email = object.getString("email");
//         //                   String birthday = object.getString("birthday"); // 01/31/1980 format
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//        Bundle parameters = new Bundle();
//        parameters.putString("fields", "id,name,email,gender,birthday");
//        request.setParameters(parameters);
//        request.executeAsync();
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
