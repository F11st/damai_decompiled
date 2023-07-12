package tb;

import android.view.View;
import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class zy1 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String RANK_PAGE = "ranklist_square";
    private static zy1 b;

    public static zy1 f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "590757915")) {
            return (zy1) ipChange.ipc$dispatch("590757915", new Object[0]);
        }
        if (b == null) {
            b = new zy1();
        }
        return b;
    }

    public a.b g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1171808154")) {
            return (a.b) ipChange.ipc$dispatch("-1171808154", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        return new a.b().j(hashMap).i("ranklist_square");
    }

    public void h(View view, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1760818659")) {
            ipChange.ipc$dispatch("-1760818659", new Object[]{this, view, str, Integer.valueOf(i)});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d());
            hashMap.put("usercode", z20.E());
            hashMap.put(pb.PRE_CONTENT_ID, str);
            hashMap.put(pb.PRE_CONTENT_TYPE, "ranklist");
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            e.G(view, "item_" + i, "local_list", "ranklist_square", hashMap);
        }
    }

    public void i(View view, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1852234103")) {
            ipChange.ipc$dispatch("1852234103", new Object[]{this, view, str, Integer.valueOf(i)});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d());
            hashMap.put("usercode", z20.E());
            hashMap.put(pb.PRE_CONTENT_ID, str);
            hashMap.put(pb.PRE_CONTENT_TYPE, "ranklist");
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            e.G(view, "item_" + i, "more_list", "ranklist_square", hashMap);
        }
    }

    public void j(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1495841132")) {
            ipChange.ipc$dispatch("-1495841132", new Object[]{this, view});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d());
            hashMap.put("usercode", z20.E());
            cn.damai.common.user.c.e().G(view, "list", "ip_list", "ranklist_square", hashMap);
        }
    }

    public void k(View view, String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1587986553")) {
            ipChange.ipc$dispatch("1587986553", new Object[]{this, view, str, Integer.valueOf(i)});
        } else if (view == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("city", z20.d());
            hashMap.put("usercode", z20.E());
            hashMap.put("repertoire_id", str);
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            e.G(view, "item_" + i, "ip_list", "ranklist_square", hashMap);
        }
    }

    public a.b l(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-178790453")) {
            return (a.b) ipChange.ipc$dispatch("-178790453", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        return e("ranklist_square", "local_list", "item_" + i, hashMap, Boolean.TRUE);
    }

    public a.b m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1355369464")) {
            return (a.b) ipChange.ipc$dispatch("1355369464", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        return e("ranklist_square", "local_list", "more", hashMap, Boolean.FALSE);
    }

    public a.b n(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1170083859")) {
            return (a.b) ipChange.ipc$dispatch("-1170083859", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        return e("ranklist_square", "more_list", "item_" + i, hashMap, Boolean.TRUE);
    }

    public a.b o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "189378991")) {
            return (a.b) ipChange.ipc$dispatch("189378991", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        return e("ranklist_square", "ip_list", "list", hashMap, Boolean.TRUE);
    }

    public a.b p(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-316609972")) {
            return (a.b) ipChange.ipc$dispatch("-316609972", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        hashMap.put("repertoire_id", str);
        return e("ranklist_square", "ip_list", "item_" + i, hashMap, Boolean.TRUE);
    }

    public a.b q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-320600353")) {
            return (a.b) ipChange.ipc$dispatch("-320600353", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        return e("ranklist_square", "top", "share", hashMap, Boolean.TRUE);
    }

    public a.b r(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "677967819")) {
            return (a.b) ipChange.ipc$dispatch("677967819", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        return e("ranklist_square", "theme_list", "item_" + i, hashMap, Boolean.TRUE);
    }

    public a.b s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1935214841")) {
            return (a.b) ipChange.ipc$dispatch("-1935214841", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        return e("ranklist_square", "theme_list", "list", hashMap, Boolean.TRUE);
    }
}
