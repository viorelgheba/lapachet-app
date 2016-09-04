package emag.lapachet.service;

import emag.lapachet.entity.SaveUser;
import emag.lapachet.modelInterface.UserInterface;
import emag.lapachet.util.Db;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

/**
 * Created by viorel.gheba on 9/4/16.
 */
public class SqlUser implements UserInterface {
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
}
