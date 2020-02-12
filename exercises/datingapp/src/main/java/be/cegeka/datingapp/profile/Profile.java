package be.cegeka.datingapp.profile;

import be.cegeka.datingapp.user.User;

import java.util.ArrayList;
import java.util.List;

public class Profile {

    private List<User> likedUsers = new ArrayList<>();

    public void addLikedUser(User user) {
        this.likedUsers.add(user);
    }

    public List<User> getLikedUsers() {
        return new ArrayList<>(likedUsers);
    }
}
