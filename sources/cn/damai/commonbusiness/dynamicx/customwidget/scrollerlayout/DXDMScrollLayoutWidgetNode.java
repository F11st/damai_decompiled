package cn.damai.commonbusiness.dynamicx.customwidget.scrollerlayout;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.widget.DXScrollerLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class DXDMScrollLayoutWidgetNode extends DXScrollerLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_DMSCROLLLAYOUT = 6775078443504696460L;
    public static final long DX_DMSCROLLLAYOUT_EDGEBOTTOM = 3778393840848227604L;
    public static final long DX_DMSCROLLLAYOUT_EDGELEFT = 2332578833154584872L;
    public static final long DX_DMSCROLLLAYOUT_EDGERIGHT = 8034601693281029276L;
    public static final long DX_DMSCROLLLAYOUT_EDGETOP = 4803347022718390095L;
    public static final long DX_DMSCROLLLAYOUT_ITEMSPACE = -5480591084986543964L;
    public static final long DX_DMSCROLLLAYOUT_SLINESPACE = -573736670546541551L;
    public static final long USER_DEFINE_PARAM_HASH_CODE = 9999999999L;
    private boolean addedDec;
    private int edgeBottom;
    private int edgeLeft;
    private int edgeRight;
    private int edgeTop;
    private int itemSpace;
    private int slineSpace;
    private String userDefineParam;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static class a implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1275941067") ? (DXWidgetNode) ipChange.ipc$dispatch("1275941067", new Object[]{this, obj}) : new DXDMScrollLayoutWidgetNode();
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "949005890") ? (DXWidgetNode) ipChange.ipc$dispatch("949005890", new Object[]{this, obj}) : new DXDMScrollLayoutWidgetNode();
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-14742817")) {
            return ((Integer) ipChange.ipc$dispatch("-14742817", new Object[]{this, Long.valueOf(j)})).intValue();
        }
        if (j == 9999999999L) {
            return -100;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "34542282")) {
            ipChange.ipc$dispatch("34542282", new Object[]{this});
        } else {
            super.onBeforeBindChildData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "534416163")) {
            ipChange.ipc$dispatch("534416163", new Object[]{this, context, view, Long.valueOf(j)});
        } else {
            super.onBindEvent(context, view, j);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "191349372")) {
            ipChange.ipc$dispatch("191349372", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
            return;
        }
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode == null || !(dXWidgetNode instanceof DXDMScrollLayoutWidgetNode)) {
            return;
        }
        DXDMScrollLayoutWidgetNode dXDMScrollLayoutWidgetNode = (DXDMScrollLayoutWidgetNode) dXWidgetNode;
        this.userDefineParam = dXDMScrollLayoutWidgetNode.userDefineParam;
        this.edgeLeft = dXDMScrollLayoutWidgetNode.edgeLeft;
        this.edgeTop = dXDMScrollLayoutWidgetNode.edgeTop;
        this.edgeRight = dXDMScrollLayoutWidgetNode.edgeRight;
        this.edgeBottom = dXDMScrollLayoutWidgetNode.edgeBottom;
        this.itemSpace = dXDMScrollLayoutWidgetNode.itemSpace;
        this.slineSpace = dXDMScrollLayoutWidgetNode.slineSpace;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1679409461") ? (View) ipChange.ipc$dispatch("1679409461", new Object[]{this, context}) : super.onCreateView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-876682186")) {
            ipChange.ipc$dispatch("-876682186", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            super.onMeasure(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1790186651")) {
            ipChange.ipc$dispatch("-1790186651", new Object[]{this, context, view});
            return;
        }
        super.onRenderView(context, view);
        if (view == null || !(view instanceof RecyclerView)) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getItemDecorationCount() <= 0) {
            recyclerView.addItemDecoration(new DMItemDividerDecoration(this.edgeLeft, this.edgeRight, this.itemSpace));
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "237970596")) {
            ipChange.ipc$dispatch("237970596", new Object[]{this, Long.valueOf(j), Integer.valueOf(i)});
        } else if (j == DX_DMSCROLLLAYOUT_EDGELEFT) {
            this.edgeLeft = i;
        } else if (j == DX_DMSCROLLLAYOUT_EDGETOP) {
            this.edgeTop = i;
        } else if (j == DX_DMSCROLLLAYOUT_EDGERIGHT) {
            this.edgeRight = i;
        } else if (j == DX_DMSCROLLLAYOUT_EDGEBOTTOM) {
            this.edgeBottom = i;
        } else if (j == DX_DMSCROLLLAYOUT_ITEMSPACE) {
            this.itemSpace = i;
        } else if (j == DX_DMSCROLLLAYOUT_SLINESPACE) {
            this.slineSpace = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }
}
