package cn.damai.commonbusiness.tab;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.tab.BottomSheetBean;
import cn.damai.commonbusiness.tab.TabClickStatusManager;
import cn.damai.commonbusiness.tab.download.ImageDownLoader;
import com.airbnb.lottie.LottieAnimationView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.m61;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DamaiTabViewHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int HOMEICON_STATE_NORMAL = 1;
    public static final int HOMEICON_STATE_UP = 2;
    protected static int g = 5;
    private List<TabItem> a = new ArrayList();
    private OnHomeIconTabStateChangedListener b;
    private ImageDownLoader c;
    private boolean d;
    private View e;
    LottieAnimationView f;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnHomeIconTabStateChangedListener {
        void onHomeIconTabStateChanged(int i);
    }

    public DamaiTabViewHelper(AppCompatActivity appCompatActivity) {
        this.d = false;
        this.c = new ImageDownLoader(appCompatActivity);
        this.d = false;
    }

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "987559622")) {
            ipChange.ipc$dispatch("987559622", new Object[]{this});
        } else {
            this.f.setImageResource(R$drawable.default_tab_home_selected);
        }
    }

    private void e(List<TabItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271279432")) {
            ipChange.ipc$dispatch("1271279432", new Object[]{this, list});
            return;
        }
        BottomSheetBean bottomSheetBean = (BottomSheetBean) m61.a(z20.B(DamaiTabbarManager.TabBar_SERVER_DATA), BottomSheetBean.class);
        if (bottomSheetBean == null || wh2.e(bottomSheetBean.content) <= 0) {
            return;
        }
        int size = bottomSheetBean.content.size();
        int size2 = list.size();
        g = size2;
        for (int i = 0; i < size2; i++) {
            TabItem tabItem = list.get(i);
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    BottomSheetBean.Result result = bottomSheetBean.content.get(i2);
                    if (tabItem.type.equals(result.type)) {
                        tabItem.popText = result.popText;
                        tabItem.popPosition = i;
                        break;
                    }
                    i2++;
                }
            }
        }
    }

    private void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "320589549")) {
            ipChange.ipc$dispatch("320589549", new Object[]{this});
        } else {
            this.f.setImageResource(R$drawable.default_tab_home_reselected);
        }
    }

    @Nullable
    public String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-708830112")) {
            return (String) ipChange.ipc$dispatch("-708830112", new Object[]{this});
        }
        try {
            BottomSheetBean bottomSheetBean = (BottomSheetBean) m61.a(z20.B(DamaiTabbarManager.TabBar), BottomSheetBean.class);
            if (bottomSheetBean != null && wh2.e(bottomSheetBean.content) >= 5) {
                return bottomSheetBean.backgroundPic;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<TabItem> c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2037311469")) {
            return (List) ipChange.ipc$dispatch("-2037311469", new Object[]{this});
        }
        this.a.clear();
        BottomSheetBean bottomSheetBean = (BottomSheetBean) m61.a(z20.B(DamaiTabbarManager.TabBar), BottomSheetBean.class);
        List<TabItem> h = a.g(bottomSheetBean) ? a.h(bottomSheetBean, this.c) : null;
        if (cb2.d(h)) {
            this.d = true;
            h = a.e();
        } else {
            this.d = false;
        }
        this.a.addAll(h);
        e(h);
        return h;
    }

    public void d(OnHomeIconTabStateChangedListener onHomeIconTabStateChangedListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-922822847")) {
            ipChange.ipc$dispatch("-922822847", new Object[]{this, onHomeIconTabStateChangedListener});
        } else {
            this.b = onHomeIconTabStateChangedListener;
        }
    }

    public void f(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "348734934")) {
            ipChange.ipc$dispatch("348734934", new Object[]{this, view});
        } else {
            this.e = view;
        }
    }

    public void g() {
        TabItem tabItem;
        ITabView iTabView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "323907174")) {
            ipChange.ipc$dispatch("323907174", new Object[]{this});
        } else if (wh2.e(this.a) <= 0 || (tabItem = this.a.get(0)) == null || (iTabView = tabItem.tabView) == null || iTabView.getLottieAnimationView() == null) {
        } else {
            this.f = tabItem.tabView.getLottieAnimationView();
            TabClickStatusManager.HomeTabStatus a = TabClickStatusManager.b().a();
            TabClickStatusManager.HomeTabStatus homeTabStatus = TabClickStatusManager.HomeTabStatus.RE_SELECTED;
            if (a == homeTabStatus) {
                if (this.d) {
                    a();
                } else {
                    this.f.setImageBitmap(tabItem.selectedBitmap);
                }
                TabClickStatusManager.b().c(TabClickStatusManager.HomeTabStatus.SELECTED);
                OnHomeIconTabStateChangedListener onHomeIconTabStateChangedListener = this.b;
                if (onHomeIconTabStateChangedListener != null) {
                    onHomeIconTabStateChangedListener.onHomeIconTabStateChanged(1);
                }
            } else if (TabClickStatusManager.b().a() == TabClickStatusManager.HomeTabStatus.SELECTED) {
                if (this.d) {
                    j();
                } else {
                    this.f.setImageBitmap(tabItem.reSelectedBitmap);
                }
                TabClickStatusManager.b().c(homeTabStatus);
                OnHomeIconTabStateChangedListener onHomeIconTabStateChangedListener2 = this.b;
                if (onHomeIconTabStateChangedListener2 != null) {
                    onHomeIconTabStateChangedListener2.onHomeIconTabStateChanged(2);
                }
            }
        }
    }

    public void h() {
        TabItem tabItem;
        ITabView iTabView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1473479080")) {
            ipChange.ipc$dispatch("1473479080", new Object[]{this});
        } else if (wh2.e(this.a) <= 0 || (tabItem = this.a.get(0)) == null || (iTabView = tabItem.tabView) == null || iTabView.getLottieAnimationView() == null) {
        } else {
            this.f = tabItem.tabView.getLottieAnimationView();
            if (TabClickStatusManager.b().a() == TabClickStatusManager.HomeTabStatus.RE_SELECTED) {
                if (this.d) {
                    a();
                } else {
                    this.f.setImageBitmap(tabItem.selectedBitmap);
                }
                TabClickStatusManager.b().c(TabClickStatusManager.HomeTabStatus.SELECTED);
            }
        }
    }

    public void i() {
        TabItem tabItem;
        ITabView iTabView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1236641951")) {
            ipChange.ipc$dispatch("-1236641951", new Object[]{this});
        } else if (wh2.e(this.a) <= 0 || (tabItem = this.a.get(0)) == null || (iTabView = tabItem.tabView) == null || iTabView.getLottieAnimationView() == null) {
        } else {
            this.f = tabItem.tabView.getLottieAnimationView();
            if (TabClickStatusManager.b().a() == TabClickStatusManager.HomeTabStatus.SELECTED) {
                if (this.d) {
                    j();
                } else {
                    this.f.setImageBitmap(tabItem.reSelectedBitmap);
                }
                TabClickStatusManager.b().c(TabClickStatusManager.HomeTabStatus.RE_SELECTED);
            }
        }
    }
}
