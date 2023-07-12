package tb;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.common.AppConfig;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.alibaba.pictures.bricks.orderconfirm.CouponOrderConfirmFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class v82 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AppConfig.EnvMode.values().length];
            a = iArr;
            try {
                iArr[AppConfig.EnvMode.online.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AppConfig.EnvMode.prepare.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AppConfig.EnvMode.test.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static void a(@NonNull Bundle bundle, long j, @NonNull Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1563970079")) {
            ipChange.ipc$dispatch("1563970079", new Object[]{bundle, Long.valueOf(j), map});
            return;
        }
        Set<String> keySet = map.keySet();
        StringBuilder sb = new StringBuilder();
        for (String str : keySet) {
            sb.append(str);
            sb.append("=");
            sb.append(map.get(str));
            sb.append("&");
        }
        int length = sb.length();
        if (length > 0) {
            sb.deleteCharAt(length - 1);
        }
        String sb2 = sb.toString();
        String str2 = d() + "?" + sb2;
        if (AppConfig.v()) {
            e(j, str2);
        }
        bundle.putString(pc0.c, str2);
        bundle.putLong(pc0.d, j);
    }

    public static void b(Bundle bundle, long j, long j2, long j3, long j4, @Nullable String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-321675471")) {
            ipChange.ipc$dispatch("-321675471", new Object[]{bundle, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), str, Boolean.valueOf(z)});
        } else if (bundle == null) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("itemId", j + "");
            hashMap.put("projectId", j2 + "");
            hashMap.put(TicketDetailExtFragment.PERFORM_ID, j3 + "");
            if (j4 > 0) {
                hashMap.put(CouponOrderConfirmFragment.SKU_ID, j4 + "");
            }
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("privilegeActId", str);
            }
            hashMap.put("toDxOrder", String.valueOf(z));
            a(bundle, j, hashMap);
        }
    }

    public static void c(Bundle bundle, long j, long j2, long j3, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1787752621")) {
            ipChange.ipc$dispatch("1787752621", new Object[]{bundle, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str});
        } else if (bundle == null) {
        } else {
            HashMap hashMap = new HashMap(4);
            hashMap.put("itemId", j + "");
            hashMap.put("projectId", j2 + "");
            hashMap.put(TicketDetailExtFragment.PERFORM_ID, j3 + "");
            hashMap.put("orderId", str);
            a(bundle, j, hashMap);
        }
    }

    private static String d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2080823118")) {
            return (String) ipChange.ipc$dispatch("2080823118", new Object[0]);
        }
        int i = a.a[AppConfig.h().ordinal()];
        return i != 1 ? i != 2 ? "https://market.waptest.taobao.com/app/dmfe/select-seat-biz/kylin.html" : "https://market.wapa.taobao.com/app/dmfe/select-seat-biz/kylin.html" : "https://m.damai.cn/app/dmfe/select-seat-biz/kylin.html";
    }

    private static void e(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-368070045")) {
            ipChange.ipc$dispatch("-368070045", new Object[]{Long.valueOf(j), str});
            return;
        }
        Log.e("SeatBundle", "itemId = " + j + ",finalUrl=" + str);
    }
}
