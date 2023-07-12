package tb;

import android.util.Pair;
import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.network.util.Constants;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class z21 {
    protected Map<String, Object> a = new HashMap();
    protected List<Pair<String, String>> b;

    public z21() {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.a.put("headers", arrayList);
    }

    private String g(String str) {
        return str == null ? "NULL" : str;
    }

    private String j(String str) {
        return str != null ? str.replaceFirst("\\[", "").replaceFirst("\\]", "") : str;
    }

    public void a(String str, String str2) {
        this.b.add(new Pair<>(g(str), j(str2)));
    }

    public String b() {
        return e(Constants.Protocol.CONTENT_ENCODING);
    }

    public int c() {
        String e = e(Constants.Protocol.CONTENT_LENGTH);
        if (e != null) {
            try {
                return Integer.parseInt(e);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return -1;
    }

    public String d() {
        String e = e("Content-Type");
        return e == null ? IRequestConst.CONTENT_TYPE_TEXT_PLAIN : e;
    }

    public String e(String str) {
        for (Pair<String, String> pair : this.b) {
            Object obj = pair.first;
            if (obj != null && ((String) obj).equalsIgnoreCase(str)) {
                return (String) pair.second;
            }
        }
        return null;
    }

    public Map<String, Object> f() {
        return this.a;
    }

    public void h(String str) {
        this.a.put("requestId", str);
    }

    public void i(String str) {
        this.a.put("url", str);
    }
}
