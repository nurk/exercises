package be.cegeka.datingapp.user;

import be.cegeka.datingapp.core.io.IOFacade;
import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

public class UserInfoRepository {
    private List<String> personalityTraits;
    private List<String> femaleNames;
    private List<String> maleNames;
    private List<String> surnames;

    private final IOFacade ioFacade;

    @Inject
    public UserInfoRepository(IOFacade ioFacade) {
        this.ioFacade = ioFacade;
    }

    public List<String> getPersonalityTraits() {
        if (personalityTraits == null) {
            personalityTraits = ioFacade.readFile("adjectives.txt");
        }
        return new ArrayList<>(personalityTraits);
    }

    public List<String> getFemaleNames() {
        if (femaleNames == null) {
            femaleNames = ioFacade.readFile("femalenames.txt");
        }
        return new ArrayList<>(femaleNames);
    }

    public List<String> getMaleNames() {
        if (maleNames == null) {
            maleNames = ioFacade.readFile("malenames.txt");
        }
        return new ArrayList<>(maleNames);
    }

    public List<String> getSurnames() {
        if (surnames == null) {
            surnames = ioFacade.readFile("surnames.txt");
        }
        return new ArrayList<>(surnames);
    }
}
