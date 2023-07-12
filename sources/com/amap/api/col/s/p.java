package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class p extends b<InputtipsQuery, ArrayList<Tip>> {
    public p(Context context, InputtipsQuery inputtipsQuery) {
        super(context, inputtipsQuery);
    }

    private static ArrayList<Tip> c(String str) throws AMapException {
        try {
            return q.h(new JSONObject(str));
        } catch (JSONException e) {
            i.a(e, "InputtipsHandler", "paseJSON");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String b = b.b(((InputtipsQuery) ((a) this).b).getKeyword());
        if (!TextUtils.isEmpty(b)) {
            stringBuffer.append("&keywords=");
            stringBuffer.append(b);
        }
        String city = ((InputtipsQuery) ((a) this).b).getCity();
        if (!q.g(city)) {
            String b2 = b.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b2);
        }
        String type = ((InputtipsQuery) ((a) this).b).getType();
        if (!q.g(type)) {
            String b3 = b.b(type);
            stringBuffer.append("&type=");
            stringBuffer.append(b3);
        }
        if (((InputtipsQuery) ((a) this).b).getCityLimit()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        LatLonPoint location = ((InputtipsQuery) ((a) this).b).getLocation();
        if (location != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(location.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(location.getLatitude());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(bk.f(((a) this).e));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.a() + "/assistant/inputtips?";
    }
}
