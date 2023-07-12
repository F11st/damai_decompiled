package com.tencent.stat.event;

import android.content.Context;
import com.ali.user.open.core.Site;
import com.tencent.stat.StatConfig;
import com.tencent.stat.common.StatCommonHelper;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AdditionEvent extends Event {
    Map<String, ?> map;

    public AdditionEvent(Context context, int i, Map<String, ?> map) {
        super(context, i);
        this.map = null;
        this.map = map;
    }

    @Override // com.tencent.stat.event.Event
    public EventType getType() {
        return EventType.ADDITION;
    }

    @Override // com.tencent.stat.event.Event
    public boolean onEncode(JSONObject jSONObject) throws JSONException {
        StatCommonHelper.jsonPut(jSONObject, Site.QQ, StatConfig.getQQ());
        Map<String, ?> map = this.map;
        if (map == null || map.size() <= 0) {
            return true;
        }
        for (Map.Entry<String, ?> entry : this.map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        return true;
    }
}
