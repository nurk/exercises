package be.cegeka.datingapp.core;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import be.cegeka.datingapp.core.guice.BasicModule;
import be.cegeka.datingapp.views.View;

public class ViewManager {

    private Injector injector;

    @Inject
    public ViewManager() {
        injector = Guice.createInjector(new BasicModule());
    }

    public void start(Class<? extends View> viewClass) {
        while (viewClass != null) {
            View view = injector.getInstance(viewClass);
            viewClass = view.run();
        }
    }
}
