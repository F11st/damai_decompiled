package tb;

import android.text.TextUtils;
import cn.damai.seatdecoder.common.bean.StaticSeat;
import cn.damai.seatdecoder.common.bean.StaticStandSeat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class b92 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static x82 a(List<StaticStandSeat> list) {
        int i;
        List<StaticStandSeat> list2 = list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1723309197")) {
            return (x82) ipChange.ipc$dispatch("1723309197", new Object[]{list2});
        }
        if (list2 == null || list.isEmpty()) {
            return null;
        }
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        long j11 = 0;
        int i2 = 0;
        while (i2 < list.size()) {
            StaticStandSeat staticStandSeat = list2.get(i2);
            if (staticStandSeat.getSeats() == null) {
                i = i2;
            } else {
                List<StaticSeat> seats = staticStandSeat.getSeats();
                i = i2;
                int i3 = 0;
                while (i3 < seats.size()) {
                    StaticSeat staticSeat = seats.get(i3);
                    j2 ^= aw0.b(staticSeat.getX());
                    j3 ^= aw0.b(staticSeat.getY());
                    j4 ^= aw0.e(staticSeat.getChint());
                    j5 ^= aw0.e(staticSeat.getFn());
                    j6 ^= aw0.e(staticSeat.getRhint());
                    j7 ^= aw0.c(staticSeat.getPlid());
                    j8 ^= aw0.c(staticSeat.getGroupId());
                    j9 ^= aw0.c(staticSeat.getGroupPriceId());
                    j10 ^= aw0.a(staticSeat.getAngle());
                    j11 ^= aw0.b(staticSeat.getI());
                    i3++;
                    seats = seats;
                    j ^= aw0.c(staticSeat.getSid());
                }
            }
            i2 = i + 1;
            list2 = list;
        }
        x82 x82Var = new x82();
        x82Var.s(String.valueOf(j));
        x82Var.u(String.valueOf(j2));
        x82Var.v(String.valueOf(j3));
        x82Var.m(String.valueOf(j4));
        x82Var.n(String.valueOf(j5));
        x82Var.r(String.valueOf(j6));
        x82Var.q(String.valueOf(j7));
        x82Var.o(String.valueOf(j8));
        x82Var.p(String.valueOf(j9));
        x82Var.l(String.valueOf(j10));
        x82Var.t(String.valueOf(j11));
        return x82Var;
    }

    public static boolean b(String str, List<StaticStandSeat> list) {
        x82 a;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "448166659")) {
            return ((Boolean) ipChange.ipc$dispatch("448166659", new Object[]{str, list})).booleanValue();
        }
        if (TextUtils.isEmpty(str) || list == null || (a = a(list)) == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("sidHash");
            if ((string == null || string.equals(a.h())) && (string != null || a.h() == null)) {
                String string2 = jSONObject.getString("xHash");
                if ((string2 == null || string2.equals(a.j())) && (string2 != null || a.j() == null)) {
                    String string3 = jSONObject.getString("yHash");
                    if ((string3 == null || string3.equals(a.k())) && (string3 != null || a.k() == null)) {
                        String string4 = jSONObject.getString("chintHash");
                        if ((string4 == null || string4.equals(a.b())) && (string4 != null || a.b() == null)) {
                            String string5 = jSONObject.getString("fnHash");
                            if ((string5 == null || string5.equals(a.c())) && (string5 != null || a.c() == null)) {
                                String string6 = jSONObject.getString("rhintHash");
                                if ((string6 == null || string6.equals(a.g())) && (string6 != null || a.g() == null)) {
                                    String string7 = jSONObject.getString("plidHash");
                                    if ((string7 == null || string7.equals(a.f())) && (string7 != null || a.f() == null)) {
                                        String string8 = jSONObject.getString("groupIdHash");
                                        if ((string8 == null || string8.equals(a.d())) && (string8 != null || a.d() == null)) {
                                            String string9 = jSONObject.getString("groupPriceIdHash");
                                            if ((string9 == null || string9.equals(a.e())) && (string9 != null || a.e() == null)) {
                                                String string10 = jSONObject.getString("angleHash");
                                                if ((string10 == null || string10.equals(a.a())) && (string10 != null || a.a() == null)) {
                                                    String string11 = jSONObject.getString("iHash");
                                                    if (string11 == null || string11.equals(a.i())) {
                                                        if (string11 == null) {
                                                            if (a.i() != null) {
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
