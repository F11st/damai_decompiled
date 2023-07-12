package com.xiaomi.clientreport.data;

import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class EventClientReport extends C7537a {
    public String eventContent;
    public String eventId;
    public long eventTime;
    public int eventType;

    public static EventClientReport getBlankInstance() {
        return new EventClientReport();
    }

    @Override // com.xiaomi.clientreport.data.C7537a
    public JSONObject toJson() {
        try {
            JSONObject json = super.toJson();
            if (json == null) {
                return null;
            }
            json.put("eventId", this.eventId);
            json.put("eventType", this.eventType);
            json.put("eventTime", this.eventTime);
            String str = this.eventContent;
            if (str == null) {
                str = "";
            }
            json.put("eventContent", str);
            return json;
        } catch (JSONException e) {
            AbstractC7535b.a(e);
            return null;
        }
    }

    @Override // com.xiaomi.clientreport.data.C7537a
    public String toJsonString() {
        return super.toJsonString();
    }
}