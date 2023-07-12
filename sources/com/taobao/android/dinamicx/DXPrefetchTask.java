package com.taobao.android.dinamicx;

import com.taobao.android.dinamicx.asyncrender.DXAsyncRenderCallback;
import com.taobao.android.dinamicx.asyncrender.DXBaseRenderWorkTask;
import tb.bu;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXPrefetchTask extends DXBaseRenderWorkTask {
    private final DXAsyncRenderCallback<Void> callback;

    public DXPrefetchTask(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, DXTemplateManager dXTemplateManager, C6380h c6380h, C6367d c6367d, bu buVar) {
        this(dXRuntimeContext, dXRenderOptions, dXTemplateManager, c6380h, c6367d, buVar, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0056 A[Catch: all -> 0x00c4, TryCatch #0 {all -> 0x00c4, blocks: (B:3:0x0004, B:5:0x000e, B:10:0x0037, B:12:0x0056, B:14:0x0071, B:16:0x0077, B:17:0x00a6, B:19:0x00aa, B:21:0x00b2, B:22:0x00bb, B:9:0x001f), top: B:29:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa A[Catch: all -> 0x00c4, TryCatch #0 {all -> 0x00c4, blocks: (B:3:0x0004, B:5:0x000e, B:10:0x0037, B:12:0x0056, B:14:0x0071, B:16:0x0077, B:17:0x00a6, B:19:0x00aa, B:21:0x00b2, B:22:0x00bb, B:9:0x001f), top: B:29:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @Override // com.taobao.android.dinamicx.asyncrender.DXBaseRenderWorkTask, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r9 = this;
            super.run()
            r0 = 1
            java.lang.ThreadLocal<com.taobao.android.dinamicx.DXRenderPipeline> r1 = com.taobao.android.dinamicx.asyncrender.DXBaseRenderWorkTask.pipelineThreadLocal     // Catch: java.lang.Throwable -> Lc4
            java.lang.Object r1 = r1.get()     // Catch: java.lang.Throwable -> Lc4
            com.taobao.android.dinamicx.DXRenderPipeline r1 = (com.taobao.android.dinamicx.DXRenderPipeline) r1     // Catch: java.lang.Throwable -> Lc4
            if (r1 == 0) goto L1f
            com.taobao.android.dinamicx.DXEngineConfig r2 = r9.config     // Catch: java.lang.Throwable -> Lc4
            long r2 = r2.c     // Catch: java.lang.Throwable -> Lc4
            com.taobao.android.dinamicx.DXEngineConfig r4 = r1.b()     // Catch: java.lang.Throwable -> Lc4
            long r4 = r4.c     // Catch: java.lang.Throwable -> Lc4
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L1d
            goto L1f
        L1d:
            r3 = r1
            goto L37
        L1f:
            com.taobao.android.dinamicx.DXTemplateManager r1 = new com.taobao.android.dinamicx.DXTemplateManager     // Catch: java.lang.Throwable -> Lc4
            com.taobao.android.dinamicx.d r2 = r9.engineContext     // Catch: java.lang.Throwable -> Lc4
            android.content.Context r3 = com.taobao.android.dinamicx.DinamicXEngine.i()     // Catch: java.lang.Throwable -> Lc4
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> Lc4
            com.taobao.android.dinamicx.DXRenderPipeline r2 = new com.taobao.android.dinamicx.DXRenderPipeline     // Catch: java.lang.Throwable -> Lc4
            com.taobao.android.dinamicx.d r3 = r9.engineContext     // Catch: java.lang.Throwable -> Lc4
            r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> Lc4
            java.lang.ThreadLocal<com.taobao.android.dinamicx.DXRenderPipeline> r1 = com.taobao.android.dinamicx.asyncrender.DXBaseRenderWorkTask.pipelineThreadLocal     // Catch: java.lang.Throwable -> Lc4
            r1.set(r2)     // Catch: java.lang.Throwable -> Lc4
            r3 = r2
        L37:
            com.taobao.android.dinamicx.DinamicXEngine.x()     // Catch: java.lang.Throwable -> Lc4
            com.taobao.android.dinamicx.DXRuntimeContext r1 = r9.runtimeContext     // Catch: java.lang.Throwable -> Lc4
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch: java.lang.Throwable -> Lc4
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lc4
            r1.setDxRenderPipeline(r2)     // Catch: java.lang.Throwable -> Lc4
            r4 = 0
            r5 = 0
            r6 = 0
            com.taobao.android.dinamicx.DXRuntimeContext r7 = r9.runtimeContext     // Catch: java.lang.Throwable -> Lc4
            com.taobao.android.dinamicx.DXRenderOptions r8 = r9.options     // Catch: java.lang.Throwable -> Lc4
            r3.r(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lc4
            r9.isDone = r0     // Catch: java.lang.Throwable -> Lc4
            boolean r1 = com.taobao.android.dinamicx.DinamicXEngine.x()     // Catch: java.lang.Throwable -> Lc4
            if (r1 == 0) goto La6
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r3 = "prefetchTemplate desc : \n"
            r4 = 0
            r2[r4] = r3     // Catch: java.lang.Throwable -> Lc4
            com.taobao.android.dinamicx.DXRuntimeContext r3 = r9.runtimeContext     // Catch: java.lang.Throwable -> Lc4
            tb.d00 r3 = r3.getDxPerformInfo()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lc4
            r2[r0] = r3     // Catch: java.lang.Throwable -> Lc4
            tb.nz.q(r2)     // Catch: java.lang.Throwable -> Lc4
            com.taobao.android.dinamicx.DXRuntimeContext r2 = r9.runtimeContext     // Catch: java.lang.Throwable -> Lc4
            if (r2 == 0) goto La6
            com.taobao.android.dinamicx.template.download.DXTemplateItem r2 = r2.getDxTemplateItem()     // Catch: java.lang.Throwable -> Lc4
            if (r2 == 0) goto La6
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r3 = "prefetchTemplate end "
            r2[r4] = r3     // Catch: java.lang.Throwable -> Lc4
            com.taobao.android.dinamicx.DXRuntimeContext r3 = r9.runtimeContext     // Catch: java.lang.Throwable -> Lc4
            com.taobao.android.dinamicx.template.download.DXTemplateItem r3 = r3.getDxTemplateItem()     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r3 = r3.name     // Catch: java.lang.Throwable -> Lc4
            r2[r0] = r3     // Catch: java.lang.Throwable -> Lc4
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc4
            r3.<init>()     // Catch: java.lang.Throwable -> Lc4
            com.taobao.android.dinamicx.DXRuntimeContext r4 = r9.runtimeContext     // Catch: java.lang.Throwable -> Lc4
            com.taobao.android.dinamicx.template.download.DXTemplateItem r4 = r4.getDxTemplateItem()     // Catch: java.lang.Throwable -> Lc4
            long r4 = r4.version     // Catch: java.lang.Throwable -> Lc4
            r3.append(r4)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r4 = "\n "
            r3.append(r4)     // Catch: java.lang.Throwable -> Lc4
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lc4
            r2[r1] = r3     // Catch: java.lang.Throwable -> Lc4
            tb.nz.q(r2)     // Catch: java.lang.Throwable -> Lc4
        La6:
            com.taobao.android.dinamicx.asyncrender.DXAsyncRenderCallback<java.lang.Void> r1 = r9.callback     // Catch: java.lang.Throwable -> Lc4
            if (r1 == 0) goto Ld6
            com.taobao.android.dinamicx.DXRuntimeContext r1 = r9.runtimeContext     // Catch: java.lang.Throwable -> Lc4
            boolean r1 = r1.hasError()     // Catch: java.lang.Throwable -> Lc4
            if (r1 == 0) goto Lbb
            com.taobao.android.dinamicx.DXPrefetchTask$1 r1 = new com.taobao.android.dinamicx.DXPrefetchTask$1     // Catch: java.lang.Throwable -> Lc4
            r1.<init>()     // Catch: java.lang.Throwable -> Lc4
            tb.y00.o(r1)     // Catch: java.lang.Throwable -> Lc4
            goto Ld6
        Lbb:
            com.taobao.android.dinamicx.DXPrefetchTask$2 r1 = new com.taobao.android.dinamicx.DXPrefetchTask$2     // Catch: java.lang.Throwable -> Lc4
            r1.<init>()     // Catch: java.lang.Throwable -> Lc4
            tb.y00.o(r1)     // Catch: java.lang.Throwable -> Lc4
            goto Ld6
        Lc4:
            r1 = move-exception
            tb.ry.b(r1)
            r9.isFailed = r0
            com.taobao.android.dinamicx.asyncrender.DXAsyncRenderCallback<java.lang.Void> r0 = r9.callback
            if (r0 == 0) goto Ld6
            com.taobao.android.dinamicx.DXPrefetchTask$3 r0 = new com.taobao.android.dinamicx.DXPrefetchTask$3
            r0.<init>()
            tb.y00.o(r0)
        Ld6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.DXPrefetchTask.run():void");
    }

    public DXPrefetchTask(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, DXTemplateManager dXTemplateManager, C6380h c6380h, C6367d c6367d, bu buVar, DXAsyncRenderCallback<Void> dXAsyncRenderCallback) {
        super(dXRuntimeContext, dXRenderOptions, dXTemplateManager, c6380h, c6367d, buVar);
        this.callback = dXAsyncRenderCallback;
    }
}
