package cn.damai.common.net.mtop.netfit;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cw0;
import tb.vb1;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class ERROR {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int ERROR_NEED_LOGIN = 1005;
    public static final String MTOP_BIZTYPE = "mtop";
    public static final String MTOP_XFLUSH_ERROR_CODE = "-1000002";
    public static final String MTOP_XFLUSH_PARSE_CODE = "-1000001";
    public static final String MTOP_XFLUSH_SUCCESS_CODE = "2000";
    public static final int NETWORD_CONNECTEXCEPTION = 1004;
    public static final int NETWORD_ERROR = 1002;
    public static final int SERVER_ERROR = 1003;
    public static final int UNKNOWN = 1000;
    private static ERROR error;
    private DealLoginErrorListener dealLoginErrorListener;
    private List<String> mWhiteList = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface DealLoginErrorListener {
        void dealLoginError(Context context);
    }

    private ERROR() {
        initWhiteList();
    }

    public static void broadcastLogoutSuccess(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1717429386")) {
            ipChange.ipc$dispatch("1717429386", new Object[]{context});
            return;
        }
        Intent intent = new Intent();
        intent.setAction(vb1.BROADCAST_LOGOUT_SUCCESS);
        context.sendBroadcast(intent);
    }

    private void dealSessionExpired(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122660107")) {
            ipChange.ipc$dispatch("1122660107", new Object[]{this, context, str, str2, str3});
        } else if ("MAPIE97003".equals(str2) || "FAIL_SYS_SESSION_EXPIRED".equals(str2)) {
            z20.r0("");
            z20.x0("");
            z20.k0("");
            broadcastLogoutSuccess(context);
            if (context == null || !needLogin(str)) {
                return;
            }
            cw0.a().b(context);
        }
    }

    private void initWhiteList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1169418589")) {
            ipChange.ipc$dispatch("1169418589", new Object[]{this});
        } else {
            this.mWhiteList.add("mtop.damai.wireless.ticklet.performs.preload");
        }
    }

    public static ERROR instance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "764437145")) {
            return (ERROR) ipChange.ipc$dispatch("764437145", new Object[0]);
        }
        if (error == null) {
            synchronized (ERROR.class) {
                if (error == null) {
                    error = new ERROR();
                }
            }
        }
        return error;
    }

    private boolean needLogin(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "124512175")) {
            return ((Boolean) ipChange.ipc$dispatch("124512175", new Object[]{this, str})).booleanValue();
        }
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : this.mWhiteList) {
                if (str.equals(str2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void dealError(Context context, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913196974")) {
            ipChange.ipc$dispatch("1913196974", new Object[]{this, context, str, str2, str3});
        } else {
            dealSessionExpired(context, str, str2, str3);
        }
    }

    public void setDealLoginErrorListener(DealLoginErrorListener dealLoginErrorListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2003023368")) {
            ipChange.ipc$dispatch("-2003023368", new Object[]{this, dealLoginErrorListener});
        } else {
            this.dealLoginErrorListener = dealLoginErrorListener;
        }
    }
}
