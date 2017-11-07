import java.awt.*;

public class Car {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected boolean turboOn;
    protected double turboAmount;
    protected static double trimFactor;

    public abstract Car (){
        nrDoors = 0;
        color = Color.black;
        enginePower = 100;
        modelName = "Car";
        turboOn = false;
        turboAmount = 1.0;
        trimFactor = 1.0;
        stopEngine();
    }
//--------------------- INC/DEC Speed ------------------------
    private void incrementSpeed(double amount){
    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
}
    private void decrementSpeed(double amount){
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
    private double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = turboAmount;
        return enginePower * 0.01 * turbo * trimFactor;
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

    //-------------------------Setters-----------------------------
    public void setColor(Color clr){
        color = clr;
    }
    //-------------------------- Turbo ------------------------------------
    public void setTurboOn(){
        turboOn = getTurbo(); //Sets turbo on if car have turbo.
    }
    public void setTurboOff(){
        turboOn = false;
    }


}
