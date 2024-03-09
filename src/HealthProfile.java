import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Class HealthProfile with basic functionality of a health profile.

 * @see HealthProfileTest
 */

public class HealthProfile {
    private String name;
    private String lastName;
    private String gender;
    private LocalDate birthDate;
    private int height;
    private int weight;

    public HealthProfile(String name, String lastName, String gender, LocalDate birthDate, int height, int weight) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static int ageInYears(LocalDate birthDate){
        int age=0;
        age= (int) ChronoUnit.YEARS.between(birthDate, LocalDate.now());
        return age;
    }

    public static int maxHeartRate(int age){
        int maxHeartRate=0;
        maxHeartRate=220-age;
        return maxHeartRate;
    }

    public static int minTargetHeartRate(int maxHeartRate){
        int minTargetHeartRate=0;
        minTargetHeartRate=(int) (maxHeartRate*0.5);
        return minTargetHeartRate;
    }

    public static int maxTargetHeartRate(int maxHeartRate){
        int maxTargetHeartRate=0;
        maxTargetHeartRate=(int) (maxHeartRate*0.85);
        return maxTargetHeartRate;
    }

    public static double BMI(int weight, int height){
        double bmi=0;
        bmi=(weight)*1.0/(height*height/10000.0);
        bmi=Math.round(bmi*100.0)/100.0;
        return bmi;
    }

}
