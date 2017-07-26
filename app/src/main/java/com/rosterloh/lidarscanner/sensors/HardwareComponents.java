package com.rosterloh.lidarscanner.sensors;

import com.google.android.things.contrib.driver.pwmservo.Servo;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import timber.log.Timber;

@Singleton
public class HardwareComponents {

    private static final String GPIO_SERVO_H = "PWM0";

    private Servo mServoH;

    @Inject
    HardwareComponents() {
        try {
            mServoH = new Servo(GPIO_SERVO_H);
            mServoH.setPulseDurationRange(1.0, 2.0);
            mServoH.setAngleRange(0.0, 180.0);
            mServoH.setEnabled(true);
            mServoH.setAngle(mServoH.getMinimumAngle());
        } catch (IOException e) {
            Timber.e("Failed to initialise horizontal servo");
        }
    }

    public boolean moveHorizontal(double angle) {
        try {
            mServoH.setAngle(angle);
            return true;
        } catch (IOException e) {
            Timber.e("Move failed: " + e.getMessage());
            return false;
        }
    }
}
