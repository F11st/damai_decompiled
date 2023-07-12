package tb;

import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class u12 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String BIZ_ID = "biz_id";
    public static final String BIZ_TYPE = "biz_type";
    public static final String ITEM_ID = "item_id";
    public static final String REPERTOITE = "repertoire";
    public static final String TITLELABEL = "titlelabel";
    public static final String USERCODE = "usercode";
    public static final String VIEW_TYPE = "view_type";

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    private static class b {
        private static final u12 a = new u12();
    }

    public static final u12 h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-348042629") ? (u12) ipChange.ipc$dispatch("-348042629", new Object[0]) : b.a;
    }

    public a.b f(boolean z, String str, String str2, boolean z2, String str3, String str4, String str5, String str6, String str7, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1350558166")) {
            return (a.b) ipChange.ipc$dispatch("1350558166", new Object[]{this, Boolean.valueOf(z), str, str2, Boolean.valueOf(z2), str3, str4, str5, str6, str7, Integer.valueOf(i)});
        }
        String str8 = str3 + "&" + str4 + "&" + str5 + "&" + str6;
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("biz_id", str);
        hashMap.put("biz_type", str2);
        hashMap.put(VIEW_TYPE, z2 ? "1" : "0");
        hashMap.put("titlelabel", str8);
        hashMap.put("circle_id", str7);
        return e(REPERTOITE, !z ? pp2.PROJECT_EVALUATE : "wonderful_evaluate", "enter_circle_" + i, hashMap, Boolean.TRUE);
    }

    public a.b g(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1975434842")) {
            return (a.b) ipChange.ipc$dispatch("-1975434842", new Object[]{this, str, str2, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("biz_id", str);
        hashMap.put("biz_type", str2);
        hashMap.put(VIEW_TYPE, z ? "1" : "0");
        return e(REPERTOITE, "repertoire_info", "poster", hashMap, Boolean.FALSE);
    }

    public a.b i(boolean z, String str, String str2, boolean z2, String str3, String str4, String str5, String str6, int i) {
        String str7;
        String str8;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-674324261")) {
            return (a.b) ipChange.ipc$dispatch("-674324261", new Object[]{this, Boolean.valueOf(z), str, str2, Boolean.valueOf(z2), str3, str4, str5, str6, Integer.valueOf(i)});
        }
        String str9 = str3 + "&" + str4 + "&" + str5 + "&" + str6;
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("biz_id", str);
        hashMap.put("biz_type", str2);
        hashMap.put(VIEW_TYPE, z2 ? "1" : "0");
        hashMap.put("titlelabel", str9);
        String str10 = "wonderful_comment_" + i;
        if (z) {
            str7 = "wonderful_evaluate";
            str8 = str10;
        } else {
            str8 = "comment_" + i;
            str7 = pp2.PROJECT_EVALUATE;
        }
        return e(REPERTOITE, str7, str8, hashMap, Boolean.TRUE);
    }

    public a.b j(String str, String str2, boolean z, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1329358170")) {
            return (a.b) ipChange.ipc$dispatch("-1329358170", new Object[]{this, str, str2, Boolean.valueOf(z), str3, str4, str5, str6});
        }
        String str7 = str3 + "&" + str4 + "&" + str5 + "&" + str6;
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("biz_id", str);
        hashMap.put("biz_type", str2);
        hashMap.put(VIEW_TYPE, z ? "1" : "0");
        hashMap.put("titlelabel", str7);
        return e(REPERTOITE, pp2.PROJECT_EVALUATE, "more_comment", hashMap, Boolean.FALSE);
    }

    public a.b k(boolean z, String str, String str2, boolean z2, String str3, String str4, String str5, String str6, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1120026418")) {
            return (a.b) ipChange.ipc$dispatch("1120026418", new Object[]{this, Boolean.valueOf(z), str, str2, Boolean.valueOf(z2), str3, str4, str5, str6, Integer.valueOf(i)});
        }
        String str7 = str3 + "&" + str4 + "&" + str5 + "&" + str6;
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("biz_id", str);
        hashMap.put("biz_type", str2);
        hashMap.put(VIEW_TYPE, z2 ? "1" : "0");
        hashMap.put("titlelabel", str7);
        return e(REPERTOITE, !z ? pp2.PROJECT_EVALUATE : "wonderful_evaluate", "evaluate_pic_" + i, hashMap, Boolean.TRUE);
    }

    public a.b l(boolean z, String str, String str2, boolean z2, String str3, String str4, String str5, String str6, int i) {
        String str7;
        String str8;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-563402366")) {
            return (a.b) ipChange.ipc$dispatch("-563402366", new Object[]{this, Boolean.valueOf(z), str, str2, Boolean.valueOf(z2), str3, str4, str5, str6, Integer.valueOf(i)});
        }
        String str9 = str3 + "&" + str4 + "&" + str5 + "&" + str6;
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("biz_id", str);
        hashMap.put("biz_type", str2);
        hashMap.put(VIEW_TYPE, z2 ? "1" : "0");
        hashMap.put("titlelabel", str9);
        String str10 = "wonderful_likes_" + i;
        if (z) {
            str7 = "wonderful_evaluate";
            str8 = str10;
        } else {
            str8 = "likes_" + i;
            str7 = pp2.PROJECT_EVALUATE;
        }
        return e(REPERTOITE, str7, str8, hashMap, Boolean.FALSE);
    }

    public a.b m(String str, String str2, boolean z, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1407699619")) {
            return (a.b) ipChange.ipc$dispatch("1407699619", new Object[]{this, str, str2, Boolean.valueOf(z), str3, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("biz_id", str);
        hashMap.put("biz_type", str2);
        hashMap.put(VIEW_TYPE, z ? "1" : "0");
        hashMap.put("titlelabel", str3);
        return e(REPERTOITE, "repertoire_info", "project_" + i + "", hashMap, Boolean.TRUE);
    }

    public a.b n(boolean z, String str, String str2, boolean z2, String str3, String str4, String str5, String str6, int i) {
        String str7;
        String str8;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1786928540")) {
            return (a.b) ipChange.ipc$dispatch("-1786928540", new Object[]{this, Boolean.valueOf(z), str, str2, Boolean.valueOf(z2), str3, str4, str5, str6, Integer.valueOf(i)});
        }
        String str9 = str3 + "&" + str4 + "&" + str5 + "&" + str6;
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("biz_id", str);
        hashMap.put("biz_type", str2);
        hashMap.put(VIEW_TYPE, z2 ? "1" : "0");
        hashMap.put("titlelabel", str9);
        String str10 = "wonderful_reply_btn_" + i;
        if (z) {
            str7 = "wonderful_evaluate";
            str8 = str10;
        } else {
            str8 = "reply_btn_" + i;
            str7 = pp2.PROJECT_EVALUATE;
        }
        return e(REPERTOITE, str7, str8, hashMap, Boolean.TRUE);
    }

    public a.b o(String str, String str2, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1944237177")) {
            return (a.b) ipChange.ipc$dispatch("1944237177", new Object[]{this, str, str2, Boolean.valueOf(z), Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("biz_id", str);
        hashMap.put("biz_type", str2);
        hashMap.put(VIEW_TYPE, z ? "1" : "0");
        return e(REPERTOITE, "repertoire_info", "pic_" + i, hashMap, Boolean.FALSE);
    }

    public a.b p(boolean z, String str, String str2, boolean z2, String str3, String str4, String str5, String str6, int i) {
        String str7;
        String str8;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1261921389")) {
            return (a.b) ipChange.ipc$dispatch("-1261921389", new Object[]{this, Boolean.valueOf(z), str, str2, Boolean.valueOf(z2), str3, str4, str5, str6, Integer.valueOf(i)});
        }
        String str9 = str3 + "&" + str4 + "&" + str5 + "&" + str6;
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("biz_id", str);
        hashMap.put("biz_type", str2);
        hashMap.put(VIEW_TYPE, z2 ? "1" : "0");
        hashMap.put("titlelabel", str9);
        String str10 = "wonderful_portrait_" + i;
        if (z) {
            str7 = "wonderful_evaluate";
            str8 = str10;
        } else {
            str8 = "portrait_" + i;
            str7 = pp2.PROJECT_EVALUATE;
        }
        return e(REPERTOITE, str7, str8, hashMap, Boolean.TRUE);
    }

    private u12() {
    }
}
