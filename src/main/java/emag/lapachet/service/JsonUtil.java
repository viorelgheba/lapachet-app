package emag.lapachet.service;

import com.google.gson.Gson;
import spark.ResponseTransformer;

import java.util.Objects;

public class JsonUtil {
    private static String toJson(Object object) {
        return new Gson().toJson(object);
    }

    public static ResponseTransformer json() {
        return JsonUtil::toJson;
    }
}
