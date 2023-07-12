package tb;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.nav.DMNav;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.ultron.R$drawable;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.utils.DmUltronChooseListenerImpl;
import cn.damai.ultron.view.bean.DetailInfoVO;
import cn.damai.ultron.view.bean.DmTicketDetailBean;
import cn.damai.ultron.view.bean.DmTicketPriceHasSeatBean;
import cn.damai.ultron.view.bean.DmTicketPriceNoSeatBean;
import cn.damai.ultron.view.bean.DmUltronTicketPayDetailBean;
import com.alibaba.fastjson.JSON;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class eb0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private LinearLayout a;
    private DMIconFontTextView b;
    private TextView c;
    private TextView d;
    private LinearLayout e;
    private TextView f;
    private LinearLayout g;
    private View h;
    private Context i;
    private DmUltronChooseListenerImpl<String> j;
    HashMap<String, Integer> k = new HashMap<>();
    View.OnClickListener l = new c();

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DetailInfoVO a;

        a(DetailInfoVO detailInfoVO) {
            this.a = detailInfoVO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "196328306")) {
                ipChange.ipc$dispatch("196328306", new Object[]{this, view});
            } else {
                eb0.this.e(this.a.jumpUrl);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DetailInfoVO a;

        b(DetailInfoVO detailInfoVO) {
            this.a = detailInfoVO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1987348621")) {
                ipChange.ipc$dispatch("-1987348621", new Object[]{this, view});
            } else {
                eb0.this.e(this.a.jumpUrl);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "123941748")) {
                ipChange.ipc$dispatch("123941748", new Object[]{this, view});
                return;
            }
            int id = view.getId();
            if (id != R$id.text_ok && id != R$id.ll_popup_detail) {
                if (id == R$id.ll_popup) {
                    eb0.this.c();
                    if (eb0.this.j != null) {
                        eb0.this.j.chooseItemListener("");
                        return;
                    }
                    return;
                }
                return;
            }
            eb0.this.c();
            if (eb0.this.j != null) {
                eb0.this.j.chooseItemListener("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "447436417")) {
            ipChange.ipc$dispatch("447436417", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            DMNav.from(this.i).toUri(str);
        }
    }

    private void f(DmTicketDetailBean dmTicketDetailBean) {
        ViewGroup viewGroup;
        int i;
        List<DmTicketPriceHasSeatBean> list;
        int i2;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-151536712")) {
            ipChange.ipc$dispatch("-151536712", new Object[]{this, dmTicketDetailBean});
        } else if (dmTicketDetailBean == null) {
        } else {
            List<DmTicketPriceNoSeatBean> list2 = dmTicketDetailBean.ticketPriceNoSeatList;
            List<DmTicketPriceHasSeatBean> list3 = dmTicketDetailBean.ticketPriceHasSeatList;
            int e = wh2.e(list2);
            int e2 = wh2.e(list3);
            if (e <= 0 && e2 <= 0) {
                this.d.setVisibility(8);
                this.e.setVisibility(8);
                return;
            }
            this.e.setVisibility(0);
            this.d.setVisibility(0);
            this.d.setText(dmTicketDetailBean.ticketTitle);
            this.k.clear();
            int i3 = 0;
            while (true) {
                viewGroup = null;
                if (i3 >= e2) {
                    break;
                }
                DmTicketPriceHasSeatBean dmTicketPriceHasSeatBean = list3.get(i3);
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.i).inflate(R$layout.ultron_ticket_detail_info, (ViewGroup) null, z);
                TextView textView = (TextView) linearLayout.findViewById(R$id.tv_price);
                TextView textView2 = (TextView) linearLayout.findViewById(R$id.tv_ticket_label);
                TextView textView3 = (TextView) linearLayout.findViewById(R$id.tv_ticket_orgin_price);
                TextView textView4 = (TextView) linearLayout.findViewById(R$id.tv_seat);
                TextView textView5 = (TextView) linearLayout.findViewById(R$id.tv_area);
                View findViewById = linearLayout.findViewById(R$id.line);
                View findViewById2 = linearLayout.findViewById(R$id.top_line);
                if (i3 == 0) {
                    list = list3;
                    findViewById.setVisibility(8);
                    findViewById2.setVisibility(0);
                    i2 = 8;
                } else {
                    list = list3;
                    findViewById.setVisibility(0);
                    i2 = 8;
                    findViewById2.setVisibility(8);
                }
                textView4.setText(dmTicketPriceHasSeatBean.seatDesc);
                textView5.setText(dmTicketPriceHasSeatBean.areaDesc);
                textView2.setVisibility(i2);
                if (TextUtils.isEmpty(dmTicketPriceHasSeatBean.originPrice)) {
                    textView3.setVisibility(i2);
                } else {
                    textView3.setText(dmTicketPriceHasSeatBean.originPrice);
                    textView3.setVisibility(0);
                    textView3.setPaintFlags(textView3.getPaintFlags() | 16);
                }
                if (!TextUtils.isEmpty(dmTicketPriceHasSeatBean.packageTicketID)) {
                    if (!this.k.containsKey(dmTicketPriceHasSeatBean.packageTicketID)) {
                        textView.setText(dmTicketPriceHasSeatBean.price);
                        textView2.setVisibility(0);
                        this.k.put(dmTicketPriceHasSeatBean.packageTicketID, Integer.valueOf(i3));
                    } else {
                        textView.setText("");
                        findViewById.setVisibility(8);
                        textView3.setVisibility(8);
                    }
                } else {
                    textView.setText(dmTicketPriceHasSeatBean.price);
                }
                this.e.addView(linearLayout);
                i3++;
                list3 = list;
                z = false;
            }
            int i4 = 0;
            while (i4 < e) {
                DmTicketPriceNoSeatBean dmTicketPriceNoSeatBean = list2.get(i4);
                LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(this.i).inflate(R$layout.ultron_ticket_detail_info, viewGroup, false);
                TextView textView6 = (TextView) linearLayout2.findViewById(R$id.tv_price);
                TextView textView7 = (TextView) linearLayout2.findViewById(R$id.tv_ticket_label);
                TextView textView8 = (TextView) linearLayout2.findViewById(R$id.tv_ticket_orgin_price);
                TextView textView9 = (TextView) linearLayout2.findViewById(R$id.tv_seat);
                TextView textView10 = (TextView) linearLayout2.findViewById(R$id.tv_area);
                View findViewById3 = linearLayout2.findViewById(R$id.line);
                View findViewById4 = linearLayout2.findViewById(R$id.top_line);
                if (i4 == 0) {
                    i = 8;
                    findViewById3.setVisibility(8);
                    findViewById4.setVisibility(0);
                } else {
                    i = 8;
                    findViewById3.setVisibility(0);
                    findViewById4.setVisibility(8);
                }
                textView9.setText(dmTicketPriceNoSeatBean.numTip);
                textView10.setText(dmTicketPriceNoSeatBean.amountTip);
                textView7.setVisibility(i);
                if (TextUtils.isEmpty(dmTicketPriceNoSeatBean.originPrice)) {
                    textView8.setVisibility(i);
                } else {
                    textView8.setText(dmTicketPriceNoSeatBean.originPrice);
                    textView8.setVisibility(0);
                    textView8.setPaintFlags(textView8.getPaintFlags() | 16);
                }
                if (!TextUtils.isEmpty(dmTicketPriceNoSeatBean.packageTicketID)) {
                    if (!this.k.containsKey(dmTicketPriceNoSeatBean.packageTicketID)) {
                        textView6.setText(dmTicketPriceNoSeatBean.price);
                        textView7.setVisibility(0);
                        this.k.put(dmTicketPriceNoSeatBean.packageTicketID, Integer.valueOf(i4));
                    } else {
                        textView6.setText("");
                        findViewById3.setVisibility(8);
                        textView8.setVisibility(8);
                    }
                } else {
                    textView6.setText(dmTicketPriceNoSeatBean.price);
                }
                this.e.addView(linearLayout2);
                i4++;
                viewGroup = null;
            }
        }
    }

    private void g(DmTicketDetailBean dmTicketDetailBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1910736054")) {
            ipChange.ipc$dispatch("1910736054", new Object[]{this, dmTicketDetailBean});
        } else if (dmTicketDetailBean != null) {
            List<DmUltronTicketPayDetailBean> list = dmTicketDetailBean.ticketPayDetailList;
            int e = wh2.e(list);
            if (e == 0) {
                this.f.setVisibility(8);
                this.g.setVisibility(8);
                return;
            }
            this.g.setVisibility(0);
            this.f.setVisibility(0);
            this.f.setText(dmTicketDetailBean.payDetailTitle);
            for (int i = 0; i < e; i++) {
                DmUltronTicketPayDetailBean dmUltronTicketPayDetailBean = list.get(i);
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.i).inflate(R$layout.ultron_ticket_pay_info, (ViewGroup) null, false);
                ((TextView) linearLayout.findViewById(R$id.tv_price)).setText(dmUltronTicketPayDetailBean.price);
                ((TextView) linearLayout.findViewById(R$id.tv_comment)).setText(dmUltronTicketPayDetailBean.comment);
                this.g.addView(linearLayout);
            }
        }
    }

    private void h(DetailInfoVO detailInfoVO, ImageView imageView, TextView textView, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "94049690")) {
            ipChange.ipc$dispatch("94049690", new Object[]{this, detailInfoVO, imageView, textView, Boolean.valueOf(z)});
            return;
        }
        if (!TextUtils.isEmpty(detailInfoVO.icon)) {
            imageView.setVisibility(0);
            int i = R$drawable.commonbusiness_help_icon;
            if (!z) {
                i = R$drawable.commonbusiness_help_gray_icon;
            }
            cn.damai.common.image.a.b().c(detailInfoVO.icon).i(i).c(i).g(imageView);
        } else {
            imageView.setVisibility(8);
        }
        imageView.setOnClickListener(new a(detailInfoVO));
        textView.setOnClickListener(new b(detailInfoVO));
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-587962908")) {
            ipChange.ipc$dispatch("-587962908", new Object[]{this});
            return;
        }
        View view = this.h;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void d(View view, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1017424083")) {
            ipChange.ipc$dispatch("1017424083", new Object[]{this, view, context});
            return;
        }
        this.i = context;
        this.h = view;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.ll_ticket_detail);
        this.a = linearLayout;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.height = ((int) (DisplayMetrics.getheightPixels(m62.b(context)) * 0.75d)) - m62.a(context, 60.0f);
        this.a.setLayoutParams(layoutParams);
        this.b = (DMIconFontTextView) view.findViewById(R$id.text_ok);
        this.c = (TextView) view.findViewById(R$id.tv_title);
        this.b.setOnClickListener(this.l);
        view.findViewById(R$id.ll_popup_detail).setOnClickListener(this.l);
        this.d = (TextView) view.findViewById(R$id.tv_ticket_info);
        this.e = (LinearLayout) view.findViewById(R$id.ll_ticket_info);
        this.f = (TextView) view.findViewById(R$id.tv_payment_details);
        this.g = (LinearLayout) view.findViewById(R$id.ll_payment_details);
    }

    public void i(DmUltronChooseListenerImpl<String> dmUltronChooseListenerImpl) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-809872141")) {
            ipChange.ipc$dispatch("-809872141", new Object[]{this, dmUltronChooseListenerImpl});
        } else {
            this.j = dmUltronChooseListenerImpl;
        }
    }

    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "34179807")) {
            ipChange.ipc$dispatch("34179807", new Object[]{this});
            return;
        }
        View view = this.h;
        if (view != null) {
            if (view.getVisibility() != 0) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
        }
    }

    public void k(List<DetailInfoVO> list) {
        LinearLayout linearLayout;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1837210653")) {
            ipChange.ipc$dispatch("1837210653", new Object[]{this, list});
        } else if (!cb2.d(list)) {
            this.d.setVisibility(8);
            this.f.setVisibility(8);
            this.g.removeAllViews();
            this.g.setVisibility(8);
            this.e.removeAllViews();
            this.e.setVisibility(0);
            String str = null;
            int i = 0;
            for (DetailInfoVO detailInfoVO : list) {
                if (detailInfoVO.isTitle()) {
                    linearLayout = (LinearLayout) LayoutInflater.from(this.i).inflate(R$layout.ultron_ticket_pay_new_title, (ViewGroup) null, false);
                    TextView textView = (TextView) linearLayout.findViewById(R$id.tv_price);
                    textView.setText(Html.fromHtml(detailInfoVO.title));
                    ((TextView) linearLayout.findViewById(R$id.tv_comment)).setText(Html.fromHtml(detailInfoVO.desc));
                    h(detailInfoVO, (ImageView) linearLayout.findViewById(R$id.icon), textView, true);
                    if (i == 0) {
                        linearLayout.findViewById(R$id.line).setVisibility(8);
                    }
                } else {
                    linearLayout = (LinearLayout) LayoutInflater.from(this.i).inflate(R$layout.ultron_ticket_pay_new_info, (ViewGroup) null, false);
                    LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R$id.price_layout);
                    TextView textView2 = (TextView) linearLayout.findViewById(R$id.tv_price);
                    TextView textView3 = (TextView) linearLayout.findViewById(R$id.tv_comment);
                    textView2.setText(Html.fromHtml(detailInfoVO.title));
                    h(detailInfoVO, (ImageView) linearLayout.findViewById(R$id.icon), textView2, false);
                    if (str != null && str.equals(detailInfoVO.packageTicketID)) {
                        linearLayout2.setVisibility(4);
                    } else {
                        linearLayout2.setVisibility(0);
                        str = detailInfoVO.packageTicketID;
                    }
                    textView3.setText(Html.fromHtml(detailInfoVO.desc));
                }
                this.e.addView(linearLayout);
                i++;
            }
        }
    }

    public void l(String str) {
        List<DetailInfoVO> list;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1477216600")) {
            ipChange.ipc$dispatch("1477216600", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            DmTicketDetailBean dmTicketDetailBean = (DmTicketDetailBean) JSON.parseObject(str, DmTicketDetailBean.class);
            if (dmTicketDetailBean != null && (list = dmTicketDetailBean.detailInfos) != null) {
                k(list);
                return;
            }
            if (dmTicketDetailBean != null) {
                this.c.setText(dmTicketDetailBean.topTitle);
            }
            this.e.removeAllViews();
            this.g.removeAllViews();
            f(dmTicketDetailBean);
            g(dmTicketDetailBean);
        }
    }
}
