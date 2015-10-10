package riboni.com.udemyexample1;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Riboni1989 on 10/10/15.
 */
public class StartApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "yDtXoC5vV5UQ29DUXMkzb66WeI3QltDQZLMxCMUC", "oApQ0fw7aVUoMBL0I5mVZumrHBXfTfATtiDO5q63");
    }
}
