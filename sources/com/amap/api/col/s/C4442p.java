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
/* renamed from: com.amap.api.col.s.p */
/* loaded from: classes10.dex */
public final class C4442p extends AbstractC4379b<InputtipsQuery, ArrayList<Tip>> {
    public C4442p(Context context, InputtipsQuery inputtipsQuery) {
        super(context, inputtipsQuery);
    }

    private static ArrayList<Tip> c(String str) throws AMapException {
        try {
            return C4443q.h(new JSONObject(str));
        } catch (JSONException e) {
            C4435i.a(e, "InputtipsHandler", "paseJSON");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    protected final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String b = AbstractC4379b.b(((InputtipsQuery) ((AbstractC4370a) this).b).getKeyword());
        if (!TextUtils.isEmpty(b)) {
            stringBuffer.append("&keywords=");
            stringBuffer.append(b);
        }
        String city = ((InputtipsQuery) ((AbstractC4370a) this).b).getCity();
        if (!C4443q.g(city)) {
            String b2 = AbstractC4379b.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b2);
        }
        String type = ((InputtipsQuery) ((AbstractC4370a) this).b).getType();
        if (!C4443q.g(type)) {
            String b3 = AbstractC4379b.b(type);
            stringBuffer.append("&type=");
            stringBuffer.append(b3);
        }
        if (((InputtipsQuery) ((AbstractC4370a) this).b).getCityLimit()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        LatLonPoint location = ((InputtipsQuery) ((AbstractC4370a) this).b).getLocation();
        if (location != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(location.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(location.getLatitude());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(bk.f(((AbstractC4370a) this).e));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return C4434h.a() + "/assistant/inputtips?";
    }
}
