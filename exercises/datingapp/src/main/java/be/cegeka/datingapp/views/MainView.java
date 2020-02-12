package be.cegeka.datingapp.views;

import com.google.inject.Inject;
import be.cegeka.datingapp.core.io.IOFacade;

public class MainView implements View{

    private final IOFacade ioFacade;

    @Inject
    public MainView(IOFacade ioFacade) {
        this.ioFacade = ioFacade;
    }

    @Override
    public Class<? extends View> run() {
        ioFacade.output("===== Welcome to Lovefinderrz =====\n      Choose an option below       \n===== and find your true love =====\n\n1. Match with other users\n2. Matched users\n3. Exit");

        int choice = ioFacade.inputMenuNumber(3);
        switch (choice) {
            case 1:
                return MatchingView.class;
            case 2:
                return MatchedUserView.class;
            default:
                return null;
        }
    }
}
