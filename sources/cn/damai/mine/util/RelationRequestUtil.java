package cn.damai.mine.util;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.login.LoginManager;
import cn.damai.mine.relationship.fragment.RelationBaseFragment;
import cn.damai.mine.relationship.net.RelationItemRequest;
import cn.damai.mine.relationship.net.RelationItemResponse;
import com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.ActionRelation;
import com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.CityWantRequest;
import com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.CityWantRequestKt;
import com.alibaba.pictures.bricks.component.home.FollowStateBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import tb.hm1;
import tb.vf1;
import tb.x2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class RelationRequestUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    RelationRequestInter a;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface RelationRequestInter {
        void fail(String str, String str2);

        void success(int i, int i2);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.util.RelationRequestUtil$a */
    /* loaded from: classes15.dex */
    public class DialogInterface$OnClickListenerC1467a implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        DialogInterface$OnClickListenerC1467a(RelationRequestUtil relationRequestUtil) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1834101709")) {
                ipChange.ipc$dispatch("-1834101709", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.util.RelationRequestUtil$b */
    /* loaded from: classes15.dex */
    public class DialogInterface$OnClickListenerC1468b implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ int e;
        final /* synthetic */ String f;

        DialogInterface$OnClickListenerC1468b(Context context, int i, String str, String str2, int i2, String str3) {
            this.a = context;
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = i2;
            this.f = str3;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-864520686")) {
                ipChange.ipc$dispatch("-864520686", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                RelationRequestUtil.this.b(this.a, this.b, this.c, this.d, this.e, this.f);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.util.RelationRequestUtil$c */
    /* loaded from: classes6.dex */
    public class C1469c implements ActionRelation<FollowStateBean> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Context a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        C1469c(Context context, int i, int i2) {
            this.a = context;
            this.b = i;
            this.c = i2;
        }

        @Override // com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.ActionRelation
        public void action(@NonNull x2<FollowStateBean> x2Var) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1241806621")) {
                ipChange.ipc$dispatch("1241806621", new Object[]{this, x2Var});
            } else if (x2Var.b()) {
                int i = this.b != 0 ? 0 : 1;
                if (x2Var.a() != null && !TextUtils.isEmpty(x2Var.a().status)) {
                    i = hm1.e(x2Var.a().status, i);
                }
                RelationRequestUtil.this.a.success(this.c, i);
                if (this.b == 0) {
                    ToastUtil.i("关注成功");
                } else {
                    ToastUtil.i("取消关注成功");
                }
            } else {
                ToastUtil.i("麦麦开小差了，请稍后重试哦");
            }
        }

        @Override // com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.ActionRelation
        public void end() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-410674078")) {
                ipChange.ipc$dispatch("-410674078", new Object[]{this});
                return;
            }
            Context context = this.a;
            if (context == null || !(context instanceof DamaiBaseActivity)) {
                return;
            }
            ((DamaiBaseActivity) context).stopProgressDialog();
        }

        @Override // com.alibaba.pictures.bricks.component.artist.wishcity.cityrequest.ActionRelation
        public void start() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "123442555")) {
                ipChange.ipc$dispatch("123442555", new Object[]{this});
                return;
            }
            Context context = this.a;
            if (context == null || !(context instanceof DamaiBaseActivity)) {
                return;
            }
            ((DamaiBaseActivity) context).startProgressDialog();
        }
    }

    public RelationRequestUtil(RelationRequestInter relationRequestInter) {
        this.a = relationRequestInter;
    }

    public void a(Context context, int i, String str, String str2, int i2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1829541124")) {
            ipChange.ipc$dispatch("1829541124", new Object[]{this, context, Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3});
            return;
        }
        try {
            if (i != 0) {
                DMDialog dMDialog = new DMDialog(context);
                dMDialog.o(false).q("确认不再关注TA了？");
                dMDialog.i("取消", new DialogInterface$OnClickListenerC1467a(this));
                dMDialog.n(PurchaseConstants.CONFIRM, new DialogInterface$OnClickListenerC1468b(context, i, str, str2, i2, str3)).show();
            } else {
                b(context, i, str, str2, i2, str3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(final Context context, final int i, String str, String str2, final int i2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1643898587")) {
            ipChange.ipc$dispatch("1643898587", new Object[]{this, context, Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3});
        } else if (LoginManager.k().q()) {
            if (context != null && (context instanceof DamaiBaseActivity)) {
                ((DamaiBaseActivity) context).startProgressDialog();
            }
            if ("fans".equals(str3)) {
                C0529c.e().x(vf1.x().b0(vf1.FANS_LIST_PAGE, i2, i != 0 ? "0" : "1", ""));
            } else if ("wantsee".equals(str3)) {
                C0529c.e().x(vf1.x().c0(i2, i != 0 ? "0" : "1"));
            } else if ("brand".equals(str3)) {
                C0529c.e().x(vf1.x().b0(vf1.FOLLOW_LIST_PAGE, i2, i != 0 ? "0" : "1", "0"));
            } else if ("star".equals(str3)) {
                C0529c.e().x(vf1.x().b0(vf1.FOLLOW_LIST_PAGE, i2, i == 0 ? "1" : "0", "1"));
            } else if (RelationBaseFragment.RELATION_TYPE_KIND_COSTOMER.equals(str3)) {
                C0529c.e().x(vf1.x().b0(vf1.FOLLOW_LIST_PAGE, i2, i != 0 ? "0" : "1", "2"));
            }
            if ("star".equalsIgnoreCase(str3)) {
                CityWantRequestKt.a(i == 0, str, new C1469c(context, i, i2), CityWantRequest.PageName.DM_MY_FOLLOW_LIST);
                return;
            }
            RelationItemRequest relationItemRequest = new RelationItemRequest();
            if (i == 0) {
                relationItemRequest.operateType = 1;
            } else if (i == 1) {
                relationItemRequest.operateType = 0;
            } else if (i == 2) {
                relationItemRequest.operateType = 0;
            }
            relationItemRequest.targetId = str;
            relationItemRequest.targetType = str2;
            relationItemRequest.request(new DMMtopRequestListener<RelationItemResponse>(RelationItemResponse.class) { // from class: cn.damai.mine.util.RelationRequestUtil.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str4, String str5) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1418433317")) {
                        ipChange2.ipc$dispatch("1418433317", new Object[]{this, str4, str5});
                        return;
                    }
                    Context context2 = context;
                    if (context2 != null && (context2 instanceof DamaiBaseActivity)) {
                        ((DamaiBaseActivity) context2).stopProgressDialog();
                    }
                    RelationRequestUtil.this.a.fail(str4, str5);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(RelationItemResponse relationItemResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-477798159")) {
                        ipChange2.ipc$dispatch("-477798159", new Object[]{this, relationItemResponse});
                        return;
                    }
                    Context context2 = context;
                    if (context2 != null && (context2 instanceof DamaiBaseActivity)) {
                        ((DamaiBaseActivity) context2).stopProgressDialog();
                    }
                    RelationRequestUtil.this.a.success(i2, relationItemResponse.status);
                    if (i == 0) {
                        ToastUtil.i("关注成功");
                    } else {
                        ToastUtil.i("取消关注成功");
                    }
                }
            });
        } else {
            LoginManager.k().v(context);
        }
    }
}
