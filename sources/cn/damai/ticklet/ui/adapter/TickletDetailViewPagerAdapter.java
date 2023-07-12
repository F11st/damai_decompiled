package cn.damai.ticklet.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import cn.damai.member.R$id;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.TickletExtraInfo;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.inteface.TickletTicketCallback;
import cn.damai.ticklet.view.TickletTicketItemDigitalTicketsView;
import cn.damai.ticklet.view.TickletTicketItemFloatLayerView;
import cn.damai.ticklet.view.TickletTicketItemView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb1;
import tb.in2;
import tb.o11;
import tb.wh2;
import tb.x30;
import tb.xh2;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletDetailViewPagerAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<UserTicketTable> b;
    private ViewGroup c;
    private String d;
    private a e;
    private int f;
    private TickletExtraInfo g;
    private TickletTicketCallback h;
    private TicketDeatilResult i;
    AutoResizeViewPager j;
    private View k;
    private int l;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ImageView imageView;
            UserTicketTable userTicketTable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1942546523")) {
                ipChange.ipc$dispatch("-1942546523", new Object[]{this});
                return;
            }
            cb1.b("TimeDown", "current time = " + x30.f(System.currentTimeMillis()));
            if (TickletDetailViewPagerAdapter.this.c != null && TickletDetailViewPagerAdapter.this.c.getChildCount() > 0) {
                for (int i = 0; i < TickletDetailViewPagerAdapter.this.c.getChildCount(); i++) {
                    View childAt = TickletDetailViewPagerAdapter.this.c.getChildAt(i);
                    if (childAt != null && (imageView = (ImageView) childAt.getTag(R$id.tag_one)) != null && (userTicketTable = (UserTicketTable) imageView.getTag(R$id.tag_two)) != null && userTicketTable.hasAvailableTicket() && !xh2.c(userTicketTable.getVerifyCode())) {
                        cb1.b("TimeDown", "ticklet time");
                        o11.c(TickletDetailViewPagerAdapter.this.a, userTicketTable, imageView, TickletDetailViewPagerAdapter.this.d);
                    }
                }
            }
            if (TickletDetailViewPagerAdapter.this.e != null) {
                TickletDetailViewPagerAdapter.this.e.cancel();
                TickletDetailViewPagerAdapter.this.e = null;
            }
            TickletDetailViewPagerAdapter tickletDetailViewPagerAdapter = TickletDetailViewPagerAdapter.this;
            tickletDetailViewPagerAdapter.e = new a(60800L, 500L);
            TickletDetailViewPagerAdapter.this.e.start();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1299582729")) {
                ipChange.ipc$dispatch("1299582729", new Object[]{this, Long.valueOf(j)});
            }
        }
    }

    public TickletDetailViewPagerAdapter(Context context) {
        this.b = new ArrayList();
        this.d = "DEFAULT";
        this.f = 0;
        this.l = -1;
        this.a = context;
        Activity activity = (Activity) context;
        a aVar = new a(60800L, 500L);
        this.e = aVar;
        aVar.start();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1864865231")) {
            ipChange.ipc$dispatch("-1864865231", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
        } else {
            viewGroup.removeView((View) obj);
        }
    }

    public void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1218727830")) {
            ipChange.ipc$dispatch("-1218727830", new Object[]{this});
            return;
        }
        a aVar = this.e;
        if (aVar != null) {
            aVar.cancel();
            this.e = null;
        }
    }

    public List<UserTicketTable> g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "536104264") ? (List) ipChange.ipc$dispatch("536104264", new Object[]{this}) : this.b;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-835698424") ? ((Integer) ipChange.ipc$dispatch("-835698424", new Object[]{this})).intValue() : this.b.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1906486777")) {
            return ((Integer) ipChange.ipc$dispatch("1906486777", new Object[]{this, obj})).intValue();
        }
        if (this.f > 0) {
            return -2;
        }
        return super.getItemPosition(obj);
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-971961343")) {
            ipChange.ipc$dispatch("-971961343", new Object[]{this});
        } else {
            f();
        }
    }

    public void i(TickletTicketCallback tickletTicketCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1099360205")) {
            ipChange.ipc$dispatch("1099360205", new Object[]{this, tickletTicketCallback});
        } else {
            this.h = tickletTicketCallback;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        TickletTicketItemView tickletTicketItemView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-846479923")) {
            return ipChange.ipc$dispatch("-846479923", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        UserTicketTable userTicketTable = this.b.get(i);
        if (in2.TICKLET_TICKET_VIEW_FLOAT_LAYER.equals(this.d)) {
            TickletTicketItemFloatLayerView tickletTicketItemFloatLayerView = new TickletTicketItemFloatLayerView(this.a);
            tickletTicketItemFloatLayerView.setCallback(this.h);
            tickletTicketItemFloatLayerView.update(userTicketTable, this.g, i, getCount());
            tickletTicketItemView = tickletTicketItemFloatLayerView;
        } else if (in2.TICKLET_TICKET_VIEW_DETAIL_NFT.equals(this.d)) {
            TickletTicketItemDigitalTicketsView tickletTicketItemDigitalTicketsView = new TickletTicketItemDigitalTicketsView(this.a);
            tickletTicketItemDigitalTicketsView.setCallback(this.h);
            tickletTicketItemDigitalTicketsView.update(userTicketTable, this.g, this.i, i, getCount());
            tickletTicketItemView = tickletTicketItemDigitalTicketsView;
        } else {
            TickletTicketItemView tickletTicketItemView2 = new TickletTicketItemView(this.a);
            tickletTicketItemView2.setCallback(this.h);
            tickletTicketItemView2.update(userTicketTable, this.g, this.i, i, getCount());
            tickletTicketItemView = tickletTicketItemView2;
        }
        tickletTicketItemView.setId(i);
        viewGroup.addView(tickletTicketItemView);
        this.c = viewGroup;
        AutoResizeViewPager autoResizeViewPager = this.j;
        if (autoResizeViewPager != null) {
            autoResizeViewPager.setObjectForPosition(tickletTicketItemView, i);
        }
        return tickletTicketItemView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1754958524") ? ((Boolean) ipChange.ipc$dispatch("1754958524", new Object[]{this, view, obj})).booleanValue() : view == obj;
    }

    public void j(List<UserTicketTable> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1826346239")) {
            ipChange.ipc$dispatch("-1826346239", new Object[]{this, list});
        } else {
            this.b = list;
        }
    }

    public void k(TicketDeatilResult ticketDeatilResult, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "614537816")) {
            ipChange.ipc$dispatch("614537816", new Object[]{this, ticketDeatilResult, str});
            return;
        }
        this.i = ticketDeatilResult;
        TickletExtraInfo tickletExtraInfo = new TickletExtraInfo();
        this.g = tickletExtraInfo;
        tickletExtraInfo.moreType = ticketDeatilResult.getMoreType();
        TickletExtraInfo tickletExtraInfo2 = this.g;
        tickletExtraInfo2.forceShowNotFace = str;
        tickletExtraInfo2.projectId = ticketDeatilResult.getProjectId();
        this.g.transferWarn = ticketDeatilResult.getTransferWarn();
        this.g.transferringNum = ticketDeatilResult.getTransferringNum();
        this.g.liveH5Url = ticketDeatilResult.getLiveH5Url();
        this.g.liveType = ticketDeatilResult.getLiveType();
        this.g.liveTicketBgUrl = ticketDeatilResult.getLiveTicketBgUrl();
        this.g.projectName = ticketDeatilResult.getProjectName();
        this.g.projectImage = ticketDeatilResult.getProjectImage();
        this.g.esouvenirEnable = ticketDeatilResult.getEsouvenirEnable();
        this.g.beginTime = ticketDeatilResult.getBeginTime().longValue();
        this.g.itemProjectId = ticketDeatilResult.getItemId();
        this.g.extAttr = ticketDeatilResult.getPerformNftExtAttr();
        this.g.memberLevel = ticketDeatilResult.getMemberLevel();
        this.g.actionTvColor = Color.parseColor(ticketDeatilResult.isNftPerform() ? "#ffffff" : "#999999");
    }

    public void l(AutoResizeViewPager autoResizeViewPager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2005733240")) {
            ipChange.ipc$dispatch("-2005733240", new Object[]{this, autoResizeViewPager});
        } else {
            this.j = autoResizeViewPager;
        }
    }

    public void m(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1914172251")) {
            ipChange.ipc$dispatch("-1914172251", new Object[]{this, str});
        } else {
            this.d = str;
        }
    }

    public void n(UserTicketTable userTicketTable) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1487952092")) {
            ipChange.ipc$dispatch("-1487952092", new Object[]{this, userTicketTable});
            return;
        }
        List<UserTicketTable> list = this.b;
        if (list == null || list.size() <= 0 || userTicketTable == null || xh2.c(userTicketTable.voucherUniqueKey)) {
            return;
        }
        Boolean bool = Boolean.FALSE;
        while (true) {
            if (i >= this.b.size()) {
                break;
            }
            UserTicketTable userTicketTable2 = this.b.get(i);
            if (userTicketTable2.voucherUniqueKey.equals(userTicketTable.voucherUniqueKey)) {
                if (!xh2.c(userTicketTable.performId)) {
                    userTicketTable2.setPerformId(userTicketTable.performId);
                }
                if (!xh2.c(userTicketTable.voucherState)) {
                    userTicketTable2.setVoucherState(userTicketTable.voucherState);
                }
                if (!xh2.c(userTicketTable.verifyCode)) {
                    userTicketTable2.setVerifyCode(userTicketTable.verifyCode);
                }
                if (!xh2.c(userTicketTable.getCheckDirection())) {
                    userTicketTable2.setCheckDirection(userTicketTable.getCheckDirection());
                }
                if (!xh2.c(userTicketTable.getCheckCountDown())) {
                    userTicketTable2.setCheckCountDown(userTicketTable.getCheckCountDown());
                }
                if (!xh2.c(userTicketTable.getTips())) {
                    userTicketTable2.setTips(userTicketTable.getTips());
                }
                if (wh2.e(userTicketTable.getSubTicketList()) > 0) {
                    userTicketTable2.setSubTicketList(userTicketTable.getSubTicketList());
                    xr.c(in2.COUPON_NUM_STATE_UPDATE, Integer.valueOf(i));
                }
                bool = Boolean.TRUE;
            } else {
                i++;
            }
        }
        if (bool.booleanValue()) {
            notifyDataSetChanged();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void notifyDataSetChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "644105353")) {
            ipChange.ipc$dispatch("644105353", new Object[]{this});
            return;
        }
        this.f = getCount();
        super.notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1880473179")) {
            ipChange.ipc$dispatch("-1880473179", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
            return;
        }
        cb1.c("DigitalTicketsView", "setPrimaryItem position=" + i);
        View view = (View) obj;
        this.k = view;
        if (i != this.l) {
            this.l = i;
            if (view instanceof TickletTicketItemDigitalTicketsView) {
                ((TickletTicketItemDigitalTicketsView) view).setShowType(TickletTicketItemDigitalTicketsView.SHOW_TYPE);
            }
        }
    }

    public TickletDetailViewPagerAdapter(Context context, String str) {
        this.b = new ArrayList();
        this.d = "DEFAULT";
        this.f = 0;
        this.l = -1;
        this.a = context;
        this.d = str;
        Activity activity = (Activity) context;
        a aVar = new a(60800L, 500L);
        this.e = aVar;
        aVar.start();
    }
}
