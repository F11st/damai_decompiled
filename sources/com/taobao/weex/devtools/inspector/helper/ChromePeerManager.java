package com.taobao.weex.devtools.inspector.helper;

import com.taobao.weex.devtools.common.LogRedirector;
import com.taobao.weex.devtools.common.Util;
import com.taobao.weex.devtools.inspector.jsonrpc.DisconnectReceiver;
import com.taobao.weex.devtools.inspector.jsonrpc.JsonRpcPeer;
import com.taobao.weex.devtools.inspector.jsonrpc.PendingRequestCallback;
import java.nio.channels.NotYetConnectedException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ChromePeerManager {
    private static final String TAG = "ChromePeerManager";
    @GuardedBy("this")
    private PeerRegistrationListener mListener;
    @GuardedBy("this")
    private final Map<JsonRpcPeer, DisconnectReceiver> mReceivingPeers = new HashMap();
    @GuardedBy("this")
    private JsonRpcPeer[] mReceivingPeersSnapshot;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class UnregisterOnDisconnect implements DisconnectReceiver {
        private final JsonRpcPeer mPeer;

        public UnregisterOnDisconnect(JsonRpcPeer jsonRpcPeer) {
            this.mPeer = jsonRpcPeer;
        }

        @Override // com.taobao.weex.devtools.inspector.jsonrpc.DisconnectReceiver
        public void onDisconnect() {
            ChromePeerManager.this.removePeer(this.mPeer);
        }
    }

    private synchronized JsonRpcPeer[] getReceivingPeersSnapshot() {
        if (this.mReceivingPeersSnapshot == null) {
            this.mReceivingPeersSnapshot = (JsonRpcPeer[]) this.mReceivingPeers.keySet().toArray(new JsonRpcPeer[this.mReceivingPeers.size()]);
        }
        return this.mReceivingPeersSnapshot;
    }

    private void sendMessageToPeers(String str, Object obj, @Nullable PendingRequestCallback pendingRequestCallback) {
        for (JsonRpcPeer jsonRpcPeer : getReceivingPeersSnapshot()) {
            try {
                jsonRpcPeer.invokeMethod(str, obj, pendingRequestCallback);
            } catch (NotYetConnectedException e) {
                LogRedirector.e(TAG, "Error delivering data to Chrome", e);
            }
        }
    }

    public synchronized boolean addPeer(JsonRpcPeer jsonRpcPeer) {
        if (this.mReceivingPeers.containsKey(jsonRpcPeer)) {
            return false;
        }
        UnregisterOnDisconnect unregisterOnDisconnect = new UnregisterOnDisconnect(jsonRpcPeer);
        jsonRpcPeer.registerDisconnectReceiver(unregisterOnDisconnect);
        this.mReceivingPeers.put(jsonRpcPeer, unregisterOnDisconnect);
        this.mReceivingPeersSnapshot = null;
        PeerRegistrationListener peerRegistrationListener = this.mListener;
        if (peerRegistrationListener != null) {
            peerRegistrationListener.onPeerRegistered(jsonRpcPeer);
        }
        return true;
    }

    public synchronized boolean hasRegisteredPeers() {
        return !this.mReceivingPeers.isEmpty();
    }

    public void invokeMethodOnPeers(String str, Object obj, PendingRequestCallback pendingRequestCallback) {
        Util.throwIfNull(pendingRequestCallback);
        sendMessageToPeers(str, obj, pendingRequestCallback);
    }

    public synchronized void removePeer(JsonRpcPeer jsonRpcPeer) {
        if (this.mReceivingPeers.remove(jsonRpcPeer) != null) {
            this.mReceivingPeersSnapshot = null;
            PeerRegistrationListener peerRegistrationListener = this.mListener;
            if (peerRegistrationListener != null) {
                peerRegistrationListener.onPeerUnregistered(jsonRpcPeer);
            }
        }
    }

    public void sendNotificationToPeers(String str, Object obj) {
        sendMessageToPeers(str, obj, null);
    }

    public synchronized void setListener(PeerRegistrationListener peerRegistrationListener) {
        this.mListener = peerRegistrationListener;
    }
}
