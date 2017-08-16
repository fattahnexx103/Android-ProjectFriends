package restapps.neehad.projectfriends.inmemory;


import com.squareup.otto.Bus;

import infrastructure.Appl;

public class BaseInMemory {

    protected  final Bus bus;
    protected  final Appl application;

    public BaseInMemory(Appl application){
        this.application = application;
        this.bus = application.getBus();
        bus.register(this);
    }
}
