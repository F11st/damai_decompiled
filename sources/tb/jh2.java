package tb;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.android.sopatch.transfer.Transfer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class jh2 implements Transfer<String, ge2> {
    private final C9313c a = new C9313c();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.jh2$b */
    /* loaded from: classes11.dex */
    public static class C9312b implements Transfer<JSONArray, List<me2>> {
        private C9312b() {
        }

        @Override // com.taobao.android.sopatch.transfer.Transfer
        /* renamed from: a */
        public JSONArray antiTransfer(List<me2> list) {
            JSONArray jSONArray = new JSONArray();
            for (me2 me2Var : list) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", me2Var.b());
                    jSONObject.put("md5", me2Var.a());
                    jSONObject.put("size", me2Var.d());
                    jSONObject.put("patchVersion", me2Var.c());
                    jSONArray.put(jSONObject);
                } catch (Exception e) {
                    ob1.e(e);
                }
            }
            return jSONArray;
        }

        @Override // com.taobao.android.sopatch.transfer.Transfer
        /* renamed from: b */
        public List<me2> transfer(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("name");
                    String string2 = jSONObject.getString("md5");
                    arrayList.add(he2.c(string, string2.toLowerCase(), jSONObject.getLong("size"), jSONObject.getInt("patchVersion")));
                } catch (Exception e) {
                    ob1.e(e);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.jh2$c */
    /* loaded from: classes11.dex */
    public static class C9313c implements Transfer<JSONArray, List<pe2>> {
        private C9312b a;

        private C9313c() {
            this.a = new C9312b();
        }

        @Override // com.taobao.android.sopatch.transfer.Transfer
        /* renamed from: a */
        public JSONArray antiTransfer(List<pe2> list) {
            JSONArray jSONArray = new JSONArray();
            for (pe2 pe2Var : list) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("patchUrl", pe2Var.g());
                    jSONObject.put("md5", pe2Var.c());
                    jSONObject.put("size", pe2Var.f());
                    jSONObject.put("patchVersion", pe2Var.d());
                    List<me2> b = pe2Var.b();
                    if (b != null && b.size() > 0) {
                        jSONObject.put("soLastValidPatch", this.a.antiTransfer(b));
                    }
                    jSONArray.put(jSONObject);
                } catch (Exception e) {
                    ob1.e(e);
                }
            }
            return jSONArray;
        }

        @Override // com.taobao.android.sopatch.transfer.Transfer
        /* renamed from: b */
        public List<pe2> transfer(JSONArray jSONArray) {
            List<me2> transfer;
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    pe2 pe2Var = new pe2(jSONObject.getString("patchUrl"), jSONObject.getInt("patchVersion"), jSONObject.getString("md5").toLowerCase(), jSONObject.getLong("size"));
                    JSONArray optJSONArray = jSONObject.optJSONArray("soLastValidPatch");
                    if (optJSONArray != null && optJSONArray.length() > 0 && (transfer = this.a.transfer(optJSONArray)) != null && transfer.size() > 0) {
                        pe2Var.e(transfer);
                    }
                    arrayList.add(pe2Var);
                } catch (JSONException e) {
                    ob1.e(e);
                }
            }
            return arrayList;
        }
    }

    @Override // com.taobao.android.sopatch.transfer.Transfer
    /* renamed from: a */
    public String antiTransfer(ge2 ge2Var) {
        if (ge2Var == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, ge2Var.a());
            jSONObject.put("beta", ge2Var.c());
            jSONObject.put("priority", ge2Var.f());
            jSONObject.put("type", ge2Var.j());
            List<pe2> b = ge2Var.b();
            if (b != null && b.size() > 0) {
                jSONObject.put("solist", this.a.antiTransfer(ge2Var.b()));
            }
            jSONObject.put("md5", ge2Var.d());
        } catch (Exception e) {
            ob1.e(e);
        }
        return jSONObject.toString();
    }

    @Override // com.taobao.android.sopatch.transfer.Transfer
    /* renamed from: b */
    public ge2 transfer(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION);
            boolean optBoolean = jSONObject.optBoolean("beta");
            int i = jSONObject.getInt("priority");
            String string2 = jSONObject.getString("type");
            List<pe2> transfer = this.a.transfer(jSONObject.getJSONArray("solist"));
            ge2 ge2Var = new ge2(string, string2, i, optBoolean);
            ge2Var.i(transfer);
            String optString = jSONObject.optString("md5");
            if (!TextUtils.isEmpty(optString)) {
                ge2Var.g(optString.toLowerCase());
            }
            return ge2Var;
        } catch (Exception e) {
            ob1.e(e);
            return null;
        }
    }
}
