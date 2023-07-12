package cn.damai.homepage.util;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import cn.damai.category.discountticket.model.OnTListener;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.yymember.MemberGuideCallBackRequest;
import cn.damai.commonbusiness.yymember.bean.MemberBindResult;
import cn.damai.commonbusiness.yymember.bean.MemberFinishedInfo;
import cn.damai.commonbusiness.yymember.bean.WrapFirstGuideBean;
import cn.damai.commonbusiness.yymember.request.MemberFinishGuideCallBackRequest;
import cn.damai.homepage.MainAlertEntity;
import cn.damai.homepage.util.window.UTHelperCallback;
import cn.damai.tetris.componentplugin.OnBizListener;
import cn.damai.uikit.util.DialogUtil;
import cn.damai.uikit.view.DMAvatar;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.request.ImageFlowMonitor;
import com.taobao.phenix.request.ImageStatistics;
import tb.k23;
import tb.py0;
import tb.ur1;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class MemberGuideDialogManger {
    private static transient /* synthetic */ IpChange $ipChange;
    private final BaseActivity a;
    private final C1213g b;
    private UTHelperCallback c;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.util.MemberGuideDialogManger$11  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass11 extends DMMtopRequestListener<MemberBindResult> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnBizListener val$listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass11(Class cls, OnBizListener onBizListener) {
            super(cls);
            this.val$listener = onBizListener;
        }

        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
        public void onFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-279585253")) {
                ipChange.ipc$dispatch("-279585253", new Object[]{this, str, str2});
                return;
            }
            MemberGuideDialogManger.this.a.stopProgressDialog();
            this.val$listener.onFail(str, str2);
        }

        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
        public void onSuccess(MemberBindResult memberBindResult) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-832298294")) {
                ipChange.ipc$dispatch("-832298294", new Object[]{this, memberBindResult});
                return;
            }
            MemberGuideDialogManger.this.a.stopProgressDialog();
            if (memberBindResult != null && memberBindResult.isSuccess()) {
                this.val$listener.onSuccess(memberBindResult);
            } else {
                this.val$listener.onFail("1", memberBindResult == null ? "授权失败，请重试！" : memberBindResult.returnMessage);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface IMemberDialogDispatcher {
        void dialogToShow(Dialog dialog);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.util.MemberGuideDialogManger$a */
    /* loaded from: classes5.dex */
    public class C1205a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnTListener a;

        C1205a(OnTListener onTListener) {
            this.a = onTListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1578956669")) {
                ipChange.ipc$dispatch("1578956669", new Object[]{this, c0502e});
            } else if (!MemberGuideDialogManger.this.j() || c0502e == null || (bitmap = c0502e.b) == null || bitmap.isRecycled()) {
            } else {
                this.a.callBack(c0502e.b);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.util.MemberGuideDialogManger$b */
    /* loaded from: classes5.dex */
    public class C1206b implements OnTListener<Bitmap> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WrapFirstGuideBean a;

        C1206b(WrapFirstGuideBean wrapFirstGuideBean) {
            this.a = wrapFirstGuideBean;
        }

        @Override // cn.damai.category.discountticket.model.OnTListener
        /* renamed from: a */
        public void callBack(Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "621737652")) {
                ipChange.ipc$dispatch("621737652", new Object[]{this, bitmap});
            } else {
                MemberGuideDialogManger.this.g(this.a, bitmap);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.util.MemberGuideDialogManger$c */
    /* loaded from: classes5.dex */
    public class C1207c implements OnTListener<Bitmap> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ MemberFinishedInfo a;

        C1207c(MemberFinishedInfo memberFinishedInfo) {
            this.a = memberFinishedInfo;
        }

        @Override // cn.damai.category.discountticket.model.OnTListener
        /* renamed from: a */
        public void callBack(Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2083317651")) {
                ipChange.ipc$dispatch("2083317651", new Object[]{this, bitmap});
            } else {
                MemberGuideDialogManger.this.f(this.a, bitmap);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.util.MemberGuideDialogManger$d */
    /* loaded from: classes5.dex */
    public class C1208d implements DialogUtil.MemberDialogAction {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WrapFirstGuideBean a;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.homepage.util.MemberGuideDialogManger$d$a */
        /* loaded from: classes14.dex */
        public class View$OnClickListenerC1209a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC1209a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-2029129409")) {
                    ipChange.ipc$dispatch("-2029129409", new Object[]{this, view});
                    return;
                }
                if (MemberGuideDialogManger.this.c != null) {
                    MemberGuideDialogManger.this.c.confirmUt("");
                } else {
                    py0.h(C1208d.this.a.tipType);
                }
                k23.e(MemberGuideDialogManger.this.a);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.homepage.util.MemberGuideDialogManger$d$b */
        /* loaded from: classes14.dex */
        public class View$OnClickListenerC1210b implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            View$OnClickListenerC1210b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "82160960")) {
                    ipChange.ipc$dispatch("82160960", new Object[]{this, view});
                } else if (MemberGuideDialogManger.this.c != null) {
                    MemberGuideDialogManger.this.c.closeUt();
                } else {
                    py0.g(C1208d.this.a.tipType);
                }
            }
        }

        C1208d(WrapFirstGuideBean wrapFirstGuideBean) {
            this.a = wrapFirstGuideBean;
        }

        @Override // cn.damai.uikit.util.TDialog.OnDialogShowTimeListener
        public void exposureTime(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1711029143")) {
                ipChange.ipc$dispatch("1711029143", new Object[]{this, Long.valueOf(j)});
            } else if (MemberGuideDialogManger.this.c != null) {
                MemberGuideDialogManger.this.c.exposureUt(j);
            } else {
                py0.r(j, this.a.tipType);
            }
        }

        @Override // cn.damai.uikit.util.DialogUtil.MemberDialogAction
        public View.OnClickListener getCloseClick() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1653062356") ? (View.OnClickListener) ipChange.ipc$dispatch("-1653062356", new Object[]{this}) : new View$OnClickListenerC1210b();
        }

        @Override // cn.damai.uikit.util.DialogUtil.MemberDialogAction
        public View.OnClickListener getContentClick() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-148446483") ? (View.OnClickListener) ipChange.ipc$dispatch("-148446483", new Object[]{this}) : new View$OnClickListenerC1209a();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.util.MemberGuideDialogManger$e */
    /* loaded from: classes14.dex */
    public class DialogInterface$OnShowListenerC1211e implements DialogInterface.OnShowListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ WrapFirstGuideBean a;

        DialogInterface$OnShowListenerC1211e(MemberGuideDialogManger memberGuideDialogManger, WrapFirstGuideBean wrapFirstGuideBean) {
            this.a = wrapFirstGuideBean;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "605002976")) {
                ipChange.ipc$dispatch("605002976", new Object[]{this, dialogInterface});
            } else {
                MemberGuideCallBackRequest.asyncWriteBack(this.a.tipType);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.util.MemberGuideDialogManger$f */
    /* loaded from: classes14.dex */
    public class DialogInterface$OnShowListenerC1212f implements DialogInterface.OnShowListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnShowListenerC1212f(MemberGuideDialogManger memberGuideDialogManger) {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1761691618")) {
                ipChange.ipc$dispatch("-1761691618", new Object[]{this, dialogInterface});
            } else {
                MemberFinishGuideCallBackRequest.syncWriteBack();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.homepage.util.MemberGuideDialogManger$g */
    /* loaded from: classes5.dex */
    public static class C1213g implements IMemberDialogDispatcher {
        private static transient /* synthetic */ IpChange $ipChange;
        private final IMemberDialogDispatcher a;

        public C1213g(IMemberDialogDispatcher iMemberDialogDispatcher) {
            this.a = iMemberDialogDispatcher;
        }

        @Override // cn.damai.homepage.util.MemberGuideDialogManger.IMemberDialogDispatcher
        public void dialogToShow(Dialog dialog) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1528346004")) {
                ipChange.ipc$dispatch("1528346004", new Object[]{this, dialog});
                return;
            }
            IMemberDialogDispatcher iMemberDialogDispatcher = this.a;
            if (iMemberDialogDispatcher != null) {
                iMemberDialogDispatcher.dialogToShow(dialog);
            }
        }
    }

    public MemberGuideDialogManger(BaseActivity baseActivity, IMemberDialogDispatcher iMemberDialogDispatcher) {
        this.a = baseActivity;
        this.b = new C1213g(iMemberDialogDispatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final MemberFinishedInfo memberFinishedInfo, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-108449975")) {
            ipChange.ipc$dispatch("-108449975", new Object[]{this, memberFinishedInfo, bitmap});
            return;
        }
        Dialog c = DialogUtil.c(this.a, bitmap, memberFinishedInfo.avatar, memberFinishedInfo.userNick, memberFinishedInfo.memberFlag, memberFinishedInfo.gifUrl, new DialogUtil.MemberDialogActionV2() { // from class: cn.damai.homepage.util.MemberGuideDialogManger.5
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.homepage.util.MemberGuideDialogManger$5$a */
            /* loaded from: classes14.dex */
            public class View$OnClickListenerC1203a implements View.OnClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                View$OnClickListenerC1203a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-761844542")) {
                        ipChange.ipc$dispatch("-761844542", new Object[]{this, view});
                        return;
                    }
                    if (MemberGuideDialogManger.this.c != null) {
                        MemberGuideDialogManger.this.c.confirmUt("");
                    } else {
                        py0.f(memberFinishedInfo.memberFlag);
                    }
                    k23.e(MemberGuideDialogManger.this.a);
                }
            }

            /* compiled from: Taobao */
            /* renamed from: cn.damai.homepage.util.MemberGuideDialogManger$5$b */
            /* loaded from: classes14.dex */
            public class View$OnClickListenerC1204b implements View.OnClickListener {
                private static transient /* synthetic */ IpChange $ipChange;

                View$OnClickListenerC1204b() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1349445827")) {
                        ipChange.ipc$dispatch("1349445827", new Object[]{this, view});
                    } else if (MemberGuideDialogManger.this.c != null) {
                        MemberGuideDialogManger.this.c.closeUt();
                    }
                }
            }

            @Override // cn.damai.uikit.util.TDialog.OnDialogShowTimeListener
            public void exposureTime(long j) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "893380693")) {
                    ipChange2.ipc$dispatch("893380693", new Object[]{this, Long.valueOf(j)});
                } else if (MemberGuideDialogManger.this.c != null) {
                    MemberGuideDialogManger.this.c.exposureUt(j);
                } else {
                    py0.q(j, memberFinishedInfo.memberFlag);
                }
            }

            @Override // cn.damai.uikit.util.DialogUtil.MemberDialogAction
            public View.OnClickListener getCloseClick() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-777043350") ? (View.OnClickListener) ipChange2.ipc$dispatch("-777043350", new Object[]{this}) : new View$OnClickListenerC1204b();
            }

            @Override // cn.damai.uikit.util.DialogUtil.MemberDialogAction
            public View.OnClickListener getContentClick() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-107771733") ? (View.OnClickListener) ipChange2.ipc$dispatch("-107771733", new Object[]{this}) : new View$OnClickListenerC1203a();
            }

            @Override // cn.damai.uikit.util.DialogUtil.MemberDialogActionV2
            public void loadGifImg(final ImageView imageView, final String str, final View view, final View view2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "102970370")) {
                    ipChange2.ipc$dispatch("102970370", new Object[]{this, imageView, str, view, view2});
                    return;
                }
                ur1.o().y(new ImageFlowMonitor(this) { // from class: cn.damai.homepage.util.MemberGuideDialogManger.5.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX INFO: Access modifiers changed from: private */
                    public void b() {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "-1549477317")) {
                            ipChange3.ipc$dispatch("-1549477317", new Object[]{this});
                            return;
                        }
                        imageView.setVisibility(8);
                        view.setVisibility(0);
                        view2.setVisibility(0);
                    }

                    @Override // com.taobao.phenix.request.ImageFlowMonitor
                    public int getMinimumScheduleTime2StatWaitSize() {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "-467494899")) {
                            return ((Integer) ipChange3.ipc$dispatch("-467494899", new Object[]{this})).intValue();
                        }
                        return 0;
                    }

                    @Override // com.taobao.phenix.request.ImageFlowMonitor
                    public void onCancel(ImageStatistics imageStatistics) {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "-69587336")) {
                            ipChange3.ipc$dispatch("-69587336", new Object[]{this, imageStatistics});
                            return;
                        }
                        Log.e("ImageStatistics", "onCancel 2");
                        b();
                    }

                    @Override // com.taobao.phenix.request.ImageFlowMonitor
                    public void onFail(ImageStatistics imageStatistics, Throwable th) {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "-2080041895")) {
                            ipChange3.ipc$dispatch("-2080041895", new Object[]{this, imageStatistics, th});
                        } else if (str.equals(imageStatistics.p().k())) {
                            Log.e("ImageStatistics", "onFail 5 " + imageStatistics.p().k());
                            b();
                        }
                    }

                    @Override // com.taobao.phenix.request.ImageFlowMonitor
                    public void onProcess(ImageStatistics imageStatistics, String str2, String str3) {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "-1519280711")) {
                            ipChange3.ipc$dispatch("-1519280711", new Object[]{this, imageStatistics, str2, str3});
                        }
                    }

                    @Override // com.taobao.phenix.request.ImageFlowMonitor
                    public void onStart(ImageStatistics imageStatistics) {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "1557207768")) {
                            ipChange3.ipc$dispatch("1557207768", new Object[]{this, imageStatistics});
                        } else if (str.equals(imageStatistics.p().k())) {
                            Log.e("ImageStatistics", "onStart 1 " + imageStatistics.p().k());
                            imageView.setVisibility(0);
                            view.setVisibility(4);
                            view2.setVisibility(4);
                        }
                    }

                    @Override // com.taobao.phenix.request.ImageFlowMonitor
                    public void onSuccess(ImageStatistics imageStatistics) {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "-2120165959")) {
                            ipChange3.ipc$dispatch("-2120165959", new Object[]{this, imageStatistics});
                        } else if (str.equals(imageStatistics.p().k())) {
                            Log.e("ImageStatistics", "onSuccess 3 " + imageStatistics.p().k());
                            imageView.postDelayed(new Runnable() { // from class: cn.damai.homepage.util.MemberGuideDialogManger.5.1.1
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // java.lang.Runnable
                                public void run() {
                                    IpChange ipChange4 = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange4, "310644706")) {
                                        ipChange4.ipc$dispatch("310644706", new Object[]{this});
                                    } else {
                                        b();
                                    }
                                }
                            }, 2000L);
                        }
                    }
                });
                ur1.o().s(str).y(imageView);
            }

            @Override // cn.damai.uikit.util.DialogUtil.MemberDialogActionV2
            public void loadHeadImg(DMAvatar dMAvatar, String str) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1495228065")) {
                    ipChange2.ipc$dispatch("-1495228065", new Object[]{this, dMAvatar, str});
                } else {
                    dMAvatar.setAvatar(str);
                }
            }
        });
        c.setOnShowListener(new DialogInterface$OnShowListenerC1212f(this));
        this.b.dialogToShow(c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(WrapFirstGuideBean wrapFirstGuideBean, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "559967750")) {
            ipChange.ipc$dispatch("559967750", new Object[]{this, wrapFirstGuideBean, bitmap});
            return;
        }
        Dialog d = DialogUtil.d(this.a, bitmap, new C1208d(wrapFirstGuideBean));
        d.setOnShowListener(new DialogInterface$OnShowListenerC1211e(this, wrapFirstGuideBean));
        this.b.dialogToShow(d);
    }

    private void i(String str, OnTListener<Bitmap> onTListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "580040991")) {
            ipChange.ipc$dispatch("580040991", new Object[]{this, str, onTListener});
        } else {
            C0504a.b().e(str).n(new C1205a(onTListener)).f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902122751")) {
            return ((Boolean) ipChange.ipc$dispatch("-902122751", new Object[]{this})).booleanValue();
        }
        BaseActivity baseActivity = this.a;
        return (baseActivity == null || baseActivity.isFinishing()) ? false : true;
    }

    public void h(@NonNull MainAlertEntity mainAlertEntity, DialogInterface.OnDismissListener onDismissListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "872403930")) {
            ipChange.ipc$dispatch("872403930", new Object[]{this, mainAlertEntity, onDismissListener});
        } else if (mainAlertEntity.isFirstMemberGuide()) {
            WrapFirstGuideBean wrapFirstGuideBean = mainAlertEntity.getWrapFirstGuideBean();
            if (wrapFirstGuideBean.isValid()) {
                i(wrapFirstGuideBean.firstMemberGuideUrl, new C1206b(wrapFirstGuideBean));
            } else {
                onDismissListener.onDismiss(null);
            }
        } else if (mainAlertEntity.isMemberFinishGuide()) {
            MemberFinishedInfo memberFinishedInfo = mainAlertEntity.getMemberFinishedInfo();
            if (memberFinishedInfo.isValid4FinishDialog()) {
                i(memberFinishedInfo.profitImageUrl, new C1207c(memberFinishedInfo));
            } else {
                onDismissListener.onDismiss(null);
            }
        } else {
            onDismissListener.onDismiss(null);
        }
    }

    public boolean k(MainAlertEntity mainAlertEntity) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1608786287") ? ((Boolean) ipChange.ipc$dispatch("-1608786287", new Object[]{this, mainAlertEntity})).booleanValue() : mainAlertEntity != null && mainAlertEntity.isType4Member();
    }

    public void l(UTHelperCallback uTHelperCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1189059994")) {
            ipChange.ipc$dispatch("1189059994", new Object[]{this, uTHelperCallback});
        } else {
            this.c = uTHelperCallback;
        }
    }
}
