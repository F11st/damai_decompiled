package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.y */
/* loaded from: classes11.dex */
public abstract class AbstractRunnableC7790y implements Runnable {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private File f1010a;

    /* renamed from: a  reason: collision with other field name */
    private Runnable f1011a;

    private AbstractRunnableC7790y(Context context, File file) {
        this.a = context;
        this.f1010a = file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ AbstractRunnableC7790y(Context context, File file, C7791z c7791z) {
        this(context, file);
    }

    public static void a(Context context, File file, Runnable runnable) {
        new C7791z(context, file, runnable).run();
    }

    protected abstract void a(Context context);

    @Override // java.lang.Runnable
    public final void run() {
        C7789x c7789x = null;
        try {
            try {
                if (this.f1010a == null) {
                    this.f1010a = new File(this.a.getFilesDir(), "default_locker");
                }
                c7789x = C7789x.a(this.a, this.f1010a);
                Runnable runnable = this.f1011a;
                if (runnable != null) {
                    runnable.run();
                }
                a(this.a);
                if (c7789x == null) {
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (c7789x == null) {
                    return;
                }
            }
            c7789x.a();
        } catch (Throwable th) {
            if (c7789x != null) {
                c7789x.a();
            }
            throw th;
        }
    }
}
