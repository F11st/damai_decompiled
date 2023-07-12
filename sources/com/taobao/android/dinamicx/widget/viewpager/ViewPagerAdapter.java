package com.taobao.android.dinamicx.widget.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.k;
import com.taobao.android.dinamicx.view.DXNativeFrameLayout;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXViewPager;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import tb.ry;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ViewPagerAdapter extends PagerAdapter {
    protected DXViewPager a;
    protected List<DXWidgetNode> b;
    protected k c;
    protected Context d;
    protected LinkedHashMap<Integer, View> e = new LinkedHashMap<>();

    public ViewPagerAdapter(DXViewPager dXViewPager, List<DXWidgetNode> list, Context context) {
        this.a = dXViewPager;
        this.b = list;
        this.c = new k(dXViewPager.getDXRuntimeContext().getEngineContext(), 3, UUID.randomUUID().toString());
        this.d = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, int i, View view) {
        if (i == viewGroup.getChildCount()) {
            viewGroup.addView(view, i, new ViewGroup.LayoutParams(-2, -2));
        } else if (i < viewGroup.getChildCount()) {
            viewGroup.removeViewAt(i);
            viewGroup.addView(view, i, new ViewGroup.LayoutParams(-2, -2));
        } else {
            int childCount = i - viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                viewGroup.addView(new View(this.d), new ViewGroup.LayoutParams(-2, -2));
            }
            viewGroup.addView(view, i, new ViewGroup.LayoutParams(-2, -2));
        }
    }

    public void b(DXViewPager dXViewPager) {
        this.a = dXViewPager;
        getCount();
        for (Map.Entry<Integer, View> entry : this.e.entrySet()) {
            DXWidgetNode dXWidgetNode = this.b.get(entry.getKey().intValue());
            View value = entry.getValue();
            DXRuntimeContext cloneWithWidgetNode = dXWidgetNode.getDXRuntimeContext().cloneWithWidgetNode(dXWidgetNode);
            int c = DXWidgetNode.DXMeasureSpec.c(this.a.getMeasuredWidth(), 1073741824);
            int c2 = DXWidgetNode.DXMeasureSpec.c(this.a.getMeasuredHeight(), 1073741824);
            if (dXWidgetNode instanceof DXTemplateWidgetNode) {
                dXWidgetNode.setLayoutWidth(-1);
                dXWidgetNode.setLayoutHeight(-1);
            }
            this.c.g(dXWidgetNode, null, value, cloneWithWidgetNode, 2, 8, c, c2, entry.getKey().intValue());
        }
    }

    public void c(List<DXWidgetNode> list) {
        this.b = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<DXWidgetNode> list = this.b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
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
        int c = DXWidgetNode.DXMeasureSpec.c(this.a.getMeasuredWidth(), 1073741824);
        int c2 = DXWidgetNode.DXMeasureSpec.c(this.a.getMeasuredHeight(), 1073741824);
        if (dXWidgetNode instanceof DXTemplateWidgetNode) {
            dXWidgetNode.setLayoutWidth(-1);
            dXWidgetNode.setLayoutHeight(-1);
        }
        this.c.g(dXWidgetNode, null, dXNativeFrameLayout, cloneWithWidgetNode, 2, 8, c, c2, i);
        this.e.put(Integer.valueOf(i), dXNativeFrameLayout);
        try {
            a(viewGroup, i, dXNativeFrameLayout);
        } catch (Exception e) {
            ry.b(e);
        }
        return dXNativeFrameLayout;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
