package page;
import driver.Driver;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    By profile=By.id("user_profile_icon");
    By search=By.id("home_search");
    By zixuan=By.xpath("//*[@text='自选']");
    public static MainPage start(){
        Driver.start();
        return new MainPage();
    }

    public ProfilePage gotoProfile(){
        find(profile).click();
        return new ProfilePage();

    }

    public SearchPage gotoSearch(){
        find(search).click();
        return new SearchPage();
    }

    public ZixuanPage gotoZixuan(){
        find(zixuan).click();
        return new ZixuanPage();
    }

}
