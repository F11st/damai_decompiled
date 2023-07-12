package tb;

import android.app.Activity;
import com.taobao.monitor.impl.processor.IProcessor;
import com.taobao.monitor.impl.processor.launcher.LauncherProcessor;
import com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class i81 implements IProcessor.IProcessorLifeCycle, ActivityLifeCycleDispatcher.IActivityLifeCycle {
    private LauncherProcessor a = null;
    private int b = 0;
    private int c = 0;
    private final j81 d = new j81();

    private LauncherProcessor a(boolean z) {
        if (z) {
            return this.d.a(null);
        }
        return this.d.createProcessor();
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityCreated(Activity activity, Map<String, Object> map, long j) {
        Object obj = map.get("outLink");
        if (this.b == 0) {
            LauncherProcessor a = a(obj != null);
            this.a = a;
            if (a != null) {
                a.c(this);
            }
        }
        LauncherProcessor launcherProcessor = this.a;
        if (launcherProcessor != null) {
            launcherProcessor.onActivityCreated(activity, map, j);
        }
        this.b++;
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityDestroyed(Activity activity, long j) {
        LauncherProcessor launcherProcessor = this.a;
        if (launcherProcessor != null) {
            launcherProcessor.onActivityDestroyed(activity, j);
        }
        int i = this.b - 1;
        this.b = i;
        if (i == 0) {
            v6 v6Var = new v6();
            LauncherProcessor.S = LauncherProcessor.WARM;
            LauncherProcessor.T = true;
            v6Var.d(LauncherProcessor.WARM);
            LauncherProcessor.U = "activityKilled";
        }
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityPaused(Activity activity, long j) {
        LauncherProcessor launcherProcessor = this.a;
        if (launcherProcessor != null) {
            launcherProcessor.onActivityPaused(activity, j);
        }
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityResumed(Activity activity, long j) {
        LauncherProcessor launcherProcessor = this.a;
        if (launcherProcessor != null) {
            launcherProcessor.onActivityResumed(activity, j);
        }
        if ("com.taobao.tao.welcome.Welcome".equals(m3.b(activity))) {
            lu0.c = true;
        }
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityStarted(Activity activity, long j) {
        int i = this.c + 1;
        this.c = i;
        if (i == 1 && this.a == null) {
            LauncherProcessor a = this.d.a(LauncherProcessor.HOT);
            this.a = a;
            if (a != null) {
                a.c(this);
            }
        }
        LauncherProcessor launcherProcessor = this.a;
        if (launcherProcessor != null) {
            launcherProcessor.onActivityStarted(activity, j);
        }
    }

    @Override // com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher.IActivityLifeCycle
    public void onActivityStopped(Activity activity, long j) {
        this.c--;
        LauncherProcessor launcherProcessor = this.a;
        if (launcherProcessor != null) {
            launcherProcessor.onActivityStopped(activity, j);
        }
    }

    @Override // com.taobao.monitor.impl.processor.IProcessor.IProcessorLifeCycle
    public void processorOnEnd(IProcessor iProcessor) {
        this.a = null;
    }

    @Override // com.taobao.monitor.impl.processor.IProcessor.IProcessorLifeCycle
    public void processorOnStart(IProcessor iProcessor) {
    }
}
