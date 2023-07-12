package anetwork.channel.aidl.adapter;

import android.os.Handler;
import android.os.RemoteException;
import anet.channel.util.ALog;
import anetwork.channel.NetworkCallBack$FinishListener;
import anetwork.channel.NetworkCallBack$InputStreamListener;
import anetwork.channel.NetworkCallBack$ProgressListener;
import anetwork.channel.NetworkCallBack$ResponseCodeListener;
import anetwork.channel.NetworkListener;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.DefaultProgressEvent;
import anetwork.channel.aidl.ParcelableHeader;
import anetwork.channel.aidl.ParcelableInputStream;
import anetwork.channel.aidl.ParcelableNetworkListener;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ParcelableNetworkListenerWrapper extends ParcelableNetworkListener.Stub {
    private static final String TAG = "anet.ParcelableNetworkListenerWrapper";
    private Handler handler;
    private NetworkListener listener;
    private Object mContext;
    private byte state;

    public ParcelableNetworkListenerWrapper(NetworkListener networkListener, Handler handler, Object obj) {
        this.state = (byte) 0;
        this.listener = networkListener;
        if (networkListener != null) {
            if (NetworkCallBack$FinishListener.class.isAssignableFrom(networkListener.getClass())) {
                this.state = (byte) (this.state | 1);
            }
            if (NetworkCallBack$ProgressListener.class.isAssignableFrom(networkListener.getClass())) {
                this.state = (byte) (this.state | 2);
            }
            if (NetworkCallBack$ResponseCodeListener.class.isAssignableFrom(networkListener.getClass())) {
                this.state = (byte) (this.state | 4);
            }
            if (NetworkCallBack$InputStreamListener.class.isAssignableFrom(networkListener.getClass())) {
                this.state = (byte) (this.state | 8);
            }
        }
        this.handler = handler;
        this.mContext = obj;
    }

    private void dispatch(final byte b, final Object obj) {
        Handler handler = this.handler;
        if (handler == null) {
            dispatchCallback(b, obj);
        } else {
            handler.post(new Runnable() { // from class: anetwork.channel.aidl.adapter.ParcelableNetworkListenerWrapper.1
                @Override // java.lang.Runnable
                public void run() {
                    ParcelableNetworkListenerWrapper.this.dispatchCallback(b, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCallback(byte b, Object obj) {
        try {
            if (b == 4) {
                ParcelableHeader parcelableHeader = (ParcelableHeader) obj;
                ((NetworkCallBack$ResponseCodeListener) this.listener).onResponseCode(parcelableHeader.getResponseCode(), parcelableHeader.getHeader(), this.mContext);
                if (ALog.g(1)) {
                    ALog.c(TAG, "[onResponseCode]" + parcelableHeader, null, new Object[0]);
                }
            } else if (b == 2) {
                DefaultProgressEvent defaultProgressEvent = (DefaultProgressEvent) obj;
                if (defaultProgressEvent != null) {
                    defaultProgressEvent.setContext(this.mContext);
                }
                ((NetworkCallBack$ProgressListener) this.listener).onDataReceived(defaultProgressEvent, this.mContext);
                if (ALog.g(1)) {
                    ALog.c(TAG, "[onDataReceived]" + defaultProgressEvent, null, new Object[0]);
                }
            } else if (b != 1) {
                if (b == 8) {
                    ((NetworkCallBack$InputStreamListener) this.listener).onInputStreamGet((ParcelableInputStream) obj, this.mContext);
                    if (ALog.g(1)) {
                        ALog.c(TAG, "[onInputStreamReceived]", null, new Object[0]);
                    }
                }
            } else {
                DefaultFinishEvent defaultFinishEvent = (DefaultFinishEvent) obj;
                if (defaultFinishEvent != null) {
                    defaultFinishEvent.setContext(this.mContext);
                }
                ((NetworkCallBack$FinishListener) this.listener).onFinished(defaultFinishEvent, this.mContext);
                if (ALog.g(1)) {
                    ALog.c(TAG, "[onFinished]" + defaultFinishEvent, null, new Object[0]);
                }
            }
        } catch (Exception unused) {
            ALog.e(TAG, "dispatchCallback error", null, new Object[0]);
        }
    }

    public NetworkListener getListener() {
        return this.listener;
    }

    @Override // anetwork.channel.aidl.ParcelableNetworkListener
    public byte getListenerState() throws RemoteException {
        return this.state;
    }

    @Override // anetwork.channel.aidl.ParcelableNetworkListener
    public void onDataReceived(DefaultProgressEvent defaultProgressEvent) throws RemoteException {
        if ((this.state & 2) != 0) {
            dispatch((byte) 2, defaultProgressEvent);
        }
    }

    @Override // anetwork.channel.aidl.ParcelableNetworkListener
    public void onFinished(DefaultFinishEvent defaultFinishEvent) throws RemoteException {
        if ((this.state & 1) != 0) {
            dispatch((byte) 1, defaultFinishEvent);
        }
        this.listener = null;
        this.mContext = null;
        this.handler = null;
    }

    @Override // anetwork.channel.aidl.ParcelableNetworkListener
    public void onInputStreamGet(ParcelableInputStream parcelableInputStream) throws RemoteException {
        if ((this.state & 8) != 0) {
            dispatch((byte) 8, parcelableInputStream);
        }
    }

    @Override // anetwork.channel.aidl.ParcelableNetworkListener
    public boolean onResponseCode(int i, ParcelableHeader parcelableHeader) throws RemoteException {
        if ((this.state & 4) != 0) {
            dispatch((byte) 4, parcelableHeader);
            return false;
        }
        return false;
    }
}
