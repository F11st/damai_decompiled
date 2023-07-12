package com.youku.arch.v3.data;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.WXBridgeManager;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0011\u001a\u00020\u00108\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/youku/arch/v3/data/RequestContext;", "", "Lcom/youku/arch/v3/io/IRequest;", "request", "Lcom/youku/arch/v3/io/IRequest;", "getRequest", "()Lcom/youku/arch/v3/io/IRequest;", "setRequest", "(Lcom/youku/arch/v3/io/IRequest;)V", "Lcom/youku/arch/v3/data/DataLoadCallback;", WXBridgeManager.METHOD_CALLBACK, "Lcom/youku/arch/v3/data/DataLoadCallback;", "getCallback", "()Lcom/youku/arch/v3/data/DataLoadCallback;", "setCallback", "(Lcom/youku/arch/v3/data/DataLoadCallback;)V", "", "id", "J", "getId", "()J", "Lcom/youku/arch/v3/io/IResponse;", "response", "Lcom/youku/arch/v3/io/IResponse;", "getResponse", "()Lcom/youku/arch/v3/io/IResponse;", "setResponse", "(Lcom/youku/arch/v3/io/IResponse;)V", "<init>", "(Lcom/youku/arch/v3/io/IRequest;Lcom/youku/arch/v3/data/DataLoadCallback;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class RequestContext {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private DataLoadCallback callback;
    private final long id;
    @NotNull
    private IRequest request;
    @Nullable
    private volatile IResponse response;

    public RequestContext(@NotNull IRequest iRequest, @Nullable DataLoadCallback dataLoadCallback) {
        b41.i(iRequest, "request");
        this.request = iRequest;
        this.callback = dataLoadCallback;
        this.id = iRequest.getId();
    }

    @Nullable
    public final DataLoadCallback getCallback() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1725123518") ? (DataLoadCallback) ipChange.ipc$dispatch("1725123518", new Object[]{this}) : this.callback;
    }

    public final long getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-562913544") ? ((Long) ipChange.ipc$dispatch("-562913544", new Object[]{this})).longValue() : this.id;
    }

    @NotNull
    public final IRequest getRequest() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1368468587") ? (IRequest) ipChange.ipc$dispatch("1368468587", new Object[]{this}) : this.request;
    }

    @Nullable
    public final IResponse getResponse() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2057719417") ? (IResponse) ipChange.ipc$dispatch("2057719417", new Object[]{this}) : this.response;
    }

    public final void setCallback(@Nullable DataLoadCallback dataLoadCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-242272858")) {
            ipChange.ipc$dispatch("-242272858", new Object[]{this, dataLoadCallback});
        } else {
            this.callback = dataLoadCallback;
        }
    }

    public final void setRequest(@NotNull IRequest iRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "423257783")) {
            ipChange.ipc$dispatch("423257783", new Object[]{this, iRequest});
            return;
        }
        b41.i(iRequest, "<set-?>");
        this.request = iRequest;
    }

    public final void setResponse(@Nullable IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2044766099")) {
            ipChange.ipc$dispatch("2044766099", new Object[]{this, iResponse});
        } else {
            this.response = iResponse;
        }
    }
}
