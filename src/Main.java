
import framework.Helper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class Main {

    
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver(); //pravimo objekat klase chromwdriver
        driver.manage().window().maximize();
        
        driver.get("http://bvtest.school.cubes.rs/login");
        
        WebElement emailField = driver.findElement(By.name("email")); // WebElement je tip, kao npr int, double, char... jer je metoda 
                                                                     //  findElement tipa WebElement
        emailField.sendKeys("qa@cubes.rs");
        
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("cubesqa");
        
        WebElement loginButton = driver.findElement(By.className("btn-primary"));
        loginButton.click();
        
        System.out.println("Page title is: " + driver.getTitle() + "!");
        
        WebElement signaturesLink = driver.findElement(By.linkText("Signatures"));
        signaturesLink.click();
        
        System.out.println("Page title is: " + driver.getTitle() + "!");
        
        

        //CATEGORIES
        
        //go to the Categories page
        
        WebElement categoriesLink = driver.findElement(By.partialLinkText("Cat"));
        categoriesLink.click();
        
        System.out.println("Page title is: " + driver.getTitle() + "!");
        
        //Click on 'Add category' button
        
        WebElement addCategoryButton = driver.findElement(By.className("pull-right"));
        addCategoryButton.click();
        
        System.out.println("Page title is: " + driver.getTitle() + "!");
        
        //Fill the Title field
        
        WebElement fillTitleField = driver.findElement(By.id("title"));
        fillTitleField.sendKeys(Helper.getRandomText());
        
        //Click on the 'Save' button
        
        WebElement saveButton = driver.findElement(By.id("save-category-button"));
        saveButton.click();
        
            //driver.findElement(By.id("save-category-button")).click();
        
        //Click on the "Regions"
        
        WebElement navBar = driver.findElement(By.className("navbar-nav"));
        List<WebElement>liTags = navBar.findElements(By.tagName("li"));
        liTags.get(4).click();
        //navBar.findElements(By.tagName("li")); //dobro je jer nalazi sve li tagove unutar NAVBARA
        //driver.findElements(By.tagName("li")); //nije dobro ovo, naci se SVE li tagove u celom stablu
        
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement addPortalButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
        addPortalButton.click();
        
        
        Thread.sleep(7000);
        driver.quit();
    }
    
}
