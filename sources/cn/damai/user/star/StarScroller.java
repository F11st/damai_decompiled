package cn.damai.user.star;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.view.AttentionView;
import cn.damai.homepage.R$id;
import cn.damai.tetris.component.star.bean.StarHeaderData;
import cn.damai.user.star.view.ScrollAlphaListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.jw0;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class StarScroller extends RecyclerView.OnScrollListener {
    private static transient /* synthetic */ IpChange $ipChange;
    int a = 0;
    View b;
    boolean c;
    Handler d;
    ScrollAlphaListener e;
    StarHeaderData f;
    StarIndexFragment g;
    View.OnClickListener h;
    AttentionView i;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.star.StarScroller$a */
    /* loaded from: classes17.dex */
    public class View$OnClickListenerC2706a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2706a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-532380933")) {
                ipChange.ipc$dispatch("-532380933", new Object[]{this, view});
            } else {
                StarScroller.this.b.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.star.StarScroller$b */
    /* loaded from: classes17.dex */
    public class HandlerC2707b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        HandlerC2707b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "746677843")) {
                ipChange.ipc$dispatch("746677843", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            View view = StarScroller.this.b;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.user.star.StarScroller$c */
    /* loaded from: classes9.dex */
    public class C2708c implements AttentionView.StateListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2708c() {
        }

        @Override // cn.damai.commonbusiness.view.AttentionView.StateListener
        public void onStateChanged(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-31040423")) {
                ipChange.ipc$dispatch("-31040423", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 1 || i == 2) {
                StarScroller.this.b.setVisibility(8);
                StarScroller.this.i.setStateListener(null);
                StarHeaderData starHeaderData = StarScroller.this.f;
                starHeaderData.followStatus = i;
                StarScroller.this.g.sendMsg(new cn.damai.tetris.core.msg.Message(103, starHeaderData));
            }
        }
    }

    public StarScroller(StarIndexFragment starIndexFragment, ViewGroup viewGroup, ScrollAlphaListener scrollAlphaListener, StarHeaderData starHeaderData, int i) {
        t60.a(starIndexFragment.getActivity(), 250.0f);
        this.g = starIndexFragment;
        this.e = scrollAlphaListener;
        this.f = starHeaderData;
        b(viewGroup);
    }

    private void b(ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906909204")) {
            ipChange.ipc$dispatch("-906909204", new Object[]{this, viewGroup});
            return;
        }
        View findViewById = viewGroup.findViewById(R$id.user_call_follow);
        this.b = findViewById;
        if (findViewById != null) {
            int i = R$id.user_call_follow_close;
            if (findViewById.findViewById(i) != null) {
                this.h = new View$OnClickListenerC2706a();
                this.b.findViewById(i).setOnClickListener(this.h);
            }
        }
        this.c = false;
        this.d = new HandlerC2707b();
        jw0.a(this.g.getActivity(), (ViewGroup) this.b, this.f, 2);
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "753855539")) {
            ipChange.ipc$dispatch("753855539", new Object[]{this});
            return;
        }
        View view = this.b;
        if (view != null) {
            int i = R$id.user_call_follow_close;
            if (view.findViewById(i) != null) {
                this.b.findViewById(i).setOnClickListener(null);
                this.h = null;
            }
        }
        AttentionView attentionView = this.i;
        if (attentionView != null) {
            attentionView.cleanAttenList();
            this.i.setStateListener(null);
        }
        this.d.removeMessages(0);
        this.d = null;
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2036051778")) {
            ipChange.ipc$dispatch("-2036051778", new Object[]{this});
        } else {
            this.a = 0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-283876102")) {
            ipChange.ipc$dispatch("-283876102", new Object[]{this, recyclerView, Integer.valueOf(i)});
        } else {
            super.onScrollStateChanged(recyclerView, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        ScrollAlphaListener scrollAlphaListener;
        ScrollAlphaListener scrollAlphaListener2;
        AttentionView attentionView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2050109925")) {
            ipChange.ipc$dispatch("2050109925", new Object[]{this, recyclerView, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onScrolled(recyclerView, i, i2);
        if (this.f == null) {
            return;
        }
        int i3 = -1;
        if (recyclerView != null) {
            View childAt = recyclerView.getChildAt(0);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (childAt != null && layoutManager != null) {
                i3 = layoutManager.getPosition(childAt);
                if (i3 > 10) {
                    AttentionView attentionView2 = (AttentionView) this.b.findViewById(R$id.attent_view_star_pop);
                    this.i = attentionView2;
                    attentionView2.setInitParams(this.f.id + "", this.f.targetType + "");
                    this.i.setState(this.f.followStatus);
                    if (!this.c && (attentionView = this.i) != null && !attentionView.followed()) {
                        this.b.setVisibility(0);
                        this.i.setVisibility(0);
                        this.c = true;
                        Handler handler = this.d;
                        if (handler != null) {
                            handler.sendEmptyMessageDelayed(0, 6000L);
                        }
                        AttentionView attentionView3 = (AttentionView) this.g.getActivity().findViewById(cn.damai.commonbusiness.R$id.attent_view_star);
                        if (attentionView3 != null) {
                            attentionView3.addAttentionView(this.i);
                        }
                        this.i.setStateListener(new C2708c());
                    }
                } else {
                    this.b.setVisibility(8);
                }
            }
        }
        this.a -= i2;
        Log.d("xxgetScrollState", " totalDy :" + this.a + " ， position： " + i3);
        int i4 = this.a;
        if ((i4 == 0 || i3 == 0) && (scrollAlphaListener = this.e) != null) {
            scrollAlphaListener.onAlphaChanged(0.0f);
        } else if (i4 >= 0 || (scrollAlphaListener2 = this.e) == null) {
        } else {
            scrollAlphaListener2.onAlphaChanged(1.0f);
        }
    }
}
