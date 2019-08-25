package app;

import java.util.Collections;
import java.util.List;

public class Garage{
    public List<String> bikes;

    public String joinedBikes(){
        Collections.sort(bikes);
        return String.join(", ", bikes);
    }
}