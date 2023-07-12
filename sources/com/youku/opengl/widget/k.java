package com.youku.opengl.widget;

import java.nio.FloatBuffer;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class k extends com.youku.opengl.filter.f {
    private com.youku.media.b d;
    private n e;

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

    @Override // com.youku.opengl.filter.f, com.youku.opengl.filter.b
    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        com.youku.media.b bVar = this.d;
        int c = bVar != null ? bVar.c() : -1;
        n nVar = this.e;
        int k = nVar != null ? nVar.k() : -1;
        a((k < 0 || c < 0) ? k >= 0 ? d(k) : c >= 0 ? e(c) : "no pts" : b(k, c));
        super.a(i, floatBuffer, floatBuffer2);
    }

    public void a(com.youku.media.b bVar) {
        this.d = bVar;
    }

    public void a(n nVar) {
        this.e = nVar;
    }
}
