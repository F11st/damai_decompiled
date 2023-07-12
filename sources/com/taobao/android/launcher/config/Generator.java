package com.taobao.android.launcher.config;

import com.taobao.android.job.core.DAGTaskChain;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface Generator<T> {
    void genChannelAttach(DAGTaskChain<T> dAGTaskChain);

    void genMainAttach(DAGTaskChain<T> dAGTaskChain);

    void genMainAttachDebug(DAGTaskChain<T> dAGTaskChain);

    void genMainAttachHead(DAGTaskChain<T> dAGTaskChain);

    void genMainAttachTail(DAGTaskChain<T> dAGTaskChain);

    void genMainBackground(DAGTaskChain<T> dAGTaskChain);

    void genMainBootFinished(DAGTaskChain<T> dAGTaskChain);

    void genMainColdLogin(DAGTaskChain<T> dAGTaskChain);

    void genMainCreate(DAGTaskChain<T> dAGTaskChain);

    void genMainCreateEnd(DAGTaskChain<T> dAGTaskChain);

    void genMainFirstActivity(DAGTaskChain<T> dAGTaskChain);

    void genMainForeground(DAGTaskChain<T> dAGTaskChain);

    void genMainFront(DAGTaskChain<T> dAGTaskChain);

    void genMainIdle(DAGTaskChain<T> dAGTaskChain);

    void genMainIdle10s(DAGTaskChain<T> dAGTaskChain);

    void genMainIdle15s(DAGTaskChain<T> dAGTaskChain);

    void genMainIdle2s(DAGTaskChain<T> dAGTaskChain);

    void genMainIdle30s(DAGTaskChain<T> dAGTaskChain);

    void genMainIdle5s(DAGTaskChain<T> dAGTaskChain);

    void genMainLaunch(DAGTaskChain<T> dAGTaskChain);

    void genMainLogin(DAGTaskChain<T> dAGTaskChain);

    void genMainLogout(DAGTaskChain<T> dAGTaskChain);

    void genMainSchemaWaked(DAGTaskChain<T> dAGTaskChain);

    void genMainSchemaWebWaked(DAGTaskChain<T> dAGTaskChain);

    void genMainSecurityGuard(DAGTaskChain<T> dAGTaskChain);

    void genSafeModeAttach(DAGTaskChain<T> dAGTaskChain);

    void genUCAttach(DAGTaskChain<T> dAGTaskChain);

    void genWindmillAttach(DAGTaskChain<T> dAGTaskChain);

    void genWindmillCreate(DAGTaskChain<T> dAGTaskChain);

    void genWindmillFirstActivity(DAGTaskChain<T> dAGTaskChain);
}
