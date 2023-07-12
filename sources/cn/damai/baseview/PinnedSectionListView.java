package cn.damai.baseview;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.l62;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PinnedSectionListView extends ListView {
    private static transient /* synthetic */ IpChange $ipChange;
    private final DataSetObserver mDataSetObserver;
    private AbsListView.OnScrollListener mDelegateOnScrollListener;
    private MotionEvent mDownEvent;
    private final AbsListView.OnScrollListener mOnScrollListener;
    private C0274b mPinnedSection;
    public PinnedSectionListAdapter mPinnedSectionListAdapter;
    private int mScreenWidth;
    private int mSectionsDistanceY;
    private GradientDrawable mShadowDrawable;
    private int mShadowHeight;
    private final PointF mTouchPoint;
    private final Rect mTouchRect;
    private int mTouchSlop;
    private View mTouchTarget;
    private int mTranslateY;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface PinnedSectionListAdapter extends ListAdapter {
        View getTitleView(int i);

        boolean isItemViewTypePinned(int i);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.baseview.PinnedSectionListView$a */
    /* loaded from: classes.dex */
    public class C0273a extends DataSetObserver {
        private static transient /* synthetic */ IpChange $ipChange;

        C0273a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1135271049")) {
                ipChange.ipc$dispatch("-1135271049", new Object[]{this});
            } else {
                PinnedSectionListView.this.recreatePinnedShadow();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-795608958")) {
                ipChange.ipc$dispatch("-795608958", new Object[]{this});
            } else {
                PinnedSectionListView.this.recreatePinnedShadow();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: cn.damai.baseview.PinnedSectionListView$b */
    /* loaded from: classes.dex */
    public static class C0274b {
        public View a;
        public int b;
        public long c;

        private C0274b() {
        }
    }

    public PinnedSectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTouchRect = new Rect();
        this.mTouchPoint = new PointF();
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: cn.damai.baseview.PinnedSectionListView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1686715827")) {
                    ipChange.ipc$dispatch("-1686715827", new Object[]{this, absListView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                    return;
                }
                if (PinnedSectionListView.this.mDelegateOnScrollListener != null) {
                    PinnedSectionListView.this.mDelegateOnScrollListener.onScroll(absListView, i, i2, i3);
                }
                ListAdapter adapter = PinnedSectionListView.this.getAdapter();
                if (adapter == null || i2 == 0) {
                    return;
                }
                if (!PinnedSectionListView.isItemViewTypePinned(adapter, adapter.getItemViewType(i))) {
                    int findCurrentSectionPosition = PinnedSectionListView.this.findCurrentSectionPosition(i);
                    if (findCurrentSectionPosition > -1) {
                        PinnedSectionListView.this.ensureShadowForPosition(findCurrentSectionPosition, i, i2);
                    } else {
                        PinnedSectionListView.this.mPinnedSection = null;
                    }
                } else if (PinnedSectionListView.this.getChildAt(0).getTop() == PinnedSectionListView.this.getPaddingTop()) {
                    PinnedSectionListView.this.mPinnedSection = null;
                } else {
                    PinnedSectionListView.this.ensureShadowForPosition(i, i, i2);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-351581136")) {
                    ipChange.ipc$dispatch("-351581136", new Object[]{this, absListView, Integer.valueOf(i)});
                } else if (PinnedSectionListView.this.mDelegateOnScrollListener != null) {
                    PinnedSectionListView.this.mDelegateOnScrollListener.onScrollStateChanged(absListView, i);
                }
            }
        };
        this.mDataSetObserver = new C0273a();
        initView();
    }

    private void clearTouchTarget() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1988664884")) {
            ipChange.ipc$dispatch("-1988664884", new Object[]{this});
            return;
        }
        this.mTouchTarget = null;
        MotionEvent motionEvent = this.mDownEvent;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.mDownEvent = null;
        }
    }

    private void createPinnedShadow(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-526988856")) {
            ipChange.ipc$dispatch("-526988856", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        C0274b c0274b = new C0274b();
        View view = getAdapter().getView(i, c0274b.a, this);
        View titleView = this.mPinnedSectionListAdapter.getTitleView(i);
        AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new AbsListView.LayoutParams(-1, -2);
        }
        View.MeasureSpec.getMode(layoutParams.height);
        View.MeasureSpec.getSize(layoutParams.height);
        getHeight();
        getListPaddingTop();
        getListPaddingBottom();
        this.mTranslateY = 0;
        int a = l62.a(getContext(), 40.0f);
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundColor(Color.parseColor("#e6e6e6"));
        ((LinearLayout) titleView).addView(imageView, this.mScreenWidth, 1);
        titleView.setBackgroundColor(Color.argb(242, 255, 255, 255));
        int i2 = a + 1;
        titleView.measure(this.mScreenWidth, i2);
        titleView.layout(0, 0, this.mScreenWidth, i2);
        c0274b.a = titleView;
        c0274b.b = i;
        c0274b.c = getAdapter().getItemId(i);
        this.mPinnedSection = c0274b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureShadowForPosition(int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-900479716")) {
            ipChange.ipc$dispatch("-900479716", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        } else if (i3 < 2) {
            this.mPinnedSection = null;
        } else {
            C0274b c0274b = this.mPinnedSection;
            if (c0274b != null && c0274b.b != i) {
                this.mPinnedSection = null;
            }
            if (this.mPinnedSection == null) {
                createPinnedShadow(i);
            }
            int i4 = i + 1;
            if (i4 < getCount()) {
                int findFirstVisibleSectionPosition = findFirstVisibleSectionPosition(i4, i3 - (i4 - i2));
                if (findFirstVisibleSectionPosition > -1) {
                    int top = getChildAt(findFirstVisibleSectionPosition - i2).getTop() - (this.mPinnedSection.a.getBottom() + getPaddingTop());
                    this.mSectionsDistanceY = top;
                    if (top < 0) {
                        this.mTranslateY = top;
                        return;
                    } else {
                        this.mTranslateY = 0;
                        return;
                    }
                }
                this.mTranslateY = 0;
                this.mSectionsDistanceY = Integer.MAX_VALUE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int findCurrentSectionPosition(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671471125")) {
            return ((Integer) ipChange.ipc$dispatch("671471125", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        ListAdapter adapter = getAdapter();
        if (adapter instanceof SectionIndexer) {
            SectionIndexer sectionIndexer = (SectionIndexer) adapter;
            int positionForSection = sectionIndexer.getPositionForSection(sectionIndexer.getSectionForPosition(i));
            if (isItemViewTypePinned(adapter, adapter.getItemViewType(positionForSection))) {
                return positionForSection;
            }
        }
        while (i >= 0) {
            if (isItemViewTypePinned(adapter, adapter.getItemViewType(i))) {
                return i;
            }
            i--;
        }
        return -1;
    }

    private int findFirstVisibleSectionPosition(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "122285467")) {
            return ((Integer) ipChange.ipc$dispatch("122285467", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).intValue();
        }
        ListAdapter adapter = getAdapter();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i + i3;
            if (isItemViewTypePinned(adapter, adapter.getItemViewType(i4))) {
                return i4;
            }
        }
        return -1;
    }

    private void initShadow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-106918475")) {
            ipChange.ipc$dispatch("-106918475", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            if (this.mShadowDrawable == null) {
                this.mShadowDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#ffa0a0a0"), Color.parseColor("#50a0a0a0"), Color.parseColor("#00a0a0a0")});
                this.mShadowHeight = (int) (getResources().getDisplayMetrics().density * 8.0f);
            }
        } else if (this.mShadowDrawable != null) {
            this.mShadowDrawable = null;
            this.mShadowHeight = 0;
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1672447014")) {
            ipChange.ipc$dispatch("-1672447014", new Object[]{this});
            return;
        }
        setOnScrollListener(this.mOnScrollListener);
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        initShadow(true);
    }

    public static boolean isItemViewTypePinned(ListAdapter listAdapter, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2048289981")) {
            return ((Boolean) ipChange.ipc$dispatch("-2048289981", new Object[]{listAdapter, Integer.valueOf(i)})).booleanValue();
        }
        if (listAdapter instanceof HeaderViewListAdapter) {
            listAdapter = ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return ((PinnedSectionListAdapter) listAdapter).isItemViewTypePinned(i);
    }

    private boolean isPinnedViewTouched(View view, float f, float f2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "530627090")) {
            return ((Boolean) ipChange.ipc$dispatch("530627090", new Object[]{this, view, Float.valueOf(f), Float.valueOf(f2)})).booleanValue();
        }
        view.getHitRect(this.mTouchRect);
        Rect rect = this.mTouchRect;
        int i = rect.top;
        int i2 = this.mTranslateY;
        rect.top = i + i2;
        rect.bottom += i2 + getPaddingTop();
        this.mTouchRect.left += getPaddingLeft();
        this.mTouchRect.right -= getPaddingRight();
        return this.mTouchRect.contains((int) f, (int) f2);
    }

    private boolean performPinnedItemClick() {
        AdapterView.OnItemClickListener onItemClickListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-23312073")) {
            return ((Boolean) ipChange.ipc$dispatch("-23312073", new Object[]{this})).booleanValue();
        }
        if (this.mPinnedSection == null || (onItemClickListener = getOnItemClickListener()) == null) {
            return false;
        }
        View view = this.mPinnedSection.a;
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        C0274b c0274b = this.mPinnedSection;
        onItemClickListener.onItemClick(this, view, c0274b.b, c0274b.c);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recreatePinnedShadow() {
        int firstVisiblePosition;
        int findCurrentSectionPosition;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1720349240")) {
            ipChange.ipc$dispatch("-1720349240", new Object[]{this});
            return;
        }
        this.mPinnedSection = null;
        ListAdapter adapter = getAdapter();
        if (adapter == null || adapter.getCount() <= 0 || (findCurrentSectionPosition = findCurrentSectionPosition((firstVisiblePosition = getFirstVisiblePosition()))) == -1) {
            return;
        }
        ensureShadowForPosition(findCurrentSectionPosition, firstVisiblePosition, getLastVisiblePosition() - firstVisiblePosition);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1162471084")) {
            ipChange.ipc$dispatch("-1162471084", new Object[]{this, canvas});
            return;
        }
        super.dispatchDraw(canvas);
        if (this.mPinnedSection != null) {
            int listPaddingLeft = getListPaddingLeft();
            int listPaddingTop = getListPaddingTop();
            View view = this.mPinnedSection.a;
            canvas.save();
            canvas.clipRect(listPaddingLeft, listPaddingTop, view.getWidth() + listPaddingLeft, view.getHeight() + (this.mShadowDrawable != null ? Math.min(this.mShadowHeight, this.mSectionsDistanceY) : 0) + listPaddingTop);
            canvas.translate(listPaddingLeft, listPaddingTop + this.mTranslateY);
            drawChild(canvas, this.mPinnedSection.a, getDrawingTime());
            GradientDrawable gradientDrawable = this.mShadowDrawable;
            if (gradientDrawable != null && this.mSectionsDistanceY > 0) {
                gradientDrawable.setBounds(this.mPinnedSection.a.getLeft(), this.mPinnedSection.a.getBottom(), this.mPinnedSection.a.getRight(), this.mPinnedSection.a.getBottom() + this.mShadowHeight);
                this.mShadowDrawable.draw(canvas);
            }
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        C0274b c0274b;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "968705555")) {
            return ((Boolean) ipChange.ipc$dispatch("968705555", new Object[]{this, motionEvent})).booleanValue();
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0 && this.mTouchTarget == null && (c0274b = this.mPinnedSection) != null && isPinnedViewTouched(c0274b.a, x, y)) {
            this.mTouchTarget = this.mPinnedSection.a;
            PointF pointF = this.mTouchPoint;
            pointF.x = x;
            pointF.y = y;
            this.mDownEvent = MotionEvent.obtain(motionEvent);
        }
        View view = this.mTouchTarget;
        if (view != null) {
            if (isPinnedViewTouched(view, x, y)) {
                this.mTouchTarget.dispatchTouchEvent(motionEvent);
            }
            if (action == 1) {
                super.dispatchTouchEvent(motionEvent);
                performPinnedItemClick();
                clearTouchTarget();
            } else if (action == 3) {
                clearTouchTarget();
            } else if (action == 2 && Math.abs(y - this.mTouchPoint.y) > this.mTouchSlop) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                this.mTouchTarget.dispatchTouchEvent(obtain);
                obtain.recycle();
                super.dispatchTouchEvent(this.mDownEvent);
                super.dispatchTouchEvent(motionEvent);
                clearTouchTarget();
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "231710734")) {
            ipChange.ipc$dispatch("231710734", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
        if (this.mPinnedSection == null || ((i3 - i) - getPaddingLeft()) - getPaddingRight() == this.mPinnedSection.a.getWidth()) {
            return;
        }
        recreatePinnedShadow();
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2007496177")) {
            ipChange.ipc$dispatch("2007496177", new Object[]{this, parcelable});
            return;
        }
        super.onRestoreInstanceState(parcelable);
        post(new Runnable() { // from class: cn.damai.baseview.PinnedSectionListView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1968696323")) {
                    ipChange2.ipc$dispatch("1968696323", new Object[]{this});
                } else {
                    PinnedSectionListView.this.recreatePinnedShadow();
                }
            }
        });
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "889972526")) {
            ipChange.ipc$dispatch("889972526", new Object[]{this, onScrollListener});
        } else if (onScrollListener == this.mOnScrollListener) {
            super.setOnScrollListener(onScrollListener);
        } else {
            this.mDelegateOnScrollListener = onScrollListener;
        }
    }

    public void setShadowVisible(boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2028600114")) {
            ipChange.ipc$dispatch("-2028600114", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i)});
            return;
        }
        this.mScreenWidth = i;
        initShadow(z);
        C0274b c0274b = this.mPinnedSection;
        if (c0274b != null) {
            View view = c0274b.a;
            invalidate(view.getLeft(), view.getTop(), view.getRight(), view.getBottom() + this.mShadowHeight);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2124109323")) {
            ipChange.ipc$dispatch("2124109323", new Object[]{this, listAdapter});
            return;
        }
        if (listAdapter != null) {
            if (listAdapter instanceof PinnedSectionListAdapter) {
                this.mPinnedSectionListAdapter = (PinnedSectionListAdapter) listAdapter;
                if (listAdapter.getViewTypeCount() < 2) {
                    throw new IllegalArgumentException("Does your adapter handle at least two types of views in getViewTypeCount() method: items and sections?");
                }
            } else {
                throw new IllegalArgumentException("Does your adapter implement PinnedSectionListAdapter?");
            }
        }
        ListAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.unregisterDataSetObserver(this.mDataSetObserver);
        }
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mDataSetObserver);
        }
        if (adapter != listAdapter) {
            this.mPinnedSection = null;
        }
        super.setAdapter(listAdapter);
    }

    public PinnedSectionListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTouchRect = new Rect();
        this.mTouchPoint = new PointF();
        this.mOnScrollListener = new AbsListView.OnScrollListener() { // from class: cn.damai.baseview.PinnedSectionListView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i22, int i3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1686715827")) {
                    ipChange.ipc$dispatch("-1686715827", new Object[]{this, absListView, Integer.valueOf(i2), Integer.valueOf(i22), Integer.valueOf(i3)});
                    return;
                }
                if (PinnedSectionListView.this.mDelegateOnScrollListener != null) {
                    PinnedSectionListView.this.mDelegateOnScrollListener.onScroll(absListView, i2, i22, i3);
                }
                ListAdapter adapter = PinnedSectionListView.this.getAdapter();
                if (adapter == null || i22 == 0) {
                    return;
                }
                if (!PinnedSectionListView.isItemViewTypePinned(adapter, adapter.getItemViewType(i2))) {
                    int findCurrentSectionPosition = PinnedSectionListView.this.findCurrentSectionPosition(i2);
                    if (findCurrentSectionPosition > -1) {
                        PinnedSectionListView.this.ensureShadowForPosition(findCurrentSectionPosition, i2, i22);
                    } else {
                        PinnedSectionListView.this.mPinnedSection = null;
                    }
                } else if (PinnedSectionListView.this.getChildAt(0).getTop() == PinnedSectionListView.this.getPaddingTop()) {
                    PinnedSectionListView.this.mPinnedSection = null;
                } else {
                    PinnedSectionListView.this.ensureShadowForPosition(i2, i2, i22);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-351581136")) {
                    ipChange.ipc$dispatch("-351581136", new Object[]{this, absListView, Integer.valueOf(i2)});
                } else if (PinnedSectionListView.this.mDelegateOnScrollListener != null) {
                    PinnedSectionListView.this.mDelegateOnScrollListener.onScrollStateChanged(absListView, i2);
                }
            }
        };
        this.mDataSetObserver = new C0273a();
        initView();
    }
}
