/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.commands.driveWithJoystick;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class Chassis extends SubsystemBase {
  /**
   * Creates a new Chassis.
   */
  //Declaring Motor Mapping
  public static int FRONT_LEFT = 0;
  public static int FRONT_RIGHT = 1;
  public static int BACK_LEFT = 2;
  public static int BACK_RIGHT = 3;
  public static int SHOOTER_0 = 4;
  public static int SHOOTER_1 = 5;

  WPI_TalonFX frontLeft;
  WPI_TalonFX frontRight;
  WPI_TalonFX backLeft;
  WPI_TalonFX backRight;
  PWMSparkMax leftShoot;
  PWMSparkMax rightShoot;

  public MecanumDrive drive;
  public DifferentialDrive master_Shoot;

  public Chassis() {
    // construct mecanum drive
    frontLeft = new WPI_TalonFX(FRONT_LEFT);
    frontRight = new WPI_TalonFX(FRONT_RIGHT);
    backLeft = new WPI_TalonFX(BACK_LEFT);
    backRight = new WPI_TalonFX(BACK_RIGHT);
    drive = new MecanumDrive (frontLeft, frontRight, backLeft, backRight);
  //  construct shooting speed group
    leftShoot = new PWMSparkMax(SHOOTER_0);
    rightShoot = new PWMSparkMax(SHOOTER_1);
    master_Shoot = new DifferentialDrive(leftShoot, rightShoot);
  }


  // public void publishToSmartDashboard() {
  //   SmartDashboard.putNumber("Left Velocity", getLeftVelocity());
  //   SmartDashboard.putNumber("Right Velocity", getRightVelocity());
  //   SmartDashboard.putNumber("Left Follower Velocity", getLeftFollowerVelocity());
  //   SmartDashboard.putNumber("Right Follower Velocity", getRightVelocity());
  //   SmartDashboard.putNumber("Left Position", getLeftPosition());
  //   SmartDashboard.putNumber("Right Position", getRightPosition());
  // }
  // public double getLeftPosition() {
  //   return frontLeft.getEncoder().getPosition();
  // }

  // public double getRightPosition() {
  //   return -frontRight.getEncoder().getPosition();
  // }

  // public double getRightFollowerVelocity() {
  //   return backRight.getEncoder().getVelocity();
  // }

  // public double getLeftVelocity() {
  //   return frontLeft.getEncoder().getVelocity();

  // }

  // public double getLeftFollowerVelocity() {
  //   return backLeft.getEncoder().getVelocity();
  // }

  // public double getRightVelocity() {
  //   return -frontRight.getEncoder().getVelocity();
  // }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
