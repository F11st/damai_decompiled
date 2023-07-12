package tb;

import android.text.TextUtils;
import com.alibaba.android.umbrella.performance.PerformanceEntity;
import java.util.Map;
import mtopsdk.mtop.util.ErrorConstant;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class lt2 {
    public static boolean a(String str) {
        return kt2.z() || TextUtils.isEmpty(str);
    }

    public static boolean b(String str) {
        return TextUtils.isEmpty(str) || str.equals(e11.FAIL_SYS_TRAFFIC_LIMIT) || str.equals(ErrorConstant.ERRCODE_API_41X_ANTI_ATTACK) || str.equals("FAIL_SYS_USER_VALIDATE") || str.equals("FAIL_LOCAL_ERROR_FANG_XUE_FENG");
    }

    public static PerformanceEntity c(String str, String str2, Map<String, Long> map, Map<String, String> map2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || map == null) {
            return null;
        }
        PerformanceEntity performanceEntity = new PerformanceEntity(str, str2, null);
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            performanceEntity.addRecordPoint(entry.getKey(), entry.getValue().longValue());
        }
        performanceEntity.addArgs(map2);
        return performanceEntity;
    }
}
