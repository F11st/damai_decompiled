package com.youku.opengl.widget;

import com.youku.media.InterfaceC7968b;
import com.youku.opengl.filter.C8024f;
import java.nio.FloatBuffer;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
/* renamed from: com.youku.opengl.widget.k */
/* loaded from: classes3.dex */
public class C8039k extends C8024f {
    private InterfaceC7968b d;
    private C8043n e;

    private String b(int i, int i2) {
        return "No." + i + AltriaXLaunchTime.SPACE + i2;
    }

    private String d(int i) {
        return "No." + i;
    }

    private String e(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        return sb.toString();
    }

    @Override // com.youku.opengl.filter.C8024f, com.youku.opengl.filter.C8020b
    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        InterfaceC7968b interfaceC7968b = this.d;
        int c = interfaceC7968b != null ? interfaceC7968b.c() : -1;
        C8043n c8043n = this.e;
        int k = c8043n != null ? c8043n.k() : -1;
        a((k < 0 || c < 0) ? k >= 0 ? d(k) : c >= 0 ? e(c) : "no pts" : b(k, c));
        super.a(i, floatBuffer, floatBuffer2);
    }

    public void a(InterfaceC7968b interfaceC7968b) {
        this.d = interfaceC7968b;
    }

    public void a(C8043n c8043n) {
        this.e = c8043n;
    }
}
