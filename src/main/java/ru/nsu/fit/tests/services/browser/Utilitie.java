package ru.nsu.fit.tests.services.browser;

import org.openqa.selenium.By;
import org.testng.Assert;
import ru.nsu.fit.tests.shared.AllureUtils;

/**
 * Created by Анастасия on 16.12.2015.
 */
public class Utilitie {

        public static String PAGE_URL = "http://testmethods.tmweb.ru/";

        public static final By inputElement = By.xpath("//input[@type='text' and @name='Input']");

        public static final By zeroElement = By.xpath("//input[@type='button' and @name='zero']");
        public static final By oneElement = By.xpath("//input[@type='button' and @name='one']");
        public static final By twoElement = By.xpath("//input[@type='button' and @name='two']");
        public static final By threeElement = By.xpath("//input[@type='button' and @name='three']");
        public static final By fourElement = By.xpath("//input[@type='button' and @name='four']");
        public static final By fiveElement = By.xpath("//input[@type='button' and @name='five']");
        public static final By sixElement = By.xpath("//input[@type='button' and @name='six']");
        public static final By sevenElement = By.xpath("//input[@type='button' and @name='seven']");
        public static final By eightElement = By.xpath("//input[@type='button' and @name='eight']");
        public static final By nineElement = By.xpath("//input[@type='button' and @name='nine']");

        public static final By clearElement = By.xpath("//input[@type='button' and @name='clear']");
        public static final By equalElement = By.xpath("//input[@type='button' and @name='DoIt']");

        public static final By plusElement = By.xpath("//input[@type='button' and @name='plus']");
        public static final By minusElement = By.xpath("//input[@type='button' and @name='minus']");
        public static final By divElement = By.xpath("//input[@type='button' and @name='div']");
        public static final By timesElement = By.xpath("//input[@type='button' and @name='times']");

        public static double round(String inputValue, int t) {
            Double tmpResDouble = Double.parseDouble(inputValue);
            double tmpRes = tmpResDouble.doubleValue();
            tmpRes = tmpRes * t;
            int tmpResInt = (int) Math.round(tmpRes);
            tmpRes = (double)tmpResInt / t;
            return tmpRes;
        }


        public static void loggin(String expecVal, String messageImage, String messageLog, Browser browser) {
            if(expecVal != null) {
                Assert.assertEquals(browser.getValue(Utilitie.inputElement), expecVal);
            }
            AllureUtils.saveTextLog("The page was opened successfully");
            AllureUtils.saveImageAttach("Main screen", browser.makeScreenshot());
        }
}
