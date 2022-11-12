import java.io.Reader;
import java.util.List;

import com.google.gson.Gson;

public class Values {
    private List<Value> values;

    public List<Value> getValues() {
        return values;
    }

    static Values parse(Reader s) {
        Gson gson = new Gson();
        return gson.fromJson(s, Values.class);
    }
}
