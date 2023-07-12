package com.taobao.weex.ui.component.list;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.utils.WXLogUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DefaultDragHelper implements DragHelper {
    private static final String EVENT_END_DRAG = "dragend";
    private static final String EVENT_START_DRAG = "dragstart";
    private static final String TAG = "WXListExComponent";
    private static final String TAG_EXCLUDED = "drag_excluded";
    private boolean isDraggable = false;
    @NonNull
    private final List<WXComponent> mDataSource;
    @NonNull
    private final EventTrigger mEventTrigger;
    @NonNull
    private ItemTouchHelper mItemTouchHelper;
    private boolean mLongPressEnabled;
    @NonNull
    private final RecyclerView mRecyclerView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultDragHelper(@NonNull List<WXComponent> list, @NonNull RecyclerView recyclerView, @NonNull EventTrigger eventTrigger) {
        this.mDataSource = list;
        this.mEventTrigger = eventTrigger;
        this.mRecyclerView = recyclerView;
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new DragSupportCallback(this, true));
        this.mItemTouchHelper = itemTouchHelper;
        try {
            itemTouchHelper.attachToRecyclerView(recyclerView);
        } catch (Throwable unused) {
        }
    }

    private Map<String, Object> buildEvent(@Nullable String str, int i, int i2) {
        HashMap hashMap = new HashMap(4);
        if (str == null) {
            str = "unknown";
        }
        hashMap.put("target", str);
        hashMap.put("fromIndex", Integer.valueOf(i));
        hashMap.put("toIndex", Integer.valueOf(i2));
        hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        return hashMap;
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public boolean isDragExcluded(@NonNull RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        if (view != null) {
            return view.getTag() != null && TAG_EXCLUDED.equals(viewHolder.itemView.getTag());
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.e(TAG, "[error] viewHolder.itemView is null");
        }
        return false;
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public boolean isDraggable() {
        return this.isDraggable;
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public boolean isLongPressDragEnabled() {
        return this.mLongPressEnabled;
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public void onDragEnd(@NonNull WXComponent wXComponent, int i, int i2) {
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d(TAG, "list on drag end : from index " + i + " to index " + i2);
        }
        this.mEventTrigger.triggerEvent(EVENT_END_DRAG, buildEvent(wXComponent.getRef(), i, i2));
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public void onDragStart(@NonNull WXComponent wXComponent, int i) {
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d(TAG, "list on drag start : from index " + i);
        }
        this.mEventTrigger.triggerEvent(EVENT_START_DRAG, buildEvent(wXComponent.getRef(), i, -1));
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public void onDragging(int i, int i2) {
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d(TAG, "list on dragging : from index " + i + " to index " + i2);
        }
        RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
        if (adapter == null) {
            WXLogUtils.e(TAG, "drag failed because of RecyclerView#Adapter is not bound");
        } else if (i < 0 || i > this.mDataSource.size() - 1 || i2 < 0 || i2 > this.mDataSource.size() - 1) {
        } else {
            Collections.swap(this.mDataSource, i, i2);
            adapter.notifyItemMoved(i, i2);
        }
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public void setDragExcluded(@NonNull RecyclerView.ViewHolder viewHolder, boolean z) {
        View view = viewHolder.itemView;
        if (view == null) {
            if (WXEnvironment.isApkDebugable()) {
                WXLogUtils.e(TAG, "[error] viewHolder.itemView is null");
            }
        } else if (z) {
            view.setTag(TAG_EXCLUDED);
        } else {
            view.setTag(null);
        }
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public void setDraggable(boolean z) {
        this.isDraggable = z;
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public void setLongPressDragEnabled(boolean z) {
        this.mLongPressEnabled = z;
    }

    @Override // com.taobao.weex.ui.component.list.DragHelper
    public void startDrag(@NonNull RecyclerView.ViewHolder viewHolder) {
        if (this.isDraggable) {
            this.mItemTouchHelper.startDrag(viewHolder);
        }
    }
}
