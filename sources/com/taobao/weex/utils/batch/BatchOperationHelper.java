package com.taobao.weex.utils.batch;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class BatchOperationHelper implements Interceptor {
    private BactchExecutor a;
    private CopyOnWriteArrayList<Runnable> b = new CopyOnWriteArrayList<>();
    private boolean c;

    public BatchOperationHelper(BactchExecutor bactchExecutor) {
        this.c = false;
        this.a = bactchExecutor;
        bactchExecutor.setInterceptor(this);
        this.c = true;
    }

    public void flush() {
        this.c = false;
        this.a.post(new Runnable() { // from class: com.taobao.weex.utils.batch.BatchOperationHelper.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = BatchOperationHelper.this.b.iterator();
                while (it.hasNext()) {
                    Runnable runnable = (Runnable) it.next();
                    runnable.run();
                    BatchOperationHelper.this.b.remove(runnable);
                }
            }
        });
        this.a.setInterceptor(null);
    }

    @Override // com.taobao.weex.utils.batch.Interceptor
    public boolean take(Runnable runnable) {
        if (this.c) {
            this.b.add(runnable);
            return true;
        }
        return false;
    }
}
