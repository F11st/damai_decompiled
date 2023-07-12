package com.taobao.android.dinamicx.asyncrender;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.C6365b;
import com.taobao.android.dinamicx.C6367d;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.C6380h;
import com.taobao.android.dinamicx.DXPreRenderWorkTask;
import com.taobao.android.dinamicx.DXPrefetchTask;
import com.taobao.android.dinamicx.DXRenderOptions;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DXSimplePrefetchTask;
import com.taobao.android.dinamicx.DXTemplateManager;
import com.taobao.android.dinamicx.asyncrender.batch.DXBatchAsyncRenderCallback;
import com.taobao.android.dinamicx.asyncrender.batch.DXBatchPreRenderWorkTask;
import com.taobao.android.dinamicx.asyncrender.batch.DXBatchPrefetchWorkTask;
import com.taobao.android.dinamicx.asyncrender.batch.DXBatchRenderWorkTask;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.template.download.DXPriorityRunnable;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.youku.arch.v3.data.Constants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import tb.bu;
import tb.nz;
import tb.ry;
import tb.y00;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.asyncrender.a */
/* loaded from: classes11.dex */
public class C6363a extends C6365b {
    public static final int MSG_ASYNC_RENDER = 3;
    public static final int MSG_BATCH_RENDER = 9;
    public static final int MSG_CACHE_MONITOR = 8;
    public static final int MSG_CANCEL_PREFETCH_SIMPLE = 11;
    public static final int MSG_CANCEL_PREFETCH_TASK = 7;
    public static final int MSG_CLEAR_COMPLETED_SIMPLE_TASKS = 13;
    public static final int MSG_CLEAR_EXECUTOR_TASKS = 4;
    public static final int MSG_CLEAR_SIMPLE_TASKS = 12;
    public static final int MSG_CLEAR_TASKS = 5;
    public static final int MSG_PREFETCH = 2;
    public static final int MSG_PREFETCH_SIMPLE = 10;
    public static final int MSG_PRE_RENDER = 1;
    public static final int MSG_RESTORE_EXECUTOR_TASKS = 6;
    private int d;
    private int e;
    private int f;
    private int g;
    private HashMap<String, DXPrefetchTask> h;
    private HashMap<String, DXSimplePrefetchTask> i;
    private boolean j;
    private HandlerC6364a k;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.asyncrender.a$a */
    /* loaded from: classes12.dex */
    public static class HandlerC6364a extends Handler {
        private WeakReference<C6363a> a;

        public HandlerC6364a(C6363a c6363a, Looper looper) {
            super(looper);
            this.a = new WeakReference<>(c6363a);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            C6363a c6363a = this.a.get();
            if (c6363a == null) {
                removeCallbacksAndMessages(null);
                return;
            }
            try {
                switch (message.what) {
                    case 1:
                        ((Runnable) message.obj).run();
                        break;
                    case 2:
                        ((Runnable) message.obj).run();
                        break;
                    case 4:
                        c6363a.n();
                        break;
                    case 5:
                        c6363a.p();
                        break;
                    case 6:
                        c6363a.x();
                        break;
                    case 7:
                        c6363a.k((DXRuntimeContext) message.obj);
                        break;
                    case 8:
                        c6363a.t();
                        break;
                    case 9:
                        ((Runnable) message.obj).run();
                        break;
                    case 10:
                        ((Runnable) message.obj).run();
                        break;
                    case 11:
                        c6363a.l((DXRuntimeContext) message.obj);
                        break;
                    case 12:
                        c6363a.o();
                        break;
                    case 13:
                        c6363a.m();
                        break;
                }
            } catch (Throwable th) {
                ry.b(th);
            }
        }
    }

    public C6363a(@NonNull C6367d c6367d) {
        super(c6367d);
        this.d = -1;
        try {
            this.k = new HandlerC6364a(this, y00.c().getLooper());
        } catch (Throwable th) {
            this.k = new HandlerC6364a(this, Looper.getMainLooper());
            DXAppMonitor.q(this.b, null, "AsyncRender", "Async_Render_3.0_init_Crash", C6368e.V3_ASYNC_RENDER_INIT_CRASH, ry.a(th));
        }
    }

    private void B() {
        Message obtain = Message.obtain();
        obtain.what = 4;
        this.k.sendMessage(obtain);
    }

    private void C() {
        Message obtain = Message.obtain();
        obtain.what = 12;
        this.k.sendMessage(obtain);
    }

    private void D() {
        Message obtain = Message.obtain();
        obtain.what = 5;
        this.k.sendMessage(obtain);
    }

    private void E() {
        Message obtain = Message.obtain();
        obtain.what = 8;
        this.k.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.j = true;
        y00.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        HashMap<String, DXSimplePrefetchTask> hashMap = this.i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        HashMap<String, DXPrefetchTask> hashMap = this.h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    private String q(@NonNull DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext.getWidgetNode() instanceof DXTemplateWidgetNode) {
            return dXRuntimeContext.getCacheIdentifyWithSubData();
        }
        return dXRuntimeContext.getCacheIdentify();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        int i = this.d;
        if (i == 0) {
            return;
        }
        if (i > 0) {
            float f = (i - this.e) / i;
            HashMap hashMap = new HashMap();
            hashMap.put(Constants.TOTAL_NUM, String.valueOf(this.d));
            hashMap.put("cancelNum", String.valueOf(this.e));
            hashMap.put("fillRate", String.valueOf(f));
            DXAppMonitor.m(0, this.b, "PreRender", "PreRender_FillRate", hashMap);
            nz.i("DXAsyncRenderManager", "任务填充率=" + f + "预加载任务创建=" + this.d + "任务取消=" + this.e);
        }
        int i2 = this.f;
        if (i2 > 0) {
            float f2 = this.g / i2;
            HashMap hashMap2 = new HashMap();
            hashMap2.put(Constants.TOTAL_NUM, String.valueOf(this.f));
            hashMap2.put("hitNum", String.valueOf(this.g));
            hashMap2.put("hitRate", String.valueOf(f2));
            DXAppMonitor.m(0, this.b, "PreRender", "PreRender_HitRate", hashMap2);
            nz.i("DXAsyncRenderManager", "缓存命中率=" + f2 + "模板渲染调用次数=" + this.f + "缓存命中的调用次数=" + this.g);
        }
        if (b().i() > 0) {
            float i3 = this.d / b().i();
            HashMap hashMap3 = new HashMap();
            hashMap3.put("maxNum", String.valueOf(b().i()));
            HashMap<String, DXPrefetchTask> hashMap4 = this.h;
            hashMap3.put("taskNum", String.valueOf(hashMap4 != null ? hashMap4.size() : 0));
            hashMap3.put("hitRate", String.valueOf(i3));
            DXAppMonitor.m(0, this.b, "PreRender", "PreRender_OccupationRate", hashMap3);
            nz.i("DXAsyncRenderManager", "缓存利用率=" + i3 + "缓存最大个数限制=" + b().i() + "预加载的创建任务=" + this.d);
        }
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.j) {
            HashMap<String, DXPrefetchTask> hashMap = this.h;
            if (hashMap != null) {
                for (DXPrefetchTask dXPrefetchTask : hashMap.values()) {
                    if (!dXPrefetchTask.isDone) {
                        y00.i(new DXPriorityRunnable(2, dXPrefetchTask));
                    }
                }
            }
            HashMap<String, DXSimplePrefetchTask> hashMap2 = this.i;
            if (hashMap2 != null) {
                for (DXSimplePrefetchTask dXSimplePrefetchTask : hashMap2.values()) {
                    if (!dXSimplePrefetchTask.isDone) {
                        y00.j(new DXPriorityRunnable(2, dXSimplePrefetchTask));
                    }
                }
            }
            this.j = false;
        }
    }

    private void y(DXRuntimeContext dXRuntimeContext) {
        Message obtain = Message.obtain();
        obtain.what = 7;
        obtain.obj = dXRuntimeContext;
        this.k.sendMessage(obtain);
    }

    private void z(DXRuntimeContext dXRuntimeContext) {
        Message obtain = Message.obtain();
        obtain.what = 11;
        obtain.obj = dXRuntimeContext;
        this.k.sendMessage(obtain);
    }

    public void A() {
        Message obtain = Message.obtain();
        obtain.what = 13;
        this.k.sendMessage(obtain);
    }

    public void F(@NonNull Runnable runnable) {
        Message obtain = Message.obtain();
        obtain.what = 10;
        obtain.obj = runnable;
        this.k.sendMessage(obtain);
    }

    public void h(@NonNull List<DXRuntimeContext> list, @NonNull DXRenderOptions dXRenderOptions, @NonNull DXTemplateManager dXTemplateManager, @NonNull C6380h c6380h, @NonNull bu buVar, @Nullable DXBatchAsyncRenderCallback dXBatchAsyncRenderCallback, boolean z) {
        DXBatchRenderWorkTask dXBatchPreRenderWorkTask;
        if (dXRenderOptions.e() == 1) {
            dXBatchPreRenderWorkTask = new DXBatchPrefetchWorkTask(dXTemplateManager, c6380h, buVar, dXRenderOptions, list, dXBatchAsyncRenderCallback, z);
        } else {
            dXBatchPreRenderWorkTask = dXRenderOptions.e() == 2 ? new DXBatchPreRenderWorkTask(dXTemplateManager, c6380h, buVar, dXRenderOptions, list, dXBatchAsyncRenderCallback, z) : null;
        }
        if (dXBatchPreRenderWorkTask != null) {
            dXBatchPreRenderWorkTask.runTasks();
        }
    }

    public void i(DXRuntimeContext dXRuntimeContext) {
        y(dXRuntimeContext);
    }

    public void j(DXRuntimeContext dXRuntimeContext) {
        z(dXRuntimeContext);
    }

    public void k(DXRuntimeContext dXRuntimeContext) {
        DXPrefetchTask dXPrefetchTask;
        this.f++;
        HashMap<String, DXPrefetchTask> hashMap = this.h;
        if (hashMap == null || (dXPrefetchTask = hashMap.get(dXRuntimeContext.getCacheIdentify())) == null) {
            return;
        }
        if (!dXPrefetchTask.isDone) {
            dXPrefetchTask.options.k(true);
            dXPrefetchTask.isDone = true;
            this.e++;
        } else if (dXPrefetchTask.options.i()) {
        } else {
            this.g++;
        }
    }

    public void l(DXRuntimeContext dXRuntimeContext) {
        DXSimplePrefetchTask remove;
        HashMap<String, DXSimplePrefetchTask> hashMap = this.i;
        if (hashMap == null || (remove = hashMap.remove(q(dXRuntimeContext))) == null) {
            return;
        }
        remove.cancel();
    }

    public void m() {
        if (this.i != null) {
            HashSet<String> hashSet = new HashSet();
            for (Map.Entry<String, DXSimplePrefetchTask> entry : this.i.entrySet()) {
                if (entry.getValue().isDone) {
                    hashSet.add(entry.getKey());
                }
            }
            for (String str : hashSet) {
                this.i.remove(str);
            }
        }
    }

    public void r() {
        if (this.d == -1) {
            return;
        }
        B();
    }

    public void s(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, DXTemplateManager dXTemplateManager, C6380h c6380h, bu buVar) {
        y00.h(new DXPriorityRunnable(0, new DXPreRenderWorkTask(dXRuntimeContext, dXRenderOptions, dXTemplateManager, c6380h, this.c, buVar)));
    }

    public void u(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, DXTemplateManager dXTemplateManager, C6380h c6380h, bu buVar) {
        if (this.h == null) {
            this.h = new HashMap<>(100);
        }
        if (this.h.containsKey(dXRuntimeContext.getCacheIdentify())) {
            return;
        }
        if (this.d == -1) {
            this.d = 0;
        }
        DXPrefetchTask dXPrefetchTask = new DXPrefetchTask(dXRuntimeContext, dXRenderOptions, dXTemplateManager, c6380h, this.c, buVar);
        y00.i(new DXPriorityRunnable(2, dXPrefetchTask));
        this.h.put(dXRuntimeContext.getCacheIdentify(), dXPrefetchTask);
        this.d++;
    }

    public void v(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, C6380h c6380h, View view, DXAsyncRenderCallback<DXRuntimeContext> dXAsyncRenderCallback) {
        if (this.i == null) {
            this.i = new HashMap<>();
        }
        String q = q(dXRuntimeContext);
        if (this.i.containsKey(q)) {
            return;
        }
        DXSimplePrefetchTask dXSimplePrefetchTask = new DXSimplePrefetchTask(dXRuntimeContext, dXRenderOptions, this.c, c6380h, view, dXAsyncRenderCallback);
        y00.j(new DXPriorityRunnable(2, dXSimplePrefetchTask));
        this.i.put(q, dXSimplePrefetchTask);
    }

    public void w() {
        if (this.d == -1) {
            return;
        }
        E();
        B();
        D();
        C();
    }
}
