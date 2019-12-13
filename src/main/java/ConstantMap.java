import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConstantMap {


    public void doLab(){
        ////////////////////////////Const MAP////////////////////////////////////////////
        final Map<String, String> map = new HashMap<String, String>(){{
            put("Key_1", "Value_1");
            put("Key_2", "Value_2");
            put("Key_3", "Value_1");
        }};

        map.put("d","d");

        final Map constMap = Collections.unmodifiableMap(map);

        try {
            constMap.put("d", "d");
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

}
