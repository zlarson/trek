package app;

public class App 
{ 
    public static void main(String args[]) 
    { 
        //i would normally have used some sort of class composer here instead of manually creating instances
        IPopularityCalculatorService popularityCalculator = new TopTwentyPopularityCalculatorService();
        popularityCalculator.calculate();
    } 
}