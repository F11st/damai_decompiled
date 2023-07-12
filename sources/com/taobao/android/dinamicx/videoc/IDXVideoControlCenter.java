package com.taobao.android.dinamicx.videoc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import tb.by2;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDXVideoControlCenter {
    void clearVideoQueue(@NonNull RecyclerView recyclerView);

    void clearVideoQueue(@NonNull RecyclerView recyclerView, @Nullable String str);

    void destroy();

    void makeVideoControl(@NonNull RecyclerView recyclerView);

    void makeVideoControl(@NonNull RecyclerView recyclerView, @NonNull DXVideoControlConfig<by2> dXVideoControlConfig);

    void makeVideoControl(@NonNull RecyclerView recyclerView, @NonNull DXVideoControlConfig<by2> dXVideoControlConfig, @NonNull String str);

    void start(@NonNull RecyclerView recyclerView);

    void start(@NonNull RecyclerView recyclerView, @Nullable String str);

    void startAtOnce(@NonNull RecyclerView recyclerView);

    void startAtOnce(@NonNull RecyclerView recyclerView, @Nullable String str);

    void stop(@NonNull RecyclerView recyclerView);

    void stop(@NonNull RecyclerView recyclerView, @Nullable String str);

    void stopAtOnce(@NonNull RecyclerView recyclerView);

    void stopAtOnce(@NonNull RecyclerView recyclerView, @Nullable String str);

    void triggerPlayControl(@NonNull RecyclerView recyclerView);

    void triggerPlayControl(@NonNull RecyclerView recyclerView, @Nullable String str);

    int triggerPlayControlAtOnce(@NonNull RecyclerView recyclerView, @NonNull String str);
}
