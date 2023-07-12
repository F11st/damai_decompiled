package cn.damai.tetris.component.drama.viewholdercopy;

import android.view.View;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public interface OnItemBindListener<T> extends OnItemClickListener<T> {
    void exposeItem(@Nullable View view, T t, int i);
}
