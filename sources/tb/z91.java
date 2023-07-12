package tb;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import cn.damai.category.category.ui.StarFragment;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.wannasee.ut.CardType;
import cn.damai.tetris.core.TrackInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class z91 extends pb {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String LIVE = "live";
    public static final String RECMMEND = "recommend";
    private static z91 b;

    public static void k(String str, View view, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-242094649")) {
            ipChange.ipc$dispatch("-242094649", new Object[]{str, view, str2, Integer.valueOf(i)});
            return;
        }
        HashMap<String, String> f = d23.f();
        f.put("titlelabel", str2);
        cn.damai.common.user.c e = cn.damai.common.user.c.e();
        e.G(view, "tab_" + i, "favorite_tab", str, f);
    }

    public static void l(View view, String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-862575944")) {
            ipChange.ipc$dispatch("-862575944", new Object[]{view, str, str2, str3, str4, str5});
            return;
        }
        HashMap hashMap = new HashMap();
        pb.f(hashMap);
        pb.h("titlelabel", str4, hashMap);
        pb.h("item_id", str5, hashMap);
        pb.g(hashMap);
        cn.damai.common.user.c.e().G(view, str3, str2, str, hashMap);
    }

    public static void m(View view, int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "109791783")) {
            ipChange.ipc$dispatch("109791783", new Object[]{view, Integer.valueOf(i), str});
            return;
        }
        HashMap hashMap = new HashMap();
        pb.f(hashMap);
        pb.g(hashMap);
        pb.h("titlelabel", "关注", hashMap);
        pb.h("rec_usercode", str, hashMap);
        cn.damai.common.user.c e = cn.damai.common.user.c.e();
        e.G(view, "card_" + i, "follow_recommend", "live", hashMap);
    }

    public static void n(View view, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "967760300")) {
            ipChange.ipc$dispatch("967760300", new Object[]{view, str, Integer.valueOf(i)});
            return;
        }
        HashMap hashMap = new HashMap();
        pb.f(hashMap);
        pb.g(hashMap);
        pb.h("titlelabel", "关注", hashMap);
        pb.h(pb.PRE_CONTENT_ID, str, hashMap);
        pb.h(pb.PRE_CONTENT_TYPE, "note", hashMap);
        cn.damai.common.user.c e = cn.damai.common.user.c.e();
        e.G(view, "card_" + i, StarFragment.KEY_FOLLOW, "live", hashMap);
    }

    public static void o(View view, String str, int i, String str2, String str3, int i2, CardType cardType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2070691921")) {
            ipChange.ipc$dispatch("2070691921", new Object[]{view, str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), cardType});
            return;
        }
        HashMap hashMap = new HashMap();
        pb.f(hashMap);
        pb.h("titlelabel", str2, hashMap);
        pb.g(hashMap);
        if (cardType != null) {
            pb.h(pb.PRE_CONTENT_TYPE, cardType.name(), hashMap);
            pb.h(pb.PRE_CONTENT_ID, str3, hashMap);
        } else {
            pb.h("item_id", str3, hashMap);
        }
        cn.damai.common.user.c.e().G(view, "card_" + i2, "favorite_tab_" + i, str, hashMap);
    }

    public static void p(View view, String str, int i, String str2, String str3, int i2, CardType cardType, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-68656928")) {
            ipChange.ipc$dispatch("-68656928", new Object[]{view, str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), cardType, str4, str5});
            return;
        }
        HashMap hashMap = new HashMap();
        pb.f(hashMap);
        pb.h("titlelabel", str2, hashMap);
        pb.g(hashMap);
        pb.h("type", str4, hashMap);
        if (!TextUtils.isEmpty(str5)) {
            pb.h("discount_type", str5, hashMap);
        }
        if (cardType != null) {
            pb.h(pb.PRE_CONTENT_TYPE, cardType.name(), hashMap);
            pb.h(pb.PRE_CONTENT_ID, str3, hashMap);
        } else {
            pb.h("item_id", str3, hashMap);
        }
        cn.damai.common.user.c.e().G(view, "card_" + i2, "favorite_tab_" + i, str, hashMap);
    }

    public static TrackInfo q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1666491319")) {
            return (TrackInfo) ipChange.ipc$dispatch("-1666491319", new Object[0]);
        }
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.trackB = "live";
        trackInfo.trackC = "recommend";
        String d = z20.d();
        trackInfo.put("usercode", (Object) z20.E());
        trackInfo.put("city", (Object) d);
        trackInfo.put("titlelabel", (Object) "推荐");
        return trackInfo;
    }

    public static z91 u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-974419077")) {
            return (z91) ipChange.ipc$dispatch("-974419077", new Object[0]);
        }
        if (b == null) {
            b = new z91();
        }
        return b;
    }

    public a.b A(String str, @Nullable String str2, int i, String str3, int i2, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1666184903")) {
            return (a.b) ipChange.ipc$dispatch("1666184903", new Object[]{this, str, str2, Integer.valueOf(i), str3, Integer.valueOf(i2), str4});
        }
        HashMap hashMap = new HashMap();
        pb.f(hashMap);
        pb.h("titlelabel", str3, hashMap);
        pb.g(hashMap);
        pb.h("type", str4 + "", hashMap);
        if (!TextUtils.isEmpty(str2)) {
            pb.h("item_id", str2, hashMap);
        }
        return e(str, "favorite_tab_" + i, "card_" + i2, hashMap, Boolean.valueOf(pb.i(2001)));
    }

    public a.b B(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-648787655")) {
            return (a.b) ipChange.ipc$dispatch("-648787655", new Object[]{this, str, str2, str3, str4, str5});
        }
        HashMap hashMap = new HashMap();
        pb.f(hashMap);
        pb.h("titlelabel", str4, hashMap);
        pb.h("item_id", str5, hashMap);
        pb.g(hashMap);
        return e(str, str2, str3, hashMap, Boolean.TRUE);
    }

    public a.b C(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217858779")) {
            return (a.b) ipChange.ipc$dispatch("217858779", new Object[]{this, str, str2, str3, str4, str5});
        }
        HashMap hashMap = new HashMap();
        pb.f(hashMap);
        pb.h("titlelabel", str4, hashMap);
        pb.h("item_id", str5, hashMap);
        pb.g(hashMap);
        return e(str, str2, str3, hashMap, Boolean.TRUE);
    }

    public a.b D(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922815225")) {
            return (a.b) ipChange.ipc$dispatch("1922815225", new Object[]{this, str, str2, str3, str4, str5});
        }
        HashMap hashMap = new HashMap();
        pb.f(hashMap);
        pb.h("titlelabel", str4, hashMap);
        pb.h("item_id", str5, hashMap);
        pb.g(hashMap);
        return e(str, str2, str3, hashMap, Boolean.TRUE);
    }

    public a.b E(String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-582156510")) {
            return (a.b) ipChange.ipc$dispatch("-582156510", new Object[]{this, str, Integer.valueOf(i), str2});
        }
        HashMap hashMap = new HashMap();
        pb.f(hashMap);
        pb.g(hashMap);
        pb.h("titlelabel", str2, hashMap);
        return e(str, "favorite_tab", "tab_" + i, hashMap, Boolean.valueOf(pb.i(2101)));
    }

    public a.b r(int i, String str, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-507144250")) {
            return (a.b) ipChange.ipc$dispatch("-507144250", new Object[]{this, Integer.valueOf(i), str, Integer.valueOf(i2)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", "关注");
        pb.h("rec_userode", str, hashMap);
        hashMap.put("status", i2 + "");
        return e("live", "follow_recommend", "follow_btn_" + i, hashMap, Boolean.FALSE);
    }

    public a.b s(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "182845867")) {
            return (a.b) ipChange.ipc$dispatch("182845867", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", "关注");
        pb.h("rec_usercode", str, hashMap);
        return e("live", "follow_recommend", "card_" + i, hashMap, Boolean.TRUE);
    }

    public a.b t(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1925614792")) {
            return (a.b) ipChange.ipc$dispatch("1925614792", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", "关注");
        return e("live", StarFragment.KEY_FOLLOW, "card_" + i, hashMap, Boolean.TRUE);
    }

    public a.b v(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1206325126")) {
            return (a.b) ipChange.ipc$dispatch("1206325126", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", str);
        hashMap.put("city", str2);
        return new a.b().j(hashMap).i("live");
    }

    public a.b w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "917673534")) {
            return (a.b) ipChange.ipc$dispatch("917673534", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        pb.f(hashMap);
        pb.g(hashMap);
        return e("live", "top", "mine", hashMap, Boolean.TRUE);
    }

    public a.b x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1446853849")) {
            return (a.b) ipChange.ipc$dispatch("1446853849", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        pb.f(hashMap);
        pb.g(hashMap);
        return e("live", "bottom", "submitbtn", hashMap, Boolean.TRUE);
    }

    public a.b y(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "28363157")) {
            return (a.b) ipChange.ipc$dispatch("28363157", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", str);
        return e("live", "center", "tab_" + i, hashMap, Boolean.FALSE);
    }

    public a.b z(String str, @Nullable String str2, int i, String str3, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "903193797")) {
            return (a.b) ipChange.ipc$dispatch("903193797", new Object[]{this, str, str2, Integer.valueOf(i), str3, Integer.valueOf(i2)});
        }
        HashMap hashMap = new HashMap();
        pb.f(hashMap);
        pb.h("titlelabel", str3, hashMap);
        pb.g(hashMap);
        if (!TextUtils.isEmpty(str2)) {
            pb.h("item_id", str2, hashMap);
        }
        return e(str, "favorite_tab_" + i, "card_" + i2, hashMap, Boolean.valueOf(pb.i(2001)));
    }
}
