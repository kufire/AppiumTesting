package page;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;


public class ZixuanPage  extends BasePage{

    By search = By.id("action_create_cube");
    public SearchPage gotoSearch(){
        find(search).click();
        return new SearchPage();
    }

    public ArrayList<String> getStockAll(){
        ArrayList<String> array=new ArrayList<String>();
        for(WebElement e: Driver.getCurrentDriver().findElements(By.id("stockName"))){
            array.add(e.getText());
        }
        return array;
    }



}
