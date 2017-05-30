package mx.uerre;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FilesGenerator {

    private static final int LAST_DAYS = 7;
    private static final String FILE_EXT = ".json";
    private static final String FOLDER_PATH = "C:\\Users\\a.martinez.navarro\\Downloads\\servicio\\";

    private Map<String, String> filesMap = new HashMap<String, String>();

    public static void main(String[] args) {
        FilesGenerator main = new FilesGenerator();
        main.exportFiles();
    }

    public Map<String, String> getFilesMap() {
        generateFiles();

        return filesMap;
    }

    public void exportFiles() {
        generateFiles();

        for(Map.Entry<String, String> entry : filesMap.entrySet()) {
            writeFile(entry.getKey(), entry.getValue());
        }
    }

    private void generateFiles() {
        StringBuilder jsonFile;
        String fileName;
        filesMap.clear();

        for (Category category : Category.values()) {
            for(Location location : Location.values()) {
                fileName = getFileName(category, location);

                jsonFile = new StringBuilder();

                jsonFile.append("{\n");
                jsonFile.append(" \"_id\":");
                jsonFile.append("\"");
                jsonFile.append(fileName);
                jsonFile.append("\",\n");

                jsonFile.append(" \"startUrl\": \"https://www.occ.com.mx/empleos-en-");
                jsonFile.append(category.getUrl());
                jsonFile.append("/en-");
                jsonFile.append(location.getUrl());
                jsonFile.append("?tm=");
                jsonFile.append(LAST_DAYS);
                jsonFile.append("\",\n");

                jsonFile.append(getRestOfFile());

                filesMap.put(fileName, jsonFile.toString());
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

        restOfFile.append(" \"selectors\":\n");
        restOfFile.append(" [\n");
        restOfFile.append("  {\n");
        restOfFile.append("   \"parentSelectors\":[\"_root\",\"pagination\"],\n");
        restOfFile.append("   \"type\":\"SelectorLink\",\n");
        restOfFile.append("   \"multiple\":true,\n");
        restOfFile.append("   \"id\":\"nombre_vacante\",\n");
        restOfFile.append("   \"selector\":\"h2.title_modn_sr a.linkoffer\",\n");
        restOfFile.append("   \"delay\":\"\"\n");
        restOfFile.append("  },\n  {\n");
        restOfFile.append("   \"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("   \"type\":\"SelectorText\",\n");
        restOfFile.append("   \"multiple\":false,\n");
        restOfFile.append("   \"id\":\"empresa\",\n");
        restOfFile.append("   \"selector\":\"h3 span\",\n");
        restOfFile.append("   \"regex\":\"\",\n");
        restOfFile.append("   \"delay\":\"\"\n");
        restOfFile.append("  },\n  {\n");
        restOfFile.append("   \"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("   \"type\":\"SelectorText\",\n");
        restOfFile.append("   \"multiple\":false,\n");
        restOfFile.append("   \"id\":\"sueldo\",\n");
        restOfFile.append("   \"selector\":\"dd:nth-of-type(1)\",\n");
        restOfFile.append("   \"regex\":\"\",\n");
        restOfFile.append("   \"delay\":\"\"\n");
        restOfFile.append("  },\n  {\n");
        restOfFile.append("   \"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("   \"type\":\"SelectorText\",\n");
        restOfFile.append("   \"multiple\":false,\n");
        restOfFile.append("   \"id\":\"categoria\",\n");
        restOfFile.append("   \"selector\":\"dd:nth-of-type(2) span\",\n");
        restOfFile.append("   \"regex\":\"\",\n");
        restOfFile.append("   \"delay\":\"\"\n");
        restOfFile.append("  },\n  {\n");
        restOfFile.append("   \"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("   \"type\":\"SelectorText\",\n");
        restOfFile.append("   \"multiple\":false,\n");
        restOfFile.append("   \"id\":\"subcategoria\",\n");
        restOfFile.append("   \"selector\":\"dd:nth-of-type(3)\",\n");
        restOfFile.append("   \"regex\":\"\",\n");
        restOfFile.append("   \"delay\":\"\"\n");
        restOfFile.append("  },\n  {\n");
        restOfFile.append("   \"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("   \"type\":\"SelectorText\",\n");
        restOfFile.append("   \"multiple\":false,\n");
        restOfFile.append("   \"id\":\"localidad\",\n");
        restOfFile.append("   \"selector\":\"dd span span\",\n");
        restOfFile.append("   \"regex\":\"\",\n");
        restOfFile.append("   \"delay\":\"\"\n");
        restOfFile.append("  },\n  {\n");
        restOfFile.append("   \"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("   \"type\":\"SelectorText\",\n");
        restOfFile.append("   \"multiple\":false,\n");
        restOfFile.append("   \"id\":\"sector\",\n");
        restOfFile.append("   \"selector\":\"dd:nth-of-type(5)\",\n");
        restOfFile.append("   \"regex\":\"\",\n");
        restOfFile.append("   \"delay\":\"\"\n");
        restOfFile.append("  },\n  {\n");
        restOfFile.append("   \"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("   \"type\":\"SelectorText\",\n");
        restOfFile.append("   \"multiple\":false,\n");
        restOfFile.append("   \"id\":\"giro\",\n");
        restOfFile.append("   \"selector\":\"dd:nth-of-type(6)\",\n");
        restOfFile.append("   \"regex\":\"\",\n");
        restOfFile.append("   \"delay\":\"\"\n");
        restOfFile.append("  },\n  {\n");
        restOfFile.append("   \"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("   \"type\":\"SelectorText\",\n");
        restOfFile.append("   \"multiple\":false,\n");
        restOfFile.append("   \"id\":\"tipo_contratacion\",\n");
        restOfFile.append("   \"selector\":\"dd:nth-of-type(7) span\",\n");
        restOfFile.append("   \"regex\":\"\",\n");
        restOfFile.append("   \"delay\":\"\"\n");
        restOfFile.append("  },\n  {\n");
        restOfFile.append("   \"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("   \"type\":\"SelectorText\",\n");
        restOfFile.append("   \"multiple\":false,\n");
        restOfFile.append("   \"id\":\"numero_oferta\",\n");
        restOfFile.append("   \"selector\":\"dd:nth-of-type(8)\",\n");
        restOfFile.append("   \"regex\":\"\",\n");
        restOfFile.append("   \"delay\":\"\"\n");
        restOfFile.append("  },\n  {\n");
        restOfFile.append("   \"parentSelectors\":[\"nombre_vacante\"],\n");
        restOfFile.append("   \"type\":\"SelectorText\",\n");
        restOfFile.append("   \"multiple\":false,\n");
        restOfFile.append("   \"id\":\"descripcion\",\n");
        restOfFile.append("   \"selector\":\"div.txt2_jo\",\n");
        restOfFile.append("   \"regex\":\"\",\n");
        restOfFile.append("   \"delay\":\"\"\n");
        restOfFile.append("  },\n  {\n");
        restOfFile.append("   \"parentSelectors\":[\"_root\",\"pagination\"],\n");
        restOfFile.append("   \"type\":\"SelectorLink\",\n");
        restOfFile.append("   \"multiple\":true,\n");
        restOfFile.append("   \"id\":\"pagination\",\n");
        restOfFile.append("   \"selector\":\"div.num-foot a\",\n");
        restOfFile.append("   \"delay\":\"2000\"\n");
        restOfFile.append("  }\n ]\n}");

        return restOfFile.toString();
    }

}
