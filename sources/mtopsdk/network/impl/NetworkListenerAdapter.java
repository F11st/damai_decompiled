package mtopsdk.network.impl;

import anetwork.channel.NetworkCallBack$FinishListener;
import anetwork.channel.NetworkCallBack$InputStreamListener;
import anetwork.channel.NetworkCallBack$ResponseCodeListener;
import anetwork.channel.NetworkEvent$FinishEvent;
import anetwork.channel.aidl.ParcelableInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.network.Call;
import mtopsdk.network.NetworkCallback;
import mtopsdk.network.domain.Response;
import mtopsdk.network.domain.ResponseBody;
import mtopsdk.network.util.ANetworkConverter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class NetworkListenerAdapter implements NetworkCallBack$FinishListener, NetworkCallBack$InputStreamListener, NetworkCallBack$ResponseCodeListener {
    private static final String TAG = "mtopsdk.NetworkListenerAdapter";
    Call call;
    Map<String, List<String>> headers;
    NetworkCallback networkCallback;
    final String seqNo;
    int statusCode;
    private volatile boolean isStreamReceived = false;
    NetworkEvent$FinishEvent finishEvent = null;
    boolean isNeedCallFinish = false;
    ByteArrayOutputStream bos = null;
    int resLength = 0;

    public NetworkListenerAdapter(Call call, NetworkCallback networkCallback, String str) {
        this.call = call;
        this.networkCallback = networkCallback;
        this.seqNo = str;
    }

    void callFinish(final NetworkEvent$FinishEvent networkEvent$FinishEvent, final Object obj) {
        String str = this.seqNo;
        MtopSDKThreadPoolExecutorFactory.submitCallbackTask(str != null ? str.hashCode() : hashCode(), new Runnable() { // from class: mtopsdk.network.impl.NetworkListenerAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    NetworkListenerAdapter.this.onFinishTask(networkEvent$FinishEvent, obj);
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                        String str2 = NetworkListenerAdapter.this.seqNo;
                        TBSdkLog.d(NetworkListenerAdapter.TAG, str2, "[callFinish] execute onFinishTask time[ms] " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                } catch (Exception e) {
                    TBSdkLog.e(NetworkListenerAdapter.TAG, NetworkListenerAdapter.this.seqNo, "[callFinish]execute onFinishTask error.", e);
                }
            }
        });
    }

    void onFinishTask(NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
        if (this.networkCallback == null) {
            TBSdkLog.e(TAG, this.seqNo, "[onFinishTask]networkCallback is null");
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = this.bos;
        final byte[] byteArray = byteArrayOutputStream != null ? byteArrayOutputStream.toByteArray() : null;
        this.networkCallback.onResponse(this.call, new Response.Builder().request(this.call.request()).code(networkEvent$FinishEvent.getHttpCode()).message(networkEvent$FinishEvent.getDesc()).headers(this.headers).body(new ResponseBody() { // from class: mtopsdk.network.impl.NetworkListenerAdapter.3
            @Override // mtopsdk.network.domain.ResponseBody
            public InputStream byteStream() {
                return null;
            }

            @Override // mtopsdk.network.domain.ResponseBody
            public long contentLength() throws IOException {
                byte[] bArr = byteArray;
                if (bArr != null) {
                    return bArr.length;
                }
                return 0L;
            }

            @Override // mtopsdk.network.domain.ResponseBody
            public String contentType() {
                return HeaderHandlerUtil.getSingleHeaderFieldByKey(NetworkListenerAdapter.this.headers, "Content-Type");
            }

            @Override // mtopsdk.network.domain.ResponseBody
            public byte[] getBytes() throws IOException {
                return byteArray;
            }
        }).stat(ANetworkConverter.convertNetworkStats(networkEvent$FinishEvent.getStatisticData())).build());
    }

    @Override // anetwork.channel.NetworkCallBack$FinishListener
    public void onFinished(NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
        synchronized (this) {
            this.finishEvent = networkEvent$FinishEvent;
            if (this.isNeedCallFinish || !this.isStreamReceived) {
                callFinish(networkEvent$FinishEvent, obj);
            }
        }
    }

    @Override // anetwork.channel.NetworkCallBack$InputStreamListener
    public void onInputStreamGet(final ParcelableInputStream parcelableInputStream, final Object obj) {
        this.isStreamReceived = true;
        MtopSDKThreadPoolExecutorFactory.submitRequestTask(new Runnable() { // from class: mtopsdk.network.impl.NetworkListenerAdapter.1
            /* JADX WARN: Code restructure failed: missing block: B:18:0x006e, code lost:
                if (r0 != null) goto L34;
             */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x0086, code lost:
                if (r0 == null) goto L20;
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x0088, code lost:
                r0.close();
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r7 = this;
                    mtopsdk.common.util.TBSdkLog$LogEnable r0 = mtopsdk.common.util.TBSdkLog.LogEnable.DebugEnable     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    boolean r0 = mtopsdk.common.util.TBSdkLog.isLogEnable(r0)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    if (r0 == 0) goto L13
                    java.lang.String r0 = "mtopsdk.NetworkListenerAdapter"
                    mtopsdk.network.impl.NetworkListenerAdapter r1 = mtopsdk.network.impl.NetworkListenerAdapter.this     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    java.lang.String r1 = r1.seqNo     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    java.lang.String r2 = "[onInputStreamGet]start to read input stream"
                    mtopsdk.common.util.TBSdkLog.d(r0, r1, r2)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                L13:
                    anetwork.channel.aidl.ParcelableInputStream r0 = r2     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    int r0 = r0.length()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    if (r0 <= 0) goto L22
                    anetwork.channel.aidl.ParcelableInputStream r0 = r2     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    int r0 = r0.length()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    goto L26
                L22:
                    mtopsdk.network.impl.NetworkListenerAdapter r0 = mtopsdk.network.impl.NetworkListenerAdapter.this     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    int r0 = r0.resLength     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                L26:
                    mtopsdk.network.impl.NetworkListenerAdapter r1 = mtopsdk.network.impl.NetworkListenerAdapter.this     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    r2.<init>(r0)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    r1.bos = r2     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    r0 = 4096(0x1000, float:5.74E-42)
                    byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                L33:
                    anetwork.channel.aidl.ParcelableInputStream r1 = r2     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    int r1 = r1.read(r0)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    r2 = -1
                    if (r1 == r2) goto L6c
                    mtopsdk.common.util.TBSdkLog$LogEnable r2 = mtopsdk.common.util.TBSdkLog.LogEnable.DebugEnable     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    boolean r2 = mtopsdk.common.util.TBSdkLog.isLogEnable(r2)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    r3 = 0
                    if (r2 == 0) goto L64
                    java.lang.String r2 = "mtopsdk.NetworkListenerAdapter"
                    mtopsdk.network.impl.NetworkListenerAdapter r4 = mtopsdk.network.impl.NetworkListenerAdapter.this     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    java.lang.String r4 = r4.seqNo     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    r5.<init>()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    java.lang.String r6 = "[onInputStreamGet]data chunk content: "
                    r5.append(r6)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    r6.<init>(r0, r3, r1)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    r5.append(r6)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    mtopsdk.common.util.TBSdkLog.d(r2, r4, r5)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                L64:
                    mtopsdk.network.impl.NetworkListenerAdapter r2 = mtopsdk.network.impl.NetworkListenerAdapter.this     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    java.io.ByteArrayOutputStream r2 = r2.bos     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    r2.write(r0, r3, r1)     // Catch: java.lang.Throwable -> L71 java.lang.Exception -> L73
                    goto L33
                L6c:
                    anetwork.channel.aidl.ParcelableInputStream r0 = r2
                    if (r0 == 0) goto L8b
                    goto L88
                L71:
                    r0 = move-exception
                    goto La9
                L73:
                    r0 = move-exception
                    java.lang.String r1 = "mtopsdk.NetworkListenerAdapter"
                    mtopsdk.network.impl.NetworkListenerAdapter r2 = mtopsdk.network.impl.NetworkListenerAdapter.this     // Catch: java.lang.Throwable -> L71
                    java.lang.String r2 = r2.seqNo     // Catch: java.lang.Throwable -> L71
                    java.lang.String r3 = "[onInputStreamGet]Read data from inputstream failed."
                    mtopsdk.common.util.TBSdkLog.e(r1, r2, r3, r0)     // Catch: java.lang.Throwable -> L71
                    mtopsdk.network.impl.NetworkListenerAdapter r0 = mtopsdk.network.impl.NetworkListenerAdapter.this     // Catch: java.lang.Throwable -> L71
                    r1 = 0
                    r0.bos = r1     // Catch: java.lang.Throwable -> L71
                    anetwork.channel.aidl.ParcelableInputStream r0 = r2
                    if (r0 == 0) goto L8b
                L88:
                    r0.close()     // Catch: java.lang.Exception -> L8b
                L8b:
                    mtopsdk.network.impl.NetworkListenerAdapter r0 = mtopsdk.network.impl.NetworkListenerAdapter.this
                    java.io.ByteArrayOutputStream r0 = r0.bos
                    mtopsdk.network.util.NetworkUtils.closeQuietly(r0)
                    mtopsdk.network.impl.NetworkListenerAdapter r0 = mtopsdk.network.impl.NetworkListenerAdapter.this
                    monitor-enter(r0)
                    mtopsdk.network.impl.NetworkListenerAdapter r1 = mtopsdk.network.impl.NetworkListenerAdapter.this     // Catch: java.lang.Throwable -> La6
                    anetwork.channel.NetworkEvent$FinishEvent r2 = r1.finishEvent     // Catch: java.lang.Throwable -> La6
                    if (r2 == 0) goto La1
                    java.lang.Object r3 = r3     // Catch: java.lang.Throwable -> La6
                    r1.callFinish(r2, r3)     // Catch: java.lang.Throwable -> La6
                    goto La4
                La1:
                    r2 = 1
                    r1.isNeedCallFinish = r2     // Catch: java.lang.Throwable -> La6
                La4:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> La6
                    return
                La6:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> La6
                    throw r1
                La9:
                    anetwork.channel.aidl.ParcelableInputStream r1 = r2
                    if (r1 == 0) goto Lb0
                    r1.close()     // Catch: java.lang.Exception -> Lb0
                Lb0:
                    mtopsdk.network.impl.NetworkListenerAdapter r1 = mtopsdk.network.impl.NetworkListenerAdapter.this
                    java.io.ByteArrayOutputStream r1 = r1.bos
                    mtopsdk.network.util.NetworkUtils.closeQuietly(r1)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: mtopsdk.network.impl.NetworkListenerAdapter.AnonymousClass1.run():void");
            }
        });
    }

    @Override // anetwork.channel.NetworkCallBack$ResponseCodeListener
    public boolean onResponseCode(int i, Map<String, List<String>> map, Object obj) {
        this.statusCode = i;
        this.headers = map;
        try {
            String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "content-length");
            if (StringUtils.isBlank(singleHeaderFieldByKey)) {
                singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(this.headers, HttpHeaderConstant.X_BIN_LENGTH);
            }
            if (StringUtils.isNotBlank(singleHeaderFieldByKey)) {
                this.resLength = Integer.parseInt(singleHeaderFieldByKey);
                return false;
            }
            return false;
        } catch (Exception unused) {
            TBSdkLog.e(TAG, this.seqNo, "[onResponseCode]parse Response HeaderField ContentLength error ");
            return false;
        }
    }
}
