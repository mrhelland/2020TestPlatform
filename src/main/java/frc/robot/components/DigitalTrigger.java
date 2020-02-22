package frc.robot.components;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class DigitalTrigger extends Trigger {

    private DigitalInput source;
    private boolean triggerValue;

    public DigitalTrigger(DigitalInput source, boolean desiredtriggervalue) {
        this.source = source;
        this.triggerValue = desiredtriggervalue;
    }

    @Override
    public boolean get() {
        return (source.get() == triggerValue);
    }

    /* Inherited methods
    public void cancelWhenActive(Command command);
    public void toggleWhenActive​(Command command);
    public void whenActive​(Command command);
    public void whenInactive​(Command command);
    public void whileActive​(Command command);
    */


}