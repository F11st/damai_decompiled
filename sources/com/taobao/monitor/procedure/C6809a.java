package com.taobao.monitor.procedure;

import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.taobao.monitor.procedure.a */
/* loaded from: classes11.dex */
class C6809a implements IProcedure {
    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addBiz(String str, Map<String, Object> map) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addBizAbTest(String str, Map<String, Object> map) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addBizStage(String str, Map<String, Object> map) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addProperty(String str, Object obj) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addPropertyIfAbsent(String str, Object obj) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addStatistic(String str, Object obj) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure addSubTask(String str, long j, long j2) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure begin() {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure end() {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure end(boolean z) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure event(String str, Map<String, Object> map) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public boolean isAlive() {
        return false;
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
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure stage(String str, long j) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public IProcedure stageIfAbsent(String str, long j) {
        return this;
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public String topic() {
        return "default";
    }

    @Override // com.taobao.monitor.procedure.IProcedure
    public String topicSession() {
        return "no-session";
    }
}
