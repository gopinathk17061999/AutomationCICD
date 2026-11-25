package AutomationTesting;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Practice {
public static boolean StringPalindrome(String Str)
{   Str=Str.toLowerCase();
	int left=0;
	int right=Str.length()-1;
	while(left<right)
	{
	if (Str.charAt(left)!= Str.charAt(right))
	{
		return false;
	}
	left++;
	right--;
	}
	return true;


}
	
	public static void main(String[] args) {
 
		
		System.out.println(StringPalindrome("Java"));
		
	}

}
