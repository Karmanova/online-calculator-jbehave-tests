package ru.nsu.fit.tests.steps;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.By;
import org.testng.Assert;
import ru.nsu.fit.tests.services.browser.Browser;
import ru.nsu.fit.tests.services.browser.BrowserService;
import ru.nsu.fit.tests.services.browser.Utilitie;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.model.SeverityLevel;

/**
 * @author Timur Zolotuhin (e-mail: tzolotuhin@parallels.com)
 */
public class MainSteps extends Steps {
    // Constants
    private static final By inputElement = By.xpath("//input[@type='text' and @name='Input']");
    private static final By equalElement = By.xpath("//input[@type='button' and @name='DoIt']");
    private static final By plusElement = By.xpath("//input[@type='button' and @name='plus']");
    private static final By mulElement = By.xpath("//input[@type='button' and @name='times']");
    private static final By oneElement = By.xpath("//input[@type='button' and @name='one']");
    private static final By twoElement = By.xpath("//input[@type='button' and @name='two']");
    private static final By threeElement = By.xpath("//input[@type='button' and @name='three']");

    private Browser browser;
    private MyContext context;

    //Context steps
    @When("put a $name of $variable in TEMP")
    @Severity(SeverityLevel.BLOCKER)
    @Features("UI feature")
    public void putVariables(String name, String variable){
        System.out.println("1. Name: " + name + " Var " + variable);
        context.variables.put(name, variable);
    }

    @When("get a variable of $name in TEMP")
    @Severity(SeverityLevel.BLOCKER)
    @Features("UI feature")
    public Object getVariables(String name){
        System.out.println("2. Name: " + name + " Var " + context.variables.get(name));
        return context.variables.get(name);
    }

    // Main steps
    @Given("Start page of Online Calculator in browser")
    @Severity(SeverityLevel.BLOCKER)
    @Features("UI feature")
    public void openCalculator() {
        browser.openPage("http://testmethods.tmweb.ru/");
    }

    @When("User types expression $expr using user interface")
    @Severity(SeverityLevel.BLOCKER)
    @Features({"UI feature", "Subtraction", "Addition", "Multiplication", "Division"})
    public void userTypesExpressionUsingUI(String expr) {
        for (int i = 0; i < expr.length(); i++) {
            byte symbol = expr.getBytes()[i];
            switch (symbol) {
                case '1':
                    browser.click(Utilitie.oneElement);
                    break;
                case '2':
                    browser.click(twoElement);
                    break;
                case '3':
                    browser.click(threeElement);
                    break;
                case '4':
                    browser.click(Utilitie.fourElement);
                    break;
                case '5':
                    browser.click(Utilitie.fiveElement);
                    break;
                case '6':
                    browser.click(Utilitie.sixElement);
                    break;
                case '7':
                    browser.click(Utilitie.sevenElement);
                    break;
                case '8':
                    browser.click(Utilitie.eightElement);
                    break;
                case '9':
                    browser.click(Utilitie.nineElement);
                    break;
                case '0':
                    browser.click(Utilitie.zeroElement);
                    break;
                case '+':
                    browser.click(plusElement);
                    break;
                case '-':
                    browser.click(Utilitie.minusElement);
                    break;
                case '*':
                    browser.click(mulElement);
                    break;
                case '/':
                    browser.click(Utilitie.divElement);
                    break;
                case '=':
                    browser.click(equalElement);
                    break;
                default: throw new IllegalArgumentException("Could not find ui element for following symbol: " + symbol);
            }
        }
    }

    @When ("User types expression  $exp using user keyboboard")
    @Severity(SeverityLevel.BLOCKER)
    @Features({"UI feature", "Subtraction", "Addition", "Multiplication", "Division"})
    public void userTypesExpressionUsingKeybord(String expr) {
        String inputString = expr;
        char[] charsInputString = inputString.toCharArray();
        StringBuffer resultStringBuffer = new StringBuffer();
        for (int i = 0; i < charsInputString.length; i++) {
            char[] tmpArr = new char[1];
            tmpArr[0] = charsInputString[i];
            browser.typeText(Utilitie.inputElement, new String(tmpArr));
            Assert.assertEquals(browser.getValue(Utilitie.inputElement), resultStringBuffer.append(charsInputString[i]).toString());
        }

    }


    @When("User types expression $expr using keyboard")
    @Severity(SeverityLevel.BLOCKER)
    @Features({"UI feature", "Subtraction", "Addition", "Multiplication", "Division"})
    public void userTypesExpressionUsingKeyboard(String expr) {
        browser.typeText(inputElement, expr);
    }

    @Then("The result of an $type type $result")
    @Severity(SeverityLevel.BLOCKER)
    @Features("UI feature")
    public void checkResult(String type, String result) {
        switch (type) {
            case "int":
                Assert.assertEquals(Integer.parseInt(browser.getValue(inputElement)), Integer.parseInt(result));
                break;
            case "double":
                Assert.assertEquals(Double.parseDouble(browser.getValue(inputElement)), Double.parseDouble(result));
                break;
            case "String":
                Assert.assertEquals(browser.getValue(inputElement), result);
                ;
                break;
            default:
                throw new IllegalArgumentException("Could not find ui element for following symbol: " + type);
        }
    }

    @When("User applies the $exp operation by $var")
    @Severity(SeverityLevel.BLOCKER)
    @Features("UI feature")
    public void divisionOperation(String exp, String var) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(exp);
        stringBuffer.append(var);
        browser.typeText(Utilitie.inputElement, stringBuffer.toString());
    }

    @When ("User press the buton C")
    @Severity(SeverityLevel.MINOR)
    public void pressButonC() {
        browser.click(Utilitie.clearElement);
    }

    @When ("User applies the operation Ctrl + C")
    @Severity(SeverityLevel.CRITICAL)
    public void copyOperation(){
        String result = browser.getValue(Utilitie.inputElement);
        putVariables("copy", result);
    }

    @When ("User applies the operation Ctrl + V")
    @Severity(SeverityLevel.CRITICAL)
    public void pasteOperation(){
        browser.typeText(Utilitie.inputElement, getVariables("copy").toString());
        ;
    }

    @BeforeScenario
    public void beforeScenario() {
        this.browser = BrowserService.openNewBrowser();
        this.context = new MyContext();
        System.out.println("ctor");
    }

    @AfterScenario
    public void afterScenario() {
        browser.close();
        context.variables.clear();
    }

}
