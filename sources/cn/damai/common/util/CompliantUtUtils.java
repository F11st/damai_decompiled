package cn.damai.common.util;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public final class CompliantUtUtils {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final CompliantUtUtils INSTANCE = new CompliantUtUtils();
    @Nullable
    private static CompliantUtDelegate a;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface CompliantUtDelegate {
        boolean isOpenPrivacyDoubleListInit();
    }

    private CompliantUtUtils() {
    }

    @JvmStatic
    public static final void a() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-940899936")) {
            ipChange.ipc$dispatch("-940899936", new Object[0]);
            return;
        }
        CompliantUtDelegate compliantUtDelegate = a;
        if (compliantUtDelegate != null && compliantUtDelegate.isOpenPrivacyDoubleListInit()) {
            z = true;
        }
        if (z) {
            return;
        }
        C0529c.e().A(new HashMap(), "model", "device");
    }

    @JvmStatic
    public static final void b(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-2121882088")) {
            ipChange.ipc$dispatch("-2121882088", new Object[]{str, str2});
            return;
        }
        CompliantUtDelegate compliantUtDelegate = a;
        if (compliantUtDelegate != null && compliantUtDelegate.isOpenPrivacyDoubleListInit()) {
            return;
        }
        if (str == null || str.length() == 0) {
            return;
        }
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        if (z) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("lat", str);
        hashMap.put("lng", str2);
        C0529c.e().A(hashMap, "location", "location");
    }

    @JvmStatic
    public static final void c(@Nullable String str) {
        long currentTimeMillis;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1241169807")) {
            ipChange.ipc$dispatch("1241169807", new Object[]{str});
            return;
        }
        if ((str == null || str.length() == 0) ? true : true) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(z20.B("serverTimeDiff"))) {
            long currentTimeMillis2 = System.currentTimeMillis();
            String B = z20.B("serverTimeDiff");
            b41.h(B, "getString(\"serverTimeDiff\")");
            currentTimeMillis = (currentTimeMillis2 + Long.parseLong(B)) / 1000;
        } else {
            currentTimeMillis = System.currentTimeMillis() / 1000;
        }
        hashMap.put("havanaid", str);
        hashMap.put("logintime", String.valueOf(currentTimeMillis));
        C0529c.e().A(hashMap, "record", "login");
    }

    @JvmStatic
    public static final void d() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "199036319")) {
            ipChange.ipc$dispatch("199036319", new Object[0]);
            return;
        }
        CompliantUtDelegate compliantUtDelegate = a;
        if (compliantUtDelegate != null && compliantUtDelegate.isOpenPrivacyDoubleListInit()) {
            z = true;
        }
        if (z) {
            return;
        }
        C0529c.e().A(new HashMap(), "osversion", "device");
    }

    @JvmStatic
    public static final void e(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "2038470891")) {
            ipChange.ipc$dispatch("2038470891", new Object[]{str});
            return;
        }
        if ((str == null || str.length() == 0) ? true : true) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("phone", str);
        C0529c.e().A(hashMap, "contact", NotificationCompat.CATEGORY_SOCIAL);
    }

    @JvmStatic
    public static final void f(@NotNull CompliantUtDelegate compliantUtDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1454258694")) {
            ipChange.ipc$dispatch("-1454258694", new Object[]{compliantUtDelegate});
            return;
        }
        b41.i(compliantUtDelegate, "delegate");
        a = compliantUtDelegate;
    }
}
