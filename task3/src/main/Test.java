import java.util.List;

class Test {
    private Integer id;
    private String title;
    private String value;

    public List<Test> getValues() {
        return values;
    }

    private List<Test> values;

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}