package be.cegeka.datingapp.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomFacade {

    private Random random = new Random();

    public List<Integer> getNonRepetitiveRandomNumbers(int amountOfNumbers, int min, int max) {
        List<Integer> toReturn = new ArrayList<>();

        List<Integer> numbers = IntStream.range(min, max)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(numbers);

        for (int i = 0; i < amountOfNumbers; i++) {
            int randomIndex = random.nextInt(numbers.size());
            int randomElement = numbers.get(randomIndex);
            numbers.remove(randomIndex);
            toReturn.add(randomElement);
        }
        return toReturn;
    }

    public int getRandomNumber(int min, int max) {
        return random.nextInt(max-min) + min;
    }
}
