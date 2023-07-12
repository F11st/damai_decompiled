package com.taobao.android.lifecycle;

import android.app.Activity;
import android.os.Build;
import android.os.Debug;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.content.ContextCompat;
import com.taobao.android.lifecycle.PanguApplication;
import com.taobao.android.task.Coordinator;
import com.uc.webview.export.extension.UCCore;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.NonNullByDefault;
import javax.annotation.Nullable;
import tb.s40;

/* compiled from: Taobao */
@NonNullByDefault
/* loaded from: classes12.dex */
public abstract class PanguInitializers {
    @Nullable
    protected PanguApplication mApplication;
    protected String mPackageName;
    protected String mProcessName;
    protected String[] mPermission = null;
    protected final SparseArray<ArrayList<Method>> mSyncInitializers = new SparseArray<>();
    protected final ArrayList<Method> mAsyncInitializers = new ArrayList<>();
    protected final ArrayList<Method> mDelayedInitializers = new ArrayList<>();
    protected final AtomicInteger mMethodCount = new AtomicInteger();
    protected final SparseArray<SparseArray<CopyOnWriteArrayList<Method>>> mGlobalFlowInitializers = new SparseArray<>();
    protected final SparseArray<SparseArray<CopyOnWriteArrayList<Method>>> mUIFlowInitializers = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes12.dex */
    public @interface Async {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes12.dex */
    public @interface Delayed {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes12.dex */
    public @interface Flow {
        int value() default 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes12.dex */
    public @interface Global {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes12.dex */
    public @interface Permission {
        String[] value() default {};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes12.dex */
    public @interface Priority {
        int value();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes12.dex */
    public @interface Process {
        String[] value() default {};
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class UnqualifiedInitializerError extends Error {
        private static final long serialVersionUID = 1;

        public UnqualifiedInitializerError(String str) {
            super(str);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements PanguApplication.CrossActivityLifecycleCallback {
        final /* synthetic */ PanguApplication a;

        a(PanguApplication panguApplication) {
            this.a = panguApplication;
        }

        @Override // com.taobao.android.lifecycle.PanguApplication.CrossActivityLifecycleCallback
        public void onCreated(Activity activity) {
            PanguInitializers.this.doInitOnFistActivityCreate(activity);
            PanguInitializers.this.startInitializersAnnotatedBy(null);
        }

        @Override // com.taobao.android.lifecycle.PanguApplication.CrossActivityLifecycleCallback
        public void onDestroyed(Activity activity) {
        }

        @Override // com.taobao.android.lifecycle.PanguApplication.CrossActivityLifecycleCallback
        public void onStarted(Activity activity) {
            PanguInitializers.this.doInitOnFistActivityStarted(activity);
            this.a.unregisterCrossActivityLifecycleCallback(this);
            Coordinator.scheduleIdleTasks();
        }

        @Override // com.taobao.android.lifecycle.PanguApplication.CrossActivityLifecycleCallback
        public void onStopped(Activity activity) {
        }
    }

    public PanguInitializers(String str, String str2) {
        this.mProcessName = str;
        this.mPackageName = str2;
    }

    protected void doInitOnFistActivityCreate(Activity activity) {
    }

    protected void doInitOnFistActivityStarted(Activity activity) {
    }

    protected PanguApplication getApplication() {
        return this.mApplication;
    }

    @Nullable
    protected Method getInitializer(String str) {
        String str2 = UCCore.LEGACY_EVENT_INIT + str;
        Iterator<Method> it = this.mAsyncInitializers.iterator();
        while (it.hasNext()) {
            Method next = it.next();
            if (str2.equals(next.getName())) {
                return next;
            }
        }
        Iterator<Method> it2 = this.mDelayedInitializers.iterator();
        while (it2.hasNext()) {
            Method next2 = it2.next();
            if (str2.equals(next2.getName())) {
                return next2;
            }
        }
        for (int i = 0; i < this.mSyncInitializers.size(); i++) {
            Iterator<Method> it3 = this.mSyncInitializers.valueAt(i).iterator();
            while (it3.hasNext()) {
                Method next3 = it3.next();
                if (str2.equals(next3.getName())) {
                    return next3;
                }
            }
        }
        if (s40.b()) {
            throw new NoSuchMethodError(str2 + " (used in @Require)");
        }
        return null;
    }

    protected void invokeInitializer(Method method) {
        Permission permission;
        if (Build.VERSION.SDK_INT >= 23 && (permission = (Permission) method.getAnnotation(Permission.class)) != null) {
            for (String str : permission.value()) {
                if (ContextCompat.checkSelfPermission(this.mApplication, str) != 0) {
                    return;
                }
            }
        }
        long nanoTime = System.nanoTime();
        long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
        try {
            try {
                method.invoke(this, new Object[0]);
            } catch (Exception e) {
                if (!s40.b()) {
                    onInitializerException(method, e);
                } else {
                    onInitializerException(method, e);
                }
                Log.e("Pangu", "invoke exception:" + method.getName(), e);
                onInitializerTimeing(method.getName().substring(4), (Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000, (System.nanoTime() - nanoTime) / 1000000);
                if (this.mMethodCount.decrementAndGet() != 0) {
                }
            } catch (Throwable th) {
                Log.e("Pangu", "invoke throwable:" + method.getName(), th);
                onInitializerTimeing(method.getName().substring(4), (Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000, (System.nanoTime() - nanoTime) / 1000000);
                if (this.mMethodCount.decrementAndGet() != 0) {
                }
            }
        } finally {
            onInitializerTimeing(method.getName().substring(4), (Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000, (System.nanoTime() - nanoTime) / 1000000);
            if (this.mMethodCount.decrementAndGet() == 0) {
                onInitializerFinish();
            }
        }
    }

    public abstract void onInitializerException(Method method, Exception exc);

    public void onInitializerFinish() {
    }

    public void onInitializerTimeing(String str, long j, long j2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void parse() {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.lifecycle.PanguInitializers.parse():void");
    }

    public void start(PanguApplication panguApplication) {
        this.mApplication = panguApplication;
        Coordinator.runTask(new Coordinator.TaggedRunnable("initPanguParse") { // from class: com.taobao.android.lifecycle.PanguInitializers.1
            @Override // java.lang.Runnable
            public void run() {
                PanguInitializers.this.parse();
            }
        });
        startInitializersAnnotatedBy(Global.class);
        panguApplication.registerCrossActivityLifecycleCallback(new a(panguApplication));
    }

    protected void startInitializersAnnotatedBy(@Nullable Class<? extends Annotation> cls) {
        Iterator<Method> it = this.mAsyncInitializers.iterator();
        while (it.hasNext()) {
            final Method next = it.next();
            if (cls == null || next.isAnnotationPresent(cls)) {
                Coordinator.postTask(new Coordinator.TaggedRunnable(next.getName()) { // from class: com.taobao.android.lifecycle.PanguInitializers.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PanguInitializers.this.invokeInitializer(next);
                    }
                });
                it.remove();
            }
        }
        if (cls == null) {
            for (int i = 0; i < this.mUIFlowInitializers.size(); i++) {
                final int keyAt = this.mUIFlowInitializers.keyAt(i);
                Coordinator.postTask(new Coordinator.TaggedRunnable("UIFlow" + i) { // from class: com.taobao.android.lifecycle.PanguInitializers.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SparseArray<CopyOnWriteArrayList<Method>> sparseArray = PanguInitializers.this.mUIFlowInitializers.get(keyAt);
                        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                            CopyOnWriteArrayList<Method> copyOnWriteArrayList = sparseArray.get(sparseArray.keyAt(i2));
                            for (final Method method : copyOnWriteArrayList) {
                                copyOnWriteArrayList.remove(method);
                                Coordinator.runTask(new Coordinator.TaggedRunnable(method.getName()) { // from class: com.taobao.android.lifecycle.PanguInitializers.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        PanguInitializers.this.invokeInitializer(method);
                                    }
                                });
                            }
                        }
                    }
                });
            }
        } else {
            for (int i2 = 0; i2 < this.mGlobalFlowInitializers.size(); i2++) {
                final int keyAt2 = this.mGlobalFlowInitializers.keyAt(i2);
                Coordinator.postTask(new Coordinator.TaggedRunnable("GlobalFlow" + i2) { // from class: com.taobao.android.lifecycle.PanguInitializers.5
                    @Override // java.lang.Runnable
                    public void run() {
                        SparseArray<CopyOnWriteArrayList<Method>> sparseArray = PanguInitializers.this.mGlobalFlowInitializers.get(keyAt2);
                        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                            CopyOnWriteArrayList<Method> copyOnWriteArrayList = sparseArray.get(sparseArray.keyAt(i3));
                            for (final Method method : copyOnWriteArrayList) {
                                copyOnWriteArrayList.remove(method);
                                Coordinator.runTask(new Coordinator.TaggedRunnable(method.getName()) { // from class: com.taobao.android.lifecycle.PanguInitializers.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        PanguInitializers.this.invokeInitializer(method);
                                    }
                                });
                            }
                        }
                    }
                });
            }
        }
        for (int i3 = 0; i3 < this.mSyncInitializers.size(); i3++) {
            Iterator<Method> it2 = this.mSyncInitializers.get(this.mSyncInitializers.keyAt(i3)).iterator();
            while (it2.hasNext()) {
                final Method next2 = it2.next();
                if (cls == null || next2.isAnnotationPresent(cls)) {
                    Coordinator.runTask(new Coordinator.TaggedRunnable(next2.getName()) { // from class: com.taobao.android.lifecycle.PanguInitializers.6
                        @Override // java.lang.Runnable
                        public void run() {
                            PanguInitializers.this.invokeInitializer(next2);
                        }
                    });
                    it2.remove();
                }
            }
        }
        Iterator<Method> it3 = this.mDelayedInitializers.iterator();
        while (it3.hasNext()) {
            final Method next3 = it3.next();
            if (cls == null || next3.isAnnotationPresent(cls)) {
                Coordinator.postIdleTask(new Coordinator.TaggedRunnable(next3.getName()) { // from class: com.taobao.android.lifecycle.PanguInitializers.7
                    @Override // java.lang.Runnable
                    public void run() {
                        PanguInitializers.this.invokeInitializer(next3);
                    }
                });
                it3.remove();
            }
        }
    }

    public PanguInitializers withPermission(String[] strArr) {
        this.mPermission = strArr;
        return this;
    }
}
