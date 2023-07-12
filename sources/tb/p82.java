package tb;

import android.text.TextUtils;
import cn.damai.seatdecoder.seat_vr.bean.StaticSeat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class p82 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static o82 a(Map<String, List<StaticSeat3DVrInfo>> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1602139881")) {
            return (o82) ipChange.ipc$dispatch("-1602139881", new Object[]{map});
        }
        if (map == null) {
            return null;
        }
        Iterator<Map.Entry<String, List<StaticSeat3DVrInfo>>> it = map.entrySet().iterator();
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        while (it.hasNext()) {
            Map.Entry<String, List<StaticSeat3DVrInfo>> next = it.next();
            if (next != null) {
                List<StaticSeat3DVrInfo> value = next.getValue();
                Iterator<Map.Entry<String, List<StaticSeat3DVrInfo>>> it2 = it;
                long j9 = j7;
                int i = 0;
                while (i < value.size()) {
                    StaticSeat3DVrInfo staticSeat3DVrInfo = value.get(i);
                    j2 ^= aw0.d(staticSeat3DVrInfo.getFloorId());
                    j3 ^= aw0.a(staticSeat3DVrInfo.getFov());
                    j4 ^= aw0.a(staticSeat3DVrInfo.getFov());
                    j5 ^= aw0.a(staticSeat3DVrInfo.getFov());
                    j6 ^= aw0.e(staticSeat3DVrInfo.getImg());
                    j9 ^= aw0.e(staticSeat3DVrInfo.getThumb());
                    j8 ^= aw0.e(staticSeat3DVrInfo.getImgHash());
                    i++;
                    j ^= aw0.d(staticSeat3DVrInfo.getSid());
                }
                it = it2;
                j7 = j9;
            }
        }
        o82 o82Var = new o82();
        o82Var.m(String.valueOf(j));
        o82Var.n(String.valueOf(j2));
        o82Var.i(String.valueOf(j3));
        o82Var.j(String.valueOf(j4));
        o82Var.p(String.valueOf(j5));
        o82Var.l(String.valueOf(j6));
        o82Var.o(String.valueOf(j7));
        o82Var.k(String.valueOf(j8));
        return o82Var;
    }

    public static boolean b(String str, Map<String, List<StaticSeat3DVrInfo>> map) {
        o82 a;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "79790489")) {
            return ((Boolean) ipChange.ipc$dispatch("79790489", new Object[]{str, map})).booleanValue();
        }
        if (TextUtils.isEmpty(str) || map == null || (a = a(map)) == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("sidHash");
            if ((string == null || string.equals(a.e())) && (string != null || a.e() == null)) {
                String string2 = jSONObject.getString("standIdHash");
                if ((string2 == null || string2.equals(a.f())) && (string2 != null || a.f() == null)) {
                    String string3 = jSONObject.getString("fovHash");
                    if ((string3 == null || string3.equals(a.a())) && (string3 != null || a.a() == null)) {
                        String string4 = jSONObject.getString("horizontalHash");
                        if ((string4 == null || string4.equals(a.b())) && (string4 != null || a.b() == null)) {
                            String string5 = jSONObject.getString("verticalHash");
                            if ((string5 == null || string5.equals(a.h())) && (string5 != null || a.h() == null)) {
                                String string6 = jSONObject.getString("imgHash");
                                if ((string6 == null || string6.equals(a.d())) && (string6 != null || a.d() == null)) {
                                    String string7 = jSONObject.getString("thumbHash");
                                    if ((string7 == null || string7.equals(a.g())) && (string7 != null || a.g() == null)) {
                                        String string8 = jSONObject.getString("imgEncryptHash");
                                        if (string8 == null || string8.equals(a.c())) {
                                            if (string8 == null) {
                                                if (a.c() != null) {
                                                }
                                            }
                                            return true;
                                        }
                                        return false;
                                    }
                                    return false;
                                }
                                return false;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
