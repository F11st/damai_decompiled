package com.tencent.stat.event;

import android.content.Context;
import android.util.Log;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatStore;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.User;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class Event {
    protected String appkey;
    protected Context ctx;
    protected int sessionId;
    protected long timestamp = System.currentTimeMillis() / 1000;
    protected User user;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Event(Context context, int i) {
        this.user = null;
        this.ctx = context;
        this.appkey = StatConfig.getAppKey(context);
        this.sessionId = i;
        this.user = StatStore.getInstance(context).getUser(context);
    }

    public boolean encode(JSONObject jSONObject) {
        try {
            StatCommonHelper.jsonPut(jSONObject, "ky", this.appkey);
            jSONObject.put("et", getType().GetIntValue());
            jSONObject.put("ui", this.user.getUid());
            StatCommonHelper.jsonPut(jSONObject, "mc", this.user.getMac());
            jSONObject.put("si", this.sessionId);
            jSONObject.put("ts", this.timestamp);
            return onEncode(jSONObject);
        } catch (JSONException e) {
            Log.e("Event", "Failed to encode", e);
            return false;
        }
    }

    public Context getContext() {
        return this.ctx;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public abstract EventType getType();

    public abstract boolean onEncode(JSONObject jSONObject) throws JSONException;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        encode(jSONObject);
        return jSONObject.toString();
    }
}
