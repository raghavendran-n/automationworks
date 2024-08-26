package StepDefinition;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class AutomationExercise {
	
	WebDriver driver = null;
	
	
	@Given("user is on automation exercise site")
	public void user_is_on_automation_exercise_site() {
	    
	    String projectpath = System.getProperty("user.dir");
	    System.out.println("Project path is"+ projectpath);
	    
	    System.setProperty("webdriver.chrome.driver",projectpath+"/src/test/resources/Drivers/chromedriver.exe" );
	    
	    driver = new ChromeDriver();
	    
	    System.out.println("About to launch automationexercise site");
	    
	    driver.get("https://automationexercise.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    boolean t = driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed();
	      if (t) {
	         System.out.println("Page is loaded successfully");
	      } else {
	         System.out.println("Page load failed");
	      }
	    		
	    
	}

	

	@And("enters username and password")
	public void enters_username_and_password() {
		System.out.println("Entering username and password");
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("raghav@tester.com");
		driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Raghav#2000");
		boolean t = driver.findElement(By.xpath("//button[@data-qa='login-button']")).isDisplayed();
	      if (t) {
	         System.out.println("Login button is displayed");
	      } else {
	         System.out.println("Login button is not displayed");
	      }
		
	}

	@And("hits login button")
	public void hits_login_button() {
		System.out.println("Clicking login button");
		driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
		boolean t = driver.findElement(By.xpath("//a[@href='/logout']")).isDisplayed();
	      if (t) {
	         System.out.println("Login successful");
	      } else {
	         System.out.println("Login failed");
	      }
	}

	@Then("user lands in homepage")
	public void user_lands_in_homepage() {
		System.out.println("Verifying homepage logo");
		boolean t = driver.findElement(By.xpath("//img[@alt='Website for automation practice']")).isDisplayed();
	      if (t) {
	         System.out.println("Site Logo is displayed");
	      } else {
	         System.out.println("Site Logo is not displayed");
	      }
	      
	     System.out.println("Verifying user profile name after sign-in");
	     	boolean u = driver.findElement(By.xpath("//b[' Logged in as '][text()='Raghav']")).isDisplayed();
		    if (u) {
		       System.out.println("Profile name is displayed");
		      } else {
		       System.out.println("Profile name is not displayed");
		      }
	    
		
	}
	
	@When("user hits sign in")
	public void user_hits_sign_in() {
		System.out.println("Clicking sign in");
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		System.out.println("Verifying email and password field");
		boolean t = driver.findElement(By.xpath("//input[@data-qa='login-email']")).isDisplayed();
	      if (t) {
	         System.out.println("Email and password fields are displayed");
	      } else {
	         System.out.println("Email and password fields are not displayed");
	      }
		
	}
	
	@When("user navigates to PDP")
	public void user_navigates_to_pdp() {
		System.out.println("Navigating to PDP of product 1");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 550)"); // if the element is on bottom.
		//WebElement scroll = driver.findElement(By.xpath("//a[@href='/product_details/2']"));
	    //Actions actions = new Actions(driver);
	    //actions.moveToElement(scroll).perform();
		driver.findElement(By.xpath("//a[@href='/product_details/2']")).click();
		System.out.println("Verifying PDP page details");
		boolean t = driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).isDisplayed();
	      if (t) {
	         System.out.println("PDP - Add to cart button is visible");
	      } else {
	         System.out.println("PDP - Add to cart button is not visible");
	      }
	      boolean u = driver.findElement(By.xpath("//input[@id='quantity']")).isDisplayed();
	      if (u) {
	         System.out.println("PDP - Quantity button is visible");
	      } else {
	         System.out.println("PDP - Quantity button is not visible");
	      }
	}

	@When("adds product into cart")
	public void adds_product_into_cart() {
		System.out.println("Adding product to cart");
		
	      boolean u = driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).isDisplayed();
	      if (u) {
	    	  driver.findElement(By.xpath("//button[@class='btn btn-default cart']")).click();
	    	  System.out.println("Add to cart button is clicked successfully");
	    	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	      } else {
	         System.out.println("Add to cart button failed");
	      }
	      
	}

	@Then("navigates to cart page")
	public void navigates_to_cart_page() {
		System.out.println("Verifying cart addition modal");
		boolean t = driver.findElement(By.xpath("//i[@class='material-icons']")).isDisplayed();
	      if (t) {
	         System.out.println("Green tick is displayed");
	      } else {
	         System.out.println("Green tick is not displayed");
	      }
	      boolean u = driver.findElement(By.xpath("//h4[text()='Added!']")).isDisplayed();
	      if (u) {
	         System.out.println("Added! text is displayed");
	      } else {
	         System.out.println("Added! text is not displayed");
	      }
	      boolean v = driver.findElement(By.xpath("//a[@href='/view_cart']")).isDisplayed();
	      if (v) {
	    	  driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
	    	  System.out.println("View cart url is clicked successfully");
	      } else {
	         System.out.println("View cart url selection failed");
	      }
	}

	@When("user verifies cart addition")
	public void user_verifies_cart_addition() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("navigates to checkout")
	public void navigates_to_checkout() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("verifies checkout details")
	public void verifies_checkout_details() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
