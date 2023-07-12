package cn.damai.commonbusiness.base;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.android.utils.OPRUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import mtopsdk.mtop.util.ErrorConstant;
import tb.e11;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ResponseErrorPageType {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_EMPTY = 3;
    public static final int TYPE_EMPTY_ORDER = 6;
    public static final int TYPE_LIMIT = 2;
    public static final int TYPE_LIMIT_CUSTOM_MSG = 11;
    public static final int TYPE_LIMIT_ORDER = 5;
    public static final int TYPE_LOGIN = 7;
    public static final int TYPE_NET_ERROR = 1;
    public static final int TYPE_TICKET_EMPTY = 4;
    public static final int TYPE_USER_CUSTOM = 10;
    public static List<String> a;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes14.dex */
    public @interface ErrorType {
    }

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.clear();
        a.add("MAPIE98015");
        a.add("MAPIE98043");
        a.add("F-10003-11-16-001");
        a.add("B-00203-200-018");
        a.add("BUYER_TOO_MANY_UNPAID_ORDERS");
        a.add("FAIL_BIZ_TICKLET_BUSINESS_ERROR");
        a.add("FAIL_LOCAL_ERROR_FANG_XUE_FENG");
        a.add("FAIL_SYS_USER_VALIDATE");
        a.add(e11.FAIL_SYS_TRAFFIC_LIMIT);
        a.add("ANDROID_SYS_API_FLOW_LIMIT_LOCKED");
        a.add("FAIL_SYS_SESSION_EXPIRED");
        a.add("FAIL_SYS_SESSION_EXPIRED");
        a.add(ErrorConstant.ERRCODE_API_41X_ANTI_ATTACK);
        a.add("ANDROID_SYS_NO_NETWORK");
        a.add("F-10012-01-16-001");
        a.add("B-00203-200-018");
        a.add("ANDROID_SYS_NETWORK_ERROR");
        a.add(OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM);
    }

    public static boolean a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1989758974")) {
            return ((Boolean) ipChange.ipc$dispatch("-1989758974", new Object[]{str})).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a.contains(str);
    }
}
