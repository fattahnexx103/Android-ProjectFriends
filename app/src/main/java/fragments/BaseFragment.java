package fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.squareup.otto.Bus;

import infrastructure.Appl;

public class BaseFragment extends Fragment {

    protected Bus bus;
    protected Appl application;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (Appl) getActivity().getApplication();
        bus = application.getBus();
        bus.register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}
