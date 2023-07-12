package tb;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.commonbusiness.search.bean.ProjectItemBean;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import cn.damai.discover.main.bean.PublishStateBean;
import cn.damai.discover.main.bean.ThemeShare;
import cn.damai.discover.main.ui.TabLiveActivity;
import cn.damai.discover.main.ui.listener.OnShareListener;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.issue.tool.IssueConstants;
import cn.damai.login.LoginManager;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class s90 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2047547783")) {
                ipChange.ipc$dispatch("-2047547783", new Object[]{this, valueAnimator});
                return;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            layoutParams.width = intValue;
            layoutParams.height = intValue;
            this.a.requestLayout();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        b(View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1417089158")) {
                ipChange.ipc$dispatch("-1417089158", new Object[]{this, valueAnimator});
            } else {
                this.a.scrollTo(0, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class c implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ FrameLayout a;

        c(FrameLayout frameLayout) {
            this.a = frameLayout;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1254772083")) {
                ipChange.ipc$dispatch("-1254772083", new Object[]{this, animation});
            } else {
                s90.m(this.a);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1967613383")) {
                ipChange.ipc$dispatch("1967613383", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-454961498")) {
                ipChange.ipc$dispatch("-454961498", new Object[]{this, animation});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class d implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnShareListener a;

        d(OnShareListener onShareListener) {
            this.a = onShareListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "147351975")) {
                ipChange.ipc$dispatch("147351975", new Object[]{this, dVar});
                return;
            }
            this.a.showLoading(false);
            this.a.toast("分享失败");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class e implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnShareListener a;
        final /* synthetic */ String b;
        final /* synthetic */ ThemeShare c;

        e(OnShareListener onShareListener, String str, ThemeShare themeShare) {
            this.a = onShareListener;
            this.b = str;
            this.c = themeShare;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Bitmap bitmap;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1399472636")) {
                ipChange.ipc$dispatch("1399472636", new Object[]{this, eVar});
                return;
            }
            this.a.showLoading(false);
            if (eVar == null || (bitmap = eVar.b) == null) {
                return;
            }
            try {
                String d = j11.d(this.b, bitmap, mu0.a());
                ThemeShare themeShare = this.c;
                String str = themeShare.shareTitle;
                String str2 = themeShare.shareSubTitle;
                String str3 = themeShare.shareImage;
                String str4 = themeShare.shareUrl;
                Bundle bundle = new Bundle();
                bundle.putString("title", str);
                bundle.putString("projectName", str);
                bundle.putString("message", str2);
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("imageurl", str3);
                    bundle.putString("projectImage", str3);
                }
                if (!TextUtils.isEmpty(d)) {
                    bundle.putString("sinaSharePath", d);
                }
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString("producturl", str4);
                }
                bundle.putBoolean("showGenerateImage", true);
                bundle.putString("shareType", "chat_h5");
                bundle.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_THEME_IMAGE);
                this.a.openShareView(bundle);
            } catch (Exception unused) {
                this.a.toast("分享失败");
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class f {
        public final ValueAnimator a;
        public final boolean b;

        public f(ValueAnimator valueAnimator, boolean z) {
            this.a = valueAnimator;
            this.b = z;
        }
    }

    @SuppressLint({"NewApi"})
    public static void b(View view, boolean z, int i) {
        ValueAnimator ofInt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-258588489")) {
            ipChange.ipc$dispatch("-258588489", new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i)});
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof f) {
            f fVar = (f) tag;
            if (fVar.b == z) {
                return;
            }
            fVar.a.cancel();
        }
        if (z) {
            ofInt = ValueAnimator.ofInt(0, i);
        } else {
            int min = Math.min(view.getMeasuredHeight(), i);
            if (min < 0) {
                min = 0;
            }
            ofInt = ValueAnimator.ofInt(min, 0);
        }
        ofInt.setDuration(300L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new a(view));
        ofInt.start();
        view.setTag(new f(ofInt, z));
    }

    @SuppressLint({"NewApi"})
    public static void c(View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1217332142")) {
            ipChange.ipc$dispatch("1217332142", new Object[]{view, Boolean.valueOf(z)});
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof f) {
            f fVar = (f) tag;
            if (fVar.b == z) {
                return;
            }
            fVar.a.cancel();
        }
        ValueAnimator ofInt = z ? ValueAnimator.ofInt(view.getScrollY(), 0) : ValueAnimator.ofInt(view.getScrollY(), -view.getMeasuredHeight());
        ofInt.setDuration(300L);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new b(view));
        ofInt.start();
        view.setTag(new f(ofInt, z));
    }

    public static String d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1306347010")) {
            return (String) ipChange.ipc$dispatch("1306347010", new Object[0]);
        }
        if (LoginManager.k().q()) {
            String headPicLink = Login.getHeadPicLink();
            if (TextUtils.isEmpty(headPicLink)) {
                return null;
            }
            return z20.B(headPicLink);
        }
        return null;
    }

    public static int e(BaseResponse baseResponse) {
        NodeData item;
        JSONArray jSONArray;
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-1497828567")) {
            return ((Integer) ipChange.ipc$dispatch("-1497828567", new Object[]{baseResponse})).intValue();
        }
        if (baseResponse != null) {
            try {
                if (!cb2.d(baseResponse.layers)) {
                    Iterator<BaseLayer> it = baseResponse.layers.iterator();
                    while (it.hasNext()) {
                        List<BaseSection> sections = it.next().getSections();
                        if (!cb2.d(sections)) {
                            for (BaseSection baseSection : sections) {
                                if (db.j(baseSection.getComponentId()) && (item = baseSection.getItem()) != null && (jSONArray = item.getJSONArray("card")) != null) {
                                    i += jSONArray.size();
                                }
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return i;
    }

    public static boolean f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-814573682")) {
            return ((Boolean) ipChange.ipc$dispatch("-814573682", new Object[0])).booleanValue();
        }
        String B = z20.B("KEY_SAVE_PUBLISH_TIP_SHOWED");
        if (TextUtils.isEmpty(B)) {
            return false;
        }
        return i(new Date(jm1.k(B, System.currentTimeMillis())), new Date());
    }

    public static boolean g(List<?> list) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1593000728") ? ((Boolean) ipChange.ipc$dispatch("-1593000728", new Object[]{list})).booleanValue() : list == null || list.size() <= 0;
    }

    public static boolean h(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254032904")) {
            return ((Boolean) ipChange.ipc$dispatch("-1254032904", new Object[]{recyclerView})).booleanValue();
        }
        if (recyclerView != null) {
            try {
                View childAt = recyclerView.getChildAt(0);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (childAt != null && layoutManager != null) {
                    return layoutManager.getPosition(childAt) > 8;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static boolean i(Date date, Date date2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1632417872")) {
            return ((Boolean) ipChange.ipc$dispatch("1632417872", new Object[]{date, date2})).booleanValue();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(6);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return i == calendar2.get(6);
    }

    public static void j(Activity activity, ProjectItemBean projectItemBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1429233020")) {
            ipChange.ipc$dispatch("1429233020", new Object[]{activity, projectItemBean});
        } else if (activity == null || activity.isFinishing() || projectItemBean == null) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(IssueConstants.ProjectID, projectItemBean.id);
            bundle.putString("projectName", projectItemBean.name);
            bundle.putString("projectImage", projectItemBean.verticalPic);
            qd2.a(activity, projectItemBean.schema, bundle);
        }
    }

    public static void k(Activity activity, PublishStateBean publishStateBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2119585178")) {
            ipChange.ipc$dispatch("-2119585178", new Object[]{activity, publishStateBean, Integer.valueOf(i)});
        } else if (activity == null || activity.isFinishing() || publishStateBean == null || !publishStateBean.isNeedShowPublishBtn()) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("appPublishHint", publishStateBean.appPublishHint);
            bundle.putString(g41.ISSUE_TYPE, g41.ISSUE_TYPE_PRIVILEGE);
            bundle.putString(g41.ISSUE_PARAM_COMMENT_TYPE, "62");
            bundle.putString("targetType", "0");
            bundle.putString("themeId", publishStateBean.themeId);
            bundle.putString(g41.ISSUE_PARAM_LIVE_THEME_NAME, publishStateBean.themeName);
            if (activity instanceof TabLiveActivity) {
                bundle.putBoolean(g41.ISSUE_PARAM_TOAST_SWITCH, false);
            }
            DMNav.from(activity).withExtras(bundle).forResult(i).toUri(NavUri.b("issue"));
        }
    }

    public static void l(Activity activity, PublishStateBean publishStateBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-852033056")) {
            ipChange.ipc$dispatch("-852033056", new Object[]{activity, publishStateBean, Integer.valueOf(i)});
        } else if (activity == null || activity.isFinishing() || publishStateBean == null || !publishStateBean.isNeedShowPublishBtn()) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("appPublishHint", publishStateBean.appPublishHint);
            bundle.putString(g41.ISSUE_TYPE, g41.ISSUE_TYPE_PRIVILEGE);
            bundle.putString(g41.ISSUE_PARAM_COMMENT_TYPE, "62");
            bundle.putString("targetType", "0");
            bundle.putString("circleId", publishStateBean.themeId);
            bundle.putString("circleName", publishStateBean.themeName);
            if (activity instanceof TabLiveActivity) {
                bundle.putBoolean(g41.ISSUE_PARAM_TOAST_SWITCH, false);
            }
            DMNav.from(activity).withExtras(bundle).forResult(i).toUri(NavUri.b("issue"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(FrameLayout frameLayout) {
        View findViewById;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2002711892")) {
            ipChange.ipc$dispatch("2002711892", new Object[]{frameLayout});
        } else if (frameLayout == null || (findViewById = frameLayout.findViewById(R$id.animation_view_id_after_publish)) == null) {
        } else {
            frameLayout.removeView(findViewById);
        }
    }

    public static void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1731464910")) {
            ipChange.ipc$dispatch("-1731464910", new Object[0]);
            return;
        }
        z20.T("KEY_SAVE_PUBLISH_TIP_SHOWED", System.currentTimeMillis() + "");
    }

    public static void o(FrameLayout frameLayout) {
        long j;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "437770099")) {
            ipChange.ipc$dispatch("437770099", new Object[]{frameLayout});
        } else if (frameLayout == 0 || frameLayout.getContext() == null) {
        } else {
            int width = frameLayout.getWidth();
            int height = frameLayout.getHeight();
            if (width <= 0 || height <= 0) {
                return;
            }
            int i = R$id.animation_view_id_after_publish;
            if (frameLayout.findViewById(i) == null) {
                Context context = frameLayout.getContext();
                int a2 = m62.a(context, 160.0f);
                int a3 = m62.a(context, 214.0f);
                ImageView imageView = new ImageView(context);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a3);
                layoutParams.gravity = 17;
                imageView.setLayoutParams(layoutParams);
                imageView.setId(i);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setBackgroundResource(R$drawable.icon_tip_after_publish_success);
                frameLayout.addView(imageView);
                AnimationSet animationSet = new AnimationSet(false);
                float f2 = a2 / 2;
                float f3 = a3 / 2;
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.6f, 1.0f, 0.6f, 1.0f, f2, f3);
                scaleAnimation.setDuration(300L);
                animationSet.addAnimation(scaleAnimation);
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, f2, f3);
                scaleAnimation2.setDuration(50L);
                scaleAnimation2.setStartOffset((int) (0 + scaleAnimation.getDuration()));
                animationSet.addAnimation(scaleAnimation2);
                AnimationSet animationSet2 = new AnimationSet(true);
                ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.0f, 0.2f, 1.0f, 0.2f, a2, a3);
                scaleAnimation3.setDuration(700L);
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (width - a2) / 2, 0.0f, (height - a3) / 2);
                translateAnimation.setDuration(700L);
                animationSet2.addAnimation(scaleAnimation3);
                animationSet2.addAnimation(translateAnimation);
                animationSet2.setInterpolator(new AccelerateInterpolator());
                animationSet2.setStartOffset(((int) (j + scaleAnimation2.getDuration())) + 300);
                animationSet.addAnimation(animationSet2);
                animationSet.setAnimationListener(new c(frameLayout));
                imageView.startAnimation(animationSet);
            }
        }
    }

    public static void p(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1652621977")) {
            ipChange.ipc$dispatch("1652621977", new Object[]{textView, str});
        } else if (textView != null) {
            if (TextUtils.isEmpty(str)) {
                textView.setVisibility(8);
                return;
            }
            textView.setText(str);
            textView.setVisibility(0);
        }
    }

    public static void q(OnShareListener onShareListener, ThemeShare themeShare) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1697737609")) {
            ipChange.ipc$dispatch("1697737609", new Object[]{onShareListener, themeShare});
        } else if (themeShare == null || !themeShare.isValid()) {
        } else {
            String str = themeShare.shareImage;
            Application a2 = mu0.a();
            cn.damai.common.image.a.b().f(str, m62.a(a2, 111.0f), m62.a(a2, 148.0f)).n(new e(onShareListener, str, themeShare)).e(new d(onShareListener)).f();
        }
    }
}
