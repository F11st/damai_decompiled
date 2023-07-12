package tb;

import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class mf extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CALENDAR_PAGE = "perform_calendar";
    private static mf b;

    public static mf i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-784696741")) {
            return (mf) ipChange.ipc$dispatch("-784696741", new Object[0]);
        }
        if (b == null) {
            b = new mf();
        }
        return b;
    }

    public C0525a.C0527b f() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "756691653") ? (C0525a.C0527b) ipChange.ipc$dispatch("756691653", new Object[]{this}) : new C0525a.C0527b().i(CALENDAR_PAGE);
    }

    public C0525a.C0527b g(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1800967469")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1800967469", new Object[]{this, Integer.valueOf(i), str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", str);
        hashMap.put("titlelabel", str2);
        return e(CALENDAR_PAGE, "calendar", "day_" + i, hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b h(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-539573079")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-539573079", new Object[]{this, str, str2, str3, str4});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", str2);
        hashMap.put("titlelabel", str3 + "&" + str4);
        return e(CALENDAR_PAGE, "categorynames", "item_" + str, hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b j(int i, String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1976034346")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1976034346", new Object[]{this, Integer.valueOf(i), str, str2, str3, str4});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", str);
        hashMap.put("titlelabel", str2 + "&" + str3);
        hashMap.put("item_id", str4);
        return e(CALENDAR_PAGE, "list", "item_" + i, hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b k(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "278350974")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("278350974", new Object[]{this, Integer.valueOf(i), str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", str);
        hashMap.put("titlelabel", str2);
        return e(CALENDAR_PAGE, "top", "item_" + i, hashMap, Boolean.FALSE);
    }
}
