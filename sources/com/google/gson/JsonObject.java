package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class JsonObject extends JsonElement {
    private final LinkedTreeMap<String, JsonElement> members = new LinkedTreeMap<>();

    private JsonElement createJsonElement(Object obj) {
        return obj == null ? JsonNull.INSTANCE : new JsonPrimitive(obj);
    }

    public void add(String str, JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        this.members.put(str, jsonElement);
    }

    public void addProperty(String str, String str2) {
        add(str, createJsonElement(str2));
    }

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonObject) && ((JsonObject) obj).members.equals(this.members));
    }

    public JsonElement get(String str) {
        return this.members.get(str);
    }

    public JsonArray getAsJsonArray(String str) {
        return (JsonArray) this.members.get(str);
    }

    public JsonObject getAsJsonObject(String str) {
        return (JsonObject) this.members.get(str);
    }

    public JsonPrimitive getAsJsonPrimitive(String str) {
        return (JsonPrimitive) this.members.get(str);
    }

    public boolean has(String str) {
        return this.members.containsKey(str);
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public JsonElement remove(String str) {
        return this.members.remove(str);
    }

    public int size() {
        return this.members.size();
    }

    public void addProperty(String str, Number number) {
        add(str, createJsonElement(number));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.gson.JsonElement
    public JsonObject deepCopy() {
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, JsonElement> entry : this.members.entrySet()) {
            jsonObject.add(entry.getKey(), entry.getValue().deepCopy());
        }
        return jsonObject;
    }

    public void addProperty(String str, Boolean bool) {
        add(str, createJsonElement(bool));
    }

    public void addProperty(String str, Character ch) {
        add(str, createJsonElement(ch));
    }
}
