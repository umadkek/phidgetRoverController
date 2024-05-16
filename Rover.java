package rover;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import com.phidget22.*;
public class Rover {
    public static void main(String[] args) throws Exception {
        //Connect to wireless rover
        Net.addServer("", "192.168.100.1", 5661, "", 0);

        //Create
        DCMotor leftMotors = new DCMotor();
        DCMotor rightMotors = new DCMotor();

        //Address
        leftMotors.setChannel(0);
        rightMotors.setChannel(1);

        //Open
        leftMotors.open(5000);
        rightMotors.open(5000);

        //Increase acceleration
        leftMotors.setAcceleration(leftMotors.getMaxAcceleration());
        rightMotors.setAcceleration(rightMotors.getMaxAcceleration());

        new MyFrame();
        
    }       
    
    public static void moveForward() {
        
    }
    
    public static void moveBackward() {
        
    }
    
    public static void moveLeft() {
        
    }
    
    public static void moveRight() {
        System.out.println("test");
    }
}
