package cn.damai.ticklet.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.common.DamaiConstants;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.app.widget.ProtocolDialog;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.share.AlipayEntryActivity;
import cn.damai.commonbusiness.util.Utils;
import cn.damai.login.LoginManager;
import cn.damai.member.R$color;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TickletTransferCancelData;
import cn.damai.ticklet.bean.TickletTransferConfirmData;
import cn.damai.ticklet.bean.TickletTransferDataResult;
import cn.damai.ticklet.bean.TickletTransferManagerListExtra;
import cn.damai.ticklet.bean.TickletTransferThirdConfirmData;
import cn.damai.ticklet.bean.Tips;
import cn.damai.ticklet.inteface.TickletTransferCallback;
import cn.damai.ticklet.inteface.TickletTransferShareCallback;
import cn.damai.ticklet.net.TickletTransferManagerCancelRequest;
import cn.damai.ticklet.net.TickletTransferManagerListRequest;
import cn.damai.ticklet.net.TickletTransferManagerSponsorRequest;
import cn.damai.ticklet.ui.adapter.TickletManageAdapter;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import cn.damai.ticklet.view.TickletAnimWindow;
import cn.damai.ticklet.view.TickletTransferConfirmDialogView;
import cn.damai.ticklet.view.TickletTransferShareView;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.IRecyclerView;
import cn.damai.uikit.pulltorefresh.library.DMScrollerView;
import cn.damai.uikit.pulltorefresh.library.PullToRefreshBase;
import cn.damai.uikit.view.DMActionButtonBgView;
import cn.damai.wxapi.WXEntryActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.cb1;
import tb.h4;
import tb.in2;
import tb.rp2;
import tb.tn2;
import tb.un2;
import tb.wh2;
import tb.x30;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletTransferManageActivity extends TickletBaseActivity implements DamaiConstants, View.OnClickListener, TickletTransferCallback, PullToRefreshBase.OnRefreshListener<DMScrollerView> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int CODE_REQUEST_FACE_UNBIND_FOR_LOGIN = 2;
    private static final int ERROR_NEED_LOGIN = 100;
    private String acceptNum;
    private TickletManageAdapter adapterManage;
    private DMActionButtonBgView btnTicketTransferConfirm;
    private LinearLayout errorPageView;
    private EditText etTransferPhone;
    private RelativeLayout llTransferPhone;
    private IRecyclerView mRecyclerView;
    private View mViewStatusBarSpace;
    private TickletAnimWindow mapAppWindow;
    private String performId;
    private String productSystemId;
    private Thread thread;
    private LinearLayout ticklet_sponsor_transfer_list_layout;
    private DMActionButtonBgView ticklet_sponsor_transfer_phone_confirm;
    private RelativeLayout ticklet_transfer_ll_inputphone_layout;
    private RelativeLayout ticklet_transfer_manager_list;
    private MyThread timeThread;
    private TickletTransferDataResult transferDataResult;
    private TextView transferOneTicket;
    private DMIconFontTextView tvBack;
    private TextView tvRule;
    private TextView tvTitle;
    private int mCurrentPageIndex = 0;
    private boolean defalutChoose = true;
    private boolean isHasTicketStateChange = false;
    boolean isNoConutDown = false;
    private int visibleWindowDisplayHeight = 0;
    private final rp2 mDividerDataHolder = new rp2(3);
    private rp2 transferTips = new rp2(4);
    private rp2 transferLimit = new rp2(5);
    private rp2 transferAllows = new rp2(0);
    private rp2 transferOuts = new rp2(1);
    private rp2 transferRunnings = new rp2(2);
    private ArrayList<rp2> transferDatas = new ArrayList<>();
    private ArrayList<TickletTransferManagerListExtra> allowTransfer = new ArrayList<>();
    private ArrayList<TickletTransferManagerListExtra> outTransfer = new ArrayList<>();
    private ArrayList<TickletTransferManagerListExtra> runningTransfer = new ArrayList<>();
    Handler handler = new h();
    private String transferType = null;
    private String acceptPerson = " ";

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class MyThread implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        boolean endThread;
        List<TickletTransferManagerListExtra> runningTransfers;

        public MyThread(List<TickletTransferManagerListExtra> list) {
            this.runningTransfers = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-643823340")) {
                ipChange.ipc$dispatch("-643823340", new Object[]{this});
                return;
            }
            while (!this.endThread && TickletTransferManageActivity.this.thread != null) {
                try {
                    Message obtainMessage = TickletTransferManageActivity.this.handler.obtainMessage();
                    obtainMessage.what = 1;
                    boolean z = true;
                    for (int i = 0; i < this.runningTransfers.size(); i++) {
                        if (!TextUtils.isEmpty(this.runningTransfers.get(i).transferValidityTime)) {
                            long parseLong = Long.parseLong(this.runningTransfers.get(i).transferValidityTime) - x30.a();
                            if (parseLong >= 1000) {
                                long j = parseLong - 1000;
                                if (j <= 0) {
                                    obtainMessage.what = 2;
                                    this.endThread = true;
                                }
                                if (!TickletTransferManageActivity.this.isNoConutDown) {
                                    this.runningTransfers.get(i).realCountDown = String.valueOf(j);
                                }
                            } else {
                                obtainMessage.what = 2;
                                this.endThread = true;
                                if (!TickletTransferManageActivity.this.isNoConutDown) {
                                    this.runningTransfers.get(i).realCountDown = "0";
                                }
                            }
                            z = false;
                        }
                    }
                    TickletTransferManageActivity tickletTransferManageActivity = TickletTransferManageActivity.this;
                    if (!tickletTransferManageActivity.isNoConutDown) {
                        tickletTransferManageActivity.handler.sendMessage(obtainMessage);
                    }
                    if (z) {
                        this.endThread = true;
                        TickletTransferManageActivity.this.thread = null;
                        TickletTransferManageActivity.this.timeThread = null;
                    }
                    Thread.sleep(1000L);
                } catch (Exception unused) {
                    this.endThread = true;
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a(TickletTransferManageActivity tickletTransferManageActivity) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1603033994")) {
                ipChange.ipc$dispatch("1603033994", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1722352279")) {
                ipChange.ipc$dispatch("-1722352279", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            TickletTransferManageActivity.this.transferType = "3";
            TickletTransferManageActivity.this.phoneTransferInput();
            dialogInterface.dismiss();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-752771256")) {
                ipChange.ipc$dispatch("-752771256", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            cn.damai.common.user.c.e().x(un2.k().P("bottom", "canceltransferbtn", TickletTransferManageActivity.this.performId, TickletTransferManageActivity.this.acceptPerson, false));
            dialogInterface.dismiss();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class d implements ProtocolDialog.OnConfirmListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // cn.damai.common.app.widget.ProtocolDialog.OnConfirmListener
        public void onConfirmClick(boolean z, DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "287291874")) {
                ipChange.ipc$dispatch("287291874", new Object[]{this, Boolean.valueOf(z), dialogInterface});
            } else if (z) {
                cn.damai.common.user.c.e().x(un2.k().P("bottom", "submittransferbtn", TickletTransferManageActivity.this.performId, TickletTransferManageActivity.this.acceptPerson, false));
                if ("1".equals(TickletTransferManageActivity.this.transferType) || "2".equals(TickletTransferManageActivity.this.transferType)) {
                    TickletTransferManageActivity.this.thirdTransferConirm();
                } else {
                    TickletTransferManageActivity tickletTransferManageActivity = TickletTransferManageActivity.this;
                    tickletTransferManageActivity.confirmTransfer(tickletTransferManageActivity.acceptPerson);
                }
                dialogInterface.dismiss();
            } else {
                ToastUtil.f("请您认真阅读转送规则说明，接受后可开始使用我们的服务");
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class e implements TextWatcher {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1758219832")) {
                ipChange.ipc$dispatch("1758219832", new Object[]{this, editable});
            } else {
                TickletTransferManageActivity.this.phoneConfirmButtonState();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1927704309")) {
                ipChange.ipc$dispatch("-1927704309", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-294419669")) {
                ipChange.ipc$dispatch("-294419669", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class f implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;

        f() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1323285347")) {
                ipChange.ipc$dispatch("1323285347", new Object[]{this});
                return;
            }
            Rect rect = new Rect();
            TickletTransferManageActivity.this.ticklet_transfer_manager_list.getWindowVisibleDisplayFrame(rect);
            if (TickletTransferManageActivity.this.visibleWindowDisplayHeight > rect.bottom) {
                TickletTransferManageActivity.this.ticklet_transfer_ll_inputphone_layout.setVisibility(0);
                TickletTransferManageActivity.this.llTransferPhone.setVisibility(8);
                cb1.b("TestCostomUIActivity", "输入框show");
                return;
            }
            if (TickletTransferManageActivity.this.isCheckTransferEnabled()) {
                TickletTransferManageActivity.this.etTransferPhone.setText("");
                TickletTransferManageActivity.this.ticklet_transfer_ll_inputphone_layout.setVisibility(8);
                TickletTransferManageActivity.this.llTransferPhone.setVisibility(0);
            } else {
                TickletTransferManageActivity.this.etTransferPhone.setText("");
                TickletTransferManageActivity.this.ticklet_transfer_ll_inputphone_layout.setVisibility(8);
                TickletTransferManageActivity.this.llTransferPhone.setVisibility(8);
            }
            cb1.b("TestCostomUIActivity", "输入框hide");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class g implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        g(String str) {
            this.a = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-524205110")) {
                ipChange.ipc$dispatch("-524205110", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                TickletTransferManageActivity.this.cancelTransfer(this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class h extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "869586953")) {
                ipChange.ipc$dispatch("869586953", new Object[]{this, message});
                return;
            }
            int i = message.what;
            if (i == 1) {
                TickletTransferManageActivity.this.adapterManage.b(2);
            } else if (i == 2) {
                TickletTransferManageActivity.this.onRefresh();
            }
            super.handleMessage(message);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class i implements TickletTransferShareCallback {
        private static transient /* synthetic */ IpChange $ipChange;

        i() {
        }

        @Override // cn.damai.ticklet.inteface.TickletTransferShareCallback
        public void alipay() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "334629900")) {
                ipChange.ipc$dispatch("334629900", new Object[]{this});
                return;
            }
            TickletTransferManageActivity.this.transferType = "2";
            TickletTransferManageActivity tickletTransferManageActivity = TickletTransferManageActivity.this;
            tickletTransferManageActivity.transferTypeDeal("1".equals(((TickletTransferManagerListExtra) tickletTransferManageActivity.getCheckedTransferInfo().get(0)).isBindCert), TickletTransferManageActivity.this.getResources().getString(R$string.ticklet_transfer_alipay_friend));
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            un2 k = un2.k();
            e.x(k.Q("bottom", "transfer_item_" + String.valueOf(1), TickletTransferManageActivity.this.performId, "支付宝", false));
        }

        @Override // cn.damai.ticklet.inteface.TickletTransferShareCallback
        public void damaiPhone() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1602792000")) {
                ipChange.ipc$dispatch("-1602792000", new Object[]{this});
                return;
            }
            TickletTransferManageActivity.this.transferType = "3";
            TickletTransferManageActivity.this.phoneTransferInput();
            if (TickletTransferManageActivity.this.mapAppWindow != null) {
                TickletTransferManageActivity.this.mapAppWindow.callSuperDismiss();
            }
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            un2 k = un2.k();
            e.x(k.Q("bottom", "transfer_item_" + String.valueOf(2), TickletTransferManageActivity.this.performId, "手机", false));
        }

        @Override // cn.damai.ticklet.inteface.TickletTransferShareCallback
        public void weChat() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "315983248")) {
                ipChange.ipc$dispatch("315983248", new Object[]{this});
                return;
            }
            TickletTransferManageActivity.this.transferType = "1";
            TickletTransferManageActivity tickletTransferManageActivity = TickletTransferManageActivity.this;
            tickletTransferManageActivity.transferTypeDeal("1".equals(((TickletTransferManagerListExtra) tickletTransferManageActivity.getCheckedTransferInfo().get(0)).isBindCert), TickletTransferManageActivity.this.getResources().getString(R$string.ticklet_transfer_weixin_friend));
            cn.damai.common.user.c e = cn.damai.common.user.c.e();
            un2 k = un2.k();
            e.x(k.Q("bottom", "transfer_item_" + String.valueOf(0), TickletTransferManageActivity.this.performId, "微信", false));
        }
    }

    private void alipayImp(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1781008933")) {
            ipChange.ipc$dispatch("1781008933", new Object[]{this, str, str2, str3});
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("title", str);
        intent.putExtra("message", "");
        intent.putExtra("imageurl", str2);
        intent.putExtra("producturl", str3);
        intent.setClass(this, AlipayEntryActivity.class);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelTransfer(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1577158746")) {
            ipChange.ipc$dispatch("-1577158746", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            startProgressDialog();
            TickletTransferManagerCancelRequest tickletTransferManagerCancelRequest = new TickletTransferManagerCancelRequest();
            tickletTransferManagerCancelRequest.transferRecordId = str;
            tickletTransferManagerCancelRequest.request(new DMMtopRequestListener<TickletTransferCancelData>(TickletTransferCancelData.class) { // from class: cn.damai.ticklet.ui.activity.TickletTransferManageActivity.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str2, String str3) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-877888920")) {
                        ipChange2.ipc$dispatch("-877888920", new Object[]{this, str2, str3});
                        return;
                    }
                    TickletTransferManageActivity.this.returnSponsorCancelFailResult(str2, str3);
                    tn2.c(2, str2, str3, TickletTransferManageActivity.this.performId);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(TickletTransferCancelData tickletTransferCancelData) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-329556878")) {
                        ipChange2.ipc$dispatch("-329556878", new Object[]{this, tickletTransferCancelData});
                    } else {
                        TickletTransferManageActivity.this.returnCancelTransfer(tickletTransferCancelData);
                    }
                }
            });
        }
    }

    private void cardTransferDialog(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "927315112")) {
            ipChange.ipc$dispatch("927315112", new Object[]{this, str});
            return;
        }
        DMDialog dMDialog = new DMDialog(this);
        dMDialog.v(getResources().getString(R$string.ticklet_transfer_cardId_share_tip)).q(getResources().getString(R$string.ticklet_transfer_cardId_share_content, str)).n(getString(R$string.ticklet_transfer_phone_share), new b()).i(getString(R$string.ticklet_know), new a(this));
        dMDialog.b(false);
        dMDialog.show();
    }

    private void confirmButtonState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1780081538")) {
            ipChange.ipc$dispatch("1780081538", new Object[]{this});
        } else if (this.adapterManage != null) {
            if (getCheckedTransferInfo() != null && getCheckedTransferInfo().size() > 0) {
                this.btnTicketTransferConfirm.setBackground(true);
            } else {
                this.btnTicketTransferConfirm.setBackground(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void confirmTransfer(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1796983944")) {
            ipChange.ipc$dispatch("1796983944", new Object[]{this, str});
            return;
        }
        String str2 = null;
        ArrayList<TickletTransferManagerListExtra> checkedTransferInfo = getCheckedTransferInfo();
        if (wh2.e(checkedTransferInfo) > 0 && checkedTransferInfo.get(0) != null) {
            str2 = checkedTransferInfo.get(0).voucherUniqueKey;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        startProgressDialog();
        TickletTransferManagerSponsorRequest tickletTransferManagerSponsorRequest = new TickletTransferManagerSponsorRequest();
        tickletTransferManagerSponsorRequest.targetMobile = str;
        tickletTransferManagerSponsorRequest.voucherUniqueKey = str2;
        tickletTransferManagerSponsorRequest.channelId = "3";
        tickletTransferManagerSponsorRequest.request(new DMMtopRequestListener<TickletTransferConfirmData>(TickletTransferConfirmData.class) { // from class: cn.damai.ticklet.ui.activity.TickletTransferManageActivity.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str3, String str4) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-885648279")) {
                    ipChange2.ipc$dispatch("-885648279", new Object[]{this, str3, str4});
                    return;
                }
                TickletTransferManageActivity.this.returnSponsorCancelFailResult(str3, str4);
                tn2.c(3, str3, str4, TickletTransferManageActivity.this.performId);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(TickletTransferConfirmData tickletTransferConfirmData) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1551551377")) {
                    ipChange2.ipc$dispatch("-1551551377", new Object[]{this, tickletTransferConfirmData});
                } else {
                    TickletTransferManageActivity.this.returnSponsorTransferTicketResult();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<TickletTransferManagerListExtra> getCheckedTransferInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1669586863")) {
            return (ArrayList) ipChange.ipc$dispatch("-1669586863", new Object[]{this});
        }
        ArrayList<TickletTransferManagerListExtra> arrayList = new ArrayList<>();
        ArrayList<TickletTransferManagerListExtra> arrayList2 = this.allowTransfer;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            Iterator<TickletTransferManagerListExtra> it = this.allowTransfer.iterator();
            while (it.hasNext()) {
                TickletTransferManagerListExtra next = it.next();
                if (next.isCheck) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    private void initIRecyclerView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-571560084")) {
            ipChange.ipc$dispatch("-571560084", new Object[]{this});
            return;
        }
        TickletManageAdapter tickletManageAdapter = new TickletManageAdapter(this);
        this.adapterManage = tickletManageAdapter;
        tickletManageAdapter.e(this);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.adapterManage.setData(this.transferDatas);
        this.mRecyclerView.setAdapter(this.adapterManage);
        this.mRecyclerView.setRefreshEnabled(false);
        this.mRecyclerView.setLoadMoreEnabled(false);
        this.mRecyclerView.setIsAutoToDefault(false);
        this.mRecyclerView.setOnLoadMoreListener(this);
        this.mRecyclerView.getLoadMoreFooterView().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCheckTransferEnabled() {
        TickletTransferDataResult tickletTransferDataResult;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1795534451")) {
            return ((Boolean) ipChange.ipc$dispatch("-1795534451", new Object[]{this})).booleanValue();
        }
        ArrayList<TickletTransferManagerListExtra> arrayList = this.allowTransfer;
        return arrayList != null && arrayList.size() > 0 && (tickletTransferDataResult = this.transferDataResult) != null && "1".equals(tickletTransferDataResult.transferState);
    }

    private boolean isNeedRefreshCode(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "530894863") ? ((Boolean) ipChange.ipc$dispatch("530894863", new Object[]{this, str})).booleanValue() : "FAIL_BIZ_FAIL_BIZ_TRANS_ERROR_NOT_SUPPORT_DONATION".equals(str) || "FAIL_BIZ_FAIL_BIZ_TRANS_ERROR_NO_TRANSFERRABLE_TICK".equals(str) || "FAIL_BIZ_FAIL_BIZ_TRANS_ERROR_ACCEPT_NO_DONATION".equals(str);
    }

    private void notifyData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1832332786")) {
            ipChange.ipc$dispatch("-1832332786", new Object[]{this});
            return;
        }
        this.transferDatas.clear();
        if ("1".equals(this.transferDataResult.transferState)) {
            Tips tips = this.transferDataResult.transferTips;
            if (tips != null && !TextUtils.isEmpty(tips.getText())) {
                this.transferTips.k(this.transferDataResult.transferTips);
                this.transferTips.h(this.transferDataResult.transferTips.getText());
                this.transferDatas.add(this.transferTips);
            }
            if (this.allowTransfer.size() > 0) {
                this.transferAllows.g(this.allowTransfer);
                this.transferAllows.h(getResources().getString(R$string.ticklet_transfer_allow_title));
                this.transferDatas.add(this.transferAllows);
                this.transferDatas.add(this.mDividerDataHolder);
                if (this.transferAllows.a().size() > 0 && this.defalutChoose) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.transferAllows.a().size()) {
                            i2 = -1;
                            break;
                        } else if (!"1".equals(this.transferAllows.a().get(i2).topLimitFlag)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 != -1 && this.transferAllows.a().get(i2) != null) {
                        this.transferAllows.a().get(i2).isCheck = true;
                        this.defalutChoose = false;
                    }
                }
            }
            if (this.runningTransfer.size() > 0) {
                this.transferRunnings.j(this.runningTransfer);
                this.transferRunnings.h(getResources().getString(R$string.ticklet_transfer_running_title));
                this.transferDatas.add(this.transferRunnings);
                this.transferDatas.add(this.mDividerDataHolder);
            }
        } else if ("0".equals(this.transferDataResult.transferState)) {
            this.transferDatas.add(this.transferLimit);
        }
        if (this.outTransfer.size() > 0) {
            this.transferOuts.i(this.outTransfer);
            this.transferOuts.h(getResources().getString(R$string.ticklet_transfer_success_title));
            this.transferDatas.add(this.transferOuts);
            this.transferDatas.add(this.mDividerDataHolder);
        }
    }

    private void onBackPresss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1890074411")) {
            ipChange.ipc$dispatch("1890074411", new Object[]{this});
            return;
        }
        if (this.isHasTicketStateChange) {
            setResult(-1);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void phoneConfirmButtonState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1338301924")) {
            ipChange.ipc$dispatch("-1338301924", new Object[]{this});
            return;
        }
        String trim = this.etTransferPhone.getText().toString().trim();
        if (!TextUtils.isEmpty(trim) && trim.length() > 10 && getCheckedTransferInfo() != null && getCheckedTransferInfo().size() > 0) {
            this.ticklet_sponsor_transfer_phone_confirm.setBackground(true);
        } else {
            this.ticklet_sponsor_transfer_phone_confirm.setBackground(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void phoneTransferInput() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-168352752")) {
            ipChange.ipc$dispatch("-168352752", new Object[]{this});
            return;
        }
        Rect rect = new Rect();
        this.ticklet_transfer_manager_list.getWindowVisibleDisplayFrame(rect);
        this.visibleWindowDisplayHeight = rect.bottom;
        this.etTransferPhone.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) this.etTransferPhone.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(0, 2);
        }
    }

    private void refreshViewByDataChange() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1176763224")) {
            ipChange.ipc$dispatch("1176763224", new Object[]{this});
        } else if (this.outTransfer.size() <= 0 && "0".equals(this.transferDataResult.transferState)) {
            showLimitPage();
        } else {
            showViewByTransferNum(isCheckTransferEnabled());
            this.ticklet_sponsor_transfer_list_layout.setVisibility(0);
            this.errorPageView.setVisibility(8);
            confirmButtonState();
            this.adapterManage.a();
            if (!"0".equals(this.transferDataResult.transferState) || this.mCurrentPageIndex <= 0) {
                return;
            }
            new h4(this).i(getResources().getString(R$string.ticklet_transfer_stop_tip_title)).c(false).e(getResources().getString(R$string.ticklet_transfer_stop_tip_text)).h(getResources().getString(R$string.ticklet_know), null).j();
        }
    }

    private void requestDetailData(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1806219999")) {
            ipChange.ipc$dispatch("1806219999", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        if (!z) {
            MyThread myThread = this.timeThread;
            if (myThread != null) {
                myThread.endThread = true;
            }
            this.errorPageView.setVisibility(8);
            this.mCurrentPageIndex = 0;
            this.transferDataResult = null;
            if (z2) {
                startProgressDialog();
            }
        }
        TickletTransferManagerListRequest tickletTransferManagerListRequest = new TickletTransferManagerListRequest();
        if (!LoginManager.k().q()) {
            ToastUtil.i("登录失效");
            LoginManager.k().x(this, new Intent(), 100);
        }
        tickletTransferManagerListRequest.performId = this.performId;
        tickletTransferManagerListRequest.productSystemId = this.productSystemId;
        tickletTransferManagerListRequest.request(new DMMtopRequestListener<TickletTransferDataResult>(TickletTransferDataResult.class) { // from class: cn.damai.ticklet.ui.activity.TickletTransferManageActivity.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-870129561")) {
                    ipChange2.ipc$dispatch("-870129561", new Object[]{this, str, str2});
                    return;
                }
                TickletTransferManageActivity.this.stopProgressDialog();
                TickletTransferManageActivity.this.error(str, str2, "mtop.damai.wireless.ticklet2.transfer.query");
                tn2.c(1, str, str2, TickletTransferManageActivity.this.performId);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(TickletTransferDataResult tickletTransferDataResult) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "564754030")) {
                    ipChange2.ipc$dispatch("564754030", new Object[]{this, tickletTransferDataResult});
                    return;
                }
                TickletTransferManageActivity.this.stopProgressDialog();
                TickletTransferManageActivity.this.returnTransferData(tickletTransferDataResult);
            }
        });
    }

    private void resumeView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1815730225")) {
            ipChange.ipc$dispatch("-1815730225", new Object[]{this});
            return;
        }
        this.errorPageView.setVisibility(0);
        this.ticklet_sponsor_transfer_list_layout.setVisibility(8);
        this.llTransferPhone.setVisibility(8);
        this.ticklet_transfer_ll_inputphone_layout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnSponsorCancelFailResult(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-69697858")) {
            ipChange.ipc$dispatch("-69697858", new Object[]{this, str, str2});
            return;
        }
        stopProgressDialog();
        this.acceptNum = "";
        if (isNeedRefreshCode(str)) {
            onRefresh();
        }
        ToastUtil.f(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnSponsorTransferTicketResult() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1935831445")) {
            ipChange.ipc$dispatch("-1935831445", new Object[]{this});
            return;
        }
        stopProgressDialog();
        if ("3".equals(this.transferType)) {
            ToastUtil.f(getResources().getString(R$string.ticklet_transfer_success));
        }
        this.etTransferPhone.setText("");
        this.acceptNum = "";
        onRefresh();
        this.isHasTicketStateChange = true;
    }

    private void showEmptyPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-95851894")) {
            ipChange.ipc$dispatch("-95851894", new Object[]{this});
            return;
        }
        if (this.adapterManage.getItemCount() != 0) {
            this.adapterManage.clear();
        }
        this.ticklet_sponsor_transfer_list_layout.setVisibility(8);
        this.errorPageView.setVisibility(0);
        onResponseError(3, getString(R$string.ticklet_transfer_ticket_no_data), "", "", this.errorPageView, true);
    }

    private void showErrorPage(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1505927667")) {
            ipChange.ipc$dispatch("-1505927667", new Object[]{this, str, str2, str3});
            return;
        }
        resumeView();
        if (isNeedRefreshCode(str2)) {
            onResponseError(3, str, "", "", this.errorPageView, true);
        } else {
            onResponseError(str, str2, str3, this.errorPageView, true);
        }
    }

    private void showLimitPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1721815972")) {
            ipChange.ipc$dispatch("-1721815972", new Object[]{this});
            return;
        }
        resumeView();
        View inflate = getLayoutInflater().inflate(R$layout.ticklet_transfer_limit_big_item, (ViewGroup) null);
        inflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.errorPageView.removeAllViews();
        this.errorPageView.addView(inflate);
    }

    private void showTickletTransferDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1848729173")) {
            ipChange.ipc$dispatch("1848729173", new Object[]{this});
            return;
        }
        ArrayList<TickletTransferManagerListExtra> checkedTransferInfo = getCheckedTransferInfo();
        if (checkedTransferInfo == null || checkedTransferInfo.isEmpty()) {
            return;
        }
        showTransferConfirmDialog();
    }

    private void showTransferConfirmDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2046147817")) {
            ipChange.ipc$dispatch("2046147817", new Object[]{this});
            return;
        }
        if ("1".equals(this.transferType)) {
            this.acceptPerson = getResources().getString(R$string.ticklet_transfer_weixin_friend);
        } else if ("2".equals(this.transferType)) {
            this.acceptPerson = getResources().getString(R$string.ticklet_transfer_alipay_friend);
        } else {
            this.acceptPerson = this.acceptNum;
        }
        Tips tips = this.transferDataResult.transferProtocolTips;
        String text = tips != null ? tips.getText() : null;
        String string = getResources().getString(R$string.ticklet_transfer_dialog_title);
        TickletTransferConfirmDialogView tickletTransferConfirmDialogView = new TickletTransferConfirmDialogView(this);
        tickletTransferConfirmDialogView.setData(getCheckedTransferInfo().size(), this.acceptPerson, text);
        SpannableString spannableString = new SpannableString(getResources().getString(R$string.ticklet_detail_ticket_rule_tip));
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R$color.color_ff2d79)), 0, spannableString.length(), 33);
        ProtocolDialog C = ProtocolDialog.C(this, string, null, spannableString, getResources().getString(R$string.ticklet_transfer_cancel_button_thought), -16777216, new c(), getString(R$string.ticklet_transfer_ticket_agree), Color.parseColor("#ff2d79"), new d(), null);
        C.u(tickletTransferConfirmDialogView);
        C.show();
    }

    private void showViewByTransferNum(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679127635")) {
            ipChange.ipc$dispatch("-1679127635", new Object[]{this, Boolean.valueOf(z)});
        } else if (!z) {
            this.llTransferPhone.setVisibility(8);
        } else {
            this.llTransferPhone.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void thirdTransferConirm() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1465123253")) {
            ipChange.ipc$dispatch("1465123253", new Object[]{this});
            return;
        }
        String str = null;
        ArrayList<TickletTransferManagerListExtra> checkedTransferInfo = getCheckedTransferInfo();
        if (wh2.e(checkedTransferInfo) > 0 && checkedTransferInfo.get(0) != null) {
            str = checkedTransferInfo.get(0).voucherUniqueKey;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        startProgressDialog();
        TickletTransferManagerSponsorRequest tickletTransferManagerSponsorRequest = new TickletTransferManagerSponsorRequest();
        tickletTransferManagerSponsorRequest.voucherUniqueKey = str;
        tickletTransferManagerSponsorRequest.channelId = this.transferType;
        tickletTransferManagerSponsorRequest.request(new DMMtopRequestListener<TickletTransferThirdConfirmData>(TickletTransferThirdConfirmData.class) { // from class: cn.damai.ticklet.ui.activity.TickletTransferManageActivity.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-893407638")) {
                    ipChange2.ipc$dispatch("-893407638", new Object[]{this, str2, str3});
                    return;
                }
                TickletTransferManageActivity.this.returnSponsorCancelFailResult(str2, str3);
                tn2.c(3, str2, str3, TickletTransferManageActivity.this.performId);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(TickletTransferThirdConfirmData tickletTransferThirdConfirmData) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1935255883")) {
                    ipChange2.ipc$dispatch("-1935255883", new Object[]{this, tickletTransferThirdConfirmData});
                    return;
                }
                TickletTransferManageActivity.this.stopProgressDialog();
                if (tickletTransferThirdConfirmData.optResult) {
                    if (!TextUtils.isEmpty(tickletTransferThirdConfirmData.appletUrl)) {
                        TickletTransferManageActivity.this.thirdTransferShare(tickletTransferThirdConfirmData);
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("三方转送失败 transferType=");
                    sb.append(TickletTransferManageActivity.this.transferType);
                    sb.append(" voucherUniqueKey=");
                    sb.append(TickletTransferManageActivity.this.getCheckedTransferInfo().size() > 0 ? ((TickletTransferManagerListExtra) TickletTransferManageActivity.this.getCheckedTransferInfo().get(0)).voucherUniqueKey : "");
                    tn2.c(7, "", sb.toString(), TickletTransferManageActivity.this.performId);
                }
                TickletTransferManageActivity.this.returnSponsorTransferTicketResult();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void thirdTransferShare(TickletTransferThirdConfirmData tickletTransferThirdConfirmData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-468142284")) {
            ipChange.ipc$dispatch("-468142284", new Object[]{this, tickletTransferThirdConfirmData});
            return;
        }
        TickletTransferDataResult tickletTransferDataResult = this.transferDataResult;
        if (tickletTransferDataResult != null) {
            String str = tickletTransferDataResult.projectImage;
            if (TextUtils.isEmpty(str)) {
                str = in2.PROJECT_DEFAULT_IMAGE;
            }
            if ("1".equals(this.transferType)) {
                weChatImp(tickletTransferThirdConfirmData.linkTitle, str, tickletTransferThirdConfirmData.appletUrl);
            } else if ("2".equals(this.transferType)) {
                alipayImp(tickletTransferThirdConfirmData.linkTitle, str, tickletTransferThirdConfirmData.appletUrl);
            }
        }
    }

    private void transferPhoneImp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "806500184")) {
            ipChange.ipc$dispatch("806500184", new Object[]{this});
            return;
        }
        String trim = this.etTransferPhone.getText().toString().trim();
        cn.damai.common.user.c.e().x(un2.k().P("bottom", "submittransfer", this.performId, trim, false));
        if (TextUtils.isEmpty(trim)) {
            ToastUtil.h(R$string.ticklet_transfer_phone_tip);
        } else if (getCheckedTransferInfo().size() == 0) {
            ToastUtil.h(R$string.ticklet_transfer_person_choose_tip);
        } else {
            this.acceptNum = trim;
            showTickletTransferDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transferTypeDeal(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2137501042")) {
            ipChange.ipc$dispatch("-2137501042", new Object[]{this, Boolean.valueOf(z), str});
        } else if (z) {
            cardTransferDialog(str);
            TickletAnimWindow tickletAnimWindow = this.mapAppWindow;
            if (tickletAnimWindow != null) {
                tickletAnimWindow.dismiss();
            }
        } else if ("1".equals(this.transferType)) {
            if (Utils.b(this, false)) {
                showTickletTransferDialog();
                TickletAnimWindow tickletAnimWindow2 = this.mapAppWindow;
                if (tickletAnimWindow2 != null) {
                    tickletAnimWindow2.dismiss();
                }
            }
        } else if ("2".equals(this.transferType) && Utils.a(this, false)) {
            showTickletTransferDialog();
            TickletAnimWindow tickletAnimWindow3 = this.mapAppWindow;
            if (tickletAnimWindow3 != null) {
                tickletAnimWindow3.dismiss();
            }
        }
    }

    private void weChatImp(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1725078817")) {
            ipChange.ipc$dispatch("1725078817", new Object[]{this, str, str2, str3});
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("title", str);
        intent.putExtra("message", "");
        intent.putExtra("imageurl", str2);
        intent.putExtra("producturl", str3);
        intent.putExtra("miniprogram", true);
        intent.setClass(this, WXEntryActivity.class);
        startActivity(intent);
    }

    @Override // cn.damai.ticklet.inteface.TickletTransferCallback
    public void callCancelTransfer(String str, int i2, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "336774821")) {
            ipChange.ipc$dispatch("336774821", new Object[]{this, str, Integer.valueOf(i2), str2});
            return;
        }
        cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
        un2 k = un2.k();
        e2.x(k.P("list", "canceltransfer_" + String.valueOf(i2), this.performId, str2, false));
        DMDialog dMDialog = new DMDialog(this);
        Resources resources = getResources();
        int i3 = R$string.ticklet_transfer_cancel_title;
        dMDialog.v(resources.getString(i3)).q(getResources().getString(R$string.ticklet_transfer_cancel_message_tip)).m(getResources().getString(i3), Color.parseColor("#111111"), new g(str)).h(getResources().getString(R$string.ticklet_transfer_cancel_button_thought), Color.parseColor("#111111"), null);
        dMDialog.show();
    }

    @Override // cn.damai.ticklet.inteface.TickletTransferCallback
    public void chooseUpdateView(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1280491353")) {
            ipChange.ipc$dispatch("-1280491353", new Object[]{this, Integer.valueOf(i2)});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("screening_id", this.performId);
        TickletTransferManagerListExtra tickletTransferManagerListExtra = this.allowTransfer.get(i2);
        if (tickletTransferManagerListExtra.isCheck) {
            tickletTransferManagerListExtra.isCheck = false;
            hashMap.put("status", "0");
        } else {
            if (getCheckedTransferInfo() != null && getCheckedTransferInfo().size() > 0) {
                getCheckedTransferInfo().get(0).isCheck = false;
            }
            tickletTransferManagerListExtra.isCheck = true;
            hashMap.put("status", "1");
        }
        cn.damai.common.user.c.e().x(cn.damai.common.user.b.getInstance().e(un2.TICKLET_TRANSFER_MANAGER_PAGE, "to_transfer", "select_ticket", hashMap, Boolean.FALSE));
        this.adapterManage.a();
        confirmButtonState();
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-314948951")) {
            ipChange.ipc$dispatch("-314948951", new Object[]{this, Integer.valueOf(i2)});
        }
    }

    public void error(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1866396159")) {
            ipChange.ipc$dispatch("1866396159", new Object[]{this, str, str2, str3});
            return;
        }
        stopProgressDialog();
        if (this.mCurrentPageIndex == 0) {
            showErrorPage(str2, str, str3);
        } else {
            ToastUtil.f(str);
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "946039201") ? ((Integer) ipChange.ipc$dispatch("946039201", new Object[]{this})).intValue() : R$layout.ticklet_sponsor_transfer_manager_layout;
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1695412730")) {
            ipChange.ipc$dispatch("1695412730", new Object[]{this, Integer.valueOf(i2)});
        } else {
            onRefresh();
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-477435764")) {
            ipChange.ipc$dispatch("-477435764", new Object[]{this});
            return;
        }
        hideBaseLayout();
        this.mViewStatusBarSpace = findViewById(R$id.ticklet_title_bar_space_view);
        this.ticklet_transfer_manager_list = (RelativeLayout) findViewById(R$id.ticklet_transfer_manager_list);
        this.tvBack = (DMIconFontTextView) findViewById(R$id.ticklet_iv_left_icon);
        this.tvTitle = (TextView) findViewById(R$id.ticklet_title_text);
        this.tvRule = (TextView) findViewById(R$id.ticklet_rule_text_url);
        this.errorPageView = (LinearLayout) findViewById(R$id.errorPageView);
        this.mRecyclerView = (IRecyclerView) findViewById(R$id.ticklet_sponsor_transfer_list);
        this.ticklet_sponsor_transfer_list_layout = (LinearLayout) findViewById(R$id.ticklet_sponsor_transfer_list_layout);
        this.llTransferPhone = (RelativeLayout) findViewById(R$id.ticklet_transfer_ll_layout);
        this.transferOneTicket = (TextView) findViewById(R$id.ticklet_transfer_one_ticket_tip);
        this.btnTicketTransferConfirm = (DMActionButtonBgView) findViewById(R$id.ticklet_sponsor_transfer_confirm);
        this.ticklet_transfer_ll_inputphone_layout = (RelativeLayout) findViewById(R$id.ticklet_transfer_ll_inputphone_layout);
        this.etTransferPhone = (EditText) findViewById(R$id.ticklet_sponsor_transfer_phone);
        this.ticklet_sponsor_transfer_phone_confirm = (DMActionButtonBgView) findViewById(R$id.ticklet_sponsor_transfer_phone_confirm);
        initIRecyclerView();
        this.tvRule.setText("细则");
        this.tvRule.setVisibility(8);
        this.tvBack.setOnClickListener(this);
        this.btnTicketTransferConfirm.setOnClickListener(this);
        this.ticklet_sponsor_transfer_phone_confirm.setOnClickListener(this);
        this.tvTitle.setText("转送管理");
        this.btnTicketTransferConfirm.setBackground(false);
        this.btnTicketTransferConfirm.update(getResources().getString(R$string.ticklet_sponsor_transfer_ticket_confirm));
        this.ticklet_sponsor_transfer_phone_confirm.setBackground(false);
        this.ticklet_sponsor_transfer_phone_confirm.getEventTv().setTextSize(1, 14.0f);
        this.ticklet_sponsor_transfer_phone_confirm.update(getResources().getString(R$string.ticklet_transfer_phone_share_action));
        this.etTransferPhone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
        this.etTransferPhone.addTextChangedListener(new e());
        this.ticklet_transfer_ll_inputphone_layout.getViewTreeObserver().addOnGlobalLayoutListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-10986125")) {
            ipChange.ipc$dispatch("-10986125", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3), intent});
            return;
        }
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 100) {
            onRefresh();
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-707164302")) {
            ipChange.ipc$dispatch("-707164302", new Object[]{this, view});
        } else if (view.getId() == R$id.ticklet_sponsor_transfer_confirm) {
            if (getCheckedTransferInfo().size() <= 0 || this.transferDataResult == null) {
                return;
            }
            TickletTransferShareView tickletTransferShareView = new TickletTransferShareView(this);
            this.mapAppWindow = new TickletAnimWindow(this, this.ticklet_transfer_manager_list, tickletTransferShareView, this);
            i iVar = new i();
            TickletTransferDataResult tickletTransferDataResult = this.transferDataResult;
            tickletTransferShareView.initData(tickletTransferDataResult.wechatSwitch, tickletTransferDataResult.alipaySwitch, iVar);
            this.mapAppWindow.show();
        } else if (view.getId() == R$id.ticklet_iv_left_icon) {
            onBackPresss();
        } else if (view.getId() == R$id.ticklet_sponsor_transfer_phone_confirm) {
            transferPhoneImp();
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "475501614")) {
            ipChange.ipc$dispatch("475501614", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.performId = getIntent().getStringExtra(TicketDetailExtFragment.PERFORM_ID);
            this.productSystemId = getIntent().getStringExtra(TicketDetailExtFragment.PRODUCT_SYSTEM_ID);
        }
        if (TextUtils.isEmpty(this.performId)) {
            return;
        }
        onRefresh();
        setDamaiUTKeyBuilder(un2.k().l(un2.TICKLET_TRANSFER_MANAGER_PAGE));
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-576332562")) {
            ipChange.ipc$dispatch("-576332562", new Object[]{this});
            return;
        }
        super.onDestroy();
        MyThread myThread = this.timeThread;
        if (myThread != null) {
            myThread.endThread = true;
        }
        if (myThread != null) {
            this.timeThread = null;
        }
        if (this.thread != null) {
            this.thread = null;
        }
        TickletAnimWindow tickletAnimWindow = this.mapAppWindow;
        if (tickletAnimWindow != null) {
            tickletAnimWindow.onDestory();
            this.mapAppWindow = null;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "576004420")) {
            return ((Boolean) ipChange.ipc$dispatch("576004420", new Object[]{this, Integer.valueOf(i2), keyEvent})).booleanValue();
        }
        if (i2 == 4) {
            onBackPresss();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1357003991")) {
            ipChange.ipc$dispatch("-1357003991", new Object[]{this});
        }
    }

    public void onLoadMore(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1663452811")) {
            ipChange.ipc$dispatch("1663452811", new Object[]{this, view});
        }
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-131579444")) {
            ipChange.ipc$dispatch("-131579444", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1983445065")) {
            ipChange.ipc$dispatch("1983445065", new Object[]{this, intent});
        } else {
            super.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2031294002")) {
            ipChange.ipc$dispatch("2031294002", new Object[]{this});
        } else {
            super.onPause();
        }
    }

    public void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1936716397")) {
            ipChange.ipc$dispatch("1936716397", new Object[]{this});
        } else {
            requestDetailData(false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "193391125")) {
            ipChange.ipc$dispatch("193391125", new Object[]{this});
        } else {
            super.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1755907499")) {
            ipChange.ipc$dispatch("1755907499", new Object[]{this, bundle});
        } else {
            super.onSaveInstanceState(bundle);
        }
    }

    public void returnCancelTransfer(TickletTransferCancelData tickletTransferCancelData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "931049595")) {
            ipChange.ipc$dispatch("931049595", new Object[]{this, tickletTransferCancelData});
            return;
        }
        stopProgressDialog();
        ToastUtil.f(getResources().getString(R$string.ticklet_transfer_cancel_success));
        onRefresh();
        this.isHasTicketStateChange = true;
    }

    public void returnTransferData(TickletTransferDataResult tickletTransferDataResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "21555496")) {
            ipChange.ipc$dispatch("21555496", new Object[]{this, tickletTransferDataResult});
            return;
        }
        stopProgressDialog();
        this.transferDataResult = tickletTransferDataResult;
        if (tickletTransferDataResult == null || !tickletTransferDataResult.isNotEmptyList()) {
            if (this.mCurrentPageIndex == 0) {
                showEmptyPage();
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(tickletTransferDataResult.serverTimestamp)) {
            x30.d(Long.parseLong(tickletTransferDataResult.serverTimestamp));
        }
        if (this.mCurrentPageIndex == 0) {
            this.transferDatas = ticketSeatCombine(tickletTransferDataResult, true);
        } else {
            MyThread myThread = this.timeThread;
            if (myThread != null) {
                myThread.endThread = true;
            }
            this.isNoConutDown = true;
            this.transferDatas = ticketSeatCombine(tickletTransferDataResult, false);
        }
        refreshViewByDataChange();
        ArrayList<TickletTransferManagerListExtra> arrayList = this.runningTransfer;
        if (arrayList != null && arrayList.size() > 0 && "1".equals(tickletTransferDataResult.transferState)) {
            if (this.timeThread != null) {
                this.timeThread = null;
            }
            if (this.thread != null) {
                this.thread = null;
            }
            this.isNoConutDown = false;
            this.timeThread = new MyThread(this.runningTransfer);
            Thread thread = new Thread(this.timeThread);
            this.thread = thread;
            thread.start();
        }
        this.mCurrentPageIndex++;
    }

    @Override // cn.damai.ticklet.ui.activity.TickletBaseActivity, cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "23552597") ? (String) ipChange.ipc$dispatch("23552597", new Object[]{this}) : "";
    }

    public ArrayList<rp2> ticketSeatCombine(TickletTransferDataResult tickletTransferDataResult, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-504810043")) {
            return (ArrayList) ipChange.ipc$dispatch("-504810043", new Object[]{this, tickletTransferDataResult, Boolean.valueOf(z)});
        }
        if (z) {
            this.defalutChoose = true;
            this.allowTransfer.clear();
            this.outTransfer.clear();
            this.runningTransfer.clear();
            this.transferTips = new rp2(4);
            this.transferAllows = new rp2(0);
            this.transferOuts = new rp2(1);
            this.transferRunnings = new rp2(2);
        }
        if (tickletTransferDataResult.isCanTransferNotEmptyList()) {
            this.allowTransfer.addAll(tickletTransferDataResult.canTransferList);
        }
        if (tickletTransferDataResult.isRunningNotEmptyList()) {
            this.runningTransfer.addAll(tickletTransferDataResult.ongoingTransferList);
        }
        if (tickletTransferDataResult.isAlreadyNotEmptyList()) {
            this.outTransfer.addAll(tickletTransferDataResult.alreadyTransferList);
        }
        notifyData();
        return this.transferDatas;
    }

    @Override // cn.damai.uikit.pulltorefresh.library.PullToRefreshBase.OnRefreshListener
    public void onRefresh(PullToRefreshBase<DMScrollerView> pullToRefreshBase) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2105810880")) {
            ipChange.ipc$dispatch("-2105810880", new Object[]{this, pullToRefreshBase});
        } else {
            onRefresh();
        }
    }
}
