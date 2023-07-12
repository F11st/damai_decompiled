package com.alibaba.aliweex.plugin;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class WorkFlow$Flow {

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.plugin.WorkFlow$Flow$1  reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ WorkFlow$Flow this$0;

        AnonymousClass1(WorkFlow$Flow workFlow$Flow) {
        }

        @Override // java.lang.Runnable
        public void run() {
            WorkFlow$Flow.a(this.this$0);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface CancelListener {
        void onCancel();
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface Cancelable {
        boolean cancel();
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface CompleteListener {
        void onComplete();
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface ErrorListener {
        void onError(Throwable th);
    }

    static /* synthetic */ void a(WorkFlow$Flow workFlow$Flow) {
        throw null;
    }
}
