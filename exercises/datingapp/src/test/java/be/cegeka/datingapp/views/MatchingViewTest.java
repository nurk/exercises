package be.cegeka.datingapp.views;

import be.cegeka.datingapp.core.io.IOFacade;
import be.cegeka.datingapp.matching.MatchingService;
import be.cegeka.datingapp.profile.ProfileService;
import be.cegeka.datingapp.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static be.cegeka.datingapp.user.UserTestConstants.aUserBuilder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MatchingViewTest {

    @InjectMocks
    private MatchingView matchingView;

    @Mock
    private IOFacade ioFacade;

    @Mock
    private MatchingService matchingService;

    @Mock
    private ProfileService profileService;

    private User aUser;
    private User anotherUser;

    @BeforeEach
    void setUp() {
        aUser = aUserBuilder().build();
        anotherUser = aUserBuilder().withName("Miet").build();
        when(matchingService.findAUser()).thenReturn(aUser, anotherUser);
    }

    @Test
    void outputsUserInfo() {
        when(ioFacade.inputMenuNumber(3)).thenReturn(3);

        Class<? extends View> actual = matchingView.run();

        verify(ioFacade).output(aUser.getInfo());
    }

    @Test
    void outputsRightText() {
        when(ioFacade.inputMenuNumber(3)).thenReturn(3);

        Class<? extends View> actual = matchingView.run();

        verify(ioFacade).output("1. ♥ Like ♥\n2. Dislike\n3. Back");
    }

    @Test
    void pressOne_One_Three_likesTwoUsers() {
        when(ioFacade.inputMenuNumber(3)).thenReturn(1, 1, 3);

        matchingView.run();

        verify(profileService).like(aUser);
        verify(profileService).like(anotherUser);
    }

    @Test
    void pressOne_Two_Three_likesFirsUser() {
        when(ioFacade.inputMenuNumber(3)).thenReturn(1, 2, 3);

        matchingView.run();

        verify(profileService).like(aUser);
    }

    @Test
    void pressTwo_One_Three_likesSecondUser() {
        when(ioFacade.inputMenuNumber(3)).thenReturn(2, 1, 3);

        matchingView.run();

        verify(profileService).like(anotherUser);
    }

    @Test
    void pressThree_returnsMainView() {
        when(ioFacade.inputMenuNumber(3)).thenReturn(3);

        Class<? extends View> actual = matchingView.run();

        assertThat(actual).isEqualTo(MainView.class);
    }
}
