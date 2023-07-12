package tb;

import com.alibaba.motu.tbrest.SendService;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ka2 {
    private static final Integer a = 61004;
    private static final String b = null;

    public static boolean a(String str, String str2) {
        try {
            Boolean sendRequest = SendService.getInstance().sendRequest(b, System.currentTimeMillis(), null, a.intValue(), "AliHA", str2, str, null);
            if (sendRequest.booleanValue()) {
                lb1.d("SendManager", "send success");
            } else {
                lb1.g("SendManager", "send failure");
            }
            return sendRequest.booleanValue();
        } catch (Throwable th) {
            lb1.f(th);
            return false;
        }
    }
}
