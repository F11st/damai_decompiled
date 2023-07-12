package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import tb.aw2;

/* compiled from: Taobao */
/* renamed from: com.airbnb.lottie.animation.content.b */
/* loaded from: classes17.dex */
public class C2828b {
    private List<C2842n> a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(C2842n c2842n) {
        this.a.add(c2842n);
    }

    public void b(Path path) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            aw2.b(path, this.a.get(size));
        }
    }
}
