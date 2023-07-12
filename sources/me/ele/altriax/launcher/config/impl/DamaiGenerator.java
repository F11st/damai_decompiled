package me.ele.altriax.launcher.config.impl;

import androidx.annotation.Keep;
import com.taobao.android.job.core.DAGTaskChain;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public final class DamaiGenerator extends AltriaXGenerator {
    @Override // me.ele.altriax.launcher.config.impl.AltriaXGenerator, com.taobao.android.launcher.config.Generator
    public void genChannelAttach(DAGTaskChain<String> dAGTaskChain) {
        dAGTaskChain.createTaskPair("DMInitMtop", "DMInitLoginSDK");
        dAGTaskChain.createInitialTask("DMInitUT");
        dAGTaskChain.createInitialTask("DMInitTetrisProxy");
        dAGTaskChain.createInitialTask("DMInitDynamicX");
    }

    @Override // me.ele.altriax.launcher.config.impl.AltriaXGenerator, com.taobao.android.launcher.config.Generator
    public void genMainCreate(DAGTaskChain<String> dAGTaskChain) {
        dAGTaskChain.createTaskPair("DMInitMtop", "DMInitLoginSDK");
        dAGTaskChain.createInitialTask("DMInitImageLoader");
        dAGTaskChain.createInitialTask("DMInitNav");
        dAGTaskChain.createInitialTask("DMInitUT");
        dAGTaskChain.createInitialTask("DMInitTetrisProxy");
        dAGTaskChain.createInitialTask("DMInitDynamicX");
    }
}
