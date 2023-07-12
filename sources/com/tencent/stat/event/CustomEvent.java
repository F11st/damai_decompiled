package com.tencent.stat.event;

import android.content.Context;
import com.meizu.cloud.pushsdk.notification.model.NotificationStyle;
import java.util.Arrays;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CustomEvent extends Event {
    private long duration;
    protected Key key;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Key {
        String[] args;
        String id;
        Properties prop = null;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Key) {
                Key key = (Key) obj;
                boolean z = this.id.equals(key.id) && Arrays.equals(this.args, key.args);
                Properties properties = this.prop;
                return properties != null ? z && properties.equals(key.prop) : z && key.prop == null;
            }
            return false;
        }

        public int hashCode() {
            String str = this.id;
            int hashCode = str != null ? str.hashCode() : 0;
            String[] strArr = this.args;
            if (strArr != null) {
                hashCode ^= Arrays.hashCode(strArr);
            }
            Properties properties = this.prop;
            return properties != null ? hashCode ^ properties.hashCode() : hashCode;
        }

        public String toString() {
            String str;
            String str2 = this.id;
            String[] strArr = this.args;
            if (strArr != null) {
                String str3 = strArr[0];
                for (int i = 1; i < this.args.length; i++) {
                    str3 = str3 + "," + this.args[i];
                }
                str = jn1.ARRAY_START_STR + str3 + jn1.ARRAY_END_STR;
            } else {
                str = "";
            }
            if (this.prop != null) {
                str = str + this.prop.toString();
            }
            return str2 + str;
        }
    }

    public CustomEvent(Context context, int i, String str) {
        super(context, i);
        Key key = new Key();
        this.key = key;
        this.duration = -1L;
        key.id = str;
    }

    public Key getKey() {
        return this.key;
    }

    @Override // com.tencent.stat.event.Event
    public EventType getType() {
        return EventType.CUSTOM;
    }

    @Override // com.tencent.stat.event.Event
    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        jSONObject.put(NotificationStyle.EXPANDABLE_IMAGE_URL, this.key.id);
        long j = this.duration;
        if (j > 0) {
            jSONObject.put("du", j);
        }
        if (this.key.args != null) {
            JSONArray jSONArray = new JSONArray();
            for (String str : this.key.args) {
                jSONArray.put(str);
            }
            jSONObject.put("ar", jSONArray);
        }
        if (this.key.prop != null) {
            jSONObject.put("kv", new JSONObject(this.key.prop));
            return true;
        }
        return true;
    }

    public void setArgs(String[] strArr) {
        this.key.args = strArr;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setProperties(Properties properties) {
        this.key.prop = properties;
    }
}
