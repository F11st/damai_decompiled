package com.youku.arch.v3.data;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.data.local.LocalDataSource;
import com.youku.arch.v3.io.IResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/youku/arch/v3/data/LocalDataLoader;", "Lcom/youku/arch/v3/data/DataLoader;", "Lcom/youku/arch/v3/data/RequestContext;", "Lcom/youku/arch/v3/data/Chain;", "chain", "Ltb/wt2;", "process", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class LocalDataLoader implements DataLoader<RequestContext> {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.arch.v3.data.DataLoader
    public void process(@NotNull Chain<RequestContext> chain) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1621473692")) {
            ipChange.ipc$dispatch("1621473692", new Object[]{this, chain});
            return;
        }
        b41.i(chain, "chain");
        final RequestContext param = chain.getParam();
        LocalDataSource.Companion.getInstance().get(param.getRequest(), new DataLoadCallback() { // from class: com.youku.arch.v3.data.LocalDataLoader$process$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.arch.v3.data.DataLoadCallback
            public void onFilter(@NotNull IResponse iResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2113086809")) {
                    ipChange2.ipc$dispatch("-2113086809", new Object[]{this, iResponse});
                    return;
                }
                b41.i(iResponse, "response");
                DataLoadCallback callback = RequestContext.this.getCallback();
                if (callback == null) {
                    return;
                }
                callback.onFilter(iResponse);
            }

            @Override // com.youku.arch.v3.io.Callback
            public void onResponse(@NotNull IResponse iResponse) {
                DataLoadCallback callback;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2026663678")) {
                    ipChange2.ipc$dispatch("2026663678", new Object[]{this, iResponse});
                    return;
                }
                b41.i(iResponse, "response");
                if (iResponse.isSuccess()) {
                    if (RequestContext.this.getResponse() != null) {
                        long timestamp = iResponse.getTimestamp();
                        IResponse response = RequestContext.this.getResponse();
                        b41.f(response);
                        if (timestamp <= response.getTimestamp()) {
                            return;
                        }
                    }
                    RequestContext.this.setResponse(iResponse);
                    DataLoadCallback callback2 = RequestContext.this.getCallback();
                    if (callback2 == null) {
                        return;
                    }
                    callback2.onResponse(iResponse);
                } else if ((RequestContext.this.getRequest().getStrategy() & 2) == 0 && b41.d("local_cache_missing", iResponse.getRetCode()) && (callback = RequestContext.this.getCallback()) != null) {
                    callback.onResponse(iResponse);
                }
            }
        });
        chain.proceed();
    }
}
