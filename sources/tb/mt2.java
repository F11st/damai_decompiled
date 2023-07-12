package tb;

import com.alibaba.android.umbrella.trace.UmbrellaTracker;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class mt2 {
    public static final String KEY_MAIN_BIZ_NAME = "ultronTrade";

    public static void a(String str, String str2, Map<String, String> map) {
        UmbrellaTracker.commitFailureStability("umbrella.event.openurl", "ultron.trade.open.url", "1.0", KEY_MAIN_BIZ_NAME, "biz_unknow", map, str, str2);
    }
}
