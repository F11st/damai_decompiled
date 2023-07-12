package tb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.ViewModelProviders;
import cn.damai.common.image.DMImageCreator;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.user.repertoite.view.AttentionView;
import cn.damai.user.userprofile.UserIndexActivity;
import cn.damai.user.userprofile.UserIndexViewModel;
import cn.damai.user.userprofile.bean.UserData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class iw0 extends ob {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class a implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ Activity b;
        final /* synthetic */ String c;

        a(View view, Activity activity, String str) {
            this.a = view;
            this.b = activity;
            this.c = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-902419546")) {
                ipChange.ipc$dispatch("-902419546", new Object[]{this, eVar});
            } else if (eVar == null || eVar.b == null) {
            } else {
                ((ImageView) this.a.findViewById(R$id.user_iv_header)).setImageDrawable(new ui(eVar.b));
                Activity activity = this.b;
                if (activity instanceof UserIndexActivity) {
                    ((UserIndexViewModel) ViewModelProviders.of((UserIndexActivity) activity).get(UserIndexViewModel.class)).sinapath = iw0.f(this.c, eVar.b, this.b);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ String b;

        b(Activity activity, String str) {
            this.a = activity;
            this.b = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1510496409")) {
                ipChange.ipc$dispatch("-1510496409", new Object[]{this, eVar});
            } else if (eVar == null || eVar.b == null) {
            } else {
                Activity activity = this.a;
                if (activity instanceof UserIndexActivity) {
                    ((UserIndexViewModel) ViewModelProviders.of((UserIndexActivity) activity).get(UserIndexViewModel.class)).sinapath = iw0.f(this.b, eVar.b, this.a);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ UserData b;
        final /* synthetic */ View c;

        c(Activity activity, UserData userData, View view) {
            this.a = activity;
            this.b = userData;
            this.c = view;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2118573272")) {
                ipChange.ipc$dispatch("-2118573272", new Object[]{this, eVar});
                return;
            }
            Activity activity = this.a;
            if (activity == null) {
                return;
            }
            Drawable[] drawableArr = new Drawable[2];
            drawableArr[1] = activity.getResources().getDrawable(R$drawable.account_header_gradient_bg);
            if (this.b.type != 1 || eVar == null || (drawable = eVar.a) == null) {
                return;
            }
            drawableArr[0] = drawable;
            this.c.setBackground(new LayerDrawable(drawableArr));
        }
    }

    public static SpannableString d(long j, String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2097946863")) {
            return (SpannableString) ipChange.ipc$dispatch("-2097946863", new Object[]{Long.valueOf(j), str, Boolean.valueOf(z)});
        }
        float f = z ? 1.0f : 0.6f;
        try {
            if (j < 10000) {
                String e = e(j, str);
                SpannableString spannableString = new SpannableString(e);
                spannableString.setSpan(new RelativeSizeSpan(f), e.length() - str.length(), e.length(), 33);
                return spannableString;
            }
            String e2 = e(j, str);
            SpannableString spannableString2 = new SpannableString(e2);
            spannableString2.setSpan(new RelativeSizeSpan(f), (e2.length() - str.length()) - 1, e2.length(), 33);
            return spannableString2;
        } catch (Exception e3) {
            e3.printStackTrace();
            return new SpannableString("");
        }
    }

    public static String e(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-872559548")) {
            return (String) ipChange.ipc$dispatch("-872559548", new Object[]{Long.valueOf(j), str});
        }
        try {
            if (j < 10000) {
                return j + str;
            }
            return (((float) (j / 1000)) / 10.0f) + "万" + str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String f(String str, Bitmap bitmap, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "961217791")) {
            return (String) ipChange.ipc$dispatch("961217791", new Object[]{str, bitmap, context});
        }
        try {
            return ir1.i(mr1.STORAGE) ? j11.d(str, bitmap, context) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static void g(UserData userData, AttentionView attentionView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1046515965")) {
            ipChange.ipc$dispatch("-1046515965", new Object[]{userData, attentionView});
        } else if (attentionView == null) {
        } else {
            if (userData.bid != 0) {
                attentionView.setInitParams(userData.bid + "", userData.type + "");
            } else if (!TextUtils.isEmpty(userData.havanaIdStr)) {
                attentionView.setInitParams(userData.havanaIdStr + "", userData.type + "");
            } else {
                attentionView.setInitParams(userData.userId + "", userData.type + "");
            }
            attentionView.setVisibility(0);
            attentionView.setState(userData.favoriteFlag);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0410 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0319  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void h(android.app.Activity r17, cn.damai.user.userprofile.bean.UserData r18, android.view.View r19, int r20) {
        /*
            Method dump skipped, instructions count: 1073
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.iw0.h(android.app.Activity, cn.damai.user.userprofile.bean.UserData, android.view.View, int):void");
    }
}
