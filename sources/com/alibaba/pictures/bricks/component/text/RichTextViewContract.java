package com.alibaba.pictures.bricks.component.text;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface RichTextViewContract {

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Model {
        @NotNull
        String getDesc();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface Present {
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface View {
        @NotNull
        RecyclerView getRichTextView();

        @NotNull
        TextView getShowMoreView();
    }
}
