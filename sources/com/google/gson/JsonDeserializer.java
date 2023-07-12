package com.google.gson;

import java.lang.reflect.Type;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface JsonDeserializer<T> {
    T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException;
}
