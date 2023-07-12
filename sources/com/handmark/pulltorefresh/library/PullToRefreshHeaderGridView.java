package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import com.baseproject.ui.R$id;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import com.youku.widget.HeaderGridView;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PullToRefreshHeaderGridView extends PullToRefreshAdapterViewBase<HeaderGridView> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class InternalGridView extends HeaderGridView implements EmptyViewMethodAccessor {
        public InternalGridView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.AbsListView, android.view.View
        public ContextMenu.ContextMenuInfo getContextMenuInfo() {
            return super.getContextMenuInfo();
        }

        @Override // android.widget.AdapterView, com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyView(View view) {
            PullToRefreshHeaderGridView.this.setEmptyView(view);
        }

        @Override // com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyViewInternal(View view) {
            super.setEmptyView(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    @TargetApi(9)
    /* loaded from: classes10.dex */
    public final class InternalGridViewSDK9 extends InternalGridView {
        public InternalGridViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.view.View
        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            a.d(PullToRefreshHeaderGridView.this, i2, i4, z);
            return overScrollBy;
        }
    }

    public PullToRefreshHeaderGridView(Context context) {
        super(context);
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshAdapterViewBase, android.view.View
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return ((InternalGridView) getRefreshableView()).getContextMenuInfo();
    }

    public PullToRefreshHeaderGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public final HeaderGridView createRefreshableView(Context context, AttributeSet attributeSet) {
        HeaderGridView internalGridView;
        if (Build.VERSION.SDK_INT >= 9) {
            internalGridView = new InternalGridViewSDK9(context, attributeSet);
        } else {
            internalGridView = new InternalGridView(context, attributeSet);
        }
        internalGridView.setId(R$id.gridview);
        return internalGridView;
    }

    public PullToRefreshHeaderGridView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }
}
