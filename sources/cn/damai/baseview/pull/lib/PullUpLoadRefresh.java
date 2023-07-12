package cn.damai.baseview.pull.lib;

import android.view.View;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListView;
import cn.damai.baseview.PullScrollView;
import cn.damai.baseview.abcpullrefresh.library.listeners.OnLoadMoreListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class PullUpLoadRefresh implements IPullUpLoad {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private boolean b;
    private OnLoadMoreListener c;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements PullScrollView.OnScrollListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.baseview.PullScrollView.OnScrollListener
        public void isScrollIng(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1802080602")) {
                ipChange.ipc$dispatch("-1802080602", new Object[]{this, Integer.valueOf(i)});
            } else if (PullUpLoadRefresh.this.c != null) {
                if (i >= 130) {
                    PullUpLoadRefresh.this.c.onScroll(true);
                } else {
                    PullUpLoadRefresh.this.c.onScroll(false);
                }
            }
        }

        @Override // cn.damai.baseview.PullScrollView.OnScrollListener
        public void onScroll(PullScrollView pullScrollView) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1694487344")) {
                ipChange.ipc$dispatch("-1694487344", new Object[]{this, pullScrollView});
            } else if (PullUpLoadRefresh.this.c != null) {
                PullUpLoadRefresh.this.c.onLoadStarted(pullScrollView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(AbsListView absListView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "84558358")) {
            return ((Integer) ipChange.ipc$dispatch("84558358", new Object[]{this, absListView})).intValue();
        }
        View childAt = absListView.getChildAt(0);
        if (childAt == null) {
            return 0;
        }
        return (-childAt.getTop()) + (absListView.getFirstVisiblePosition() * childAt.getHeight());
    }

    public PullUpLoadRefresh g(OnLoadMoreListener onLoadMoreListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1663518460")) {
            return (PullUpLoadRefresh) ipChange.ipc$dispatch("-1663518460", new Object[]{this, onLoadMoreListener});
        }
        this.b = false;
        this.c = onLoadMoreListener;
        return this;
    }

    @Override // cn.damai.baseview.pull.lib.IPullUpLoad
    public void getScrollListener(ListView listView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "73086612")) {
            ipChange.ipc$dispatch("73086612", new Object[]{this, listView});
        } else {
            listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: cn.damai.baseview.pull.lib.PullUpLoadRefresh.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1879164489")) {
                        ipChange2.ipc$dispatch("1879164489", new Object[]{this, absListView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                        return;
                    }
                    if (PullUpLoadRefresh.this.c != null) {
                        if (q60.d(absListView.getContext(), PullUpLoadRefresh.this.f(absListView)) == 0) {
                            return;
                        }
                        if (q60.d(absListView.getContext(), PullUpLoadRefresh.this.f(absListView)) > 130) {
                            PullUpLoadRefresh.this.c.onScroll(true);
                        } else {
                            PullUpLoadRefresh.this.c.onScroll(false);
                        }
                    }
                    PullUpLoadRefresh.this.a = i;
                    if (absListView.getLastVisiblePosition() == i3 - 1) {
                        PullUpLoadRefresh.this.b = true;
                    } else {
                        PullUpLoadRefresh.this.b = false;
                    }
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "219055404")) {
                        ipChange2.ipc$dispatch("219055404", new Object[]{this, absListView, Integer.valueOf(i)});
                    } else if ((i == 0 || i == 2) && PullUpLoadRefresh.this.b && PullUpLoadRefresh.this.c != null) {
                        PullUpLoadRefresh.this.c.onLoadStarted(absListView);
                    }
                }
            });
        }
    }

    @Override // cn.damai.baseview.pull.lib.IPullUpLoad
    public void getScrollListener(PullScrollView pullScrollView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1530853241")) {
            ipChange.ipc$dispatch("1530853241", new Object[]{this, pullScrollView});
        } else {
            pullScrollView.setOnScrollListener(new a());
        }
    }

    @Override // cn.damai.baseview.pull.lib.IPullUpLoad
    public void getScrollListener(GridView gridView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1773768428")) {
            ipChange.ipc$dispatch("1773768428", new Object[]{this, gridView});
        } else {
            gridView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: cn.damai.baseview.pull.lib.PullUpLoadRefresh.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-487530105")) {
                        ipChange2.ipc$dispatch("-487530105", new Object[]{this, absListView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                        return;
                    }
                    PullUpLoadRefresh.this.a = i;
                    if (absListView.getLastVisiblePosition() == i3 - 1) {
                        PullUpLoadRefresh.this.b = true;
                    } else {
                        PullUpLoadRefresh.this.b = false;
                    }
                }

                @Override // android.widget.AbsListView.OnScrollListener
                public void onScrollStateChanged(AbsListView absListView, int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "259730154")) {
                        ipChange2.ipc$dispatch("259730154", new Object[]{this, absListView, Integer.valueOf(i)});
                    } else if ((i == 0 || i == 2) && PullUpLoadRefresh.this.b && PullUpLoadRefresh.this.c != null) {
                        PullUpLoadRefresh.this.c.onLoadStarted(absListView);
                    }
                }
            });
        }
    }
}
