package cn.damai.user.brand;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.view.AttentionView;
import cn.damai.homepage.R$id;
import cn.damai.tetris.component.brand.bean.ActivityInfo;
import cn.damai.tetris.component.brand.bean.BrandHeaderInfoBean;
import cn.damai.tetris.page.AbsFragmentV2;
import cn.damai.user.brand.BrandAttentionFloatLayerView;
import cn.damai.user.star.view.ScrollAlphaListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class BrandScrollListener extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    int a = 0;
    View b;
    BrandAttentionFloatLayerView c;
    boolean d;
    Handler e;
    ScrollAlphaListener f;
    BrandHeaderInfoBean g;
    AbsFragmentV2 h;
    ActivityInfo i;
    AttentionView j;
    long k;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class a implements BrandAttentionFloatLayerView.AttentionLayerCallBack {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.user.brand.BrandAttentionFloatLayerView.AttentionLayerCallBack
        public void attentionAction() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1563582133")) {
                ipChange.ipc$dispatch("1563582133", new Object[]{this});
                return;
            }
            ActivityInfo activityInfo = BrandScrollListener.this.i;
            if (activityInfo != null && !TextUtils.isEmpty(activityInfo.couponId)) {
                if (BrandScrollListener.this.h.getActivity() != null && (BrandScrollListener.this.h.getActivity() instanceof BrandActivity)) {
                    ((BrandActivity) BrandScrollListener.this.h.getActivity()).autoFollow();
                }
            } else {
                BrandScrollListener.this.j.getRelationUpdateAndLogin();
            }
            BrandScrollListener.this.b.setVisibility(8);
            BrandScrollListener.this.c();
        }

        @Override // cn.damai.user.brand.BrandAttentionFloatLayerView.AttentionLayerCallBack
        public void closeLayer() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1914892952")) {
                ipChange.ipc$dispatch("-1914892952", new Object[]{this});
                return;
            }
            BrandScrollListener.this.b.setVisibility(8);
            BrandScrollListener.this.c();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1357933884")) {
                ipChange.ipc$dispatch("1357933884", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            View view = BrandScrollListener.this.b;
            if (view != null) {
                view.setVisibility(8);
                BrandScrollListener.this.c();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class c implements AttentionView.StateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.commonbusiness.view.AttentionView.StateListener
        public void onStateChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-701138046")) {
                ipChange.ipc$dispatch("-701138046", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 1 || i == 2) {
                BrandScrollListener.this.b.setVisibility(8);
                BrandScrollListener.this.c();
                BrandScrollListener.this.j.setStateListener(null);
                BrandScrollListener.this.g.setFavoriteFlag(i);
            }
        }
    }

    public BrandScrollListener(AbsFragmentV2 absFragmentV2, ViewGroup viewGroup, ScrollAlphaListener scrollAlphaListener, BrandHeaderInfoBean brandHeaderInfoBean, ActivityInfo activityInfo) {
        this.g = new BrandHeaderInfoBean();
        t60.a(absFragmentV2.getActivity(), 250.0f);
        this.h = absFragmentV2;
        this.f = scrollAlphaListener;
        if (brandHeaderInfoBean != null) {
            this.g = brandHeaderInfoBean;
        }
        this.i = activityInfo;
        d(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1499818064")) {
            ipChange.ipc$dispatch("-1499818064", new Object[]{this});
            return;
        }
        ActivityInfo activityInfo = this.i;
        if (activityInfo == null || TextUtils.isEmpty(activityInfo.couponId)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.k;
        HashMap hashMap = new HashMap();
        BrandHeaderInfoBean brandHeaderInfoBean = this.g;
        if (brandHeaderInfoBean != null) {
            hashMap.put("brand_id", brandHeaderInfoBean.getBid());
        }
        hashMap.put("coupon_id", this.i.couponId);
        cn.damai.common.user.c.e().C("coupon_btn", TypedValues.Custom.S_FLOAT, "brand", "1.0", currentTimeMillis, hashMap, 2201);
    }

    private void d(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1673283627")) {
            ipChange.ipc$dispatch("-1673283627", new Object[]{this, viewGroup});
            return;
        }
        this.b = viewGroup.findViewById(R$id.user_call_follow);
        BrandAttentionFloatLayerView brandAttentionFloatLayerView = new BrandAttentionFloatLayerView(viewGroup.getContext());
        this.c = brandAttentionFloatLayerView;
        ((ViewGroup) this.b).addView(brandAttentionFloatLayerView);
        if (this.b != null) {
            this.c.setCallBack(new a());
        }
        this.d = false;
        this.e = new b();
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1987721884")) {
            ipChange.ipc$dispatch("1987721884", new Object[]{this});
            return;
        }
        AttentionView attentionView = this.j;
        if (attentionView != null) {
            attentionView.cleanAttenList();
            this.j.setStateListener(null);
        }
        this.e.removeMessages(0);
        this.e = null;
    }

    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2074991257")) {
            ipChange.ipc$dispatch("-2074991257", new Object[]{this});
        } else {
            this.a = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1580421809")) {
            ipChange.ipc$dispatch("1580421809", new Object[]{this, recyclerView, Integer.valueOf(i)});
        } else {
            super.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        ScrollAlphaListener scrollAlphaListener;
        ScrollAlphaListener scrollAlphaListener2;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "504998478")) {
            ipChange.ipc$dispatch("504998478", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onScrolled(recyclerView, i, i2);
        if (this.g == null) {
            return;
        }
        int i3 = -1;
        if (recyclerView != null) {
            View childAt = recyclerView.getChildAt(0);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (childAt != null && layoutManager != null) {
                i3 = layoutManager.getPosition(childAt);
                if (i3 > 4) {
                    if (this.j == null) {
                        AttentionView attentionView = new AttentionView(this.h.getContext());
                        this.j = attentionView;
                        attentionView.setInitParams(this.g.getBid() + "", this.g.getType() + "");
                        this.j.setState(this.g.getFavoriteFlag());
                        this.j.setVisibility(8);
                        ((ViewGroup) this.b).addView(this.j);
                    }
                    if (!this.d) {
                        AttentionView attentionView2 = (AttentionView) this.h.getActivity().findViewById(R$id.brand_navbar_attention);
                        if (this.j != null && !attentionView2.followed()) {
                            this.b.setVisibility(0);
                            ActivityInfo activityInfo = this.i;
                            if (activityInfo == null || TextUtils.isEmpty(activityInfo.couponId)) {
                                str = "关注";
                            } else {
                                this.k = System.currentTimeMillis();
                                str = "关注领券";
                            }
                            this.c.update(this.g.getNickname(), str, this.g.getHeadImg());
                            this.d = true;
                            Handler handler = this.e;
                            if (handler != null) {
                                handler.sendEmptyMessageDelayed(0, 6000L);
                            }
                            attentionView2.addAttentionView(this.j);
                            this.j.setStateListener(new c());
                        }
                    }
                } else {
                    this.b.setVisibility(8);
                }
            }
        }
        int i4 = this.a - i2;
        this.a = i4;
        if ((i4 == 0 || i3 == 0) && (scrollAlphaListener = this.f) != null) {
            scrollAlphaListener.onAlphaChanged(0.0f);
        } else if (i4 >= 0 || (scrollAlphaListener2 = this.f) == null) {
        } else {
            scrollAlphaListener2.onAlphaChanged(1.0f);
        }
    }
}
