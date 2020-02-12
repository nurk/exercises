package be.cegeka.datingapp.user;

import be.cegeka.datingapp.core.io.IOFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserInfoRepositoryTest {

    @InjectMocks
    private UserInfoRepository userInfoRepository;

    @Mock
    private IOFacade ioFacade;

    private List<String> aList = asList("something", "something else");

    @Test
    void getPersonalityTraits() {
        when(ioFacade.readFile("adjectives.txt")).thenReturn(aList);

        List<String> actual = userInfoRepository.getPersonalityTraits();

        assertThat(actual).isEqualTo(aList);
        verify(ioFacade, times(1)).readFile("adjectives.txt");

        userInfoRepository.getPersonalityTraits();
        verify(ioFacade, times(1)).readFile("adjectives.txt");
    }

    @Test
    void getFemaleNames() {
        when(ioFacade.readFile("femalenames.txt")).thenReturn(aList);

        List<String> actual = userInfoRepository.getFemaleNames();

        assertThat(actual).isEqualTo(aList);
        verify(ioFacade, times(1)).readFile("femalenames.txt");

        userInfoRepository.getFemaleNames();
        verify(ioFacade, times(1)).readFile("femalenames.txt");
    }

    @Test
    void getMaleNames() {
        when(ioFacade.readFile("malenames.txt")).thenReturn(aList);

        List<String> actual = userInfoRepository.getMaleNames();

        assertThat(actual).isEqualTo(aList);
        verify(ioFacade, times(1)).readFile("malenames.txt");

        userInfoRepository.getMaleNames();
        verify(ioFacade, times(1)).readFile("malenames.txt");
    }

    @Test
    void getSurnames() {
        when(ioFacade.readFile("surnames.txt")).thenReturn(aList);

        List<String> actual = userInfoRepository.getSurnames();

        assertThat(actual).isEqualTo(aList);
        verify(ioFacade, times(1)).readFile("surnames.txt");

        userInfoRepository.getSurnames();
        verify(ioFacade, times(1)).readFile("surnames.txt");
    }
}
