package com.youku.live.dago.widgetlib.ailpbaselib.net;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.android.liveservice.LivePlayerController;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URI;
import java.util.Enumeration;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ReportSocketIO {
    private static transient /* synthetic */ IpChange $ipChange;
    private static volatile ReportSocketIO instance;
    private boolean isConnected = false;
    private WebSocketClient webSocketClient;

    private void connect() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1390900772")) {
            ipChange.ipc$dispatch("-1390900772", new Object[]{this});
        } else {
            connect(URI.create("ws://11.239.165.93:8080"));
        }
    }

    private static String getHostIP() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "358996447")) {
            return (String) ipChange.ipc$dispatch("358996447", new Object[0]);
        }
        String str = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!(nextElement instanceof Inet6Address) && !LivePlayerController.CLIENT_IP.equals(nextElement.getHostAddress())) {
                            str = nextElement.getHostAddress();
                            break;
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static ReportSocketIO getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "255267067")) {
            return (ReportSocketIO) ipChange.ipc$dispatch("255267067", new Object[0]);
        }
        if (instance == null) {
            synchronized (ReportSocketIO.class) {
                if (instance == null) {
                    instance = new ReportSocketIO();
                }
            }
        }
        return instance;
    }

    public void disConnect() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1784187976")) {
            ipChange.ipc$dispatch("1784187976", new Object[]{this});
            return;
        }
        WebSocketClient webSocketClient = this.webSocketClient;
        if (webSocketClient != null) {
            webSocketClient.close();
            this.webSocketClient = null;
            instance = null;
            this.isConnected = false;
        }
    }

    public void send(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "392899526")) {
            ipChange.ipc$dispatch("392899526", new Object[]{this, str});
        } else if (!this.isConnected) {
            connect();
        } else {
            this.webSocketClient.send(String.format("+log|android|%s|info|%s", getHostIP(), str));
        }
    }

    private void connect(URI uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-35537602")) {
            ipChange.ipc$dispatch("-35537602", new Object[]{this, uri});
        } else if (this.webSocketClient == null) {
            WebSocketClient webSocketClient = new WebSocketClient(uri, new Draft_6455(), null, 3000) { // from class: com.youku.live.dago.widgetlib.ailpbaselib.net.ReportSocketIO.1
                public void onClose(int i, String str, boolean z) {
                    ReportSocketIO.this.isConnected = false;
                    ReportSocketIO.this.webSocketClient = null;
                }

                public void onError(Exception exc) {
                    exc.printStackTrace();
                    Log.e("socket err", exc.getMessage());
                    ReportSocketIO.this.isConnected = false;
                    ReportSocketIO.this.webSocketClient = null;
                }

                public void onMessage(String str) {
                    Log.e("socket onmessage", str);
                }

                public void onOpen(ServerHandshake serverHandshake) {
                    Log.e("socket open", serverHandshake.getHttpStatusMessage());
                    ReportSocketIO.this.isConnected = true;
                }
            };
            this.webSocketClient = webSocketClient;
            webSocketClient.connect();
        }
    }
}
