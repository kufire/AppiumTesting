package page;

import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import static java.lang.Thread.sleep;


public class BasePage {
    //元素连续两次找到的位置一样，才定位到元素
    static AndroidElement find_two(By locator) {
        Point p1,p2;
        for (int i = 0; i < 20; i++){
            p1 = Driver.getCurrentDriver().findElement(locator).getLocation();
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
            return find_two(locator);
        }catch (Exception e){
            Driver.getCurrentDriver().findElement(text("下次再说")).click();
            return find_two(locator);
        }
    }

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
