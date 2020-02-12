package be.cegeka.datingapp.user;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static be.cegeka.datingapp.user.UserTestConstants.aUserBuilder;

class UserTest {
    @Test
    void getInfo() {
        User user = aUserBuilder().build();

        String actual = user.getInfo();

        assertThat(actual).isEqualTo("Hello, my name is Jantje Peeters. I am 25 years old and I am funny, happy and witty.");
    }

    @Test
    void getInfo_onePersonalityTrait() {
        User user = aUserBuilder().withPersonalityTraits(Collections.singletonList("witty")).build();

        String actual = user.getInfo();

        assertThat(actual).isEqualTo("Hello, my name is Jantje Peeters. I am 25 years old and I am witty.");
    }

    @Test
    void changingPersonalityList_doesNotChangeUserList() {
        User user = aUserBuilder().build();

        user.getPersonalityTraits().set(0, "stinky");

        assertThat(user.getPersonalityTraits()).doesNotContain("stinky");
    }
}