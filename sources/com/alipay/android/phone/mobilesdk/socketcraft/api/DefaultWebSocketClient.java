package com.alipay.android.phone.mobilesdk.socketcraft.api;

import com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_17;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshake;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.MonitorHelper;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatUtil;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskUtil;
import com.alipay.android.phone.mobilesdk.socketcraft.util.Charsetfunctions;
import com.alipay.android.phone.mobilesdk.socketcraft.util.WsMessageConstants;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class DefaultWebSocketClient extends WebSocketClient {
    public static final int DEFAULT_CONNECTION_TIMEOUT = 60000;
    public static final int MIN_CONNECTION_TIMEOUT = 4000;
    private static final String TAG = "WebSocketClient";
    private long connectTimeout;
    private Framedata firstFragmentFrame;
    private MonitorHelper monitorHelper;
    private boolean myselfClosed;
    private ScheduledFuture<?> timeoutScheduleFuture;
    private String url;
    private WebSocketCallback webSocketCallback;
    private WebSocketContext webSocketContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class SCConnectionTimerRunnable implements Runnable {
        private static final String TAG = "SCConnectionTimerRunnable";
        private DefaultWebSocketClient defaultWebSocketClient;
        public WebSocketCallback webSocketCallback;

        SCConnectionTimerRunnable(DefaultWebSocketClient defaultWebSocketClient, WebSocketCallback webSocketCallback) {
            this.defaultWebSocketClient = defaultWebSocketClient;
            this.webSocketCallback = webSocketCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            SCLogCatUtil.error(TAG, "connect response time out");
            try {
                DefaultWebSocketClient.this.onError(WsMessageConstants.MSG_CONNECTION_TIME_OUT);
            } catch (Throwable th) {
                SCLogCatUtil.error(TAG, "onSocketError error", th);
            }
            try {
                this.defaultWebSocketClient.close();
            } catch (Throwable th2) {
                SCLogCatUtil.error(TAG, "close socket error", th2);
            }
        }
    }

    public DefaultWebSocketClient(URI uri, Draft draft, Map<String, String> map, int i, WebSocketCallback webSocketCallback, WebSocketContext webSocketContext) {
        super(uri, draft, map, i);
        this.myselfClosed = false;
        this.webSocketCallback = webSocketCallback;
        this.url = uri.toString();
        this.webSocketContext = webSocketContext;
        if (i > 4000) {
            this.connectTimeout = i;
        } else {
            this.connectTimeout = DanmakuFactory.MIN_DANMAKU_DURATION;
        }
        this.monitorHelper = new MonitorHelper(this);
    }

    private void afterConnect() {
        SCLogCatUtil.info(TAG, "enter afterConnect");
        this.monitorHelper.recordConnectedTime();
        this.monitorHelper.printConnMonitorLog();
    }

    private void beforeConnect() {
        SCLogCatUtil.info(TAG, "enter beforeConnect");
        this.monitorHelper.recordStartConnAllTime();
    }

    private void cancelTimeoutScheduleFuture() {
        try {
            SCLogCatUtil.info(TAG, "cancelTimeoutScheduleFuture. try to stop connectTimer");
            ScheduledFuture<?> scheduledFuture = this.timeoutScheduleFuture;
            if (scheduledFuture == null) {
                return;
            }
            scheduledFuture.cancel(true);
            this.timeoutScheduleFuture = null;
        } catch (Throwable th) {
            SCLogCatUtil.error(TAG, "cancelTimeoutScheduleFuture. Cancel old timeoutScheduleFuture error", th);
        }
    }

    private void startConnectionTimer() {
        cancelTimeoutScheduleFuture();
        this.timeoutScheduleFuture = SCNetworkAsyncTaskUtil.schedule(new SCConnectionTimerRunnable(this, this.webSocketCallback), this.connectTimeout, TimeUnit.MILLISECONDS);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient, com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void close() {
        try {
            SCLogCatUtil.info(TAG, "close. try to close socket");
            this.myselfClosed = true;
            super.close();
        } catch (Throwable th) {
            SCLogCatUtil.error(TAG, "send err. ", th);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void connect() {
        beforeConnect();
        super.connect();
        startConnectionTimer();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public boolean connectBlocking() {
        beforeConnect();
        return super.connectBlocking();
    }

    public void connectBlockingWithSSL() {
        setSslSocketFactory((SSLSocketFactory) SSLSocketFactory.getDefault());
        connectBlocking();
    }

    public void connectWithSSL() {
        setSslSocketFactory((SSLSocketFactory) SSLSocketFactory.getDefault());
        connect();
    }

    public String getBizUniqId() {
        Object attribute = getWebSocketContext().getAttribute(WSContextConstant.BIZ_UNIQUE_ID);
        return (attribute == null || !(attribute instanceof String)) ? "unkown" : String.valueOf(attribute);
    }

    public String getUrl() {
        return this.url;
    }

    public WebSocketCallback getWebSocketCallback() {
        return this.webSocketCallback;
    }

    public WebSocketContext getWebSocketContext() {
        WebSocketContext webSocketContext = this.webSocketContext;
        if (webSocketContext != null) {
            return webSocketContext;
        }
        synchronized (this) {
            WebSocketContext webSocketContext2 = this.webSocketContext;
            if (webSocketContext2 != null) {
                return webSocketContext2;
            }
            BasicWebSocketContext basicWebSocketContext = new BasicWebSocketContext();
            this.webSocketContext = basicWebSocketContext;
            return basicWebSocketContext;
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onClose(int i, String str, boolean z) {
        cancelTimeoutScheduleFuture();
        SCLogCatUtil.info(TAG, String.format("onClose. url is %s ,state: closed ,reason: %s, errCode = %d, remote = %s", this.url, str, Integer.valueOf(i), Boolean.toString(z)));
        if (!this.myselfClosed && (i == -1 || i == -2 || i == -3)) {
            onError(str);
        } else {
            this.webSocketCallback.onSocketClose();
        }
        this.monitorHelper.printDisconnMonitorLog();
        this.monitorHelper.noteTraficConsume(new DataflowMonitorModel(this.url, getBizUniqId(), "close", 0, 0));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onDns(String str, long j) {
        this.monitorHelper.recordDnsTime(j);
        this.monitorHelper.recordTargetHost(str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onError(Exception exc) {
        SCLogCatUtil.error(TAG, String.format("onError. url is %s ,error is %s", this.url, exc.toString()), exc);
        onSocketError("exception: " + exc.getMessage());
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onFragment(Framedata framedata) {
        Framedata framedata2;
        Framedata.Opcode opcode = framedata.getOpcode();
        Framedata.Opcode opcode2 = Framedata.Opcode.CONTINUOUS;
        if (opcode != opcode2 && !framedata.isFin()) {
            this.firstFragmentFrame = framedata;
        } else if (framedata.getOpcode() != opcode2 || (framedata2 = this.firstFragmentFrame) == null) {
        } else {
            if (framedata2.getPayloadData().position() > 10485760) {
                SCLogCatUtil.warn(TAG, "onFragment. Pending frame exploded");
                onError(new RuntimeException(WsMessageConstants.MSG_PENDING_FRAME_EXPLODED));
                close();
                this.firstFragmentFrame = null;
                return;
            }
            try {
                this.firstFragmentFrame.append(framedata);
            } catch (Throwable th) {
                SCLogCatUtil.warn(TAG, "onFragment. append frame err. ", th);
            }
            if (framedata.isFin()) {
                if (this.firstFragmentFrame.getOpcode() == Framedata.Opcode.BINARY) {
                    onMessage(this.firstFragmentFrame.getPayloadData());
                } else if (this.firstFragmentFrame.getOpcode() == Framedata.Opcode.TEXT) {
                    try {
                        String stringUtf8 = Charsetfunctions.stringUtf8(this.firstFragmentFrame.getPayloadData());
                        if (stringUtf8 == null) {
                            stringUtf8 = "";
                        }
                        onMessage(stringUtf8);
                    } catch (Throwable th2) {
                        SCLogCatUtil.warn(TAG, "onFragment. ByteBuffer to String err ", th2);
                    }
                }
                this.firstFragmentFrame = null;
            }
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onMessage(String str) {
        Object[] objArr = new Object[2];
        objArr[0] = this.url;
        objArr[1] = Integer.valueOf(str != null ? str.length() : -1);
        SCLogCatUtil.info(TAG, String.format("onMessage. url is %s ,socket onmessage length :%d", objArr));
        if (str == null || str.length() <= 0) {
            return;
        }
        this.webSocketCallback.onSocketMessage(str);
        this.monitorHelper.recordMonitorOfRecvMsg(str.length());
        this.monitorHelper.noteTraficConsume(new DataflowMonitorModel(this.url, getBizUniqId(), DataflowMonitorModel.METHOD_NAME_RECEIVE, 0, str.length()));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onOpen(ServerHandshake serverHandshake) {
        afterConnect();
        cancelTimeoutScheduleFuture();
        SCLogCatUtil.info(TAG, String.format("onOpen. url is %s , state: opened", this.url));
        this.webSocketCallback.onSocketOpen();
        this.monitorHelper.noteTraficConsume(new DataflowMonitorModel(this.url, getBizUniqId(), "connect", this.url.length() + 189, 185));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onSSLHandshake(long j) {
        this.monitorHelper.recordSSLTime(j);
    }

    public void onSocketError(String str) {
        this.webSocketCallback.onSocketError(str);
        this.monitorHelper.printErrorMonitorLog("1", str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onTcpConnect(String str, long j) {
        this.monitorHelper.recordTcpTime(j);
        this.monitorHelper.recordTargetHost(str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onWsHandshake(long j) {
        SCLogCatUtil.info(TAG, "onWsHandshake cost: " + j);
        this.monitorHelper.recordWsHsTime(j);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient, com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void send(String str) {
        if (str == null) {
            SCLogCatUtil.warn(TAG, "[send] text is null");
            return;
        }
        if (str.length() <= 0) {
            SCLogCatUtil.warn(TAG, "[send] text is empty, but continue send.");
        }
        super.send(str);
        this.monitorHelper.recordMonitorOfSndMsg(str.length());
        this.monitorHelper.noteTraficConsume(new DataflowMonitorModel(this.url, getBizUniqId(), "send", str.length(), 0));
    }

    public void setWebSocketContext(WebSocketContext webSocketContext) {
        this.webSocketContext = webSocketContext;
    }

    public void onError(String str) {
        SCLogCatUtil.error(TAG, String.format("onError. url is %s ,error is %s", this.url, str));
        onSocketError(str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient, com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void close(int i, String str) {
        try {
            SCLogCatUtil.info(TAG, "close. try to close socket");
            this.myselfClosed = true;
            super.close(i, str);
        } catch (Throwable th) {
            SCLogCatUtil.error(TAG, "send err. ", th);
        }
    }

    public DefaultWebSocketClient(URI uri, Draft draft, Map<String, String> map, int i, WebSocketCallback webSocketCallback) {
        this(uri, draft, map, i, webSocketCallback, new BasicWebSocketContext());
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onMessage(ByteBuffer byteBuffer) {
        Object[] objArr = new Object[2];
        objArr[0] = this.url;
        objArr[1] = Integer.valueOf(byteBuffer != null ? byteBuffer.position() : -1);
        SCLogCatUtil.info(TAG, String.format("onMessage. url is %s , socket onMessage buffer length : %d", objArr));
        if (byteBuffer == null) {
            return;
        }
        this.webSocketCallback.onSocketMessage(byteBuffer);
        this.monitorHelper.recordMonitorOfRecvMsg(byteBuffer.position());
        this.monitorHelper.noteTraficConsume(new DataflowMonitorModel(this.url, getBizUniqId(), DataflowMonitorModel.METHOD_NAME_RECEIVE, 0, byteBuffer.array().length));
    }

    public DefaultWebSocketClient(URI uri, Map<String, String> map, WebSocketCallback webSocketCallback) {
        this(uri, new Draft_17(), map, 60000, webSocketCallback);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient, com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void send(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            super.send(bArr);
            this.monitorHelper.recordMonitorOfSndMsg(bArr.length);
            this.monitorHelper.noteTraficConsume(new DataflowMonitorModel(this.url, getBizUniqId(), "send", bArr.length, 0));
            return;
        }
        SCLogCatUtil.warn(TAG, "[send] byte[] is null or length <= 0.");
    }

    public DefaultWebSocketClient(URI uri, Map<String, String> map, WebSocketCallback webSocketCallback, WebSocketContext webSocketContext) {
        this(uri, new Draft_17(), map, 60000, webSocketCallback, webSocketContext);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient, com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void send(ByteBuffer byteBuffer) {
        if (byteBuffer != null && byteBuffer.array().length > 0) {
            super.send(byteBuffer);
            this.monitorHelper.recordMonitorOfSndMsg(byteBuffer.array().length);
            this.monitorHelper.noteTraficConsume(new DataflowMonitorModel(this.url, getBizUniqId(), "send", byteBuffer.array().length, 0));
            return;
        }
        SCLogCatUtil.warn(TAG, "[send] ByteBuffer is null or length <= 0.");
    }
}
