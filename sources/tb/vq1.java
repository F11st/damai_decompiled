package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class vq1 {
    public boolean a;
    public String b;
    public long d;
    public String e;
    public int f;
    public String g;
    public int h;
    public String k;
    public int l;
    public f80 n;
    public boolean c = true;
    public int i = 1;
    public boolean j = true;
    public boolean m = false;

    public vq1(boolean z) {
        this.a = true;
        this.a = z;
    }

    public static vq1 a(JSONObject jSONObject) {
        vq1 vq1Var = null;
        try {
            if (jSONObject.containsKey("patches")) {
                JSONArray jSONArray = jSONObject.getJSONArray("patches");
                if (jSONArray != null && jSONArray.size() > 0) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(0);
                    vq1 vq1Var2 = new vq1(true);
                    try {
                        vq1Var2.c = true;
                        String string = jSONObject2.getString("type");
                        if ("andfix".equals(string)) {
                            String string2 = jSONObject2.getString("md5");
                            String string3 = jSONObject2.getString("patchUrl");
                            int intValue = jSONObject2.getInteger("pri").intValue();
                            long longValue = jSONObject2.getLong("size").longValue();
                            String string4 = jSONObject2.getString("mainVersion");
                            int intValue2 = jSONObject2.getInteger("version").intValue();
                            boolean booleanValue = jSONObject2.getBoolean("useSupport").booleanValue();
                            if (jSONObject2.containsKey(AgooConstants.MESSAGE_EXT)) {
                                vq1Var2.i = jSONObject2.getInteger(AgooConstants.MESSAGE_EXT).intValue();
                            }
                            if ((vq1Var2.i & 1) == 1) {
                                vq1Var2.j = true;
                            } else {
                                vq1Var2.j = false;
                            }
                            vq1Var2.k = string;
                            vq1Var2.g = string2;
                            vq1Var2.b = string3;
                            vq1Var2.h = intValue;
                            vq1Var2.d = longValue;
                            vq1Var2.e = string4;
                            vq1Var2.f = intValue2;
                            vq1Var2.c = booleanValue;
                            vq1Var2.k = "andfix";
                        } else if (lu2.DEXPATCH.equals(string)) {
                            f80 f80Var = new f80();
                            vq1Var2.n = f80Var;
                            f80Var.d = jSONObject2.getString("md5");
                            f80 f80Var2 = vq1Var2.n;
                            vq1Var2.g = f80Var2.d;
                            f80Var2.a = jSONObject2.getLong("size").longValue();
                            f80 f80Var3 = vq1Var2.n;
                            vq1Var2.d = f80Var3.a;
                            f80Var3.e = jSONObject2.getLong("version").longValue();
                            vq1Var2.k = lu2.DEXPATCH;
                            vq1Var2.f = (int) vq1Var2.n.e;
                            vq1Var2.e = jSONObject2.getString("mainVersion");
                            if (jSONObject2.containsKey("httpsUrl")) {
                                vq1Var2.n.b = jSONObject2.getString("httpsUrl");
                            }
                            if (jSONObject2.containsKey("patchUrl")) {
                                vq1Var2.n.c = jSONObject2.getString("patchUrl");
                            }
                            vq1Var2.n.f = jSONObject2.getJSONArray("updateBundles");
                        }
                        vq1Var = vq1Var2;
                    } catch (Exception e) {
                        e = e;
                        vq1Var = vq1Var2;
                        e.printStackTrace();
                        return vq1Var;
                    }
                }
            } else if (jSONObject.containsKey("rollback")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("rollback");
                vq1 vq1Var3 = new vq1(true);
                try {
                    vq1Var3.m = true;
                    if (jSONObject3.containsKey("patchVersion")) {
                        vq1Var3.l = jSONObject3.getInteger("patchVersion").intValue();
                    }
                    vq1Var = vq1Var3;
                } catch (Exception e2) {
                    e = e2;
                    vq1Var = vq1Var3;
                    e.printStackTrace();
                    return vq1Var;
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
        return vq1Var;
    }

    public String b() {
        if (this.k.equals(lu2.DEXPATCH)) {
            return this.n.a();
        }
        return this.b;
    }

    public String toString() {
        return "Patch的版本为：" + this.f + " ---  Patch的MD5值为：" + this.g + " ---  Patch的size为：" + this.d + " ---  Patch的存储路径为：" + this.b + " ---  Patch优先级：" + this.h;
    }
}
