package com.taobao.android.abilitykit.ability.pop.render;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import tb.q;
import tb.w;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IAKPopContainer<PARAMS extends w, ABILITY_CONTEXT extends q> {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface Callback {
        void onDismissAnimationEnd();
    }

    void changeSize(float f, float f2);

    void doDismissAnimation();

    @NonNull
    ViewGroup onCreateView(@NonNull ABILITY_CONTEXT ability_context, @NonNull PARAMS params, @Nullable View view, Callback callback, IAKPopRender<PARAMS, ABILITY_CONTEXT> iAKPopRender);

    void show();
}
