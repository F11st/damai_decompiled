package tb;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class a23 {
    @NotNull
    public static final a23 INSTANCE = new a23();
    @NotNull
    private static String a = AgooConstants.MESSAGE_POPUP;
    @NotNull
    private static String b = "failureMonitor";

    private a23() {
    }

    private final void c(String str, String str2, String str3, String str4, String str5, boolean z) {
        try {
            f23 f23Var = new f23();
            if (str3 != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("arg", str3);
                f23Var.setExtral(hashMap);
            }
            f23Var.setBizCode(str4);
            f23Var.setBizMsg(str5);
            f23Var.setBizScene(str);
            f23Var.setMPointName(str2);
            f23Var.setResultExpected(z);
            f23Var.release();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println((Object) String.valueOf(wt2.INSTANCE));
        }
    }

    public final void a(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        if (AppInfoProviderProxy.isDebuggable()) {
            return;
        }
        try {
            AppMonitor.Alarm.commitFail(a, b, str, str2, str3);
            c(a, b, str, str2, str3, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    public final String b(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.BLOCK_START_STR);
        if (!TextUtils.isEmpty(str)) {
            sb.append(" api:" + str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(", apiName:" + str2);
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append(AVFSCacheConstants.COMMA_SEP + str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(", retCode:" + str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(", retMsg:" + str4);
        }
        sb.append(" }");
        return sb.toString();
    }
}
