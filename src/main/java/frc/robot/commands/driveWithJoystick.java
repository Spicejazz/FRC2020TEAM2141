/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import frc.robot.subsystems.Chassis;

import java.lang.module.ModuleDescriptor.Requires;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.MecanumDrive; 

public class driveWithJoystick extends CommandBase {
  /**
   * Creates a new driveWithJoystick.
   */
  public XboxController drivePad = XboxController(0);
  Chassis m_Subsytem;
  public driveWithJoystick(Chassis subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Subsytem = subsystem;
    addRequirements(subsystem);
  }

  private XboxController XboxController(int i) {
    return null;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Subsytem.drive.driveCartesian(drivePad.getY(Hand.kLeft), drivePad.getX(Hand.kLeft), drivePad.getX(Hand.kRight));
    m_Subsytem.master_Shoot.tankDrive(drivePad.getTriggerAxis(Hand.kLeft), drivePad.getTriggerAxis(Hand.kLeft));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
