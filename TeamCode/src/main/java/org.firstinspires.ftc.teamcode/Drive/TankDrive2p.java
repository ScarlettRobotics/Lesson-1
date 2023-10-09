package org.firstinspires.ftc.teamcode.Drive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.*;
import org.firstinspires.ftc.robotcore.external.Telemetry;


/**
 * Lesson 1
 * Teaches the basics of using the FTC package.
 */
@TeleOp(name = "TankDrive2p", group = "auto")
public class TankDrive2p extends OpMode {
    // Class variables
    protected DcMotor motorLeft;
    protected DcMotor motorRight;
    protected Servo clawLeft;
    protected Servo clawRight;

    // Gamepad variables
    protected boolean pgamepad2a;

    @Override
    public void init() {
        motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
        motorRight = hardwareMap.get(DcMotor.class, "motorRight");

        motorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        clawLeft = hardwareMap.get(Servo.class, "clawLeft");
        clawRight = hardwareMap.get(Servo.class, "clawRight");
        // Telemetry
        telemetry.addData("STATUS: ", "Initialized"); // the FTC equivalent to println()
        telemetry.addData("FTC Team #", "22531");
    }

    @Override
    public void loop() {
        // Update drive system
        motorLeft.setPower(gamepad1.left_stick_y);
        motorRight.setPower(gamepad1.right_stick_y);

        // Update claw
        if (gamepad2.a) {
            clawLeft.setPosition(0.595);
            clawRight.setPosition(0.73);
        }
        if (gamepad2.b) {
            clawLeft.setPosition(0.70);
            clawRight.setPosition(0.61);
        }

        // Telemetry
        telemetry(telemetry);
    }

    public void telemetry(Telemetry telemetry) {
        telemetry.addData("\nCurrent class", "DualMotorDrive.java");
        telemetry.addData("runMode", motorLeft.getMode());
        telemetry.addData("Left Power",
                "%4.2f", motorLeft.getPower());
        telemetry.addData("Right Power",
                "%4.2f", motorRight.getPower());

        telemetry.addData("\nCurrent class", "ClawCore.java");
        telemetry.addData("Left claw position", clawLeft.getPosition());
        telemetry.addData("Right claw position", clawRight.getPosition());
    }
}
