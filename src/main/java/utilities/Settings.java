package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Settings {
    public static String getSetting(String key, String... params) {
        String result = readPropertiesFile("Setting.properties", key, params);
        return "";
    }

    private static String readPropertiesFile(String filename, String key, String... params) {
        //System.out.print("key: " + key);
        String result = "", finalResult = "";

        try {
            InputStream is = new FileInputStream((new Helper()).getClass().getClassLoader().getResource(filename).getFile());
            ResourceBundle resources = new PropertyResourceBundle(is);
            result = resources.getString(key);
            System.out.print("value: " + result);

            if (result.contains("{") && params.length > 0) {
                int count = 0;
                Pattern p = Pattern.compile("\\{.*?\\}");
                Matcher m = p.matcher(result);

                while (m.find()) {
                    finalResult = result.replace(m.group(), params[count].toString());
                    count++;
                    result = finalResult;
                }

            }else {
                finalResult = result;
            }

            System.out.print("value after: " + finalResult);

        } catch (FileNotFoundException e) {
            System.out.print("EXCEPTION FileNotFoundException: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.print("EXCEPTION IOException: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.print("EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.print(finalResult);
        return finalResult;
    }
}
