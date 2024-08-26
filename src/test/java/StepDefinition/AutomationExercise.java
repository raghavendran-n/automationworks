package StepDefinition;

import java.time.Duration;
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
		driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
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
	    	  driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));

	      } else {
	         System.out.println("Add to cart button failed");
	      }
	      
	}

	@Then("navigates to cart page")
	public void navigates_to_cart_page() {
		System.out.println("Verifying cart addition modal");
		
	      boolean u = driver.findElement(By.xpath("//a[@href='/view_cart']")).isDisplayed();
	      if (u) {
	         System.out.println("View cart url is displayed");
	      } else {
	         System.out.println("View cart url is not displayed");
	      }
	      boolean v = driver.findElement(By.xpath("//a[@href='/view_cart']")).isDisplayed();
	      if (v) {
	    	  driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
	    	  driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
	    	  System.out.println("View cart url is clicked successfully");
	      } else {
	         System.out.println("View cart url selection failed");
	      }
	}

	@When("user verifies cart addition")
	public void user_verifies_cart_addition() {
		boolean v = driver.findElement(By.xpath("//a[@href='/product_details/1'][text()='Blue Top']")).isDisplayed();
	      if (v) {
	    	  System.out.println("Product name is present in cart entry");
	      } else {
	         System.out.println("Product name is not present in cart entry");
	      }
	    boolean t = driver.findElement(By.xpath("//button[text()='1']")).isDisplayed();
	      if (t) {
	    	  System.out.println("Product Quantity added is present in cart entry");
	      } else {
	         System.out.println("Product Quantity added is not present in cart entry");
	      }
	    boolean u = driver.findElement(By.xpath("//p[text()='Rs. 500']")).isDisplayed();
	      if (u) {
	    	  System.out.println("Product unit price is present in cart entry");
	      } else {
	         System.out.println("Product unit price is not present in cart entry");
	      }
	    boolean w = driver.findElement(By.xpath("//p[@class='cart_total_price'][text()='Rs. 500']")).isDisplayed();
	      if (w) {
	    	  System.out.println("Cart total price is present");
	      } else {
	         System.out.println("Cart total price is not present");
	      }
	    boolean x = driver.findElement(By.xpath("//a[@class='btn btn-default check_out'][text()='Proceed To Checkout']")).isDisplayed();
	      if (x) {
	    	  System.out.println("Checkout button is present");
	      } else {
	         System.out.println("Checkout button is not present");
	      }
	}

	@When("navigates to checkout")
	public void navigates_to_checkout() {
		boolean x = driver.findElement(By.xpath("//a[@class='btn btn-default check_out'][text()='Proceed To Checkout']")).isDisplayed();
	      if (x) {
	    	  driver.findElement(By.xpath("//a[@class='btn btn-default check_out'][text()='Proceed To Checkout']")).click();
	    	  System.out.println("Checkout button is present");
	      } else {
	         System.out.println("Checkout button is not present");
	      }
	}

	@Then("verifies checkout details")
	public void verifies_checkout_details() {
		boolean v = driver.findElement(By.xpath("//a[@href='/product_details/1'][text()='Blue Top']")).isDisplayed();
	      if (v) {
	    	  System.out.println("Product name is present in checkout page");
	      } else {
	         System.out.println("Product name is not present in checkout page");
	      }
	    boolean t = driver.findElement(By.xpath("//button[text()='1']")).isDisplayed();
	      if (t) {
	    	  System.out.println("Product Quantity added is present in checkout page");
	      } else {
	         System.out.println("Product Quantity added is not present in checkout page");
	      }
	    boolean u = driver.findElement(By.xpath("//p[text()='Rs. 500']")).isDisplayed();
	      if (u) {
	    	  System.out.println("Product unit price is present in checkout page");
	      } else {
	         System.out.println("Product unit price is not present in checkout page");
	      }
	    boolean w = driver.findElement(By.xpath("//h2[text()='Review Your Order']")).isDisplayed();
	      if (w) {
	    	  System.out.println("Review your order button is present checkout page");
	      } else {
	         System.out.println("Review your order button is not present checkout page");
	      }
	    boolean x = driver.findElement(By.xpath("//ul[@id='address_delivery']/li[text()='Mr. Raghav Tester']")).isDisplayed();
	      if (x) {
	    	  System.out.println("Customer name in delivery address is present checkout page");
	      } else {
	         System.out.println("Customer name in delivery address is not present checkout page");
	      }
	     boolean y = driver.findElement(By.xpath("//a[@href='/payment'][text()='Place Order']")).isDisplayed();
	      if (y) {
	    	  System.out.println("Place order button is present checkout page");
	      } else {
	         System.out.println("Place order button is not present checkout page");
	      }
	      
	      driver.close();
	      driver.quit();
	     
	}

}
