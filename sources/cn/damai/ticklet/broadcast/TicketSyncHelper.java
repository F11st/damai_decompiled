package cn.damai.ticklet.broadcast;

import android.os.Handler;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.ticklet.bean.QueryPerformListResultEntryData;
import cn.damai.ticklet.manager.DataHelper;
import cn.damai.ticklet.net.TickletPreloadRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.apache.commons.lang3.time.DateUtils;
import tb.in2;
import tb.xn2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TicketSyncHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "89306902")) {
            ipChange.ipc$dispatch("89306902", new Object[]{str});
            return;
        }
        TickletPreloadRequest tickletPreloadRequest = new TickletPreloadRequest();
        DMMtopRequestListener<QueryPerformListResultEntryData> dMMtopRequestListener = new DMMtopRequestListener<QueryPerformListResultEntryData>(QueryPerformListResultEntryData.class) { // from class: cn.damai.ticklet.broadcast.TicketSyncHelper.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1516116561")) {
                    ipChange2.ipc$dispatch("1516116561", new Object[]{this, str2, str3});
                    return;
                }
                TicketSyncHelper.e(str2, "预加载接口来源：" + str + " " + str3);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(QueryPerformListResultEntryData queryPerformListResultEntryData) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-16503008")) {
                    ipChange2.ipc$dispatch("-16503008", new Object[]{this, queryPerformListResultEntryData});
                } else {
                    DataHelper.getInstance().saveOrUpdatePerformTables(queryPerformListResultEntryData.getUserPerformVOList(), in2.a);
                }
            }
        };
        tickletPreloadRequest.showLoginUI(false);
        tickletPreloadRequest.request(dMMtopRequestListener);
    }

    private static void d(Boolean bool, final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1774070395")) {
            ipChange.ipc$dispatch("1774070395", new Object[]{bool, str});
        } else if (bool.booleanValue()) {
            new Handler().postDelayed(new Runnable() { // from class: cn.damai.ticklet.broadcast.TicketSyncHelper.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1527378170")) {
                        ipChange2.ipc$dispatch("-1527378170", new Object[]{this});
                    } else {
                        TicketSyncHelper.c(str);
                    }
                }
            }, DateUtils.MILLIS_PER_MINUTE);
        } else {
            c(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1652917367")) {
            ipChange.ipc$dispatch("1652917367", new Object[]{str, str2});
        } else {
            xn2.d(xn2.f(xn2.TICKLET_PRELOAD_NETWORK_ERROR_MSG, "mtop.damai.wireless.ticklet2.performs.preload", str, str2, null), xn2.TICKLET_PRELOAD_NETWORK_ERROR_CODE, str, xn2.TICKLET_PRELOAD_NETWORK_ERROR_MSG);
        }
    }

    public static void f(Boolean bool, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2111117854")) {
            ipChange.ipc$dispatch("-2111117854", new Object[]{bool, str});
        } else {
            d(bool, str);
        }
    }
}
