package tb;

import com.alibaba.android.ultron.trade.event.base.ISubscriber;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class gb0 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String PAGE_ADDRESS_LIST = "addressListPage";
    public static final String PAGE_PHONE_CODE = "phoneCodePage";
    public static final String PAGE_PROMOTION_LIST = "promotionListPage";
    public static final String PAGE_READ_PHONE = "read_contacts_phone";
    public static final String PAGE_TYPE = "pageType";
    private static Map<String, Class<? extends ISubscriber>> a = new HashMap();
    private static Map<String, Class<? extends ISubscriber>> b = new HashMap();
    public static final String closePopUpEvent = "closePopUpEvent";
    public static final String requestSubmitEvent = "validateSuccess";
    public static final String selectContactEvent = "select_contact";
    public static final String submitSuccessEvent = "submitSuccessEvent";
    public static final String switchDataTypeEvent = "switchData";
    public static final String switchDeliveryWayEvent = "switchDeliveryWay";

    static {
        a.put("submit", ab0.class);
        a.put(requestSubmitEvent, oa0.class);
        a.put(switchDeliveryWayEvent, cb0.class);
        a.put(switchDataTypeEvent, bb0.class);
        a.put(submitSuccessEvent, jb0.class);
        a.put(selectContactEvent, za0.class);
        a.put(closePopUpEvent, na0.class);
        a.put("remain", ma0.class);
        b.put("openUrl", bs.class);
        b.put("input", ra0.class);
        b.put("openPopupWindow", ta0.class);
        b.put("autoJumpOpenUrl", la0.class);
    }

    public static Map<String, Class<? extends ISubscriber>> a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1286580581") ? (Map) ipChange.ipc$dispatch("-1286580581", new Object[0]) : b;
    }

    public static Map<String, Class<? extends ISubscriber>> b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "320838516") ? (Map) ipChange.ipc$dispatch("320838516", new Object[0]) : a;
    }
}
