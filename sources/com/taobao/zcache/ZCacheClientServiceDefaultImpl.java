package com.taobao.zcache;

import androidx.annotation.NonNull;
import com.taobao.application.common.Apm;
import com.taobao.application.common.C6673b;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ZCacheClientServiceDefaultImpl implements IZCacheClientService {
    @Override // com.taobao.zcache.IZCacheClientService
    public void addClientEventListener(@NonNull final IZCacheClientListener iZCacheClientListener) {
        try {
            C6673b.a(new Apm.OnApmEventListener() { // from class: com.taobao.zcache.ZCacheClientServiceDefaultImpl.1
                @Override // com.taobao.application.common.IApmEventListener
                public void onEvent(int i) {
                    if (i == 2) {
                        iZCacheClientListener.clientActived();
                    } else if (i != 50) {
                    } else {
                        iZCacheClientListener.clientDeactived();
                    }
                }
            });
        } catch (NoClassDefFoundError unused) {
        }
    }
}
