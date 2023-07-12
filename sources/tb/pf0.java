package tb;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import cn.damai.common.askpermission.OnGrantListener;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.issue.net.CommentGradeText;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.pictures.uploader.FileUploader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class pf0 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1226725188")) {
                ipChange.ipc$dispatch("-1226725188", new Object[]{this, valueAnimator});
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
    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        b(View view) {
            this.a = view;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1064477405")) {
                ipChange.ipc$dispatch("-1064477405", new Object[]{this, animator});
            } else {
                pf0.i(this.a);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1792104212")) {
                ipChange.ipc$dispatch("-1792104212", new Object[]{this, animator});
            } else {
                pf0.i(this.a);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1249098210")) {
                ipChange.ipc$dispatch("1249098210", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1374663867")) {
                ipChange.ipc$dispatch("-1374663867", new Object[]{this, animator});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class c implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;

        c(View view) {
            this.a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-672913008")) {
                ipChange.ipc$dispatch("-672913008", new Object[]{this, animation});
            } else {
                this.a.setVisibility(8);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1643310052")) {
                ipChange.ipc$dispatch("1643310052", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "365861097")) {
                ipChange.ipc$dispatch("365861097", new Object[]{this, animation});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class d implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        d(Activity activity, int i, int i2) {
            this.a = activity;
            this.b = i;
            this.c = i2;
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-869657593")) {
                ipChange.ipc$dispatch("-869657593", new Object[]{this});
                return;
            }
            try {
                i41.i().q("video_upload");
                s11.b(this.a, this.b, true, this.c, "2", null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static class e {
        public final ValueAnimator a;
        public final boolean b;

        public e(ValueAnimator valueAnimator, boolean z) {
            this.a = valueAnimator;
            this.b = z;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    private static class f {
        private static final pf0 a = new pf0();
    }

    public static void b(View view, boolean z, int i) {
        ValueAnimator ofInt;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-115067948")) {
            ipChange.ipc$dispatch("-115067948", new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i)});
            return;
        }
        Object tag = view.getTag();
        if (Build.VERSION.SDK_INT >= 11) {
            if (tag instanceof e) {
                e eVar = (e) tag;
                if (eVar.b == z) {
                    return;
                }
                eVar.a.cancel();
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
            view.setTag(new e(ofInt, z));
        }
    }

    public static int c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1067176920")) {
            return ((Integer) ipChange.ipc$dispatch("1067176920", new Object[]{str})).intValue();
        }
        if (str == null || str.length() <= 0 || TextUtils.isEmpty(str)) {
            return 0;
        }
        return str.replace(" ", "").length();
    }

    public static ArrayList<Image> d(ArrayList<String> arrayList, Image image, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2114695082")) {
            return (ArrayList) ipChange.ipc$dispatch("2114695082", new Object[]{arrayList, image, str});
        }
        ArrayList<Image> arrayList2 = new ArrayList<>();
        if (image != null) {
            arrayList2.add(image);
        }
        if (arrayList != null && arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                Image image2 = new Image();
                image2.setPath(arrayList.get(i));
                image2.setType(str);
                arrayList2.add(image2);
            }
        }
        return arrayList2;
    }

    public static String f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "662212841")) {
            return (String) ipChange.ipc$dispatch("662212841", new Object[]{str});
        }
        if (str.startsWith("http")) {
            return str;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        pi0.INSTANCE.c(FileUploader.n, str, options);
        String str2 = options.outMimeType;
        if ((str2 != null && str2.toLowerCase().endsWith("gif")) || str.toLowerCase().endsWith(".gif")) {
            try {
                Bitmap d2 = w11.d(str, 400, 400);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                d2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                File l = l(t6.INSTANCE.getAppContext(), byteArrayOutputStream.toByteArray(), ".png");
                d2.recycle();
                byteArrayOutputStream.close();
                if (l != null) {
                    return l.getAbsolutePath();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    public static final pf0 g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1014976357") ? (pf0) ipChange.ipc$dispatch("-1014976357", new Object[0]) : f.a;
    }

    public static void h(View view, LottieAnimationView lottieAnimationView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2007983753")) {
            ipChange.ipc$dispatch("2007983753", new Object[]{view, lottieAnimationView});
            return;
        }
        z20.T(g41.a, g41.b);
        view.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) lottieAnimationView.getLayoutParams();
        layoutParams.height = 310;
        layoutParams.width = com.alipay.sdk.m.u.n.g;
        lottieAnimationView.setImageAssetsFolder("imagesissue/");
        lottieAnimationView.setAnimation("lottie_issue_guide.json");
        lottieAnimationView.playAnimation();
        if (Build.VERSION.SDK_INT >= 11) {
            lottieAnimationView.addAnimatorListener(new b(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1640743686")) {
            ipChange.ipc$dispatch("-1640743686", new Object[]{view});
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        view.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new c(view));
    }

    public static void j(Activity activity, int i, boolean z, int i2, ArrayList<Image> arrayList, String str, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "629511501")) {
            ipChange.ipc$dispatch("629511501", new Object[]{activity, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), arrayList, str, Integer.valueOf(i3)});
            return;
        }
        try {
            s11.d(activity, arrayList, arrayList, z, i2, i, str, i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void k(Activity activity, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1771034700")) {
            ipChange.ipc$dispatch("-1771034700", new Object[]{activity, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            ir1.b(activity, false, mr1.STORAGE, "用于选取视频文件进行发布", new d(activity, i, i2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0054 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.io.File l(android.content.Context r4, byte[] r5, java.lang.String r6) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = tb.pf0.$ipChange
            java.lang.String r1 = "-830712558"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L1d
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r4 = 1
            r2[r4] = r5
            r4 = 2
            r2[r4] = r6
            java.lang.Object r4 = r0.ipc$dispatch(r1, r2)
            java.io.File r4 = (java.io.File) r4
            return r4
        L1d:
            r0 = 0
            java.lang.String r1 = "upload_decode"
            java.io.File r4 = r4.getCacheDir()     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L40
            java.io.File r4 = java.io.File.createTempFile(r1, r6, r4)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L40
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L40
            r6.<init>(r4)     // Catch: java.lang.Throwable -> L3e java.io.IOException -> L40
            r6.write(r5)     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L50
            r6.flush()     // Catch: java.io.IOException -> L3c java.lang.Throwable -> L50
            r6.close()     // Catch: java.io.IOException -> L37
            goto L3b
        L37:
            r5 = move-exception
            r5.printStackTrace()
        L3b:
            return r4
        L3c:
            r4 = move-exception
            goto L42
        L3e:
            r4 = move-exception
            goto L52
        L40:
            r4 = move-exception
            r6 = r0
        L42:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L50
            if (r6 == 0) goto L4f
            r6.close()     // Catch: java.io.IOException -> L4b
            goto L4f
        L4b:
            r4 = move-exception
            r4.printStackTrace()
        L4f:
            return r0
        L50:
            r4 = move-exception
            r0 = r6
        L52:
            if (r0 == 0) goto L5c
            r0.close()     // Catch: java.io.IOException -> L58
            goto L5c
        L58:
            r5 = move-exception
            r5.printStackTrace()
        L5c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.pf0.l(android.content.Context, byte[], java.lang.String):java.io.File");
    }

    public String e(int i, ArrayList<CommentGradeText> arrayList, String str) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-793789234")) {
            return (String) ipChange.ipc$dispatch("-793789234", new Object[]{this, Integer.valueOf(i), arrayList, str});
        }
        if (i == 0) {
            return str;
        }
        String str2 = i <= 2 ? "1" : i <= 4 ? "2" : i <= 6 ? "3" : i <= 8 ? "4" : "5";
        if (arrayList == null || arrayList.size() <= 0) {
            return str;
        }
        while (arrayList.size() > 0) {
            if (str2.equals(arrayList.get(i2).getLevel())) {
                return arrayList.get(i2).getText();
            }
            i2++;
        }
        return str;
    }

    public void m(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "665899872")) {
            ipChange.ipc$dispatch("665899872", new Object[]{this, view});
        } else if (view.getVisibility() == 0) {
            view.setVisibility(8);
        }
    }

    public void n(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-40258330")) {
            ipChange.ipc$dispatch("-40258330", new Object[]{this, view});
        } else if (view.getVisibility() == 0 || view.getVisibility() == 8) {
            view.setVisibility(4);
        }
    }

    public void o(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1587146005")) {
            ipChange.ipc$dispatch("-1587146005", new Object[]{this, view});
        } else if (view.getVisibility() == 8 || view.getVisibility() == 4) {
            view.setVisibility(0);
        }
    }
}
