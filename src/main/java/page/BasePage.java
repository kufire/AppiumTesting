package page;

import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import static java.lang.Thread.sleep;


public class BasePage {

    static AndroidElement waitfor(By locator) {
        Point p1,p2;
        p1 = Driver.getCurrentDriver().findElement(locator).getLocation();
        for (int i = 0; i < 20; i++){
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p2 = Driver.getCurrentDriver().findElement(locator).getLocation();
            if(p1.equals(p2)){
                break;
            }
        }
        return Driver.getCurrentDriver().findElement(locator);
    }

    static AndroidElement find(By locator){
        try{
            return waitfor(locator);
        }catch (Exception e){
            Driver.getCurrentDriver().findElement(text("下次再说")).click();
            return waitfor(locator);
        }
    }

    /*
    static AndroidElement find(By locator){
        try{
            return Driver.getCurrentDriver().findElement(locator);
        }catch (Exception e){
            Driver.getCurrentDriver().findElement(text("下次再说")).click();
            return Driver.getCurrentDriver().findElement(locator);
        }
    }*/

    static By locate(String locator){
        if(locator.matches("/.*")){
            return By.xpath(locator);
        }else{
            return By.id(locator);
        }
    }
    static By text(String content){
        return By.xpath("//*[@text='"+ content + "']");
    }


}
