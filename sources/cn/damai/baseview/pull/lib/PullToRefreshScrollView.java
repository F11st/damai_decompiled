package cn.damai.baseview.pull.lib;

import android.content.Context;
import android.util.AttributeSet;
import cn.damai.baseview.pull.lib.PullToRefreshBase;
import cn.damai.uikit.view.MyScrollView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PullToRefreshScrollView extends PullToRefreshBase<MyScrollView> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final PullToRefreshBase.OnRefreshListener defaultOnRefreshListener;
    private RefreshListener refreshListener;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface RefreshListener {
        void onRefresh(PullToRefreshScrollView pullToRefreshScrollView);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.baseview.pull.lib.PullToRefreshScrollView$a */
    /* loaded from: classes.dex */
    public class C0296a implements PullToRefreshBase.OnRefreshListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0296a() {
        }

        @Override // cn.damai.baseview.pull.lib.PullToRefreshBase.OnRefreshListener
        public void onRefresh() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1209124043")) {
                ipChange.ipc$dispatch("-1209124043", new Object[]{this});
            } else if (PullToRefreshScrollView.this.refreshListener != null) {
                PullToRefreshScrollView.this.refreshListener.onRefresh(PullToRefreshScrollView.this);
            }
        }
    }

    public PullToRefreshScrollView(Context context) {
        super(context);
        C0296a c0296a = new C0296a();
        this.defaultOnRefreshListener = c0296a;
        setOnRefreshListener(c0296a);
    }

    @Override // cn.damai.baseview.pull.lib.PullToRefreshBase
    protected boolean isReadyForPullDown() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1431736697") ? ((Boolean) ipChange.ipc$dispatch("1431736697", new Object[]{this})).booleanValue() : ((MyScrollView) this.refreshableView).getScrollY() == 0;
    }

    @Override // cn.damai.baseview.pull.lib.PullToRefreshBase
    protected boolean isReadyForPullUp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2135574880")) {
            return ((Boolean) ipChange.ipc$dispatch("2135574880", new Object[]{this})).booleanValue();
        }
        MyScrollView refreshableView = getRefreshableView();
        return (refreshableView.getScrollY() + refreshableView.getHeight()) - refreshableView.getChildAt(0).getHeight() == 0;
    }

    public void setRefreshListener(RefreshListener refreshListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2102824844")) {
            ipChange.ipc$dispatch("2102824844", new Object[]{this, refreshListener});
        } else {
            this.refreshListener = refreshListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.baseview.pull.lib.PullToRefreshBase
    public MyScrollView createRefreshableView(Context context, AttributeSet attributeSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1298004191")) {
            return (MyScrollView) ipChange.ipc$dispatch("1298004191", new Object[]{this, context, attributeSet});
        }
        MyScrollView myScrollView = new MyScrollView(context, attributeSet);
        myScrollView.setFadingEdgeLength(0);
        return myScrollView;
    }

    public PullToRefreshScrollView(Context context, int i) {
        super(context, i);
        C0296a c0296a = new C0296a();
        this.defaultOnRefreshListener = c0296a;
        setOnRefreshListener(c0296a);
    }

    public PullToRefreshScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0296a c0296a = new C0296a();
        this.defaultOnRefreshListener = c0296a;
        setOnRefreshListener(c0296a);
    }
}
