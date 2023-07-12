package com.taobao.android.riverlogger.inspector;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class InspectorNativeCommandHandler implements InspectorCommandHandler {
    private final long a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InspectorNativeCommandHandler(long j) {
        this.a = j;
    }

    private native void handleNative(long j, String str, int i, String str2, String str3);

    @Override // com.taobao.android.riverlogger.inspector.InspectorCommandHandler
    public void handle(@NonNull JSONObject jSONObject, @NonNull C6577b c6577b) {
        handleNative(this.a, c6577b.b(), c6577b.a(), c6577b.c(), jSONObject.toString());
    }
}
