package com.taobao.android.abilitykit.ability.pop.presenter;

import android.taobao.windvane.util.WVConstants;
import android.widget.PopupWindow;
import kotlin.Metadata;
import tb.x;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Ltb/w;", WVConstants.INTENT_EXTRA_PARAMS, "Ltb/y;", "CONTEXT", "Ltb/wt2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes8.dex */
final class AKPopWindowPresenter$doDismiss$1 implements Runnable {
    final /* synthetic */ x this$0;

    AKPopWindowPresenter$doDismiss$1(x xVar) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        PopupWindow a = x.a(this.this$0);
        if (a != null) {
            a.dismiss();
        }
    }
}
