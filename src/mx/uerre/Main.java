package mx.uerre;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static final int LAST_DAYS = 7;
    private static final String FILE_EXT = ".json";
    private static final String FOLDER_PATH = "C:\\Users\\a.martinez.navarro\\Downloads\\servicio\\";

    public static void main(String[] args) {
        Main main = new Main();
        main.generateFiles();
    }

    public void generateFiles() {
        StringBuilder jsonFile;
        String fileName;

        for (Category category : Category.values()) {
            for(Location location : Location.values()) {
                fileName = getFileName(category, location);

                jsonFile = new StringBuilder();

                jsonFile.append("{ \"_id\":");
                jsonFile.append("\"");
                jsonFile.append(fileName);
                jsonFile.append("\", ");

                jsonFile.append("\"startUrl\": \"https://www.occ.com.mx/empleos-en-");
                jsonFile.append(category.getUrl());
                jsonFile.append("/en-");
                jsonFile.append(location.getUrl());
                jsonFile.append("?tm=");
                jsonFile.append(LAST_DAYS);
                jsonFile.append("\", ");

                jsonFile.append(getRestOfFile());

                writeFile(fileName, jsonFile.toString());
            }
        }
    }

    private void writeFile(String fileName, String jsonFile) {
        File jsonFileOutput;
        FileWriter fileWriter;

        try {
            jsonFileOutput = new File(FOLDER_PATH + fileName + FILE_EXT);

            fileWriter = new FileWriter(jsonFileOutput);
            fileWriter.write(jsonFile);
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error has occurred when writing the file: " + fileName + FILE_EXT);
            e.printStackTrace();
        }
    }

    private String getFileName(Category category, Location location) {
        StringBuilder fileName = new StringBuilder();

        fileName.append("occ-");
        fileName.append(location.getUrl());
        fileName.append("-");
        fileName.append(LAST_DAYS);
        fileName.append("dias-");
        fileName.append(category.getUrl());

        return fileName.toString();
    }

    private String getRestOfFile() {
        StringBuilder restOfFile = new StringBuilder();

        restOfFile.append("\"selectors\": [ ");
        restOfFile.append("{ ");
        restOfFile.append("\"parentSelectors\":[\"_root\",\"pagination\"], ");
        restOfFile.append("\"type\":\"SelectorLink\", ");
        restOfFile.append("\"multiple\":true, ");
        restOfFile.append("\"id\":\"nombre_vacante\", ");
        restOfFile.append("\"selector\":\"h2.title_modn_sr a.linkoffer\", ");
        restOfFile.append("\"delay\":\"\" ");
        restOfFile.append("}, { ");
        restOfFile.append("\"parentSelectors\":[\"nombre_vacante\"], ");
        restOfFile.append("\"type\":\"SelectorText\", ");
        restOfFile.append("\"multiple\":false, ");
        restOfFile.append("\"id\":\"empresa\", ");
        restOfFile.append("\"selector\":\"h3 span\", ");
        restOfFile.append("\"regex\":\"\", ");
        restOfFile.append("\"delay\":\"\" ");
        restOfFile.append("}, { ");
        restOfFile.append("\"parentSelectors\":[\"nombre_vacante\"], ");
        restOfFile.append("\"type\":\"SelectorText\", ");
        restOfFile.append("\"multiple\":false, ");
        restOfFile.append("\"id\":\"sueldo\", ");
        restOfFile.append("\"selector\":\"dd:nth-of-type(1)\", ");
        restOfFile.append("\"regex\":\"\", ");
        restOfFile.append("\"delay\":\"\" ");
        restOfFile.append("}, { ");
        restOfFile.append("\"parentSelectors\":[\"nombre_vacante\"], ");
        restOfFile.append("\"type\":\"SelectorText\", ");
        restOfFile.append("\"multiple\":false, ");
        restOfFile.append("\"id\":\"categoria\", ");
        restOfFile.append("\"selector\":\"dd:nth-of-type(2) span\", ");
        restOfFile.append("\"regex\":\"\", ");
        restOfFile.append("\"delay\":\"\" ");
        restOfFile.append("}, { ");
        restOfFile.append("\"parentSelectors\":[\"nombre_vacante\"], ");
        restOfFile.append("\"type\":\"SelectorText\", ");
        restOfFile.append("\"multiple\":false, ");
        restOfFile.append("\"id\":\"subcategoria\", ");
        restOfFile.append("\"selector\":\"dd:nth-of-type(3)\", ");
        restOfFile.append("\"regex\":\"\", ");
        restOfFile.append("\"delay\":\"\" ");
        restOfFile.append("}, { ");
        restOfFile.append("\"parentSelectors\":[\"nombre_vacante\"], ");
        restOfFile.append("\"type\":\"SelectorText\", ");
        restOfFile.append("\"multiple\":false, ");
        restOfFile.append("\"id\":\"localidad\", ");
        restOfFile.append("\"selector\":\"dd span span\", ");
        restOfFile.append("\"regex\":\"\", ");
        restOfFile.append("\"delay\":\"\" ");
        restOfFile.append("}, { ");
        restOfFile.append("\"parentSelectors\":[\"nombre_vacante\"], ");
        restOfFile.append("\"type\":\"SelectorText\", ");
        restOfFile.append("\"multiple\":false, ");
        restOfFile.append("\"id\":\"sector\", ");
        restOfFile.append("\"selector\":\"dd:nth-of-type(5)\", ");
        restOfFile.append("\"regex\":\"\", ");
        restOfFile.append("\"delay\":\"\" ");
        restOfFile.append("}, { ");
        restOfFile.append("\"parentSelectors\":[\"nombre_vacante\"], ");
        restOfFile.append("\"type\":\"SelectorText\", ");
        restOfFile.append("\"multiple\":false, ");
        restOfFile.append("\"id\":\"giro\", ");
        restOfFile.append("\"selector\":\"dd:nth-of-type(6)\", ");
        restOfFile.append("\"regex\":\"\", ");
        restOfFile.append("\"delay\":\"\" ");
        restOfFile.append("}, { ");
        restOfFile.append("\"parentSelectors\":[\"nombre_vacante\"], ");
        restOfFile.append("\"type\":\"SelectorText\", ");
        restOfFile.append("\"multiple\":false, ");
        restOfFile.append("\"id\":\"tipo_contratacion\", ");
        restOfFile.append("\"selector\":\"dd:nth-of-type(7) span\", ");
        restOfFile.append("\"regex\":\"\", ");
        restOfFile.append("\"delay\":\"\" ");
        restOfFile.append("}, { ");
        restOfFile.append("\"parentSelectors\":[\"nombre_vacante\"], ");
        restOfFile.append("\"type\":\"SelectorText\", ");
        restOfFile.append("\"multiple\":false, ");
        restOfFile.append("\"id\":\"numero_oferta\", ");
        restOfFile.append("\"selector\":\"dd:nth-of-type(8)\", ");
        restOfFile.append("\"regex\":\"\", ");
        restOfFile.append("\"delay\":\"\" ");
        restOfFile.append("}, { ");
        restOfFile.append("\"parentSelectors\":[\"nombre_vacante\"], ");
        restOfFile.append("\"type\":\"SelectorText\", ");
        restOfFile.append("\"multiple\":false, ");
        restOfFile.append("\"id\":\"descripcion\", ");
        restOfFile.append("\"selector\":\"div.txt2_jo\", ");
        restOfFile.append("\"regex\":\"\", ");
        restOfFile.append("\"delay\":\"\" ");
        restOfFile.append("}, { ");
        restOfFile.append("\"parentSelectors\":[\"_root\",\"pagination\"], ");
        restOfFile.append("\"type\":\"SelectorLink\", ");
        restOfFile.append("\"multiple\":true, ");
        restOfFile.append("\"id\":\"pagination\", ");
        restOfFile.append("\"selector\":\"div.num-foot a\", ");
        restOfFile.append("\"delay\":\"2000\" ");
        restOfFile.append("} ] }");

        return restOfFile.toString();
    }

}
