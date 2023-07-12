package tb;

import android.text.TextUtils;
import cn.damai.commonbusiness.home.bean.HomeTabBean;
import cn.damai.homepage.R$raw;
import cn.damai.homepage.bean.HomeTabListBean;
import cn.damai.homepage.bean.TabExtra;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class yh {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_CHANNEL_TAB_CACHE = "channelTabList";

    private static List<HomeTabBean> a(List<HomeTabBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1931631067")) {
            return (List) ipChange.ipc$dispatch("1931631067", new Object[]{list});
        }
        for (int i = 0; i < list.size(); i++) {
            HomeTabBean homeTabBean = list.get(i);
            if (homeTabBean != null) {
                homeTabBean.index = i;
                HomeTabBean.Args parseArgs = homeTabBean.parseArgs();
                if (parseArgs != null) {
                    homeTabBean.categoryId = parseArgs.categoryId;
                    homeTabBean.groupId = parseArgs.groupId;
                }
            }
        }
        return list;
    }

    private static List<HomeTabBean> b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-66508108")) {
            return (List) ipChange.ipc$dispatch("-66508108", new Object[0]);
        }
        List<HomeTabBean> a = a(((HomeTabListBean) m61.a(cn.damai.common.util.a.n(mu0.a().getResources().openRawResource(R$raw.default_home_tab)), HomeTabListBean.class)).data);
        String str = null;
        try {
            str = JSON.toJSONString(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        z20.T(KEY_CHANNEL_TAB_CACHE, str);
        return a;
    }

    public static int c(TabExtra tabExtra, List<HomeTabBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1729574681")) {
            return ((Integer) ipChange.ipc$dispatch("-1729574681", new Object[]{tabExtra, list})).intValue();
        }
        if (tabExtra != null && !cb2.d(list)) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                HomeTabBean homeTabBean = list.get(i);
                if (homeTabBean != null && f(tabExtra, homeTabBean)) {
                    return i;
                }
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<cn.damai.commonbusiness.home.bean.HomeTabBean> d(cn.damai.homepage.bean.HomeTabListBean r5) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = tb.yh.$ipChange
            java.lang.String r1 = "962254035"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L17
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r5
            java.lang.Object r5 = r0.ipc$dispatch(r1, r2)
            java.util.List r5 = (java.util.List) r5
            return r5
        L17:
            java.lang.String r0 = "channelTabList"
            r1 = 0
            if (r5 == 0) goto L52
            java.util.List<cn.damai.commonbusiness.home.bean.HomeTabBean> r2 = r5.data
            boolean r2 = tb.m91.a(r2)
            if (r2 != 0) goto L52
            java.util.List<cn.damai.commonbusiness.home.bean.HomeTabBean> r5 = r5.data
            java.util.List r5 = a(r5)
            java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r5)     // Catch: java.lang.Exception -> L2f
            goto L4d
        L2f:
            r2 = move-exception
            r2.printStackTrace()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getHomeTabList error "
            r3.append(r4)
            java.lang.String r2 = r2.getMessage()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "CMSTAB"
            android.util.Log.e(r3, r2)
        L4d:
            tb.z20.T(r0, r1)
        L50:
            r1 = r5
            goto L67
        L52:
            java.lang.String r5 = tb.z20.B(r0)     // Catch: java.lang.Exception -> L63
            boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L63
            if (r0 != 0) goto L67
            java.lang.Class<cn.damai.commonbusiness.home.bean.HomeTabBean> r0 = cn.damai.commonbusiness.home.bean.HomeTabBean.class
            java.util.List r5 = com.alibaba.fastjson.JSON.parseArray(r5, r0)     // Catch: java.lang.Exception -> L63
            goto L50
        L63:
            r5 = move-exception
            r5.printStackTrace()
        L67:
            if (r1 != 0) goto L6d
            java.util.List r1 = b()
        L6d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.yh.d(cn.damai.homepage.bean.HomeTabListBean):java.util.List");
    }

    private static String e(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "926594157") ? (String) ipChange.ipc$dispatch("926594157", new Object[]{str}) : str == null ? "0" : str;
    }

    public static boolean f(TabExtra tabExtra, HomeTabBean homeTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1752393539")) {
            return ((Boolean) ipChange.ipc$dispatch("-1752393539", new Object[]{tabExtra, homeTabBean})).booleanValue();
        }
        if (tabExtra.type == homeTabBean.type) {
            return TextUtils.equals(e(tabExtra.categoryId), e(homeTabBean.categoryId)) && TextUtils.equals(e(tabExtra.groupId), e(homeTabBean.groupId));
        }
        return false;
    }

    public static boolean g(HomeTabListBean homeTabListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1973166843")) {
            return ((Boolean) ipChange.ipc$dispatch("-1973166843", new Object[]{homeTabListBean})).booleanValue();
        }
        try {
            String B = z20.B(KEY_CHANNEL_TAB_CACHE);
            if (homeTabListBean != null && !m91.a(homeTabListBean.data)) {
                String jSONString = JSON.toJSONString(a(homeTabListBean.data));
                if (B != null && jSONString != null) {
                    if (B.equals(jSONString)) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
