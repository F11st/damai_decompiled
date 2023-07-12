package com.taobao.android.dinamicx.widget.viewpager;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.view.DXNativeFrameLayout;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXViewPager;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.List;
import tb.ry;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LazyViewPagerAdapter extends ViewPagerAdapter {
    protected SparseArray<View> f;

    public LazyViewPagerAdapter(DXViewPager dXViewPager, List<DXWidgetNode> list, Context context) {
        super(dXViewPager, list, context);
        this.f = new SparseArray<>();
    }

    private String e(int i) {
        return "LazyViewPagerAdapter:" + i;
    }

    public boolean d(int i) {
        return this.f.get(i) != null;
    }

    @Override // com.taobao.android.dinamicx.widget.viewpager.ViewPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    protected View f(int i) {
        List<DXWidgetNode> list = this.b;
        if (list == null || this.c == null) {
            return null;
        }
        DXWidgetNode dXWidgetNode = list.get(i);
        DXNativeFrameLayout dXNativeFrameLayout = new DXNativeFrameLayout(this.d);
        DXRuntimeContext cloneWithWidgetNode = dXWidgetNode.getDXRuntimeContext().cloneWithWidgetNode(dXWidgetNode);
        e eVar = new e(cloneWithWidgetNode.getBizType());
        eVar.b = cloneWithWidgetNode.getDxTemplateItem();
        cloneWithWidgetNode.setDxError(eVar);
        return dXNativeFrameLayout;
    }

    public View g(ViewGroup viewGroup, int i) {
        View findViewWithTag = viewGroup.findViewWithTag(e(i));
        if (findViewWithTag == null) {
            findViewWithTag = this.f.get(i);
            int c = DXWidgetNode.DXMeasureSpec.c(this.a.getMeasuredWidth(), 1073741824);
            int c2 = DXWidgetNode.DXMeasureSpec.c(this.a.getMeasuredHeight(), 1073741824);
            DXWidgetNode dXWidgetNode = this.b.get(i);
            DXRuntimeContext cloneWithWidgetNode = dXWidgetNode.getDXRuntimeContext().cloneWithWidgetNode(dXWidgetNode);
            if (dXWidgetNode instanceof DXTemplateWidgetNode) {
                dXWidgetNode.setLayoutWidth(-1);
                dXWidgetNode.setLayoutHeight(-1);
            }
            this.c.g(dXWidgetNode, null, findViewWithTag, cloneWithWidgetNode, 2, 8, c, c2, i);
            this.e.put(Integer.valueOf(i), findViewWithTag);
            try {
                a(viewGroup, i, findViewWithTag);
            } catch (Exception e) {
                ry.b(e);
            }
            findViewWithTag.setTag(e(i));
            this.f.remove(i);
        }
        return findViewWithTag;
    }

    @Override // com.taobao.android.dinamicx.widget.viewpager.ViewPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View f = f(i);
        this.f.put(i, f);
        return f;
    }

    @Override // com.taobao.android.dinamicx.widget.viewpager.ViewPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        g(viewGroup, i);
    }
}
