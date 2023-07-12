package cn.damai.baseview.grid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.ArrayList;
import java.util.Iterator;
import tb.pw2;

/* compiled from: Taobao */
@SuppressLint({"WrongCall"})
/* loaded from: classes.dex */
public abstract class ExtendableListView extends AbsListView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final boolean DBG = false;
    private static final int INVALID_POINTER = -1;
    private static final int LAYOUT_FORCE_TOP = 1;
    private static final int LAYOUT_NORMAL = 0;
    private static final int LAYOUT_SYNC = 2;
    private static final String TAG = "ExtendableListView";
    private static final int TOUCH_MODE_DONE_WAITING = 5;
    private static final int TOUCH_MODE_DOWN = 3;
    private static final int TOUCH_MODE_FLINGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private static final int TOUCH_MODE_SCROLLING = 1;
    private static final int TOUCH_MODE_TAP = 4;
    private int mActivePointerId;
    ListAdapter mAdapter;
    private boolean mBlockLayoutRequests;
    protected boolean mClipToPadding;
    private boolean mDataChanged;
    protected int mFirstPosition;
    private FlingRunnable mFlingRunnable;
    private int mFlingVelocity;
    private ArrayList<c> mFooterViewInfos;
    private ArrayList<c> mHeaderViewInfos;
    private boolean mInLayout;
    private boolean mIsAttached;
    final boolean[] mIsScrap;
    private int mItemCount;
    private int mLastY;
    private int mLayoutMode;
    private int mMaximumVelocity;
    private int mMotionCorrection;
    private int mMotionPosition;
    private int mMotionX;
    private int mMotionY;
    boolean mNeedSync;
    private b mObserver;
    private int mOldItemCount;
    private AbsListView.OnScrollListener mOnScrollListener;
    private PerformClick mPerformClick;
    private d mRecycleBin;
    private int mScrollState;
    protected int mSpecificTop;
    long mSyncHeight;
    protected int mSyncPosition;
    long mSyncRowId;
    private ListSavedState mSyncState;
    private int mTouchMode;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private int mWidthMeasureSpec;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class FlingRunnable implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private int mLastFlingY;
        private final Scroller mScroller;

        FlingRunnable() {
            this.mScroller = new Scroller(ExtendableListView.this.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endFling() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1583274189")) {
                ipChange.ipc$dispatch("-1583274189", new Object[]{this});
                return;
            }
            this.mLastFlingY = 0;
            ExtendableListView.this.mTouchMode = 0;
            ExtendableListView.this.reportScrollStateChange(0);
            ExtendableListView.this.removeCallbacks(this);
            this.mScroller.forceFinished(true);
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "154543371")) {
                ipChange.ipc$dispatch("154543371", new Object[]{this});
            } else if (ExtendableListView.this.mTouchMode != 2) {
            } else {
                if (ExtendableListView.this.mItemCount != 0 && ExtendableListView.this.getChildCount() != 0) {
                    Scroller scroller = this.mScroller;
                    boolean computeScrollOffset = scroller.computeScrollOffset();
                    int currY = scroller.getCurrY();
                    int i = this.mLastFlingY - currY;
                    if (i > 0) {
                        ExtendableListView extendableListView = ExtendableListView.this;
                        extendableListView.mMotionPosition = extendableListView.mFirstPosition;
                        max = Math.min(((ExtendableListView.this.getHeight() - ExtendableListView.this.getPaddingBottom()) - ExtendableListView.this.getPaddingTop()) - 1, i);
                    } else {
                        ExtendableListView extendableListView2 = ExtendableListView.this;
                        extendableListView2.mMotionPosition = extendableListView2.mFirstPosition + (ExtendableListView.this.getChildCount() - 1);
                        max = Math.max(-(((ExtendableListView.this.getHeight() - ExtendableListView.this.getPaddingBottom()) - ExtendableListView.this.getPaddingTop()) - 1), i);
                    }
                    boolean moveTheChildren = ExtendableListView.this.moveTheChildren(max, max);
                    if (computeScrollOffset && !moveTheChildren) {
                        ExtendableListView.this.invalidate();
                        this.mLastFlingY = currY;
                        ExtendableListView.this.postOnAnimate(this);
                        return;
                    }
                    endFling();
                    return;
                }
                endFling();
            }
        }

        void start(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-219764241")) {
                ipChange.ipc$dispatch("-219764241", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.mLastFlingY = i2;
            this.mScroller.forceFinished(true);
            this.mScroller.fling(0, i2, 0, i, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            ExtendableListView.this.mTouchMode = 2;
            ExtendableListView.this.postOnAnimate(this);
        }

        void startScroll(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "173341927")) {
                ipChange.ipc$dispatch("173341927", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.mLastFlingY = i3;
            this.mScroller.startScroll(0, i3, 0, i, i2);
            ExtendableListView.this.mTouchMode = 2;
            ExtendableListView.this.postOnAnimate(this);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class ListSavedState extends ClassLoaderSavedState {
        private static transient /* synthetic */ IpChange $ipChange;
        public static final Parcelable.Creator<ListSavedState> CREATOR = new a();
        protected long firstId;
        protected int height;
        protected int position;
        protected long selectedId;
        protected int viewTop;

        /* compiled from: Taobao */
        /* loaded from: classes.dex */
        public static final class a implements Parcelable.Creator<ListSavedState> {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public ListSavedState createFromParcel(Parcel parcel) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "667312779") ? (ListSavedState) ipChange.ipc$dispatch("667312779", new Object[]{this, parcel}) : new ListSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public ListSavedState[] newArray(int i) {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1931159834") ? (ListSavedState[]) ipChange.ipc$dispatch("1931159834", new Object[]{this, Integer.valueOf(i)}) : new ListSavedState[i];
            }
        }

        public ListSavedState(Parcelable parcelable) {
            super(parcelable, AbsListView.class.getClassLoader());
        }

        public String toString() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2047547699")) {
                return (String) ipChange.ipc$dispatch("-2047547699", new Object[]{this});
            }
            return "ExtendableListView.ListSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " firstId=" + this.firstId + " viewTop=" + this.viewTop + " position=" + this.position + " height=" + this.height + "}";
        }

        @Override // cn.damai.baseview.grid.ClassLoaderSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1918851202")) {
                ipChange.ipc$dispatch("-1918851202", new Object[]{this, parcel, Integer.valueOf(i)});
                return;
            }
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.selectedId);
            parcel.writeLong(this.firstId);
            parcel.writeInt(this.viewTop);
            parcel.writeInt(this.position);
            parcel.writeInt(this.height);
        }

        public ListSavedState(Parcel parcel) {
            super(parcel);
            this.selectedId = parcel.readLong();
            this.firstId = parcel.readLong();
            this.viewTop = parcel.readInt();
            this.position = parcel.readInt();
            this.height = parcel.readInt();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class PerformClick extends e implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        int mClickMotionPosition;

        private PerformClick() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            View childAt;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "49626209")) {
                ipChange.ipc$dispatch("49626209", new Object[]{this});
            } else if (ExtendableListView.this.mDataChanged) {
            } else {
                ExtendableListView extendableListView = ExtendableListView.this;
                ListAdapter listAdapter = extendableListView.mAdapter;
                int i = this.mClickMotionPosition;
                if (listAdapter == null || extendableListView.mItemCount <= 0 || i == -1 || i >= listAdapter.getCount() || !sameWindow() || (childAt = ExtendableListView.this.getChildAt(i)) == null) {
                    return;
                }
                ExtendableListView extendableListView2 = ExtendableListView.this;
                extendableListView2.performItemClick(childAt, extendableListView2.mFirstPosition + i, listAdapter.getItemId(i));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        private static transient /* synthetic */ IpChange $ipChange;
        private Parcelable a = null;

        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-982363457")) {
                ipChange.ipc$dispatch("-982363457", new Object[]{this});
                return;
            }
            ExtendableListView.this.mDataChanged = true;
            ExtendableListView extendableListView = ExtendableListView.this;
            extendableListView.mOldItemCount = extendableListView.mItemCount;
            ExtendableListView extendableListView2 = ExtendableListView.this;
            extendableListView2.mItemCount = extendableListView2.getAdapter().getCount();
            ExtendableListView.this.mRecycleBin.c();
            if (ExtendableListView.this.getAdapter().hasStableIds() && this.a != null && ExtendableListView.this.mOldItemCount == 0 && ExtendableListView.this.mItemCount > 0) {
                ExtendableListView.this.onRestoreInstanceState(this.a);
                this.a = null;
            } else {
                ExtendableListView.this.rememberSyncState();
            }
            ExtendableListView.this.updateEmptyStatus();
            ExtendableListView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1653062710")) {
                ipChange.ipc$dispatch("-1653062710", new Object[]{this});
                return;
            }
            ExtendableListView.this.mDataChanged = true;
            if (ExtendableListView.this.getAdapter().hasStableIds()) {
                this.a = ExtendableListView.this.onSaveInstanceState();
            }
            ExtendableListView extendableListView = ExtendableListView.this;
            extendableListView.mOldItemCount = extendableListView.mItemCount;
            ExtendableListView.this.mItemCount = 0;
            ExtendableListView extendableListView2 = ExtendableListView.this;
            extendableListView2.mNeedSync = false;
            extendableListView2.updateEmptyStatus();
            ExtendableListView.this.requestLayout();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class c {
        public View a;
        public Object b;
        public boolean c;

        public c(ExtendableListView extendableListView) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class d {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;
        private View[] b = new View[0];
        private ArrayList<View>[] c;
        private int d;
        private ArrayList<View> e;
        private ArrayList<View> f;
        private SparseArrayCompat<View> g;

        d() {
        }

        private void h() {
            IpChange ipChange = $ipChange;
            int i = 0;
            if (AndroidInstantRuntime.support(ipChange, "1547683416")) {
                ipChange.ipc$dispatch("1547683416", new Object[]{this});
                return;
            }
            int length = this.b.length;
            int i2 = this.d;
            ArrayList<View>[] arrayListArr = this.c;
            for (int i3 = 0; i3 < i2; i3++) {
                ArrayList<View> arrayList = arrayListArr[i3];
                int size = arrayList.size();
                int i4 = size - length;
                int i5 = size - 1;
                int i6 = 0;
                while (i6 < i4) {
                    ExtendableListView.this.removeDetachedView(arrayList.remove(i5), false);
                    i6++;
                    i5--;
                }
            }
            if (this.g != null) {
                while (i < this.g.size()) {
                    if (!ViewCompat.hasTransientState(this.g.valueAt(i))) {
                        this.g.removeAt(i);
                        i--;
                    }
                    i++;
                }
            }
        }

        void a(View view, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-540884505")) {
                ipChange.ipc$dispatch("-540884505", new Object[]{this, view, Integer.valueOf(i)});
                return;
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.position = i;
            int i2 = layoutParams.viewType;
            boolean hasTransientState = ViewCompat.hasTransientState(view);
            if (l(i2) && !hasTransientState) {
                if (this.d == 1) {
                    this.e.add(view);
                    return;
                } else {
                    this.c[i2].add(view);
                    return;
                }
            }
            if (i2 != -2 || hasTransientState) {
                if (this.f == null) {
                    this.f = new ArrayList<>();
                }
                this.f.add(view);
            }
            if (hasTransientState) {
                if (this.g == null) {
                    this.g = new SparseArrayCompat<>();
                }
                this.g.put(i, view);
            }
        }

        void b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-508381390")) {
                ipChange.ipc$dispatch("-508381390", new Object[]{this});
                return;
            }
            int i = this.d;
            if (i == 1) {
                ArrayList<View> arrayList = this.e;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ExtendableListView.this.removeDetachedView(arrayList.remove((size - 1) - i2), false);
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    ArrayList<View> arrayList2 = this.c[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ExtendableListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            SparseArrayCompat<View> sparseArrayCompat = this.g;
            if (sparseArrayCompat != null) {
                sparseArrayCompat.clear();
            }
        }

        void c() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1840530223")) {
                ipChange.ipc$dispatch("-1840530223", new Object[]{this});
                return;
            }
            SparseArrayCompat<View> sparseArrayCompat = this.g;
            if (sparseArrayCompat != null) {
                sparseArrayCompat.clear();
            }
        }

        void d(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "935521882")) {
                ipChange.ipc$dispatch("935521882", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
                return;
            }
            if (this.b.length < i) {
                this.b = new View[i];
            }
            this.a = i2;
            View[] viewArr = this.b;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = ExtendableListView.this.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.viewType != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        View e(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1750929529")) {
                return (View) ipChange.ipc$dispatch("-1750929529", new Object[]{this, Integer.valueOf(i)});
            }
            int i2 = i - this.a;
            View[] viewArr = this.b;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View f(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1648971514")) {
                return (View) ipChange.ipc$dispatch("1648971514", new Object[]{this, Integer.valueOf(i)});
            }
            if (this.d == 1) {
                return ExtendableListView.retrieveFromScrap(this.e, i);
            }
            int itemViewType = ExtendableListView.this.mAdapter.getItemViewType(i);
            if (itemViewType >= 0) {
                ArrayList<View>[] arrayListArr = this.c;
                if (itemViewType < arrayListArr.length) {
                    return ExtendableListView.retrieveFromScrap(arrayListArr[itemViewType], i);
                }
                return null;
            }
            return null;
        }

        public void g() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-88009575")) {
                ipChange.ipc$dispatch("-88009575", new Object[]{this});
                return;
            }
            int i = this.d;
            if (i == 1) {
                ArrayList<View> arrayList = this.e;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).forceLayout();
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    ArrayList<View> arrayList2 = this.c[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            SparseArrayCompat<View> sparseArrayCompat = this.g;
            if (sparseArrayCompat != null) {
                int size3 = sparseArrayCompat.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    this.g.valueAt(i5).forceLayout();
                }
            }
        }

        void i() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "13097798")) {
                ipChange.ipc$dispatch("13097798", new Object[]{this});
                return;
            }
            ArrayList<View> arrayList = this.f;
            if (arrayList == null) {
                return;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ExtendableListView.this.removeDetachedView(this.f.get(i), false);
            }
            this.f.clear();
        }

        void j() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-999996876")) {
                ipChange.ipc$dispatch("-999996876", new Object[]{this});
                return;
            }
            View[] viewArr = this.b;
            boolean z = this.d > 1;
            ArrayList<View> arrayList = this.e;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    viewArr[length] = null;
                    boolean hasTransientState = ViewCompat.hasTransientState(view);
                    int i = layoutParams.viewType;
                    if (!l(i) || hasTransientState) {
                        if (i != -2 || hasTransientState) {
                            ExtendableListView.this.removeDetachedView(view, false);
                        }
                        if (hasTransientState) {
                            if (this.g == null) {
                                this.g = new SparseArrayCompat<>();
                            }
                            this.g.put(this.a + length, view);
                        }
                    } else {
                        if (z) {
                            arrayList = this.c[i];
                        }
                        layoutParams.position = this.a + length;
                        arrayList.add(view);
                    }
                }
            }
            h();
        }

        public void k(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1833396454")) {
                ipChange.ipc$dispatch("1833396454", new Object[]{this, Integer.valueOf(i)});
            } else if (i >= 1) {
                ArrayList<View>[] arrayListArr = new ArrayList[i];
                for (int i2 = 0; i2 < i; i2++) {
                    arrayListArr[i2] = new ArrayList<>();
                }
                this.d = i;
                this.e = arrayListArr[0];
                this.c = arrayListArr;
            } else {
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
        }

        public boolean l(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "381252551") ? ((Boolean) ipChange.ipc$dispatch("381252551", new Object[]{this, Integer.valueOf(i)})).booleanValue() : i >= 0;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class e {
        private static transient /* synthetic */ IpChange $ipChange;
        private int mOriginalAttachCount;

        private e() {
        }

        public void rememberWindowAttachCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-225954003")) {
                ipChange.ipc$dispatch("-225954003", new Object[]{this});
            } else {
                this.mOriginalAttachCount = ExtendableListView.this.getWindowAttachCount();
            }
        }

        public boolean sameWindow() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1334168286") ? ((Boolean) ipChange.ipc$dispatch("1334168286", new Object[]{this})).booleanValue() : ExtendableListView.this.hasWindowFocus() && ExtendableListView.this.getWindowAttachCount() == this.mOriginalAttachCount;
        }
    }

    public ExtendableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScrollState = 0;
        this.mVelocityTracker = null;
        this.mActivePointerId = -1;
        this.mBlockLayoutRequests = false;
        this.mIsScrap = new boolean[1];
        this.mSyncRowId = Long.MIN_VALUE;
        this.mNeedSync = false;
        setWillNotDraw(false);
        setClipToPadding(false);
        setFocusableInTouchMode(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mRecycleBin = new d();
        this.mObserver = new b();
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        this.mLayoutMode = 0;
    }

    private void adjustViewsUpOrDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-928895252")) {
            ipChange.ipc$dispatch("-928895252", new Object[]{this});
        } else if (getChildCount() > 0) {
            int highestChildTop = getHighestChildTop() - getListPaddingTop();
            int i = highestChildTop >= 0 ? highestChildTop : 0;
            if (i != 0) {
                offsetChildrenTopAndBottom(-i);
            }
        }
    }

    private void clearRecycledState(ArrayList<c> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1207638114")) {
            ipChange.ipc$dispatch("-1207638114", new Object[]{this, arrayList});
        } else if (arrayList == null) {
        } else {
            Iterator<c> it = arrayList.iterator();
            while (it.hasNext()) {
                LayoutParams layoutParams = (LayoutParams) it.next().a.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.recycledHeaderFooter = false;
                }
            }
        }
    }

    private void clearState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "899007803")) {
            ipChange.ipc$dispatch("899007803", new Object[]{this});
            return;
        }
        clearRecycledState(this.mHeaderViewInfos);
        clearRecycledState(this.mFooterViewInfos);
        removeAllViewsInLayout();
        this.mFirstPosition = 0;
        this.mDataChanged = false;
        this.mRecycleBin.b();
        this.mNeedSync = false;
        this.mSyncState = null;
        this.mLayoutMode = 0;
        invalidate();
    }

    private void correctTooHigh(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "720637232")) {
            ipChange.ipc$dispatch("720637232", new Object[]{this, Integer.valueOf(i)});
        } else if ((this.mFirstPosition + i) - 1 != this.mItemCount - 1 || i <= 0) {
        } else {
            int bottom = ((getBottom() - getTop()) - getListPaddingBottom()) - getLowestChildBottom();
            int highestChildTop = getHighestChildTop();
            if (bottom > 0) {
                if (this.mFirstPosition > 0 || highestChildTop < getListPaddingTop()) {
                    if (this.mFirstPosition == 0) {
                        bottom = Math.min(bottom, getListPaddingTop() - highestChildTop);
                    }
                    offsetChildrenTopAndBottom(bottom);
                    int i2 = this.mFirstPosition;
                    if (i2 > 0) {
                        int i3 = i2 - 1;
                        fillUp(i3, getNextChildUpsBottom(i3));
                        adjustViewsUpOrDown();
                    }
                }
            }
        }
    }

    private void correctTooLow(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2095368482")) {
            ipChange.ipc$dispatch("2095368482", new Object[]{this, Integer.valueOf(i)});
        } else if (this.mFirstPosition != 0 || i <= 0) {
        } else {
            int highestChildTop = getHighestChildTop();
            int listPaddingTop = getListPaddingTop();
            int top = (getTop() - getBottom()) - getListPaddingBottom();
            int i2 = highestChildTop - listPaddingTop;
            int lowestChildBottom = getLowestChildBottom();
            int i3 = (this.mFirstPosition + i) - 1;
            if (i2 > 0) {
                int i4 = this.mItemCount;
                if (i3 >= i4 - 1 && lowestChildBottom <= top) {
                    if (i3 == i4 - 1) {
                        adjustViewsUpOrDown();
                        return;
                    }
                    return;
                }
                if (i3 == i4 - 1) {
                    i2 = Math.min(i2, lowestChildBottom - top);
                }
                offsetChildrenTopAndBottom(-i2);
                if (i3 < this.mItemCount - 1) {
                    int i5 = i3 + 1;
                    fillDown(i5, getNextChildDownsTop(i5));
                    adjustViewsUpOrDown();
                }
            }
        }
    }

    private View fillDown(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-546863812")) {
            return (View) ipChange.ipc$dispatch("-546863812", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        int height = getHeight();
        if (this.mClipToPadding) {
            height -= getListPaddingBottom();
        }
        while (true) {
            if ((i2 < height || hasSpaceDown()) && i < this.mItemCount) {
                makeAndAddView(i, i2, true, false);
                i++;
                i2 = getNextChildDownsTop(i);
            }
        }
        return null;
    }

    private View fillFromTop(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1786382142")) {
            return (View) ipChange.ipc$dispatch("-1786382142", new Object[]{this, Integer.valueOf(i)});
        }
        int min = Math.min(this.mFirstPosition, this.mItemCount - 1);
        this.mFirstPosition = min;
        if (min < 0) {
            this.mFirstPosition = 0;
        }
        return fillDown(this.mFirstPosition, i);
    }

    private View fillSpecific(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1629618988")) {
            return (View) ipChange.ipc$dispatch("1629618988", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        makeAndAddView(i, i2, true, false);
        this.mFirstPosition = i;
        int i3 = i - 1;
        int nextChildUpsBottom = getNextChildUpsBottom(i3);
        int i4 = i + 1;
        int nextChildDownsTop = getNextChildDownsTop(i4);
        View fillUp = fillUp(i3, nextChildUpsBottom);
        adjustViewsUpOrDown();
        View fillDown = fillDown(i4, nextChildDownsTop);
        int childCount = getChildCount();
        if (childCount > 0) {
            correctTooHigh(childCount);
        }
        return fillUp != null ? fillUp : fillDown;
    }

    private View fillUp(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1709381405")) {
            return (View) ipChange.ipc$dispatch("-1709381405", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        int listPaddingTop = this.mClipToPadding ? getListPaddingTop() : 0;
        while (true) {
            if ((i2 > listPaddingTop || hasSpaceUp()) && i >= 0) {
                makeAndAddView(i, i2, false, false);
                i--;
                i2 = getNextChildUpsBottom(i);
            }
        }
        this.mFirstPosition = i + 1;
        return null;
    }

    private int findMotionRow(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1132339894")) {
            return ((Integer) ipChange.ipc$dispatch("1132339894", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i <= getChildAt(i2).getBottom()) {
                    return this.mFirstPosition + i2;
                }
            }
            return -1;
        }
        return -1;
    }

    private void initOrResetVelocityTracker() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2083676064")) {
            ipChange.ipc$dispatch("2083676064", new Object[]{this});
            return;
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1915362456")) {
            ipChange.ipc$dispatch("1915362456", new Object[]{this});
        } else if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private View makeAndAddView(int i, int i2, boolean z, boolean z2) {
        View e2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-446241820")) {
            return (View) ipChange.ipc$dispatch("-446241820", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
        onChildCreated(i, z);
        if (!this.mDataChanged && (e2 = this.mRecycleBin.e(i)) != null) {
            setupChild(e2, i, i2, z, z2, true);
            return e2;
        }
        View obtainView = obtainView(i, this.mIsScrap);
        setupChild(obtainView, i, i2, z, z2, this.mIsScrap[0]);
        return obtainView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean moveTheChildren(int i, int i2) {
        int i3;
        int i4;
        int min;
        int i5;
        int i6;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "125244208")) {
            return ((Boolean) ipChange.ipc$dispatch("125244208", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
        }
        if (hasChildren()) {
            int highestChildTop = getHighestChildTop();
            int lowestChildBottom = getLowestChildBottom();
            if (this.mClipToPadding) {
                i3 = getListPaddingTop();
                i4 = getListPaddingBottom();
            } else {
                i3 = 0;
                i4 = 0;
            }
            int height = getHeight();
            int firstChildTop = i3 - getFirstChildTop();
            int lastChildBottom = getLastChildBottom() - (height - i4);
            int listPaddingBottom = (height - getListPaddingBottom()) - getListPaddingTop();
            if (i2 < 0) {
                min = Math.max(-(listPaddingBottom - 1), i2);
            } else {
                min = Math.min(listPaddingBottom - 1, i2);
            }
            int i7 = this.mFirstPosition;
            int listPaddingTop = getListPaddingTop();
            int listPaddingBottom2 = height - getListPaddingBottom();
            int childCount = getChildCount();
            boolean z = i7 == 0 && highestChildTop >= listPaddingTop && min >= 0;
            boolean z2 = i7 + childCount == this.mItemCount && lowestChildBottom <= listPaddingBottom2 && min <= 0;
            if (z) {
                return min != 0;
            } else if (z2) {
                return min != 0;
            } else {
                boolean z3 = min < 0;
                int headerViewsCount = getHeaderViewsCount();
                int footerViewsCount = this.mItemCount - getFooterViewsCount();
                if (z3) {
                    int i8 = -min;
                    if (this.mClipToPadding) {
                        i8 += getListPaddingTop();
                    }
                    i6 = 0;
                    for (int i9 = 0; i9 < childCount; i9++) {
                        View childAt = getChildAt(i9);
                        if (childAt.getBottom() >= i8) {
                            break;
                        }
                        i6++;
                        int i10 = i7 + i9;
                        if (i10 >= headerViewsCount && i10 < footerViewsCount) {
                            this.mRecycleBin.a(childAt, i10);
                        }
                    }
                    i5 = 0;
                } else {
                    int i11 = height - min;
                    if (this.mClipToPadding) {
                        i11 -= getListPaddingBottom();
                    }
                    int i12 = childCount - 1;
                    i5 = 0;
                    i6 = 0;
                    while (i12 >= 0) {
                        View childAt2 = getChildAt(i12);
                        if (childAt2.getTop() <= i11) {
                            break;
                        }
                        i6++;
                        int i13 = i7 + i12;
                        if (i13 >= headerViewsCount && i13 < footerViewsCount) {
                            this.mRecycleBin.a(childAt2, i13);
                        }
                        int i14 = i12;
                        i12--;
                        i5 = i14;
                    }
                }
                this.mBlockLayoutRequests = true;
                if (i6 > 0) {
                    detachViewsFromParent(i5, i6);
                    this.mRecycleBin.i();
                    onChildrenDetached(i5, i6);
                }
                if (!awakenScrollBars()) {
                    invalidate();
                }
                offsetChildrenTopAndBottom(min);
                if (z3) {
                    this.mFirstPosition += i6;
                }
                int abs = Math.abs(min);
                if (firstChildTop < abs || lastChildBottom < abs) {
                    fillGap(z3);
                }
                this.mBlockLayoutRequests = false;
                invokeOnItemScrollListener();
                return false;
            }
        }
        return true;
    }

    private View obtainView(int i, boolean[] zArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1524098257")) {
            return (View) ipChange.ipc$dispatch("-1524098257", new Object[]{this, Integer.valueOf(i), zArr});
        }
        zArr[0] = false;
        View f = this.mRecycleBin.f(i);
        if (f != null) {
            View view = this.mAdapter.getView(i, f, this);
            if (view != f) {
                this.mRecycleBin.a(f, i);
                return view;
            }
            zArr[0] = true;
            return view;
        }
        return this.mAdapter.getView(i, null, this);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1236764369")) {
            ipChange.ipc$dispatch("1236764369", new Object[]{this, motionEvent});
            return;
        }
        int action = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            int i = action != 0 ? 0 : 1;
            this.mMotionX = (int) motionEvent.getX(i);
            this.mMotionY = (int) motionEvent.getY(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
            recycleVelocityTracker();
        }
    }

    private boolean onTouchCancel(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-347429366")) {
            return ((Boolean) ipChange.ipc$dispatch("-347429366", new Object[]{this, motionEvent})).booleanValue();
        }
        this.mTouchMode = 0;
        setPressed(false);
        invalidate();
        recycleVelocityTracker();
        this.mActivePointerId = -1;
        return true;
    }

    private boolean onTouchDown(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "238487138")) {
            return ((Boolean) ipChange.ipc$dispatch("238487138", new Object[]{this, motionEvent})).booleanValue();
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int pointToPosition = pointToPosition(x, y);
        this.mVelocityTracker.clear();
        this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, 0);
        if (this.mTouchMode != 2 && !this.mDataChanged && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
            this.mTouchMode = 3;
            if (motionEvent.getEdgeFlags() != 0 && pointToPosition < 0) {
                return false;
            }
        } else if (this.mTouchMode == 2) {
            this.mTouchMode = 1;
            this.mMotionCorrection = 0;
            pointToPosition = findMotionRow(y);
        }
        this.mMotionX = x;
        this.mMotionY = y;
        this.mMotionPosition = pointToPosition;
        this.mLastY = Integer.MIN_VALUE;
        return true;
    }

    private boolean onTouchMove(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1607586195")) {
            return ((Boolean) ipChange.ipc$dispatch("1607586195", new Object[]{this, motionEvent})).booleanValue();
        }
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
        if (findPointerIndex < 0) {
            pw2.b(TAG, "onTouchMove could not find pointer with id " + this.mActivePointerId + " - did ExtendableListView receive an inconsistent event stream?");
            return false;
        }
        int y = (int) MotionEventCompat.getY(motionEvent, findPointerIndex);
        if (this.mDataChanged) {
            layoutChildren();
        }
        int i = this.mTouchMode;
        if (i == 1) {
            scrollIfNeeded(y);
        } else if (i == 3 || i == 4 || i == 5) {
            startScrollIfNeeded(y);
        }
        return true;
    }

    private boolean onTouchPointerUp(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-620768800")) {
            return ((Boolean) ipChange.ipc$dispatch("-620768800", new Object[]{this, motionEvent})).booleanValue();
        }
        onSecondaryPointerUp(motionEvent);
        int i = this.mMotionX;
        int i2 = this.mMotionY;
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition >= 0) {
            this.mMotionPosition = pointToPosition;
        }
        this.mLastY = i2;
        return true;
    }

    private boolean onTouchUp(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-474230647")) {
            return ((Boolean) ipChange.ipc$dispatch("-474230647", new Object[]{this, motionEvent})).booleanValue();
        }
        int i = this.mTouchMode;
        if (i != 1) {
            if (i != 3 && i != 4 && i != 5) {
                setPressed(false);
                invalidate();
                recycleVelocityTracker();
                this.mActivePointerId = -1;
                return true;
            }
            return onTouchUpTap(motionEvent);
        }
        return onTouchUpScrolling(motionEvent);
    }

    private boolean onTouchUpScrolling(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-257046850")) {
            return ((Boolean) ipChange.ipc$dispatch("-257046850", new Object[]{this, motionEvent})).booleanValue();
        }
        if (hasChildren()) {
            if (!(this.mFirstPosition == 0 && getFirstChildTop() >= getListPaddingTop() && this.mFirstPosition + getChildCount() < this.mItemCount && getLastChildBottom() <= getHeight() - getListPaddingBottom())) {
                this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                if (Math.abs(yVelocity) > this.mFlingVelocity) {
                    startFlingRunnable(yVelocity);
                    this.mTouchMode = 2;
                    this.mMotionY = 0;
                    invalidate();
                    return true;
                }
            }
        }
        stopFlingRunnable();
        recycleVelocityTracker();
        this.mTouchMode = 0;
        return true;
    }

    private boolean onTouchUpTap(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "186124176")) {
            return ((Boolean) ipChange.ipc$dispatch("186124176", new Object[]{this, motionEvent})).booleanValue();
        }
        if (this.mPerformClick == null) {
            invalidate();
            this.mPerformClick = new PerformClick();
        }
        int i = this.mMotionPosition;
        if (!this.mDataChanged && i >= 0 && this.mAdapter.isEnabled(i)) {
            PerformClick performClick = this.mPerformClick;
            performClick.mClickMotionPosition = i;
            performClick.rememberWindowAttachCount();
            performClick.run();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postOnAnimate(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-278921689")) {
            ipChange.ipc$dispatch("-278921689", new Object[]{this, runnable});
        } else {
            ViewCompat.postOnAnimation(this, runnable);
        }
    }

    private void recycleVelocityTracker() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1703647607")) {
            ipChange.ipc$dispatch("1703647607", new Object[]{this});
            return;
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void removeFixedViewInfo(View view, ArrayList<c> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-728464640")) {
            ipChange.ipc$dispatch("-728464640", new Object[]{this, view, arrayList});
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).a == view) {
                arrayList.remove(i);
                return;
            }
        }
    }

    static View retrieveFromScrap(ArrayList<View> arrayList, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2054201605")) {
            return (View) ipChange.ipc$dispatch("-2054201605", new Object[]{arrayList, Integer.valueOf(i)});
        }
        int size = arrayList.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                View view = arrayList.get(i2);
                if (((LayoutParams) view.getLayoutParams()).position == i) {
                    arrayList.remove(i2);
                    return view;
                }
            }
            return arrayList.remove(size - 1);
        }
        return null;
    }

    private void scrollIfNeeded(int i) {
        int childCount;
        ViewParent parent;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-877657213")) {
            ipChange.ipc$dispatch("-877657213", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int i2 = i - this.mMotionY;
        int i3 = i2 - this.mMotionCorrection;
        int i4 = this.mLastY;
        int i5 = i4 != Integer.MIN_VALUE ? i - i4 : i3;
        if (this.mTouchMode != 1 || i == i4) {
            return;
        }
        if (Math.abs(i2) > this.mTouchSlop && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        int i6 = this.mMotionPosition;
        if (i6 >= 0) {
            childCount = i6 - this.mFirstPosition;
        } else {
            childCount = getChildCount() / 2;
        }
        if (i5 != 0) {
            moveTheChildren(i3, i5);
        }
        if (getChildAt(childCount) != null) {
            this.mMotionY = i;
        }
        this.mLastY = i;
    }

    private void setupChild(View view, int i, int i2, boolean z, boolean z2, boolean z3) {
        LayoutParams generateChildLayoutParams;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1042743138")) {
            ipChange.ipc$dispatch("1042743138", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)});
            return;
        }
        boolean isSelected = view.isSelected();
        int i3 = this.mTouchMode;
        boolean z4 = i3 > 3 && i3 < 1 && this.mMotionPosition == i;
        boolean z5 = z4 != view.isPressed();
        boolean z6 = !z3 || isSelected || view.isLayoutRequested();
        int itemViewType = this.mAdapter.getItemViewType(i);
        if (itemViewType == -2) {
            generateChildLayoutParams = generateWrapperLayoutParams(view);
        } else {
            generateChildLayoutParams = generateChildLayoutParams(view);
        }
        generateChildLayoutParams.viewType = itemViewType;
        generateChildLayoutParams.position = i;
        if (!z3 && (!generateChildLayoutParams.recycledHeaderFooter || itemViewType != -2)) {
            if (itemViewType == -2) {
                generateChildLayoutParams.recycledHeaderFooter = true;
            }
            addViewInLayout(view, z ? -1 : 0, generateChildLayoutParams, true);
        } else {
            attachViewToParent(view, z ? -1 : 0, generateChildLayoutParams);
        }
        if (isSelected) {
            view.setSelected(false);
        }
        if (z5) {
            view.setPressed(z4);
        }
        if (z6) {
            onMeasureChild(view, generateChildLayoutParams);
        } else {
            cleanupLayoutState(view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = z ? i2 : i2 - measuredHeight;
        int childLeft = getChildLeft(i);
        if (z6) {
            onLayoutChild(view, i, z, childLeft, i4, childLeft + measuredWidth, i4 + measuredHeight);
        } else {
            onOffsetChild(view, i, z, childLeft, i4);
        }
    }

    private void startFlingRunnable(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "474722168")) {
            ipChange.ipc$dispatch("474722168", new Object[]{this, Float.valueOf(f)});
            return;
        }
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new FlingRunnable();
        }
        this.mFlingRunnable.start((int) (-f));
    }

    private boolean startScrollIfNeeded(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-551464483")) {
            return ((Boolean) ipChange.ipc$dispatch("-551464483", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        int i2 = i - this.mMotionY;
        int abs = Math.abs(i2);
        int i3 = this.mTouchSlop;
        if (abs > i3) {
            this.mTouchMode = 1;
            if (i2 <= 0) {
                i3 = -i3;
            }
            this.mMotionCorrection = i3;
            setPressed(false);
            View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            scrollIfNeeded(i);
            return true;
        }
        return false;
    }

    private void stopFlingRunnable() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1358400876")) {
            ipChange.ipc$dispatch("-1358400876", new Object[]{this});
            return;
        }
        FlingRunnable flingRunnable = this.mFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.endFling();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"WrongCall"})
    public void updateEmptyStatus() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1157401301")) {
            ipChange.ipc$dispatch("1157401301", new Object[]{this});
            return;
        }
        if (getAdapter() != null && !getAdapter().isEmpty()) {
            z = false;
        }
        if (isInFilterMode()) {
            z = false;
        }
        View emptyView = getEmptyView();
        if (z) {
            if (emptyView != null) {
                emptyView.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.mDataChanged) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        if (emptyView != null) {
            emptyView.setVisibility(8);
        }
        setVisibility(0);
    }

    public void addFooterView(View view, Object obj, boolean z) {
        b bVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1819057040")) {
            ipChange.ipc$dispatch("1819057040", new Object[]{this, view, obj, Boolean.valueOf(z)});
            return;
        }
        c cVar = new c(this);
        cVar.a = view;
        cVar.b = obj;
        cVar.c = z;
        this.mFooterViewInfos.add(cVar);
        if (this.mAdapter == null || (bVar = this.mObserver) == null) {
            return;
        }
        bVar.onChanged();
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        b bVar;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-323891234")) {
            ipChange.ipc$dispatch("-323891234", new Object[]{this, view, obj, Boolean.valueOf(z)});
            return;
        }
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && !(listAdapter instanceof HeaderViewListAdapter)) {
            throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
        }
        c cVar = new c(this);
        cVar.a = view;
        cVar.b = obj;
        cVar.c = z;
        this.mHeaderViewInfos.add(cVar);
        if (this.mAdapter == null || (bVar = this.mObserver) == null) {
            return;
        }
        bVar.onChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adjustViewsAfterFillGap(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1388471649")) {
            ipChange.ipc$dispatch("-1388471649", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            correctTooHigh(getChildCount());
        } else {
            correctTooLow(getChildCount());
        }
    }

    protected void fillGap(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1568920540")) {
            ipChange.ipc$dispatch("1568920540", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        int childCount = getChildCount();
        if (z) {
            int i = this.mFirstPosition + childCount;
            fillDown(i, getChildTop(i));
        } else {
            int i2 = this.mFirstPosition - 1;
            fillUp(i2, getChildBottom(i2));
        }
        adjustViewsAfterFillGap(z);
    }

    protected LayoutParams generateChildLayoutParams(View view) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-248019307") ? (LayoutParams) ipChange.ipc$dispatch("-248019307", new Object[]{this, view}) : generateWrapperLayoutParams(view);
    }

    protected LayoutParams generateHeaderFooterLayoutParams(View view) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1075661517") ? (LayoutParams) ipChange.ipc$dispatch("-1075661517", new Object[]{this, view}) : new LayoutParams(-1, -2, 0);
    }

    protected LayoutParams generateWrapperLayoutParams(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "194444350")) {
            return (LayoutParams) ipChange.ipc$dispatch("194444350", new Object[]{this, view});
        }
        LayoutParams layoutParams = null;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            if (layoutParams2 instanceof LayoutParams) {
                layoutParams = (LayoutParams) layoutParams2;
            } else {
                layoutParams = new LayoutParams(layoutParams2);
            }
        }
        return layoutParams == null ? generateDefaultLayoutParams() : layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getChildBottom(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-444972408")) {
            return ((Integer) ipChange.ipc$dispatch("-444972408", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        return getChildCount() > 0 ? getChildAt(0).getTop() : getHeight() - (this.mClipToPadding ? getListPaddingBottom() : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getChildLeft(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-440288924") ? ((Integer) ipChange.ipc$dispatch("-440288924", new Object[]{this, Integer.valueOf(i)})).intValue() : getListPaddingLeft();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getChildTop(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1349361990")) {
            return ((Integer) ipChange.ipc$dispatch("-1349361990", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int childCount = getChildCount();
        return childCount > 0 ? getChildAt(childCount - 1).getBottom() : this.mClipToPadding ? getListPaddingTop() : 0;
    }

    @Override // android.widget.AdapterView
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2039096711") ? ((Integer) ipChange.ipc$dispatch("-2039096711", new Object[]{this})).intValue() : this.mItemCount;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getFirstChildTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1775263777")) {
            return ((Integer) ipChange.ipc$dispatch("-1775263777", new Object[]{this})).intValue();
        }
        if (hasChildren()) {
            return getChildAt(0).getTop();
        }
        return 0;
    }

    @Override // android.widget.AdapterView
    public int getFirstVisiblePosition() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-508266979") ? ((Integer) ipChange.ipc$dispatch("-508266979", new Object[]{this})).intValue() : Math.max(0, this.mFirstPosition - getHeaderViewsCount());
    }

    public int getFooterViewsCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-991237076") ? ((Integer) ipChange.ipc$dispatch("-991237076", new Object[]{this})).intValue() : this.mFooterViewInfos.size();
    }

    public int getHeaderViewsCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "807721082") ? ((Integer) ipChange.ipc$dispatch("807721082", new Object[]{this})).intValue() : this.mHeaderViewInfos.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getHighestChildTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-489348757")) {
            return ((Integer) ipChange.ipc$dispatch("-489348757", new Object[]{this})).intValue();
        }
        if (hasChildren()) {
            return getChildAt(0).getTop();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLastChildBottom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-756820393")) {
            return ((Integer) ipChange.ipc$dispatch("-756820393", new Object[]{this})).intValue();
        }
        if (hasChildren()) {
            return getChildAt(getChildCount() - 1).getBottom();
        }
        return 0;
    }

    @Override // android.widget.AdapterView
    public int getLastVisiblePosition() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1343387011") ? ((Integer) ipChange.ipc$dispatch("1343387011", new Object[]{this})).intValue() : Math.min((this.mFirstPosition + getChildCount()) - 1, this.mAdapter.getCount() - 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getLowestChildBottom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306445709")) {
            return ((Integer) ipChange.ipc$dispatch("-1306445709", new Object[]{this})).intValue();
        }
        if (hasChildren()) {
            return getChildAt(getChildCount() - 1).getBottom();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNextChildDownsTop(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1603681874")) {
            return ((Integer) ipChange.ipc$dispatch("-1603681874", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int childCount = getChildCount();
        if (childCount > 0) {
            return getChildAt(childCount - 1).getBottom();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNextChildUpsBottom(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1331870405")) {
            return ((Integer) ipChange.ipc$dispatch("-1331870405", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        int childCount = getChildCount();
        if (childCount != 0 && childCount > 0) {
            return getChildAt(0).getTop();
        }
        return 0;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView
    public View getSelectedView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1261084137")) {
            return (View) ipChange.ipc$dispatch("-1261084137", new Object[]{this});
        }
        return null;
    }

    @Override // android.widget.AbsListView
    protected void handleDataChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1900525047")) {
            ipChange.ipc$dispatch("-1900525047", new Object[]{this});
            return;
        }
        super.handleDataChanged();
        int i = this.mItemCount;
        if (i > 0 && this.mNeedSync) {
            this.mNeedSync = false;
            this.mSyncState = null;
            this.mLayoutMode = 2;
            this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i - 1);
            return;
        }
        this.mLayoutMode = 1;
        this.mNeedSync = false;
        this.mSyncState = null;
    }

    protected boolean hasChildren() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "790832342") ? ((Boolean) ipChange.ipc$dispatch("790832342", new Object[]{this})).booleanValue() : getChildCount() > 0;
    }

    protected boolean hasSpaceDown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-151024779")) {
            return ((Boolean) ipChange.ipc$dispatch("-151024779", new Object[]{this})).booleanValue();
        }
        return false;
    }

    protected boolean hasSpaceUp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1503760988")) {
            return ((Boolean) ipChange.ipc$dispatch("1503760988", new Object[]{this})).booleanValue();
        }
        return false;
    }

    void invokeOnItemScrollListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "763443380")) {
            ipChange.ipc$dispatch("763443380", new Object[]{this});
            return;
        }
        AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(this, this.mFirstPosition, getChildCount(), this.mItemCount);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView
    public void layoutChildren() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "366258454")) {
            ipChange.ipc$dispatch("366258454", new Object[]{this});
        } else if (!this.mBlockLayoutRequests) {
            this.mBlockLayoutRequests = true;
            try {
                super.layoutChildren();
                invalidate();
                if (this.mAdapter == null) {
                    clearState();
                    return;
                }
                int listPaddingTop = getListPaddingTop();
                int childCount = getChildCount();
                View childAt = this.mLayoutMode == 0 ? getChildAt(0) : null;
                boolean z = this.mDataChanged;
                if (z) {
                    handleDataChanged();
                }
                int i = this.mItemCount;
                if (i == 0) {
                    clearState();
                } else if (i == this.mAdapter.getCount()) {
                    int i2 = this.mFirstPosition;
                    d dVar = this.mRecycleBin;
                    if (z) {
                        for (int i3 = 0; i3 < childCount; i3++) {
                            dVar.a(getChildAt(i3), i2 + i3);
                        }
                    } else {
                        dVar.d(childCount, i2);
                    }
                    detachAllViewsFromParent();
                    dVar.i();
                    int i4 = this.mLayoutMode;
                    if (i4 == 1) {
                        this.mFirstPosition = 0;
                        resetToTop();
                        adjustViewsUpOrDown();
                        fillFromTop(listPaddingTop);
                        adjustViewsUpOrDown();
                    } else if (i4 == 2) {
                        fillSpecific(this.mSyncPosition, this.mSpecificTop);
                    } else if (childCount == 0) {
                        fillFromTop(listPaddingTop);
                    } else {
                        int i5 = this.mFirstPosition;
                        if (i5 < this.mItemCount) {
                            if (childAt != null) {
                                listPaddingTop = childAt.getTop();
                            }
                            fillSpecific(i5, listPaddingTop);
                        } else {
                            fillSpecific(0, listPaddingTop);
                        }
                    }
                    dVar.j();
                    this.mDataChanged = false;
                    this.mNeedSync = false;
                    this.mLayoutMode = 0;
                } else {
                    throw new IllegalStateException("The content of the adapter has changed but ExtendableListView did not receive a notification. Make sure the content of your adapter is not modified from a background thread, but only from the UI thread. [in ExtendableListView(" + getId() + AVFSCacheConstants.COMMA_SEP + getClass() + ") with Adapter(" + this.mAdapter.getClass() + ")]");
                }
            } finally {
                this.mBlockLayoutRequests = false;
            }
        }
    }

    public void notifyTouchMode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1572111442")) {
            ipChange.ipc$dispatch("1572111442", new Object[]{this});
            return;
        }
        int i = this.mTouchMode;
        if (i == 0) {
            reportScrollStateChange(0);
        } else if (i == 1) {
            reportScrollStateChange(1);
        } else if (i != 2) {
        } else {
            reportScrollStateChange(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void offsetChildrenTopAndBottom(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-275698877")) {
            ipChange.ipc$dispatch("-275698877", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).offsetTopAndBottom(i);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-513190607")) {
            ipChange.ipc$dispatch("-513190607", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null) {
            this.mDataChanged = true;
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = listAdapter.getCount();
        }
        this.mIsAttached = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChildCreated(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "366970533")) {
            ipChange.ipc$dispatch("366970533", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onChildrenDetached(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "246504463")) {
            ipChange.ipc$dispatch("246504463", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-164486124")) {
            ipChange.ipc$dispatch("-164486124", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.mRecycleBin.b();
        FlingRunnable flingRunnable = this.mFlingRunnable;
        if (flingRunnable != null) {
            removeCallbacks(flingRunnable);
        }
        this.mIsAttached = false;
    }

    @Override // android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-359286106")) {
            ipChange.ipc$dispatch("-359286106", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), rect});
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-324766426")) {
            return ((Boolean) ipChange.ipc$dispatch("-324766426", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (this.mIsAttached) {
            int i = action & 255;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 6) {
                                onSecondaryPointerUp(motionEvent);
                            }
                        }
                    } else if (this.mTouchMode == 3) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (findPointerIndex == -1) {
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            findPointerIndex = 0;
                        }
                        initVelocityTrackerIfNotExists();
                        this.mVelocityTracker.addMovement(motionEvent);
                        if (startScrollIfNeeded((int) motionEvent.getY(findPointerIndex))) {
                            return true;
                        }
                    }
                }
                this.mTouchMode = 0;
                this.mActivePointerId = -1;
                recycleVelocityTracker();
                reportScrollStateChange(0);
            } else {
                int i2 = this.mTouchMode;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                this.mActivePointerId = motionEvent.getPointerId(0);
                int findMotionRow = findMotionRow(y);
                if (i2 != 2 && findMotionRow >= 0) {
                    this.mMotionX = x;
                    this.mMotionY = y;
                    this.mMotionPosition = findMotionRow;
                    this.mTouchMode = 3;
                }
                this.mLastY = Integer.MIN_VALUE;
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                if (i2 == 2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1989909154")) {
            ipChange.ipc$dispatch("-1989909154", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else if (this.mAdapter != null) {
            if (z) {
                int childCount = getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    getChildAt(i5).forceLayout();
                }
                this.mRecycleBin.g();
            }
            this.mInLayout = true;
            layoutChildren();
            this.mInLayout = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLayoutChild(View view, int i, boolean z, int i2, int i3, int i4, int i5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1955572821")) {
            ipChange.ipc$dispatch("-1955572821", new Object[]{this, view, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
        } else {
            view.layout(i2, i3, i4, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1452454356")) {
            ipChange.ipc$dispatch("-1452454356", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        this.mWidthMeasureSpec = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onMeasureChild(View view, LayoutParams layoutParams) {
        int makeMeasureSpec;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-187465171")) {
            ipChange.ipc$dispatch("-187465171", new Object[]{this, view, layoutParams});
            return;
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, getListPaddingLeft() + getListPaddingRight(), ((AbsListView.LayoutParams) layoutParams).width);
        int i = ((AbsListView.LayoutParams) layoutParams).height;
        if (i > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onOffsetChild(View view, int i, boolean z, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1569918078")) {
            ipChange.ipc$dispatch("-1569918078", new Object[]{this, view, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        view.offsetLeftAndRight(i2 - view.getLeft());
        view.offsetTopAndBottom(i3 - view.getTop());
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-95192255")) {
            ipChange.ipc$dispatch("-95192255", new Object[]{this, parcelable});
            return;
        }
        ListSavedState listSavedState = (ListSavedState) parcelable;
        super.onRestoreInstanceState(listSavedState.getSuperState());
        this.mDataChanged = true;
        this.mSyncHeight = listSavedState.height;
        long j = listSavedState.firstId;
        if (j >= 0) {
            this.mNeedSync = true;
            this.mSyncState = listSavedState;
            this.mSyncRowId = j;
            this.mSyncPosition = listSavedState.position;
            this.mSpecificTop = listSavedState.viewTop;
        }
        requestLayout();
    }

    @Override // android.widget.AbsListView, android.view.View
    public Parcelable onSaveInstanceState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1608592014")) {
            return (Parcelable) ipChange.ipc$dispatch("1608592014", new Object[]{this});
        }
        ListSavedState listSavedState = new ListSavedState(super.onSaveInstanceState());
        ListSavedState listSavedState2 = this.mSyncState;
        if (listSavedState2 != null) {
            listSavedState.selectedId = listSavedState2.selectedId;
            listSavedState.firstId = listSavedState2.firstId;
            listSavedState.viewTop = listSavedState2.viewTop;
            listSavedState.position = listSavedState2.position;
            listSavedState.height = listSavedState2.height;
            return listSavedState;
        }
        boolean z = getChildCount() > 0 && this.mItemCount > 0;
        listSavedState.selectedId = getSelectedItemId();
        listSavedState.height = getHeight();
        if (z && this.mFirstPosition > 0) {
            listSavedState.viewTop = getChildAt(0).getTop();
            int i = this.mFirstPosition;
            int i2 = this.mItemCount;
            if (i >= i2) {
                i = i2 - 1;
            }
            listSavedState.position = i;
            listSavedState.firstId = this.mAdapter.getItemId(i);
        } else {
            listSavedState.viewTop = 0;
            listSavedState.firstId = -1L;
            listSavedState.position = 0;
        }
        return listSavedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1313348951")) {
            ipChange.ipc$dispatch("1313348951", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        } else {
            onSizeChanged(i, i2);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchDown;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1239631166")) {
            return ((Boolean) ipChange.ipc$dispatch("1239631166", new Object[]{this, motionEvent})).booleanValue();
        }
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(motionEvent);
        if (hasChildren()) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                onTouchDown = onTouchDown(motionEvent);
            } else if (action == 6) {
                onTouchDown = onTouchPointerUp(motionEvent);
            } else if (action == 2) {
                onTouchDown = onTouchMove(motionEvent);
            } else if (action != 3) {
                onTouchDown = onTouchUp(motionEvent);
            } else {
                onTouchDown = onTouchCancel(motionEvent);
            }
            notifyTouchMode();
            return onTouchDown;
        }
        return false;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1402740032")) {
            ipChange.ipc$dispatch("-1402740032", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    void rememberSyncState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-968085918")) {
            ipChange.ipc$dispatch("-968085918", new Object[]{this});
        } else if (getChildCount() > 0) {
            this.mNeedSync = true;
            this.mSyncHeight = getHeight();
            View childAt = getChildAt(0);
            ListAdapter adapter = getAdapter();
            int i = this.mFirstPosition;
            if (i >= 0 && i < adapter.getCount()) {
                this.mSyncRowId = adapter.getItemId(this.mFirstPosition);
            } else {
                this.mSyncRowId = -1L;
            }
            if (childAt != null) {
                this.mSpecificTop = childAt.getTop();
            }
            this.mSyncPosition = this.mFirstPosition;
        }
    }

    public boolean removeFooterView(View view) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1662935931")) {
            return ((Boolean) ipChange.ipc$dispatch("1662935931", new Object[]{this, view})).booleanValue();
        }
        if (this.mFooterViewInfos.size() > 0) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter == null || !((HeaderViewListAdapter) listAdapter).removeFooter(view)) {
                z = false;
            } else {
                b bVar = this.mObserver;
                if (bVar != null) {
                    bVar.onChanged();
                }
            }
            removeFixedViewInfo(view, this.mFooterViewInfos);
            return z;
        }
        return false;
    }

    public boolean removeHeaderView(View view) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "66545133")) {
            return ((Boolean) ipChange.ipc$dispatch("66545133", new Object[]{this, view})).booleanValue();
        }
        if (this.mHeaderViewInfos.size() > 0) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter == null || !((HeaderViewListAdapter) listAdapter).removeHeader(view)) {
                z = false;
            } else {
                b bVar = this.mObserver;
                if (bVar != null) {
                    bVar.onChanged();
                }
            }
            removeFixedViewInfo(view, this.mHeaderViewInfos);
            return z;
        }
        return false;
    }

    void reportScrollStateChange(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1936953608")) {
            ipChange.ipc$dispatch("-1936953608", new Object[]{this, Integer.valueOf(i)});
        } else if (i != this.mScrollState) {
            this.mScrollState = i;
            AbsListView.OnScrollListener onScrollListener = this.mOnScrollListener;
            if (onScrollListener != null) {
                onScrollListener.onScrollStateChanged(this, i);
            }
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "266426024")) {
            ipChange.ipc$dispatch("266426024", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        if (z) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.widget.AbsListView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1279235214")) {
            ipChange.ipc$dispatch("-1279235214", new Object[]{this});
        } else if (this.mBlockLayoutRequests || this.mInLayout) {
        } else {
            super.requestLayout();
        }
    }

    public void resetToTop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1619630420")) {
            ipChange.ipc$dispatch("1619630420", new Object[]{this});
        }
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1933964135")) {
            ipChange.ipc$dispatch("-1933964135", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setClipToPadding(z);
        this.mClipToPadding = z;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "460537822")) {
            ipChange.ipc$dispatch("460537822", new Object[]{this, onScrollListener});
            return;
        }
        super.setOnScrollListener(onScrollListener);
        this.mOnScrollListener = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471193170")) {
            ipChange.ipc$dispatch("-471193170", new Object[]{this, Integer.valueOf(i)});
        } else if (i >= 0) {
            this.mLayoutMode = 2;
            this.mSpecificTop = getListPaddingTop();
            this.mFirstPosition = 0;
            if (this.mNeedSync) {
                this.mSyncPosition = i;
                this.mSyncRowId = this.mAdapter.getItemId(i);
            }
            requestLayout();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class LayoutParams extends AbsListView.LayoutParams {
        long itemId;
        int position;
        boolean recycledHeaderFooter;
        int viewType;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.itemId = -1L;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.itemId = -1L;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.itemId = -1L;
            this.viewType = i3;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.itemId = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-614608668") ? (LayoutParams) ipChange.ipc$dispatch("-614608668", new Object[]{this}) : new LayoutParams(-1, -2, 0);
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-93825479") ? (ListAdapter) ipChange.ipc$dispatch("-93825479", new Object[]{this}) : this.mAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-324890953")) {
            ipChange.ipc$dispatch("-324890953", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (getChildCount() > 0) {
            stopFlingRunnable();
            this.mRecycleBin.b();
            this.mDataChanged = true;
            rememberSyncState();
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1114122939")) {
            ipChange.ipc$dispatch("1114122939", new Object[]{this, listAdapter});
            return;
        }
        ListAdapter listAdapter2 = this.mAdapter;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.mObserver);
        }
        if (this.mHeaderViewInfos.size() <= 0 && this.mFooterViewInfos.size() <= 0) {
            this.mAdapter = listAdapter;
        } else {
            this.mAdapter = new HeaderViewListAdapter(this.mHeaderViewInfos, this.mFooterViewInfos, listAdapter);
        }
        this.mDataChanged = true;
        this.mItemCount = listAdapter != null ? listAdapter.getCount() : 0;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
            this.mRecycleBin.k(listAdapter.getViewTypeCount());
        }
        requestLayout();
    }

    public void addFooterView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1479133672")) {
            ipChange.ipc$dispatch("1479133672", new Object[]{this, view});
        } else {
            addFooterView(view, null, true);
        }
    }

    public void addHeaderView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-117257126")) {
            ipChange.ipc$dispatch("-117257126", new Object[]{this, view});
        } else {
            addHeaderView(view, null, true);
        }
    }
}
