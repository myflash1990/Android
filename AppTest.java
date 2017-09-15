package com.example.macbookpro.swipet;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.Until;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

/**
 * Created by MacbookPro on 8/24/17.
 */
@RunWith(AndroidJUnit4.class)

public class ClickYes {

    private static final String BASIC_SAMPLE_PACKAGE
            = "com.tinder"; // package path/name
    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String STRING_TO_BE_TYPED = "UiAutomator";
    private UiDevice mDevice;

    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = mDevice.getLauncherPackageName();
        Assert.assertThat(launcherPackage, CoreMatchers.notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                LAUNCH_TIMEOUT);

        // Launch the app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        // Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)),
                LAUNCH_TIMEOUT);
    }

    @Test
    public void click() throws InterruptedException, UiObjectNotFoundException {

        int c = 0;

        Thread.sleep(3000);
      //  while (c < 1) {

            String name = "/Users/macbookpro/Desktop/Untitled Export/test.png";
            File path = new File(name);
            Thread.sleep(500);
            mDevice.findObject(By.res("com.tinder:id/gamepad_like")).click();
              //mDevice.findObjects(By.clazz("")).get(0).click();
            //mDevice.findObject(new UiSelector().className("some").text("")).click();
            //mDevice.findObject(new UiSelector().resourceId("").className("").text("")).click()
       // }




    }

}
