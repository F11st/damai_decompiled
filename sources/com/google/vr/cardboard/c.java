package com.google.vr.cardboard;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Choreographer;
import com.google.devtools.build.android.desugar.runtime.ThrowableExtension;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class c implements Handler.Callback, Choreographer.FrameCallback {
    private static final String f = c.class.getSimpleName();
    private final Choreographer.FrameCallback a;
    private final HandlerThread b;
    private Handler c;
    private Choreographer d;
    private boolean e;

    public c(Choreographer.FrameCallback frameCallback) {
        this(null, frameCallback);
    }

    public void a() {
        this.b.start();
        Handler handler = new Handler(this.b.getLooper(), this);
        this.c = handler;
        handler.sendEmptyMessage(0);
    }

    public void b() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.c.sendEmptyMessage(2);
    }

    public void c() {
        if (this.e) {
            this.e = false;
            this.c.sendEmptyMessage(1);
        }
    }

    public void d() {
        b();
        this.b.quitSafely();
        try {
            this.b.join();
        } catch (InterruptedException e) {
            Log.e(f, "Interrupted when shutting down FrameMonitor.");
            ThrowableExtension.printStackTrace(e);
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        this.a.doFrame(j);
        this.d.postFrameCallback(this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            if (this.d == null) {
                this.d = Choreographer.getInstance();
            }
            this.d.postFrameCallback(this);
            return true;
        } else if (i == 1) {
            this.d.postFrameCallback(this);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            this.d.removeFrameCallback(this);
            return true;
        }
    }

    public c(Choreographer choreographer, Choreographer.FrameCallback frameCallback) {
        this.a = frameCallback;
        this.d = choreographer;
        this.b = new HandlerThread("FrameMonitor");
    }
}
