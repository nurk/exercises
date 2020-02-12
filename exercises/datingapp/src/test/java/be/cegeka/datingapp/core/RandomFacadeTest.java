package be.cegeka.datingapp.core;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RandomFacadeTest {

    private RandomFacade randomFacade = new RandomFacade();

    @Test
    void getRandomNumbers_hasOnlyDistinctNumbers() {
        List<Integer> actual = randomFacade.getNonRepetitiveRandomNumbers(20, 0, 20);

        IntStream.range(0, 20)
                .boxed()
                .forEach(assertThat(actual)::contains);
    }
}