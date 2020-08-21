package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.*;

public class ePortugalSearch {

	WebDriver driver = null;

	@Given("browser aberto")
	public void browser_aberto() {
		System.out.println("Browser Open");
		System.setProperty("webdriver.chrome.driver", "C:/Users/japimentelserrano/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

	@And("user esta na pagina principal")
	public void user_esta_na_pagina_principal() {
		System.out.println("user na search page");

		driver.navigate().to("https://eportugal.gov.pt/");
	}

	@When("user seleciona Servicos")
	public void user_seleciona_servicos() {
		Select drpBox = new Select (driver.findElement(By.id("desktopFormCategory")));
		drpBox.selectByVisibleText("Serviços");
	}

	@And("user escreve Abono de Familia")
	public void user_escreve_abono_de_familia() {
		
		driver.findElement(By.id("desktopFormKey")).sendKeys("Abono de Família");
	}

	@And("carrega no enter")
	public void carrega_no_enter() {
		driver.findElement(By.id("desktopFormKey")).sendKeys(Keys.ENTER);
	}

	@Then("user e levado para os resultados")
	public void user_e_levado_para_os_resultados() {
		driver.getPageSource().contains("19 RESULTADOS para \"Abono de família\"\r\n" + 
				"");
		driver.close();
		driver.quit();
	}

}
