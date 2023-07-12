package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class al extends AbstractC4370a<String, String> {
    private String k;

    public al(Context context, String str) {
        super(context, str);
        this.k = str;
    }

    private static String b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String a = C4443q.a(jSONObject, "code");
            String a2 = C4443q.a(jSONObject, "message");
            if ("1".equals(a)) {
                return C4443q.a(jSONObject, "transfer_url");
            }
            if (!"0".equals(a)) {
                if (!"2".equals(a)) {
                    if (!"3".equals(a)) {
                        if (!"4".equals(a)) {
                            if ("5".equals(a)) {
                                throw new AMapException(AMapException.AMAP_SHARE_LICENSE_IS_EXPIRED, 0, a2);
                            }
                            return null;
                        }
                        throw new AMapException("用户签名未通过", 0, a2);
                    }
                    throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 0, a2);
                }
                throw new AMapException(AMapException.AMAP_SHARE_FAILURE, 0, a2);
            }
            throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 0, a2);
        } catch (JSONException e) {
            C4435i.a(e, "ShareUrlSearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.AbstractC4370a
    protected final /* synthetic */ String a(String str) throws AMapException {
        return b(str);
    }

    @Override // com.amap.api.col.s.AbstractC4370a
    protected final String a_() {
        return null;
    }

    @Override // com.amap.api.col.s.AbstractC4370a, com.amap.api.col.s.df
    public final Map<String, String> e() {
        byte[] bArr;
        StringBuilder sb = new StringBuilder();
        sb.append("channel=open_api&flag=1");
        sb.append("&address=" + URLEncoder.encode(this.k));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("open_api1");
        stringBuffer.append(this.k);
        stringBuffer.append("@8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
        String a = bs.a(stringBuffer.toString());
        sb.append("&sign=");
        sb.append(a.toUpperCase(Locale.US));
        sb.append("&output=json");
        try {
            bArr = au.a(sb.toString().getBytes("utf-8"), "Yaynpa84IKOfasFx".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            C4435i.a(e, "ShareUrlSearchHandler", "getParams");
            bArr = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ent", "2");
        hashMap.put("in", bp.b(bArr));
        hashMap.put("keyt", "openapi");
        return hashMap;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return C4434h.f();
    }
}
