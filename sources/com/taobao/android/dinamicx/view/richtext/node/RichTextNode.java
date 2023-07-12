package com.taobao.android.dinamicx.view.richtext.node;

import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface RichTextNode {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnLinkTapListener {
        void onLinkTap(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnLongPressListener {
        boolean onLongPress(String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnLongTapListener {
        void onLongTap();
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnTapListener {
        void onTap();
    }

    @NonNull
    String getText();

    @NonNull
    List<Object> toSpans();

    @NonNull
    List<Object> toSpans(boolean z);
}
