package com.alient.onearch.adapter.request;

import com.youku.arch.v3.data.Chain;
import com.youku.arch.v3.data.DataLoadCallback;
import com.youku.arch.v3.data.DataLoader;
import com.youku.arch.v3.data.RequestContext;
import com.youku.arch.v3.data.local.LocalDataSource;
import com.youku.arch.v3.io.IResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/alient/onearch/adapter/request/RemoteDataLoader;", "Lcom/youku/arch/v3/data/DataLoader;", "Lcom/youku/arch/v3/data/RequestContext;", "Lcom/youku/arch/v3/data/Chain;", "chain", "Ltb/wt2;", "process", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public class RemoteDataLoader implements DataLoader<RequestContext> {
    @Override // com.youku.arch.v3.data.DataLoader
    public void process(@NotNull Chain<RequestContext> chain) {
        b41.i(chain, "chain");
        final RequestContext param = chain.getParam();
        RemoteDataSource.Companion.getInstance().get(param.getRequest(), new DataLoadCallback() { // from class: com.alient.onearch.adapter.request.RemoteDataLoader$process$1
            @Override // com.youku.arch.v3.data.DataLoadCallback
            public void onFilter(@NotNull IResponse iResponse) {
                b41.i(iResponse, "response");
                DataLoadCallback callback = RequestContext.this.getCallback();
                if (callback == null) {
                    return;
                }
                callback.onFilter(iResponse);
            }

            @Override // com.youku.arch.v3.io.Callback
            public void onResponse(@NotNull IResponse iResponse) {
                b41.i(iResponse, "response");
                if (iResponse.isSuccess()) {
                    RequestContext.this.setResponse(iResponse);
                }
                DataLoadCallback callback = RequestContext.this.getCallback();
                if (callback != null) {
                    callback.onResponse(iResponse);
                }
                if (iResponse.isSuccess() && RequestContext.this.getRequest().isNeedCache()) {
                    LocalDataSource.put$default(LocalDataSource.Companion.getInstance(), iResponse, 0L, 2, null);
                }
            }
        });
        chain.proceed();
    }
}
