package webapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Adeola.Ojo on 7/23/2016.
 */
public class BankHealth {

    @JsonProperty("BankHealthInformation")
    public List<BankInformation> bankHealthInformation;

    public List<BankInformation> getBankHealthInformation() {
        return bankHealthInformation;
    }

    public void setBankHealthInformation(List<BankInformation> bankHealthInformation) {
        this.bankHealthInformation = bankHealthInformation;
    }

    public static class BankInformation {

        private String bankDescription;
        private boolean isPaused;

        public String getBankDescription() {
            return bankDescription;
        }

        public void setBankDescription(String bankDescription) {
            this.bankDescription = bankDescription;
        }

        public boolean isPaused() {
            return isPaused;
        }

        public void setPaused(boolean paused) {
            isPaused = paused;
        }

        public String getExtimatedResumption() {
            return extimatedResumption;
        }

        public void setExtimatedResumption(String extimatedResumption) {
            this.extimatedResumption = extimatedResumption;
        }

        public String getLastEventDescription() {
            return LastEventDescription;
        }

        public void setLastEventDescription(String lastEventDescription) {
            LastEventDescription = lastEventDescription;
        }

        public boolean isProcessorEnabled() {
            return isProcessorEnabled;
        }

        public void setProcessorEnabled(boolean processorEnabled) {
            isProcessorEnabled = processorEnabled;
        }

        private String extimatedResumption;
        private String LastEventDescription;
        private boolean isProcessorEnabled;
    }

}
