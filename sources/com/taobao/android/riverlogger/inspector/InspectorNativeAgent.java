package com.taobao.android.riverlogger.inspector;

import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class InspectorNativeAgent implements InspectorAgent {
    private final long _nativePointer;

    private InspectorNativeAgent(long j) {
        this._nativePointer = j;
    }

    private native void connectionChangedNative(long j, boolean z);

    private native HashMap<String, Long> getCommandsNative(long j);

    static void registerAgent(long j, String str) {
        Inspector.d(new InspectorNativeAgent(j), str);
    }

    private native void sessionClosedNative(long j, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setConnectedNative(boolean z);

    @Override // com.taobao.android.riverlogger.inspector.InspectorAgent
    public void connectionChanged(boolean z) {
        connectionChangedNative(this._nativePointer, z);
    }

    @Override // com.taobao.android.riverlogger.inspector.InspectorAgent
    public Map<String, InspectorCommandHandler> getCommands() {
        HashMap<String, Long> commandsNative = getCommandsNative(this._nativePointer);
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Long> entry : commandsNative.entrySet()) {
            hashMap.put(entry.getKey(), new InspectorNativeCommandHandler(entry.getValue().longValue()));
        }
        return hashMap;
    }

    @Override // com.taobao.android.riverlogger.inspector.InspectorAgent
    public void sessionClosed(String str) {
        sessionClosedNative(this._nativePointer, str);
    }
}
