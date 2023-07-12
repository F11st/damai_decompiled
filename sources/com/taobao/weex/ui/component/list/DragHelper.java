package com.taobao.weex.ui.component.list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.weex.ui.component.WXComponent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface DragHelper {
    boolean isDragExcluded(@NonNull RecyclerView.ViewHolder viewHolder);

    boolean isDraggable();

    boolean isLongPressDragEnabled();

    void onDragEnd(@NonNull WXComponent wXComponent, int i, int i2);

    void onDragStart(@NonNull WXComponent wXComponent, int i);

    void onDragging(int i, int i2);

    void setDragExcluded(@NonNull RecyclerView.ViewHolder viewHolder, boolean z);

    void setDraggable(boolean z);

    void setLongPressDragEnabled(boolean z);

    void startDrag(@NonNull RecyclerView.ViewHolder viewHolder);
}
