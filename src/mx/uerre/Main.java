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

                jsonFile.append("{\n");
                jsonFile.append("\t\"_id\":");
                jsonFile.append("\"");
                jsonFile.append(fileName);
                jsonFile.append("\",\n");

                jsonFile.append("\t\"startUrl\": \"https://www.occ.com.mx/empleos-en-");
                jsonFile.append(category.getUrl());
                jsonFile.append("/en-");
                jsonFile.append(location.getUrl());
                jsonFile.append("?tm=");
                jsonFile.append(LAST_DAYS);
                jsonFile.append("\",\n");

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

        restOfFile.append("\t\"selectors\":\n");
        restOfFile.append("\t[\n");
        restOfFile.append("\t\t{\n");
        restOfFile.append("\t\t\t\"parentSelectors\":[\"_root\",\"pagination\"],\n");
        restOfFile.append("\t\t\t\"type\":\"SelectorLink\",\n");
        restOfFile.append("\t\t\t\"multiple\":true,\n");
        restOfFile.append("\t\t\t\"id\":\"nombre_vacante\",\n");
        restOfFile.append("\t\t\t\"selector\":\"h2.title_modn_sr a.linkoffer\",\n");
        restOfFile.append("\t\t\t\"delay\":\"\"\n");
        restOfFile.append("\t\t},\n\t\t{\n");
        restOfFile.append("\t\t\t\"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("\t\t\t\"type\":\"SelectorText\",\n");
        restOfFile.append("\t\t\t\"multiple\":false,\n");
        restOfFile.append("\t\t\t\"id\":\"empresa\",\n");
        restOfFile.append("\t\t\t\"selector\":\"h3 span\",\n");
        restOfFile.append("\t\t\t\"regex\":\"\",\n");
        restOfFile.append("\t\t\t\"delay\":\"\"\n");
        restOfFile.append("\t\t},\n\t\t{\n");
        restOfFile.append("\t\t\t\"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("\t\t\t\"type\":\"SelectorText\",\n");
        restOfFile.append("\t\t\t\"multiple\":false,\n");
        restOfFile.append("\t\t\t\"id\":\"sueldo\",\n");
        restOfFile.append("\t\t\t\"selector\":\"dd:nth-of-type(1)\",\n");
        restOfFile.append("\t\t\t\"regex\":\"\",\n");
        restOfFile.append("\t\t\t\"delay\":\"\"\n");
        restOfFile.append("\t\t},\n\t\t{\n");
        restOfFile.append("\t\t\t\"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("\t\t\t\"type\":\"SelectorText\",\n");
        restOfFile.append("\t\t\t\"multiple\":false,\n");
        restOfFile.append("\t\t\t\"id\":\"categoria\",\n");
        restOfFile.append("\t\t\t\"selector\":\"dd:nth-of-type(2) span\",\n");
        restOfFile.append("\t\t\t\"regex\":\"\",\n");
        restOfFile.append("\t\t\t\"delay\":\"\"\n");
        restOfFile.append("\t\t},\n\t\t{\n");
        restOfFile.append("\t\t\t\"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("\t\t\t\"type\":\"SelectorText\",\n");
        restOfFile.append("\t\t\t\"multiple\":false,\n");
        restOfFile.append("\t\t\t\"id\":\"subcategoria\",\n");
        restOfFile.append("\t\t\t\"selector\":\"dd:nth-of-type(3)\",\n");
        restOfFile.append("\t\t\t\"regex\":\"\",\n");
        restOfFile.append("\t\t\t\"delay\":\"\"\n");
        restOfFile.append("\t\t},\n\t\t{\n");
        restOfFile.append("\t\t\t\"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("\t\t\t\"type\":\"SelectorText\",\n");
        restOfFile.append("\t\t\t\"multiple\":false,\n");
        restOfFile.append("\t\t\t\"id\":\"localidad\",\n");
        restOfFile.append("\t\t\t\"selector\":\"dd span span\",\n");
        restOfFile.append("\t\t\t\"regex\":\"\",\n");
        restOfFile.append("\t\t\t\"delay\":\"\"\n");
        restOfFile.append("\t\t},\n\t\t{\n");
        restOfFile.append("\t\t\t\"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("\t\t\t\"type\":\"SelectorText\",\n");
        restOfFile.append("\t\t\t\"multiple\":false,\n");
        restOfFile.append("\t\t\t\"id\":\"sector\",\n");
        restOfFile.append("\t\t\t\"selector\":\"dd:nth-of-type(5)\",\n");
        restOfFile.append("\t\t\t\"regex\":\"\",\n");
        restOfFile.append("\t\t\t\"delay\":\"\"\n");
        restOfFile.append("\t\t},\n\t\t{\n");
        restOfFile.append("\t\t\t\"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("\t\t\t\"type\":\"SelectorText\",\n");
        restOfFile.append("\t\t\t\"multiple\":false,\n");
        restOfFile.append("\t\t\t\"id\":\"giro\",\n");
        restOfFile.append("\t\t\t\"selector\":\"dd:nth-of-type(6)\",\n");
        restOfFile.append("\t\t\t\"regex\":\"\",\n");
        restOfFile.append("\t\t\t\"delay\":\"\"\n");
        restOfFile.append("\t\t},\n\t\t{\n");
        restOfFile.append("\t\t\t\"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("\t\t\t\"type\":\"SelectorText\",\n");
        restOfFile.append("\t\t\t\"multiple\":false,\n");
        restOfFile.append("\t\t\t\"id\":\"tipo_contratacion\",\n");
        restOfFile.append("\t\t\t\"selector\":\"dd:nth-of-type(7) span\",\n");
        restOfFile.append("\t\t\t\"regex\":\"\",\n");
        restOfFile.append("\t\t\t\"delay\":\"\"\n");
        restOfFile.append("\t\t},\n\t\t{\n");
        restOfFile.append("\t\t\t\"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("\t\t\t\"type\":\"SelectorText\",\n");
        restOfFile.append("\t\t\t\"multiple\":false,\n");
        restOfFile.append("\t\t\t\"id\":\"numero_oferta\",\n");
        restOfFile.append("\t\t\t\"selector\":\"dd:nth-of-type(8)\",\n");
        restOfFile.append("\t\t\t\"regex\":\"\",\n");
        restOfFile.append("\t\t\t\"delay\":\"\"\n");
        restOfFile.append("\t\t},\n\t\t{\n");
        restOfFile.append("\t\t\t\"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("\t\t\t\"type\":\"SelectorText\",\n");
        restOfFile.append("\t\t\t\"multiple\":false,\n");
        restOfFile.append("\t\t\t\"id\":\"descripcion\",\n");
        restOfFile.append("\t\t\t\"selector\":\"div.txt2_jo\",\n");
        restOfFile.append("\t\t\t\"regex\":\"\",\n");
        restOfFile.append("\t\t\t\"delay\":\"\"\n");
        restOfFile.append("\t\t},\n\t\t{\n");
        restOfFile.append("\t\t\t\"parentSelectors\":[\"_root\",\"pagination\"],\n");
        restOfFile.append("\t\t\t\"type\":\"SelectorLink\",\n");
        restOfFile.append("\t\t\t\"multiple\":true,\n");
        restOfFile.append("\t\t\t\"id\":\"pagination\",\n");
        restOfFile.append("\t\t\t\"selector\":\"div.num-foot a\",\n");
        restOfFile.append("\t\t\t\"delay\":\"2000\"\n");
        restOfFile.append("\t\t}\n\t]\n}");

        return restOfFile.toString();
    }

}
