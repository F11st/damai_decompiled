package com.alibaba.pictures.dolores.business;

import com.alibaba.pictures.dolores.DoloresKernel;
import com.alibaba.pictures.dolores.response.BizResponseType;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.dc0;
import tb.gn1;
import tb.gu1;
import tb.hu1;
import tb.jn1;
import tb.rq;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B'\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/alibaba/pictures/dolores/business/AsyncRequestFuture;", "BizResponse", "Ljava/util/concurrent/RunnableFuture;", "Lcom/alibaba/pictures/dolores/business/AsyncResult;", "Ltb/wt2;", "run", "", "mayInterruptIfRunning", "cancel", "isCancelled", "isDone", gn1.TYPE_OPEN_URL_METHOD_GET, "", "p0", "Ljava/util/concurrent/TimeUnit;", "p1", "", "TAG", "Ljava/lang/String;", "Z", "taskCanceled", "asyncResult", "Lcom/alibaba/pictures/dolores/business/AsyncResult;", "Lcom/alibaba/pictures/dolores/DoloresKernel;", "doloresKernel", "Lcom/alibaba/pictures/dolores/DoloresKernel;", "<init>", "(Lcom/alibaba/pictures/dolores/business/AsyncResult;Lcom/alibaba/pictures/dolores/DoloresKernel;)V", "dolores_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class AsyncRequestFuture<BizResponse> implements RunnableFuture<AsyncResult<BizResponse>> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String TAG = "AsyncRequestFuture";
    private final AsyncResult<BizResponse> asyncResult;
    private final DoloresKernel<BizResponse> doloresKernel;
    private boolean isDone;
    private boolean taskCanceled;

    public AsyncRequestFuture(@Nullable AsyncResult<BizResponse> asyncResult, @Nullable DoloresKernel<BizResponse> doloresKernel) {
        this.asyncResult = asyncResult;
        this.doloresKernel = doloresKernel;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1057216654")) {
            return ((Boolean) ipChange.ipc$dispatch("1057216654", new Object[]{this, Boolean.valueOf(z)})).booleanValue();
        }
        this.taskCanceled = true;
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-652961949")) {
            return ((Boolean) ipChange.ipc$dispatch("-652961949", new Object[]{this})).booleanValue();
        }
        if (this.taskCanceled) {
            return true;
        }
        DoloresKernel<BizResponse> doloresKernel = this.doloresKernel;
        return doloresKernel != null ? doloresKernel.u() : false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "677781756") ? ((Boolean) ipChange.ipc$dispatch("677781756", new Object[]{this})).booleanValue() : this.isDone;
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-131140965")) {
            ipChange.ipc$dispatch("-131140965", new Object[]{this});
            return;
        }
        rq.a("AsyncRequestFuture", "AsyncRequestFuture start run...");
        if (this.asyncResult != null && this.doloresKernel != null && !isCancelled()) {
            this.asyncResult.onStart(this.doloresKernel.m());
            gu1<BizResponse> e = hu1.INSTANCE.e(this.asyncResult, this.doloresKernel);
            if (b41.d(e.b(), Boolean.TRUE)) {
                return;
            }
            dc0<BizResponse> a = e.a();
            if (a == null) {
                a = this.doloresKernel.D(this.asyncResult);
            }
            this.asyncResult.setResponse(a);
            a.o(this.asyncResult.getTag());
            if (isCancelled()) {
                String str = this.TAG;
                rq.d(str, jn1.ARRAY_START + this.doloresKernel.g() + "]->该请求被取消||返回时业务调用页面生命周期已结束");
                this.asyncResult.onFinish();
                this.doloresKernel.z();
                return;
            }
            if (a.b() == BizResponseType.RESULT_SUCCESS.getCode()) {
                String str2 = this.TAG;
                rq.a(str2, jn1.ARRAY_START + this.doloresKernel.g() + "]->onSuccess call back");
                if (a.a() == null) {
                    if (!this.asyncResult.onSuccessNull(a)) {
                        this.asyncResult.onFail(a);
                    }
                } else {
                    AsyncResult<BizResponse> asyncResult = this.asyncResult;
                    BizResponse a2 = a.a();
                    b41.f(a2);
                    asyncResult.onSuccess(a2);
                }
            } else {
                String str3 = this.TAG;
                rq.a(str3, jn1.ARRAY_START + this.doloresKernel.g() + "]->onFail call back");
                this.asyncResult.onFail(a);
            }
            this.asyncResult.onFinish();
            this.doloresKernel.z();
            String str4 = this.TAG;
            rq.a(str4, jn1.ARRAY_START + this.doloresKernel.g() + "]->AsyncRequestFuture done");
            this.isDone = true;
            return;
        }
        rq.d("AsyncRequestFuture", "请求return:asyncResult == null || doloresBusiness == null || isCancelled");
        AsyncResult<BizResponse> asyncResult2 = this.asyncResult;
        if (asyncResult2 != null) {
            asyncResult2.onFinish();
        }
        DoloresKernel<BizResponse> doloresKernel = this.doloresKernel;
        if (doloresKernel != null) {
            doloresKernel.z();
        }
    }

    @Override // java.util.concurrent.Future
    @NotNull
    public AsyncResult<BizResponse> get() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1393485665")) {
            return (AsyncResult) ipChange.ipc$dispatch("1393485665", new Object[]{this});
        }
        AsyncResult<BizResponse> asyncResult = this.asyncResult;
        return asyncResult != null ? asyncResult : new AsyncResult<>();
    }

    @Override // java.util.concurrent.Future
    @NotNull
    public AsyncResult<BizResponse> get(long j, @Nullable TimeUnit timeUnit) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "959942485")) {
            return (AsyncResult) ipChange.ipc$dispatch("959942485", new Object[]{this, Long.valueOf(j), timeUnit});
        }
        AsyncResult<BizResponse> asyncResult = this.asyncResult;
        return asyncResult != null ? asyncResult : new AsyncResult<>();
    }
}
