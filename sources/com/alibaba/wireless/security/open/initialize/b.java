package com.alibaba.wireless.security.open.initialize;

import android.content.Context;
import com.alibaba.wireless.security.framework.ApmMonitorAdapter;
import com.alibaba.wireless.security.framework.ISGPluginManager;
import com.alibaba.wireless.security.framework.SGApmMonitorManager;
import com.alibaba.wireless.security.framework.d;
import com.alibaba.wireless.security.framework.utils.FLOG;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;
import java.util.HashSet;
import java.util.Set;
import tb.lu2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class b {
    private Set<IInitializeComponent.IInitFinishListener> a;
    private Object b;
    private String c;
    private ISGPluginManager d;
    boolean e;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;
        final /* synthetic */ boolean d;

        a(Context context, String str, boolean z, boolean z2) {
            this.a = context;
            this.b = str;
            this.c = z;
            this.d = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b.this.b(this.a, this.b, this.c, this.d);
            } catch (SecException e) {
                e.printStackTrace();
                b.this.b();
            }
        }
    }

    public b() {
        this.a = new HashSet();
        this.b = new Object();
        this.c = null;
        this.d = null;
        this.e = false;
    }

    public b(String str) {
        this.a = new HashSet();
        this.b = new Object();
        this.c = null;
        this.d = null;
        this.e = false;
        this.c = str;
    }

    private void a(boolean z) {
        for (IInitializeComponent.IInitFinishListener iInitFinishListener : this.a) {
            if (z) {
                iInitFinishListener.onSuccess();
            } else {
                iInitFinishListener.onError();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        synchronized (this.b) {
            for (IInitializeComponent.IInitFinishListener iInitFinishListener : this.a) {
                iInitFinishListener.onError();
            }
        }
    }

    private void c() {
        for (IInitializeComponent.IInitFinishListener iInitFinishListener : this.a) {
            if (iInitFinishListener instanceof IInitializeComponent.IInitFinishListenerV2) {
                ((IInitializeComponent.IInitFinishListenerV2) iInitFinishListener).onStart();
            }
        }
    }

    public ISGPluginManager a() {
        return this.d;
    }

    public void a(Context context, String str, boolean z, boolean z2) throws SecException {
        if (context == null) {
            throw new SecException(101);
        }
        new Thread(new a(context, str, z, z2), "SGloadLibraryAsync").start();
    }

    public void a(IInitializeComponent.IInitFinishListener iInitFinishListener) throws SecException {
        if (iInitFinishListener != null) {
            synchronized (this.b) {
                this.a.add(iInitFinishListener);
            }
        }
    }

    public boolean a(Context context) throws SecException {
        return true;
    }

    public int b(Context context, String str, boolean z, boolean z2) throws SecException {
        synchronized (this.b) {
            if (!this.e) {
                c();
                if (context == null) {
                    throw new SecException(101);
                }
                SGApmMonitorManager.getInstance().init(context);
                SGApmMonitorManager.getInstance().monitorStart("plugin");
                SGApmMonitorManager.getInstance().monitorStart("getInstance");
                SGApmMonitorManager.getInstance().monitorStartWithTimeout("firstBizRequest", 10000);
                long j = FLOG.get_currentTime();
                ApmMonitorAdapter.jstageStart(lu2.MAIN, "1");
                d dVar = new d();
                dVar.a(context, this.c, str, z, new Object[0]);
                SGApmMonitorManager.getInstance().setSGPluginManager(dVar);
                ApmMonitorAdapter.jstageEnd(lu2.MAIN, "1");
                FLOG.printTimeCost(lu2.MAIN, "pluginMgr.init", "", j);
                dVar.getPluginInfo(dVar.getMainPluginName());
                FLOG.printTimeCost(lu2.MAIN, "getInstance", "", j);
                SGApmMonitorManager.getInstance().monitorEnd("getInstance");
                this.d = dVar;
                this.e = true;
                a(true);
            }
        }
        return !this.e ? 1 : 0;
    }
}
