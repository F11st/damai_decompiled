package cn.damai.ticklet.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.scriptmurder.coupon.CouponDetailFragment;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TicketDeatilResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.intf.event.IPhenixListener;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import tb.cb1;
import tb.cs;
import tb.h4;
import tb.in2;
import tb.nh0;
import tb.pl;
import tb.py2;
import tb.ui2;
import tb.un2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletDetailPerformInfo extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    Context context;
    ImageView imageViewShadow;
    View partent;
    LinearLayout passTicket;
    TextView passTicketTip;
    TextView tv_perform_name;
    TextView tv_perform_time;
    TextView tv_perform_venue;
    TUrlImageView tv_project_image;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.view.TickletDetailPerformInfo$a */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC2099a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TicketDeatilResult a;

        View$OnClickListenerC2099a(TicketDeatilResult ticketDeatilResult) {
            this.a = ticketDeatilResult;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "594195089")) {
                ipChange.ipc$dispatch("594195089", new Object[]{this, view});
                return;
            }
            TicketDeatilResult ticketDeatilResult = this.a;
            if (ticketDeatilResult == null || TextUtils.isEmpty(ticketDeatilResult.getShowTimeRangeDetail())) {
                return;
            }
            C0529c.e().x(C0528b.getInstance().e(un2.TICKLET_DETAIL_PAGE, "iteminfo", "useexplain", un2.k().t(this.a.getProjectId(), this.a.getPerformId()), Boolean.FALSE));
            TickletDetailPerformInfo.this.passDialogTip(this.a.getShowTimeRangeDetail());
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.view.TickletDetailPerformInfo$b */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC2100b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TicketDeatilResult a;

        View$OnClickListenerC2100b(TicketDeatilResult ticketDeatilResult) {
            this.a = ticketDeatilResult;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1589481838")) {
                ipChange.ipc$dispatch("-1589481838", new Object[]{this, view});
                return;
            }
            C0529c.e().x(C0528b.getInstance().e(un2.TICKLET_DETAIL_PAGE, "iteminfo", "itemimage", un2.k().t(this.a.getProjectId(), this.a.getPerformId()), Boolean.TRUE));
            if (this.a.isLivePerform() && !TextUtils.isEmpty(this.a.getLiveH5Url())) {
                py2.f().n(TickletDetailPerformInfo.this.context, this.a.getLiveH5Url());
            } else if (this.a.getUserPerformVO().isCouponPerform()) {
                TickletDetailPerformInfo.this.gotoCouponDetail(this.a.getItemId());
            } else if (TextUtils.isEmpty(this.a.getItemId())) {
            } else {
                TickletDetailPerformInfo.this.gotoProjectDetail(this.a.getItemId(), this.a.getProjectName(), this.a.getProjectImage());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.view.TickletDetailPerformInfo$c */
    /* loaded from: classes7.dex */
    public class C2101c implements IPhenixListener<ui2> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        C2101c(TickletDetailPerformInfo tickletDetailPerformInfo, ImageView imageView) {
            this.a = imageView;
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        /* renamed from: a */
        public boolean onHappen(ui2 ui2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1759149139")) {
                return ((Boolean) ipChange.ipc$dispatch("-1759149139", new Object[]{this, ui2Var})).booleanValue();
            }
            this.a.setVisibility(0);
            cb1.c("ratioTime", "success ");
            return true;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.view.TickletDetailPerformInfo$d */
    /* loaded from: classes7.dex */
    public class C2102d implements IPhenixListener<nh0> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ImageView a;

        C2102d(TickletDetailPerformInfo tickletDetailPerformInfo, ImageView imageView) {
            this.a = imageView;
        }

        @Override // com.taobao.phenix.intf.event.IPhenixListener
        /* renamed from: a */
        public boolean onHappen(nh0 nh0Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2064597002")) {
                return ((Boolean) ipChange.ipc$dispatch("2064597002", new Object[]{this, nh0Var})).booleanValue();
            }
            this.a.setVisibility(8);
            cb1.c("ratioTime", "fail ");
            return true;
        }
    }

    public TickletDetailPerformInfo(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoCouponDetail(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175280061")) {
            ipChange.ipc$dispatch("-1175280061", new Object[]{this, str});
        } else if (this.context == null || TextUtils.isEmpty(str)) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(CouponDetailFragment.COUPON_ID, str);
            DMNav.from(this.context).withExtras(bundle).toUri(NavUri.b(cs.SCRIPT_COUPON_DETAIL));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoProjectDetail(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "480875246")) {
            ipChange.ipc$dispatch("480875246", new Object[]{this, str, str2, str3});
        } else if (this.context != null) {
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, str);
            bundle.putString("projectName", str2);
            bundle.putString("projectImage", str3);
            DMNav.from(this.context).withExtras(bundle).toUri(NavUri.b(pl.PROJECT_DETAIL_PAGE));
        }
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "410684958")) {
            ipChange.ipc$dispatch("410684958", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.ticklet_deatil_perform_info, this);
        this.partent = inflate;
        this.tv_perform_name = (TextView) inflate.findViewById(R$id.tv_perform_name);
        this.tv_perform_time = (TextView) this.partent.findViewById(R$id.tv_perform_time);
        this.tv_perform_venue = (TextView) this.partent.findViewById(R$id.tv_perform_venue);
        this.tv_project_image = (TUrlImageView) this.partent.findViewById(R$id.tv_project_image);
        this.imageViewShadow = (ImageView) this.partent.findViewById(R$id.tv_project_image_shadow);
        this.passTicket = (LinearLayout) this.partent.findViewById(R$id.ticklet_ll_perform_pass_ticket);
        this.passTicketTip = (TextView) this.partent.findViewById(R$id.tv_perform_pass_ticket_tip);
    }

    private void loadPerformImage(TUrlImageView tUrlImageView, ImageView imageView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1512418691")) {
            ipChange.ipc$dispatch("-1512418691", new Object[]{this, tUrlImageView, imageView, str});
            return;
        }
        tUrlImageView.setImageUrl(str);
        tUrlImageView.succListener(new C2101c(this, imageView));
        tUrlImageView.failListener(new C2102d(this, imageView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void passDialogTip(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "626448831")) {
            ipChange.ipc$dispatch("626448831", new Object[]{this, str});
            return;
        }
        Context context = this.context;
        if (context != null) {
            new h4(context).i(getResources().getString(R$string.ticklet_ticket_pass_dialog_title)).c(false).e(str).h(getResources().getString(R$string.ticklet_know), null).j();
        }
    }

    public void update(TicketDeatilResult ticketDeatilResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1024914490")) {
            ipChange.ipc$dispatch("-1024914490", new Object[]{this, ticketDeatilResult});
        } else if (ticketDeatilResult == null) {
            setVisibility(8);
        } else {
            setVisibility(0);
            py2.F(this.tv_perform_name, ticketDeatilResult.getProjectName());
            if (TextUtils.isEmpty(ticketDeatilResult.getTimeTitle()) && ticketDeatilResult.getBeginTime().longValue() == 0) {
                this.tv_perform_time.setVisibility(8);
            } else {
                this.tv_perform_time.setVisibility(0);
                py2.D(this.context, this.tv_perform_time, ticketDeatilResult.getTimeTitle(), ticketDeatilResult.getBeginTime().longValue(), ticketDeatilResult.getChangeDateState(), ticketDeatilResult.getChangeDateReason(), ticketDeatilResult.getPerformStatus());
            }
            if (ticketDeatilResult.getLocaleName() != null) {
                this.tv_perform_venue.setVisibility(0);
                this.tv_perform_venue.setText(ticketDeatilResult.getLocaleName());
            } else {
                this.tv_perform_venue.setVisibility(8);
            }
            if (!TextUtils.isEmpty(ticketDeatilResult.getLongtermProject()) && "1".equals(ticketDeatilResult.getLongtermProject())) {
                this.passTicket.setVisibility(0);
                this.passTicket.setOnClickListener(new View$OnClickListenerC2099a(ticketDeatilResult));
            } else {
                this.passTicket.setVisibility(8);
            }
            if (wh2.j(ticketDeatilResult.getProjectImage())) {
                ticketDeatilResult.setProjectImage(in2.PROJECT_DEFAULT_IMAGE);
            }
            loadPerformImage(this.tv_project_image, this.imageViewShadow, ticketDeatilResult.getProjectImage());
            this.tv_project_image.setOnClickListener(new View$OnClickListenerC2100b(ticketDeatilResult));
        }
    }

    public TickletDetailPerformInfo(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletDetailPerformInfo(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        initView();
    }
}
