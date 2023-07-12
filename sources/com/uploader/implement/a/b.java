package com.uploader.implement.a;

import android.os.Handler;
import com.uploader.export.ITaskListener;
import com.uploader.export.ITaskResult;
import com.uploader.export.IUploaderTask;
import tb.fl2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class b implements Runnable {
    final ITaskListener a;
    final IUploaderTask b;
    final Object c;
    final int d;

    private b(int i, IUploaderTask iUploaderTask, ITaskListener iTaskListener, Object obj) {
        this.d = i;
        this.b = iUploaderTask;
        this.a = iTaskListener;
        this.c = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Handler handler, int i, IUploaderTask iUploaderTask, ITaskListener iTaskListener, Object obj) {
        if (iTaskListener == null) {
            return;
        }
        b bVar = new b(i, iUploaderTask, iTaskListener, obj);
        if (handler == null) {
            com.uploader.implement.e.b.a(bVar);
        } else {
            handler.post(bVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        switch (this.d) {
            case 0:
                this.a.onSuccess(this.b, (ITaskResult) this.c);
                return;
            case 1:
                this.a.onCancel(this.b);
                return;
            case 2:
                this.a.onFailure(this.b, (fl2) this.c);
                return;
            case 3:
                this.a.onProgress(this.b, ((Integer) this.c).intValue());
                return;
            case 4:
                this.a.onPause(this.b);
                return;
            case 5:
                this.a.onStart(this.b);
                return;
            case 6:
                this.a.onResume(this.b);
                return;
            case 7:
                this.a.onWait(this.b);
                return;
            default:
                return;
        }
    }
}
