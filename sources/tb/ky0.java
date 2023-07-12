package tb;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import cn.damai.homepage.bean.HomeConfigBean;
import cn.damai.homepage.bean.HomeConfigPopBean;
import cn.damai.homepage.ui.view.HomeLottieView;
import cn.damai.homepage.util.ZipDownLoadManager;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ky0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ky0 d;
    private Context a;
    private LottieAnimationView b;
    private LottieListener c = new d();

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements ZipDownLoadManager.OnZipDownLoadListsner {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.homepage.util.ZipDownLoadManager.OnZipDownLoadListsner
        public void onFailure() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1962759999")) {
                ipChange.ipc$dispatch("1962759999", new Object[]{this});
            } else {
                xr.c("LottieDownLoadSuccess", "");
            }
        }

        @Override // cn.damai.homepage.util.ZipDownLoadManager.OnZipDownLoadListsner
        public void onSuccess(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "3782256")) {
                ipChange.ipc$dispatch("3782256", new Object[]{this, str});
                return;
            }
            xr.c("LottieDownLoadSuccess", str);
            z20.T("paopaodate", ky0.this.g());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class b implements ImageAssetDelegate {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        b(ky0 ky0Var, String str) {
            this.a = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0080 A[Catch: IOException -> 0x0084, TRY_LEAVE, TryCatch #2 {IOException -> 0x0084, blocks: (B:32:0x0079, B:34:0x0080), top: B:41:0x0079 }] */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileInputStream] */
        /* JADX WARN: Type inference failed for: r2v5, types: [java.io.FileInputStream, java.io.InputStream] */
        @Override // com.airbnb.lottie.ImageAssetDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.graphics.Bitmap fetchBitmap(tb.jc1 r7) {
            /*
                r6 = this;
                java.lang.String r0 = "HomePageLottieHelper"
                com.android.alibaba.ip.runtime.IpChange r1 = tb.ky0.b.$ipChange
                java.lang.String r2 = "-1716022274"
                boolean r3 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r1, r2)
                r4 = 1
                if (r3 == 0) goto L1c
                r0 = 2
                java.lang.Object[] r0 = new java.lang.Object[r0]
                r3 = 0
                r0[r3] = r6
                r0[r4] = r7
                java.lang.Object r7 = r1.ipc$dispatch(r2, r0)
                android.graphics.Bitmap r7 = (android.graphics.Bitmap) r7
                return r7
            L1c:
                r1 = 0
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
                r3.<init>()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
                java.lang.String r5 = r6.a     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
                r3.append(r5)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
                java.lang.String r5 = java.io.File.separator     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
                r3.append(r5)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
                java.lang.String r7 = r7.b()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
                r3.append(r7)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
                java.lang.String r7 = r3.toString()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
                r2.<init>(r7)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
                android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch: java.lang.Exception -> L57 java.lang.Throwable -> L77
                if (r7 != 0) goto L4b
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch: java.io.IOException -> L49
                android.graphics.Bitmap r7 = android.graphics.Bitmap.createBitmap(r4, r4, r1)     // Catch: java.io.IOException -> L49
                goto L4b
            L49:
                r1 = move-exception
                goto L4f
            L4b:
                r2.close()     // Catch: java.io.IOException -> L49
                goto L76
            L4f:
                java.lang.String r1 = r1.getMessage()
                tb.cb1.b(r0, r1)
                goto L76
            L57:
                r7 = move-exception
                goto L5d
            L59:
                r7 = move-exception
                goto L79
            L5b:
                r7 = move-exception
                r2 = r1
            L5d:
                r7.printStackTrace()     // Catch: java.lang.Throwable -> L77
                android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ALPHA_8     // Catch: java.io.IOException -> L6d
                android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r4, r4, r7)     // Catch: java.io.IOException -> L6d
                if (r2 == 0) goto L6b
                r2.close()     // Catch: java.io.IOException -> L6d
            L6b:
                r7 = r1
                goto L76
            L6d:
                r7 = move-exception
                java.lang.String r7 = r7.getMessage()
                tb.cb1.b(r0, r7)
                goto L6b
            L76:
                return r7
            L77:
                r7 = move-exception
                r1 = r2
            L79:
                android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ALPHA_8     // Catch: java.io.IOException -> L84
                android.graphics.Bitmap.createBitmap(r4, r4, r2)     // Catch: java.io.IOException -> L84
                if (r1 == 0) goto L8c
                r1.close()     // Catch: java.io.IOException -> L84
                goto L8c
            L84:
                r1 = move-exception
                java.lang.String r1 = r1.getMessage()
                tb.cb1.b(r0, r1)
            L8c:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.ky0.b.fetchBitmap(tb.jc1):android.graphics.Bitmap");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class c implements Animator.AnimatorListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ HomeLottieView a;
        final /* synthetic */ String b;

        c(ky0 ky0Var, HomeLottieView homeLottieView, String str) {
            this.a = homeLottieView;
            this.b = str;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-621640826")) {
                ipChange.ipc$dispatch("-621640826", new Object[]{this, animator});
            } else {
                this.a.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "511890793")) {
                ipChange.ipc$dispatch("511890793", new Object[]{this, animator});
                return;
            }
            this.a.setVisibility(8);
            this.a.cancelAnimation();
            dw2.b(new File(this.b), true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1691934789")) {
                ipChange.ipc$dispatch("1691934789", new Object[]{this, animator});
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "856378498")) {
                ipChange.ipc$dispatch("856378498", new Object[]{this, animator});
            } else {
                this.a.setVisibility(0);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class d implements LottieListener<com.airbnb.lottie.a> {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(com.airbnb.lottie.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1300973226")) {
                ipChange.ipc$dispatch("1300973226", new Object[]{this, aVar});
                return;
            }
            ky0.this.b.setComposition(aVar);
            ky0.this.b.playAnimation();
        }
    }

    private String c(File file) {
        File[] listFiles;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1242596339")) {
            return (String) ipChange.ipc$dispatch("1242596339", new Object[]{this, file});
        }
        String str = "";
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    String name = file2.getName();
                    if (name.endsWith(".png") && !name.startsWith(JSMethod.NOT_SET) && !name.startsWith(".")) {
                        str = file2.getAbsolutePath();
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    break;
                }
            }
        }
        return str;
    }

    public static ky0 d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1438478393")) {
            return (ky0) ipChange.ipc$dispatch("-1438478393", new Object[0]);
        }
        if (d == null) {
            d = new ky0();
        }
        return d;
    }

    private String e(File file) {
        File[] listFiles;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-688844111")) {
            return (String) ipChange.ipc$dispatch("-688844111", new Object[]{this, file});
        }
        String str = "";
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    String name = file2.getName();
                    if (name.endsWith(".json") && !name.startsWith(JSMethod.NOT_SET) && !name.startsWith(".")) {
                        str = file2.getAbsolutePath();
                    }
                } else {
                    str = e(file2);
                }
                if (!TextUtils.isEmpty(str)) {
                    break;
                }
            }
        }
        return str;
    }

    private String f(File file) {
        File[] listFiles;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1250796461")) {
            return (String) ipChange.ipc$dispatch("1250796461", new Object[]{this, file});
        }
        String str = "";
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    if (!name.startsWith(JSMethod.NOT_SET) && !name.startsWith(".")) {
                        str = file2.getAbsolutePath();
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    break;
                }
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1731985448") ? (String) ipChange.ipc$dispatch("-1731985448", new Object[]{this}) : new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT).format(new Date(System.currentTimeMillis()));
    }

    private String h(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-973633065")) {
            return (String) ipChange.ipc$dispatch("-973633065", new Object[]{this, context});
        }
        if (dw2.d()) {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getExternalCacheDir());
            String str = File.separator;
            sb.append(str);
            sb.append("cn.damai");
            sb.append(str);
            sb.append("lottieCache");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getCacheDir().getPath());
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("cn.damai");
        sb2.append(str2);
        sb2.append("lottieCache");
        return sb2.toString();
    }

    public void i(HomeConfigBean homeConfigBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1651767190")) {
            ipChange.ipc$dispatch("-1651767190", new Object[]{this, homeConfigBean});
            return;
        }
        HomeConfigPopBean homeConfigPopBean = homeConfigBean.pop;
        if (homeConfigPopBean == null) {
            return;
        }
        String str = homeConfigPopBean.icon;
        this.a = mu0.a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String B = z20.B("paopaodate");
        if (B == null || !B.equals(g())) {
            new ZipDownLoadManager().h(str).f(h(this.a)).g(new a()).e();
        }
    }

    @SuppressLint({"NewApi"})
    public void j(HomeLottieView homeLottieView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "766969943")) {
            ipChange.ipc$dispatch("766969943", new Object[]{this, homeLottieView, str});
            return;
        }
        this.b = homeLottieView.getLottieView();
        try {
            String e = e(new File(str));
            if (TextUtils.isEmpty(e)) {
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(e));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            String c2 = c(new File(e).getParentFile());
            if (!TextUtils.isEmpty(c2)) {
                homeLottieView.setBgImage(c2);
            }
            String f = f(new File(e).getParentFile());
            if (!TextUtils.isEmpty(f)) {
                homeLottieView.setImageAssetDelegate(new b(this, f));
            }
            com.airbnb.lottie.b.m(sb.toString(), "homeLottie").f(this.c);
            homeLottieView.addAnimatorListener(new c(this, homeLottieView, str));
        } catch (Exception e2) {
            cb1.b("HomePageLottieHelper", e2.getMessage());
        }
    }
}
