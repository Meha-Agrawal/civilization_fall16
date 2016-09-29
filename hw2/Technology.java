public class Technology {
    private int understanding = 0;
    private boolean foundMeaningOfLife = false;
    private int experienceLevel = 0;
    private boolean builtWonderOfTheWorld = false;

    public int getUnderstanding() {
        return understanding;
    }
    public int getBuildExperience() {
        return experienceLevel;
    }

    public void philosophize() {
        understanding += 25;
        if (understanding > 200) {
            foundMeaningOfLife = true;
        }
    }
    public void improveWriting() {
        understanding += 10;
        if (understanding > 200) {
            foundMeaningOfLife = true;
        }
    }

    public void increaseExperience(int increase) {
        experienceLevel += increase;
        if (experienceLevel > 200) {
            builtWonderOfTheWorld = true;
        }
    }

    public boolean hasTechnologyWin() {
        return foundMeaningOfLife || builtWonderOfTheWorld;
    }
}
