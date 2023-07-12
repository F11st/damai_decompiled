package com.taobao.android.dinamicx.widget.richtext;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.taobao.android.dinamicx.DXGlobalCenter;
import com.taobao.android.dinamicx.view.richtext.node.C6414a;
import com.taobao.android.dinamicx.view.richtext.node.RichTextNode;
import com.taobao.android.dinamicx.widget.DXImageWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXRichTextImageInterface;
import com.taobao.android.dinamicx.widget.IDXWebImageUrlInterface;
import tb.hy;
import tb.nz;
import tb.u00;
import tb.v00;
import tb.wt;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXImageSpanWidgetNode extends DXImageWidgetNode {
    public static final long DXIMAGESPAN_IMAGESPAN = 7700670379007126142L;
    public static final long DXIMAGESPAN_LINK = 35873943762L;
    public static final long DXIMAGESPAN_ONLINK = 9859228430928305L;
    public static final long DXIMAGESPAN_ONPRESS = 5176476879387311985L;
    public static final long DXIMAGESPAN_PRESS = 19050239308914L;
    private String v;
    private String w;
    private C6414a x;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface ImageLoadCallback {
        void onLoaded(Bitmap bitmap);
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.richtext.DXImageSpanWidgetNode$a */
    /* loaded from: classes11.dex */
    class C6535a implements RichTextNode.OnLinkTapListener {
        final /* synthetic */ long a;

        C6535a(long j) {
            this.a = j;
        }

        @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode.OnLinkTapListener
        public void onLinkTap(String str) {
            u00 u00Var = new u00(this.a);
            u00Var.f(str);
            DXImageSpanWidgetNode.this.postEvent(u00Var);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.richtext.DXImageSpanWidgetNode$b */
    /* loaded from: classes11.dex */
    class C6536b implements RichTextNode.OnLongPressListener {
        final /* synthetic */ long a;

        C6536b(long j) {
            this.a = j;
        }

        @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode.OnLongPressListener
        public boolean onLongPress(String str) {
            v00 v00Var = new v00(this.a);
            v00Var.f(str);
            DXImageSpanWidgetNode.this.postEvent(v00Var);
            return true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.richtext.DXImageSpanWidgetNode$c */
    /* loaded from: classes11.dex */
    class C6537c implements RichTextNode.OnTapListener {
        C6537c() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode.OnTapListener
        public void onTap() {
            DXImageSpanWidgetNode.this.postEvent(new hy(18903999933159L));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.richtext.DXImageSpanWidgetNode$d */
    /* loaded from: classes11.dex */
    class C6538d implements RichTextNode.OnLongTapListener {
        C6538d() {
        }

        @Override // com.taobao.android.dinamicx.view.richtext.node.RichTextNode.OnLongTapListener
        public void onLongTap() {
            DXImageSpanWidgetNode.this.postEvent(new hy(-6544685697300501093L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.richtext.DXImageSpanWidgetNode$e */
    /* loaded from: classes11.dex */
    public class C6539e implements ImageLoadCallback {
        final /* synthetic */ C6414a a;

        C6539e(C6414a c6414a) {
            this.a = c6414a;
        }

        @Override // com.taobao.android.dinamicx.widget.richtext.DXImageSpanWidgetNode.ImageLoadCallback
        public void onLoaded(Bitmap bitmap) {
            View view;
            this.a.v(bitmap);
            DXWidgetNode parentWidget = DXImageSpanWidgetNode.this.getParentWidget();
            if (parentWidget.getWRView() != null) {
                view = parentWidget.getWRView().get();
            } else {
                view = (parentWidget.getReferenceNode() == null || parentWidget.getReferenceNode().getWRView() == null) ? null : parentWidget.getReferenceNode().getWRView().get();
            }
            if (view != null) {
                view.invalidate();
            }
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXImageWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXImageSpanWidgetNode();
    }

    public C6414a k(boolean z, boolean z2) {
        if (getLayoutWidth() > 0 || getLayoutHeight() > 0) {
            C6414a.C6423i c6423i = new C6414a.C6423i();
            c6423i.f(getLayoutWidth()).b(getLayoutHeight()).c(this.v).d(this.w).e(c());
            C6414a a = c6423i.a();
            if (z) {
                l(a, z2);
            }
            this.x = a;
            return a;
        }
        return null;
    }

    public void l(C6414a c6414a, boolean z) {
        IDXRichTextImageInterface d;
        IDXWebImageUrlInterface g;
        if (c6414a == null || (d = DXGlobalCenter.d(getDXRuntimeContext())) == null || getDXRuntimeContext() == null || getDXRuntimeContext().getContext() == null) {
            return;
        }
        String e = e();
        if (!z && !TextUtils.isEmpty(e) && (g = DXGlobalCenter.g()) != null) {
            String decideUrl = g.decideUrl(e, c6414a.r(), c6414a.q(), a());
            if (!TextUtils.isEmpty(decideUrl)) {
                e = decideUrl;
            }
        }
        nz.g("DXImageSpanRequest", e);
        d.downloadImage(getDXRuntimeContext().getContext(), e, new C6539e(c6414a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        if (this.x == null) {
            if (wt.j0(this)) {
                return;
            }
            super.onBindEvent(context, view, j);
        } else if (j == 9859228430928305L && !TextUtils.isEmpty(this.v)) {
            this.x.w(new C6535a(j));
        } else if (j == 5176476879387311985L && !TextUtils.isEmpty(this.w)) {
            this.x.x(new C6536b(j));
        } else if (j == 18903999933159L) {
            this.x.z(new C6537c());
        } else if (j == -6544685697300501093L) {
            this.x.y(new C6538d());
        } else if (wt.j0(this)) {
        } else {
            super.onBindEvent(context, view, j);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXImageWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode == null || !(dXWidgetNode instanceof DXImageSpanWidgetNode)) {
            return;
        }
        super.onClone(dXWidgetNode, z);
        DXImageSpanWidgetNode dXImageSpanWidgetNode = (DXImageSpanWidgetNode) dXWidgetNode;
        this.v = dXImageSpanWidgetNode.v;
        this.w = dXImageSpanWidgetNode.w;
        this.x = dXImageSpanWidgetNode.x;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXImageWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        if (wt.j0(this)) {
            return null;
        }
        return super.onCreateView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXImageWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // com.taobao.android.dinamicx.widget.DXImageWidgetNode, com.taobao.android.dinamicx.PrefetchListener
    public void onPrefetchSuccess() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXImageWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXImageWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == 35873943762L) {
            this.v = str;
        } else if (j == 19050239308914L) {
            this.w = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }
}
