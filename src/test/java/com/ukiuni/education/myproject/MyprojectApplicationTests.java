package com.ukiuni.education.myproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
		System.setProperty("webdriver.chrome.driver", "libs/chromedriver");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testIndex() {
		driver.get("http://localhost:" + port);
		Assert.assertEquals("新しいサービスを開始します。", driver.findElement(By.tagName("body")).getText());
	}
}
