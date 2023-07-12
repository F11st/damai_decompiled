package com.alibaba.pictures.piclocation;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.pictures.piclocation.listener.LocateGpsPicListener;
import com.alibaba.pictures.piclocation.listener.LocateRegionPicListener;
import com.alibaba.pictures.piclocation.mtop.LocationRequestDelegate;
import com.alibaba.pictures.piclocation.mtop.RegionRequestHandler;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ga1;
import tb.k12;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class LocateQueueManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final a Companion = new a(null);
    private static boolean i = true;
    @Nullable
    private static LocateQueueManager j;
    private final AtomicBoolean a;
    private long b;
    private final List<LocateGpsPicListener> c;
    private final List<LocateRegionPicListener> d;
    private LocationInterface e;
    private boolean f;
    private Handler g;
    @Nullable
    private LocationRequestDelegate h;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        @Nullable
        public final LocateQueueManager a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "836604349")) {
                return (LocateQueueManager) ipChange.ipc$dispatch("836604349", new Object[]{this});
            }
            if (LocateQueueManager.j == null) {
                LocateQueueManager.j = new LocateQueueManager(null);
            }
            return LocateQueueManager.j;
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class b implements RegionRequestHandler {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ga1 b;

        b(ga1 ga1Var) {
            this.b = ga1Var;
        }

        @Override // com.alibaba.pictures.piclocation.mtop.RegionRequestHandler
        public void onRequestRegionDataFailed() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1432701791")) {
                ipChange.ipc$dispatch("1432701791", new Object[]{this});
                return;
            }
            LocateQueueManager.this.a.set(false);
            ga1 ga1Var = this.b;
            ga1Var.c = "";
            ga1Var.d = "";
            ga1Var.f = "";
            ga1Var.g = LocationDataStatus.GETFAILED;
            LocateQueueManager.this.l(ga1Var);
        }

        @Override // com.alibaba.pictures.piclocation.mtop.RegionRequestHandler
        public void onRequestRegionDataSuccess(@NotNull k12 k12Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-143814019")) {
                ipChange.ipc$dispatch("-143814019", new Object[]{this, k12Var});
                return;
            }
            b41.i(k12Var, "regionPicResponse");
            LocateQueueManager.this.a.set(false);
            throw null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class c extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1365401431")) {
                ipChange.ipc$dispatch("1365401431", new Object[]{this, message});
                return;
            }
            b41.i(message, "msg");
            Object obj = message.obj;
            if (obj instanceof LocateGpsPicListener) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.pictures.piclocation.listener.LocateGpsPicListener");
                LocateGpsPicListener locateGpsPicListener = (LocateGpsPicListener) obj;
                if (message.what != locateGpsPicListener.hashCode()) {
                    return;
                }
                if (!LocateQueueManager.this.n()) {
                    LocationDataStatus locationDataStatus = LocationDataStatus.NOPERMISSION;
                    locateGpsPicListener.onFailed(locationDataStatus.getCode(), locationDataStatus.getDes());
                } else {
                    LocationDataStatus locationDataStatus2 = LocationDataStatus.TIMEOUT;
                    locateGpsPicListener.onFailed(locationDataStatus2.getCode(), locationDataStatus2.getDes());
                }
                LocateQueueManager.this.c.remove(locateGpsPicListener);
            }
            Object obj2 = message.obj;
            if (obj2 instanceof LocateRegionPicListener) {
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type com.alibaba.pictures.piclocation.listener.LocateRegionPicListener");
                LocateRegionPicListener locateRegionPicListener = (LocateRegionPicListener) obj2;
                if (message.what != locateRegionPicListener.hashCode()) {
                    return;
                }
                LocationDataStatus locationDataStatus3 = LocationDataStatus.TIMEOUT;
                locateRegionPicListener.onFailed(locationDataStatus3.getCode(), locationDataStatus3.getDes());
                LocateQueueManager.this.d.remove(locateRegionPicListener);
            }
            LocateQueueManager.this.u();
        }
    }

    private LocateQueueManager() {
        this.a = new AtomicBoolean(false);
        this.c = new ArrayList(4);
        this.d = new ArrayList(4);
        this.f = true;
        this.g = new c(Looper.getMainLooper());
    }

    private final void j(ga1 ga1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1384459916")) {
            ipChange.ipc$dispatch("-1384459916", new Object[]{this, ga1Var});
        } else if (this.h != null) {
            if (this.a.compareAndSet(false, true)) {
                LocationRequestDelegate locationRequestDelegate = this.h;
                b41.f(locationRequestDelegate);
                locationRequestDelegate.requestRegionData(ga1Var, new b(ga1Var));
            }
        } else {
            ga1Var.c = "";
            ga1Var.d = "";
            ga1Var.g = LocationDataStatus.NOTINIT;
            l(ga1Var);
        }
    }

    private final void k(final ga1 ga1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "498234988")) {
            ipChange.ipc$dispatch("498234988", new Object[]{this, ga1Var});
        } else if (ga1Var == null) {
        } else {
            List<LocateGpsPicListener> list = this.c;
            if (list != null && list.size() != 0) {
                Iterator it = Collections.synchronizedCollection(this.c).iterator();
                while (it.hasNext()) {
                    final LocateGpsPicListener locateGpsPicListener = (LocateGpsPicListener) it.next();
                    it.remove();
                    if (locateGpsPicListener != null) {
                        this.g.post(new Runnable() { // from class: com.alibaba.pictures.piclocation.LocateQueueManager$doLocationListenerCallback$1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public final void run() {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "397206519")) {
                                    ipChange2.ipc$dispatch("397206519", new Object[]{this});
                                    return;
                                }
                                ga1 ga1Var2 = ga1.this;
                                LocationDataStatus locationDataStatus = ga1Var2.g;
                                if (locationDataStatus == LocationDataStatus.NOTINIT) {
                                    LocateGpsPicListener locateGpsPicListener2 = locateGpsPicListener;
                                    b41.f(locationDataStatus);
                                    int code = locationDataStatus.getCode();
                                    LocationDataStatus locationDataStatus2 = ga1.this.g;
                                    b41.f(locationDataStatus2);
                                    locateGpsPicListener2.onFailed(code, locationDataStatus2.getDes());
                                    return;
                                }
                                locateGpsPicListener.onLocationSuccess(ga1Var2);
                            }
                        });
                        this.g.removeMessages(locateGpsPicListener.hashCode());
                    }
                }
            }
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(final ga1 ga1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "390802317")) {
            ipChange.ipc$dispatch("390802317", new Object[]{this, ga1Var});
        } else if (ga1Var == null) {
        } else {
            List<LocateRegionPicListener> list = this.d;
            if (list != null && list.size() != 0) {
                Iterator it = Collections.synchronizedCollection(this.d).iterator();
                while (it.hasNext()) {
                    final LocateRegionPicListener locateRegionPicListener = (LocateRegionPicListener) it.next();
                    it.remove();
                    if (locateRegionPicListener != null) {
                        this.g.post(new Runnable() { // from class: com.alibaba.pictures.piclocation.LocateQueueManager$doRegionListenerCallback$1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public final void run() {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "1475785816")) {
                                    ipChange2.ipc$dispatch("1475785816", new Object[]{this});
                                    return;
                                }
                                ga1 ga1Var2 = ga1.this;
                                LocationDataStatus locationDataStatus = ga1Var2.g;
                                if (locationDataStatus != LocationDataStatus.NOTINIT && locationDataStatus != LocationDataStatus.GETFAILED && !TextUtils.isEmpty(ga1Var2.c)) {
                                    Log.e("Locate_ListenerHelper", "onRegionSuccess");
                                    locateRegionPicListener.onRegionSuccess(ga1.this);
                                    return;
                                }
                                Log.e("Locate_ListenerHelper", "onRegionFailed");
                                LocateRegionPicListener locateRegionPicListener2 = locateRegionPicListener;
                                LocationDataStatus locationDataStatus2 = ga1.this.g;
                                b41.f(locationDataStatus2);
                                int code = locationDataStatus2.getCode();
                                LocationDataStatus locationDataStatus3 = ga1.this.g;
                                b41.f(locationDataStatus3);
                                locateRegionPicListener2.onFailed(code, locationDataStatus3.getDes());
                            }
                        });
                        this.g.removeMessages(locateRegionPicListener.hashCode());
                    }
                }
            }
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1983561923")) {
            return ((Boolean) ipChange.ipc$dispatch("-1983561923", new Object[]{this})).booleanValue();
        }
        if (this.c.size() != 0) {
            return false;
        }
        if (this.d.size() == 0 || this.a.get()) {
            LocationInterface locationInterface = this.e;
            if (locationInterface != null) {
                b41.f(locationInterface);
                locationInterface.stop();
            }
            return true;
        }
        return false;
    }

    public final void h(@NotNull LocateGpsPicListener locateGpsPicListener, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1581664106")) {
            ipChange.ipc$dispatch("-1581664106", new Object[]{this, locateGpsPicListener, Long.valueOf(j2)});
            return;
        }
        b41.i(locateGpsPicListener, "listener");
        if (j2 >= 0) {
            Message message = new Message();
            message.what = locateGpsPicListener.hashCode();
            message.obj = locateGpsPicListener;
            this.g.sendMessageDelayed(message, j2);
        }
        this.c.add(locateGpsPicListener);
    }

    public final void i(@NotNull LocateRegionPicListener locateRegionPicListener, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-392467978")) {
            ipChange.ipc$dispatch("-392467978", new Object[]{this, locateRegionPicListener, Long.valueOf(j2)});
            return;
        }
        b41.i(locateRegionPicListener, "listener");
        if (j2 >= 0) {
            Message message = new Message();
            message.what = locateRegionPicListener.hashCode();
            message.obj = locateRegionPicListener;
            this.g.sendMessageDelayed(message, j2);
        }
        this.d.add(locateRegionPicListener);
    }

    public final long m() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "870482962") ? ((Long) ipChange.ipc$dispatch("870482962", new Object[]{this})).longValue() : this.b;
    }

    public final boolean n() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1451658715") ? ((Boolean) ipChange.ipc$dispatch("-1451658715", new Object[]{this})).booleanValue() : this.f;
    }

    public final void o(@Nullable ga1 ga1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1682723604")) {
            ipChange.ipc$dispatch("-1682723604", new Object[]{this, ga1Var});
        } else if (ga1Var != null) {
            if (ga1Var.a == 0.0d && ga1Var.b == 0.0d) {
                return;
            }
            this.b = System.currentTimeMillis();
            List<LocateGpsPicListener> list = this.c;
            if (list != null && list.size() != 0) {
                k(ga1Var);
            }
            t(ga1Var);
        }
    }

    public final void p(int i2, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1176470254")) {
            ipChange.ipc$dispatch("1176470254", new Object[]{this, Integer.valueOf(i2), str});
            return;
        }
        b41.i(str, SocialConstants.PARAM_APP_DESC);
        this.b = 0L;
        List<LocateGpsPicListener> list = this.c;
        if (list != null && list.size() != 0) {
            Iterator<LocateGpsPicListener> it = this.c.iterator();
            while (it.hasNext()) {
                LocateGpsPicListener next = it.next();
                if (next != null) {
                    next.onFailed(i2, str);
                    this.g.removeMessages(next.hashCode());
                    it.remove();
                }
            }
        }
        u();
    }

    public final void q(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1632342343")) {
            ipChange.ipc$dispatch("1632342343", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.f = z;
        }
    }

    public final void r(@Nullable LocationInterface locationInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1917895942")) {
            ipChange.ipc$dispatch("1917895942", new Object[]{this, locationInterface});
        } else {
            this.e = locationInterface;
        }
    }

    public final void s(@Nullable LocationRequestDelegate locationRequestDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-701948599")) {
            ipChange.ipc$dispatch("-701948599", new Object[]{this, locationRequestDelegate});
        } else {
            this.h = locationRequestDelegate;
        }
    }

    public final void t(@NotNull ga1 ga1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "476711526")) {
            ipChange.ipc$dispatch("476711526", new Object[]{this, ga1Var});
            return;
        }
        b41.i(ga1Var, "info");
        List<LocateRegionPicListener> list = this.d;
        if (list == null || list.size() == 0 || this.a.get()) {
            return;
        }
        j(ga1Var);
    }

    public /* synthetic */ LocateQueueManager(k50 k50Var) {
        this();
    }
}
