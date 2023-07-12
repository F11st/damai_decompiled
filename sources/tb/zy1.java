package tb;

import android.view.View;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class zy1 extends C0528b {
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

    public C0525a.C0527b g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1171808154")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1171808154", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        return new C0525a.C0527b().j(hashMap).i("ranklist_square");
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
            hashMap.put(C9548pb.PRE_CONTENT_ID, str);
            hashMap.put(C9548pb.PRE_CONTENT_TYPE, "ranklist");
            C0529c e = C0529c.e();
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
            hashMap.put(C9548pb.PRE_CONTENT_ID, str);
            hashMap.put(C9548pb.PRE_CONTENT_TYPE, "ranklist");
            C0529c e = C0529c.e();
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
            C0529c.e().G(view, "list", "ip_list", "ranklist_square", hashMap);
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
            C0529c e = C0529c.e();
            e.G(view, "item_" + i, "ip_list", "ranklist_square", hashMap);
        }
    }

    public C0525a.C0527b l(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-178790453")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-178790453", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        return e("ranklist_square", "local_list", "item_" + i, hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1355369464")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1355369464", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        return e("ranklist_square", "local_list", "more", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b n(String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1170083859")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1170083859", new Object[]{this, str, str2, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        return e("ranklist_square", "more_list", "item_" + i, hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "189378991")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("189378991", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        return e("ranklist_square", "ip_list", "list", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b p(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-316609972")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-316609972", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        hashMap.put("repertoire_id", str);
        return e("ranklist_square", "ip_list", "item_" + i, hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-320600353")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-320600353", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        return e("ranklist_square", "top", "share", hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b r(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "677967819")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("677967819", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        return e("ranklist_square", "theme_list", "item_" + i, hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1935214841")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1935214841", new Object[]{this});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.d());
        hashMap.put("usercode", z20.E());
        return e("ranklist_square", "theme_list", "list", hashMap, Boolean.TRUE);
    }
}
