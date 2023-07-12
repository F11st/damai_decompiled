package com.youku.opengl.filter;

import android.opengl.GLES20;
import com.youku.alixplayer.MsgID;
import com.youku.opengl.a.C8013a;
import com.youku.opengl.a.C8016c;
import com.youku.opengl.widget.C8034h;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.youku.opengl.filter.c */
/* loaded from: classes3.dex */
public class C8021c extends C8020b {
    private List<C8020b> d;
    private List<C8020b> e;
    private int[] f;
    private int[] g;
    private final FloatBuffer h;
    private final FloatBuffer i;
    private final FloatBuffer j;

    public C8021c() {
        this(null);
    }

    public C8021c(List<C8020b> list) {
        String simpleName = getClass().getSimpleName();
        this.a = simpleName;
        C8013a.a(simpleName, "YkGLFilterGroup()");
        this.d = list;
        if (list == null) {
            this.d = new ArrayList();
        } else {
            o();
        }
        float[] fArr = C8034h.e;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.h = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        float[] fArr2 = C8016c.a;
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.i = asFloatBuffer2;
        asFloatBuffer2.put(fArr2).position(0);
        float[] a = C8016c.a(0, false, true);
        FloatBuffer asFloatBuffer3 = ByteBuffer.allocateDirect(a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.j = asFloatBuffer3;
        asFloatBuffer3.put(a).position(0);
    }

    private void p() {
        int[] iArr = this.g;
        if (iArr != null) {
            GLES20.glDeleteTextures(iArr.length, iArr, 0);
            this.g = null;
        }
        int[] iArr2 = this.f;
        if (iArr2 != null) {
            GLES20.glDeleteFramebuffers(iArr2.length, iArr2, 0);
            this.f = null;
        }
    }

    @Override // com.youku.opengl.filter.C8020b
    public void a() {
        super.a();
        for (C8020b c8020b : this.d) {
            c8020b.d();
        }
    }

    @Override // com.youku.opengl.filter.C8020b
    public void a(int i, int i2) {
        super.a(i, i2);
        if (this.f != null) {
            p();
        }
        int size = this.d.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.d.get(i3).a(i, i2);
        }
        List<C8020b> list = this.e;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i4 = 1;
        int size2 = this.e.size() - 1;
        this.f = new int[size2];
        this.g = new int[size2];
        int i5 = 0;
        while (i5 < size2) {
            GLES20.glGenFramebuffers(i4, this.f, i5);
            if (C8013a.b) {
                String str = this.a;
                C8013a.a(str, "onOutputSizeChanged() - mFrameBuffers[" + i5 + "]:" + this.f[i5]);
            }
            GLES20.glGenTextures(i4, this.g, i5);
            if (C8013a.b) {
                String str2 = this.a;
                C8013a.a(str2, "onOutputSizeChanged() - mFrameBufferTextures[" + i5 + "]:" + this.g[i5]);
            }
            GLES20.glBindTexture(3553, this.g[i5]);
            GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
            GLES20.glTexParameterf(3553, MsgID.MEDIA_INFO_VIDEO_START_RECOVER, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glBindFramebuffer(36160, this.f[i5]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.g[i5], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
            i5++;
            i4 = 1;
        }
    }

    @Override // com.youku.opengl.filter.C8020b
    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        List<C8020b> list;
        FloatBuffer floatBuffer3;
        FloatBuffer floatBuffer4;
        h();
        if (!i() || this.f == null || this.g == null || (list = this.e) == null) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            C8020b c8020b = this.e.get(i2);
            int i3 = size - 1;
            boolean z = i2 < i3;
            if (z) {
                GLES20.glBindFramebuffer(36160, this.f[i2]);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            }
            GLES20.glUseProgram(c8020b.l());
            if (i2 == 0) {
                c8020b.a(i, floatBuffer, floatBuffer2);
            } else {
                if (i2 == i3) {
                    floatBuffer3 = this.h;
                    if (size % 2 == 0) {
                        floatBuffer4 = this.j;
                        c8020b.a(i, floatBuffer3, floatBuffer4);
                    }
                } else {
                    floatBuffer3 = this.h;
                }
                floatBuffer4 = this.i;
                c8020b.a(i, floatBuffer3, floatBuffer4);
            }
            if (z) {
                GLES20.glBindFramebuffer(36160, 0);
                i = this.g[i2];
            }
            i2++;
        }
    }

    public void a(C8020b c8020b) {
        if (C8013a.b) {
            String str = this.a;
            C8013a.a(str, "addFilter() - aFilter:" + c8020b);
        }
        if (c8020b == null) {
            return;
        }
        this.d.add(c8020b);
        o();
    }

    @Override // com.youku.opengl.filter.C8020b
    public void a(C8034h c8034h) {
        super.a(c8034h);
        for (C8020b c8020b : this.d) {
            c8020b.a(c8034h);
        }
    }

    @Override // com.youku.opengl.filter.C8020b
    public void a(float[] fArr) {
        List<C8020b> list = this.e;
        if (list != null) {
            for (C8020b c8020b : list) {
                if (c8020b != null) {
                    c8020b.a(fArr);
                }
            }
        }
    }

    @Override // com.youku.opengl.filter.C8020b
    public void f() {
        C8013a.a(this.a, "onDestroy()");
        p();
        for (C8020b c8020b : this.d) {
            c8020b.e();
        }
        super.f();
    }

    public List<C8020b> m() {
        return this.d;
    }

    public List<C8020b> n() {
        return this.e;
    }

    public void o() {
        if (this.d == null) {
            return;
        }
        List<C8020b> list = this.e;
        if (list == null) {
            this.e = new ArrayList();
        } else {
            list.clear();
        }
        for (C8020b c8020b : this.d) {
            if (c8020b instanceof C8021c) {
                C8021c c8021c = (C8021c) c8020b;
                c8021c.o();
                List<C8020b> n = c8021c.n();
                if (n != null && !n.isEmpty()) {
                    this.e.addAll(n);
                }
            } else {
                this.e.add(c8020b);
            }
        }
    }
}
