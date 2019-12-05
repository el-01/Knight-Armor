package frc.team2036.robot //creates package for robot code

import edu.wpi.first.wpilibj.Joystick //joystick code
// import edu.wpi.first.wpilibj.TalonSRX
import edu.wpi.first.wpilibj.Spark // 1 robot
import frc.team2036.robot.knightarmor.KnightBot 
import edu.wpi.first.wpilibj.XboxController
import edu.wpi.first.wpilibj.drive.MecanumDrive
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj.Preferences
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX
import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj.Encoder
import edu.wpi.first.wpilibj.CounterBase.EncodingType

import edu.wpi.first.wpilibj.Talon

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;

// OPENCV
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;


import org.opencv.core.*;
import org.opencv.core.Core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.*;
import org.opencv.objdetect.*;

import kotlin.math.*; // Is this right?
class Robot : KnightBot() {
    //left joystick
    lateinit var controller0: Joystick // ties one controller to be a joystick
    //right joystick
    lateinit var controller1: Joystick // ties other controller to be a joystick
    //drivetrain
    lateinit var drivetrain: MecanumDrive // drivetrain type

    //back elevator
    lateinit var rearElevatorMotor: Spark // ties rearElevator to a Spark motor controller
    //main elevator
    lateinit var elevatorMotor: WPI_TalonSRX // ties elevatorMotor to a TalonSRX controller
    //ball intak
    lateinit var grabMotor1: WPI_VictorSPX // ties the ball intakes to motor controllers
    lateinit var grabMotor2: Talon 
    //hatch intake
    lateinit var hatchIntake: Talon // ties hatch intake to a Talon


    override fun robotInit() { // creates initialisation function

        controller0 = Joystick(0) // ties one joystick to controller0
        controller1 = Joystick(1) // ties another joystick to controller1
        drivetrain = MecanumDrive(WPI_TalonSRX(1), WPI_TalonSRX(2), WPI_TalonSRX(3), WPI_TalonSRX(4)) // Creates drivetrain. RTFM!

        rearElevatorMotor = Spark(8) // channel
        elevatorMotor = WPI_TalonSRX(20) // channel

        grabMotor1 = WPI_VictorSPX(11)
        grabMotor2 = Talon(7)
        hatchIntake = Talon(9)
    }

    /* run repeatedly during the teleop period */
    override fun teleopPeriodic(){
        
        var x = controller0.getX();
        var y = controller0.getY();
        var bearingX = controller1.getX();
        var bearingY = controller1.getY();
        var totalBearing = atan2(bearingY,bearingX);// Is this correct?
        drivetrain.driveCartesian(x,y,totalBearing);
        
    }

    /* run repeatedly during auto period */
    override fun autonomousPeriodic(){

    }


}
