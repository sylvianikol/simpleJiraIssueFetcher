package fetcher.util;

import fetcher.common.Attribute;
import org.json.JSONArray;
import org.json.JSONObject;

import static fetcher.common.Constants.EMPTY;

public class IssueFieldExtractor {

    public static String getFieldName(JSONObject jsonObject, Attribute name) {

        return exists(jsonObject, name.label)
                ? jsonObject.getString(name.label).trim()
                : EMPTY;
    }

    public static String getFieldValue(JSONObject jsonObject, Attribute name, Attribute value) {

        return exists(jsonObject, name.label)
                ? jsonObject.getJSONObject(name.label).getString(value.label)
                : EMPTY;
    }

    public static JSONObject getJsonObject(JSONObject jsonObject, Attribute field) {
        return jsonObject.getJSONObject(field.label);
    }

    public static JSONArray getJsonArray(JSONObject jsonObject, Attribute field, Attribute value) {
        return jsonObject.getJSONObject(field.label)
                .getJSONArray(value.label);
    }

    private static boolean exists(JSONObject jsonObject, String field) {
        try {
            jsonObject.get(field);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
