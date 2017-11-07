import java.awt.*;

public class Car {
    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public boolean turboOn;
    public double turboAmount;
    public static double trimFactor;

    public Car (){
        stopEngine();
    }
//--------------------- INC/DEC Speed ------------------------
    public void incrementSpeed(double amount){
    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
}
    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - this.speedFactor() * amount,0);
    }

//---------------------- Start/Stop-engine ---------------------
    public void startEngine(){
        currentSpeed = 0.1;
    }
    public void stopEngine(){
        currentSpeed = 0;
    }

//---------------------- SpeedFactor ---------------------------------

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = turboAmount;
        return enginePower * 0.01 * turbo * trimFactor;
    }

//-------------------------- Turbo ------------------------------------
    public void setTurboOn(){
        turboOn = getTurbo(); //Sets turbo on if car have turbo.
    }
    public void setTurboOff(){
        turboOn = false;
    }

//-------------------------- Peddals --------------------------------
    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(amount);
    }
    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(amount);
    }

    //-------------Getters-----------------------------
    public int getNrDoors(){
        return nrDoors;
    }
    public Color getColor(){
        return color;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public boolean getTurbo(){
        return turboAmount > 1;
    }

    //-------------Setters-----------------------------
    public void setColor(Color clr){
        color = clr;
    }

}
