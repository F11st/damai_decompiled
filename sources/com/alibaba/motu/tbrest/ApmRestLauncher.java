package com.alibaba.motu.tbrest;

import android.app.Application;
import com.alibaba.motu.tbrest.rest.RestReqSend;
import com.taobao.application.common.IApmEventListener;
import com.taobao.application.common.b;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ApmRestLauncher implements Serializable {
    private static volatile boolean init;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    private static class ApmListener implements IApmEventListener {
        private ApmListener() {
        }

        @Override // com.taobao.application.common.IApmEventListener
        public void onEvent(int i) {
            if (i == 1) {
                RestReqSend.sendAllCacheData();
            }
        }
    }

    public void init(Application application, HashMap<String, Object> hashMap) {
        if (init) {
            return;
        }
        init = true;
        b.a(new ApmListener());
    }
}
