package cn.damai.comment.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import cn.damai.comment.R$anim;
import cn.damai.comment.bean.CommentImageInfoBean;
import cn.damai.comment.bean.CommentsItemBean;
import cn.damai.comment.bean.CommentsVideoBean;
import cn.damai.comment.net.CommentDeleteReponse;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import mtopsdk.common.util.SymbolExpUtil;
import tb.g41;
import tb.nb2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CommentItemMoreUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static OnCommentDeleteSuccessListener a;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.comment.util.CommentItemMoreUtil$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass3 extends DMMtopRequestListener<CommentDeleteReponse> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String val$commentId;
        final /* synthetic */ DamaiBaseActivity val$context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Class cls, String str, DamaiBaseActivity damaiBaseActivity) {
            super(cls);
            this.val$commentId = str;
            this.val$context = damaiBaseActivity;
        }

        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
        public void onFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-182532118")) {
                ipChange.ipc$dispatch("-182532118", new Object[]{this, str, str2});
                return;
            }
            if (CommentItemMoreUtil.a != null) {
                CommentItemMoreUtil.a.onFailure(str, str2);
            }
            this.val$context.stopProgressDialog();
            ToastUtil.a().e(this.val$context, "删除失败");
        }

        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
        public void onSuccess(CommentDeleteReponse commentDeleteReponse) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "959360557")) {
                ipChange.ipc$dispatch("959360557", new Object[]{this, commentDeleteReponse});
                return;
            }
            if (CommentItemMoreUtil.a != null) {
                CommentItemMoreUtil.a.onSuccess(this.val$commentId);
            }
            this.val$context.stopProgressDialog();
            ToastUtil.a().e(this.val$context, "删除成功");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public interface OnCommentDeleteSuccessListener {
        void onFailure(String str, String str2);

        void onSuccess(String str);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.comment.util.CommentItemMoreUtil$a */
    /* loaded from: classes13.dex */
    public class View$OnClickListenerC0450a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CommentsItemBean a;
        final /* synthetic */ String b;
        final /* synthetic */ DamaiBaseActivity c;

        View$OnClickListenerC0450a(CommentsItemBean commentsItemBean, String str, DamaiBaseActivity damaiBaseActivity) {
            this.a = commentsItemBean;
            this.b = str;
            this.c = damaiBaseActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-257649789")) {
                ipChange.ipc$dispatch("-257649789", new Object[]{this, view});
                return;
            }
            try {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString(g41.ISSUE_TYPE, g41.ISSUE_TYPE_EDIT);
                    bundle.putString(g41.ISSUE_PARAM_COMMENT_ID, this.a.getCommentId());
                    bundle.putString("projectName", this.b);
                    if (wh2.e(this.a.getGradeDOList()) > 0 && this.a.getGradeDOList().get(0) != null) {
                        String str = this.a.getGradeDOList().get(0).value;
                        if (!TextUtils.isEmpty(str)) {
                            bundle.putInt(g41.ISSUE_PARAM_GRADES, (int) Float.parseFloat(str));
                        }
                    }
                    if (wh2.e(this.a.getTextDOList()) > 0 && this.a.getTextDOList().get(0) != null) {
                        bundle.putString("text", this.a.getTextDOList().get(0).getValue());
                    }
                    bundle.putStringArrayList("images", CommentItemMoreUtil.d(this.a.getImageDOList()));
                    if (wh2.e(this.a.getSyncCircle()) > 0 && this.a.getSyncCircle().get(0) != null) {
                        bundle.putString("circleId", this.a.getSyncCircle().get(0).getCircleId());
                        bundle.putString("circleName", this.a.getSyncCircle().get(0).getCircleName());
                    }
                    DMNav.from(this.c).withExtras(bundle).toUri(NavUri.b("issue"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                ShareManager.E().C();
            }
        }
    }

    private static View b(DamaiBaseActivity damaiBaseActivity, String str, CommentsItemBean commentsItemBean) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-957900931") ? (View) ipChange.ipc$dispatch("-957900931", new Object[]{damaiBaseActivity, str, commentsItemBean}) : nb2.e(damaiBaseActivity, new View$OnClickListenerC0450a(commentsItemBean, str, damaiBaseActivity));
    }

    private static ArrayList<String> c(List<CommentImageInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-299354019")) {
            return (ArrayList) ipChange.ipc$dispatch("-299354019", new Object[]{list});
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (!TextUtils.isEmpty(list.get(i).url)) {
                    arrayList.add(list.get(i).url);
                }
            }
        }
        return arrayList;
    }

    public static ArrayList<String> d(List<CommentImageInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1240159035")) {
            return (ArrayList) ipChange.ipc$dispatch("-1240159035", new Object[]{list});
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < wh2.e(list); i++) {
            CommentImageInfoBean commentImageInfoBean = list.get(i);
            if (commentImageInfoBean != null) {
                arrayList.add(commentImageInfoBean.url);
            }
        }
        return arrayList;
    }

    private static Bundle e(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, String str11) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "428681938")) {
            return (Bundle) ipChange.ipc$dispatch("428681938", new Object[]{str, str2, str3, str4, str5, Integer.valueOf(i), str6, str7, str8, str9, str10, str11});
        }
        Bundle bundle = new Bundle();
        bundle.putString(g41.ISSUE_TYPE, g41.ISSUE_TYPE_EVALUATE);
        bundle.putString("targetId", str);
        bundle.putString("targetType", "0");
        bundle.putString(g41.ISSUE_PARAM_COMMENT_TYPE, "32");
        bundle.putString("itemId", str2);
        bundle.putString("projectName", str3);
        bundle.putString(g41.ISSUE_PARAM_PROJECT_POSTER, str4);
        bundle.putString(g41.ISSUE_PARAM_PERFORM_BEGIN_TIMR, str5);
        bundle.putString(g41.ISSUE_FROM, str6);
        bundle.putInt(g41.ISSUE_PARAM_GRADES, i);
        bundle.putString("timeAddress", str7);
        bundle.putString("circleId", str8);
        bundle.putString("circleName", str9);
        bundle.putString("themeId", str10);
        bundle.putString(g41.ISSUE_PARAM_LIVE_THEME_NAME, str11);
        return bundle;
    }

    public static void f(Context context, String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-70669461")) {
            ipChange.ipc$dispatch("-70669461", new Object[]{context, str, str2, str3, str4, str5, Integer.valueOf(i), str6, str7, Integer.valueOf(i2)});
        } else {
            DMNav.from(context).withExtras(e(str, str2, str3, str4, str5, i, str7, str6, null, null, null, null)).setTransition(R$anim.anim_bottom_in, R$anim.anim_no).forResult(i2).toUri(NavUri.b("issue"));
        }
    }

    public static void g(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-788547735")) {
            ipChange.ipc$dispatch("-788547735", new Object[]{context, str, str2, str3, str4, str5, str6});
        } else {
            DMNav.from(context).withExtras(e(str, str2, str3, str4, str5, 0, "", str6, null, null, null, null)).toUri(NavUri.b("issue"));
        }
    }

    public static void h(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1020336495")) {
            ipChange.ipc$dispatch("-1020336495", new Object[]{context, str, str2, str3, str4, str5, str6, str7, str8, str9, str10});
        } else {
            DMNav.from(context).withExtras(e(str, str2, str3, str4, str5, 0, "", str6, str7, str8, str9, str10)).toUri(NavUri.b("issue"));
        }
    }

    public static void i(DamaiBaseActivity damaiBaseActivity, String str, long j, String str2, String str3, String str4, String str5, CommentsItemBean commentsItemBean, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2101406361")) {
            ipChange.ipc$dispatch("-2101406361", new Object[]{damaiBaseActivity, str, Long.valueOf(j), str2, str3, str4, str5, commentsItemBean, Boolean.valueOf(z), Integer.valueOf(i)});
        } else {
            j(damaiBaseActivity, str, j, str2, str3, str4, str5, commentsItemBean, z, i, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0167 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void j(cn.damai.commonbusiness.base.DamaiBaseActivity r27, java.lang.String r28, long r29, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, cn.damai.comment.bean.CommentsItemBean r35, boolean r36, int r37, boolean r38) {
        /*
            Method dump skipped, instructions count: 703
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.comment.util.CommentItemMoreUtil.j(cn.damai.commonbusiness.base.DamaiBaseActivity, java.lang.String, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, cn.damai.comment.bean.CommentsItemBean, boolean, int, boolean):void");
    }

    public static void k(OnCommentDeleteSuccessListener onCommentDeleteSuccessListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1688398878")) {
            ipChange.ipc$dispatch("1688398878", new Object[]{onCommentDeleteSuccessListener});
        } else {
            a = onCommentDeleteSuccessListener;
        }
    }

    public static ArrayList<DMShareMessage.ExtraMedia> l(CommentsVideoBean commentsVideoBean, ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-744104030")) {
            return (ArrayList) ipChange.ipc$dispatch("-744104030", new Object[]{commentsVideoBean, arrayList});
        }
        ArrayList<DMShareMessage.ExtraMedia> arrayList2 = new ArrayList<>();
        if (commentsVideoBean != null && !TextUtils.isEmpty(commentsVideoBean.getCoverUrl()) && !commentsVideoBean.isVideoStatusUnReview()) {
            DMShareMessage.ExtraMedia extraMedia = new DMShareMessage.ExtraMedia();
            extraMedia.coverUrl = commentsVideoBean.getCoverUrl();
            extraMedia.isVideo = true;
            arrayList2.add(extraMedia);
        }
        if (wh2.e(arrayList) > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                DMShareMessage.ExtraMedia extraMedia2 = new DMShareMessage.ExtraMedia();
                extraMedia2.coverUrl = arrayList.get(i);
                extraMedia2.isVideo = false;
                arrayList2.add(extraMedia2);
            }
        }
        return arrayList2;
    }

    public static String m(String str, String str2) {
        String str3;
        String[] split;
        String[] split2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-983419347")) {
            return (String) ipChange.ipc$dispatch("-983419347", new Object[]{str, str2});
        }
        String str4 = "";
        if (!TextUtils.isEmpty(str)) {
            if (str.contains(" | ")) {
                if (str.split(" \\| ").length > 1) {
                    str4 = split2[0] + " | ";
                    str3 = " | " + split2[1];
                }
            } else if (str.contains("|")) {
                if (str.split(SymbolExpUtil.SYMBOL_VERTICALBAR).length > 1) {
                    str4 = split[0] + " | ";
                    str3 = " | " + split[1];
                }
            } else {
                str3 = " | " + str;
            }
            return str4 + str2 + str3;
        }
        str3 = "";
        return str4 + str2 + str3;
    }

    public static String n(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-851824541")) {
            return (String) ipChange.ipc$dispatch("-851824541", new Object[]{str, str2, str3});
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            sb.append(str);
            sb.append(" | ");
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            sb.append(" | ");
            sb.append(str3);
        }
        return sb.toString();
    }

    public static String o(Long l, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1726140759")) {
            return (String) ipChange.ipc$dispatch("1726140759", new Object[]{l, str});
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return simpleDateFormat.format(new Date(l.longValue()));
    }
}
