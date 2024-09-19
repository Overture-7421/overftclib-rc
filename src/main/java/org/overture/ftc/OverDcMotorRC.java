//TEST
package org.overture.ftc;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.overture.ftc.overftclib.OverDcMotor;

public class OverDcMotorRC implements OverDcMotor {

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

}
