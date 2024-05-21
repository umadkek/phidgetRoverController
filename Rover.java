package rover;
import com.phidget22.*;
public class Rover {
    
    static DCMotor rightMotors;
    static DCMotor leftMotors;
    
    public static void main(String[] args) throws Exception {
        //Connect to wireless rover
        Net.addServer("", "192.168.100.1", 5661, "", 0);

        //Create
        leftMotors = new DCMotor();
        rightMotors = new DCMotor();

        //Address
        leftMotors.setChannel(0);
        rightMotors.setChannel(1);

        //Open
        leftMotors.open(5000);
        rightMotors.open(5000);
        
        new MyFrame();
    }       
    
    public static void moveForward() throws Exception {
        leftMotors.setTargetVelocity(1);
        rightMotors.setTargetVelocity(1);
    }
    
    public static void moveBackward() throws Exception {
        leftMotors.setTargetVelocity(-1);
        rightMotors.setTargetVelocity(-1);
    }
    
    public static void moveLeft() throws Exception {
        leftMotors.setTargetVelocity(1);
        rightMotors.setTargetVelocity(-1);
    }
    
    public static void moveRight() throws Exception {
        leftMotors.setTargetVelocity(-1);
        rightMotors.setTargetVelocity(1);
    }
    
    public static void stopMoving() throws Exception {
        leftMotors.setTargetVelocity(0);
        rightMotors.setTargetVelocity(0);
    }
    
    public static void setAcceleration(int speed) throws Exception {
        leftMotors.setAcceleration(speed);
        rightMotors.setAcceleration(speed);
    }
}
