package android.taobao.windvane.extra.uc;

import com.uc.webview.export.internal.interfaces.INetworkDecider;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AliNetworkDecider implements INetworkDecider {
    @Override // com.uc.webview.export.internal.interfaces.INetworkDecider
    public int chooseNetwork(String str) {
        return (str.startsWith("ws://") || str.startsWith("wss://") || !WVUCWebView.getUseTaobaoNetwork()) ? 0 : 2;
    }
}
