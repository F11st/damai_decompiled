package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.common.Env;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SessionEnv extends Event {
    private JSONObject cfgJson;
    private Env env;

    public SessionEnv(Context context, int i, JSONObject jSONObject) {
        super(context, i);
        this.cfgJson = null;
        this.env = new Env(context);
        this.cfgJson = jSONObject;
    }

    @Override // com.tencent.stat.event.Event
    public EventType getType() {
        return EventType.SESSION_ENV;
    }

    @Override // com.tencent.stat.event.Event
    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        jSONObject.put("ut", this.user.getType());
        JSONObject jSONObject2 = this.cfgJson;
        if (jSONObject2 != null) {
            jSONObject.put("cfg", jSONObject2);
        }
        this.env.encode(jSONObject);
        return true;
    }
}
