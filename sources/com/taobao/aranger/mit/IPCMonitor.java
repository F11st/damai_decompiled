package com.taobao.aranger.mit;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.update.datasource.mtop.MtopUpdater;
import tb.a11;
import tb.z01;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class IPCMonitor {
    private static boolean a = true;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class IpcState {
        private static boolean i;
        private final int a;
        private String b;
        private String c;
        private int d;
        private int e;
        private long f;
        private long g;
        private long h;

        public IpcState(int i2) {
            this.a = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean k() {
            if (IPCMonitor.a) {
                synchronized (this) {
                    if (i) {
                        return true;
                    }
                    try {
                        DimensionSet create = DimensionSet.create();
                        create.addDimension("type");
                        create.addDimension(MtopUpdater.DEGRADE);
                        create.addDimension("result");
                        create.addDimension("serviceName");
                        create.addDimension("methodName");
                        MeasureSet create2 = MeasureSet.create();
                        create2.addMeasure("costTime");
                        create2.addMeasure("invokeTime");
                        create2.addMeasure("dataSize");
                        AppMonitor.register("ARanger", "ipcState", create2, create, true);
                        i = true;
                    } catch (Exception e) {
                        z01.c("IPCMonitor", "[register][AppMonitor register]", e, new Object[0]);
                    }
                    return i;
                }
            }
            return false;
        }

        public void j() {
            if (IPCMonitor.a) {
                a11.b(false, true, new Runnable() { // from class: com.taobao.aranger.mit.IPCMonitor.IpcState.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (IpcState.this.k()) {
                            z01.e("IPCMonitor", "[commit]", "IpcState", IpcState.this.toString());
                            try {
                                DimensionValueSet create = DimensionValueSet.create();
                                create.setValue("type", String.valueOf(IpcState.this.a));
                                create.setValue(MtopUpdater.DEGRADE, String.valueOf(IpcState.this.e));
                                create.setValue("result", String.valueOf(IpcState.this.d));
                                create.setValue("serviceName", IpcState.this.b);
                                create.setValue("methodName", IpcState.this.c);
                                MeasureValueSet create2 = MeasureValueSet.create();
                                create2.setValue("costTime", IpcState.this.f);
                                create2.setValue("invokeTime", IpcState.this.g);
                                create2.setValue("dataSize", IpcState.this.h);
                                AppMonitor.Stat.commit("ARanger", "ipcState", create, create2);
                            } catch (Exception e) {
                                z01.c("IPCMonitor", "[commit][AppMonitor Stat commit]", e, new Object[0]);
                            }
                        }
                    }
                });
            }
        }

        public void l(long j) {
            this.f = j;
        }

        public void m(long j) {
            this.h = j;
        }

        public void n(boolean z) {
            this.e = z ? 1 : 0;
        }

        public void o(long j) {
            this.g = j;
        }

        public void p(String str) {
            this.c = str;
        }

        public void q(int i2) {
            this.d = i2;
        }

        public void r(String str) {
            this.b = str;
        }

        public String toString() {
            return "IpcState{serviceName='" + this.b + "', methodName='" + this.c + "', type=" + this.a + ", result=" + this.d + ", degrade=" + this.e + ", costTime=" + this.f + ", invokeTime=" + this.g + ", dataSize=" + this.h + '}';
        }
    }
}
