package io.flutter.plugin.common;

import androidx.annotation.Nullable;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class MethodCall {
    public final Object arguments;
    public final String method;

    public MethodCall(String str, Object obj) {
        this.method = str;
        this.arguments = obj;
    }

    @Nullable
    public <T> T argument(String str) {
        Object obj = this.arguments;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Map) {
            return (T) ((Map) obj).get(str);
        }
        if (obj instanceof JSONObject) {
            return (T) ((JSONObject) obj).opt(str);
        }
        throw new ClassCastException();
    }

    public <T> T arguments() {
        return (T) this.arguments;
    }

    public boolean hasArgument(String str) {
        Object obj = this.arguments;
        if (obj == null) {
            return false;
        }
        if (obj instanceof Map) {
            return ((Map) obj).containsKey(str);
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).has(str);
        }
        throw new ClassCastException();
    }
}
