package com.taobao.android.riverlogger.inspector;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.riverlogger.remote.RemoteChannel;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class b {
    private final String a;
    private int b;
    private final String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull String str, int i, @Nullable String str2, @NonNull JSONObject jSONObject) {
        this.a = str;
        this.b = i;
        this.c = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.c;
    }

    protected void finalize() throws Throwable {
        RemoteChannel c;
        if (this.b >= 0 && (c = com.taobao.android.riverlogger.remote.b.c()) != null) {
            c.d(this.b, null);
        }
        super.finalize();
    }
}
