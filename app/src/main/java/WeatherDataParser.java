import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class WeatherDataParser {

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {

        weatherJsonStr = "{\"city\":{\"id\":706483,\"name\":\"Kharkiv\",\"coord\":{\"lon\":36.25,\"lat\":50},\"country\":\"UA\",\"population\":0},\"cod\":\"200\",\"message\":0.0079,\"cnt\":7,\"list\":[{\"dt\":1444899600,\"temp\":{\"day\":11,\"min\":-0.05,\"max\":12.29,\"night\":-0.05,\"eve\":7.87,\"morn\":11},\"pressure\":1022.03,\"humidity\":44,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"ясно\",\"icon\":\"01d\"}],\"speed\":3.96,\"deg\":53,\"clouds\":0},{\"dt\":1444986000,\"temp\":{\"day\":10.8,\"min\":-4.39,\"max\":11.93,\"night\":-2.51,\"eve\":6.69,\"morn\":-4.39},\"pressure\":1026.04,\"humidity\":51,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"ясно\",\"icon\":\"01d\"}],\"speed\":2.3,\"deg\":70,\"clouds\":0},{\"dt\":1445072400,\"temp\":{\"day\":9.96,\"min\":-4.39,\"max\":11.4,\"night\":-2.24,\"eve\":6.42,\"morn\":-4.39},\"pressure\":1024.03,\"humidity\":54,\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"облачно\",\"icon\":\"02d\"}],\"speed\":2.06,\"deg\":148,\"clouds\":24},{\"dt\":1445158800,\"temp\":{\"day\":10.11,\"min\":-3.45,\"max\":11.34,\"night\":0.44,\"eve\":7.02,\"morn\":-3.45},\"pressure\":1015.55,\"humidity\":51,\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"пасмурно\",\"icon\":\"04d\"}],\"speed\":2.86,\"deg\":169,\"clouds\":56},{\"dt\":1445245200,\"temp\":{\"day\":11.08,\"min\":-1.8,\"max\":13.78,\"night\":-0.27,\"eve\":7.72,\"morn\":-1.8},\"pressure\":1011.35,\"humidity\":53,\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"облачно\",\"icon\":\"02d\"}],\"speed\":2.06,\"deg\":144,\"clouds\":24},{\"dt\":1445331600,\"temp\":{\"day\":12.44,\"min\":2.65,\"max\":12.44,\"night\":2.65,\"eve\":6.98,\"morn\":6.34},\"pressure\":1018.59,\"humidity\":0,\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"легкий дождь\",\"icon\":\"10d\"}],\"speed\":4.04,\"deg\":105,\"clouds\":26},{\"dt\":1445418000,\"temp\":{\"day\":12.78,\"min\":2.08,\"max\":12.78,\"night\":2.08,\"eve\":5.48,\"morn\":3.21},\"pressure\":1016.77,\"humidity\":0,\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"ясно\",\"icon\":\"01d\"}],\"speed\":4.16,\"deg\":125,\"clouds\":4}]}";
        JSONObject json = new JSONObject(weatherJsonStr);
        JSONArray jsonArray = json.getJSONArray("list");
        JSONObject jsonResult = jsonArray.getJSONObject(dayIndex);
        JSONObject jsonResult2 = jsonResult.getJSONObject("temp");
        double res = jsonResult2.getDouble("max");
        return res ;
    }

}
