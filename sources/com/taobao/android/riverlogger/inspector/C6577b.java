package com.taobao.android.riverlogger.inspector;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.riverlogger.remote.C6581b;
import com.taobao.android.riverlogger.remote.RemoteChannel;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.riverlogger.inspector.b */
/* loaded from: classes12.dex */
public class C6577b {
    private final String a;
    private int b;
    private final String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6577b(@NonNull String str, int i, @Nullable String str2, @NonNull JSONObject jSONObject) {
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
        if (this.b >= 0 && (c = C6581b.c()) != null) {
            c.d(this.b, null);
        }
        super.finalize();
    }
}
