/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * Add your docs here.
 */
public class ArduinoInterface extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private SerialPort arduino;
  public Timer timer;

  public String lastMessage = "";
  public double lastAngle = 0.0;

  public ArduinoInterface() {

    timer = new Timer();
    timer.start();

    try {
      for (final SerialPort.Port c : SerialPort.Port.values())
        System.out.println(c);
      arduino = new SerialPort(9600, SerialPort.Port.kUSB);
      System.out.println("Connected to Arduino kUSB");

    } catch (final Exception e) {
      System.out.println("Failed to initially connect to Arduino, gonna try again!");

      try {
        for (final SerialPort.Port c : SerialPort.Port.values())
          System.out.println(c);
        arduino = new SerialPort(9600, SerialPort.Port.kUSB1);
        System.out.println("Connected to Arduino kUSB1");

      } catch (final Exception ekusb1) {
        System.out.println("Failed to initially connect to Arduino on kUSB1, gonna try again!");

        try {
          for (final SerialPort.Port c : SerialPort.Port.values())
            System.out.println(c);
          arduino = new SerialPort(9600, SerialPort.Port.kUSB2);
          System.out.println("Connected to Arduino");

        } catch (final Exception ekusb2) {
          System.out.println("Failed to initially connect to Arduino on kUSB2, gonna try again!");
        }
      }
    }

    }
    public String getSerialPortBuffer() {
      if (arduino.getBytesReceived() > 0 && timer.get() > 0.2) {
        // System.out.println(arduino.readString());
        timer.reset();
        return arduino.readString();
      } else {
        return lastMessage;
      }
    }
    public void publishToSmartDashboard() {
      try {
        lastMessage = getSerialPortBuffer();
        SmartDashboard.putString("ArduinoData", lastMessage);
   } catch (Exception e){
     System.out.println(e);
   }
 }
}