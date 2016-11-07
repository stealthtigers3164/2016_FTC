package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by danyguag on 11/5/2016.
 */

@TeleOp(name="JagMode", group="Iterative Opmode")  // @Autonomous(...) is the other common choice
public class Jags extends OpMode {
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;

    private DcMotor intake;

    @Override
    public void init() {
        frontRight = hardwareMap.dcMotor.get("front_right");
        backRight = hardwareMap.dcMotor.get("back_right");
        frontLeft = hardwareMap.dcMotor.get("front_left");
        backLeft = hardwareMap.dcMotor.get("back_left");

        intake = hardwareMap.dcMotor.get("intake");
    }

    @Override
    public void loop() {
        //Driving
        frontLeft.setPower(gamepad1.left_stick_y);
        backLeft.setPower(gamepad1.left_stick_y);

        frontRight.setPower(-gamepad1.right_stick_y);
        backRight.setPower(-gamepad1.right_stick_y);

        //Intake
        if (gamepad2.b) {
            intake.setPower(1);
        }
        if (gamepad2.x) {
            intake.setPower(-1);
        }

        if (!gamepad2.b &&
            !gamepad2.x) {
            intake.setPower(0);
        }
    }
}
