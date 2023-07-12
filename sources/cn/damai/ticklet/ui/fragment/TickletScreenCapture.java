package cn.damai.ticklet.ui.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.member.R$color;
import cn.damai.member.R$drawable;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.UserTicketTable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.py2;
import tb.un2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletScreenCapture extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String CAPTURE_FROM_DETAIL = "perfromDetail";
    public static String CAPTURE_FROM_VOUCHER = "perfromVoucher";
    private LinearLayout captureLayout;
    private String from;
    private String imagePath;
    private String pageName;
    private String performId;
    private String productSystemId;
    private String projectId;
    private int souvenirState;
    private UserTicketTable ticket;
    private TickletDetailInterface tickletDetailInterface;
    private TextView tv_feedback;
    private TextView tv_souvenir;
    private TextView tv_transfer;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.ui.fragment.TickletScreenCapture$a */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC2087a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2087a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-736605849")) {
                ipChange.ipc$dispatch("-736605849", new Object[]{this, view});
            } else {
                TickletScreenCapture.this.dissDialog();
            }
        }
    }

    private void actionControl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "811543514")) {
            ipChange.ipc$dispatch("811543514", new Object[]{this});
            return;
        }
        UserTicketTable userTicketTable = this.ticket;
        if (userTicketTable != null) {
            String voucherType = userTicketTable.getVoucherType();
            voucherType.hashCode();
            char c = 65535;
            switch (voucherType.hashCode()) {
                case 49:
                    if (voucherType.equals("1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 50:
                    if (voucherType.equals("2")) {
                        c = 1;
                        break;
                    }
                    break;
                case 51:
                    if (voucherType.equals("3")) {
                        c = 2;
                        break;
                    }
                    break;
                case 52:
                    if (voucherType.equals("4")) {
                        c = 3;
                        break;
                    }
                    break;
                case 53:
                    if (voucherType.equals("5")) {
                        c = 4;
                        break;
                    }
                    break;
                case 54:
                    if (voucherType.equals("6")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1599:
                    if (voucherType.equals("21")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1630:
                    if (voucherType.equals("31")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 4:
                case 5:
                case 7:
                    actionShow(true);
                    return;
                case 3:
                case 6:
                    actionShow(false);
                    return;
                default:
                    return;
            }
        }
    }

    private void actionShow(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2136622626")) {
            ipChange.ipc$dispatch("-2136622626", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            UserTicketTable userTicketTable = this.ticket;
            if (userTicketTable != null && userTicketTable.isTransferStateEnable() && "1".equals(this.ticket.getVoucherState())) {
                sb.append(getResources().getString(R$string.ticklet_ticket_capture_transfer));
                this.tv_transfer.setVisibility(0);
            } else {
                this.tv_transfer.setVisibility(8);
            }
            if (this.souvenirState == 1) {
                this.tv_souvenir.setVisibility(0);
                if (this.tv_transfer.getVisibility() == 0) {
                    this.tv_souvenir.setBackgroundResource(R$drawable.ticklet_ffe9f0_radius24_bg);
                    this.tv_souvenir.setTextColor(getResources().getColor(R$color.color_ff2d79));
                } else {
                    this.tv_souvenir.setBackgroundResource(R$drawable.submit_enable_btn_h44);
                    this.tv_souvenir.setTextColor(getResources().getColor(R$color.white));
                }
                if (!TextUtils.isEmpty(sb.toString())) {
                    sb.append("&");
                }
                sb.append(getResources().getString(R$string.ticklet_ticket_capture_souvenir));
            } else {
                this.tv_souvenir.setVisibility(8);
            }
        } else {
            this.tv_transfer.setVisibility(8);
            this.tv_souvenir.setVisibility(8);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", this.projectId);
        hashMap.put("screening_id", this.performId);
        hashMap.put("titlelabel", sb.toString());
        C0529c.e().G(this.captureLayout, "alert", "screenshot", this.pageName, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dissDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "983855228")) {
            ipChange.ipc$dispatch("983855228", new Object[]{this});
            return;
        }
        TickletDetailInterface tickletDetailInterface = this.tickletDetailInterface;
        if (tickletDetailInterface != null) {
            tickletDetailInterface.hideTickletShowAllFragment();
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "399737958") ? ((Integer) ipChange.ipc$dispatch("399737958", new Object[]{this})).intValue() : R$layout.fragment_screen_capture;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1164017310")) {
            ipChange.ipc$dispatch("-1164017310", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-353937143")) {
            ipChange.ipc$dispatch("-353937143", new Object[]{this});
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0151, code lost:
        if (r7.equals("2") == false) goto L37;
     */
    @Override // cn.damai.common.app.base.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void initView() {
        /*
            Method dump skipped, instructions count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.ticklet.ui.fragment.TickletScreenCapture.initView():void");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1088880858")) {
            ipChange.ipc$dispatch("1088880858", new Object[]{this, view});
            return;
        }
        if (view.getId() == R$id.ticklet_capture_tv_transfer) {
            TickletDetailInterface tickletDetailInterface = this.tickletDetailInterface;
            if (tickletDetailInterface != null) {
                tickletDetailInterface.captureGoTransferManagePage();
            }
            C0529c.e().x(un2.k().N(this.performId, this.projectId, this.pageName, "transfer"));
        } else if (view.getId() == R$id.ticklet_capture_tv_souvenir) {
            if (getContext() != null) {
                py2.f().l(getContext(), this.performId, this.productSystemId);
            }
            C0529c.e().x(un2.k().N(this.performId, this.projectId, this.pageName, "share_ticket"));
        } else if (view.getId() == R$id.ticklet_capture_tv_feedback) {
            TickletDetailInterface tickletDetailInterface2 = this.tickletDetailInterface;
            if (tickletDetailInterface2 != null) {
                tickletDetailInterface2.goFeedBackPage(this.imagePath);
            }
            C0529c.e().x(un2.k().N(this.performId, this.projectId, this.pageName, "help"));
        }
        dissDialog();
    }

    public void setTickletDetailInterface(TickletDetailInterface tickletDetailInterface) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1452473422")) {
            ipChange.ipc$dispatch("-1452473422", new Object[]{this, tickletDetailInterface});
        } else {
            this.tickletDetailInterface = tickletDetailInterface;
        }
    }
}
