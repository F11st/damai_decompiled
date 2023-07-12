package cn.damai.ticklet.view;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import cn.damai.common.user.C0529c;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.member.R$dimen;
import cn.damai.member.R$drawable;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.TickletExtraInfo;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.inteface.TickletTicketCallback;
import cn.damai.ticklet.ui.activity.TicketDeatilActivity;
import cn.damai.uikit.view.DMThemeDialog;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.py2;
import tb.t60;
import tb.un2;
import tb.wh2;
import tb.x30;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletTicketActionView extends HorizontalScrollView implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private DamaiBaseActivity activity;
    private Context context;
    private TicketDeatilResult detailResult;
    private LinearLayout llAction;
    private View partent;
    private TickletTicketCallback ticketCallback;
    int typeListPos;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.view.TickletTicketActionView$a */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC2118a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ UserTicketTable a;
        final /* synthetic */ TickletExtraInfo b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;

        View$OnClickListenerC2118a(UserTicketTable userTicketTable, TickletExtraInfo tickletExtraInfo, String str, int i) {
            this.a = userTicketTable;
            this.b = tickletExtraInfo;
            this.c = str;
            this.d = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "919293954")) {
                ipChange.ipc$dispatch("919293954", new Object[]{this, view});
                return;
            }
            C0529c.e().x(un2.k().y(this.a.getPerformId(), this.b.projectId, this.c, this.d));
            py2.f().n(TickletTicketActionView.this.context, this.b.liveH5Url);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.view.TickletTicketActionView$b */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC2119b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ UserTicketTable a;
        final /* synthetic */ TickletExtraInfo b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;

        View$OnClickListenerC2119b(UserTicketTable userTicketTable, TickletExtraInfo tickletExtraInfo, String str, int i) {
            this.a = userTicketTable;
            this.b = tickletExtraInfo;
            this.c = str;
            this.d = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1264382973")) {
                ipChange.ipc$dispatch("-1264382973", new Object[]{this, view});
            } else if (TickletTicketActionView.this.context == null || !(TickletTicketActionView.this.context instanceof TicketDeatilActivity)) {
            } else {
                C0529c.e().x(un2.k().y(this.a.getPerformId(), this.b.projectId, this.c, this.d));
                py2 f = py2.f();
                Context context = TickletTicketActionView.this.context;
                UserTicketTable userTicketTable = this.a;
                String str = userTicketTable.performId;
                String str2 = userTicketTable.productSystemId;
                boolean z = userTicketTable.isLiveTicket() && "1".equals(this.b.liveType);
                TickletExtraInfo tickletExtraInfo = this.b;
                f.m(context, str, str2, z, tickletExtraInfo.projectImage, tickletExtraInfo.itemProjectId, tickletExtraInfo.projectName, x30.h(Long.valueOf(tickletExtraInfo.beginTime), "yyyy.MM.dd | HH:mm"), this.b.liveH5Url, "", true);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.view.TickletTicketActionView$c */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC2120c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ TickletExtraInfo a;
        final /* synthetic */ UserTicketTable b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;

        View$OnClickListenerC2120c(TickletExtraInfo tickletExtraInfo, UserTicketTable userTicketTable, String str, int i) {
            this.a = tickletExtraInfo;
            this.b = userTicketTable;
            this.c = str;
            this.d = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "846907396")) {
                ipChange.ipc$dispatch("846907396", new Object[]{this, view});
            } else if (!TextUtils.isEmpty(this.a.transferWarn)) {
                TickletTicketActionView tickletTicketActionView = TickletTicketActionView.this;
                TickletExtraInfo tickletExtraInfo = this.a;
                String str = tickletExtraInfo.transferWarn;
                String str2 = tickletExtraInfo.projectId;
                UserTicketTable userTicketTable = this.b;
                tickletTicketActionView.transferTipDialog(str, str2, userTicketTable.performId, userTicketTable.productSystemId, this.c, this.d);
            } else {
                TickletTicketActionView tickletTicketActionView2 = TickletTicketActionView.this;
                String str3 = this.a.projectId;
                UserTicketTable userTicketTable2 = this.b;
                tickletTicketActionView2.goTransfer(str3, userTicketTable2.performId, userTicketTable2.productSystemId, this.c, this.d);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.view.TickletTicketActionView$d */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC2121d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ UserTicketTable a;
        final /* synthetic */ TickletExtraInfo b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;
        final /* synthetic */ TicketDeatilResult e;

        View$OnClickListenerC2121d(UserTicketTable userTicketTable, TickletExtraInfo tickletExtraInfo, String str, int i, TicketDeatilResult ticketDeatilResult) {
            this.a = userTicketTable;
            this.b = tickletExtraInfo;
            this.c = str;
            this.d = i;
            this.e = ticketDeatilResult;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1336769531")) {
                ipChange.ipc$dispatch("-1336769531", new Object[]{this, view});
            } else if (TickletTicketActionView.this.ticketCallback != null) {
                C0529c.e().x(un2.k().y(this.a.getPerformId(), this.b.projectId, this.c, this.d));
                py2.f().k(TickletTicketActionView.this.context, this.e.getPerformId(), this.e.getEcertTipsInfo());
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.view.TickletTicketActionView$e */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC2122e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC2122e(TickletTicketActionView tickletTicketActionView) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "774520838")) {
                ipChange.ipc$dispatch("774520838", new Object[]{this, view});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.ticklet.view.TickletTicketActionView$f */
    /* loaded from: classes7.dex */
    public class DialogInterface$OnClickListenerC2123f implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ int e;

        DialogInterface$OnClickListenerC2123f(String str, String str2, String str3, String str4, int i) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1713354120")) {
                ipChange.ipc$dispatch("1713354120", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            if (dialogInterface != null) {
                dialogInterface.dismiss();
            }
            TickletTicketActionView.this.goTransfer(this.a, this.b, this.c, this.d, this.e);
        }
    }

    public TickletTicketActionView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goTransfer(String str, String str2, String str3, String str4, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902919542")) {
            ipChange.ipc$dispatch("-902919542", new Object[]{this, str, str2, str3, str4, Integer.valueOf(i)});
            return;
        }
        C0529c.e().x(un2.k().y(str2, str, str4, i));
        py2.f().j(this.activity, str2, str3, 101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transferTipDialog(String str, String str2, String str3, String str4, String str5, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816001565")) {
            ipChange.ipc$dispatch("-1816001565", new Object[]{this, str, str2, str3, str4, str5, Integer.valueOf(i)});
        } else if (this.context == null) {
        } else {
            DMThemeDialog dMThemeDialog = new DMThemeDialog(this.context);
            dMThemeDialog.r(DMThemeDialog.DMDialogTheme.THEME_NOTIFICATION);
            dMThemeDialog.o("转送提醒");
            dMThemeDialog.k(str);
            dMThemeDialog.g(true, new View$OnClickListenerC2122e(this));
            dMThemeDialog.i(this.context.getResources().getString(R$string.ticklet_ticket_transfer_entry), new DialogInterface$OnClickListenerC2123f(str2, str3, str4, str5, i));
            dMThemeDialog.f(false);
            dMThemeDialog.show();
        }
    }

    public void addAction(UserTicketTable userTicketTable, TickletExtraInfo tickletExtraInfo, TicketDeatilResult ticketDeatilResult, int i) {
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i3;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734713597")) {
            ipChange.ipc$dispatch("1734713597", new Object[]{this, userTicketTable, tickletExtraInfo, ticketDeatilResult, Integer.valueOf(i)});
        } else if (userTicketTable == null || tickletExtraInfo == null || this.context == null || ticketDeatilResult == null) {
        } else {
            this.detailResult = ticketDeatilResult;
            this.llAction.removeAllViews();
            if (wh2.e(userTicketTable.getOpTypeList()) > 0) {
                i2 = wh2.e(userTicketTable.getOpTypeList()) + 0;
                z = true;
            } else {
                i2 = 0;
                z = false;
            }
            if (userTicketTable.isLiveTicket()) {
                i2++;
                z2 = true;
            } else {
                z2 = false;
            }
            if (tickletExtraInfo.esouvenirEnable == 1) {
                i2++;
                z3 = true;
            } else {
                z3 = false;
            }
            if (userTicketTable.isTransferStateEnable()) {
                i2++;
                z4 = true;
            } else {
                z4 = false;
            }
            String str2 = "1";
            if (userTicketTable.isCertCardTicket() && "1".equals(userTicketTable.ecertState) && ("1".equals(userTicketTable.getVoucherState()) || "3".equals(userTicketTable.getVoucherState()))) {
                i2++;
                z5 = true;
            } else {
                z5 = false;
            }
            if (i2 == 0) {
                if (ticketDeatilResult.isLocalData.booleanValue()) {
                    return;
                }
                setVisibility(8);
                return;
            }
            setVisibility(0);
            float f = 70;
            getLayoutParams().height = t60.a(getContext(), f);
            int dimension = (DisplayMetrics.getwidthPixels(t60.b(this.context)) - (((int) this.context.getResources().getDimension(R$dimen.ticklet_detail_margin)) * 2)) / (i2 <= 3 ? i2 : 4);
            if (dimension < t60.a(this.context, 65.0f)) {
                dimension = t60.a(this.context, 65.0f);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimension, t60.a(getContext(), f));
            if (z) {
                int e = wh2.e(userTicketTable.getOpTypeList());
                int i4 = 0;
                while (i4 < e) {
                    this.typeListPos = i4;
                    String str3 = userTicketTable.getOpTypeList().get(i4).performOpType;
                    TickletTicketActionItemView tickletTicketActionItemView = new TickletTicketActionItemView(this.context);
                    if (!str2.equals(str3) && !"2".equals(str3)) {
                        if ("5".equals(str3)) {
                            i3 = e;
                            str = str2;
                            tickletTicketActionItemView.update(R$drawable.ticket_nft_resource_collection_icon, tickletExtraInfo.actionTvColor, userTicketTable.getOpTypeList().get(i4), i, "", "");
                            this.llAction.addView(tickletTicketActionItemView, layoutParams);
                        } else {
                            i3 = e;
                            str = str2;
                            if ("6".equals(str3)) {
                                C0529c.e().G(tickletTicketActionItemView, "showoff_" + i, "nft", un2.TICKLET_DETAIL_PAGE, new HashMap());
                                tickletTicketActionItemView.update(R$drawable.ticket_nft_source_show_icon, tickletExtraInfo.actionTvColor, userTicketTable.getOpTypeList().get(i4), ticketDeatilResult.getUserPerformVO().getUserTicketVOList().get(i).getExtAttr().nftAttr, i, "", "", this.activity, tickletExtraInfo.isTMNormalMember());
                                this.llAction.addView(tickletTicketActionItemView, layoutParams);
                            }
                        }
                    } else {
                        i3 = e;
                        str = str2;
                        tickletTicketActionItemView.update(R$drawable.ticklet_comment_icon, tickletExtraInfo.actionTvColor, userTicketTable.getOpTypeList().get(i4), i, userTicketTable.tradeOrderId, userTicketTable.getPerformId());
                        this.llAction.addView(tickletTicketActionItemView, layoutParams);
                    }
                    i4++;
                    e = i3;
                    str2 = str;
                }
            }
            if (z2) {
                TickletTicketActionItemView tickletTicketActionItemView2 = new TickletTicketActionItemView(this.context);
                un2.k().z(tickletTicketActionItemView2, 1, userTicketTable.getPerformId(), tickletExtraInfo.projectId, "进入直播间");
                layoutParams = layoutParams;
                tickletTicketActionItemView2.update("进入直播间", tickletExtraInfo.actionTvColor, ticketDeatilResult.isNftPerform() ? R$drawable.ticklet_live_nft_small_icon : R$drawable.ticklet_live_small_icon, -1, new View$OnClickListenerC2118a(userTicketTable, tickletExtraInfo, "进入直播间", 1));
                this.llAction.addView(tickletTicketActionItemView2, layoutParams);
            }
            if (z3) {
                TickletTicketActionItemView tickletTicketActionItemView3 = new TickletTicketActionItemView(this.context);
                un2.k().z(tickletTicketActionItemView3, 2, userTicketTable.getPerformId(), tickletExtraInfo.projectId, "官方纪念票");
                layoutParams = layoutParams;
                tickletTicketActionItemView3.update("官方纪念票", tickletExtraInfo.actionTvColor, ticketDeatilResult.isNftPerform() ? R$drawable.ticket_nft_source_sou_icon : R$drawable.ticklet_share_souvenir_icon, -1, new View$OnClickListenerC2119b(userTicketTable, tickletExtraInfo, "官方纪念票", 2));
                this.llAction.addView(tickletTicketActionItemView3, layoutParams);
            }
            if (z4) {
                TickletTicketActionItemView tickletTicketActionItemView4 = new TickletTicketActionItemView(this.context);
                un2.k().z(tickletTicketActionItemView4, 3, userTicketTable.getPerformId(), tickletExtraInfo.projectId, "转送好友");
                layoutParams = layoutParams;
                tickletTicketActionItemView4.update("转送好友", tickletExtraInfo.actionTvColor, ticketDeatilResult.isNftPerform() ? R$drawable.ticket_nft_source_trans_icon : R$drawable.ticklet_transfer_icon, tickletExtraInfo.transferringNum, new View$OnClickListenerC2120c(tickletExtraInfo, userTicketTable, "转送好友", 3));
                this.llAction.addView(tickletTicketActionItemView4, layoutParams);
            }
            if (z5) {
                TickletTicketActionItemView tickletTicketActionItemView5 = new TickletTicketActionItemView(this.context);
                un2.k().z(tickletTicketActionItemView5, 5, userTicketTable.getPerformId(), tickletExtraInfo.projectId, "电子身份证");
                tickletTicketActionItemView5.update("电子身份证", tickletExtraInfo.actionTvColor, ticketDeatilResult.isNftPerform() ? R$drawable.ticklet_e_nft_card_icon : R$drawable.ticklet_e_card_icon, -1, new View$OnClickListenerC2121d(userTicketTable, tickletExtraInfo, "电子身份证", 5, ticketDeatilResult));
                this.llAction.addView(tickletTicketActionItemView5, layoutParams);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448145461")) {
            ipChange.ipc$dispatch("1448145461", new Object[]{this, view});
        }
    }

    public void setTicketCallback(TickletTicketCallback tickletTicketCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1836052433")) {
            ipChange.ipc$dispatch("-1836052433", new Object[]{this, tickletTicketCallback});
        } else {
            this.ticketCallback = tickletTicketCallback;
        }
    }

    public TickletTicketActionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickletTicketActionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.typeListPos = -1;
        this.context = context;
        this.activity = (DamaiBaseActivity) context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.llAction = linearLayout;
        linearLayout.setOrientation(0);
        this.llAction.setGravity(1);
        removeAllViews();
        addView(this.llAction, new LinearLayout.LayoutParams(-2, -1));
    }
}
