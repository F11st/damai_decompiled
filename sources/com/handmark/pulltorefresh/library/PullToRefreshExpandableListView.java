package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ExpandableListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PullToRefreshExpandableListView extends PullToRefreshAdapterViewBase<ExpandableListView> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class InternalExpandableListView extends ExpandableListView implements EmptyViewMethodAccessor {
        public InternalExpandableListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.widget.AbsListView, android.view.View
        public ContextMenu.ContextMenuInfo getContextMenuInfo() {
            return super.getContextMenuInfo();
        }

        @Override // android.widget.AdapterView, com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor
        public void setEmptyView(View view) {
            PullToRefreshExpandableListView.this.setEmptyView(view);
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
    public final class InternalExpandableListViewSDK9 extends InternalExpandableListView {
        public InternalExpandableListViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.view.View
        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            a.d(PullToRefreshExpandableListView.this, i2, i4, z);
            return overScrollBy;
        }
    }

    public PullToRefreshExpandableListView(Context context) {
        super(context);
    }

    @Override // com.handmark.pulltorefresh.library.PullToRefreshAdapterViewBase, android.view.View
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return ((InternalExpandableListView) getRefreshableView()).getContextMenuInfo();
    }

    public PullToRefreshExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.handmark.pulltorefresh.library.PullToRefreshBase
    public final ExpandableListView createRefreshableView(Context context, AttributeSet attributeSet) {
        ExpandableListView internalExpandableListView;
        if (Build.VERSION.SDK_INT >= 9) {
            internalExpandableListView = new InternalExpandableListViewSDK9(context, attributeSet);
        } else {
            internalExpandableListView = new InternalExpandableListView(context, attributeSet);
        }
        internalExpandableListView.setId(16908298);
        return internalExpandableListView;
    }

    public PullToRefreshExpandableListView(Context context, PullToRefreshBase.Mode mode) {
        super(context, mode);
    }
}
