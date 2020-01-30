package be.cegeka.movierental;

enum MoviePriceCode {
    CHILDRENS,
    NEW_RELEASE,
    REGULAR;
}

public class Movie {

    private String _title;
    private MoviePriceCode _priceCode;

    public Movie(String title, MoviePriceCode priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public MoviePriceCode getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(MoviePriceCode priceCode) {
        _priceCode = priceCode;
    }

    public String getTitle() {
        return _title;
    }

}
