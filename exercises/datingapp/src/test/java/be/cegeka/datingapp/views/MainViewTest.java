package be.cegeka.datingapp.views;

import be.cegeka.datingapp.core.io.IOFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MainViewTest {

    @InjectMocks
    private MainView mainView;

    @Mock
    private IOFacade ioFacade;

    @Test
    void outputs_expectedText() {
        when(ioFacade.inputMenuNumber(3)).thenReturn(3);

        mainView.run();

        Mockito.verify(ioFacade).output("===== Welcome to Lovefinderrz =====\n      Choose an option below       \n===== and find your true love =====\n\n1. Match with other users\n2. Matched users\n3. Exit");
    }

    @Test
    void one_returnsMatchingView() {
        when(ioFacade.inputMenuNumber(3)).thenReturn(1);

        Class<? extends View> actual = mainView.run();

        assertThat(actual).isEqualTo(MatchingView.class);
    }

    @Test
    void two_returnsProfileView() {
        when(ioFacade.inputMenuNumber(3)).thenReturn(2);

        Class<? extends View> actual = mainView.run();

        assertThat(actual).isEqualTo(MatchedUserView.class);
    }

    @Test
    void three_returnsNull() {
        when(ioFacade.inputMenuNumber(3)).thenReturn(3);

        Class<? extends View> actual = mainView.run();

        assertThat(actual).isEqualTo(null);
    }
}
