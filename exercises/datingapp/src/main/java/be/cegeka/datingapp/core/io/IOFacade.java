package be.cegeka.datingapp.core.io;

import javax.inject.Singleton;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@Singleton
public class IOFacade {
    private Scanner scanner = new Scanner(System.in);

    public void output(String out) {
        System.out.println(out);
    }

    public String input() {
        return scanner.next();
    }

    public int inputMenuNumber(int max) {
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input >= 1 && input <= max) {
                    return input;
                } else {
                    errorMax(max);
                }
            } catch (Exception e) {
                errorMax(max);
            }
        }
    }

    public List<String> readFile(String filename) {
        try {
            URL resourceUrl = getClass().getClassLoader().getResource(filename);
            return Files.lines(Paths.get(resourceUrl.toURI())).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emptyList();
    }

    private void errorMax(int max) {
        System.out.println("Please enter a number from 1 to " + max);
    }
}
