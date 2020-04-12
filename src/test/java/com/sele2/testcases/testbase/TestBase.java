package com.sele2.testcases.testbase;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.varia.NullAppender;

import com.sele2.support.DriverUtils;

import io.qameta.allure.Step;

import com.sele2.driver.DriverManagerFactory;
import com.sele2.helper.FileReaderManager;
import com.sele2.pages.ChoosePanels;
import com.sele2.pages.GeneralPage;
import com.sele2.pages.HomePage;
import com.sele2.pages.LoginPage;
import com.sele2.pages.NewPage;
import com.sele2.pages.PanelPage;


public class TestBase {
	public GeneralPage generalPage = new GeneralPage();
	public LoginPage loginPage = new LoginPage();
	public HomePage homePage = new HomePage();
	public NewPage newPage = new NewPage();
	public PanelPage panelPage = new PanelPage();
	public ChoosePanels choosePanels = new ChoosePanels();

	@BeforeClass
	@Parameters({ "BROWSER", "REMOTE"})
	public static void setUp(@Optional String BROWSER, @Optional String REMOTE) {
		System.out.println("Pre-condition");
		BasicConfigurator.configure();
		if(BROWSER!=null) FileReaderManager.getInstance().getConfigReader().updateConfigFile("browser", BROWSER);
		if(REMOTE!=null) FileReaderManager.getInstance().getConfigReader().updateConfigFile("remoteURL", REMOTE);
		DriverUtils.driver = DriverManagerFactory.getDriverManager(FileReaderManager.getInstance().getConfigReader().getBrowser()).getWebDriver();
	}

	@AfterClass
	public void tearDown() {
		System.out.println("Post-condition");
		Logger.getRootLogger().removeAllAppenders();
		Logger.getRootLogger().addAppender(new NullAppender());
		DriverUtils.driver.quit();
	}

	@Step("Navigate to Dashboard login page")
	public void goToDashboardLoginPage() {
		DriverUtils.driver.get(DriverUtils.url);
		DriverUtils.driver.manage().window().maximize();
		DriverUtils.driver.manage().timeouts().pageLoadTimeout(DriverUtils.loadTimeout,TimeUnit.SECONDS);
		DriverUtils.driver.manage().timeouts().implicitlyWait(DriverUtils.implicityWait, TimeUnit.SECONDS);
	}
}
