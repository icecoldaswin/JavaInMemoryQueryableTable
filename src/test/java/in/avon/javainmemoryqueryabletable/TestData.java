package in.avon.javainmemoryqueryabletable;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestData {
    private static final String DATA_AS_JSON = "[\n" +
            "  {\n" +
            "    \"name\": \"Raja Raja Chola I\",\n" +
            "    \"age\": 59,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Padmini\",\n" +
            "    \"age\": 37,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Maharana Pratap\",\n" +
            "    \"age\": 56,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Shivaji Maharaj\",\n" +
            "    \"age\": 50,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Lakshmibai\",\n" +
            "    \"age\": 29,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Krishnadevaraya\",\n" +
            "    \"age\": 66,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Jodha Bai\",\n" +
            "    \"age\": 42,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Tipu Sultan\",\n" +
            "    \"age\": 48,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Mangammal\",\n" +
            "    \"age\": 60,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Chhatrapati Sambhaji\",\n" +
            "    \"age\": 31,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Meera Bai\",\n" +
            "    \"age\": 49,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Akbar\",\n" +
            "    \"age\": 63,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Durgavati\",\n" +
            "    \"age\": 40,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Krishna Deva Raya\",\n" +
            "    \"age\": 65,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Karnavati\",\n" +
            "    \"age\": 38,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Shah Jahan\",\n" +
            "    \"age\": 74,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Shahaji\",\n" +
            "    \"age\": 68,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Tarabai\",\n" +
            "    \"age\": 52,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Harsha\",\n" +
            "    \"age\": 43,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Rudrama Devi\",\n" +
            "    \"age\": 45,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Guru Gobind Singh\",\n" +
            "    \"age\": 42,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Padmavati\",\n" +
            "    \"age\": 33,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Shivaji II\",\n" +
            "    \"age\": 36,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Ahilyabai Holkar\",\n" +
            "    \"age\": 70,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Chand Bibi\",\n" +
            "    \"age\": 46,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Velu Nachiyar\",\n" +
            "    \"age\": 55,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Samudragupta\",\n" +
            "    \"age\": 58,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Rashmoni\",\n" +
            "    \"age\": 67,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Raja Todar Mal\",\n" +
            "    \"age\": 63,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Chennamma\",\n" +
            "    \"age\": 44,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rana Kumbha\",\n" +
            "    \"age\": 60,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Avantibai\",\n" +
            "    \"age\": 41,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Durgawati\",\n" +
            "    \"age\": 50,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Raja Bhoja\",\n" +
            "    \"age\": 55,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Karnavati\",\n" +
            "    \"age\": 48,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Krishna Deva Raya\",\n" +
            "    \"age\": 64,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Mangammal\",\n" +
            "    \"age\": 58,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Chhatrapati Sambhaji\",\n" +
            "    \"age\": 39,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Padmini\",\n" +
            "    \"age\": 36,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Raja Raja Chola I\",\n" +
            "    \"age\": 62,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Rani Lakshmibai\",\n" +
            "    \"age\": 31,\n" +
            "    \"gender\": \"F\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"name\": \"Maharana Pratap\",\n" +
            "    \"age\": 53,\n" +
            "    \"gender\": \"M\"\n" +
            "  },\n" +
            "]\n" ;
    public static Set<Map<String, Object>> get() {
        Gson g = new Gson();
        JsonArray array = g.fromJson(DATA_AS_JSON, JsonArray.class);
        Set<Map<String, Object>> set = new HashSet<>();
        array.forEach(e -> set.add(g.fromJson(e, Map.class)));

        return set;
    }
}
