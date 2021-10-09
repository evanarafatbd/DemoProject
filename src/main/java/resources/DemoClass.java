package resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.poifs.filesystem.Entry;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.sql.DriverManager.getConnection;

public class DemoClass extends Base{

    public static void main(String[] args) {


        













































































































































/*
        String url= "https://www.amazon.com/";


        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setPlatform(Platform.WIN10);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(url),caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File path= new File("path.exe");
        try {
            FileUtils.copyFile(screenshot,path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //  WebElement customersAjax= driver.findElement(By.cssSelector("ol[role='list'] >li:nth-of-type(4)"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement until = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ol[role='list'] >li:nth-of-type(4)")));
        until.click();
        System.out.println(driver.getTitle());
        sleepFor(3);
        driver.close();
        String url1= "url";
        String userName= "username";
        String password= "password";
        Class.forName("jdbc.driver goes here");
        Connection connection= DriverManager.getConnection(url, userName,password);
        ResultSet rs=  connection.createStatement().executeQuery("Select * from customers");

        Actions mouse= new Actions(driver);
        Robot keyBoard= new Robot();
        keyBoard.keyPress(KeyEvent.VK_TAB);


        int index= 0;
        while (rs.next()){
            rs.getString(index);
            if (rs.getString(index).equalsIgnoreCase("Evan Arafat")){
                Assert.assertEquals("31", "32");
            }
            index++;
            break;

        }
        connection.close();







        //Evan's algo testings

        //To join two list
        List<String> list1= new ArrayList<>();
        list1.add("Evan");
        list1.add("Liza");
        list1.add("Yerav");

        List<String> list2= new ArrayList<>();
        list2.add("Suha");
        list2.add("Jisha");
        list2.add("Baby");

        List<String> combined= new ArrayList<>();
        combined.addAll(list1);
        combined.addAll(list2);

        System.out.println(list1);
        System.out.println(list2);
        System.out.println(combined);

        //ArrayList to Array
        List<String> list3= new ArrayList<>();
        list3.add("Java");
        list3.add("JavaScript");
        list3.add("Python");

        Object[] array= list3.toArray();
        System.out.println(list3 +" array list to array "+ array);
        */
/*for (Object language: array){
            System.out.println(language);
        }*//*


        //Convert Array to ArrayList

        Object[] array2= {"evan","loves his", 1, "wife"};
       ArrayList<Object> array4= new ArrayList<>(Arrays.asList(array2));
       System.out.println("Array to ArrayList "+ array4);

       //Conver Map to ArrayList
        Map<Object, Object> map1= new HashMap<>();
        map1.put(1,"Evan Arafat");
        map1.put(2,"Yerav Rahat");
        map1.put(3,"Hafiza Liza");

        List<Object> keys= new ArrayList<>(map1.keySet());
        List<Object> values= new ArrayList<>(map1.values());
        System.out.println("Keys " +keys);
        System.out.println("Values "+ values);

        //Iterate through HashMap with full key and value
        Iterator<Map.Entry<Object, Object>> names = map1.entrySet().iterator();
        while (names.hasNext()){
            System.out.println("Entry Set "+names.next());

        }

        //Iterate through HashSet
        Set<String> languages = new HashSet<>();
        languages.add("Java");
        languages.add("JavaScript");
        languages.add("Python");
        System.out.println("Set: " + languages);

        // Using forEach loop
        System.out.println("Iterating over Set using for-each loop:");
        for(String language : languages) {
            System.out.print(language);
            System.out.print(", ");
        }

        System.out.println("Merge two list");
        List<Integer> prime = new ArrayList<>();
        prime.add(2);
        prime.add(3);
        prime.add(5);
        System.out.println("First List: " + prime);

        // create second list
        List<Integer> even = new ArrayList<>();
        even.add(4);
        even.add(6);
        System.out.println("Second List: " + even);

        List<Integer> combined2= new ArrayList<>();
        combined2.addAll(prime);
        combined2.addAll(even);
        System.out.println(combined2);

        //Remove duplicate elements from list
        List<Object> list = new ArrayList<>(Arrays.asList(1,1,1,2,2,2,3,3,3,4,4,5,5));
        System.out.println("duplicate value list "+ list);

        Set<Object> set1= new HashSet<>();
        set1.addAll(list);
        list.clear();
        list.addAll(set1);
        System.out.println("no duplicate vlue list "+ list);
        // REVERSING ARRAYLIST
        Collections.reverse(list);
        System.out.println("Reversed ArrayList is "+ list);
*/











        //TO FIND VOWEL
//        boolean isItaVowel=false;
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("Enter a character : ");
//        char ch=scanner.next().charAt(0);
//        scanner.close();
//        switch(ch) {
//            case 'a' :
//                isItaVowel = true;
//            case 'e' :
//                isItaVowel = true;
//            case 'i' :
//                isItaVowel = true;
//            case 'o' :
//                isItaVowel = true;
//            case 'u' :
//                isItaVowel = true;
//            case 'A' :
//                isItaVowel = true;
//            case 'E' :
//                isItaVowel = true;
//            case 'I' :
//                isItaVowel = true;
//            case 'O' :
//                isItaVowel = true;
//            case 'U' :
//                isItaVowel = true;
//        }
//        if(isItaVowel == true) {
//            System.out.println(ch+" is  a Vowel");
//        }
//        else {
//            if((ch>='a'&& ch<='z')||(ch>='A'&&ch<='Z'))
//                System.out.println(ch+" is a Consonant");
//            else
//                System.out.println("Input is not an alphabet");
//        }
//    }



//        //TO REVERSE A STRING
//        String word = "Evan Arafat";
//        String reversed = "";
//        int wordLength = word.length();
//
//        for (int i = wordLength - 1; i >= 0; i--) {
//            reversed = reversed + word.charAt(i);
//        }
//        System.out.println(reversed);
//
//        //OR
//        StringBuffer sb = new StringBuffer(word);
//        StringBuffer newWord = sb.reverse();
//        System.out.println(newWord + " 2");
//
//        //TO SWAP NUMBERS
//        int a = 20, b = 10, t;
//        a = a + b; //20+10=30
//        b = a - b; //30-10=20
//        a = a - b; //30-20=10
//        System.out.println(a + " " + b);
//
//        //TO FIND LEAP YEAR
//        int year;
//        System.out.println("Enter an Year :: ");
//        Scanner sc = new Scanner(System.in);
//        year = sc.nextInt();
//
//        if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0))
//            System.out.println("Specified year is a leap year");
//        else
//            System.out.println("Specified year is not a leap year");
//
//        //OR
//
//            if (year % 4 == 0 && year % 100 != 0 || year == 0) {
//                System.out.println(year + " is a leap year");
//
//            } else {
//                System.out.println(year + " is a NOT leap year");


//            //REVERSE INT NUMBER
//        int num = 12345;
//        int rev= 0, remainder;
//
//        while (num > 0) {
//
//            remainder = num % 10;
//            rev = rev * 10 + remainder;
//            num = num / 10;
//        }
//        System.out.println(rev);

        //TO FIND PRIME NUMBER
        // 1*5,1*7,1*11,1*13,1*17,1*19
//        int num = 4;
//        boolean flag=false;
//        for (int i = 2; i <= num / 2; ++i) {
//            // condition for non prime number
//            if (num % i == 0) {
//                flag=true;
//                break;
//            }
//        } if (flag)
//            System.out.println(num + " is not a prime number.");
//        else
//            System.out.println(num + " is a prime number.");
//    }


//        //TO FIND ARMSTRONG NUMBER
//        int num = 370, actualNumber, remainder, total = 0;
//
//        actualNumber = num;
//        while (actualNumber != 0)
//        {
//            remainder = actualNumber % 10;
//            total = total + remainder*remainder*remainder;
//            actualNumber /= 10;
//        }
//
//        if(total == num)
//            System.out.println(num + " is an Armstrong number");
//        else
//            System.out.println(num + " is not an Armstrong number");


//        //TO FIND LARGEST AND SMALLEST NUMBER IN AN ARRAY
//        int numbers[] = {55,32,45,98,82,11,9,39,50};
//
//        //assign first element of an array to largest and smallest int smallest = numbers[0];
//        int largest = numbers[0];
//        System.out.println( numbers[0] +" "+ largest);
//        int smallest = numbers[0];
//        System.out.println( numbers[0] +" "+ smallest);
//
//        for (int i = 1; i< numbers.length; i++) {
//            if (numbers[i]> largest) {
//                System.out.println(numbers[i] + " " + largest);
//                largest = numbers[i];
//                System.out.println(numbers[i] + " " + largest);
//
//             }else if (numbers[i]< smallest)
//                System.out.println( numbers[i] +" "+ smallest);
//            smallest = numbers[i];
//            System.out.println( numbers[i] +" "+ smallest);
//        }
//
//        System.out.println("Largest Number is : " + largest);
//        System.out.println("Smallest Number is : " + smallest);

        //writing factorial
//        int num= 5;
//
//        int fact=1;
//        for(int i=1; i<=5;i++){
//            fact= fact* i; //0*1
//    }
//        System.out.println(fact);


        //writing fibonacci series

        //0,1,1,2,3,5,8,13,21,34
//         int num =40;
//         int n1=0, n2=1, temp=0;
//         int sum1 = 0;
//
//         for(int i=2; i<=num;i++){
//             sum1=n1+n2;
//             n1=n2;
//             n2=sum1;
//         }
//        System.out.println(sum1);

        //Finding lowest number from this array

//        int  array[] = new int[]{211,110,99,34,67,89,67,456,321,456,78,90,45,32,56,78,90,54,32,123,67,5,679,54,32,65};
//
//        int lowest= array[0];
//        int highest= array[0];
//                for(int i=1; i<array.length; i++){
//
//                    if(array[i]<lowest){
//                        lowest= array[i];
//                    }
//
//                }
//
//        System.out.println(lowest);
//                System.out.println(highest);


        //Fizz Buzz test (if number is even print fizz, if number is odd print buzz
//        try {
//            int num = 0;
//
//            Scanner scanner = new Scanner(System.in);
//            int num1 = 1;
//            while (num1 != 0) {
//                System.out.println("plz put a whole number");
//                num = scanner.nextInt();
//                if (num % 2 == 0) {
//                    System.out.println("Fizz");
//                } else if (num % 3 == 0) {
//                    System.out.println("Buzz");
//                } else {
//
//                    System.out.println(num + " is not a whole number you idiot");
//
//                }
//
//            }
//        } catch (InputMismatchException m) {
//            m.printStackTrace();
//        }

        //REVERSE A STRING

        // String sentence="Hi my name is Evan Arafat";
//        String reversed="";
//        int len= sentence.length();
//        System.out.println("original: "+sentence);
//        for(int i= len-1; i>=0; i--){
//
//            reversed= reversed+ sentence.charAt(i);
//        }
//        System.out.println("reversed: "+reversed);
//        if(sentence.equals(reversed)) {
//            System.out.println("it is a palindrome sentence");
//        }else
//                System.out.println("it is NOT a palindrome sentence");

//       //REVERSE AN INTEGER in an Array
//        //Function 1 using built in method
//        Integer [] num= {2,4,5,7,9,6,1,3};
//        Collections.reverse(Arrays.asList(num));
//        System.out.println("Reversed using Collections and Arrays: "+Arrays.asList(num));

        //Function 2 reversing Array integer manually using loops
//        int [] num= {2,4,5,7,9,6,1,3};
//        for(int i= num.length-1; i>=0; i--){
//            System.out.print(num[i]+ " ");
//         }

        //Reverse integer

//        int num= 123456789;
//        int reversed=0, remainder;
//        System.out.println("before reversing "+num);
//        while(num>0){
//            remainder= num%10;
//            reversed= (reversed*10) +remainder;
//            num= num/10;
//        }
//        System.out.println("after reversing "+reversed);


        // manually finding largest and smallest num in array
//        int [] num= {2,4,5,7,9,6,1,3};
//
//        int largest = num[0];
//        int smallest = num[0];
//       for(int i=1; i<num.length;i++){
//           if(num[i]> largest){
//               largest= num[i];
//           }else if(num[i]<smallest){
//               smallest=num[i];
//           }
//       }
//        System.out.println(largest+ " largest in array");
//        System.out.println(smallest+ " smallest in array");

        //Print characters A to Z
//        char a= 'a', z='z';
//        for(char i=a; i<=z; i++){
//           // System.out.print(i+" "); TO PRINT ALL CHARS: ABCDEFGH
//            if(i%2==0){
//                System.out.print(i+" "); // TO PRINT EVERY OTHER CHARS: BDFHJLN
//            }
//
//        }
//        char c= "c";
//        int ascii = (int) c;
//        System.out.println(ascii);

        // MY PERSONAL METHOD TO FIND VOWELS IN ANY SENTENCE AND
        // HOW MANY VOWELS TOTAL AND TOTAL CHARACTER
//        String st = ";aslkdnfoer;qIiIitrjew;lka,;s.nv;aouthjew;ljr.s";
//        int a = 0, e = 0, I = 0, o = 0, u = 0;
//        int count = 0;
//        boolean flag = false;
//        char c = ' ';
//
//
//        for (int i = 0; i < st.length(); i++) {
//            c = st.toLowerCase().charAt(i);
//            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
//                flag=true;
//                count++;
//
//                   if (c == 'a') {
//                        a++;
//                    } else if (c == 'e') {
//                        e++;
//                    } else if (c == 'i') {
//                        I++;
//                    } else if (c == 'o') {
//                        o++;
//                    } else if (c == 'u') {
//                        u++;
//                    }
//            }
//    }if(flag!=true) {
//            System.out.println("there are NO vowels in this sentence.");
//        }
//        System.out.println("total number of Vowels: " + count+" and characters: "+st.length());
//        System.out.println("a: " + a);
//        System.out.println("e: " + e);
//        System.out.println("i: " + I);
//        System.out.println("o: " + o);
//        System.out.println("u: " + u);
//        System.setProperty("webdriver.chrome.driver","C:/Users/evana/" +
//                "ProgrammingFiles/chromedriver_win32/chromedriver.exe");
//        WebDriver driver= new ChromeDriver();
//        WebDriverWait wait= new WebDriverWait(driver, 10);
        //WebElement element= new WebDriverWait(driver, 10)
        // .until(ExpectedConditions.elementToBeClickable(By.className(".class")));
//        driver.get("https://www.google.com/");
//        Thread.sleep(1000);
//        driver.navigate().to("https://www.aol.com/");
//        Thread.sleep(1000);
//        driver.navigate().refresh();
//        Thread.sleep(1000);
//        driver.navigate().back();
//        Thread.sleep(1000);
//        driver.navigate().forward();
//
//        HashMap<String, String> windowHandles= new HashMap<>();
//        String homePageHandle= driver.getWindowHandle();
//        windowHandles.put("HomePage", homePageHandle);
//        driver.navigate().to(windowHandles.get("HomePage"));
//        driver.quit();
//        System.out.println("window handle is: "+windowHandles.get("HomePage"));
//
//       WebElement element= driver.findElement(By.id("idName"));
//        Select select= new Select(element);
//        select.selectByVisibleText("words");
//        Robot rb= new Robot();
//        rb.keyPress(KeyEvent.VK_ACCEPT);
//
//        Actions mouse= new Actions(driver);
//        boolean id= driver.findElement(By.id("idname")).isDisplayed();
//        ExpectedConditions.elementToBeClickable(By.id("aslkdjf"));
//        driver.switchTo().frame(driver.findElements(By.tagName("iframe")).get(0));
//        Alert alert= driver.switchTo().alert();
//        alert.accept();
//

//        String a = "0123456789";
//        StringBuffer sbf = new StringBuffer(a);
//        System.out.println("before " + sbf);
//        sbf.reverse();
//        sbf.insert(5, "Evan");
//        System.out.println(sbf);
//
//
//        String s = "Evan Arafat";
//        StringBuilder sb = new StringBuilder(s);
//
//        System.out.println(sb.reverse());
//        try {
//            Scanner scanner = new Scanner(new File("C:/Users/evana/ProgrammingFiles/mysql-init.txt"));
//            while (scanner.hasNextLine()) {
//                System.out.println(scanner.nextLine());
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Set<String> set = new HashSet<String>();
//        set.add("Evan Arafat");
//        set.add("Suha Arafat");
//        set.add("Hafiza Akther Liza");
//        set.add("Anowara Joly");
//        System.out.println(set);
//        Iterator it = set.iterator();
//        System.out.println(set);
//
//        Stack stk = new Stack();
//        stk.push("Evan");
//        stk.push("liza");
//        stk.push("suha");
//        stk.push("mom");
//        stk.push("Yerav baby");
//        System.out.println("top " + stk.peek());
//        int yeravIN = stk.search("Yerav");
//        System.out.println("yerav int " + yeravIN);
//
//        System.out.println(stk);
//        //System.out.println(stk.pop());
//        try {
//            while (stk != null) {
//                System.out.println("1 " + stk.pop());
//            }
//        } catch (EmptyStackException e) {
//            e.getMessage();
//            e.getStackTrace();
//            e.getLocalizedMessage();
//        }
//
//        LinkedList<String> list= new LinkedList<String>();
//        list.add("Evan");
//        System.out.println(list);
//        list.remove("Evan");
//        System.out.println(list);

//        int[] recallYears = {1995, 1996, 1997, 1998, 2006, 2007, 2008};
//
//        int[] modelYear = {1996, 1998, 2006,2020};
//
//        List ry= new ArrayList();
//        ry.add(recallYears);//????????????? solve later
//
//        boolean flag = false;
//        try {
//            for (int i = 0; i <= recallYears.length; i++) {
//                for (int j = 0; j <= modelYear.length; j++) {
//                    if (recallYears[i]== modelYear[j]) {
//                        System.out.println("RECALL");
//                        flag = true;
//                        continue;
//                    }
//                }if (flag == false) {
//                    System.out.println("Dont Recall");
//                }
//
//            }
//        }catch (Exception e){
//        e.getStackTrace();
//
//            Reporter.log("Hello Evan Hellooo");

        // TODO Auto-generated method stub
      /* System.setProperty("webdriver.chrome.driver","C:\\work\\chromedriver.exe");
       WebDriver driver =new ChromeDriver();
       driver.get("http://www.qaclickacademy.com/interview.php");
       driver.findElement(By.xpath("//li[text()=' Selenium ']")).click();

       //TO TRAVERSE TO SIBLING ELEMENT: ADD /following-sibling::li[1]
       driver.findElement(
       By.xpath("//ul[@class='responsive-tabs__list']/li[1]/following-sibling::li[2]")).click();
       //TO TRAVERSE TO PARENT ELEMENT FROM CHILD ELEMENT : ADD /parent::ul
       System.out.println(driver.findElement(
       By.xpath(".//*[@id='tablist1-tab2']/parent::ul")).getAttribute("role"));*/

        //To automate auto suggest test fields like on google
      /* WebDriver driver =new ChromeDriver();

       driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

       driver.findElement(By.id("autosuggest")).sendKeys("ind");

       try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }

       List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

       for(WebElement option :options)

       {

           if(option.getText().equalsIgnoreCase("India"))

           {

               option.click();

               break;

           }

       }

        WebDriver driver= new ChromeDriver();
        Actions actions= new Actions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        driver.findElement(By.cssSelector("sdfsdf")).click();
        actions.sendKeys("sdfsadf");
        try {
            Robot robot= new Robot();
        } catch (AWTException e) {
            e.printStackTrace();

        }

        Arrays.asList();
        ArrayList<Integer> al= new ArrayList<>();
        al.add(2);
        Vector<String> vec= new Vector<String>();
        Collections.sort(al);
        Collections.synchronizedList(al);
        HashSet<String> hset= new HashSet<>();
        hset.size();
        Iterator it= hset.iterator();
        it.hasNext();
        int[] arr= {1,2,3,};
        ListIterator li = al.listIterator();
        Map<Integer, String> m= new HashMap<Integer, String>();
        m.put(1, "Evan Arafat");
        String[] ar= new String[10];
        ar[0]= "Evan Arafat";
        Object[] a1= {"evan", "suha","liza",1,2.5,10000000};
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        WebElement element= driver.findElement(By.cssSelector("demo"));
        WebDriver driver1= new EdgeDriver();
        //IMPLICIT WAIT
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS)
        //EXPLECIT WAIT
        WebDriverWait explecitWait= new WebDriverWait(driver1, 20);
        explecitWait.until(ExpectedConditions.elementToBeClickable(element));
        explecitWait.until(ExpectedConditions.alertIsPresent());
        explecitWait.until(ExpectedConditions.visibilityOf(element));
        //FLUENT WAIT
        Wait fluentWait= new FluentWait(driver).withTimeout(20,TimeUnit.SECONDS)
                .pollingEvery(5,TimeUnit.SECONDS).ignoring(NoSuchFieldException.class);
*/
    }















}














