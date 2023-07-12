package com.taobao.weex.devtools.inspector.elements;

import com.taobao.weex.devtools.common.ThreadBound;
import com.taobao.weex.devtools.common.UncheckedCallable;
import com.taobao.weex.devtools.common.Util;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class Descriptor implements NodeDescriptor {
    private Host mHost;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface Host extends ThreadBound {
        @Nullable
        Descriptor getDescriptor(@Nullable Object obj);

        void onAttributeModified(Object obj, String str, String str2);

        void onAttributeRemoved(Object obj, String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Map<String, String> parseSetAttributesAsTextArg(String str) {
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        int length = str.length();
        String str2 = "";
        String str3 = "";
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '=') {
                str2 = sb.toString();
                sb.setLength(0);
            } else if (charAt == '\"') {
                if (z) {
                    str3 = sb.toString();
                    sb.setLength(0);
                }
                z = !z;
            } else if (charAt == ' ' && !z) {
                hashMap.put(str2, str3);
            } else {
                sb.append(charAt);
            }
        }
        if (!str2.isEmpty() && !str3.isEmpty()) {
            hashMap.put(str2, str3);
        }
        return hashMap;
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public final boolean checkThreadAccess() {
        return getHost().checkThreadAccess();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Host getHost() {
        return this.mHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void initialize(Host host) {
        Util.throwIfNull(host);
        Util.throwIfNotNull(this.mHost);
        this.mHost = host;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isInitialized() {
        return this.mHost != null;
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public final <V> V postAndWait(UncheckedCallable<V> uncheckedCallable) {
        return (V) getHost().postAndWait(uncheckedCallable);
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public final void postDelayed(Runnable runnable, long j) {
        getHost().postDelayed(runnable, j);
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public final void removeCallbacks(Runnable runnable) {
        getHost().removeCallbacks(runnable);
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public final void verifyThreadAccess() {
        getHost().verifyThreadAccess();
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public final void postAndWait(Runnable runnable) {
        getHost().postAndWait(runnable);
    }
}
