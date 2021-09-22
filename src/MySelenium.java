import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MySelenium {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\navarun\\Downloads\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://sanusart.github.io/react-dropdown-select/");

        //Clicking on the drop-down box.
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div[2]/div/div/div/div/div")).click();

        //Sometimes, after the first click, the fourth element is automatically selected.
        //This may be a bug in the web page's code.
        //Grab the fourth element and inspect it.
        WebElement myElement4 = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div[3]/span[4]"));
        String attr4 = myElement4.getAttribute("aria-selected");
        if(attr4.equals("true")) {
            System.out.println("The fourth element is selected.");
        }
        else {
            System.out.println("The fourth element is NOT selected. Selecting it now.");
            myElement4.click();
        }

        //Clicking on the first element in the drop-down box.
        WebElement myElement1 = driver.findElement(By.xpath("/html/body/div/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div[3]/span[1]"));
        myElement1.click();


        String attr1 = myElement1.getAttribute("aria-selected");
        if(attr1.equals("true")) {
            System.out.println("The first element is selected.");
        }
        else {
            System.out.println("The first element is NOT selected.");
        }

        attr4 = myElement4.getAttribute("aria-selected");
        if(attr4.equals("true")) {
            System.out.println("The fourth element is selected.");
        }
        else {
            System.out.println("The fourth element is NOT selected.");
        }


        System.out.println("Clearing the selection.");

        myElement1.click();
        myElement4.click();

        attr1 = myElement1.getAttribute("aria-selected");
        if(attr1.equals("true")) {
            System.out.println("The first element is selected.");
        }
        else {
            System.out.println("The first element is NOT selected.");
        }

        attr4 = myElement4.getAttribute("aria-selected");
        if(attr4.equals("true")) {
            System.out.println("The fourth element is selected.");
        }
        else {
            System.out.println("The fourth element is NOT selected.");
        }

        //driver.quit();


    }
}
