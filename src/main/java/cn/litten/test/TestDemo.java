package cn.litten.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/11/9.
 */
public class TestDemo {
    private static ChromeOptions chromeOptions;
    private static WebDriver driver;
    private static String url = "https://www.baidu.com/";

    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "D:\\my_project\\AutoTest\\src\\main\\resources\\chromedriver.exe");
        chromeOptions = new ChromeOptions();
        //通过配置参数禁止data;的出现
        chromeOptions.addArguments("--user-data-dir=C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data\\Default");
        //通过配置参数删除“您使用的是不受支持的命令行标记：--ignore-certificate-errors。稳定性和安全性会有所下降。”提示
        chromeOptions.addArguments("--start-maximized", "allow-running-insecure-content", "--test-type");
        driver = new ChromeDriver(chromeOptions);
    }
    @Test
    public void getHtmlPage(){
        System.out.println("正在打开浏览器···");
        driver.get(url);
        try {
            Thread.sleep(1000*3);
            driver.quit();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
