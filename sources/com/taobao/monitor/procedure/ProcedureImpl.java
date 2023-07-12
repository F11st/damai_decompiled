package com.taobao.monitor.procedure;

import android.text.TextUtils;
import com.ali.user.mobile.login.model.LoginConstant;
import com.taobao.monitor.procedure.C6817d;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import tb.pb1;
import tb.qf2;
import tb.rf0;
import tb.tu1;
import tb.uu1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ProcedureImpl implements IProcedureGroup, IValueCallback {
    private static volatile long j = System.currentTimeMillis();
    private String a;
    private final String b;
    private final IProcedure c;
    private final C6821f d;
    private Status e;
    private final List<IProcedure> f;
    private IProcedureLifeCycle g;
    private final boolean h;
    private final Map<String, Long> i;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface IProcedureLifeCycle {
        void begin(C6821f c6821f);

        void end(C6821f c6821f);

        void event(C6821f c6821f, rf0 rf0Var);

        void stage(C6821f c6821f, qf2 qf2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum Status {
        INIT,
        RUNNING,
        STOPPED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProcedureImpl(String str, IProcedure iProcedure, boolean z, boolean z2) {
        long j2 = j;
        j = 1 + j2;
        String valueOf = String.valueOf(j2);
        this.b = valueOf;
        this.e = Status.INIT;
        this.a = str;
        this.c = iProcedure;
        this.h = z;
        this.f = new LinkedList();
        C6821f c6821f = new C6821f(str, z, z2);
        this.d = c6821f;
        if (iProcedure != null) {
            c6821f.d("parentSession", iProcedure.topicSession());
        }
        c6821f.d(Preloader.KEY_SESSION, valueOf);
        c6821f.e(valueOf);
        this.i = new HashMap();
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addBiz(String str, Map<String, Object> map) {
        if (str != null && isAlive()) {
            this.d.a(str, map);
            pb1.d("ProcedureImpl", this.c, this.a, str);
        }
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addBizAbTest(String str, Map<String, Object> map) {
        if (str != null && isAlive()) {
            this.d.b(str, map);
            pb1.d("ProcedureImpl", this.c, this.a, str);
        }
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addBizStage(String str, Map<String, Object> map) {
        if (str != null && isAlive()) {
            this.d.c(str, map);
            pb1.d("ProcedureImpl", this.c, this.a, str);
        }
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addProperty(String str, Object obj) {
        if (isAlive()) {
            this.d.d(str, obj);
        }
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addPropertyIfAbsent(String str, Object obj) {
        if (isAlive() && !this.d.m().containsKey(str)) {
            this.d.d(str, obj);
        }
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addStatistic(String str, Object obj) {
        if (isAlive()) {
            this.d.f(str, obj);
        }
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedureGroup
    public void addSubProcedure(IProcedure iProcedure) {
        if (iProcedure == null || !isAlive()) {
            return;
        }
        synchronized (this.f) {
            this.f.add(iProcedure);
        }
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addSubTask(String str, long j2, long j3) {
        return this;
    }

    public IProcedure b(String str, String str2, Map<String, Object> map, long j2, String str3, boolean z) {
        Long l = this.i.get(str);
        if (l != null && !TextUtils.isEmpty(str) && this.f != null && isAlive()) {
            C6817d f = new C6817d.C6819b().g(false).k(false).i(false).h(this).f();
            tu1 tu1Var = tu1.b;
            IProcedure createProcedure = tu1Var.createProcedure("/" + str, f);
            createProcedure.begin();
            createProcedure.stage("taskStart", l.longValue());
            createProcedure.addProperty("isMainThread", Boolean.valueOf(z));
            createProcedure.addProperty("threadName", str3);
            createProcedure.stage("taskEnd", j2);
            if (!TextUtils.isEmpty(str2)) {
                createProcedure.addProperty("errorType", str2);
            }
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String valueOf = String.valueOf(entry.getKey());
                    if (!TextUtils.isEmpty(valueOf)) {
                        createProcedure.addProperty(valueOf, entry.getValue());
                    }
                }
            }
            createProcedure.end();
            pb1.a("ProcedureImpl", "subTaskName", str, LoginConstant.START_TIME, l, "endTime", Long.valueOf(j2), "errorType", str2, "threadName", str3, "isMainThread", Boolean.valueOf(z));
        }
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure begin() {
        if (this.e == Status.INIT) {
            this.e = Status.RUNNING;
            IProcedure iProcedure = this.c;
            if (iProcedure instanceof IProcedureGroup) {
                ((IProcedureGroup) iProcedure).addSubProcedure(this);
            }
            pb1.d("ProcedureImpl", this.c, this.a, "begin()");
            IProcedureLifeCycle iProcedureLifeCycle = this.g;
            if (iProcedureLifeCycle != null) {
                iProcedureLifeCycle.begin(this.d);
            }
        }
        return this;
    }

    public IProcedure c(String str, long j2) {
        if (!TextUtils.isEmpty(str)) {
            this.i.put(str, Long.valueOf(j2));
        }
        pb1.a("ProcedureImpl", "name", str, LoginConstant.START_TIME, Long.valueOf(j2));
        return this;
    }

    @Override // com.taobao.monitor.procedure.IValueCallback
    public void callback(C6821f c6821f) {
        if (isAlive()) {
            this.d.g(c6821f);
        }
    }

    public ProcedureImpl d(IProcedureLifeCycle iProcedureLifeCycle) {
        this.g = iProcedureLifeCycle;
        return this;
    }

    public C6821f e() {
        return this.d;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure end() {
        return end(false);
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure event(String str, Map<String, Object> map) {
        if (str != null && isAlive()) {
            rf0 rf0Var = new rf0(str, map);
            this.d.j(rf0Var);
            IProcedureLifeCycle iProcedureLifeCycle = this.g;
            if (iProcedureLifeCycle != null) {
                iProcedureLifeCycle.event(this.d, rf0Var);
            }
            pb1.d("ProcedureImpl", this.c, this.a, str);
        }
        return this;
    }

    protected C6821f f() {
        return this.d.t();
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.e == Status.RUNNING) {
            pb1.f(new RuntimeException("Please call end function first!"));
        }
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public boolean isAlive() {
        return Status.STOPPED != this.e;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure onSubTaskBegin(String str) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure onSubTaskFail(String str, String str2, Map<String, Object> map) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure onSubTaskSuccess(String str, Map<String, Object> map) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure parent() {
        return this.c;
    }

    @Override // com.taobao.monitor.procedure.IProcedureGroup
    public void removeSubProcedure(IProcedure iProcedure) {
        if (iProcedure != null) {
            synchronized (this.f) {
                this.f.remove(iProcedure);
            }
        }
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure stage(String str, long j2) {
        if (str != null && isAlive()) {
            qf2 qf2Var = new qf2(str, j2);
            this.d.p(qf2Var);
            IProcedureLifeCycle iProcedureLifeCycle = this.g;
            if (iProcedureLifeCycle != null) {
                iProcedureLifeCycle.stage(this.d, qf2Var);
            }
            pb1.d("ProcedureImpl", this.c, this.a, qf2Var);
        }
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure stageIfAbsent(String str, long j2) {
        if (str != null && isAlive()) {
            qf2 qf2Var = new qf2(str, j2);
            if (this.d.q().contains(qf2Var)) {
                return this;
            }
            this.d.p(qf2Var);
            IProcedureLifeCycle iProcedureLifeCycle = this.g;
            if (iProcedureLifeCycle != null) {
                iProcedureLifeCycle.stage(this.d, qf2Var);
            }
            pb1.d("ProcedureImpl", this.c, this.a, qf2Var);
        }
        return this;
    }

    public String toString() {
        return this.a;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public String topic() {
        return this.a;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public String topicSession() {
        return this.b;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure end(boolean z) {
        if (this.e == Status.RUNNING) {
            synchronized (this.f) {
                for (IProcedure iProcedure : this.f) {
                    if (iProcedure instanceof ProcedureProxy) {
                        IProcedure c = ((ProcedureProxy) iProcedure).c();
                        if (c instanceof ProcedureImpl) {
                            ProcedureImpl procedureImpl = (ProcedureImpl) c;
                            if (procedureImpl.isAlive()) {
                                this.d.g(procedureImpl.f());
                            }
                            if (!procedureImpl.h || z) {
                                c.end(z);
                            }
                        } else {
                            c.end(z);
                        }
                    } else {
                        iProcedure.end(z);
                    }
                }
            }
            if (this.c instanceof IProcedureGroup) {
                uu1.d().b().post(new Runnable() { // from class: com.taobao.monitor.procedure.ProcedureImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((IProcedureGroup) ProcedureImpl.this.c).removeSubProcedure(ProcedureImpl.this);
                    }
                });
            }
            IProcedure iProcedure2 = this.c;
            if (iProcedure2 instanceof IValueCallback) {
                ((IValueCallback) iProcedure2).callback(f());
            }
            IProcedureLifeCycle iProcedureLifeCycle = this.g;
            if (iProcedureLifeCycle != null) {
                iProcedureLifeCycle.end(this.d);
            }
            this.e = Status.STOPPED;
            pb1.d("ProcedureImpl", this.c, this.a, "end()");
        }
        return this;
    }
}
