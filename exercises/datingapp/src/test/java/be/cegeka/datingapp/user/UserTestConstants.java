package be.cegeka.datingapp.user;

import java.util.Arrays;

public class UserTestConstants {

    public static User.Builder aUserBuilder() {
        return new User.Builder()
                .withName("Jantje")
                .withSurName("Peeters")
                .withPersonalityTraits(Arrays.asList("funny", "happy", "witty"))
                .withAge(25);
    }

    private UserTestConstants() throws Exception {
        throw new Exception("Not allowed to instantiate class");
    }
}
