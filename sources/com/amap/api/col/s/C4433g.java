package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.alient.onearch.adapter.pom.OneArchConstants;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.taobao.weex.common.Constants;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.g */
/* loaded from: classes10.dex */
public final class C4433g extends AbstractC4429e<CloudSearch.Query, CloudResult> {
    private int k;

    public C4433g(Context context, CloudSearch.Query query) {
        super(context, query);
        this.k = 0;
    }

    private static String b(Map<String, String> map) {
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
            }
            return sb.toString();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    /* renamed from: c */
    public CloudResult a(String str) throws AMapException {
        ArrayList<CloudItem> arrayList = null;
        if (str != null && !str.equals("")) {
            try {
                arrayList = d(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            T t = ((AbstractC4370a) this).b;
            return CloudResult.createPagedResult((CloudSearch.Query) t, this.k, ((CloudSearch.Query) t).getBound(), ((CloudSearch.Query) ((AbstractC4370a) this).b).getPageSize(), arrayList);
        }
        T t2 = ((AbstractC4370a) this).b;
        return CloudResult.createPagedResult((CloudSearch.Query) t2, this.k, ((CloudSearch.Query) t2).getBound(), ((CloudSearch.Query) ((AbstractC4370a) this).b).getPageSize(), null);
    }

    private ArrayList<CloudItem> d(JSONObject jSONObject) throws JSONException {
        ArrayList<CloudItem> arrayList = new ArrayList<>();
        JSONArray a = AbstractC4429e.a(jSONObject);
        if (a == null) {
            return arrayList;
        }
        this.k = AbstractC4429e.b(jSONObject);
        for (int i = 0; i < a.length(); i++) {
            JSONObject optJSONObject = a.optJSONObject(i);
            CloudItemDetail c = AbstractC4429e.c(optJSONObject);
            AbstractC4429e.a(c, optJSONObject);
            arrayList.add(c);
        }
        return arrayList;
    }

    private static String f(String str) {
        return str != null ? str.replace("%26%26", jn1.AND) : str;
    }

    private static String g(String str) {
        try {
        } catch (Throwable th) {
            ci.a(th, "ut", "sPa");
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str = e(str);
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(str2);
            stringBuffer.append("&");
        }
        String f = f(stringBuffer.toString());
        if (f.length() > 1) {
            return (String) f.subSequence(0, f.length() - 1);
        }
        return str;
    }

    private String j() {
        return ((CloudSearch.Query) ((AbstractC4370a) this).b).getSortingrules() != null ? ((CloudSearch.Query) ((AbstractC4370a) this).b).getSortingrules().toString() : "";
    }

    private String z() {
        StringBuffer stringBuffer = new StringBuffer();
        String filterString = ((CloudSearch.Query) ((AbstractC4370a) this).b).getFilterString();
        String filterNumString = ((CloudSearch.Query) ((AbstractC4370a) this).b).getFilterNumString();
        stringBuffer.append(filterString);
        if (!C4435i.a(filterString) && !C4435i.a(filterNumString)) {
            stringBuffer.append(jn1.AND);
        }
        stringBuffer.append(filterNumString);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    protected final String a_() {
        return null;
    }

    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a, com.amap.api.col.s.df
    public final Map<String, String> e() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", bk.f(((AbstractC4370a) this).e));
        hashtable.put("output", Preloader.KEY_JSON);
        if (((CloudSearch.Query) ((AbstractC4370a) this).b).getBound() != null) {
            if (((CloudSearch.Query) ((AbstractC4370a) this).b).getBound().getShape().equals("Bound")) {
                double a = C4435i.a(((CloudSearch.Query) ((AbstractC4370a) this).b).getBound().getCenter().getLongitude());
                double a2 = C4435i.a(((CloudSearch.Query) ((AbstractC4370a) this).b).getBound().getCenter().getLatitude());
                hashtable.put("center", a + "," + a2);
                StringBuilder sb = new StringBuilder();
                sb.append(((CloudSearch.Query) ((AbstractC4370a) this).b).getBound().getRange());
                hashtable.put(BQCCameraParam.FOCUS_AREA_RADIUS, sb.toString());
            } else if (((CloudSearch.Query) ((AbstractC4370a) this).b).getBound().getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((CloudSearch.Query) ((AbstractC4370a) this).b).getBound().getLowerLeft();
                LatLonPoint upperRight = ((CloudSearch.Query) ((AbstractC4370a) this).b).getBound().getUpperRight();
                double a3 = C4435i.a(lowerLeft.getLatitude());
                double a4 = C4435i.a(lowerLeft.getLongitude());
                double a5 = C4435i.a(upperRight.getLatitude());
                double a6 = C4435i.a(upperRight.getLongitude());
                hashtable.put("polygon", a4 + "," + a3 + ";" + a6 + "," + a5);
            } else if (((CloudSearch.Query) ((AbstractC4370a) this).b).getBound().getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = ((CloudSearch.Query) ((AbstractC4370a) this).b).getBound().getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    hashtable.put("polygon", C4435i.a(polyGonList, ";"));
                }
            } else if (((CloudSearch.Query) ((AbstractC4370a) this).b).getBound().getShape().equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
                hashtable.put("city", ((CloudSearch.Query) ((AbstractC4370a) this).b).getBound().getCity());
            }
        }
        hashtable.put("layerId", ((CloudSearch.Query) ((AbstractC4370a) this).b).getTableID());
        if (!C4435i.a(j())) {
            hashtable.put("sortrule", j());
        }
        String z = z();
        if (!C4435i.a(z)) {
            hashtable.put(Constants.Name.FILTER, z);
        }
        String queryString = ((CloudSearch.Query) ((AbstractC4370a) this).b).getQueryString();
        if (queryString != null && !"".equals(queryString)) {
            hashtable.put(OneArchConstants.LayoutKey.KEY_WORDS, queryString);
        } else {
            hashtable.put(OneArchConstants.LayoutKey.KEY_WORDS, "");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((CloudSearch.Query) ((AbstractC4370a) this).b).getPageSize());
        hashtable.put(Constants.Name.PAGE_SIZE, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(((CloudSearch.Query) ((AbstractC4370a) this).b).getPageNum());
        hashtable.put("pageNum", sb3.toString());
        String a7 = bn.a();
        String a8 = bn.a(((AbstractC4370a) this).e, a7, a(hashtable));
        hashtable.put("ts", a7);
        hashtable.put("scode", a8);
        return hashtable;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        String str = C4434h.e() + "/datasearch";
        String shape = ((CloudSearch.Query) ((AbstractC4370a) this).b).getBound().getShape();
        if (shape.equals("Bound")) {
            return str + "/around";
        } else if (!shape.equals("Polygon") && !shape.equals("Rectangle")) {
            if (shape.equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
                return str + "/local";
            }
            return str;
        } else {
            return str + "/polygon";
        }
    }

    private static String a(Map<String, String> map) {
        return g(b(map));
    }

    private static String e(String str) {
        return str != null ? str.replace(jn1.AND, "%26%26") : str;
    }
}
