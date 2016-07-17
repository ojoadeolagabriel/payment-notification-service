package data;

/**
 * Created by Adeola.Ojo on 7/17/2016.
 */
public class AutogateProcessor {

    private int id;
    private int bankId;
    private String description;
    private int speed;
    private boolean isStp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isStp() {
        return isStp;
    }

    public void setStp(boolean stp) {
        isStp = stp;
    }
}
