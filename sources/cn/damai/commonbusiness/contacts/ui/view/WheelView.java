package cn.damai.commonbusiness.contacts.ui.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class WheelView extends ScrollView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int OFF_SET_DEFAULT = 1;
    private static final int SCROLL_DIRECTION_DOWN = 1;
    private static final int SCROLL_DIRECTION_UP = 0;
    public static final String TAG = WheelView.class.getSimpleName();
    int displayItemCount;
    int initialY;
    int itemHeight;
    List<String> items;
    int newCheck;
    int offset;
    private C0631b onWheelViewListener;
    Paint paint;
    private int scrollDirection;
    Runnable scrollerTask;
    int[] selectedAreaBorder;
    int selectedIndex;
    int viewWidth;
    private LinearLayout views;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.view.WheelView$a */
    /* loaded from: classes14.dex */
    public class C0630a extends Drawable {
        private static transient /* synthetic */ IpChange $ipChange;

        C0630a() {
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "238590280")) {
                ipChange.ipc$dispatch("238590280", new Object[]{this, canvas});
                return;
            }
            float f = WheelView.this.obtainSelectedAreaBorder()[0];
            WheelView wheelView = WheelView.this;
            canvas.drawLine(0.0f, f, wheelView.viewWidth, wheelView.obtainSelectedAreaBorder()[0], WheelView.this.paint);
            float f2 = WheelView.this.obtainSelectedAreaBorder()[1];
            WheelView wheelView2 = WheelView.this;
            canvas.drawLine(0.0f, f2, wheelView2.viewWidth, wheelView2.obtainSelectedAreaBorder()[1], WheelView.this.paint);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "221243775")) {
                return ((Integer) ipChange.ipc$dispatch("221243775", new Object[]{this})).intValue();
            }
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-608843074")) {
                ipChange.ipc$dispatch("-608843074", new Object[]{this, Integer.valueOf(i)});
            }
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-269083072")) {
                ipChange.ipc$dispatch("-269083072", new Object[]{this, colorFilter});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.contacts.ui.view.WheelView$b */
    /* loaded from: classes14.dex */
    public static class C0631b {
        private static transient /* synthetic */ IpChange $ipChange;

        public void a(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "334721699")) {
                ipChange.ipc$dispatch("334721699", new Object[]{this, Integer.valueOf(i), str});
            }
        }
    }

    public WheelView(Context context) {
        super(context);
        this.offset = 1;
        this.selectedIndex = 1;
        this.newCheck = 50;
        this.itemHeight = 0;
        this.scrollDirection = -1;
        init(context);
    }

    private TextView createView(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1850657744")) {
            return (TextView) ipChange.ipc$dispatch("1850657744", new Object[]{this, str});
        }
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(1, 16.0f);
        textView.setText(str);
        textView.setGravity(17);
        textView.setBackgroundColor(-1);
        int dip2px = dip2px(15.0f);
        textView.setPadding(dip2px, dip2px, dip2px, dip2px);
        if (this.itemHeight == 0) {
            this.itemHeight = getViewMeasuredHeight(textView);
            this.views.setLayoutParams(new FrameLayout.LayoutParams(-1, this.itemHeight * this.displayItemCount));
            setLayoutParams(new LinearLayout.LayoutParams(((LinearLayout.LayoutParams) getLayoutParams()).width, this.itemHeight * this.displayItemCount));
        }
        return textView;
    }

    private int dip2px(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-569411217") ? ((Integer) ipChange.ipc$dispatch("-569411217", new Object[]{this, Float.valueOf(f)})).intValue() : (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private List<String> getItems() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1594760578") ? (List) ipChange.ipc$dispatch("-1594760578", new Object[]{this}) : this.items;
    }

    private int getViewMeasuredHeight(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-834882506")) {
            return ((Integer) ipChange.ipc$dispatch("-834882506", new Object[]{this, view})).intValue();
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        return view.getMeasuredHeight();
    }

    private void init(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1819354693")) {
            ipChange.ipc$dispatch("1819354693", new Object[]{this, context});
            return;
        }
        String str = TAG;
        Log.d(str, "parent: " + getParent());
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.views = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.views);
        this.scrollerTask = new Runnable() { // from class: cn.damai.commonbusiness.contacts.ui.view.WheelView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1296320351")) {
                    ipChange2.ipc$dispatch("1296320351", new Object[]{this});
                    return;
                }
                int scrollY = WheelView.this.getScrollY();
                WheelView wheelView = WheelView.this;
                int i = wheelView.initialY;
                if (i - scrollY == 0) {
                    int i2 = wheelView.itemHeight;
                    final int i3 = i % i2;
                    final int i4 = i / i2;
                    if (i3 == 0) {
                        wheelView.selectedIndex = i4 + wheelView.offset;
                        wheelView.onSeletedCallBack();
                        return;
                    } else if (i3 > i2 / 2) {
                        wheelView.post(new Runnable() { // from class: cn.damai.commonbusiness.contacts.ui.view.WheelView.1.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "1864608562")) {
                                    ipChange3.ipc$dispatch("1864608562", new Object[]{this});
                                    return;
                                }
                                WheelView wheelView2 = WheelView.this;
                                wheelView2.smoothScrollTo(0, (wheelView2.initialY - i3) + wheelView2.itemHeight);
                                WheelView wheelView3 = WheelView.this;
                                wheelView3.selectedIndex = i4 + wheelView3.offset + 1;
                                wheelView3.onSeletedCallBack();
                            }
                        });
                        return;
                    } else {
                        wheelView.post(new Runnable() { // from class: cn.damai.commonbusiness.contacts.ui.view.WheelView.1.2
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "1668095057")) {
                                    ipChange3.ipc$dispatch("1668095057", new Object[]{this});
                                    return;
                                }
                                WheelView wheelView2 = WheelView.this;
                                wheelView2.smoothScrollTo(0, wheelView2.initialY - i3);
                                WheelView wheelView3 = WheelView.this;
                                wheelView3.selectedIndex = i4 + wheelView3.offset;
                                wheelView3.onSeletedCallBack();
                            }
                        });
                        return;
                    }
                }
                wheelView.initialY = wheelView.getScrollY();
                WheelView wheelView2 = WheelView.this;
                wheelView2.postDelayed(wheelView2.scrollerTask, wheelView2.newCheck);
            }
        };
    }

    private void initData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "291406809")) {
            ipChange.ipc$dispatch("291406809", new Object[]{this});
            return;
        }
        this.displayItemCount = (this.offset * 2) + 1;
        for (String str : this.items) {
            this.views.addView(createView(str));
        }
        refreshItemView(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] obtainSelectedAreaBorder() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-453429910")) {
            return (int[]) ipChange.ipc$dispatch("-453429910", new Object[]{this});
        }
        if (this.selectedAreaBorder == null) {
            this.selectedAreaBorder = r0;
            int i = this.itemHeight;
            int i2 = this.offset;
            int[] iArr = {i * i2, i * (i2 + 1)};
        }
        return this.selectedAreaBorder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSeletedCallBack() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1988100759")) {
            ipChange.ipc$dispatch("-1988100759", new Object[]{this});
            return;
        }
        C0631b c0631b = this.onWheelViewListener;
        if (c0631b != null) {
            int i = this.selectedIndex;
            c0631b.a(i, this.items.get(i));
        }
    }

    private void refreshItemView(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-984847745")) {
            ipChange.ipc$dispatch("-984847745", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int i2 = this.itemHeight;
        int i3 = this.offset;
        int i4 = (i / i2) + i3;
        int i5 = i % i2;
        int i6 = i / i2;
        if (i5 == 0) {
            i4 = i6 + i3;
        } else if (i5 > i2 / 2) {
            i4 = i6 + i3 + 1;
        }
        int childCount = this.views.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            TextView textView = (TextView) this.views.getChildAt(i7);
            if (textView == null) {
                return;
            }
            if (i4 == i7) {
                textView.setTextColor(Color.parseColor("#222222"));
            } else {
                textView.setTextColor(Color.parseColor("#999999"));
            }
        }
    }

    @Override // android.widget.ScrollView
    public void fling(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1523227784")) {
            ipChange.ipc$dispatch("1523227784", new Object[]{this, Integer.valueOf(i)});
        } else {
            super.fling(i / 3);
        }
    }

    public int getOffset() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1286251647") ? ((Integer) ipChange.ipc$dispatch("-1286251647", new Object[]{this})).intValue() : this.offset;
    }

    public C0631b getOnWheelViewListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1129140990") ? (C0631b) ipChange.ipc$dispatch("-1129140990", new Object[]{this}) : this.onWheelViewListener;
    }

    public int getSeletedIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-896661782") ? ((Integer) ipChange.ipc$dispatch("-896661782", new Object[]{this})).intValue() : this.selectedIndex - this.offset;
    }

    public String getSeletedItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1895580942") ? (String) ipChange.ipc$dispatch("-1895580942", new Object[]{this}) : this.items.get(this.selectedIndex);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1944238353")) {
            ipChange.ipc$dispatch("-1944238353", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onScrollChanged(i, i2, i3, i4);
        refreshItemView(i2);
        if (i2 > i4) {
            this.scrollDirection = 1;
        } else {
            this.scrollDirection = 0;
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2138525341")) {
            ipChange.ipc$dispatch("-2138525341", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        this.viewWidth = i;
        setBackgroundDrawable(null);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1647578958")) {
            return ((Boolean) ipChange.ipc$dispatch("-1647578958", new Object[]{this, motionEvent})).booleanValue();
        }
        if (motionEvent.getAction() == 1) {
            startScrollerTask();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1689846611")) {
            ipChange.ipc$dispatch("-1689846611", new Object[]{this, drawable});
            return;
        }
        if (this.viewWidth == 0) {
            this.viewWidth = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getWidth();
        }
        if (this.paint == null) {
            Paint paint = new Paint();
            this.paint = paint;
            paint.setColor(Color.parseColor("#f2f3f4"));
            this.paint.setStrokeWidth(dip2px(0.5f));
        }
        super.setBackgroundDrawable(new C0630a());
    }

    public void setItems(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "131157158")) {
            ipChange.ipc$dispatch("131157158", new Object[]{this, list});
            return;
        }
        if (this.items == null) {
            this.items = new ArrayList();
        }
        this.items.clear();
        this.items.addAll(list);
        for (int i = 0; i < this.offset; i++) {
            this.items.add(0, "");
            this.items.add("");
        }
        initData();
    }

    public void setOffset(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-444934335")) {
            ipChange.ipc$dispatch("-444934335", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.offset = i;
        }
    }

    public void setOnWheelViewListener(C0631b c0631b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1889936224")) {
            ipChange.ipc$dispatch("1889936224", new Object[]{this, c0631b});
        } else {
            this.onWheelViewListener = c0631b;
        }
    }

    public void setSeletion(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-444829299")) {
            ipChange.ipc$dispatch("-444829299", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.selectedIndex = this.offset + i;
        post(new Runnable() { // from class: cn.damai.commonbusiness.contacts.ui.view.WheelView.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "903293341")) {
                    ipChange2.ipc$dispatch("903293341", new Object[]{this});
                    return;
                }
                WheelView wheelView = WheelView.this;
                wheelView.smoothScrollTo(0, i * wheelView.itemHeight);
            }
        });
    }

    public void startScrollerTask() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1905454006")) {
            ipChange.ipc$dispatch("1905454006", new Object[]{this});
            return;
        }
        this.initialY = getScrollY();
        postDelayed(this.scrollerTask, this.newCheck);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.offset = 1;
        this.selectedIndex = 1;
        this.newCheck = 50;
        this.itemHeight = 0;
        this.scrollDirection = -1;
        init(context);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.offset = 1;
        this.selectedIndex = 1;
        this.newCheck = 50;
        this.itemHeight = 0;
        this.scrollDirection = -1;
        init(context);
    }
}
