package mtopsdk.mtop.network;

import androidx.annotation.NonNull;
import java.io.IOException;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.manager.FilterManager;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopHeaderEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.network.Call;
import mtopsdk.network.NetworkCallback;
import mtopsdk.network.domain.Response;
import mtopsdk.network.domain.ResponseBody;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class NetworkCallbackAdapter implements NetworkCallback {
    private static final String TAG = "mtopsdk.NetworkCallbackAdapter";
    FilterManager filterManager;
    public MtopCallback.MtopFinishListener finishListener;
    public MtopCallback.MtopHeaderListener headerListener;
    final MtopContext mtopContext;

    public NetworkCallbackAdapter(@NonNull MtopContext mtopContext) {
        this.mtopContext = mtopContext;
        if (mtopContext != null) {
            Mtop mtop = mtopContext.mtopInstance;
            if (mtop != null) {
                this.filterManager = mtop.getMtopConfig().filterManager;
            }
            MtopListener mtopListener = mtopContext.mtopListener;
            if (mtopListener instanceof MtopCallback.MtopHeaderListener) {
                this.headerListener = (MtopCallback.MtopHeaderListener) mtopListener;
            }
            if (mtopListener instanceof MtopCallback.MtopFinishListener) {
                this.finishListener = (MtopCallback.MtopFinishListener) mtopListener;
            }
        }
    }

    @Override // mtopsdk.network.NetworkCallback
    public void onCancel(Call call) {
        Response build = new Response.Builder().request(call.request()).code(-8).build();
        onFinish(build, build.request.reqContext);
    }

    @Override // mtopsdk.network.NetworkCallback
    public void onFailure(Call call, Exception exc) {
        Response build = new Response.Builder().request(call.request()).code(-7).message(exc.getMessage()).build();
        onFinish(build, build.request.reqContext);
    }

    public void onFinish(Response response, Object obj) {
        onFinish(response, obj, false);
    }

    public void onHeader(Response response, Object obj) {
        try {
            if (this.headerListener != null) {
                MtopHeaderEvent mtopHeaderEvent = new MtopHeaderEvent(response.code, response.headers);
                mtopHeaderEvent.seqNo = this.mtopContext.seqNo;
                this.headerListener.onHeader(mtopHeaderEvent, obj);
            }
        } catch (Throwable th) {
            TBSdkLog.e(TAG, this.mtopContext.seqNo, "onHeader failed.", th);
        }
    }

    @Override // mtopsdk.network.NetworkCallback
    public void onResponse(Call call, Response response) {
        onFinish(response, response.request.reqContext, true);
    }

    public void onFinish(final Response response, final Object obj, final boolean z) {
        MtopStatistics mtopStatistics = this.mtopContext.stats;
        mtopStatistics.netSendEndTime = mtopStatistics.currentTimeMillis();
        this.mtopContext.property.reqContext = obj;
        Runnable runnable = new Runnable() { // from class: mtopsdk.mtop.network.NetworkCallbackAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (z) {
                        NetworkCallbackAdapter.this.onHeader(response, obj);
                    }
                    MtopStatistics mtopStatistics2 = NetworkCallbackAdapter.this.mtopContext.stats;
                    mtopStatistics2.startCallbackTime = mtopStatistics2.currentTimeMillis();
                    NetworkCallbackAdapter.this.mtopContext.stats.bizRspProcessStart = System.currentTimeMillis();
                    MtopContext mtopContext = NetworkCallbackAdapter.this.mtopContext;
                    MtopStatistics mtopStatistics3 = mtopContext.stats;
                    Response response2 = response;
                    mtopStatistics3.netStats = response2.stat;
                    mtopContext.networkResponse = response2;
                    MtopResponse mtopResponse = new MtopResponse(mtopContext.mtopRequest.getApiName(), NetworkCallbackAdapter.this.mtopContext.mtopRequest.getVersion(), null, null);
                    mtopResponse.setResponseCode(response.code);
                    mtopResponse.setHeaderFields(response.headers);
                    mtopResponse.setMtopStat(NetworkCallbackAdapter.this.mtopContext.stats);
                    ResponseBody responseBody = response.body;
                    if (responseBody != null) {
                        try {
                            mtopResponse.setBytedata(responseBody.getBytes());
                        } catch (IOException e) {
                            TBSdkLog.e(NetworkCallbackAdapter.TAG, NetworkCallbackAdapter.this.mtopContext.seqNo, "call getBytes of response.body() error.", e);
                        }
                    }
                    NetworkCallbackAdapter networkCallbackAdapter = NetworkCallbackAdapter.this;
                    MtopContext mtopContext2 = networkCallbackAdapter.mtopContext;
                    mtopContext2.mtopResponse = mtopResponse;
                    networkCallbackAdapter.filterManager.callback(null, mtopContext2);
                } catch (Throwable th) {
                    TBSdkLog.e(NetworkCallbackAdapter.TAG, NetworkCallbackAdapter.this.mtopContext.seqNo, "onFinish failed.", th);
                }
            }
        };
        MtopContext mtopContext = this.mtopContext;
        FilterUtils.submitCallbackTask(mtopContext.property.handler, runnable, mtopContext.seqNo.hashCode());
    }
}
