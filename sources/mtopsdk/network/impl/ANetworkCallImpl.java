package mtopsdk.network.impl;

import android.content.Context;
import anetwork.channel.Network;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MockResponse;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.network.AbstractCallImpl;
import mtopsdk.network.NetworkCallback;
import mtopsdk.network.domain.Request;
import mtopsdk.network.domain.Response;
import mtopsdk.network.util.ANetworkConverter;
import tb.k01;
import tb.k60;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ANetworkCallImpl extends AbstractCallImpl {
    private static final String TAG = "mtopsdk.ANetworkCallImpl";
    Network mDegradalbeNetwork;
    Network mHttpNetwork;
    Network mNetwork;

    public ANetworkCallImpl(Request request, Context context) {
        super(request, context);
        if (!SwitchConfig.getInstance().isGlobalSpdySwitchOpen()) {
            if (this.mHttpNetwork == null) {
                this.mHttpNetwork = new k01(this.mContext);
            }
            this.mNetwork = this.mHttpNetwork;
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, this.seqNo, "mNetwork=HttpNetwork in ANetworkCallImpl");
                return;
            }
            return;
        }
        k60 k60Var = new k60(this.mContext);
        this.mDegradalbeNetwork = k60Var;
        this.mNetwork = k60Var;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, this.seqNo, "mNetwork=DegradableNetwork in ANetworkCallImpl");
        }
    }

    @Override // mtopsdk.network.Call
    public void enqueue(final NetworkCallback networkCallback) {
        MockResponse mockResponse;
        Request request = request();
        if (AbstractCallImpl.isDebugApk && AbstractCallImpl.isOpenMock) {
            mockResponse = getMockResponse(request.api);
            if (mockResponse != null) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i(TAG, this.seqNo, "[enqueue]get MockResponse succeed.mockResponse=" + mockResponse);
                }
                final Response buildResponse = buildResponse(request, mockResponse.statusCode, null, mockResponse.headers, mockResponse.byteData, null);
                String str = this.seqNo;
                MtopSDKThreadPoolExecutorFactory.submitCallbackTask(str != null ? str.hashCode() : hashCode(), new Runnable() { // from class: mtopsdk.network.impl.ANetworkCallImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            networkCallback.onResponse(ANetworkCallImpl.this, buildResponse);
                        } catch (Exception e) {
                            TBSdkLog.e(ANetworkCallImpl.TAG, ((AbstractCallImpl) ANetworkCallImpl.this).seqNo, "[enqueue]call NetworkCallback.onResponse error.", e);
                        }
                    }
                });
                return;
            }
        } else {
            mockResponse = null;
        }
        if (mockResponse == null) {
            this.future = this.mNetwork.asyncSend(ANetworkConverter.convertRequest(request), request.reqContext, null, new NetworkListenerAdapter(this, networkCallback, request.seqNo));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    @Override // mtopsdk.network.Call
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public mtopsdk.network.domain.Response execute() throws java.lang.Exception {
        /*
            r9 = this;
            mtopsdk.network.domain.Request r1 = r9.request()
            boolean r0 = mtopsdk.network.AbstractCallImpl.isDebugApk
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L3f
            boolean r0 = mtopsdk.network.AbstractCallImpl.isOpenMock
            if (r0 == 0) goto L3f
            java.lang.String r0 = r1.api
            mtopsdk.mtop.domain.MockResponse r0 = r9.getMockResponse(r0)
            if (r0 == 0) goto L3d
            int r3 = r0.statusCode
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r4 = r0.headers
            byte[] r5 = r0.byteData
            mtopsdk.common.util.TBSdkLog$LogEnable r6 = mtopsdk.common.util.TBSdkLog.LogEnable.InfoEnable
            boolean r6 = mtopsdk.common.util.TBSdkLog.isLogEnable(r6)
            if (r6 == 0) goto L42
            java.lang.String r6 = r9.seqNo
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "[execute]get MockResponse succeed.mockResponse="
            r7.append(r8)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "mtopsdk.ANetworkCallImpl"
            mtopsdk.common.util.TBSdkLog.i(r8, r6, r7)
            goto L42
        L3d:
            r4 = r2
            goto L41
        L3f:
            r0 = r2
            r4 = r0
        L41:
            r5 = r4
        L42:
            if (r0 != 0) goto L6a
            anetwork.channel.Network r0 = r9.mNetwork
            anetwork.channel.Request r2 = mtopsdk.network.util.ANetworkConverter.convertRequest(r1)
            java.lang.Object r3 = r1.reqContext
            anetwork.channel.Response r0 = r0.syncSend(r2, r3)
            int r2 = r0.getStatusCode()
            java.lang.String r3 = r0.getDesc()
            java.util.Map r4 = r0.getConnHeadFields()
            byte[] r5 = r0.getBytedata()
            anetwork.channel.statist.StatisticData r0 = r0.getStatisticData()
            mtopsdk.network.domain.NetworkStats r0 = mtopsdk.network.util.ANetworkConverter.convertNetworkStats(r0)
            r6 = r0
            goto L6d
        L6a:
            r6 = r2
            r2 = r3
            r3 = r6
        L6d:
            r0 = r9
            mtopsdk.network.domain.Response r0 = r0.buildResponse(r1, r2, r3, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.network.impl.ANetworkCallImpl.execute():mtopsdk.network.domain.Response");
    }

    @Override // mtopsdk.network.Ext
    public boolean isNoNetworkError(int i) {
        return i == -200;
    }
}
