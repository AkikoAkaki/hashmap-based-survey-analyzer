import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
  public static CustomHashTable readResponsesFromFile(String filePath) {
    CustomHashTable hashTable = new CustomHashTable();
    try (BufferedReader reader = new BufferedReader(new FileReader("src/" + filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] values = line.split("\t");
        int id = Integer.parseInt(values[0]);
        String gender = assignGender(Integer.parseInt(values[1]));
        int age = Integer.parseInt(values[2]);
        int residence = Integer.parseInt(values[3]);
        int education = Integer.parseInt(values[4]);
        int incomeSource = Integer.parseInt(values[5]);
        int martialStatus = Integer.parseInt(values[6]);
        int smoker = Integer.parseInt(values[7]);
        int year = Integer.parseInt(values[8]);
        String q9 = values[9];
        int q10 = Integer.parseInt(values[10]);
        int q11 = Integer.parseInt(values[11]);
        int q12 = Integer.parseInt(values[12]);
        int q13 = Integer.parseInt(values[13]);
        int q14 = Integer.parseInt(values[14]);
        int q15 = Integer.parseInt(values[15]);
        String q16 = values[16];
        int q17 = Integer.parseInt(values[17]);
        int q18 = Integer.parseInt(values[18]);
        int q19 = Integer.parseInt(values[19]);
        int q20 = Integer.parseInt(values[20]);
        int q21 = Integer.parseInt(values[21]);
        int q22 = Integer.parseInt(values[22]);
        String q23 = values[23];
        int q24 = Integer.parseInt(values[24]);
        int q25 = Integer.parseInt(values[25]);
        int q26 = Integer.parseInt(values[26]);
        int q27 = Integer.parseInt(values[27]);
        int q28 = Integer.parseInt(values[28]);
        int q29 = Integer.parseInt(values[29]);
        int q30 = Integer.parseInt(values[30]);

        Response response =
            new Response(
                id,
                gender,
                age,
                residence,
                education,
                incomeSource,
                martialStatus,
                smoker,
                year,
                q9,
                q10,
                q11,
                q12,
                q13,
                q14,
                q15,
                q16,
                q17,
                q18,
                q19,
                q20,
                q21,
                q22,
                q23,
                q24,
                q25,
                q26,
                q27,
                q28,
                q29,
                q30);

        hashTable.insert(id, response);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return hashTable;
  }

  public static String assignGender(int genderCode) {
    return switch (genderCode) {
      case 1 -> "F";
      case 2 -> "M";
      case 3 -> "O";
      default -> "-";
    };
  }
}
