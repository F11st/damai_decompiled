package tb;

import com.alibaba.security.common.track.model.a;
import com.uc.webview.export.extension.UCCore;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class jt2 {
    private String a;
    public static final jt2 INIT = new jt2(1, UCCore.LEGACY_EVENT_INIT);
    public static final jt2 LIFECYCLE = new jt2(2, "lifeCycle");
    public static final jt2 NETWORK = new jt2(3, a.c.h);
    public static final jt2 DATAPARSE = new jt2(4, "dataParse");
    public static final jt2 DRAWVIEW = new jt2(5, "drawView");
    public static final jt2 PAGELOAD = new jt2(6, "pageLoad");
    public static final jt2 SUB_CREATE_VIEW = new jt2(7, "createView");
    public static final jt2 SUB_BIND_VIEW = new jt2(8, "bindData");

    jt2(int i, String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }
}
