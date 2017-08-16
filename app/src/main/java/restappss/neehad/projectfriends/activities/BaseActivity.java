package restappss.neehad.projectfriends.activities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.squareup.otto.Bus;

import infrastructure.Appl;

public class BaseActivity extends AppCompatActivity {

    protected Appl application;
    protected Bus bus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (Appl) getApplication();
        bus = application.getBus();
        bus.register(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}
