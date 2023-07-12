package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class s10 {
    public static final int REASON_DOWNGRADE = 1000;
    public static final int REASON_DOWNLOAD_FAIL = 1003;
    public static final int REASON_DOWNLOAD_REMOTE_CHILD_SUCCESS = 1004;
    public static final int REASON_DOWNLOAD_SUCCESS = 1002;
    public static final int REASON_TEMPLATE_NOT_MATCH = 1001;
    public DXTemplateItem a;
    public JSONObject b;
    public int c;
    public Object d;

    public String toString() {
        return "DXTemplateUpdateRequest{item=" + this.a + ", data=" + this.b + ", reason='" + this.c + "', dxUserContext=" + this.d + '}';
    }
}
