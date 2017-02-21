package scoreboard.fiddle.com.scoreboard.scoreboard.fiddler.com;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by jojomampilly on 2/21/17.
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);


        //Purchace Code from Facebook SDK
        //logger.logPurchase(BigDecimal.valueOf(4.32), Currency.getInstance("USD"));

    }


}
