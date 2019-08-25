package app;

public class SettingsService implements ISettingsService
{
    private String dataUrl;
    private int numberOfItemsToReturn;

    public SettingsService(){
        //i would normally pull these from some sort of config
        dataUrl = "https://trekhiringassignments.blob.core.windows.net/interview/bikes.json";
        numberOfItemsToReturn = 20;
    }

    public String getDataUrl() { return dataUrl; }
    public int getNumberOfItemsToReturn() { return numberOfItemsToReturn; }
}