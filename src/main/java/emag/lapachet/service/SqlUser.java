package emag.lapachet.service;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import emag.lapachet.entity.SaveUser;
import emag.lapachet.modelInterface.UserInterface;
import emag.lapachet.util.Db;
import org.bson.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * Created by viorel.gheba on 9/4/16.
 */
public class SqlUser implements UserInterface {

    private BotApi botApi;

    public SqlUser() {
        botApi = new BotApi();
    }

    @Override
    public Object addUser(SaveUser saveUser) {
        Document user = Db.getMongoDatabase().getCollection("user").find(eq("userId", saveUser.userId)).first();

        if (user == null) {
            user = new Document();
            user.append("userId", saveUser.userId);
            Db.getMongoDatabase().getCollection("user").insertOne(user);
        }

        return user.get("_id");
    }

    public void notifyAllUsers() {
        List<String> userIds = new ArrayList<>();

        FindIterable<Document> iterable = Db.getMongoDatabase().getCollection("user").find();
        iterable.forEach(new Block<Document>() {
            @Override
            public void apply(final Document doc) {
                userIds.add(doc.getString("userId"));
            }
        });

        try {
            botApi.notifyUsers(userIds);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
