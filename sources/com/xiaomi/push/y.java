package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class y implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private File f1010a;

    /* renamed from: a  reason: collision with other field name */
    private Runnable f1011a;

    private y(Context context, File file) {
        this.a = context;
        this.f1010a = file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ y(Context context, File file, z zVar) {
        this(context, file);
    }

    public static void a(Context context, File file, Runnable runnable) {
        new z(context, file, runnable).run();
    }

    protected abstract void a(Context context);

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = null;
        try {
            try {
                if (this.f1010a == null) {
                    this.f1010a = new File(this.a.getFilesDir(), "default_locker");
                }
                xVar = x.a(this.a, this.f1010a);
                Runnable runnable = this.f1011a;
                if (runnable != null) {
                    runnable.run();
                }
                a(this.a);
                if (xVar == null) {
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (xVar == null) {
                    return;
                }
            }
            xVar.a();
        } catch (Throwable th) {
            if (xVar != null) {
                xVar.a();
            }
            throw th;
        }
    }
}
