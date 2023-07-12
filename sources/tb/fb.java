package tb;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class fb {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SEAT_PAGE_EXTRA = "EXTRA_DATA";

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a extends ud {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // tb.ud
        public boolean is4Preload() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1240225501")) {
                return ((Boolean) ipChange.ipc$dispatch("-1240225501", new Object[]{this})).booleanValue();
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b extends ud {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // tb.ud
        public boolean is4Preload() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "113084196")) {
                return ((Boolean) ipChange.ipc$dispatch("113084196", new Object[]{this})).booleanValue();
            }
            return true;
        }
    }

    public static void a(Activity activity, TbParams tbParams, RegionData regionData) {
        Method[] declaredMethods;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1495197035")) {
            ipChange.ipc$dispatch("-1495197035", new Object[]{activity, tbParams, regionData});
        } else if (activity != null && tbParams != null && regionData != null && regionData.checkBaseValid() && TextUtils.isEmpty(tbParams.privilegeId)) {
            try {
                for (Method method : Class.forName("cn.damai.seat.request.BufferUtil").getDeclaredMethods()) {
                    String name = method.getName();
                    if (TextUtils.equals("loadStatus", name)) {
                        method.invoke(null, Long.valueOf(tbParams.itemId), Long.valueOf(tbParams.projectId), Long.valueOf(tbParams.performId), Integer.valueOf(regionData.ri.vesion), null, null, null, new a());
                    } else if (TextUtils.equals("loadDynamic", name)) {
                        method.invoke(null, Long.valueOf(tbParams.projectId), Long.valueOf(tbParams.itemId), Long.valueOf(tbParams.performId), null, tbParams.privilegeId, null, Boolean.valueOf(tbParams.hasPromotion), null, new b());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(Activity activity, TbParams tbParams, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1326241033")) {
            ipChange.ipc$dispatch("-1326241033", new Object[]{activity, tbParams, Boolean.valueOf(z), Integer.valueOf(i)});
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("EXTRA_DATA", tbParams);
        v82.b(bundle, tbParams.itemId, tbParams.projectId, tbParams.performId, tbParams.skuId, tbParams.privilegeId, tbParams.h5NewUltron);
        if (z) {
            DMNav.from(activity).forResult(i).withExtras(bundle).toUri(NavUri.b(cs.PAGE_QILIN_JPG_SEAT));
        } else {
            DMNav.from(activity).forResult(i).withExtras(bundle).toUri(NavUri.b(cs.PAGE_QILIN_JPG_REGION));
        }
    }

    public static void c(Activity activity, TbParams tbParams, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-273836668")) {
            ipChange.ipc$dispatch("-273836668", new Object[]{activity, tbParams, Integer.valueOf(i)});
        } else if (activity == null || tbParams == null) {
        } else {
            Bundle bundle = new Bundle();
            if (tbParams.firstPayChooseSeat) {
                v82.c(bundle, tbParams.itemId, tbParams.projectId, tbParams.performId, tbParams.orderId);
            } else {
                v82.b(bundle, tbParams.itemId, tbParams.projectId, tbParams.performId, tbParams.skuId, tbParams.privilegeId, tbParams.h5NewUltron);
            }
            bundle.putParcelable("EXTRA_DATA", tbParams);
            DMNav.from(activity).forResult(i).withExtras(bundle).toUri(NavUri.b(cs.PAGE_QILIN_SVG_SEAT));
        }
    }
}
