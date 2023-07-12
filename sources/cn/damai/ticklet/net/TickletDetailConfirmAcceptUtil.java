package cn.damai.ticklet.net;

import android.content.DialogInterface;
import android.content.Intent;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TicketAcceptTransferData;
import cn.damai.ticklet.bean.TicketTransferTicketPersonMapping;
import cn.damai.ticklet.ui.activity.TicketDeatilActivity;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.h4;
import tb.tn2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TickletDetailConfirmAcceptUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    DamaiBaseActivity activity;
    TickletTransferConfirmAcceptCallBack callBack;
    private int transferNum = 0;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface TickletTransferConfirmAcceptCallBack {
        void confirmAcceptSecondFail(ArrayList<String> arrayList);
    }

    public TickletDetailConfirmAcceptUtil(DamaiBaseActivity damaiBaseActivity) {
        this.activity = damaiBaseActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void failView(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-427385465")) {
            ipChange.ipc$dispatch("-427385465", new Object[]{this, str, str2});
        } else if ("FAIL_BIZ_FAIL_BIZ_TRANS_ERROR_ACCEPT_NO_DONATION".equals(str)) {
            new h4(this.activity).e(str2).h(this.activity.getResources().getString(R$string.ticklet_know), new DialogInterface.OnClickListener() { // from class: cn.damai.ticklet.net.TickletDetailConfirmAcceptUtil.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-491254535")) {
                        ipChange2.ipc$dispatch("-491254535", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    } else {
                        TickletDetailConfirmAcceptUtil.this.callBack.confirmAcceptSecondFail(null);
                    }
                }
            }).i(this.activity.getResources().getString(R$string.ticklet_transfer_invalid)).c(false).j();
        } else {
            ToastUtil.a().j(this.activity, str2);
        }
    }

    public void requestAcceptTransferData(ArrayList<TicketTransferTicketPersonMapping> arrayList, final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1776305772")) {
            ipChange.ipc$dispatch("1776305772", new Object[]{this, arrayList, str});
            return;
        }
        this.activity.startProgressDialog();
        TickletTransferAcceptRequest tickletTransferAcceptRequest = new TickletTransferAcceptRequest();
        tickletTransferAcceptRequest.acceptInfosStr = JSON.toJSON(arrayList).toString();
        tickletTransferAcceptRequest.request(new DMMtopRequestListener<TicketAcceptTransferData>(TicketAcceptTransferData.class) { // from class: cn.damai.ticklet.net.TickletDetailConfirmAcceptUtil.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "135819546")) {
                    ipChange2.ipc$dispatch("135819546", new Object[]{this, str2, str3});
                    return;
                }
                TickletDetailConfirmAcceptUtil.this.activity.stopProgressDialog();
                TickletDetailConfirmAcceptUtil.this.failView(str2, str3);
                tn2.c(6, str2, str3, str);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(TicketAcceptTransferData ticketAcceptTransferData) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1228985738")) {
                    ipChange2.ipc$dispatch("-1228985738", new Object[]{this, ticketAcceptTransferData});
                    return;
                }
                TickletDetailConfirmAcceptUtil.this.activity.stopProgressDialog();
                TickletDetailConfirmAcceptUtil.this.returnAcceptResult(ticketAcceptTransferData, str);
            }
        });
    }

    public void returnAcceptResult(final TicketAcceptTransferData ticketAcceptTransferData, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1698141634")) {
            ipChange.ipc$dispatch("-1698141634", new Object[]{this, ticketAcceptTransferData, str});
        } else if (ticketAcceptTransferData == null) {
        } else {
            if (ticketAcceptTransferData.allSuccess) {
                ToastUtil.f(this.activity.getResources().getString(R$string.ticklet_transfer_success_get_ticket, String.valueOf(this.transferNum)));
                Intent intent = new Intent();
                intent.putExtra(TicketDetailExtFragment.PERFORM_ID, str);
                intent.putExtra("from", TicketDeatilActivity.FROM_ACCEPT_TICKET);
                intent.setClass(this.activity, TicketDeatilActivity.class);
                this.activity.startActivity(intent);
                this.activity.finish();
                return;
            }
            DMDialog dMDialog = new DMDialog(this.activity);
            dMDialog.o(false).q(ticketAcceptTransferData.failMsg);
            dMDialog.n(this.activity.getResources().getString(R$string.ok), new DialogInterface.OnClickListener() { // from class: cn.damai.ticklet.net.TickletDetailConfirmAcceptUtil.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1460835558")) {
                        ipChange2.ipc$dispatch("-1460835558", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                    } else {
                        TickletDetailConfirmAcceptUtil.this.callBack.confirmAcceptSecondFail(ticketAcceptTransferData.failDonationOrderIdList);
                    }
                }
            }).show();
        }
    }

    public void setCallBack(TickletTransferConfirmAcceptCallBack tickletTransferConfirmAcceptCallBack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1806602157")) {
            ipChange.ipc$dispatch("1806602157", new Object[]{this, tickletTransferConfirmAcceptCallBack});
        } else {
            this.callBack = tickletTransferConfirmAcceptCallBack;
        }
    }

    public void setTransferNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1167925210")) {
            ipChange.ipc$dispatch("-1167925210", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.transferNum = i;
        }
    }
}
