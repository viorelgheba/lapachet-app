package emag.lapachet.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class Db {
    private static MongoClient mongoClient;
    private static MongoDatabase mongoDatabase;

    private static MongoClient getMongoClient() {
        if (mongoClient == null) {
            mongoClient = new MongoClient(new MongoClientURI(System.getenv("MONGODB_URI")));
        }

        return mongoClient;
    }

    public static MongoDatabase getMongoDatabase() {
        if (mongoDatabase == null) {
            mongoDatabase = getMongoClient().getDatabase(System.getenv("MONGODB_DBNAME"));
        }

        return mongoDatabase;
    }
}
