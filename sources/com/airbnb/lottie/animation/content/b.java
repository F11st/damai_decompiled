package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import tb.aw2;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class b {
    private List<n> a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        this.a.add(nVar);
    }

    public void b(Path path) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            aw2.b(path, this.a.get(size));
        }
    }
}
