package infrastructure;


import android.app.Application;

import com.squareup.otto.Bus;

import restapps.neehad.projectfriends.inmemory.Module;

public class Appl extends Application {

    private Bus bus;

    public Appl() {
        bus = new Bus();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Module.Register(this);
    }

    public Bus getBus() {
        return bus;
    }
}
