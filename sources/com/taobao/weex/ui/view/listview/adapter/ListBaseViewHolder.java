package com.taobao.weex.ui.view.listview.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXHeader;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ListBaseViewHolder extends RecyclerView.ViewHolder {
    private boolean isRecycled;
    private WeakReference<WXComponent> mComponent;
    private int mViewType;

    public ListBaseViewHolder(WXComponent wXComponent, int i) {
        super(wXComponent.getHostView());
        this.mViewType = i;
        this.mComponent = new WeakReference<>(wXComponent);
        this.isRecycled = wXComponent.canRecycled();
    }

    public void bindData(WXComponent wXComponent) {
        WeakReference<WXComponent> weakReference = this.mComponent;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mComponent.get().bindData(wXComponent);
        this.isRecycled = false;
    }

    public boolean canRecycled() {
        WeakReference<WXComponent> weakReference = this.mComponent;
        if (weakReference == null || weakReference.get() == null) {
            return true;
        }
        return this.mComponent.get().canRecycled();
    }

    public WXComponent getComponent() {
        WeakReference<WXComponent> weakReference = this.mComponent;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public View getView() {
        return this.itemView;
    }

    public int getViewType() {
        return this.mViewType;
    }

    public boolean isFullSpan() {
        WeakReference<WXComponent> weakReference = this.mComponent;
        return weakReference != null && (weakReference.get() instanceof WXHeader);
    }

    public boolean isRecycled() {
        return this.isRecycled;
    }

    public void recycled() {
        WeakReference<WXComponent> weakReference = this.mComponent;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mComponent.get().recycled();
        this.isRecycled = true;
    }

    public void setComponentUsing(boolean z) {
        WeakReference<WXComponent> weakReference = this.mComponent;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mComponent.get().setUsing(z);
    }

    public ListBaseViewHolder(WXComponent wXComponent, int i, boolean z) {
        this(wXComponent, i);
        this.isRecycled = this.isRecycled || z;
    }

    public ListBaseViewHolder(View view, int i) {
        super(view);
        this.mViewType = i;
    }
}
