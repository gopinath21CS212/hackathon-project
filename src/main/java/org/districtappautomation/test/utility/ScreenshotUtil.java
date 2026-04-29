package org.districtappautomation.test.utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public void takeScreenshot(WebDriver driver) {
        try {
            File dir = new File("screenshots");
            if (!dir.exists()) dir.mkdirs();
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(dir, "img_" + System.currentTimeMillis() + ".png");
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}