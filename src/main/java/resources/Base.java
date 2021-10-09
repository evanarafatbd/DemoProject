package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    //WEBDRIVER
    public WebDriver driver = null;
    //PROPERTIES FILE CONNECTION
    public Properties prop;
    public FileInputStream fis;

    //READING FROM XCEL
    public HSSFWorkbook wb = null;
    public HSSFSheet sheet = null;
    public Cell cell = null;
    public FileOutputStream fio = null;
    public int numberOfRows, numberOfCol, rowNum;
    public File  file;

    //READING FROM SQL
    public Connection connect = null;
    public Statement statement = null;
    public PreparedStatement ps = null;
    public ResultSet resultSet = null;

    String url= "https://www.amazon.com/";

    @Parameters({"browserName"})
    @BeforeMethod
    public void localDriverInt(@Optional("chrome")String browserName) {

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @AfterMethod
    public void tearDown() {
        Reporter.log("closing browser");
        driver.close();
    }

    public WebDriver getCloudDriver(String envName,String envUsername, String envAccessKey,
                                    String os, String os_version,String browserName,
                                    String browserVersion) throws IOException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser",browserName);
        cap.setCapability("browser_version",browserVersion);
        cap.setCapability("os", os);
        cap.setCapability("os_version", os_version);


        if(envName.equalsIgnoreCase("SauceLabs")){
            //resolution for Saucelabs
            driver = new RemoteWebDriver(new URL("http://"+envUsername+":"+envAccessKey+
                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
        }else if(envName.equalsIgnoreCase("Browserstack")) {
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), cap);
        }
        return driver;
    }


    //HELPER METHODS

    public static void sleepFor(int sec) throws InterruptedException {

        Thread.sleep(sec*1000);
    }

    public String loadProperties1(String keys) {

        String value = "";
        try {
        File filePath = new File("../src/main/java/resources/configuration.properties");

            prop = new Properties();
            fis = new FileInputStream(filePath);
            prop.load(fis);
            value = prop.getProperty(keys);
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return value;

    }

    public String readConfig(String key)
    {
        File src = new File("../resources/configuration.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
        String value= prop.getProperty(key);
        return value;
    }

    public String getApplicationURL(String key)
    {
        String url=prop.getProperty(key);
        return url;
    }

    public String getUsername(String key)
    {
        String username=prop.getProperty(key);
        return username;
    }

    public String getPassword(String key)
    {
        String password=prop.getProperty(key);
        return password;
    }

    //To highlight an element
    public void highLighterMethod(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
    //To take screen shot
    public void captureScreen(WebDriver driver,String testName) throws IOException {


        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/screenShots/" + testName + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    public void highLightNScreenShot(WebDriver driver,WebElement element, String testName){
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow;" +
                    " border: 2px solid red;');", element);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/screenShots/" + testName + ".png");

            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot taken");
    }

    public void selectOptionByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public void mouseHoverByCSS(String locator) {


        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();

        }

    }

    public void mouseHoverByXpath(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();

        }

    }

    public void mouseHoverByXPathOrCss(String locator) {
        if(locator.startsWith("//")) {
            try {
                WebElement element = driver.findElement(By.xpath(locator));
                Actions action = new Actions(driver);
                Actions hover = action.moveToElement(element);
            } catch (Exception ex) {
                System.out.println("First attempt has been done, This is second try");
                WebElement element = driver.findElement(By.cssSelector(locator));
                Actions action = new Actions(driver);
                action.moveToElement(element).perform();

            }
        } else{
            try {
                WebElement element = driver.findElement(By.cssSelector(locator));
                Actions action = new Actions(driver);
                Actions hover = action.moveToElement(element);
            } catch (Exception ex) {
                System.out.println("First attempt has been done, This is second try");
                WebElement element = driver.findElement(By.cssSelector(locator));
                Actions action = new Actions(driver);
                action.moveToElement(element).perform();

            }

        }

    }


    public void okAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void cancelAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    //iFrame Handle
    public void iframeHandle(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void waitUntilClickAble( WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilVisible(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
    }

    public void waitUntilSelectable(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    public void upLoadFile(String locator, String path) {
        driver.findElement(By.cssSelector(locator)).sendKeys(path);
        /* path example to upload a file/image
           path= "C:\\Users\\rrt\\Pictures\\ds1.png";
         */
    }

    public String getCellValue(HSSFCell cell) {
        Object value = null;

        int dataType = cell.getCellType();
        switch (dataType) {
            case HSSFCell.CELL_TYPE_NUMERIC:
                value = cell.getNumericCellValue();
                break;
            case HSSFCell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
        }
        return value.toString();

    }

    //READING FROM XCEL FILE
    public String[][] fileReader1(String path,int sheetIndex) throws IOException {
        String[][] data = {};
        file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        wb = new HSSFWorkbook(fis);
        sheet = wb.getSheetAt(sheetIndex);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(0).getLastCellNum();
        data = new String[numberOfRows + 1][numberOfCol + 1];

        for (int i = 1; i < data.length; i++) {
            HSSFRow rows = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                HSSFCell cell = rows.getCell(j);
                String cellData = getCellValue(cell);
                data[i][j] = cellData;
            }
        }
        return data;
    }

    public String[] fileReader2(String path, int sheetIndex) throws IOException {
        String[] data = {};
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        wb = new HSSFWorkbook(fis);
        sheet = wb.getSheetAt(sheetIndex);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(0).getLastCellNum();
        data = new String[numberOfRows + 1];

        for (int i = 0; i < data.length; i++) {
            HSSFRow rows = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                HSSFCell cell = rows.getCell(j);
                String cellData = getCellValue(cell);
                data[i] = cellData;
            }
        }
        return data;
    }
    //READING FROM SQL SERVER

    public Properties loadProperties() throws IOException{
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("../Generic/secret.properties");
        prop.load(ism);
        ism.close();

        return prop;
    }

    public Connection connectToSqlDatabase() throws IOException, SQLException, ClassNotFoundException {
        Properties prop = loadProperties();
        String driverClass = prop.getProperty("MYSQLJDBC.driver");
        String url = prop.getProperty("MYSQLJDBC.url");
        String userName = prop.getProperty("MYSQLJDBC.userName");
        String password = prop.getProperty("MYSQLJDBC.password");
        Class.forName(driverClass);
        connect = DriverManager.getConnection(url,userName,password);
        System.out.println("Database is connected");
        return connect;
    }

    private void close() {
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connect != null){
                connect.close();
            }
        }catch(Exception e){

        }
    }

    public List<String> readDataBase(String tableName, String columnName)throws Exception{

        List<String> data = new ArrayList<String>();

        try {
            connectToSqlDatabase();
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from " + tableName);
            data = getResultSetData(resultSet, columnName);
        } catch (ClassNotFoundException e) {
            throw e;
        }finally{
            close();
        }
        return data;
    }


    public List<String> getResultSetData(ResultSet resultSet, String columnName) throws SQLException {
        List<String> dataList = new ArrayList<String>();
        while(resultSet.next()){
            String itemName = resultSet.getString(columnName);
            dataList.add(itemName);
        }
        return dataList;
    }

    public List<String> directDatabaseQueryExecute(String passQuery,String dataColumn)throws Exception{
        List<String> data = new ArrayList<String>();

        try {
            connectToSqlDatabase();
            statement = connect.createStatement();
            resultSet = statement.executeQuery(passQuery);
            data = getResultSetData(resultSet, dataColumn);
        } catch (ClassNotFoundException e) {
            throw e;
        }finally{
            close();
        }
        return data;
    }

    public List<String> readUserProfileFromSqlTable(String tableName,
                                                    String column1,String column2, String column3)
            throws IOException, SQLException, ClassNotFoundException{
        List<String> list = new ArrayList<String>();
        //String customer = null;
        try{
            Connection conn = connectToSqlDatabase();
            String query = "SELECT * FROM "+tableName;
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultSet
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultSet
            while (rs.next())
            {
                String col1 = rs.getString(column1);
                String col2 = rs.getString(column2);
                String col3 = rs.getString(column3);
                //System.out.format("%s, %s\n", name, id);
                /*customer = new String(col1);*/
                list.add(col1);
                list.add(col2);
                list.add(col3);

            }
            st.close();
        }catch (Exception e){
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return list;
    }


















}


























































