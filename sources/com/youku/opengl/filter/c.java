package com.youku.opengl.filter;

import android.opengl.GLES20;
import com.youku.alixplayer.MsgID;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class c extends b {
    private List<b> d;
    private List<b> e;
    private int[] f;
    private int[] g;
    private final FloatBuffer h;
    private final FloatBuffer i;
    private final FloatBuffer j;

    public c() {
        this(null);
    }

    public c(List<b> list) {
        String simpleName = getClass().getSimpleName();
        this.a = simpleName;
        com.youku.opengl.a.a.a(simpleName, "YkGLFilterGroup()");
        this.d = list;
        if (list == null) {
            this.d = new ArrayList();
        } else {
            o();
        }
        float[] fArr = com.youku.opengl.widget.h.e;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.h = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        float[] fArr2 = com.youku.opengl.a.c.a;
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.i = asFloatBuffer2;
        asFloatBuffer2.put(fArr2).position(0);
        float[] a = com.youku.opengl.a.c.a(0, false, true);
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

    @Override // com.youku.opengl.filter.b
    public void a() {
        super.a();
        for (b bVar : this.d) {
            bVar.d();
        }
    }

    @Override // com.youku.opengl.filter.b
    public void a(int i, int i2) {
        super.a(i, i2);
        if (this.f != null) {
            p();
        }
        int size = this.d.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.d.get(i3).a(i, i2);
        }
        List<b> list = this.e;
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
            if (com.youku.opengl.a.a.b) {
                String str = this.a;
                com.youku.opengl.a.a.a(str, "onOutputSizeChanged() - mFrameBuffers[" + i5 + "]:" + this.f[i5]);
            }
            GLES20.glGenTextures(i4, this.g, i5);
            if (com.youku.opengl.a.a.b) {
                String str2 = this.a;
                com.youku.opengl.a.a.a(str2, "onOutputSizeChanged() - mFrameBufferTextures[" + i5 + "]:" + this.g[i5]);
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

    @Override // com.youku.opengl.filter.b
    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        List<b> list;
        FloatBuffer floatBuffer3;
        FloatBuffer floatBuffer4;
        h();
        if (!i() || this.f == null || this.g == null || (list = this.e) == null) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            b bVar = this.e.get(i2);
            int i3 = size - 1;
            boolean z = i2 < i3;
            if (z) {
                GLES20.glBindFramebuffer(36160, this.f[i2]);
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            }
            GLES20.glUseProgram(bVar.l());
            if (i2 == 0) {
                bVar.a(i, floatBuffer, floatBuffer2);
            } else {
                if (i2 == i3) {
                    floatBuffer3 = this.h;
                    if (size % 2 == 0) {
                        floatBuffer4 = this.j;
                        bVar.a(i, floatBuffer3, floatBuffer4);
                    }
                } else {
                    floatBuffer3 = this.h;
                }
                floatBuffer4 = this.i;
                bVar.a(i, floatBuffer3, floatBuffer4);
            }
            if (z) {
                GLES20.glBindFramebuffer(36160, 0);
                i = this.g[i2];
            }
            i2++;
        }
    }

    public void a(b bVar) {
        if (com.youku.opengl.a.a.b) {
            String str = this.a;
            com.youku.opengl.a.a.a(str, "addFilter() - aFilter:" + bVar);
        }
        if (bVar == null) {
            return;
        }
        this.d.add(bVar);
        o();
    }

    @Override // com.youku.opengl.filter.b
    public void a(com.youku.opengl.widget.h hVar) {
        super.a(hVar);
        for (b bVar : this.d) {
            bVar.a(hVar);
        }
    }

    @Override // com.youku.opengl.filter.b
    public void a(float[] fArr) {
        List<b> list = this.e;
        if (list != null) {
            for (b bVar : list) {
                if (bVar != null) {
                    bVar.a(fArr);
                }
            }
        }
    }

    @Override // com.youku.opengl.filter.b
    public void f() {
        com.youku.opengl.a.a.a(this.a, "onDestroy()");
        p();
        for (b bVar : this.d) {
            bVar.e();
        }
        super.f();
    }

    public List<b> m() {
        return this.d;
    }

    public List<b> n() {
        return this.e;
    }

    public void o() {
        if (this.d == null) {
            return;
        }
        List<b> list = this.e;
        if (list == null) {
            this.e = new ArrayList();
        } else {
            list.clear();
        }
        for (b bVar : this.d) {
            if (bVar instanceof c) {
                c cVar = (c) bVar;
                cVar.o();
                List<b> n = cVar.n();
                if (n != null && !n.isEmpty()) {
                    this.e.addAll(n);
                }
            } else {
                this.e.add(bVar);
            }
        }
    }
}
