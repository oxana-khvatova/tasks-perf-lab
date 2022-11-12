import com.google.gson.Gson;

import java.io.Reader;
import java.io.Writer;
import java.util.List;

class Tests {
    private List<Test> tests;

    public List<Test> getTests() {
        return tests;
    }

    static Tests parse(Reader s) {
        Gson gson = new Gson();
        return gson.fromJson(s, Tests.class);
    }

    public void serialize(Writer w) {
        Gson gson = new Gson();
        gson.toJson(this, w);
    }
}