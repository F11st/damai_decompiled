package cn.damai.homepage.helper;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import cn.damai.commonbusiness.home.bean.HeadLottieBean;
import cn.damai.commonbusiness.home.bean.HeadLottieStyleBean;
import cn.damai.homepage.util.ZipDownLoadManager;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.preloader.Preloader;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class HomePageTopLottieHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private static HomePageTopLottieHelper k;
    private List<HeadLottieStyleBean> a;
    private HeadLottieBean b;
    private View c;
    private LottieAnimationView d;
    private OnLoadResultListener f;
    private Context g;
    private List<LottiePath> e = new ArrayList();
    private int h = 0;
    private boolean i = true;
    private LottieListener j = new c();

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class LottiePath implements Serializable {
        private static final long serialVersionUID = 950802914233960394L;
        public Bitmap[] bitmaps;
        public int imageNum;
        public String imagePath;
        public String jsonPath;

        public LottiePath(String str, String str2, int i) {
            this.jsonPath = str;
            this.imagePath = str2;
            this.imageNum = i;
            this.bitmaps = new Bitmap[i];
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface OnLoadResultListener {
        void onFailed();

        void onSuccess();

        void onUpdateStyle(HeadLottieStyleBean headLottieStyleBean);
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class a implements ZipDownLoadManager.OnZipDownLoadListsner {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // cn.damai.homepage.util.ZipDownLoadManager.OnZipDownLoadListsner
        public void onFailure() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-676987068")) {
                ipChange.ipc$dispatch("-676987068", new Object[]{this});
            } else {
                HomePageTopLottieHelper.this.t(this.a);
            }
        }

        @Override // cn.damai.homepage.util.ZipDownLoadManager.OnZipDownLoadListsner
        public void onSuccess(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-581155019")) {
                ipChange.ipc$dispatch("-581155019", new Object[]{this, str});
            } else if (!HomePageTopLottieHelper.this.p(str)) {
                HomePageTopLottieHelper.this.t(this.a);
            } else {
                z20.T(this.a, str);
                z20.T(this.a + "1", HomePageTopLottieHelper.this.b.zipUrl);
                HomePageTopLottieHelper.this.w();
                HomePageTopLottieHelper.this.f.onSuccess();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class b implements ImageAssetDelegate {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottiePath a;

        b(LottiePath lottiePath) {
            this.a = lottiePath;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x008f A[Catch: IOException -> 0x0093, TRY_LEAVE, TryCatch #2 {IOException -> 0x0093, blocks: (B:34:0x0088, B:36:0x008f), top: B:43:0x0088 }] */
        @Override // com.airbnb.lottie.ImageAssetDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.graphics.Bitmap fetchBitmap(tb.jc1 r6) {
            /*
                r5 = this;
                com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.homepage.helper.HomePageTopLottieHelper.b.$ipChange
                java.lang.String r1 = "1341727458"
                boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                r3 = 1
                if (r2 == 0) goto L1a
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r4 = 0
                r2[r4] = r5
                r2[r3] = r6
                java.lang.Object r6 = r0.ipc$dispatch(r1, r2)
                android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
                return r6
            L1a:
                r0 = 0
                java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r2.<init>()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                cn.damai.homepage.helper.HomePageTopLottieHelper$LottiePath r4 = r5.a     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                java.lang.String r4 = r4.imagePath     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r2.append(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                java.lang.String r4 = java.io.File.separator     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r2.append(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                java.lang.String r6 = r6.b()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r2.append(r6)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r1.<init>(r6)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L86
                if (r6 != 0) goto L4b
                android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ALPHA_8     // Catch: java.io.IOException -> L49
                android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r3, r3, r0)     // Catch: java.io.IOException -> L49
                goto L4b
            L49:
                r0 = move-exception
                goto L4f
            L4b:
                r1.close()     // Catch: java.io.IOException -> L49
                goto L85
            L4f:
                r0.printStackTrace()
                goto L85
            L53:
                r6 = move-exception
                goto L59
            L55:
                r6 = move-exception
                goto L88
            L57:
                r6 = move-exception
                r1 = r0
            L59:
                r6.printStackTrace()     // Catch: java.lang.Throwable -> L86
                cn.damai.homepage.helper.HomePageTopLottieHelper r2 = cn.damai.homepage.helper.HomePageTopLottieHelper.this     // Catch: java.lang.Throwable -> L86
                cn.damai.commonbusiness.home.bean.HeadLottieBean r2 = cn.damai.homepage.helper.HomePageTopLottieHelper.b(r2)     // Catch: java.lang.Throwable -> L86
                if (r2 == 0) goto L73
                java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L86
                cn.damai.homepage.helper.HomePageTopLottieHelper r2 = cn.damai.homepage.helper.HomePageTopLottieHelper.this     // Catch: java.lang.Throwable -> L86
                cn.damai.commonbusiness.home.bean.HeadLottieBean r2 = cn.damai.homepage.helper.HomePageTopLottieHelper.b(r2)     // Catch: java.lang.Throwable -> L86
                java.lang.String r2 = r2.zipUrl     // Catch: java.lang.Throwable -> L86
                tb.gz0.b(r6, r2)     // Catch: java.lang.Throwable -> L86
            L73:
                android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ALPHA_8     // Catch: java.io.IOException -> L80
                android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r3, r3, r6)     // Catch: java.io.IOException -> L80
                if (r1 == 0) goto L7e
                r1.close()     // Catch: java.io.IOException -> L80
            L7e:
                r6 = r0
                goto L85
            L80:
                r6 = move-exception
                r6.printStackTrace()
                goto L7e
            L85:
                return r6
            L86:
                r6 = move-exception
                r0 = r1
            L88:
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch: java.io.IOException -> L93
                android.graphics.Bitmap.createBitmap(r3, r3, r1)     // Catch: java.io.IOException -> L93
                if (r0 == 0) goto L97
                r0.close()     // Catch: java.io.IOException -> L93
                goto L97
            L93:
                r0 = move-exception
                r0.printStackTrace()
            L97:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.damai.homepage.helper.HomePageTopLottieHelper.b.fetchBitmap(tb.jc1):android.graphics.Bitmap");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class c implements LottieListener<com.airbnb.lottie.a> {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(com.airbnb.lottie.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "790604430")) {
                ipChange.ipc$dispatch("790604430", new Object[]{this, aVar});
                return;
            }
            HomePageTopLottieHelper.this.d.setComposition(aVar);
            HomePageTopLottieHelper.this.d.playAnimation();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class d implements ImageAssetDelegate {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ LottiePath a;

        d(LottiePath lottiePath) {
            this.a = lottiePath;
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x008f A[Catch: IOException -> 0x0093, TRY_LEAVE, TryCatch #2 {IOException -> 0x0093, blocks: (B:34:0x0088, B:36:0x008f), top: B:43:0x0088 }] */
        @Override // com.airbnb.lottie.ImageAssetDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public android.graphics.Bitmap fetchBitmap(tb.jc1 r6) {
            /*
                r5 = this;
                com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.homepage.helper.HomePageTopLottieHelper.d.$ipChange
                java.lang.String r1 = "-1694689345"
                boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                r3 = 1
                if (r2 == 0) goto L1a
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r4 = 0
                r2[r4] = r5
                r2[r3] = r6
                java.lang.Object r6 = r0.ipc$dispatch(r1, r2)
                android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
                return r6
            L1a:
                r0 = 0
                java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r2.<init>()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                cn.damai.homepage.helper.HomePageTopLottieHelper$LottiePath r4 = r5.a     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                java.lang.String r4 = r4.imagePath     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r2.append(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                java.lang.String r4 = java.io.File.separator     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r2.append(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                java.lang.String r6 = r6.b()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r2.append(r6)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                r1.<init>(r6)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
                android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch: java.lang.Exception -> L53 java.lang.Throwable -> L86
                if (r6 != 0) goto L4b
                android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ALPHA_8     // Catch: java.io.IOException -> L49
                android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r3, r3, r0)     // Catch: java.io.IOException -> L49
                goto L4b
            L49:
                r0 = move-exception
                goto L4f
            L4b:
                r1.close()     // Catch: java.io.IOException -> L49
                goto L85
            L4f:
                r0.printStackTrace()
                goto L85
            L53:
                r6 = move-exception
                goto L59
            L55:
                r6 = move-exception
                goto L88
            L57:
                r6 = move-exception
                r1 = r0
            L59:
                r6.printStackTrace()     // Catch: java.lang.Throwable -> L86
                cn.damai.homepage.helper.HomePageTopLottieHelper r2 = cn.damai.homepage.helper.HomePageTopLottieHelper.this     // Catch: java.lang.Throwable -> L86
                cn.damai.commonbusiness.home.bean.HeadLottieBean r2 = cn.damai.homepage.helper.HomePageTopLottieHelper.b(r2)     // Catch: java.lang.Throwable -> L86
                if (r2 == 0) goto L73
                java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L86
                cn.damai.homepage.helper.HomePageTopLottieHelper r2 = cn.damai.homepage.helper.HomePageTopLottieHelper.this     // Catch: java.lang.Throwable -> L86
                cn.damai.commonbusiness.home.bean.HeadLottieBean r2 = cn.damai.homepage.helper.HomePageTopLottieHelper.b(r2)     // Catch: java.lang.Throwable -> L86
                java.lang.String r2 = r2.zipUrl     // Catch: java.lang.Throwable -> L86
                tb.gz0.b(r6, r2)     // Catch: java.lang.Throwable -> L86
            L73:
                android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ALPHA_8     // Catch: java.io.IOException -> L80
                android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r3, r3, r6)     // Catch: java.io.IOException -> L80
                if (r1 == 0) goto L7e
                r1.close()     // Catch: java.io.IOException -> L80
            L7e:
                r6 = r0
                goto L85
            L80:
                r6 = move-exception
                r6.printStackTrace()
                goto L7e
            L85:
                return r6
            L86:
                r6 = move-exception
                r0 = r1
            L88:
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch: java.io.IOException -> L93
                android.graphics.Bitmap.createBitmap(r3, r3, r1)     // Catch: java.io.IOException -> L93
                if (r0 == 0) goto L97
                r0.close()     // Catch: java.io.IOException -> L93
                goto L97
            L93:
                r0 = move-exception
                r0.printStackTrace()
            L97:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.damai.homepage.helper.HomePageTopLottieHelper.d.fetchBitmap(tb.jc1):android.graphics.Bitmap");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class e implements LottieListener<com.airbnb.lottie.a> {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(com.airbnb.lottie.a aVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1966022836")) {
                ipChange.ipc$dispatch("-1966022836", new Object[]{this, aVar});
                return;
            }
            HomePageTopLottieHelper.this.d.setComposition(aVar);
            HomePageTopLottieHelper.this.d.playAnimation();
        }
    }

    static /* synthetic */ int i(HomePageTopLottieHelper homePageTopLottieHelper) {
        int i = homePageTopLottieHelper.h;
        homePageTopLottieHelper.h = i + 1;
        return i;
    }

    private File[] m(File[] fileArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1912433328")) {
            return (File[]) ipChange.ipc$dispatch("-1912433328", new Object[]{this, fileArr});
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < fileArr.length; i++) {
            if (q(fileArr[i].getName())) {
                arrayList.add(fileArr[i]);
            }
        }
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    public static HomePageTopLottieHelper n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1576402885")) {
            return (HomePageTopLottieHelper) ipChange.ipc$dispatch("-1576402885", new Object[0]);
        }
        if (k == null) {
            k = new HomePageTopLottieHelper();
        }
        return k;
    }

    private String o(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322394386")) {
            return (String) ipChange.ipc$dispatch("1322394386", new Object[]{this, context, str});
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().getPath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append("fenwei");
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(String str) {
        List<HeadLottieStyleBean> list;
        File[] listFiles;
        File file;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177170824")) {
            return ((Boolean) ipChange.ipc$dispatch("-177170824", new Object[]{this, str})).booleanValue();
        }
        try {
            this.e.clear();
            File file2 = new File(str);
            if (file2.exists() && (listFiles = file2.listFiles()) != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= listFiles.length) {
                        file = null;
                        break;
                    }
                    file = listFiles[i2];
                    if (file != null) {
                        String name = file.getName();
                        if (name.contains("lottie") || name.toLowerCase().contains("lottie")) {
                            break;
                        }
                    }
                    i2++;
                }
                if (file == null) {
                    return false;
                }
                File[] m = m(file.listFiles());
                z(m);
                int i3 = 0;
                while (i3 < m.length) {
                    File file3 = m[i3];
                    String name2 = file3.getName();
                    StringBuilder sb = new StringBuilder();
                    i3++;
                    sb.append(i3);
                    sb.append("");
                    if (name2.equals(sb.toString())) {
                        File[] listFiles2 = file3.listFiles();
                        String str2 = null;
                        String str3 = null;
                        if (listFiles2 != null) {
                            i = 0;
                            for (File file4 : listFiles2) {
                                if (file4.isFile() && file4.getName().contains(Preloader.KEY_JSON)) {
                                    str2 = file4.getAbsolutePath();
                                } else if (file4.isDirectory() && file4.getName().contains("image")) {
                                    File[] listFiles3 = file4.listFiles();
                                    for (int i4 = 0; i4 < listFiles3.length; i4++) {
                                        if (listFiles3[i4].getName().contains("jpg") || listFiles3[i4].getName().contains("png")) {
                                            i++;
                                        }
                                    }
                                    str3 = file4.getAbsolutePath();
                                }
                            }
                        } else {
                            i = 0;
                        }
                        if (str2 != null && str3 != null) {
                            this.e.add(new LottiePath(str2, str3, i));
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.e.size() > 0 && (list = this.a) != null && list.size() == this.e.size();
    }

    private boolean q(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "222884071") ? ((Boolean) ipChange.ipc$dispatch("222884071", new Object[]{this, str})).booleanValue() : Pattern.compile("[0-9]*").matcher(str).matches();
    }

    private void s(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-365224206")) {
            ipChange.ipc$dispatch("-365224206", new Object[]{this, str});
            return;
        }
        String B = z20.B(str);
        String B2 = z20.B(str + "1");
        if (!TextUtils.isEmpty(B2) && B2.equals(this.b.zipUrl) && !TextUtils.isEmpty(B)) {
            if (p(B)) {
                w();
                this.f.onSuccess();
                return;
            }
            t(str);
            return;
        }
        new ZipDownLoadManager().h(this.b.zipUrl).f(o(this.g, str)).g(new a(str)).e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1303278052")) {
            ipChange.ipc$dispatch("-1303278052", new Object[]{this, str});
            return;
        }
        z20.T(str, null);
        z20.T(str + "1", null);
        this.f.onFailed();
        this.i = true;
    }

    private int u(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-37489578")) {
            return ((Integer) ipChange.ipc$dispatch("-37489578", new Object[]{this, str})).intValue();
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            if (!str.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                str = Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str;
            }
            return Color.parseColor(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1608673426")) {
            ipChange.ipc$dispatch("1608673426", new Object[]{this});
            return;
        }
        if (this.e.size() > 1) {
            this.d.setRepeatCount(0);
            x();
        } else {
            this.d.setRepeatCount(-1);
            y();
        }
        new Handler().postDelayed(new Runnable() { // from class: cn.damai.homepage.helper.HomePageTopLottieHelper.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-356145149")) {
                    ipChange2.ipc$dispatch("-356145149", new Object[]{this});
                } else {
                    HomePageTopLottieHelper.this.i = true;
                }
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void x() {
        HeadLottieStyleBean headLottieStyleBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1300123325")) {
            ipChange.ipc$dispatch("1300123325", new Object[]{this});
        } else if (this.h >= this.e.size()) {
        } else {
            if (this.h < this.a.size()) {
                this.f.onUpdateStyle(this.a.get(this.h));
            }
            LottiePath lottiePath = this.e.get(this.h);
            int u = u((this.h >= this.a.size() || (headLottieStyleBean = this.a.get(this.h)) == null) ? null : headLottieStyleBean.color);
            if (u != -1) {
                this.c.setBackgroundColor(u);
            }
            try {
                this.d.setImageAssetDelegate(new b(lottiePath));
                BufferedReader bufferedReader = new BufferedReader(new FileReader(lottiePath.jsonPath));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        com.airbnb.lottie.b.m(sb.toString(), null).f(this.j);
                        this.d.addAnimatorListener(new Animator.AnimatorListener() { // from class: cn.damai.homepage.helper.HomePageTopLottieHelper.4
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationCancel(Animator animator) {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "-1132009622")) {
                                    ipChange2.ipc$dispatch("-1132009622", new Object[]{this, animator});
                                }
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator) {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "-1162372091")) {
                                    ipChange2.ipc$dispatch("-1162372091", new Object[]{this, animator});
                                    return;
                                }
                                HomePageTopLottieHelper.this.B();
                                if (HomePageTopLottieHelper.this.h == HomePageTopLottieHelper.this.e.size() - 1) {
                                    HomePageTopLottieHelper.this.h = 0;
                                } else {
                                    HomePageTopLottieHelper.i(HomePageTopLottieHelper.this);
                                }
                                new Handler().postDelayed(new Runnable() { // from class: cn.damai.homepage.helper.HomePageTopLottieHelper.4.1
                                    private static transient /* synthetic */ IpChange $ipChange;

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IpChange ipChange3 = $ipChange;
                                        if (AndroidInstantRuntime.support(ipChange3, "-1053639276")) {
                                            ipChange3.ipc$dispatch("-1053639276", new Object[]{this});
                                        } else {
                                            HomePageTopLottieHelper.this.x();
                                        }
                                    }
                                }, 300L);
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationRepeat(Animator animator) {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "1181565993")) {
                                    ipChange2.ipc$dispatch("1181565993", new Object[]{this, animator});
                                }
                            }

                            @Override // android.animation.Animator.AnimatorListener
                            public void onAnimationStart(Animator animator) {
                                IpChange ipChange2 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange2, "-1792484322")) {
                                    ipChange2.ipc$dispatch("-1792484322", new Object[]{this, animator});
                                }
                            }
                        });
                        return;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @SuppressLint({"NewApi"})
    private void y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1100635412")) {
            ipChange.ipc$dispatch("1100635412", new Object[]{this});
            return;
        }
        this.f.onUpdateStyle(this.a.get(0));
        LottiePath lottiePath = this.e.get(0);
        HeadLottieStyleBean headLottieStyleBean = this.a.get(0);
        try {
            int u = u(headLottieStyleBean != null ? headLottieStyleBean.color : null);
            if (u != -1) {
                this.c.setBackgroundColor(u);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.d.setRepeatCount(-1);
        try {
            this.d.setImageAssetDelegate(new d(lottiePath));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(lottiePath.jsonPath));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    com.airbnb.lottie.b.m(sb.toString(), null).f(new e());
                    return;
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private void z(File[] fileArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-51591688")) {
            ipChange.ipc$dispatch("-51591688", new Object[]{this, fileArr});
            return;
        }
        for (int i = 0; i < fileArr.length; i++) {
            int i2 = 0;
            while (i2 < (fileArr.length - i) - 1) {
                int i3 = i2 + 1;
                if (Integer.parseInt(fileArr[i2].getName()) > Integer.parseInt(fileArr[i3].getName())) {
                    File file = fileArr[i3];
                    fileArr[i3] = fileArr[i2];
                    fileArr[i2] = file;
                }
                i2 = i3;
            }
        }
    }

    public void A() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1748135099")) {
            ipChange.ipc$dispatch("1748135099", new Object[]{this});
            return;
        }
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView == null || lottieAnimationView.isAnimating()) {
            return;
        }
        this.d.playAnimation();
    }

    public void B() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "238293293")) {
            ipChange.ipc$dispatch("238293293", new Object[]{this});
            return;
        }
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null) {
            lottieAnimationView.removeAllLottieOnCompositionLoadedListener();
            this.d.removeAllAnimatorListeners();
            this.d.cancelAnimation();
            this.d.clearAnimation();
        }
    }

    public void r(Context context, HeadLottieBean headLottieBean, String str, View view, LottieAnimationView lottieAnimationView, OnLoadResultListener onLoadResultListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "368722606")) {
            ipChange.ipc$dispatch("368722606", new Object[]{this, context, headLottieBean, str, view, lottieAnimationView, onLoadResultListener});
        } else if (this.i) {
            this.i = false;
            this.g = context.getApplicationContext();
            this.c = view;
            this.d = lottieAnimationView;
            this.b = headLottieBean;
            List<HeadLottieStyleBean> list = headLottieBean.style;
            this.a = list;
            if (list != null) {
                for (int i = 0; i < this.a.size(); i++) {
                    this.a.get(i).index = i;
                }
            }
            this.f = onLoadResultListener;
            this.h = 0;
            B();
            s(str);
        }
    }

    public void v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-313028185")) {
            ipChange.ipc$dispatch("-313028185", new Object[]{this});
            return;
        }
        LottieAnimationView lottieAnimationView = this.d;
        if (lottieAnimationView != null) {
            lottieAnimationView.pauseAnimation();
        }
    }
}
