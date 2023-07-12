package cn.damai.baseview.pull.refresh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Scroller;
import android.widget.TextView;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$string;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PullDownView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private final OnHeaderViewStateChangeListener ON_HEADER_VIEW_STATE_CHANGE_LISTENER;
    private final AdapterView.OnItemClickListener ON_ITEM_CLICK_LISTENER;
    private final AdapterView.OnItemLongClickListener ON_ITEM_LONG_CLICK_LISTENER;
    private final AbsListView.OnScrollListener ON_LISTVIEW_SCROLL_LISTENER;
    private final View.OnTouchListener ON_LISTVIEW_TOUCH_LISTENER;
    private final String TAG;
    private int mArrowIcon;
    private ImageView mDivider;
    private int mFirstVisibleItem;
    private View mFooterView;
    private HeaderView mHeaderView;
    private String mLastUpdateTitle;
    private ListView mListView;
    private boolean mMoved;
    private OnHeaderViewStateChangeListener mOnHeaderViewStateChangeListener;
    private OnObtainMoreListener mOnObtainMoreListener;
    private OnPullDownBackListener mOnPullDownBackListener;
    private OnRefreshListener mOnRefreshListener;
    private OnTouchDownUpListener mOnTouchDownUpListener;
    private OnTouchViewListener mOnTouchViewListener;
    private boolean mPullDownEnabled;
    private OnPullDownListener mPullDownListener;
    private OnItemClickListener mPullDownViewOnItemClickListener;
    private OnItemLongClickListener mPullDownViewOnItemLongClickListener;
    private EPullStatus mPullStatus;
    private Scroller mScroller;
    private String[] mStrHeaderStatusInfo;
    private int mTouchSlop;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public enum EPullStatus {
        PULL_NORMAL,
        PULL_DOWN,
        PULL_RELEASE,
        PULL_REFRESHING,
        MORE_REFRESHING
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnHeaderViewStateChangeListener {
        void onStateChange(View view, View view2, EPullStatus ePullStatus);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnItemClickListener {
        void onItemClick(AdapterView<?> adapterView, View view, int i, long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnItemLongClickListener {
        boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnObtainMoreListener {
        void onObtainMore(View view);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnPullDownBackListener {
        void onPullDownBack();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnPullDownListener {
        void startPullDown();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnRefreshListener {
        void onRefresh();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnTouchDownUpListener {
        void OnTouchUp(int i);

        void onTouchDown(int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnTouchViewListener {
        boolean onTouch(View view, MotionEvent motionEvent);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private float a = -1.0f;
        private float b = -1.0f;
        private int c = -1;

        a() {
        }

        private void b(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1009296815")) {
                ipChange.ipc$dispatch("1009296815", new Object[]{this, motionEvent});
            } else if (PullDownView.this.mListView.getCount() <= 0) {
            } else {
                float rawY = motionEvent.getRawY();
                this.a = rawY;
                this.b = rawY;
                PullDownView.this.mMoved = false;
                int pointToPosition = PullDownView.this.mListView.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                this.c = pointToPosition;
                if (pointToPosition == -1 || PullDownView.this.mOnTouchDownUpListener == null) {
                    return;
                }
                PullDownView.this.mOnTouchDownUpListener.onTouchDown(this.c);
            }
        }

        private int c(MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1916571437")) {
                return ((Integer) ipChange.ipc$dispatch("-1916571437", new Object[]{this, motionEvent})).intValue();
            }
            if (PullDownView.this.mListView == null) {
                return 0;
            }
            PullDownView pullDownView = PullDownView.this;
            pullDownView.mFirstVisibleItem = pullDownView.mListView.getFirstVisiblePosition();
            int pointToPosition = PullDownView.this.mListView.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (a((int) Math.abs(motionEvent.getRawY() - this.b)) && PullDownView.this.mOnTouchDownUpListener != null && pointToPosition != -1) {
                PullDownView.this.mOnTouchDownUpListener.OnTouchUp(pointToPosition);
            }
            int scrollY = PullDownView.this.getScrollY();
            if (this.a == -1.0f) {
                float rawY = motionEvent.getRawY();
                this.a = rawY;
                this.b = rawY;
                this.c = pointToPosition;
                return 1;
            }
            EPullStatus ePullStatus = EPullStatus.PULL_NORMAL;
            if (ePullStatus != PullDownView.this.mPullStatus || (this.a < motionEvent.getRawY() && PullDownView.this.mFirstVisibleItem == 0 && (PullDownView.this.mListView.getChildAt(0) == null || PullDownView.this.mListView.getChildAt(0).getTop() == 0))) {
                EPullStatus ePullStatus2 = PullDownView.this.mPullStatus;
                EPullStatus ePullStatus3 = EPullStatus.PULL_DOWN;
                if (ePullStatus2 == ePullStatus3 || PullDownView.this.mPullStatus == EPullStatus.PULL_RELEASE || PullDownView.this.mPullStatus == ePullStatus) {
                    if (Math.abs(motionEvent.getRawY() - this.b) > PullDownView.this.mTouchSlop) {
                        PullDownView.this.mMoved = true;
                        if (this.c != -1) {
                            View childAt = PullDownView.this.mListView.getChildAt(this.c - PullDownView.this.mFirstVisibleItem);
                            PullDownView.this.mListView.setPressed(false);
                            if (childAt != null) {
                                childAt.setPressed(false);
                            }
                            PullDownView.this.mListView.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    int height = PullDownView.this.mListView.getHeight();
                    int i = -scrollY;
                    int rawY2 = (int) ((motionEvent.getRawY() - this.a) / ((height / (height - (i * 2))) * 1.2d));
                    if (i + rawY2 >= 0) {
                        scrollY = rawY2;
                    }
                    PullDownView.this.scrollBy(0, -scrollY);
                    this.a = motionEvent.getRawY();
                    if ((-PullDownView.this.getScrollY()) >= PullDownView.this.mHeaderView.getHeight()) {
                        PullDownView.this.setPullStatus(EPullStatus.PULL_RELEASE);
                    } else {
                        PullDownView.this.setPullStatus(ePullStatus3);
                    }
                    return 1;
                }
                return 2;
            }
            return 0;
        }

        private void d() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1709086017")) {
                ipChange.ipc$dispatch("1709086017", new Object[]{this});
                return;
            }
            if (PullDownView.this.mOnTouchDownUpListener != null && this.c != -1) {
                PullDownView.this.mOnTouchDownUpListener.OnTouchUp(this.c);
            }
            this.a = -1.0f;
            this.c = -1;
            if (PullDownView.this.mPullStatus == EPullStatus.PULL_RELEASE) {
                PullDownView.this.setPullStatus(EPullStatus.PULL_REFRESHING);
                PullDownView.this.preparePullRefresh();
                if (PullDownView.this.mOnRefreshListener != null) {
                    PullDownView.this.mOnRefreshListener.onRefresh();
                }
            }
            if (PullDownView.this.mPullStatus == EPullStatus.PULL_DOWN) {
                PullDownView.this.setPullStatus(EPullStatus.PULL_NORMAL);
                PullDownView.this.resetHeader();
            }
        }

        boolean a(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "961582003") ? ((Boolean) ipChange.ipc$dispatch("961582003", new Object[]{this, Integer.valueOf(i)})).booleanValue() : i > PullDownView.this.mTouchSlop;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "441353592")) {
                return ((Boolean) ipChange.ipc$dispatch("441353592", new Object[]{this, view, motionEvent})).booleanValue();
            }
            if (PullDownView.this.mPullDownEnabled && EPullStatus.MORE_REFRESHING != PullDownView.this.mPullStatus && PullDownView.this.mListView.getCount() != 0 && EPullStatus.PULL_REFRESHING != PullDownView.this.mPullStatus) {
                if (PullDownView.this.mOnTouchViewListener != null) {
                    PullDownView.this.mOnTouchViewListener.onTouch(view, motionEvent);
                }
                int action = motionEvent.getAction();
                if (action == 0) {
                    b(motionEvent);
                } else if (action != 1) {
                    if (action == 2 && c(motionEvent) == 1) {
                        return true;
                    }
                } else {
                    d();
                }
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements OnHeaderViewStateChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private RotateAnimation a;
        private RotateAnimation b;

        public b() {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
            this.a = rotateAnimation;
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.a.setDuration(250L);
            this.a.setFillAfter(true);
            RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
            this.b = rotateAnimation2;
            rotateAnimation2.setInterpolator(new LinearInterpolator());
            this.b.setDuration(250L);
            this.b.setFillAfter(true);
        }

        @Override // cn.damai.baseview.pull.refresh.PullDownView.OnHeaderViewStateChangeListener
        public void onStateChange(View view, View view2, EPullStatus ePullStatus) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-778831446")) {
                ipChange.ipc$dispatch("-778831446", new Object[]{this, view, view2, ePullStatus});
                return;
            }
            TextView textView = (TextView) view.findViewById(R$id.status_info);
            int i = R$id.refresh_progress;
            ProgressBar progressBar = (ProgressBar) view.findViewById(i);
            ImageView imageView = (ImageView) view.findViewById(R$id.status_img);
            if (ePullStatus == EPullStatus.PULL_DOWN) {
                textView.setText(PullDownView.this.mStrHeaderStatusInfo[0]);
                progressBar.setVisibility(8);
                imageView.setVisibility(0);
                imageView.setImageResource(PullDownView.this.mArrowIcon);
                imageView.clearAnimation();
            } else if (ePullStatus == EPullStatus.PULL_RELEASE) {
                textView.setText(PullDownView.this.mStrHeaderStatusInfo[1]);
                imageView.setImageResource(PullDownView.this.mArrowIcon);
                imageView.clearAnimation();
            } else if (ePullStatus == EPullStatus.PULL_REFRESHING) {
                textView.setText(PullDownView.this.mStrHeaderStatusInfo[2]);
                imageView.setVisibility(8);
                imageView.setImageDrawable(null);
                progressBar.setVisibility(0);
                if (view2 != null) {
                    view2.setClickable(false);
                }
            } else if (ePullStatus == EPullStatus.MORE_REFRESHING) {
                view2.findViewById(i).setVisibility(0);
            }
        }
    }

    public PullDownView(Context context) {
        super(context);
        this.mPullStatus = EPullStatus.PULL_NORMAL;
        this.mFirstVisibleItem = -1;
        this.mOnRefreshListener = null;
        this.mOnHeaderViewStateChangeListener = null;
        this.mOnObtainMoreListener = null;
        this.mPullDownViewOnItemClickListener = null;
        this.mPullDownViewOnItemLongClickListener = null;
        this.mPullDownListener = null;
        this.mOnPullDownBackListener = null;
        this.mOnTouchViewListener = null;
        this.mTouchSlop = 0;
        this.mMoved = false;
        this.mPullDownEnabled = true;
        this.mFooterView = null;
        this.mArrowIcon = R$drawable.uikit_pull_to_refresh_logo_0;
        this.TAG = "PullDownView";
        this.ON_LISTVIEW_SCROLL_LISTENER = new AbsListView.OnScrollListener() { // from class: cn.damai.baseview.pull.refresh.PullDownView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "222527380")) {
                    ipChange.ipc$dispatch("222527380", new Object[]{this, absListView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1321378633")) {
                    ipChange.ipc$dispatch("-1321378633", new Object[]{this, absListView, Integer.valueOf(i)});
                }
            }
        };
        this.ON_LISTVIEW_TOUCH_LISTENER = new a();
        this.ON_ITEM_CLICK_LISTENER = new AdapterView.OnItemClickListener() { // from class: cn.damai.baseview.pull.refresh.PullDownView.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2067097137")) {
                    ipChange.ipc$dispatch("2067097137", new Object[]{this, adapterView, view, Integer.valueOf(i), Long.valueOf(j)});
                } else if (PullDownView.this.mMoved) {
                    PullDownView.this.mMoved = false;
                } else if (i != ((PullDownView.this.mListView.getCount() - PullDownView.this.mListView.getFooterViewsCount()) + 1) - 1 || PullDownView.this.mListView.getFooterViewsCount() <= 0 || PullDownView.this.mListView.getCount() <= 0) {
                    if (PullDownView.this.mPullStatus == EPullStatus.PULL_DOWN || PullDownView.this.mPullStatus == EPullStatus.PULL_RELEASE || PullDownView.this.mPullDownViewOnItemClickListener == null) {
                        return;
                    }
                    PullDownView.this.mPullDownViewOnItemClickListener.onItemClick(adapterView, view, i, j);
                } else if (PullDownView.this.mOnObtainMoreListener == null || PullDownView.this.mPullStatus != EPullStatus.PULL_NORMAL) {
                } else {
                    PullDownView.this.setPullStatus(EPullStatus.MORE_REFRESHING);
                    PullDownView.this.mOnObtainMoreListener.onObtainMore(view);
                }
            }
        };
        this.ON_ITEM_LONG_CLICK_LISTENER = new AdapterView.OnItemLongClickListener() { // from class: cn.damai.baseview.pull.refresh.PullDownView.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1733577254")) {
                    return ((Boolean) ipChange.ipc$dispatch("-1733577254", new Object[]{this, adapterView, view, Integer.valueOf(i), Long.valueOf(j)})).booleanValue();
                }
                if (PullDownView.this.mMoved) {
                    PullDownView.this.mMoved = false;
                    return false;
                }
                if (i != ((PullDownView.this.mListView.getCount() - PullDownView.this.mListView.getFooterViewsCount()) + 1) - 1 || PullDownView.this.mListView.getFooterViewsCount() <= 0 || PullDownView.this.mListView.getCount() <= 0) {
                    if (PullDownView.this.mPullStatus != EPullStatus.PULL_DOWN && PullDownView.this.mPullStatus != EPullStatus.PULL_RELEASE && PullDownView.this.mPullDownViewOnItemLongClickListener != null) {
                        PullDownView.this.mPullDownViewOnItemLongClickListener.onItemLongClick(adapterView, view, i, j);
                    }
                } else if (PullDownView.this.mOnObtainMoreListener != null && PullDownView.this.mPullStatus == EPullStatus.PULL_NORMAL) {
                    PullDownView.this.setPullStatus(EPullStatus.MORE_REFRESHING);
                    PullDownView.this.mOnObtainMoreListener.onObtainMore(view);
                }
                return false;
            }
        };
        this.ON_HEADER_VIEW_STATE_CHANGE_LISTENER = new b();
        this.mScroller = new Scroller(context);
    }

    public static int convertDIP2PX(Context context, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1733033331")) {
            return ((Integer) ipChange.ipc$dispatch("-1733033331", new Object[]{context, Integer.valueOf(i)})).intValue();
        }
        return (int) ((i * context.getResources().getDisplayMetrics().density) + ((i < 0 ? -1 : 1) * 0.5f));
    }

    private void initControls() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "426111107")) {
            ipChange.ipc$dispatch("426111107", new Object[]{this});
            return;
        }
        this.mListView = (ListView) findViewById(R$id.pull_down_listview);
        this.mHeaderView = (HeaderView) findViewById(R$id.pull_down_headerview);
        this.mDivider = (ImageView) findViewById(R$id.iv_divider);
        this.mListView.setOnScrollListener(this.ON_LISTVIEW_SCROLL_LISTENER);
        this.mListView.setOnTouchListener(this.ON_LISTVIEW_TOUCH_LISTENER);
        this.mListView.setOnItemClickListener(this.ON_ITEM_CLICK_LISTENER);
        this.mListView.setOnItemLongClickListener(this.ON_ITEM_LONG_CLICK_LISTENER);
    }

    private void onRefreshComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "655203276")) {
            ipChange.ipc$dispatch("655203276", new Object[]{this});
        } else {
            resetHeader();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preparePullRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1165811578")) {
            ipChange.ipc$dispatch("1165811578", new Object[]{this});
            return;
        }
        int height = this.mHeaderView.getHeight();
        if (height == 0) {
            height = convertDIP2PX(getContext(), 60);
        }
        int scrollY = getScrollY();
        this.mScroller.startScroll(0, scrollY, 0, -(height + scrollY), 800);
        invalidate();
    }

    private void resetFooter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340326967")) {
            ipChange.ipc$dispatch("340326967", new Object[]{this});
            return;
        }
        View view = this.mFooterView;
        if (view != null) {
            ((ProgressBar) view.findViewById(R$id.refresh_progress)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetHeader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "773935109")) {
            ipChange.ipc$dispatch("773935109", new Object[]{this});
            return;
        }
        int scrollY = getScrollY();
        this.mScroller.startScroll(0, scrollY, 0, -scrollY, 800);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPullStatus(EPullStatus ePullStatus) {
        OnPullDownBackListener onPullDownBackListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-188937227")) {
            ipChange.ipc$dispatch("-188937227", new Object[]{this, ePullStatus});
            return;
        }
        EPullStatus ePullStatus2 = this.mPullStatus;
        if (ePullStatus2 == ePullStatus) {
            return;
        }
        EPullStatus ePullStatus3 = EPullStatus.PULL_NORMAL;
        if (ePullStatus2 == ePullStatus3 && ePullStatus == EPullStatus.PULL_DOWN) {
            OnPullDownListener onPullDownListener = this.mPullDownListener;
            if (onPullDownListener != null) {
                onPullDownListener.startPullDown();
            }
        } else if (ePullStatus2 == EPullStatus.PULL_DOWN && ePullStatus == ePullStatus3 && (onPullDownBackListener = this.mOnPullDownBackListener) != null) {
            onPullDownBackListener.onPullDownBack();
        }
        this.mPullStatus = ePullStatus;
        OnHeaderViewStateChangeListener onHeaderViewStateChangeListener = this.mOnHeaderViewStateChangeListener;
        if (onHeaderViewStateChangeListener != null) {
            onHeaderViewStateChangeListener.onStateChange(this.mHeaderView.getChildAt(0), this.mFooterView, this.mPullStatus);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "877771485")) {
            ipChange.ipc$dispatch("877771485", new Object[]{this});
        } else if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            invalidate();
        } else {
            super.computeScroll();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "973425005") ? ((Boolean) ipChange.ipc$dispatch("973425005", new Object[]{this, motionEvent})).booleanValue() : super.dispatchTouchEvent(motionEvent);
    }

    public HeaderView getHeaderView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-111278856") ? (HeaderView) ipChange.ipc$dispatch("-111278856", new Object[]{this}) : this.mHeaderView;
    }

    public ListView getListView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2143033707") ? (ListView) ipChange.ipc$dispatch("2143033707", new Object[]{this}) : this.mListView;
    }

    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1684043545")) {
            ipChange.ipc$dispatch("1684043545", new Object[]{this});
            return;
        }
        initControls();
        Context context = getContext();
        this.mStrHeaderStatusInfo = new String[]{context.getString(R$string.pull_to_refresh_pull_label), context.getString(R$string.pull_to_refresh_release_label), context.getString(R$string.pull_to_refresh_refreshing_label)};
        this.mLastUpdateTitle = "最新更新";
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.mOnHeaderViewStateChangeListener = this.ON_HEADER_VIEW_STATE_CHANGE_LISTENER;
    }

    public void mRemoveFootView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "167304989")) {
            ipChange.ipc$dispatch("167304989", new Object[]{this});
            return;
        }
        View view = this.mFooterView;
        if (view != null) {
            this.mListView.removeFooterView(view);
            this.mFooterView = null;
        }
    }

    public void notifyRefreshComplete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1028626614")) {
            ipChange.ipc$dispatch("1028626614", new Object[]{this});
            return;
        }
        setPullStatus(EPullStatus.PULL_NORMAL);
        setLastUpdateTime();
        onRefreshComplete();
    }

    public void setArrowImage(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-627806538")) {
            ipChange.ipc$dispatch("-627806538", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mArrowIcon = i;
        }
    }

    public void setDividerEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "613390237")) {
            ipChange.ipc$dispatch("613390237", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mDivider.setVisibility(0);
        } else {
            this.mDivider.setVisibility(8);
        }
    }

    public void setFooterView(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "723088324")) {
            ipChange.ipc$dispatch("723088324", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i == 0) {
            i = R$layout.footer_item;
        }
        View inflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
        this.mFooterView = inflate;
        this.mListView.addFooterView(inflate);
    }

    public void setFooterViewBkg(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1368705617")) {
            ipChange.ipc$dispatch("1368705617", new Object[]{this, drawable});
            return;
        }
        View view = this.mFooterView;
        if (view != null) {
            view.setBackgroundDrawable(drawable);
        }
    }

    public void setHeaderStatusInfo(String[] strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-675380563")) {
            ipChange.ipc$dispatch("-675380563", new Object[]{this, strArr});
        } else {
            this.mStrHeaderStatusInfo = strArr;
        }
    }

    public void setHeaderViewBkg(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-311945532")) {
            ipChange.ipc$dispatch("-311945532", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mHeaderView.setBackgroundResource(i);
        }
    }

    public void setHeaderViewStatusTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-421912342")) {
            ipChange.ipc$dispatch("-421912342", new Object[]{this, Integer.valueOf(i)});
        } else {
            ((TextView) this.mHeaderView.findViewById(R$id.status_info)).setTextColor(i);
        }
    }

    public void setHeaderViewUpdateTimeTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1638989786")) {
            ipChange.ipc$dispatch("-1638989786", new Object[]{this, Integer.valueOf(i)});
        } else {
            ((TextView) this.mHeaderView.findViewById(R$id.last_update)).setTextColor(i);
        }
    }

    public void setLastUpdateTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1156033773")) {
            ipChange.ipc$dispatch("-1156033773", new Object[]{this});
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ((TextView) this.mHeaderView.findViewById(R$id.last_update)).setText(this.mLastUpdateTitle + simpleDateFormat.format(new Date()));
    }

    public void setLastUpdateTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-156916932")) {
            ipChange.ipc$dispatch("-156916932", new Object[]{this, str});
        } else {
            this.mLastUpdateTitle = str;
        }
    }

    public void setObtainingMoreStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-135079673")) {
            ipChange.ipc$dispatch("-135079673", new Object[]{this});
        } else {
            setPullStatus(EPullStatus.MORE_REFRESHING);
        }
    }

    public void setOnHeaderViewStateChangeListener(OnHeaderViewStateChangeListener onHeaderViewStateChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1559327986")) {
            ipChange.ipc$dispatch("-1559327986", new Object[]{this, onHeaderViewStateChangeListener});
        } else {
            this.mOnHeaderViewStateChangeListener = onHeaderViewStateChangeListener;
        }
    }

    public void setOnObtainMoreListener(OnObtainMoreListener onObtainMoreListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1724168004")) {
            ipChange.ipc$dispatch("-1724168004", new Object[]{this, onObtainMoreListener});
        } else {
            this.mOnObtainMoreListener = onObtainMoreListener;
        }
    }

    public void setOnPullDownBackListener(OnPullDownBackListener onPullDownBackListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "752175508")) {
            ipChange.ipc$dispatch("752175508", new Object[]{this, onPullDownBackListener});
        } else {
            this.mOnPullDownBackListener = onPullDownBackListener;
        }
    }

    public void setOnPullDownListener(OnPullDownListener onPullDownListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2116343266")) {
            ipChange.ipc$dispatch("2116343266", new Object[]{this, onPullDownListener});
        } else {
            this.mPullDownListener = onPullDownListener;
        }
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "204860302")) {
            ipChange.ipc$dispatch("204860302", new Object[]{this, onRefreshListener});
        } else {
            this.mOnRefreshListener = onRefreshListener;
        }
    }

    public void setOnTouchDownUpListener(OnTouchDownUpListener onTouchDownUpListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-744863954")) {
            ipChange.ipc$dispatch("-744863954", new Object[]{this, onTouchDownUpListener});
        } else {
            this.mOnTouchDownUpListener = onTouchDownUpListener;
        }
    }

    public void setOnTouchViewListener(OnTouchViewListener onTouchViewListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1513342354")) {
            ipChange.ipc$dispatch("-1513342354", new Object[]{this, onTouchViewListener});
        } else {
            this.mOnTouchViewListener = onTouchViewListener;
        }
    }

    public void setPullDownEnabled(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1530229565")) {
            ipChange.ipc$dispatch("-1530229565", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mPullDownEnabled = z;
        }
    }

    public void setPullDownViewOnItemClickListener(OnItemClickListener onItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1983452190")) {
            ipChange.ipc$dispatch("-1983452190", new Object[]{this, onItemClickListener});
        } else {
            this.mPullDownViewOnItemClickListener = onItemClickListener;
        }
    }

    public void setPullDownViewOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "358067298")) {
            ipChange.ipc$dispatch("358067298", new Object[]{this, onItemLongClickListener});
        } else {
            this.mPullDownViewOnItemLongClickListener = onItemLongClickListener;
        }
    }

    public void setRefreshState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1784445623")) {
            ipChange.ipc$dispatch("-1784445623", new Object[]{this});
            return;
        }
        setPullStatus(EPullStatus.PULL_REFRESHING);
        preparePullRefresh();
    }

    public void setUpdateTimeVisibility(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1743172532")) {
            ipChange.ipc$dispatch("-1743172532", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mHeaderView.findViewById(R$id.last_update).setVisibility(i);
        }
    }

    public void showFooterView(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "785992200")) {
            ipChange.ipc$dispatch("785992200", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        View view = this.mFooterView;
        if (view != null) {
            if (z) {
                view.findViewById(R$id.refresh_progress).setVisibility(0);
                this.mFooterView.findViewById(R$id.textView_obtain_more).setVisibility(0);
                return;
            }
            view.findViewById(R$id.refresh_progress).setVisibility(8);
            this.mFooterView.findViewById(R$id.textView_obtain_more).setVisibility(8);
        }
    }

    public void setHeaderViewBkg(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-638181437")) {
            ipChange.ipc$dispatch("-638181437", new Object[]{this, drawable});
        } else {
            this.mHeaderView.setBackgroundDrawable(drawable);
        }
    }

    public void setFooterView(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-301241517")) {
            ipChange.ipc$dispatch("-301241517", new Object[]{this, view});
            return;
        }
        this.mFooterView = view;
        this.mListView.addFooterView(view);
    }

    public void init(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "665771786")) {
            ipChange.ipc$dispatch("665771786", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        initControls();
        if (i == -1) {
            return;
        }
        this.mHeaderView.removeAllViews();
        this.mHeaderView.addView(((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(i, (ViewGroup) null));
        this.mOnHeaderViewStateChangeListener = null;
        this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public PullDownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPullStatus = EPullStatus.PULL_NORMAL;
        this.mFirstVisibleItem = -1;
        this.mOnRefreshListener = null;
        this.mOnHeaderViewStateChangeListener = null;
        this.mOnObtainMoreListener = null;
        this.mPullDownViewOnItemClickListener = null;
        this.mPullDownViewOnItemLongClickListener = null;
        this.mPullDownListener = null;
        this.mOnPullDownBackListener = null;
        this.mOnTouchViewListener = null;
        this.mTouchSlop = 0;
        this.mMoved = false;
        this.mPullDownEnabled = true;
        this.mFooterView = null;
        this.mArrowIcon = R$drawable.uikit_pull_to_refresh_logo_0;
        this.TAG = "PullDownView";
        this.ON_LISTVIEW_SCROLL_LISTENER = new AbsListView.OnScrollListener() { // from class: cn.damai.baseview.pull.refresh.PullDownView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "222527380")) {
                    ipChange.ipc$dispatch("222527380", new Object[]{this, absListView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1321378633")) {
                    ipChange.ipc$dispatch("-1321378633", new Object[]{this, absListView, Integer.valueOf(i)});
                }
            }
        };
        this.ON_LISTVIEW_TOUCH_LISTENER = new a();
        this.ON_ITEM_CLICK_LISTENER = new AdapterView.OnItemClickListener() { // from class: cn.damai.baseview.pull.refresh.PullDownView.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "2067097137")) {
                    ipChange.ipc$dispatch("2067097137", new Object[]{this, adapterView, view, Integer.valueOf(i), Long.valueOf(j)});
                } else if (PullDownView.this.mMoved) {
                    PullDownView.this.mMoved = false;
                } else if (i != ((PullDownView.this.mListView.getCount() - PullDownView.this.mListView.getFooterViewsCount()) + 1) - 1 || PullDownView.this.mListView.getFooterViewsCount() <= 0 || PullDownView.this.mListView.getCount() <= 0) {
                    if (PullDownView.this.mPullStatus == EPullStatus.PULL_DOWN || PullDownView.this.mPullStatus == EPullStatus.PULL_RELEASE || PullDownView.this.mPullDownViewOnItemClickListener == null) {
                        return;
                    }
                    PullDownView.this.mPullDownViewOnItemClickListener.onItemClick(adapterView, view, i, j);
                } else if (PullDownView.this.mOnObtainMoreListener == null || PullDownView.this.mPullStatus != EPullStatus.PULL_NORMAL) {
                } else {
                    PullDownView.this.setPullStatus(EPullStatus.MORE_REFRESHING);
                    PullDownView.this.mOnObtainMoreListener.onObtainMore(view);
                }
            }
        };
        this.ON_ITEM_LONG_CLICK_LISTENER = new AdapterView.OnItemLongClickListener() { // from class: cn.damai.baseview.pull.refresh.PullDownView.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1733577254")) {
                    return ((Boolean) ipChange.ipc$dispatch("-1733577254", new Object[]{this, adapterView, view, Integer.valueOf(i), Long.valueOf(j)})).booleanValue();
                }
                if (PullDownView.this.mMoved) {
                    PullDownView.this.mMoved = false;
                    return false;
                }
                if (i != ((PullDownView.this.mListView.getCount() - PullDownView.this.mListView.getFooterViewsCount()) + 1) - 1 || PullDownView.this.mListView.getFooterViewsCount() <= 0 || PullDownView.this.mListView.getCount() <= 0) {
                    if (PullDownView.this.mPullStatus != EPullStatus.PULL_DOWN && PullDownView.this.mPullStatus != EPullStatus.PULL_RELEASE && PullDownView.this.mPullDownViewOnItemLongClickListener != null) {
                        PullDownView.this.mPullDownViewOnItemLongClickListener.onItemLongClick(adapterView, view, i, j);
                    }
                } else if (PullDownView.this.mOnObtainMoreListener != null && PullDownView.this.mPullStatus == EPullStatus.PULL_NORMAL) {
                    PullDownView.this.setPullStatus(EPullStatus.MORE_REFRESHING);
                    PullDownView.this.mOnObtainMoreListener.onObtainMore(view);
                }
                return false;
            }
        };
        this.ON_HEADER_VIEW_STATE_CHANGE_LISTENER = new b();
        this.mScroller = new Scroller(context);
    }
}
