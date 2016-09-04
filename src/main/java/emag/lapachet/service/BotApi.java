package emag.lapachet.service;

import com.google.gson.Gson;
import emag.lapachet.entity.NotifyWrapper;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by viorel.gheba on 9/4/16.
 */
public class BotApi {

    private static String BOT_API_URL;
    private static String BOT_API_TOKEN;
    private static final String NOTIFY_API = "/notify";

    public static final MediaType JSON;

    private transient final Gson GSON;
    private transient final OkHttpClient HTTP_CLIENT;

    static {
        BOT_API_URL = System.getenv("BOT_API_URL");
        BOT_API_TOKEN = System.getenv("BOT_API_TOKEN");
        JSON = MediaType.parse("application/json; charset=utf-8");
    }

    {
        HTTP_CLIENT = new OkHttpClient();
        GSON = new Gson();
    }

    public Response notifyUsers(List<String> userIds) throws IOException {
        RequestBody body = RequestBody.create(JSON, GSON.toJson(new NotifyWrapper(userIds)));
        Request request = new Request.Builder()
                .url(BOT_API_URL + NOTIFY_API + "?access_token=" + BOT_API_TOKEN)
                .header("Content-Type", "application/json; charset=UTF-8")
                .post(body)
                .build();

        okhttp3.Response response = HTTP_CLIENT.newCall(request).execute();
        final int code = response.code();

        Response returnValue = null;
        if (code == 200) {
            System.out.println(response.body().string());
            returnValue = GSON.fromJson(response.body().string(), Response.class);
        } else {
            System.out.println("ERROR: " + response.body().string());
            throw new IOException("ERROR: " + response.body().string());
        }

        response.body().close();

        return returnValue;
    }
}
