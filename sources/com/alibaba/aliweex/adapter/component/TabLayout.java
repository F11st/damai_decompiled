package com.alibaba.aliweex.adapter.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class TabLayout extends FrameLayout {
    private OnTabSelectedListener mOnTabSelectedListener;
    private LinearLayout mRootView;
    private C3026b mSelectedTab;
    private View.OnClickListener mTabClickListener;
    private WXTabbar mTabbar;
    private final ArrayList<C3026b> mTabs;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnTabSelectedListener {
        void onTabReselected(C3026b c3026b);

        void onTabSelected(C3026b c3026b);

        void onTabUnselected(C3026b c3026b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.component.TabLayout$a */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC3025a implements View.OnClickListener {
        View$OnClickListenerC3025a(TabLayout tabLayout) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((C3026b) view.getTag()).d();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.adapter.component.TabLayout$b */
    /* loaded from: classes15.dex */
    public static final class C3026b {
        public static final int INVALID_POSITION = -1;
        private int a = -1;
        private View b;
        private final TabLayout c;

        C3026b(TabLayout tabLayout) {
            this.c = tabLayout;
        }

        @Nullable
        public View b() {
            return this.b;
        }

        public int c() {
            return this.a;
        }

        public void d() {
            this.b.setSelected(true);
            this.c.selectTab(this);
        }

        @NonNull
        public C3026b e(@Nullable View view) {
            this.b = view;
            int i = this.a;
            if (i >= 0) {
                this.c.updateTab(i);
            }
            return this;
        }

        void f(int i) {
            this.a = i;
        }
    }

    public TabLayout(Context context, WXTabbar wXTabbar) {
        super(context);
        this.mTabs = new ArrayList<>();
        this.mTabbar = wXTabbar;
        init(context);
    }

    private void addTabView(C3026b c3026b, boolean z) {
        View b = c3026b.b();
        if (this.mTabClickListener == null) {
            this.mTabClickListener = new View$OnClickListenerC3025a(this);
        }
        if (b != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, (int) this.mTabbar.getLayoutHeight());
            layoutParams.weight = 1.0f;
            b.setTag(c3026b);
            b.setLayoutParams(layoutParams);
            b.setOnClickListener(this.mTabClickListener);
            this.mRootView.addView(b);
            if (z) {
                b.setSelected(true);
            }
        }
    }

    private void init(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setBackgroundColor(0);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(80);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) this.mTabbar.getLayoutHeight());
        layoutParams.gravity = 48;
        addView(linearLayout, layoutParams);
        this.mRootView = linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTab(int i) {
        View b;
        ViewParent parent;
        C3026b tabAt = getTabAt(i);
        if (tabAt == null || (b = tabAt.b()) == null || (parent = b.getParent()) == this) {
            return;
        }
        if (parent != null) {
            ((ViewGroup) parent).removeView(b);
        }
        addView(b);
    }

    public void addTab(@NonNull C3026b c3026b, boolean z) {
        if (c3026b.c == this) {
            addTabView(c3026b, z);
            int size = this.mTabs.size();
            c3026b.f(this.mTabs.size());
            this.mTabs.add(size, c3026b);
            int size2 = this.mTabs.size();
            while (true) {
                size++;
                if (size >= size2) {
                    break;
                }
                this.mTabs.get(size).f(size);
            }
            if (z) {
                c3026b.d();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public int getSelectedTabPosition() {
        C3026b c3026b = this.mSelectedTab;
        if (c3026b != null) {
            return c3026b.c();
        }
        return -1;
    }

    @Nullable
    public C3026b getTabAt(int i) {
        return this.mTabs.get(i);
    }

    @NonNull
    public C3026b newTab() {
        return new C3026b(this);
    }

    public void removeAllTabs() {
        Iterator<C3026b> it = this.mTabs.iterator();
        while (it.hasNext()) {
            it.next().f(-1);
            it.remove();
        }
        this.mSelectedTab = null;
    }

    void selectTab(C3026b c3026b) {
        OnTabSelectedListener onTabSelectedListener;
        OnTabSelectedListener onTabSelectedListener2;
        OnTabSelectedListener onTabSelectedListener3;
        C3026b c3026b2 = this.mSelectedTab;
        if (c3026b2 == c3026b) {
            if (c3026b2 == null || (onTabSelectedListener3 = this.mOnTabSelectedListener) == null) {
                return;
            }
            onTabSelectedListener3.onTabReselected(c3026b2);
            return;
        }
        if (c3026b2 != null && (onTabSelectedListener2 = this.mOnTabSelectedListener) != null) {
            onTabSelectedListener2.onTabUnselected(c3026b2);
        }
        this.mSelectedTab = c3026b;
        if (c3026b == null || (onTabSelectedListener = this.mOnTabSelectedListener) == null) {
            return;
        }
        onTabSelectedListener.onTabSelected(c3026b);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean z = layoutParams instanceof FrameLayout.LayoutParams;
        super.setLayoutParams(layoutParams);
    }

    public void setOnTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        this.mOnTabSelectedListener = onTabSelectedListener;
    }

    public void updateSize() {
        LinearLayout linearLayout = this.mRootView;
        if (linearLayout == null || this.mTabs == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.height = (int) this.mTabbar.getLayoutHeight();
        this.mRootView.setLayoutParams(layoutParams);
        for (int i = 0; i < this.mTabs.size(); i++) {
            View b = this.mTabs.get(i).b();
            if (b != null) {
                ViewGroup.LayoutParams layoutParams2 = b.getLayoutParams();
                layoutParams2.height = (int) this.mTabbar.getLayoutHeight();
                b.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // android.view.View
    public LinearLayout getRootView() {
        return this.mRootView;
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTabs = new ArrayList<>();
        init(context);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTabs = new ArrayList<>();
        init(context);
    }
}
