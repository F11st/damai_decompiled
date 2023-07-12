package com.alibaba.gaiax.studio.third.socket.websocket.dispatcher;

import android.text.TextUtils;
import com.alibaba.gaiax.studio.third.socket.java_websocket.framing.Framedata;
import com.alibaba.gaiax.studio.third.socket.websocket.SocketListener;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import tb.gf0;
import tb.um2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MainThreadResponseDelivery implements ResponseDelivery {
    private static final Object b = new Object();
    private static Queue<CallbackRunnable> c;
    private final List<SocketListener> a = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    enum RUNNABLE_TYPE {
        NON,
        CONNECTED,
        CONNECT_FAILED,
        DISCONNECT,
        SEND_ERROR,
        STRING_MSG,
        BYTE_BUFFER_MSG,
        PING,
        PONG
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.MainThreadResponseDelivery$a */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class C3395a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RUNNABLE_TYPE.values().length];
            a = iArr;
            try {
                iArr[RUNNABLE_TYPE.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RUNNABLE_TYPE.CONNECT_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RUNNABLE_TYPE.DISCONNECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RUNNABLE_TYPE.SEND_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RUNNABLE_TYPE.STRING_MSG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RUNNABLE_TYPE.BYTE_BUFFER_MSG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RUNNABLE_TYPE.PING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[RUNNABLE_TYPE.PONG.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private CallbackRunnable c() {
        if (c == null) {
            c = new ArrayDeque(5);
        }
        CallbackRunnable poll = c.poll();
        return poll == null ? new CallbackRunnable(null) : poll;
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery
    public void addListener(SocketListener socketListener) {
        if (socketListener == null || this.a.contains(socketListener)) {
            return;
        }
        synchronized (b) {
            this.a.add(socketListener);
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery
    public void clear() {
        if (this.a.isEmpty()) {
            return;
        }
        synchronized (b) {
            this.a.clear();
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onConnectFailed(Throwable th) {
        if (isEmpty()) {
            return;
        }
        if (um2.b()) {
            synchronized (b) {
                for (SocketListener socketListener : this.a) {
                    socketListener.onConnectFailed(th);
                }
            }
            return;
        }
        CallbackRunnable c2 = c();
        c2.type = RUNNABLE_TYPE.CONNECT_FAILED;
        c2.connectErrorCause = th;
        c2.mSocketListenerList = this.a;
        um2.c(c2);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onConnected() {
        if (isEmpty()) {
            return;
        }
        if (um2.b()) {
            synchronized (b) {
                for (SocketListener socketListener : this.a) {
                    socketListener.onConnected();
                }
            }
            return;
        }
        CallbackRunnable c2 = c();
        c2.type = RUNNABLE_TYPE.CONNECTED;
        c2.mSocketListenerList = this.a;
        um2.c(c2);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onDisconnect() {
        if (isEmpty()) {
            return;
        }
        if (um2.b()) {
            synchronized (b) {
                for (SocketListener socketListener : this.a) {
                    socketListener.onDisconnect();
                }
            }
            return;
        }
        CallbackRunnable c2 = c();
        c2.type = RUNNABLE_TYPE.DISCONNECT;
        c2.mSocketListenerList = this.a;
        um2.c(c2);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public <T> void onMessage(String str, T t) {
        if (isEmpty() || str == null) {
            return;
        }
        if (um2.b()) {
            synchronized (b) {
                for (SocketListener socketListener : this.a) {
                    socketListener.onMessage(str, (String) t);
                }
            }
            return;
        }
        CallbackRunnable c2 = c();
        c2.type = RUNNABLE_TYPE.STRING_MSG;
        c2.textResponse = str;
        c2.formattedData = t;
        c2.mSocketListenerList = this.a;
        um2.c(c2);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onPing(Framedata framedata) {
        if (isEmpty()) {
            return;
        }
        if (um2.b()) {
            synchronized (b) {
                for (SocketListener socketListener : this.a) {
                    socketListener.onPing(framedata);
                }
            }
            return;
        }
        CallbackRunnable c2 = c();
        c2.type = RUNNABLE_TYPE.PING;
        c2.framedataResponse = framedata;
        c2.mSocketListenerList = this.a;
        um2.c(c2);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onPong(Framedata framedata) {
        if (isEmpty()) {
            return;
        }
        if (um2.b()) {
            synchronized (b) {
                for (SocketListener socketListener : this.a) {
                    socketListener.onPong(framedata);
                }
            }
            return;
        }
        CallbackRunnable c2 = c();
        c2.type = RUNNABLE_TYPE.PONG;
        c2.framedataResponse = framedata;
        c2.mSocketListenerList = this.a;
        um2.c(c2);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public void onSendDataError(gf0 gf0Var) {
        if (isEmpty() || gf0Var == null) {
            return;
        }
        if (um2.b()) {
            synchronized (b) {
                for (SocketListener socketListener : this.a) {
                    socketListener.onSendDataError(gf0Var);
                }
            }
            return;
        }
        CallbackRunnable c2 = c();
        c2.type = RUNNABLE_TYPE.SEND_ERROR;
        c2.errorResponse = gf0Var;
        c2.mSocketListenerList = this.a;
        um2.c(c2);
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.dispatcher.ResponseDelivery
    public void removeListener(SocketListener socketListener) {
        if (socketListener == null || isEmpty() || !this.a.contains(socketListener)) {
            return;
        }
        synchronized (b) {
            this.a.remove(socketListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class CallbackRunnable<T> implements Runnable {
        ByteBuffer byteResponse;
        Throwable connectErrorCause;
        gf0 errorResponse;
        T formattedData;
        Framedata framedataResponse;
        List<SocketListener> mSocketListenerList;
        String textResponse;
        RUNNABLE_TYPE type;

        private CallbackRunnable() {
            this.type = RUNNABLE_TYPE.NON;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<SocketListener> list;
            RUNNABLE_TYPE runnable_type;
            RUNNABLE_TYPE runnable_type2;
            try {
                if (this.type != RUNNABLE_TYPE.NON && (list = this.mSocketListenerList) != null && !list.isEmpty() && (((runnable_type = this.type) != RUNNABLE_TYPE.CONNECT_FAILED || this.connectErrorCause != null) && ((runnable_type != RUNNABLE_TYPE.SEND_ERROR || this.errorResponse != null) && ((runnable_type != RUNNABLE_TYPE.STRING_MSG || !TextUtils.isEmpty(this.textResponse)) && (((runnable_type2 = this.type) != RUNNABLE_TYPE.BYTE_BUFFER_MSG || this.byteResponse != null) && ((runnable_type2 != RUNNABLE_TYPE.PING || this.framedataResponse != null) && (runnable_type2 != RUNNABLE_TYPE.PONG || this.framedataResponse != null))))))) {
                    synchronized (MainThreadResponseDelivery.b) {
                        switch (C3395a.a[this.type.ordinal()]) {
                            case 1:
                                for (SocketListener socketListener : this.mSocketListenerList) {
                                    socketListener.onConnected();
                                }
                                break;
                            case 2:
                                for (SocketListener socketListener2 : this.mSocketListenerList) {
                                    socketListener2.onConnectFailed(this.connectErrorCause);
                                }
                                break;
                            case 3:
                                for (SocketListener socketListener3 : this.mSocketListenerList) {
                                    socketListener3.onDisconnect();
                                }
                                break;
                            case 4:
                                for (SocketListener socketListener4 : this.mSocketListenerList) {
                                    socketListener4.onSendDataError(this.errorResponse);
                                }
                                break;
                            case 5:
                                for (SocketListener socketListener5 : this.mSocketListenerList) {
                                    socketListener5.onMessage(this.textResponse, (String) this.formattedData);
                                }
                                break;
                            case 6:
                                for (SocketListener socketListener6 : this.mSocketListenerList) {
                                    socketListener6.onMessage(this.byteResponse, (ByteBuffer) this.formattedData);
                                }
                                break;
                            case 7:
                                for (SocketListener socketListener7 : this.mSocketListenerList) {
                                    socketListener7.onPing(this.framedataResponse);
                                }
                                break;
                            case 8:
                                for (SocketListener socketListener8 : this.mSocketListenerList) {
                                    socketListener8.onPong(this.framedataResponse);
                                }
                                break;
                        }
                        this.mSocketListenerList = null;
                        this.errorResponse = null;
                        this.connectErrorCause = null;
                        this.textResponse = null;
                        this.byteResponse = null;
                        this.framedataResponse = null;
                        this.formattedData = null;
                    }
                }
            } finally {
                MainThreadResponseDelivery.c.offer(this);
            }
        }

        /* synthetic */ CallbackRunnable(C3395a c3395a) {
            this();
        }
    }

    @Override // com.alibaba.gaiax.studio.third.socket.websocket.SocketListener
    public <T> void onMessage(ByteBuffer byteBuffer, T t) {
        if (isEmpty() || byteBuffer == null) {
            return;
        }
        if (um2.b()) {
            synchronized (b) {
                for (SocketListener socketListener : this.a) {
                    socketListener.onMessage(byteBuffer, (ByteBuffer) t);
                }
            }
            return;
        }
        CallbackRunnable c2 = c();
        c2.type = RUNNABLE_TYPE.BYTE_BUFFER_MSG;
        c2.byteResponse = byteBuffer;
        c2.formattedData = t;
        c2.mSocketListenerList = this.a;
        um2.c(c2);
    }
}
