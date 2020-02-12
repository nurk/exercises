package be.cegeka.datingapp.views;

import be.cegeka.datingapp.core.io.IOFacade;
import be.cegeka.datingapp.matching.MatchingService;
import be.cegeka.datingapp.profile.ProfileService;
import be.cegeka.datingapp.user.User;
import com.google.inject.Inject;

public class MatchingView implements View {

    private final IOFacade ioFacade;
    private final MatchingService matchingService;
    private final ProfileService profileService;

    @Inject
    public MatchingView(IOFacade ioFacade, MatchingService matchingService, ProfileService profileService) {
        this.ioFacade = ioFacade;
        this.matchingService = matchingService;
        this.profileService = profileService;
    }

    @Override
    public Class<? extends View> run() {
        int choice;
        do {
            User user = matchingService.findAUser();

            ioFacade.output(user.getInfo());
            ioFacade.output("1. ♥ Like ♥\n2. Dislike\n3. Back");

            choice = ioFacade.inputMenuNumber(3);
            if (choice == 1) {
                profileService.like(user);
            }
        } while (choice < 3);

        return MainView.class;
    }
}
