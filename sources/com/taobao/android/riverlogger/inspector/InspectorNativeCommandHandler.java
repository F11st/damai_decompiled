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
    public void handle(@NonNull JSONObject jSONObject, @NonNull b bVar) {
        handleNative(this.a, bVar.b(), bVar.a(), bVar.c(), jSONObject.toString());
    }
}
