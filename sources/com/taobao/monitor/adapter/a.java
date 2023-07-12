package com.taobao.monitor.adapter;

import com.taobao.monitor.procedure.IProcedure;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import tb.wu1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class a {
    private static final C0311a a = new C0311a();

    /* compiled from: Taobao */
    /* renamed from: com.taobao.monitor.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0311a implements IProcedure {
        final ArrayList<IProcedure> a = new ArrayList<>();

        /* JADX INFO: Access modifiers changed from: private */
        public void addSubProcedure(IProcedure iProcedure) {
            if (iProcedure != null) {
                this.a.add(iProcedure);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            this.a.clear();
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure addBiz(String str, Map<String, Object> map) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().addBiz(str, map);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure addBizAbTest(String str, Map<String, Object> map) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().addBizAbTest(str, map);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure addBizStage(String str, Map<String, Object> map) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().addBizStage(str, map);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure addProperty(String str, Object obj) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().addProperty(str, obj);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure addPropertyIfAbsent(String str, Object obj) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().addPropertyIfAbsent(str, obj);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure addStatistic(String str, Object obj) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().addStatistic(str, obj);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure addSubTask(String str, long j, long j2) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().addSubTask(str, j, j2);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure begin() {
            throw new UnsupportedOperationException();
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure end() {
            throw new UnsupportedOperationException();
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure event(String str, Map<String, Object> map) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().event(str, map);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public boolean isAlive() {
            throw new UnsupportedOperationException();
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure onSubTaskBegin(String str) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onSubTaskBegin(str);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure onSubTaskFail(String str, String str2, Map<String, Object> map) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onSubTaskFail(str, str2, map);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure onSubTaskSuccess(String str, Map<String, Object> map) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onSubTaskSuccess(str, map);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure parent() {
            throw new UnsupportedOperationException();
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure stage(String str, long j) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().stage(str, j);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure stageIfAbsent(String str, long j) {
            Iterator<IProcedure> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().stageIfAbsent(str, j);
            }
            return this;
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public String topic() {
            throw new UnsupportedOperationException();
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public String topicSession() {
            throw new UnsupportedOperationException();
        }

        @Override // com.taobao.monitor.procedure.IProcedure
        public IProcedure end(boolean z) {
            throw new UnsupportedOperationException();
        }
    }

    public static IProcedure a() {
        C0311a c0311a = a;
        c0311a.c();
        c0311a.addSubProcedure(wu1.b.getLauncherProcedure());
        c0311a.addSubProcedure(wu1.b.getCurrentActivityProcedure());
        c0311a.addSubProcedure(wu1.b.getCurrentFragmentProcedure());
        return c0311a;
    }
}
