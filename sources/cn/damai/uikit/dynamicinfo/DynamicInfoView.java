package cn.damai.uikit.dynamicinfo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tb.yr2;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DynamicInfoView extends View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int CACHE_COUNT = 1000;
    private static final int DRAW_INTERVAL = 20;
    private static final float MOVING_DISTANCE = 1.5f;
    private int childCount;
    private int dividerCount;
    private a mCurrentClick;
    private List<a> mCurrentClickList;
    private Runnable mDrawingTask;
    private int mInfoIndex;
    private long mLastNotifyTimestamp;
    private DisplayListener mListener;
    private ArrayList<a> mPastedList;
    private ArrayList<a> mRunningList;
    private LinkedList<a> mWaitingList;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface DisplayListener {
        void onDisplayAll();

        void onDisplayCountdown(int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public static abstract class a<T> {
        private static transient /* synthetic */ IpChange $ipChange;
        protected int a;
        private int b;
        public boolean c;

        protected abstract void c(Canvas canvas, int i);

        protected abstract int d(Context context);
    }

    public DynamicInfoView(Context context) {
        super(context);
        this.mWaitingList = new LinkedList<>();
        this.mPastedList = new ArrayList<>();
        this.mRunningList = new ArrayList<>();
        this.mCurrentClickList = new ArrayList();
        this.mDrawingTask = new Runnable() { // from class: cn.damai.uikit.dynamicinfo.DynamicInfoView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "18804085")) {
                    ipChange.ipc$dispatch("18804085", new Object[]{this});
                } else if (DynamicInfoView.this.mWaitingList.isEmpty() && DynamicInfoView.this.mRunningList.isEmpty()) {
                    if (DynamicInfoView.this.mListener != null && System.currentTimeMillis() - DynamicInfoView.this.mLastNotifyTimestamp > 3000) {
                        DynamicInfoView.this.mLastNotifyTimestamp = System.currentTimeMillis();
                        DynamicInfoView.this.mListener.onDisplayAll();
                    }
                    DynamicInfoView dynamicInfoView = DynamicInfoView.this;
                    dynamicInfoView.postDelayed(dynamicInfoView.mDrawingTask, 20L);
                } else {
                    int height = DynamicInfoView.this.getHeight();
                    int a2 = yr2.a(DynamicInfoView.this.getContext(), 0.45000002f);
                    ArrayList arrayList = new ArrayList();
                    Iterator it = DynamicInfoView.this.mRunningList.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        int d = aVar.d(DynamicInfoView.this.getContext());
                        aVar.b -= a2;
                        int i = d + aVar.b;
                        if (i <= 0) {
                            arrayList.add(aVar);
                        }
                        height = i;
                    }
                    DynamicInfoView.this.mRunningList.removeAll(arrayList);
                    DynamicInfoView.this.mPastedList.addAll(arrayList);
                    DynamicInfoView.this.mWaitingList.addAll(arrayList);
                    if (DynamicInfoView.this.mPastedList.size() > 1000) {
                        DynamicInfoView.this.mPastedList.remove(0);
                    }
                    if (height <= DynamicInfoView.this.getBottom() && !DynamicInfoView.this.mWaitingList.isEmpty()) {
                        a aVar2 = (a) DynamicInfoView.this.mWaitingList.getFirst();
                        if (aVar2.d(DynamicInfoView.this.getContext()) + height < DynamicInfoView.this.getHeight()) {
                            height = DynamicInfoView.this.getHeight();
                        }
                        aVar2.b = height + 1;
                        DynamicInfoView.this.mWaitingList.remove(aVar2);
                        DynamicInfoView.this.mRunningList.add(aVar2);
                    }
                    if (DynamicInfoView.this.mListener != null && (!DynamicInfoView.this.mWaitingList.isEmpty() || !DynamicInfoView.this.mRunningList.isEmpty())) {
                        DynamicInfoView.this.mListener.onDisplayCountdown(DynamicInfoView.this.getDynamicInfoCount());
                    }
                    if (DynamicInfoView.this.mListener != null && DynamicInfoView.this.mWaitingList.isEmpty() && DynamicInfoView.this.mRunningList.isEmpty()) {
                        DynamicInfoView.this.mListener.onDisplayAll();
                    }
                    DynamicInfoView.this.invalidate();
                    DynamicInfoView dynamicInfoView2 = DynamicInfoView.this;
                    dynamicInfoView2.postDelayed(dynamicInfoView2.mDrawingTask, 20L);
                }
            }
        };
    }

    public void addDynamicInfo(a aVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-198093393")) {
            ipChange.ipc$dispatch("-198093393", new Object[]{this, aVar});
            return;
        }
        this.mWaitingList.add(aVar);
        int i = this.childCount + 1;
        this.childCount = i;
        int i2 = this.dividerCount;
        if (i2 > 0 && i % i2 == 0) {
            aVar.c = true;
        }
        int i3 = this.mInfoIndex;
        this.mInfoIndex = i3 + 1;
        aVar.a = i3;
    }

    public int getDynamicInfoCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "300719816") ? ((Integer) ipChange.ipc$dispatch("300719816", new Object[]{this})).intValue() : this.mRunningList.size() + this.mWaitingList.size();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "258846799")) {
            ipChange.ipc$dispatch("258846799", new Object[]{this});
            return;
        }
        post(this.mDrawingTask);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1265881166")) {
            ipChange.ipc$dispatch("-1265881166", new Object[]{this});
            return;
        }
        removeCallbacks(this.mDrawingTask);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-882562517")) {
            ipChange.ipc$dispatch("-882562517", new Object[]{this, canvas});
            return;
        }
        super.onDraw(canvas);
        Iterator<a> it = this.mRunningList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            next.c(canvas, next.b);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722475214")) {
            ipChange.ipc$dispatch("722475214", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1559019294")) {
            ipChange.ipc$dispatch("1559019294", new Object[]{this});
            return;
        }
        this.mPastedList.clear();
        this.mRunningList.clear();
        this.mWaitingList.clear();
        this.dividerCount = 0;
        this.childCount = 0;
    }

    public void setDividerCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1674243790")) {
            ipChange.ipc$dispatch("1674243790", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.dividerCount = i;
        }
    }

    public void setOnDisplayListener(DisplayListener displayListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "969142429")) {
            ipChange.ipc$dispatch("969142429", new Object[]{this, displayListener});
            return;
        }
        this.mListener = displayListener;
        if (displayListener == null || getDynamicInfoCount() != 0) {
            return;
        }
        this.mLastNotifyTimestamp = System.currentTimeMillis();
        this.mListener.onDisplayAll();
    }

    public DynamicInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWaitingList = new LinkedList<>();
        this.mPastedList = new ArrayList<>();
        this.mRunningList = new ArrayList<>();
        this.mCurrentClickList = new ArrayList();
        this.mDrawingTask = new Runnable() { // from class: cn.damai.uikit.dynamicinfo.DynamicInfoView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "18804085")) {
                    ipChange.ipc$dispatch("18804085", new Object[]{this});
                } else if (DynamicInfoView.this.mWaitingList.isEmpty() && DynamicInfoView.this.mRunningList.isEmpty()) {
                    if (DynamicInfoView.this.mListener != null && System.currentTimeMillis() - DynamicInfoView.this.mLastNotifyTimestamp > 3000) {
                        DynamicInfoView.this.mLastNotifyTimestamp = System.currentTimeMillis();
                        DynamicInfoView.this.mListener.onDisplayAll();
                    }
                    DynamicInfoView dynamicInfoView = DynamicInfoView.this;
                    dynamicInfoView.postDelayed(dynamicInfoView.mDrawingTask, 20L);
                } else {
                    int height = DynamicInfoView.this.getHeight();
                    int a2 = yr2.a(DynamicInfoView.this.getContext(), 0.45000002f);
                    ArrayList arrayList = new ArrayList();
                    Iterator it = DynamicInfoView.this.mRunningList.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        int d = aVar.d(DynamicInfoView.this.getContext());
                        aVar.b -= a2;
                        int i = d + aVar.b;
                        if (i <= 0) {
                            arrayList.add(aVar);
                        }
                        height = i;
                    }
                    DynamicInfoView.this.mRunningList.removeAll(arrayList);
                    DynamicInfoView.this.mPastedList.addAll(arrayList);
                    DynamicInfoView.this.mWaitingList.addAll(arrayList);
                    if (DynamicInfoView.this.mPastedList.size() > 1000) {
                        DynamicInfoView.this.mPastedList.remove(0);
                    }
                    if (height <= DynamicInfoView.this.getBottom() && !DynamicInfoView.this.mWaitingList.isEmpty()) {
                        a aVar2 = (a) DynamicInfoView.this.mWaitingList.getFirst();
                        if (aVar2.d(DynamicInfoView.this.getContext()) + height < DynamicInfoView.this.getHeight()) {
                            height = DynamicInfoView.this.getHeight();
                        }
                        aVar2.b = height + 1;
                        DynamicInfoView.this.mWaitingList.remove(aVar2);
                        DynamicInfoView.this.mRunningList.add(aVar2);
                    }
                    if (DynamicInfoView.this.mListener != null && (!DynamicInfoView.this.mWaitingList.isEmpty() || !DynamicInfoView.this.mRunningList.isEmpty())) {
                        DynamicInfoView.this.mListener.onDisplayCountdown(DynamicInfoView.this.getDynamicInfoCount());
                    }
                    if (DynamicInfoView.this.mListener != null && DynamicInfoView.this.mWaitingList.isEmpty() && DynamicInfoView.this.mRunningList.isEmpty()) {
                        DynamicInfoView.this.mListener.onDisplayAll();
                    }
                    DynamicInfoView.this.invalidate();
                    DynamicInfoView dynamicInfoView2 = DynamicInfoView.this;
                    dynamicInfoView2.postDelayed(dynamicInfoView2.mDrawingTask, 20L);
                }
            }
        };
    }
}
