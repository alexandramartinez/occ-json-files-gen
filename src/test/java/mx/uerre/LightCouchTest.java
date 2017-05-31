package mx.uerre;

import com.google.gson.JsonObject;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;

import static org.junit.Assert.assertNotNull;

public class LightCouchTest {
    private static final String DATABASE = "occ-scraper-sitemaps";
    private static final int PORT = 5984;

    private FilesGenerator filesGenerator = new FilesGenerator();
    private Map<String, String> filesMap = filesGenerator.getFilesMap();

    private static CouchDbClient client;

    @BeforeClass
    public static void createCouchClient() {
        CouchDbProperties properties = new CouchDbProperties()
            .setDbName(DATABASE)
            .setCreateDbIfNotExist(true)
            .setProtocol("http")
            .setHost("localhost")
            .setPort(PORT)
            .setMaxConnections(100)
            .setConnectionTimeout(0);

        client = new CouchDbClient(properties);
    }

    @AfterClass
    public static void closeCouchClient() {
        client.shutdown();
    }

    @Test
    public void findAllDocuments() {
        String dbURI = client.getDBUri().toString();
        String uri = dbURI + "_all_docs";

        JsonObject json = client.findAny(JsonObject.class, uri);

        assertNotNull(json);
    }

    @Test
    public void createAllOccDocuments() {
        JsonObject jsonObject;

        for(Map.Entry<String, String> entry : filesMap.entrySet()) {
            jsonObject = client.getGson().fromJson(entry.getValue(), JsonObject.class);
            client.save(jsonObject);
            System.out.println(entry.getKey() + " was saved.");
        }

    }

    @Test
    public void deleteAllDocuments() {
        client.context().deleteDB(DATABASE, "delete database");
        client.context().createDB(DATABASE);
    }
}
