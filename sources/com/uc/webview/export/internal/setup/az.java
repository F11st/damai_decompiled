package com.uc.webview.export.internal.setup;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.uc.webview.export.internal.uc.CoreFactory;
import com.uc.webview.export.internal.uc.startup.C7302b;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class az implements Callable<Object> {
    final /* synthetic */ ax a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ax axVar) {
        this.a = axVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        C7302b.a(TypedValues.Attributes.TYPE_PIVOT_TARGET);
        if (af.b) {
            CoreFactory.a(af.a);
        }
        C7279j.c();
        C7279j.d();
        C7302b.a(319);
        return null;
    }
}
