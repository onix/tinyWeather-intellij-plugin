import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.bbelovic.weather.IWeatherReader;
import org.bbelovic.weather.YahooWeatherReader;

public class ShowWeather extends AnAction {

    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        String cityName = Messages.showInputDialog(project, "Enter the name of a city:", "City", Messages.getQuestionIcon());
        if (cityName != null) {
            try {
                IWeatherReader weather = new YahooWeatherReader(cityName);
                weather.process();

                String weatherConditionString = "Weather in " + weather.getLocation() + "\n"
                        + "Temperature now is " + weather.getWeatherModel().getTemperature() + "°C" + "\n"
                        + "Humidity: " + weather.getWeatherModel().getHumidity() + "%" + "\n"
                        + "Condition: " + weather.getWeatherModel().getCondition() + "\n"
                        + "\n"
                        + "Forecast for next four days: " + "\n"
                        + "Day 1: " + weather.getWeatherModel().getForecast().get(0) + "\n"
                        + "Day 2: " + weather.getWeatherModel().getForecast().get(1) + "\n"
                        + "Day 3: " + weather.getWeatherModel().getForecast().get(2) + "\n"
                        + "Day 4: " + weather.getWeatherModel().getForecast().get(3);

                Messages.showMessageDialog(project, weatherConditionString, "Weather Condition", Messages.getInformationIcon());
            } catch (Exception e) {
                Messages.showMessageDialog(project,
                        "Oops! Something gone wrong. Check Internet connection or try another city.",
                        "Error", Messages.getErrorIcon()
                );
            }
        }

    }

}