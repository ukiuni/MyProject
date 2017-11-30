package com.ukiuni.education.myproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MyprojectApplicationTests {
	private WebDriver driver;

	@LocalServerPort
	int port;

	@Before
	public void init() throws InterruptedException {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("linux")) {
			System.setProperty("webdriver.chrome.driver", "libs/chromedriver_linux");
		} else if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", "libs/chromedriver");
		}
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testIndex() {
		driver.get("http://localhost:" + port);
		Assert.assertEquals("新しいサービスを開始します。", driver.findElement(By.id("read")).getText());
	}

	@Test
	public void testRegist() {
		driver.get("http://localhost:" + port);
		driver.findElement(By.tagName("input")).sendKeys("asdf@example.com");
		driver.findElement(By.tagName("button")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.id("thx"), "お知らせは asdf@example.com にメールをお送りします。連絡差し上げるまでしばらくお待ち下さい。"));
	}

	@Test
	public void testRegistError() {
		driver.get("http://localhost:" + port);
		driver.findElement(By.tagName("input")).sendKeys("asd");
		driver.findElement(By.tagName("button")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "登録できないメールアドレスです。"));
	}

}
