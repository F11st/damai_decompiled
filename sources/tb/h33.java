package tb;

import android.taobao.windvane.connect.HttpConnector;
import android.text.TextUtils;
import android.util.Pair;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.uploader.implement.C7364a;
import com.uploader.implement.C7399c;
import com.uploader.implement.a.InterfaceC7373e;
import com.uploader.implement.a.InterfaceC7374f;
import com.uploader.implement.a.c.C7371b;
import com.uploader.implement.b.a.C7394g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class h33 implements InterfaceC7373e {
    C7394g a;
    final String b;
    final long c;
    final Pair<String, Integer> d;
    final C7399c e;
    final i83 f = new i83(null, 0, 0, 0, e(), null, null, null);

    public h33(C7399c c7399c) throws Exception {
        this.e = c7399c;
        this.d = c7399c.a.e();
        this.b = c7399c.a.j();
        this.c = c7399c.a.i();
    }

    private InterfaceC7374f c(Map<String, String> map, byte[] bArr, int i, int i2) throws Exception {
        if (map.get("x-arup-error-code") != null) {
            return new i33(5, map);
        }
        String str = bArr != null ? new String(bArr, i, i2) : null;
        map.put("divided_length", Integer.toString(i2));
        return new i33(1, map, b(str));
    }

    private final Map<String, String> e() throws Exception {
        String str = this.e.b.getCurrentElement().b;
        String utdid = this.e.b.getUtdid();
        String userId = this.e.b.getUserId();
        String appVersion = this.e.b.getAppVersion();
        String valueOf = String.valueOf(this.c + (System.currentTimeMillis() / 1000));
        HashMap hashMap = new HashMap();
        hashMap.put("content-type", "application/json;charset=utf-8");
        hashMap.put("x-arup-version", "2.1");
        hashMap.put("host", C7371b.e(this.b));
        hashMap.put("x-arup-appkey", C7371b.e(str));
        hashMap.put("x-arup-appversion", C7371b.e(appVersion));
        hashMap.put("x-arup-device-id", C7371b.e(utdid));
        if (!TextUtils.isEmpty(userId)) {
            hashMap.put("x-arup-userinfo", C7371b.e(userId));
        }
        hashMap.put("x-arup-timestamp", C7371b.e(valueOf));
        StringBuilder sb = new StringBuilder(128);
        sb.append("/dispatchUpload.api");
        sb.append("&");
        sb.append(str);
        sb.append("&");
        sb.append(appVersion);
        sb.append("&");
        sb.append(utdid);
        sb.append("&");
        sb.append(valueOf);
        String signature = this.e.b.signature(sb.toString());
        if (C7364a.d(2)) {
            C7364a.a(2, "DeclareUploadActionRequest", "compute api sign:" + signature + ", input=" + ((Object) sb));
        }
        if (TextUtils.isEmpty(signature)) {
            if (C7364a.d(16)) {
                C7364a.a(16, "DeclareUploadActionRequest", "compute api sign failed.");
            }
            throw new Exception("compute api sign failed.");
        }
        hashMap.put("x-arup-sign", C7371b.e(signature));
        if (C7364a.d(2)) {
            C7364a.a(2, "DeclareUploadActionRequest", " create declare header:" + hashMap.toString());
        }
        return hashMap;
    }

    @Override // com.uploader.implement.a.InterfaceC7373e
    public i83 b() {
        return this.f;
    }

    @Override // com.uploader.implement.a.InterfaceC7373e
    /* renamed from: d */
    public C7394g a() {
        C7394g c7394g = this.a;
        if (c7394g != null) {
            return c7394g;
        }
        StringBuilder sb = new StringBuilder(32);
        if (((Integer) this.d.second).intValue() == 443) {
            sb.append("https://");
            sb.append((String) this.d.first);
            sb.append(":");
            sb.append(this.d.second);
        } else {
            sb.append("http://");
            sb.append((String) this.d.first);
        }
        sb.append("/dispatchUpload.api");
        Pair<String, Integer> pair = this.d;
        C7394g c7394g2 = new C7394g((String) pair.first, ((Integer) pair.second).intValue(), sb.toString(), this.b);
        this.a = c7394g2;
        return c7394g2;
    }

    private Object[] b(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        JSONArray jSONArray = jSONObject.getJSONArray("apiServerList");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int length = jSONArray.length() - 1; length >= 0; length--) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(length);
            arrayList.add(0, new Pair(jSONObject2.getString(TbAuthConstants.IP), Integer.valueOf(jSONObject2.getInt("port"))));
        }
        JSONArray jSONArray2 = jSONObject.getJSONArray("uploadServerList");
        ArrayList arrayList2 = new ArrayList();
        for (int length2 = jSONArray2.length() - 1; length2 >= 0; length2--) {
            JSONObject jSONObject3 = jSONArray2.getJSONObject(length2);
            arrayList2.add(0, new Pair(Boolean.valueOf(jSONObject3.getBoolean("encrypt")), new Pair(jSONObject3.getString(TbAuthConstants.IP), Integer.valueOf(jSONObject3.getInt("port")))));
        }
        return new Object[]{jSONObject.getString("token"), Long.valueOf(jSONObject.getLong(HttpConnector.EXPIRES)), arrayList, arrayList2};
    }

    @Override // com.uploader.implement.a.InterfaceC7373e
    public Pair<InterfaceC7374f, Integer> a(Map<String, String> map, byte[] bArr, int i, int i2) {
        if (map != null && bArr != null) {
            try {
                return new Pair<>(c(map, bArr, i, i2), Integer.valueOf(i2));
            } catch (Exception e) {
                if (C7364a.d(2)) {
                    C7364a.a(2, "DeclareUploadActionRequest", e.toString());
                }
                return new Pair<>(null, -1);
            }
        }
        return new Pair<>(null, 0);
    }
}
