package page;

import driver.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class SearchPage extends BasePage{
    By select = By.id("follow_btn");
    By selected = By.id("followed_btn");
    public SearchPage search(String keyword){
        //find(By.className("android.widget.EditText")).sendKeys(keyword);
        find(By.id("search_input_text")).sendKeys(keyword);
        return this;
    }
    public MainPage cancel_main(){
        find(By.id("action_close")).click();
        return new MainPage();
    }

    public ZixuanPage cancel_zixuan(){
        find(By.id("action_close")).click();
        return new ZixuanPage();
    }

    public ArrayList<String> getAll(){
        ArrayList<String> array=new ArrayList<String>();
        for(WebElement e: Driver.getCurrentDriver().findElements(By.id("stockName"))){
            array.add(e.getText());
        }
        return array;

    }

    public ArrayList<String> getFirstStock(){
        ArrayList<String> array=new ArrayList<String>();
        System.out.println(array.add(Driver.getCurrentDriver().findElements(By.id("stockName")).get(0).getText()));

        return array;
    }


    public ArrayList<String> addSelected() {
        ArrayList<String> array = new ArrayList<String>();
        AndroidElement addselect = (AndroidElement) find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn')]"));
        array.add(addselect.getAttribute("resourceId"));
        addselect.click();
        AndroidElement select2 = (AndroidElement) find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn')]"));
        array.add(select2.getAttribute("resourceId"));
        return array;
    }

    public ArrayList<String>  addSelect(){

        ArrayList<String> array = new ArrayList<String>();
        AndroidElement addstock= (AndroidElement) find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn')]"));
        array.add(addstock.getAttribute("resourceId"));
        if(array.get(0).equals("com.xueqiu.android:id/follow_btn")){
            addstock.click();
        }
        AndroidElement select2 = (AndroidElement) find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn')]"));
        array.add(select2.getAttribute("resourceId"));
        return array;

    }

    public ArrayList<String>  removeSelected(){
        ArrayList<String> array = new ArrayList<String>();
        AndroidElement removestock= (AndroidElement) find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn')]"));
        array.add(removestock.getAttribute("resourceId"));
        if(array.get(0).equals("com.xueqiu.android:id/followed_btn")){
            removestock.click();
        }
        AndroidElement select2 = (AndroidElement) find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn')]"));
        array.add(select2.getAttribute("resourceId"));
        return array;

    }
}
