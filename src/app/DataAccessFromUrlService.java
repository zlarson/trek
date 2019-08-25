package app;

import java.net.URL;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataAccessFromUrlService implements IDataAccessService
{
    private ISettingsService settings;

    public DataAccessFromUrlService() {
        settings = new SettingsService();
    }

    public List<Garage> getGarageData() {

      try
      {        
        ObjectMapper mapper = new ObjectMapper();

        List<Garage> garages = mapper.readValue(new URL(settings.getDataUrl()), new TypeReference<List<Garage>>(){});

        return garages;
      }
      catch (Exception e)
      {
        //should probably log e somewhere
        return null;
      }
    } 
  }