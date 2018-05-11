package com.liser.common.util;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class XmlUtils {

    public static String json2xml(String json) {
        if (json.startsWith("[")) {
            JSONArray array = new JSONArray(json);
            return XML.toString(array);
        } else {
            JSONObject o = new JSONObject(json);
            return XML.toString(o);
        }
    }
}
