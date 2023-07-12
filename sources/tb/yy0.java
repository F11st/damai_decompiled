package tb;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.common.util.C0535a;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.home.bean.HomeTabBean;
import cn.damai.commonbusiness.tab.BottomSheetBean;
import cn.damai.homepage.R$raw;
import cn.damai.homepage.bean.HomeConfigBean;
import cn.damai.homepage.bean.HomeTabListBean;
import cn.damai.homepage.bean.TabExtra;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.mtop.BaseResponse;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class yy0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String KEY_HOME_TAB_CACHE = "homeTabList_v3";

    private static List<HomeTabBean> a(List<HomeTabBean> list) {
        HomeTabBean homeTabBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-687843223")) {
            return (List) ipChange.ipc$dispatch("-687843223", new Object[]{list});
        }
        if (list != null && list.size() > 0 && (homeTabBean = list.get(0)) != null && homeTabBean.type != 999) {
            HomeTabBean homeTabBean2 = new HomeTabBean();
            homeTabBean2.type = 999;
            homeTabBean2.name = "精选";
            homeTabBean2.spmb = "home";
            list.add(0, homeTabBean2);
        }
        for (int i = 0; i < list.size(); i++) {
            HomeTabBean homeTabBean3 = list.get(i);
            if (homeTabBean3 != null) {
                homeTabBean3.index = i;
                HomeTabBean.Args parseArgs = homeTabBean3.parseArgs();
                if (parseArgs != null) {
                    homeTabBean3.categoryId = parseArgs.categoryId;
                    homeTabBean3.groupId = parseArgs.groupId;
                }
            }
        }
        return list;
    }

    private static List<HomeTabBean> b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-456931738")) {
            return (List) ipChange.ipc$dispatch("-456931738", new Object[0]);
        }
        List<HomeTabBean> a = a(((HomeTabListBean) m61.a(C0535a.n(mu0.a().getResources().openRawResource(R$raw.default_home_tab)), HomeTabListBean.class)).data);
        String str = null;
        try {
            str = JSON.toJSONString(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        z20.T(KEY_HOME_TAB_CACHE, str);
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<cn.damai.commonbusiness.home.bean.HomeTabBean> c(cn.damai.homepage.bean.HomeTabListBean r5) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = tb.yy0.$ipChange
            java.lang.String r1 = "-42537150"
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
            java.lang.String r0 = "homeTabList_v3"
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
        throw new UnsupportedOperationException("Method not decompiled: tb.yy0.c(cn.damai.homepage.bean.HomeTabListBean):java.util.List");
    }

    public static BaseSection d(String str, BaseResponse baseResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2113024454")) {
            return (BaseSection) ipChange.ipc$dispatch("2113024454", new Object[]{str, baseResponse});
        }
        if (baseResponse == null || cb2.d(baseResponse.layers)) {
            return null;
        }
        Iterator<BaseLayer> it = baseResponse.layers.iterator();
        while (it.hasNext()) {
            BaseLayer next = it.next();
            if (next != null && !cb2.d(next.getSections())) {
                for (BaseSection baseSection : next.getSections()) {
                    if (baseSection != null && TextUtils.equals(str, baseSection.getComponentId())) {
                        return baseSection;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public static int e(TabExtra tabExtra, List<HomeTabBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "947395737")) {
            return ((Integer) ipChange.ipc$dispatch("947395737", new Object[]{tabExtra, list})).intValue();
        }
        if (tabExtra != null && !cb2.d(list)) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                HomeTabBean homeTabBean = list.get(i);
                if (homeTabBean != null && h(tabExtra, homeTabBean)) {
                    return i;
                }
            }
        }
        return 0;
    }

    private static String f(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "462636923") ? (String) ipChange.ipc$dispatch("462636923", new Object[]{str}) : str == null ? "0" : str;
    }

    public static boolean g(BottomSheetBean bottomSheetBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-958722107")) {
            return ((Boolean) ipChange.ipc$dispatch("-958722107", new Object[]{bottomSheetBean})).booleanValue();
        }
        if (bottomSheetBean == null || !cb2.g(bottomSheetBean.content)) {
            return false;
        }
        for (BottomSheetBean.Result result : bottomSheetBean.content) {
            if (!TextUtils.isEmpty(result.popText)) {
                return true;
            }
        }
        return false;
    }

    private static boolean h(TabExtra tabExtra, HomeTabBean homeTabBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-710678289")) {
            return ((Boolean) ipChange.ipc$dispatch("-710678289", new Object[]{tabExtra, homeTabBean})).booleanValue();
        }
        if (tabExtra.type == homeTabBean.type) {
            return TextUtils.equals(f(tabExtra.categoryId), f(homeTabBean.categoryId)) && TextUtils.equals(f(tabExtra.groupId), f(homeTabBean.groupId));
        }
        return false;
    }

    public static boolean i(HomeTabListBean homeTabListBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1653616850")) {
            return ((Boolean) ipChange.ipc$dispatch("1653616850", new Object[]{homeTabListBean})).booleanValue();
        }
        try {
            String B = z20.B(KEY_HOME_TAB_CACHE);
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

    public static BaseResponse j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "507037568")) {
            return (BaseResponse) ipChange.ipc$dispatch("507037568", new Object[0]);
        }
        try {
            return (BaseResponse) JSON.parseObject(C0535a.n(mu0.a().getResources().openRawResource(R$raw.default_home_cms)), BaseResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static HomeConfigBean k() {
        HomeConfigBean homeConfigBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1542575730")) {
            return (HomeConfigBean) ipChange.ipc$dispatch("1542575730", new Object[0]);
        }
        String b = qx0.b();
        if (TextUtils.isEmpty(b) || (homeConfigBean = (HomeConfigBean) m61.a(qx0.a(), HomeConfigBean.class)) == null || homeConfigBean.headLottie == null) {
            return null;
        }
        ToastUtil a = ToastUtil.a();
        Application a2 = mu0.a();
        a.j(a2, "使用了mockLottie:" + b);
        homeConfigBean.headLottie.zipUrl = b;
        return homeConfigBean;
    }
}
