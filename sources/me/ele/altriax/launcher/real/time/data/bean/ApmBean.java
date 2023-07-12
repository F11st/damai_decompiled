package me.ele.altriax.launcher.real.time.data.bean;

import androidx.annotation.Nullable;
import com.taobao.monitor.procedure.IProcedure;
import java.util.List;
import java.util.Map;
import tb.qf2;
import tb.rf0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ApmBean {
    @Nullable
    public List<rf0> events;
    @Nullable
    public String firstInstall;
    @Nullable
    public String firstLaunch;
    @Nullable
    public String launchType;
    @Nullable
    public Map<String, Object> properties;
    @Nullable
    public List<qf2> stages;
    @Nullable
    public Map<String, Object> stats;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class Builder {
        @Nullable
        private final IProcedure iProcedure;

        public Builder(@Nullable IProcedure iProcedure) {
            this.iProcedure = iProcedure;
        }

        public ApmBean create() {
            return ApmBean.create(this.iProcedure);
        }
    }

    private ApmBean() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0020 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0021  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static me.ele.altriax.launcher.real.time.data.bean.ApmBean create(@androidx.annotation.Nullable com.taobao.monitor.procedure.IProcedure r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            boolean r1 = r4 instanceof com.taobao.monitor.procedure.ProcedureProxy
            if (r1 == 0) goto L16
            r1 = r4
            com.taobao.monitor.procedure.ProcedureProxy r1 = (com.taobao.monitor.procedure.ProcedureProxy) r1
            com.taobao.monitor.procedure.IProcedure r1 = r1.c()
            boolean r2 = r1 instanceof com.taobao.monitor.procedure.ProcedureImpl
            if (r2 == 0) goto L16
            com.taobao.monitor.procedure.ProcedureImpl r1 = (com.taobao.monitor.procedure.ProcedureImpl) r1
            goto L17
        L16:
            r1 = r0
        L17:
            boolean r2 = r4 instanceof com.taobao.monitor.procedure.ProcedureImpl
            if (r2 == 0) goto L1e
            r1 = r4
            com.taobao.monitor.procedure.ProcedureImpl r1 = (com.taobao.monitor.procedure.ProcedureImpl) r1
        L1e:
            if (r1 != 0) goto L21
            return r0
        L21:
            me.ele.altriax.launcher.real.time.data.bean.ApmBean r4 = new me.ele.altriax.launcher.real.time.data.bean.ApmBean
            r4.<init>()
            com.taobao.monitor.procedure.f r0 = r1.e()
            if (r0 == 0) goto L74
            java.util.List r1 = r0.q()
            java.util.List r2 = r0.k()
            java.util.Map r3 = r0.r()
            java.util.Map r0 = r0.m()
            r4.stages = r1
            r4.events = r2
            r4.stats = r3
            r4.properties = r0
            boolean r1 = isEmpty(r0)
            if (r1 != 0) goto L74
            java.lang.String r1 = "launchType"
            java.lang.Object r1 = r0.get(r1)
            java.lang.String r2 = "isFirstLaunch"
            java.lang.Object r2 = r0.get(r2)
            java.lang.String r3 = "isFirstInstall"
            java.lang.Object r0 = r0.get(r3)
            if (r1 == 0) goto L64
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r4.launchType = r1
        L64:
            if (r2 == 0) goto L6c
            java.lang.String r1 = java.lang.String.valueOf(r2)
            r4.firstLaunch = r1
        L6c:
            if (r0 == 0) goto L74
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r4.firstInstall = r0
        L74:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: me.ele.altriax.launcher.real.time.data.bean.ApmBean.create(com.taobao.monitor.procedure.IProcedure):me.ele.altriax.launcher.real.time.data.bean.ApmBean");
    }

    public static boolean isEmpty(@Nullable Map<?, ?> map) {
        return map == null || map.isEmpty();
    }
}
