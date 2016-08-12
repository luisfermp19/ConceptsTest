package freakdeveloper.lfmelonp.org.rush.application;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import co.uk.rushorm.android.AndroidInitializeConfig;
import co.uk.rushorm.core.Rush;
import co.uk.rushorm.core.RushCore;
import freakdeveloper.lfmelonp.org.rush.models.Author;
import freakdeveloper.lfmelonp.org.rush.models.Book;

/**
 * Created by a67233924 on 11/8/16.
 */
public class RushApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        // Rush is initialized asynchronously to recieve a callback after it initialized
        // set an InitializeListener on the config object
        AndroidInitializeConfig config = new AndroidInitializeConfig(getApplicationContext());
        List<Class<? extends Rush>> dbClasses = new ArrayList<Class<? extends Rush>>() ;
        dbClasses.add(Author.class);
        dbClasses.add(Book.class);
        RushCore.initialize(config);
    }
}
