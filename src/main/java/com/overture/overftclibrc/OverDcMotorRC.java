/*
 * Overftclib-RC
 * Written by: Santiago Quintana
 * Owned By: Overture Robotics Group.
 *
 * The following Interface is provided as-is in the intention of a long-term modern FTC Library that integrates WPILibJava
 * devices, logic and references.
 *
 * All rights reserved 2024. (R) OVERTURE ROBOTICS GROUP
 * */

package com.overture.overftclibrc;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.overture.ftc.overftclib.Devices.IOverDcMotor;

public class OverDcMotorRC implements IOverDcMotor {

    DcMotorEx motorEx;

    public OverDcMotorRC(HardwareMap hardwareMap, String name){
        motorEx = hardwareMap.get(DcMotorEx.class, name);
    }

    @Override
    public void setPower(double v) {
        motorEx.setPower(v);
    }

    @Override
    public double getPower() {
        return 0;
    }

    @Override
    public void setDirection(Direction direction) {
        switch (direction) {};
    }

    @Override
    public Direction getDirection() {
        return null;
    }

    @Override
    public void setMode(RunMode runMode) {
        switch (runMode) {};
    }

    @Override
    public void setZeroPowerBehavior(ZeroPowerBehavior behavior) {
        switch (behavior) {};
    }

    @Override
    public void setTargetPosition(int i) {
        motorEx.setTargetPosition(i);
    }

    @Override
    public int getTargetPosition() {
        return 0;
    }

    @Override
    public int getCurrentPosition() {
        return 0;
    }

}
