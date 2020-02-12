package be.cegeka.datingapp.matching;

import be.cegeka.datingapp.core.RandomFacade;
import be.cegeka.datingapp.user.User;
import be.cegeka.datingapp.user.UserInfoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MatchingServiceTest {

    @InjectMocks
    private MatchingService matchingService;

    @Mock
    private RandomFacade randomFacade;

    @Mock
    private UserInfoRepository userInfoRepository;

    @BeforeEach
    void setUp() {
        when(userInfoRepository.getMaleNames()).thenReturn(singletonList("Jantje"));
        when(userInfoRepository.getFemaleNames()).thenReturn(singletonList("Miet"));
        when(userInfoRepository.getSurnames()).thenReturn(singletonList("Peeters"));
        when(userInfoRepository.getPersonalityTraits()).thenReturn(asList("mooi", "lief", "leuk"));

        when(randomFacade.getNonRepetitiveRandomNumbers(3, 0, 3)).thenReturn(asList(0, 1, 2));
        doReturn(20).when(randomFacade).getRandomNumber(18, 100);
        doReturn(0).when(randomFacade).getRandomNumber(0, 1);
        doReturn(0).when(randomFacade).getRandomNumber(0, 2);
    }

    @Test
    void findAUser_returnsExpectedUser() {
        User actual = matchingService.findAUser();

        assertThat(actual).isEqualTo(new User.Builder()
                .withName("Miet")
                .withSurName("Peeters")
                .withPersonalityTraits(asList("mooi", "lief", "leuk"))
                .withAge(20)
                .build());
    }
}
