package tb;

import android.view.View;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class yf2 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PAGE_STAR_ARTIST = "ace_artist";
    public static final String PAGE_STAR_FOLLOW = "ace_myfollow";
    public static final String PAGE_STAR_REC = "ace_recommend";
    private static yf2 b = new yf2();

    public static void f(boolean z, int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "853782627")) {
            ipChange.ipc$dispatch("853782627", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, str2, str3});
            return;
        }
        String str4 = z ? PAGE_STAR_FOLLOW : PAGE_STAR_REC;
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("artist_id", str2);
        hashMap.put("status", str3);
        yf2 yf2Var = b;
        C0529c.e().x(yf2Var.e(str4, "artist_card_" + i, StarFragment.KEY_FOLLOW, hashMap, Boolean.FALSE));
    }

    public static void g(boolean z, int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1576626089")) {
            ipChange.ipc$dispatch("-1576626089", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, str2, str3});
            return;
        }
        String str4 = z ? PAGE_STAR_FOLLOW : PAGE_STAR_REC;
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("item_id", str2);
        hashMap.put("titlelabel", str3);
        yf2 yf2Var = b;
        C0529c.e().x(yf2Var.e(str4, "artist_card_" + i, "item", hashMap, Boolean.TRUE));
    }

    public static void h(boolean z, int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1144663970")) {
            ipChange.ipc$dispatch("1144663970", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, str2, str3});
            return;
        }
        String str4 = z ? PAGE_STAR_FOLLOW : PAGE_STAR_REC;
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("artist_id", str2);
        hashMap.put("titlelabel", str3);
        yf2 yf2Var = b;
        C0529c.e().x(yf2Var.e(str4, "artist_card_" + i, "card", hashMap, Boolean.TRUE));
    }

    public static void i(boolean z, int i, int i2, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-760945554")) {
            ipChange.ipc$dispatch("-760945554", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3});
            return;
        }
        String str4 = z ? PAGE_STAR_FOLLOW : PAGE_STAR_REC;
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("item_id", str2);
        hashMap.put("titlelabel", str3);
        C0529c.e().x(b.e(str4, "artist_card_" + i, "tour_item_" + i2, hashMap, Boolean.TRUE));
    }

    public static void j(boolean z, View view, int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1060720465")) {
            ipChange.ipc$dispatch("1060720465", new Object[]{Boolean.valueOf(z), view, Integer.valueOf(i), str, str2, str3});
            return;
        }
        String str4 = z ? PAGE_STAR_FOLLOW : PAGE_STAR_REC;
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("artist_id", str2);
        hashMap.put("titlelabel", str3);
        C0529c e = C0529c.e();
        e.G(view, "card", "artist_card_" + i, str4, hashMap);
    }

    public static void k(boolean z, View view, int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1821999148")) {
            ipChange.ipc$dispatch("-1821999148", new Object[]{Boolean.valueOf(z), view, Integer.valueOf(i), str, str2, str3});
            return;
        }
        String str4 = z ? PAGE_STAR_FOLLOW : PAGE_STAR_REC;
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("item_id", str2);
        hashMap.put("titlelabel", str3);
        C0529c e = C0529c.e();
        e.G(view, "item", "artist_card_" + i, str4, hashMap);
    }
}
