package com.taobao.android.abilitykit.ability.pop.presenter;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import tb.C9586q;
import tb.C9833w;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IAKPopPresenter<PARAMS extends C9833w, CONTEXT extends C9586q> {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface IAkPopDismissListener {
        void onDismiss(@Nullable JSONObject jSONObject);
    }

    void changeSize(float f, float f2);

    void dismiss(@Nullable JSONObject jSONObject, boolean z);

    void setOnDismissListener(@Nullable IAkPopDismissListener iAkPopDismissListener);

    void show(@NonNull CONTEXT context, @NonNull PARAMS params, @Nullable View view, int i);
}
