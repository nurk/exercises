package be.cegeka.movierental;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    @Test
    public void customer() {
        Customer c = new Customer("David");
        assertThat(c).isNotNull();
    }

    @Test
    public void addRental() {
        Customer customer2 = new Customer("Sallie");
        Movie movie1 = new Movie("Gone with the Wind", MoviePriceCode.REGULAR);
        Rental rental1 = new Rental(movie1, 3); // 3 day rental
        customer2.addRental(rental1);
    }

    @Test
    public void getName() {
        Customer c = new Customer("David");
        assertThat(c.getName()).isEqualTo("David");
    }

    @Test
    public void statementForRegularMovie() {
        Customer customer2 = new Customer("Sallie");
        Movie movie1 = new Movie("Gone with the Wind", MoviePriceCode.REGULAR);
        Rental rental1 = new Rental(movie1, 3); // 3 day rental
        customer2.addRental(rental1);
        String expected = "Rental Record for Sallie\n" +
                "\tGone with the Wind\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";
        String statement = customer2.statement();
        assertThat(statement).isEqualTo(expected);
    }

    @Test
    public void statementForNewReleaseMovie() {
        Customer customer2 = new Customer("Sallie");
        Movie movie1 = new Movie("Star Wars", MoviePriceCode.NEW_RELEASE);
        Rental rental1 = new Rental(movie1, 3); // 3 day rental
        customer2.addRental(rental1);
        String expected = "Rental Record for Sallie\n" +
                "\tStar Wars\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points";
        String statement = customer2.statement();
        assertThat(statement).isEqualTo(expected);
    }

    @Test
    public void statementForChildrensMovie() {
        Customer customer2 = new Customer("Sallie");
        Movie movie1 = new Movie("Madagascar", MoviePriceCode.CHILDRENS);
        Rental rental1 = new Rental(movie1, 3); // 3 day rental
        customer2.addRental(rental1);
        String expected = "Rental Record for Sallie\n" +
                "\tMadagascar\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";
        String statement = customer2.statement();
        assertThat(statement).isEqualTo(expected);
    }

    @Test
    public void statementForManyMovies() {
        Customer customer1 = new Customer("David");
        Movie movie1 = new Movie("Madagascar", MoviePriceCode.CHILDRENS);
        Rental rental1 = new Rental(movie1, 6); // 6 day rental
        Movie movie2 = new Movie("Star Wars", MoviePriceCode.NEW_RELEASE);
        Rental rental2 = new Rental(movie2, 2); // 2 day rental
        Movie movie3 = new Movie("Gone with the Wind", MoviePriceCode.REGULAR);
        Rental rental3 = new Rental(movie3, 8); // 8 day rental
        customer1.addRental(rental1);
        customer1.addRental(rental2);
        customer1.addRental(rental3);
        String expected = "Rental Record for David\n" +
                "\tMadagascar\t6.0\n" +
                "\tStar Wars\t6.0\n" +
                "\tGone with the Wind\t11.0\n" +
                "Amount owed is 23.0\n" +
                "You earned 4 frequent renter points";
        String statement = customer1.statement();
        assertThat(statement).isEqualTo(expected);
    }

    //TODO make test for price breaks in code.
}