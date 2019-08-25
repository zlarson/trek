package app;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopTwentyPopularityCalculatorService implements IPopularityCalculatorService{

    private IDataAccessService dataService;
    private ISettingsService settingsService;

    public TopTwentyPopularityCalculatorService(){
        dataService = new DataAccessFromUrlService();
        settingsService = new HardcodedSettingsService();
    }

    public void calculate(){
        List<String> garagesWithJoinedBikes = getTheData();

        Map<String, Long> bikesGrouped = garagesWithJoinedBikes
            .stream()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())
        );

        Map<String, Long> bikesGroupedOrdered = new LinkedHashMap<>();

        bikesGrouped
            .entrySet()
            .stream()
            .sorted(Map.Entry.<String, Long>comparingByValue()
            .reversed()).forEachOrdered(e -> bikesGroupedOrdered.put(e.getKey(), e.getValue()));

        bikesGroupedOrdered
            .entrySet()
            .stream()
            .limit(settingsService.getNumberOfItemsToReturn())
            .forEach(i -> System.out.println("Bike Combination '" + i.getKey() + "' was found in " + i.getValue().toString() + " family garages."));
    }

    private List<String> getTheData(){
        List<String> garagesWithJoinedBikes = dataService
            .getGarageData()
            .stream()
            .map(i -> i.joinedBikes())
            .collect(Collectors.toList());

        return garagesWithJoinedBikes;
    }
}