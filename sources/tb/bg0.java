package tb;

import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class bg0 {
    private static Map<String, Class<? extends ISubscriber>> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("openUrl", gn1.class);
        a.put("openUrlResult", fn1.class);
        a.put("openPopupWindow", dn1.class);
        a.put("select", ca2.class);
        a.put("input", y21.class);
        a.put("closePopupWindow", wj.class);
        a.put("confirmPopupWindow", vm.class);
        a.put("autoJumpOpenUrl", r9.class);
        a.put("autoJumpOpenUrlResult", q9.class);
        a.put("userTrack", jv2.class);
        a.put("openSimplePopup", OpenSimplePopupSubscriber.class);
        a.put("openSimpleGroupPopup", en1.class);
        a.put("popupSelect", ot1.class);
        a.put("confirmSimplePopup", wm.class);
    }

    public static Map<String, Class<? extends ISubscriber>> a() {
        return a;
    }
}
