package android.taobao.windvane.extra.uc;

import android.content.Context;
import android.net.Uri;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anetwork.channel.IBodyHandler;
import anetwork.channel.Network;
import anetwork.channel.NetworkCallBack$FinishListener;
import anetwork.channel.NetworkCallBack$ProgressListener;
import anetwork.channel.NetworkCallBack$ResponseCodeListener;
import anetwork.channel.NetworkEvent$FinishEvent;
import anetwork.channel.NetworkEvent$ProgressEvent;
import anetwork.channel.Request;
import anetwork.channel.Response;
import com.taobao.analysis.v3.FalcoGlobalTracer;
import com.taobao.analysis.v3.FalcoTracer;
import com.uc.webview.export.internal.interfaces.EventHandler;
import com.uc.webview.export.internal.interfaces.INetwork;
import com.uc.webview.export.internal.interfaces.IRequest;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.apache.http.ParseException;
import tb.k01;
import tb.k60;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AliNetworkAdapter implements INetwork {
    public static final int NETWORK_WORKING_MODE_ASYNC = 1;
    public static final int NETWORK_WORKING_MODE_SYNC = 0;
    private int BUFFER_SIZE;
    String LOGTAG;
    private String bizCode;
    public boolean isReload;
    public boolean isStop;
    private boolean isUseWebpImg;
    private Network mAliNetwork;
    private Context mContext;
    private int mNetworkType;
    private int mWorkingMode;
    public HashSet<EventHandler> mainRequest;
    private WVUCWebView webView;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class AliNetCallback implements NetworkCallBack$FinishListener, NetworkCallBack$ProgressListener, NetworkCallBack$ResponseCodeListener {
        EventHandler mEventHandler;
        IRequest mReq;
        String mUrl;
        int size = 0;
        int total = 0;

        protected AliNetCallback() {
        }

        @Override // anetwork.channel.NetworkCallBack$ProgressListener
        public void onDataReceived(NetworkEvent$ProgressEvent networkEvent$ProgressEvent, Object obj) {
            if (TaoLog.getLogStatus()) {
                TaoLog.d(AliNetworkAdapter.this.LOGTAG, "[onDataReceived] event:" + networkEvent$ProgressEvent + "event.getSize():" + networkEvent$ProgressEvent.getSize() + ", data:" + networkEvent$ProgressEvent.getBytedata().length + " bytes");
            }
            this.mEventHandler.data(networkEvent$ProgressEvent.getBytedata(), networkEvent$ProgressEvent.getSize());
            this.size += networkEvent$ProgressEvent.getSize();
            if (this.total == 0) {
                this.total = networkEvent$ProgressEvent.getTotal();
            }
        }

        @Override // anetwork.channel.NetworkCallBack$FinishListener
        public void onFinished(NetworkEvent$FinishEvent networkEvent$FinishEvent, Object obj) {
            if (TaoLog.getLogStatus()) {
                String str = AliNetworkAdapter.this.LOGTAG;
                TaoLog.d(str, "[onFinished] event:" + networkEvent$FinishEvent);
                String str2 = AliNetworkAdapter.this.LOGTAG;
                TaoLog.e(str2, "onFinished code = " + networkEvent$FinishEvent.getHttpCode() + ", url = " + this.mUrl + ", rev_size = " + this.size + ", total_size = " + this.total);
            }
            if (WVMonitorService.getPerformanceMonitor() != null) {
                try {
                    String str3 = networkEvent$FinishEvent.getStatisticData().connectionType;
                    long j = networkEvent$FinishEvent.getStatisticData().tcpConnTime;
                    WVMonitorService.getPerformanceMonitor().didResourceFinishLoadAtTime(this.mUrl, System.currentTimeMillis(), str3, 0L);
                } catch (Throwable th) {
                    WVMonitorService.getPerformanceMonitor().didResourceFinishLoadAtTime(this.mUrl, System.currentTimeMillis(), "unknown", 0L);
                    String str4 = AliNetworkAdapter.this.LOGTAG;
                    TaoLog.e(str4, "didResourceFinishLoadAtTime failed : " + th.getMessage());
                }
            }
            AliRequestAdapter aliRequestAdapter = (AliRequestAdapter) this.mReq;
            int httpCode = networkEvent$FinishEvent.getHttpCode();
            UCNetworkDelegate.getInstance().onFinish(httpCode, this.mUrl);
            if (httpCode < 0) {
                if (TaoLog.getLogStatus()) {
                    String str5 = AliNetworkAdapter.this.LOGTAG;
                    TaoLog.e(str5, "error code=" + httpCode + ",desc=" + networkEvent$FinishEvent.getDesc() + ",url=" + this.mUrl);
                }
                this.mEventHandler.error(httpCode, networkEvent$FinishEvent.getDesc());
                aliRequestAdapter.complete();
                return;
            }
            if (TaoLog.getLogStatus()) {
                TaoLog.d(AliNetworkAdapter.this.LOGTAG, "endData");
            }
            aliRequestAdapter.cancelPhase = AliRequestAdapter.PHASE_ENDDATA;
            this.mEventHandler.endData();
            aliRequestAdapter.complete();
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x008f A[Catch: all -> 0x00e2, TryCatch #0 {all -> 0x00e2, blocks: (B:3:0x0003, B:5:0x0015, B:7:0x0023, B:11:0x0033, B:13:0x003b, B:15:0x0043, B:27:0x005f, B:29:0x0069, B:31:0x0073, B:33:0x007f, B:35:0x0089, B:37:0x008f, B:39:0x0097, B:42:0x00a0, B:44:0x00a8, B:45:0x00bc, B:46:0x00d0), top: B:66:0x0003 }] */
        @Override // anetwork.channel.NetworkCallBack$ResponseCodeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onResponseCode(int r8, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r9, java.lang.Object r10) {
            /*
                Method dump skipped, instructions count: 342
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.uc.AliNetworkAdapter.AliNetCallback.onResponseCode(int, java.util.Map, java.lang.Object):boolean");
        }

        public void setEventHandler(EventHandler eventHandler) {
            this.mEventHandler = eventHandler;
        }

        public void setRequest(IRequest iRequest) {
            this.mReq = iRequest;
        }

        public void setURL(String str) {
            this.mUrl = str;
        }
    }

    public AliNetworkAdapter(Context context) {
        this(context, "windvane");
    }

    private void injectTraceContext(Request request) {
        try {
            WVUCWebView wVUCWebView = this.webView;
            if (wVUCWebView != null && wVUCWebView.getSpanWrapper() != null) {
                FalcoTracer falcoTracer = FalcoGlobalTracer.get();
                if (falcoTracer != null) {
                    request.setTraceContext(falcoTracer.injectContextToMap(this.webView.getSpanWrapper().context()));
                }
            } else if (this.webView == null) {
                TaoLog.i(this.LOGTAG, "webView == null");
            } else {
                TaoLog.i(this.LOGTAG, "webView.getFalcoSpan() == null");
            }
        } catch (Throwable th) {
            TaoLog.e(this.LOGTAG, CommonUtils.getStackTrace(th));
        }
    }

    private boolean sendRequestInternal(AliRequestAdapter aliRequestAdapter) {
        Request aliRequest = aliRequestAdapter.getAliRequest();
        injectTraceContext(aliRequest);
        EventHandler eventHandler = aliRequestAdapter.getEventHandler();
        if (TaoLog.getLogStatus()) {
            String str = this.LOGTAG;
            TaoLog.d(str, "requestURL eventId=" + aliRequestAdapter.getEventHandler().hashCode() + ", url=" + aliRequestAdapter.getUrl() + ",isSync=" + eventHandler.isSynchronous());
        }
        int i = this.mWorkingMode;
        if (i == 0) {
            Response syncSend = this.mAliNetwork.syncSend(aliRequest, null);
            Throwable error = syncSend.getError();
            if (error != null) {
                eventHandler.error(getErrorFromException(error), error.toString());
            } else {
                int statusCode = syncSend.getStatusCode();
                String str2 = syncSend.getStatisticData().connectionType;
                if (!TextUtils.isEmpty(str2) && str2.startsWith(ConnType.HTTP2)) {
                    eventHandler.status(2, 0, statusCode, "");
                } else {
                    eventHandler.status(0, 0, statusCode, "");
                }
                if (TaoLog.getLogStatus()) {
                    String str3 = this.LOGTAG;
                    TaoLog.d(str3, "status code=" + statusCode);
                }
                eventHandler.headers(syncSend.getConnHeadFields());
                byte[] bytedata = syncSend.getBytedata();
                if (bytedata != null) {
                    eventHandler.data(bytedata, bytedata.length);
                }
                aliRequestAdapter.cancelPhase = AliRequestAdapter.PHASE_ENDDATA;
                eventHandler.endData();
            }
        } else if (i == 1) {
            AliNetCallback aliNetCallback = new AliNetCallback();
            aliNetCallback.setEventHandler(eventHandler);
            aliNetCallback.setURL(aliRequestAdapter.getUrl());
            aliNetCallback.setRequest(aliRequestAdapter);
            aliRequestAdapter.setFutureResponse(this.mAliNetwork.asyncSend(aliRequest, null, null, aliNetCallback));
        }
        return true;
    }

    private void setRequestBodyHandler(Request request, AliRequestAdapter aliRequestAdapter) {
        if (aliRequestAdapter.getUploadFileTotalLen() != 0) {
            Map<String, String> uploadFileMap = aliRequestAdapter.getUploadFileMap();
            Map<String, byte[]> uploadDataMap = aliRequestAdapter.getUploadDataMap();
            request.setBodyHandler(new IBodyHandler(uploadFileMap.size() + uploadDataMap.size(), uploadFileMap, uploadDataMap) { // from class: android.taobao.windvane.extra.uc.AliNetworkAdapter.1
                byte[] buffer;
                List<InputStream> instream;
                final /* synthetic */ Map val$dataMap;
                final /* synthetic */ Map val$fileMap;
                final /* synthetic */ int val$totalFileNum;
                boolean isCompleted = false;
                int postedLen = 0;
                int curFilenum = 0;
                String fileNameValue = null;
                byte[] dataValue = null;
                boolean hasInitilized = false;

                {
                    this.val$totalFileNum = r2;
                    this.val$fileMap = uploadFileMap;
                    this.val$dataMap = uploadDataMap;
                    this.buffer = new byte[AliNetworkAdapter.this.BUFFER_SIZE];
                    this.instream = new ArrayList(r2);
                }

                public void initStream() {
                    try {
                        this.curFilenum = 0;
                        while (true) {
                            int i = this.curFilenum;
                            if (i >= this.val$totalFileNum) {
                                return;
                            }
                            this.fileNameValue = (String) this.val$fileMap.get(String.valueOf(i));
                            this.dataValue = (byte[]) this.val$dataMap.get(String.valueOf(this.curFilenum));
                            if (TaoLog.getLogStatus() && this.dataValue != null) {
                                String str = AliNetworkAdapter.this.LOGTAG;
                                StringBuilder sb = new StringBuilder();
                                sb.append("len =");
                                sb.append(this.dataValue.length);
                                sb.append(",datavalue=");
                                byte[] bArr = this.dataValue;
                                sb.append(new String(bArr, 0, bArr.length));
                                TaoLog.d(str, sb.toString());
                            }
                            String str2 = this.fileNameValue;
                            if (str2 != null) {
                                if (str2.toLowerCase().startsWith("content://")) {
                                    this.instream.add(this.curFilenum, AliNetworkAdapter.this.mContext.getContentResolver().openInputStream(Uri.parse(this.fileNameValue)));
                                } else {
                                    this.instream.add(this.curFilenum, new FileInputStream(this.fileNameValue));
                                }
                            } else {
                                this.instream.add(this.curFilenum, new ByteArrayInputStream(this.dataValue));
                            }
                            this.curFilenum++;
                        }
                    } catch (Exception unused) {
                    }
                }

                @Override // anetwork.channel.IBodyHandler
                public boolean isCompleted() {
                    boolean z = this.isCompleted;
                    if (z) {
                        this.isCompleted = false;
                        this.hasInitilized = false;
                        try {
                            for (InputStream inputStream : this.instream) {
                                inputStream.close();
                            }
                            this.instream.clear();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return true;
                    }
                    return z;
                }

                @Override // anetwork.channel.IBodyHandler
                public int read(byte[] bArr) {
                    if (!this.hasInitilized) {
                        initStream();
                        List<InputStream> list = this.instream;
                        if (list != null && list.size() != 0) {
                            this.hasInitilized = true;
                        } else {
                            this.isCompleted = true;
                            return 0;
                        }
                    }
                    for (InputStream inputStream : this.instream) {
                        try {
                            int read = inputStream.read(this.buffer, 0, AliNetworkAdapter.this.BUFFER_SIZE > bArr.length ? bArr.length : AliNetworkAdapter.this.BUFFER_SIZE);
                            if (read != -1) {
                                System.arraycopy(this.buffer, 0, bArr, 0, read);
                                this.postedLen += read;
                                TaoLog.i(AliNetworkAdapter.this.LOGTAG, "read len=" + read);
                                return read;
                            }
                        } catch (Exception e) {
                            TaoLog.i(AliNetworkAdapter.this.LOGTAG, "read exception" + e.getMessage());
                            this.isCompleted = true;
                            return 0;
                        }
                    }
                    TaoLog.i(AliNetworkAdapter.this.LOGTAG, "read finish");
                    this.isCompleted = true;
                    return 0;
                }
            });
        }
    }

    public static boolean willLog(EventHandler eventHandler) {
        int resourceType = eventHandler.getResourceType();
        return resourceType == 0 || resourceType == 14 || eventHandler.isSynchronous();
    }

    @Override // com.uc.webview.export.internal.interfaces.INetwork
    public void cancelPrefetchLoad() {
    }

    @Override // com.uc.webview.export.internal.interfaces.INetwork
    public void clearUserSslPrefTable() {
    }

    @Override // com.uc.webview.export.internal.interfaces.INetwork
    public IRequest formatRequest(EventHandler eventHandler, String str, String str2, boolean z, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, byte[]> map4, long j, int i, int i2) {
        AliRequestAdapter aliRequestAdapter;
        AliRequestAdapter aliRequestAdapter2 = new AliRequestAdapter(eventHandler, Escape.tryDecodeUrl(str), str2, z, map, map2, map3, map4, j, i, i2, this.isUseWebpImg, this.bizCode);
        if (this.isReload) {
            aliRequestAdapter = aliRequestAdapter2;
            aliRequestAdapter.cancelPhase = "reload";
        } else {
            aliRequestAdapter = aliRequestAdapter2;
        }
        setRequestBodyHandler(aliRequestAdapter.getAliRequest(), aliRequestAdapter);
        eventHandler.setRequest(aliRequestAdapter);
        eventHandler.setResourceType(i);
        return aliRequestAdapter;
    }

    public int getErrorFromException(Throwable th) {
        if (th instanceof ParseException) {
            return -43;
        }
        if (th instanceof SocketTimeoutException) {
            return -46;
        }
        if (th instanceof SocketException) {
            return -47;
        }
        if (th instanceof IOException) {
            return -44;
        }
        if (th instanceof IllegalStateException) {
            return -45;
        }
        return th instanceof UnknownHostException ? -2 : -99;
    }

    @Override // com.uc.webview.export.internal.interfaces.INetwork
    public int getNetworkType() {
        return 1;
    }

    @Override // com.uc.webview.export.internal.interfaces.INetwork
    public String getVersion() {
        return "1.0";
    }

    @Override // com.uc.webview.export.internal.interfaces.INetwork
    public boolean requestURL(EventHandler eventHandler, String str, String str2, boolean z, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, byte[]> map4, long j, int i, int i2) {
        String str3 = this.LOGTAG;
        TaoLog.d(str3, "requestURL:" + str + " isUCProxyReq:" + z + " requestType:" + i);
        AliRequestAdapter aliRequestAdapter = new AliRequestAdapter(eventHandler, Escape.tryDecodeUrl(str), str2, z, map, map2, map3, map4, j, i, i2, this.isUseWebpImg, this.bizCode);
        if (this.isReload) {
            aliRequestAdapter.cancelPhase = "reload";
        }
        setRequestBodyHandler(aliRequestAdapter.getAliRequest(), aliRequestAdapter);
        eventHandler.setRequest(aliRequestAdapter);
        return sendRequestInternal(aliRequestAdapter);
    }

    @Override // com.uc.webview.export.internal.interfaces.INetwork
    public boolean sendRequest(IRequest iRequest) {
        return sendRequestInternal((AliRequestAdapter) iRequest);
    }

    public AliNetworkAdapter(Context context, String str) {
        this(context, 2, str);
    }

    public AliNetworkAdapter(Context context, String str, WVUCWebView wVUCWebView) {
        this(context, 2, str);
        this.webView = wVUCWebView;
    }

    public AliNetworkAdapter(Context context, int i) {
        this(context, i, "windvane");
    }

    public AliNetworkAdapter(Context context, int i, String str) {
        this.LOGTAG = "AliNetwork";
        this.mNetworkType = -1;
        this.mWorkingMode = 1;
        this.BUFFER_SIZE = 1024;
        this.isUseWebpImg = true;
        this.bizCode = "";
        this.isReload = false;
        this.isStop = false;
        this.mainRequest = new HashSet<>();
        this.mContext = context;
        this.mNetworkType = i;
        this.bizCode = str;
        if (WVCommonConfig.commonConfig.ucsdk_image_strategy_rate > Math.random()) {
            this.isUseWebpImg = true;
        } else {
            this.isUseWebpImg = false;
        }
        int i2 = this.mNetworkType;
        if (i2 == 0) {
            this.mAliNetwork = new k01(context);
        } else if (i2 == 1 || i2 == 2) {
            this.mAliNetwork = new k60(context);
        }
    }
}
