package be.cegeka.datingapp;

import be.cegeka.datingapp.core.ViewManager;
import be.cegeka.datingapp.core.guice.BasicModule;
import be.cegeka.datingapp.views.MainView;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BasicModule());
        ViewManager viewManager = injector.getInstance(ViewManager.class);

        viewManager.start(MainView.class);
    }

}
