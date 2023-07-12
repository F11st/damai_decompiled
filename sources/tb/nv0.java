package tb;

import android.text.TextUtils;
import com.ali.alihadeviceevaluator.old.CalScore;
import com.ali.alihadeviceevaluator.old.HardWareInfo;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class nv0 implements CalScore {
    @Override // com.ali.alihadeviceevaluator.old.CalScore
    public int getScore(HardWareInfo hardWareInfo) {
        String lowerCase = Build.getBRAND().toLowerCase();
        if (TextUtils.isEmpty(lowerCase)) {
            return 1;
        }
        if (lowerCase.contains("samsung") || lowerCase.contains("google")) {
            return 10;
        }
        if (lowerCase.contains("huawei") || lowerCase.contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR) || lowerCase.contains("xiaomi")) {
            return 9;
        }
        if (lowerCase.contains("meizu") || lowerCase.contains("vivo") || lowerCase.contains("oppo") || lowerCase.contains("lge") || lowerCase.contains("verizon")) {
            return 8;
        }
        if (lowerCase.contains("motorola") || lowerCase.contains("zte") || lowerCase.contains("sony") || lowerCase.contains("zuk") || lowerCase.contains("smartisan")) {
            return 7;
        }
        if (lowerCase.contains("gionee") || lowerCase.contains("letv") || lowerCase.contains("leeco") || lowerCase.contains("coolpad") || lowerCase.contains("htc")) {
            return 6;
        }
        return (lowerCase.contains("nubia") || lowerCase.contains("oneplus") || lowerCase.contains("qiku") || lowerCase.contains("360") || lowerCase.contains("lenovo") || lowerCase.contains("cmcc") || lowerCase.contains("asus")) ? 5 : 4;
    }
}
