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
    private b mSelectedTab;
    private View.OnClickListener mTabClickListener;
    private WXTabbar mTabbar;
    private final ArrayList<b> mTabs;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnTabSelectedListener {
        void onTabReselected(b bVar);

        void onTabSelected(b bVar);

        void onTabUnselected(b bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class a implements View.OnClickListener {
        a(TabLayout tabLayout) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((b) view.getTag()).d();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static final class b {
        public static final int INVALID_POSITION = -1;
        private int a = -1;
        private View b;
        private final TabLayout c;

        b(TabLayout tabLayout) {
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
        public b e(@Nullable View view) {
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

    private void addTabView(b bVar, boolean z) {
        View b2 = bVar.b();
        if (this.mTabClickListener == null) {
            this.mTabClickListener = new a(this);
        }
        if (b2 != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, (int) this.mTabbar.getLayoutHeight());
            layoutParams.weight = 1.0f;
            b2.setTag(bVar);
            b2.setLayoutParams(layoutParams);
            b2.setOnClickListener(this.mTabClickListener);
            this.mRootView.addView(b2);
            if (z) {
                b2.setSelected(true);
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
        View b2;
        ViewParent parent;
        b tabAt = getTabAt(i);
        if (tabAt == null || (b2 = tabAt.b()) == null || (parent = b2.getParent()) == this) {
            return;
        }
        if (parent != null) {
            ((ViewGroup) parent).removeView(b2);
        }
        addView(b2);
    }

    public void addTab(@NonNull b bVar, boolean z) {
        if (bVar.c == this) {
            addTabView(bVar, z);
            int size = this.mTabs.size();
            bVar.f(this.mTabs.size());
            this.mTabs.add(size, bVar);
            int size2 = this.mTabs.size();
            while (true) {
                size++;
                if (size >= size2) {
                    break;
                }
                this.mTabs.get(size).f(size);
            }
            if (z) {
                bVar.d();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public int getSelectedTabPosition() {
        b bVar = this.mSelectedTab;
        if (bVar != null) {
            return bVar.c();
        }
        return -1;
    }

    @Nullable
    public b getTabAt(int i) {
        return this.mTabs.get(i);
    }

    @NonNull
    public b newTab() {
        return new b(this);
    }

    public void removeAllTabs() {
        Iterator<b> it = this.mTabs.iterator();
        while (it.hasNext()) {
            it.next().f(-1);
            it.remove();
        }
        this.mSelectedTab = null;
    }

    void selectTab(b bVar) {
        OnTabSelectedListener onTabSelectedListener;
        OnTabSelectedListener onTabSelectedListener2;
        OnTabSelectedListener onTabSelectedListener3;
        b bVar2 = this.mSelectedTab;
        if (bVar2 == bVar) {
            if (bVar2 == null || (onTabSelectedListener3 = this.mOnTabSelectedListener) == null) {
                return;
            }
            onTabSelectedListener3.onTabReselected(bVar2);
            return;
        }
        if (bVar2 != null && (onTabSelectedListener2 = this.mOnTabSelectedListener) != null) {
            onTabSelectedListener2.onTabUnselected(bVar2);
        }
        this.mSelectedTab = bVar;
        if (bVar == null || (onTabSelectedListener = this.mOnTabSelectedListener) == null) {
            return;
        }
        onTabSelectedListener.onTabSelected(bVar);
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
            View b2 = this.mTabs.get(i).b();
            if (b2 != null) {
                ViewGroup.LayoutParams layoutParams2 = b2.getLayoutParams();
                layoutParams2.height = (int) this.mTabbar.getLayoutHeight();
                b2.setLayoutParams(layoutParams2);
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
