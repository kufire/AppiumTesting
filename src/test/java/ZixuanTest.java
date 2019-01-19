import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.LoginPage;
import page.MainPage;
import page.SearchPage;
import page.ZixuanPage;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class ZixuanTest {

    static MainPage mainPage;
    static ZixuanPage zixuanPage;
    static SearchPage searchPage;

    @BeforeAll
    static void beforeAll(){
        mainPage=MainPage.start();
        zixuanPage=mainPage.gotoZixuan();

    }


    @ParameterizedTest
    @CsvSource({
            "PDD",
            "alibaba"
    })
    void 添加自选(String keyword){
        searchPage=zixuanPage.gotoSearch();
        searchPage.search(keyword);
        assertThat(searchPage.addSelect(),hasItems("com.xueqiu.android:id/followed_btn"));
        searchPage.cancel_zixuan();
    }

    @ParameterizedTest
    @CsvSource({
            "PDD",
            "alibaba"
    })
    void 删除自选(String keyword){
        searchPage=zixuanPage.gotoSearch();
        searchPage.search(keyword);
        assertThat(searchPage.removeSelected(),hasItems("com.xueqiu.android:id/follow_btn"));
        searchPage.cancel_zixuan();
    }

}
