package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.view.DXNativeRecyclerView;
import com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager;
import tb.b00;
import tb.z00;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXStackCardLayoutWidgetNode extends DXScrollerLayout {
    public static final long DXSTACKCARDLAYOUT_ISINFINITE = -3537170322378136036L;
    public static final long DXSTACKCARDLAYOUT_LINESPACE = -1442719518478951523L;
    public static final long DXSTACKCARDLAYOUT_MINALPHA = 4694181126962650162L;
    public static final long DXSTACKCARDLAYOUT_MINSCALE = 4694181399715426612L;
    public static final long DXSTACKCARDLAYOUT_ONPAGECHANGE = -8975195222378757716L;
    public static final long DXSTACKCARDLAYOUT_OVERLAPCOUNT = -1670650961945227762L;
    public static final long DXSTACKCARDLAYOUT_PAGINGENABLED = 8689803490594880558L;
    public static final long DXSTACKCARDLAYOUT_STACKCARDLAYOUT = 1002171220417013501L;
    private boolean isInfinite = false;
    private double lineSpace = 15.0d;
    private double minAlpha = 0.30000001192092896d;
    private double minScale = 0.800000011920929d;
    private int overlapCount = 3;
    private boolean pagingEnabled = true;
    private final b00 dxPageChangeEvent = new b00(-8975195222378757716L);
    private int currentPos = 0;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class a implements StackLayoutManager.ItemChangedListener {
        a() {
        }

        @Override // com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.StackLayoutManager.ItemChangedListener
        public void onItemChanged(int i) {
            if (i != DXStackCardLayoutWidgetNode.this.currentPos) {
                DXStackCardLayoutWidgetNode.this.dxPageChangeEvent.f(i);
                DXStackCardLayoutWidgetNode dXStackCardLayoutWidgetNode = DXStackCardLayoutWidgetNode.this;
                dXStackCardLayoutWidgetNode.postEvent(dXStackCardLayoutWidgetNode.dxPageChangeEvent);
                DXStackCardLayoutWidgetNode.this.currentPos = i;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new DXStackCardLayoutWidgetNode();
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXStackCardLayoutWidgetNode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode == null || !(dXWidgetNode instanceof DXStackCardLayoutWidgetNode)) {
            return;
        }
        super.onClone(dXWidgetNode, z);
        DXStackCardLayoutWidgetNode dXStackCardLayoutWidgetNode = (DXStackCardLayoutWidgetNode) dXWidgetNode;
        this.isInfinite = dXStackCardLayoutWidgetNode.isInfinite;
        this.lineSpace = dXStackCardLayoutWidgetNode.lineSpace;
        this.minAlpha = dXStackCardLayoutWidgetNode.minAlpha;
        this.minScale = dXStackCardLayoutWidgetNode.minScale;
        this.overlapCount = dXStackCardLayoutWidgetNode.overlapCount;
        this.pagingEnabled = dXStackCardLayoutWidgetNode.pagingEnabled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return super.onCreateView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        super.onRenderView(context, view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d) {
        if (j == -1442719518478951523L) {
            this.lineSpace = d;
        } else if (j == DXSTACKCARDLAYOUT_MINALPHA) {
            this.minAlpha = d;
        } else if (j == DXSTACKCARDLAYOUT_MINSCALE) {
            this.minScale = d;
        } else {
            super.onSetDoubleAttribute(j, d);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == -3537170322378136036L) {
            this.isInfinite = i != 0;
        } else if (j == DXSTACKCARDLAYOUT_OVERLAPCOUNT) {
            this.overlapCount = i;
        } else if (j == DXSTACKCARDLAYOUT_PAGINGENABLED) {
            this.pagingEnabled = i != 0;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout
    public void setLayoutManager(Context context, DXScrollerLayout dXScrollerLayout, RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager() == null) {
            com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.c cVar = new com.taobao.android.dinamicx.widget.recycler.stacklayoutmanager.c();
            cVar.f(z00.b(context, (float) this.lineSpace)).g(this.overlapCount).d(getOrientation() == 0 ? StackLayoutManager.ScrollOrientation.LEFT : StackLayoutManager.ScrollOrientation.TOP).a(this.isInfinite).e(this.pagingEnabled).c((float) this.minScale).b((float) this.minAlpha);
            StackLayoutManager stackLayoutManager = new StackLayoutManager(cVar);
            stackLayoutManager.w(new a());
            if (recyclerView instanceof DXNativeRecyclerView) {
                ((DXNativeRecyclerView) recyclerView).setNeedFixScrollConflict(getOrientation() == 0 ? 1 : 2);
            }
            recyclerView.setLayoutManager(stackLayoutManager);
        }
    }
}
