package be.cegeka.datingapp.profile;

import be.cegeka.datingapp.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static be.cegeka.datingapp.user.UserTestConstants.aUserBuilder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProfileServiceTest {

    @InjectMocks
    private ProfileService profileService;

    @Mock
    private Profile profile;

    private User aUser = aUserBuilder().build();

    @Test
    void like() {
        profileService.like(aUser);

        verify(profile).addLikedUser(aUser);
    }

    @Test
    void getLikedUsers() {
        when(profile.getLikedUsers()).thenReturn(singletonList(aUser));

        List<User> actual = profileService.getLikedUsers();

        assertThat(actual).containsExactly(aUser);
    }
}