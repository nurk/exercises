package be.cegeka.datingapp.matching;

import be.cegeka.datingapp.core.RandomFacade;
import be.cegeka.datingapp.user.User;
import be.cegeka.datingapp.user.UserInfoRepository;
import com.google.inject.Inject;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class MatchingService {
    private final UserInfoRepository userInfoRepository;
    private final RandomFacade randomFacade;

    @Inject
    public MatchingService(UserInfoRepository userInfoRepository, RandomFacade randomFacade) {
        this.userInfoRepository = userInfoRepository;
        this.randomFacade = randomFacade;
    }

    public User findAUser() {
        return new User.Builder()
                .withName(getRandomName())
                .withSurName(getRandomSurname())
                .withPersonalityTraits(getRandomTraits(3))
                .withAge(randomFacade.getRandomNumber(18, 100))
                .build();
    }

    private List<String> getRandomTraits(int amount) {
        List<String> personalityTraits = userInfoRepository.getPersonalityTraits();

        List<Integer> personalityIndexes = randomFacade.getNonRepetitiveRandomNumbers(amount, 0, personalityTraits.size());
        return personalityIndexes.stream().map(personalityTraits::get).collect(Collectors.toList());
    }

    private String getRandomSurname() {
        List<String> surnames = userInfoRepository.getSurnames();
        return surnames.get(randomFacade.getRandomNumber(0, surnames.size()));
    }

    private String getRandomName() {
        List<String> femaleNames = userInfoRepository.getFemaleNames();
        List<String> maleNames = userInfoRepository.getMaleNames();

        int randomGender = randomFacade.getRandomNumber(0, 2);
        if (randomGender == 0) {
            return femaleNames.get(randomFacade.getRandomNumber(0, femaleNames.size()));
        } else {
            return maleNames.get(randomFacade.getRandomNumber(0, femaleNames.size()));
        }
    }
}
