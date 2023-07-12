package tb;

import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class x13 {
    public static final byte[] a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return w13.j(obj);
        } catch (Exception e) {
            WXLogUtils.e("weex wson to wson error ", e);
            return null;
        }
    }
}
