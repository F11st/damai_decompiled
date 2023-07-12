package com.youku.live.dago.widgetlib.interactive.gift.view.indicator;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.kcrason.dynamicpagerindicatorlibrary.BasePagerTabView;
import com.kcrason.dynamicpagerindicatorlibrary.DynamicPagerIndicator;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLPagerTabIndicator extends DynamicPagerIndicator {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "LaifengPagerIndicator";

    public YKLPagerTabIndicator(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.kcrason.dynamicpagerindicatorlibrary.DynamicPagerIndicator
    public BasePagerTabView createTabView(Context context, PagerAdapter pagerAdapter, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1650725957") ? (BasePagerTabView) ipChange.ipc$dispatch("-1650725957", new Object[]{this, context, pagerAdapter, Integer.valueOf(i)}) : new YKLPagerTabView(context);
    }

    public void setIndicatorColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1201211067")) {
            ipChange.ipc$dispatch("-1201211067", new Object[]{this, str});
            return;
        }
        try {
            Class<?> cls = Class.forName("com.kcrason.dynamicpagerindicatorlibrary.DynamicPagerIndicator");
            Field declaredField = cls.getDeclaredField("mIndicatorLineStartColor");
            declaredField.setAccessible(true);
            declaredField.setInt(this, Color.parseColor(str));
            Field declaredField2 = cls.getDeclaredField("mIndicatorLineEndColor");
            declaredField2.setAccessible(true);
            declaredField2.setInt(this, Color.parseColor(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUnCheckedAll(boolean z, int i) {
        YKLPagerTabView yKLPagerTabView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1439287467")) {
            ipChange.ipc$dispatch("1439287467", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i)});
            return;
        }
        try {
            Field declaredField = Class.forName("com.kcrason.dynamicpagerindicatorlibrary.DynamicPagerIndicator").getDeclaredField("mScrollableLine");
            declaredField.setAccessible(true);
            ((View) declaredField.get(this)).setVisibility(z ? 4 : 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!(getPagerTabView(i) instanceof YKLPagerTabView) || (yKLPagerTabView = (YKLPagerTabView) getPagerTabView(i)) == null) {
            return;
        }
        yKLPagerTabView.setTextColor(z ? -1275068417 : -1);
        yKLPagerTabView.setTypeface(Typeface.defaultFromStyle(!z ? 1 : 0));
    }

    public void updateTabName(int i, String str) {
        YKLPagerTabView yKLPagerTabView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "896189523")) {
            ipChange.ipc$dispatch("896189523", new Object[]{this, Integer.valueOf(i), str});
        } else if (TextUtils.isEmpty(str) || (yKLPagerTabView = (YKLPagerTabView) getPagerTabView(i)) == null || yKLPagerTabView.getTabTextView() == null) {
        } else {
            yKLPagerTabView.getTabTextView().setText(str);
        }
    }

    public YKLPagerTabIndicator(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public YKLPagerTabIndicator(Context context) {
        super(context);
    }
}
