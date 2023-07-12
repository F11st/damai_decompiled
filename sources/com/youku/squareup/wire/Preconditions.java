package com.youku.squareup.wire;

import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class Preconditions {
    private Preconditions() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkNotNull(Object obj, String str) {
        Objects.requireNonNull(obj, str);
    }
}
