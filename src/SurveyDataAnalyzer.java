import java.util.Map;

public class SurveyDataAnalyzer {
  private final CustomHashTable responses;

  public SurveyDataAnalyzer(CustomHashTable responses) {
    this.responses = responses;
  }
  
  

  public int[] genderDistribution() {
    int[] distribution = new int[4];
    // Use a map to correspond the gender and the input integer
    Map<String, Integer> genderMap = Map.of("F", 0, "M", 1, "O", 2, "-", 3);

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null && entry.getValue() != null && entry.getValue().getGender() != null) {
        String gender = entry.getValue().getGender();
        distribution[genderMap.getOrDefault(gender, 3)]++; // Default: "-", or int 3
      }
    }

    return distribution;
  }

  public int[] ageGroupDistribution() {
    int[] distribution = new int[4];

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null
          && entry.getValue() != null
          && entry.getValue().getAge() > 0
          && entry.getValue().getAge() <= 4) {
        int age = entry.getValue().getAge();
        distribution[age - 1]++; // Corresponds the answer to the index of the array
      }
    }

    return distribution;
  }

  public int[] residenceDistribution() {
    int[] distribution = new int[4];

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null
          && entry.getValue() != null
          && entry.getValue().getResidence() > 0
          && entry.getValue().getResidence() <= 4) {
        int residence = entry.getValue().getResidence();
        distribution[residence - 1]++;
      }
    }

    return distribution;
  }

  public int[] educationDistribution() {
    int[] distribution = new int[4];

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null
          && entry.getValue() != null
          && entry.getValue().getEducation() > 0
          && entry.getValue().getEducation() <= 4) {
        int education = entry.getValue().getEducation();
        distribution[education - 1]++;
      }
    }

    return distribution;
  }

  public int[] incomeDistribution() {
    int[] distribution = new int[4];

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null
          && entry.getValue() != null
          && entry.getValue().getIncomeSource() > 0
          && entry.getValue().getIncomeSource() <= 4) {
        int incomeSource = entry.getValue().getIncomeSource();
        distribution[incomeSource - 1]++;
      }
    }

    return distribution;
  }

  public int[] maritalDistribution() {
    int[] distribution = new int[4];

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null
          && entry.getValue() != null
          && entry.getValue().getMartialStatus() > 0
          && entry.getValue().getMartialStatus() <= 4) {
        int martialStatus = entry.getValue().getMartialStatus();
        distribution[martialStatus - 1]++;
      }
    }

    return distribution;
  }

  public int[] smokerDistribution() {
    int[] distribution = new int[2];

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null
          && entry.getValue() != null
          && entry.getValue().getSmoker() >= 0
          && entry.getValue().getSmoker() <= 1) {
        distribution[entry.getValue().getSmoker()]++;
      }
    }

    return distribution;
  }

  public double lifeQualityGeneral() {
    double totalQuality = 0;
    int count = 0;

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null && entry.getValue() != null) {
        totalQuality += entry.getValue().getQuality();
        count++;
      }
    }

    return count > 0 ? totalQuality / count : 0; // Calculate average quality
  }

  public double[] lifeQualityGenderBased() {
    double[] totalQuality = {0, 0, 0, 0};
    int[] counts = {0, 0, 0, 0};

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null && entry.getValue() != null && entry.getValue().getGender() != null) {
        String gender = entry.getValue().getGender();
        int index = 3; // If there is any specific gender, index will be updated
        switch (gender) {
          case "F":
            index = 0;
            break;
          case "M":
            index = 1;
            break;
          case "O":
            index = 2;
            break;
          default:
            break;
        }
        totalQuality[index] += entry.getValue().getQuality();
        counts[index]++;
      }
    }

    double[] averageQuality = new double[totalQuality.length];
    for (int i = 0; i < averageQuality.length; i++) {
      averageQuality[i] = counts[i] > 0 ? totalQuality[i] / counts[i] : 0;
    }

    return averageQuality;
  }

  public double[] lifeQualityAgeBased() {
    double[] totalQuality = {0, 0, 0, 0};
    int[] counts = {0, 0, 0, 0};

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null
          && entry.getValue() != null
          && entry.getValue().getAge() > 0
          && entry.getValue().getAge() <= 4) {
        int age = entry.getValue().getAge();
        double quality = entry.getValue().getQuality();
        totalQuality[age - 1] += quality; // Corresponds the quality to the index of the array
        counts[age - 1]++;
      }
    }

    double[] averageQuality = new double[totalQuality.length];
    for (int i = 0; i < averageQuality.length; i++) {
      averageQuality[i] = counts[i] > 0 ? totalQuality[i] / counts[i] : 0;
    }

    return averageQuality;
  }

  public double[] lifeQualityResidenceBased() {
    double[] totalQuality = {0, 0, 0, 0};
    int[] counts = {0, 0, 0, 0};

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null
          && entry.getValue() != null
          && entry.getValue().getResidence() > 0
          && entry.getValue().getResidence() <= 4) {
        int residence = entry.getValue().getResidence();
        double quality = entry.getValue().getQuality();
        totalQuality[residence - 1] += quality;
        counts[residence - 1]++;
      }
    }

    double[] averageQuality = new double[totalQuality.length];
    for (int i = 0; i < averageQuality.length; i++) {
      averageQuality[i] = counts[i] > 0 ? totalQuality[i] / counts[i] : 0;
    }

    return averageQuality;
  }

  public double[] lifeQualityEducationBased() {
    double[] totalQuality = {0, 0, 0, 0};
    int[] counts = {0, 0, 0, 0};

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null
          && entry.getValue() != null
          && entry.getValue().getEducation() > 0
          && entry.getValue().getEducation() <= 4) {
        int education = entry.getValue().getEducation();
        double quality = entry.getValue().getQuality();
        totalQuality[education - 1] += quality;
        counts[education - 1]++;
      }
    }

    double[] averageQuality = new double[totalQuality.length];
    for (int i = 0; i < averageQuality.length; i++) {
      averageQuality[i] = counts[i] > 0 ? totalQuality[i] / counts[i] : 0;
    }

    return averageQuality;
  }

  public double[] lifeQualityIncomeBased() {
    double[] totalQuality = {0, 0, 0, 0};
    int[] counts = {0, 0, 0, 0};

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null
          && entry.getValue() != null
          && entry.getValue().getIncomeSource() > 0
          && entry.getValue().getIncomeSource() <= 4) {
        int incomeSource = entry.getValue().getIncomeSource();
        double quality = entry.getValue().getQuality();
        totalQuality[incomeSource - 1] += quality;
        counts[incomeSource - 1]++;
      }
    }

    double[] averageQuality = new double[totalQuality.length];
    for (int i = 0; i < averageQuality.length; i++) {
      averageQuality[i] = counts[i] > 0 ? totalQuality[i] / counts[i] : 0;
    }

    return averageQuality;
  }

  public double[] lifeQualityMaritalBased() {
    double[] totalQuality = {0, 0, 0, 0};
    int[] counts = {0, 0, 0, 0};

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null
          && entry.getValue() != null
          && entry.getValue().getMartialStatus() > 0
          && entry.getValue().getMartialStatus() <= 4) {
        int martialStatus = entry.getValue().getMartialStatus();
        double quality = entry.getValue().getQuality();
        totalQuality[martialStatus - 1] += quality;
        counts[martialStatus - 1]++;
      }
    }

    double[] averageQuality = new double[totalQuality.length];
    for (int i = 0; i < averageQuality.length; i++) {
      averageQuality[i] = counts[i] > 0 ? totalQuality[i] / counts[i] : 0;
    }

    return averageQuality;
  }

  public double[] lifeQualitySmokerBased() {
    double[] totalQuality = {0, 0};
    int[] counts = {0, 0};

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null
          && entry.getValue() != null
          && entry.getValue().getSmoker() >= 0
          && entry.getValue().getSmoker() <= 1) {
        // the index will be 1 if the answer is 0, and will be 0 if the answer is 1
        int smokerIndex = 1 - entry.getValue().getSmoker();
        double quality = entry.getValue().getQuality();
        totalQuality[smokerIndex] += quality;
        counts[smokerIndex]++;
      }
    }

    double[] averages = new double[totalQuality.length];
    for (int i = 0; i < averages.length; i++) {
      averages[i] = counts[i] > 0 ? totalQuality[i] / counts[i] : 0;
    }

    return averages;
  }

  public String[] mostCommonTreatment() {
    int[] count = new int[5];
    String[] treatmentArray = {
      "Surgical", "Chemotherapy", "Radiotherapy", "Immunotherapy", "MolecularlyTargetedTherapy"
    };

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null && entry.getValue() != null && entry.getValue().getQ9() != null) {
        String[] answers = entry.getValue().getQ9().split(";");
        for (String answer : answers) {
          switch (answer) {
            case "Surgical" -> count[0]++;
            case "Chemotherapy" -> count[1]++;
            case "Radiotherapy" -> count[2]++;
            case "Immunotherapy" -> count[3]++;
            case "MolecularlyTargetedTherapy" -> count[4]++;
          }
        }
      }
    }

    // Use insertion sort to sort the count array and correspond the string
    for (int i = 0; i < count.length; i++) {
      int currentCount = count[i];
      String currentTreatment = treatmentArray[i];
      int j = i - 1;
      while (j >= 0 && count[j] < currentCount) {
        count[j + 1] = count[j];
        treatmentArray[j + 1] = treatmentArray[j];
        j--;
      }
      count[j + 1] = currentCount;
      treatmentArray[j + 1] = currentTreatment;
    }

    return treatmentArray;
  }

  public String[] mostCommonSymptoms() {
    int[] count = new int[7];
    String[] symptomArray = {
      "Cough", "Hoarseness", "CoughingUpBlood", "ChestPain", "ShortnessOfBreath", "Weakness", "None"
    };

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null && entry.getValue() != null && entry.getValue().getQ16() != null) {
        String[] answers = entry.getValue().getQ16().split(";");
        for (String answer : answers) {
          switch (answer) {
            case "Cough" -> count[0]++;
            case "Hoarseness" -> count[1]++;
            case "CoughingUpBlood" -> count[2]++;
            case "ChestPain" -> count[3]++;
            case "ShortnessOfBreath" -> count[4]++;
            case "Weakness" -> count[5]++;
            case "None" -> count[6]++;
          }
        }
      }
    }

    for (int i = 0; i < count.length; i++) {
      int currentCount = count[i];
      String currentTreatment = symptomArray[i];
      int j = i - 1;
      while (j >= 0 && count[j] < currentCount) {
        count[j + 1] = count[j];
        symptomArray[j + 1] = symptomArray[j];
        j--;
      }
      count[j + 1] = currentCount;
      symptomArray[j + 1] = currentTreatment;
    }

    return symptomArray;
  }

  public String[] mostCommonLifeAspects() {
    int[] count = new int[6];
    String[] aspectArray = {
      "PhysicalAspect",
      "PsychologicalAspect",
      "ProfessionalLife",
      "FamilyLife",
      "SocialLife",
      "DoesNotAffect"
    };

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null && entry.getValue() != null && entry.getValue().getQ23() != null) {
        String[] answers = entry.getValue().getQ23().split(";");
        for (String answer : answers) {
          switch (answer) {
            case "PhysicalAspect" -> count[0]++;
            case "PsychologicalAspect" -> count[1]++;
            case "ProfessionalLife" -> count[2]++;
            case "FamilyLife" -> count[3]++;
            case "SocialLife" -> count[4]++;
            case "DoesNotAffect" -> count[5]++;
          }
        }
      }
    }

    for (int i = 0; i < count.length; i++) {
      int currentCount = count[i];
      String currentTreatment = aspectArray[i];
      int j = i - 1;
      while (j >= 0 && count[j] < currentCount) {
        count[j + 1] = count[j];
        aspectArray[j + 1] = aspectArray[j];
        j--;
      }
      count[j + 1] = currentCount;
      aspectArray[j + 1] = currentTreatment;
    }

    return aspectArray;
  }

  public double[] lifeQualityMixConditionsBased() {
    int[] totalQuality = {0, 0};
    double[] count = {0.0, 0.0};

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null && entry.getValue() != null) {
        int martialStatus = entry.getValue().getMartialStatus();
        int residence = entry.getValue().getResidence();

        if (martialStatus == 1 && residence == 4) {
          totalQuality[0] += entry.getValue().getQuality();
          count[0]++;
        } else if (martialStatus == 2 && (residence == 1 || residence == 2)) {
          totalQuality[1] += entry.getValue().getQuality();
          count[1]++;
        }
      }
    }

    double[] averageQuality = new double[2];
    for (int i = 0; i < 2; i++) {
      averageQuality[i] = count[i] > 0 ? totalQuality[i] / count[i] : 0;
    }

    return averageQuality;
  }

  public double[] lifeQualityResponseBased() {
    int[] totalQuality = new int[4];
    double[] count = {0.0, 0.0, 0.0, 0.0};

    for (CustomHashTable.Entry entry : this.responses.getTable()) {
      if (entry != null && entry.getValue() != null) {
        int q15Index = entry.getValue().getQ15() - 1;
        if (q15Index >= 0 && q15Index < 4) {
          totalQuality[q15Index] += entry.getValue().getQuality();
          count[q15Index]++;
        }
      }
    }

    double[] averageQuality = new double[4];
    for (int i = 0; i < 4; i++) {
      averageQuality[i] = count[i] > 0 ? totalQuality[i] / count[i] : 0;
    }

    return averageQuality;
  }
}
