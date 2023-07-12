package cn.damai.ticklet.ui.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import cn.damai.ticklet.view.TickletTicketItemDigitalTicketsView;
import cn.damai.ticklet.view.TickletTicketItemView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.LinkedHashMap;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class AutoResizeViewPager extends ViewPager {
    private static transient /* synthetic */ IpChange $ipChange;
    private int current;
    private int height;
    private HashMap<Integer, View> mChildrenViews;
    private boolean scrollble;
    private HashMap<Integer, HashMap<Integer, Integer>> textHeightMap;
    private TextView textView;

    public AutoResizeViewPager(Context context) {
        super(context);
        this.height = 0;
        this.mChildrenViews = new LinkedHashMap();
        this.textHeightMap = new LinkedHashMap();
        this.scrollble = true;
    }

    private int getOffset(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-830351842") ? ((Integer) ipChange.ipc$dispatch("-830351842", new Object[]{this, Integer.valueOf(i)})).intValue() : q60.a(getContext(), i * 15);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x011c, code lost:
        if (r8.textHeightMap.get(java.lang.Integer.valueOf(r8.current)).get(java.lang.Integer.valueOf(r6)).intValue() == r10) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x013a, code lost:
        if (r8.textHeightMap.get(java.lang.Integer.valueOf(r8.current)).get(java.lang.Integer.valueOf(r0)).intValue() != r10) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int heightMeasure(android.widget.TextView r9, int r10) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.ticklet.ui.adapter.AutoResizeViewPager.heightMeasure(android.widget.TextView, int):int");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        IpChange ipChange = $ipChange;
        int i4 = 0;
        int i5 = 1;
        if (AndroidInstantRuntime.support(ipChange, "985607426")) {
            ipChange.ipc$dispatch("985607426", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        if (this.mChildrenViews.get(Integer.valueOf(this.current)) != null) {
            View view = this.mChildrenViews.get(Integer.valueOf(this.current));
            view.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = view.getMeasuredHeight();
            if (view instanceof TickletTicketItemView) {
                TextView tipTv = ((TickletTicketItemView) view).getTipTv();
                this.textView = tipTv;
                i3 = tipTv.getLineCount() <= 1 ? 1 : 2;
                i4 = heightMeasure(this.textView, measuredHeight);
            } else {
                if (view instanceof TickletTicketItemDigitalTicketsView) {
                    TextView tipTv2 = ((TickletTicketItemDigitalTicketsView) view).getTipTv();
                    this.textView = tipTv2;
                    i3 = tipTv2.getLineCount() <= 1 ? 1 : 2;
                    i4 = heightMeasure(this.textView, measuredHeight);
                }
                this.height = measuredHeight + getOffset(i5) + i4;
            }
            i5 = i3;
            this.height = measuredHeight + getOffset(i5) + i4;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(this.height, 1073741824));
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "18010280")) {
            return ((Boolean) ipChange.ipc$dispatch("18010280", new Object[]{this, motionEvent})).booleanValue();
        }
        if (this.scrollble) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void resetHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1809623432")) {
            ipChange.ipc$dispatch("-1809623432", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.current = i;
        if (!this.textHeightMap.containsKey(Integer.valueOf(i))) {
            this.textHeightMap.put(Integer.valueOf(i), new HashMap<>());
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, this.height);
        } else {
            layoutParams.height = this.height;
        }
        setLayoutParams(layoutParams);
    }

    public void setObjectForPosition(View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1184421417")) {
            ipChange.ipc$dispatch("1184421417", new Object[]{this, view, Integer.valueOf(i)});
        } else {
            this.mChildrenViews.put(Integer.valueOf(i), view);
        }
    }

    public AutoResizeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.height = 0;
        this.mChildrenViews = new LinkedHashMap();
        this.textHeightMap = new LinkedHashMap();
        this.scrollble = true;
    }
}
