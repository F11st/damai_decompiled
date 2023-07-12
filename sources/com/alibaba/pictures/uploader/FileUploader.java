package com.alibaba.pictures.uploader;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uploader.export.ITaskResult;
import com.uploader.export.IUploaderTask;
import com.uploader.export.UploaderGlobal;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.av2;
import tb.b41;
import tb.da0;
import tb.fl2;
import tb.k50;
import tb.qu2;
import tb.ro;
import tb.ru2;
import tb.uu2;
import tb.wu2;
import tb.yu2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class FileUploader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String TAG = "Pic:FileUploader";
    @Nullable
    private static IImageCompressor l;
    public static String m;
    public static Context n;
    private static int o;
    private ArrayList<uu2> a;
    private ArrayList<wu2> b;
    private AtomicInteger c;
    private AtomicInteger d;
    private int e;
    private FileUploadListener f;
    private Job g;
    private Boolean h;
    private qu2 i;
    private b j;
    @Nullable
    private String k;
    @NotNull
    public static final a Companion = new a(null);
    @Nullable
    private static Boolean p = Boolean.FALSE;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        @JvmStatic
        @NotNull
        public final FileUploader a(@Nullable String str) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1034538392") ? (FileUploader) ipChange.ipc$dispatch("1034538392", new Object[]{this, str}) : new FileUploader(str, null);
        }

        @NotNull
        public final Context b() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1381479442")) {
                return (Context) ipChange.ipc$dispatch("-1381479442", new Object[]{this});
            }
            Context context = FileUploader.n;
            if (context == null) {
                b41.A(WPKFactory.INIT_KEY_CONTEXT);
            }
            return context;
        }

        @Nullable
        public final Boolean c() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "108040501") ? (Boolean) ipChange.ipc$dispatch("108040501", new Object[]{this}) : FileUploader.p;
        }

        @NotNull
        public final String d() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1418376391")) {
                return (String) ipChange.ipc$dispatch("1418376391", new Object[]{this});
            }
            String str = FileUploader.m;
            if (str == null) {
                b41.A("defaultBizType");
            }
            return str;
        }

        public final int e() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1149919227") ? ((Integer) ipChange.ipc$dispatch("-1149919227", new Object[]{this})).intValue() : FileUploader.o;
        }

        @Nullable
        public final IImageCompressor f() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-977067199")) {
                return (IImageCompressor) ipChange.ipc$dispatch("-977067199", new Object[]{this});
            }
            if (FileUploader.l == null) {
                FileUploader.l = new ru2();
            }
            return FileUploader.l;
        }

        @JvmStatic
        public final void g(@Nullable Context context, @Nullable Integer num, @NotNull String str, @NotNull String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1008665972")) {
                ipChange.ipc$dispatch("1008665972", new Object[]{this, context, num, str, str2});
                return;
            }
            b41.i(str, "appKey");
            b41.i(str2, "defaultBizType");
            if (context == null) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            b41.h(applicationContext, "context.applicationContext");
            i(applicationContext);
            j(str2);
            UploaderGlobal.g(context);
            k(num != null ? num.intValue() : 0);
            UploaderGlobal.e(e(), str);
            av2 av2Var = new av2(context);
            av2Var.setEnvironment(e());
            UploaderGlobal.c(new yu2(context, av2Var));
        }

        public final void h(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1907181215")) {
                ipChange.ipc$dispatch("-1907181215", new Object[]{this, str});
            } else if (b41.d(c(), Boolean.TRUE)) {
                if (str == null) {
                    str = "--";
                }
                Log.d(FileUploader.TAG, str);
            }
        }

        public final void i(@NotNull Context context) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-126905082")) {
                ipChange.ipc$dispatch("-126905082", new Object[]{this, context});
                return;
            }
            b41.i(context, "<set-?>");
            FileUploader.n = context;
        }

        public final void j(@NotNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1902888439")) {
                ipChange.ipc$dispatch("1902888439", new Object[]{this, str});
                return;
            }
            b41.i(str, "<set-?>");
            FileUploader.m = str;
        }

        public final void k(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-367694171")) {
                ipChange.ipc$dispatch("-367694171", new Object[]{this, Integer.valueOf(i)});
            } else {
                FileUploader.o = i;
            }
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class b extends Handler {
        private static transient /* synthetic */ IpChange $ipChange;

        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "624329147")) {
                ipChange.ipc$dispatch("624329147", new Object[]{this, message});
                return;
            }
            b41.i(message, "msg");
            int i = message.what;
            UploadErrorCode uploadErrorCode = UploadErrorCode.TIME_OUT;
            if (i == uploadErrorCode.getValue()) {
                FileUploadListener fileUploadListener = FileUploader.this.f;
                if (fileUploadListener != null) {
                    fileUploadListener.onFailure(uploadErrorCode, FileUploader.this.a);
                }
                FileUploader.this.p();
            }
        }
    }

    private FileUploader(String str) {
        this.k = str;
        this.a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.c = new AtomicInteger(0);
        this.d = new AtomicInteger(0);
        this.h = Boolean.FALSE;
        this.j = new b(Looper.getMainLooper());
    }

    public static /* synthetic */ FileUploader A(FileUploader fileUploader, qu2 qu2Var, int i, Object obj) {
        if ((i & 1) != 0) {
            qu2Var = null;
        }
        return fileUploader.z(qu2Var);
    }

    public static final void B(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-595746607")) {
            ipChange.ipc$dispatch("-595746607", new Object[]{bool});
        } else {
            p = bool;
        }
    }

    public static /* synthetic */ void F(FileUploader fileUploader, String str, Long l2, int i, Object obj) {
        if ((i & 2) != 0) {
            l2 = null;
        }
        fileUploader.E(str, l2);
    }

    public static /* synthetic */ void I(FileUploader fileUploader, List list, Long l2, int i, Object obj) {
        if ((i & 2) != 0) {
            l2 = null;
        }
        fileUploader.H(list, l2);
    }

    @JvmStatic
    @NotNull
    public static final FileUploader q(@Nullable String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1729571888") ? (FileUploader) ipChange.ipc$dispatch("-1729571888", new Object[]{str}) : Companion.a(str);
    }

    @JvmStatic
    public static final void s(@Nullable Context context, @Nullable Integer num, @NotNull String str, @NotNull String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1921978796")) {
            ipChange.ipc$dispatch("1921978796", new Object[]{context, num, str, str2});
        } else {
            Companion.g(context, num, str, str2);
        }
    }

    @NotNull
    public final FileUploader C(@Nullable FileUploadListener fileUploadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1761799520")) {
            return (FileUploader) ipChange.ipc$dispatch("-1761799520", new Object[]{this, fileUploadListener});
        }
        this.f = fileUploadListener;
        return this;
    }

    @JvmOverloads
    public final void D(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1961503504")) {
            ipChange.ipc$dispatch("-1961503504", new Object[]{this, str});
        } else {
            F(this, str, null, 2, null);
        }
    }

    @JvmOverloads
    public final void E(@Nullable String str, @Nullable Long l2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1324231983")) {
            ipChange.ipc$dispatch("1324231983", new Object[]{this, str, l2});
            return;
        }
        Companion.h("startUpload---");
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            FileUploadListener fileUploadListener = this.f;
            if (fileUploadListener != null) {
                fileUploadListener.onFailure(UploadErrorCode.FAIL_SELF, this.a);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        H(arrayList, l2);
    }

    @JvmOverloads
    public final void G(@Nullable List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-309161706")) {
            ipChange.ipc$dispatch("-309161706", new Object[]{this, list});
        } else {
            I(this, list, null, 2, null);
        }
    }

    @JvmOverloads
    public final void H(@Nullable List<String> list, @Nullable Long l2) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-240525995")) {
            ipChange.ipc$dispatch("-240525995", new Object[]{this, list, l2});
            return;
        }
        this.b.clear();
        this.a.clear();
        int size = list != null ? list.size() : 0;
        this.e = size;
        this.c.set(size);
        this.d.set(this.e);
        if (list != null && !list.isEmpty()) {
            z = false;
        }
        if (z) {
            FileUploadListener fileUploadListener = this.f;
            if (fileUploadListener != null) {
                fileUploadListener.onFailure(UploadErrorCode.FAIL_SELF, this.a);
                return;
            }
            return;
        }
        if (l2 != null && l2.longValue() > 0) {
            a aVar = Companion;
            aVar.h("startUpLoadGroup---开始超时处理=" + l2);
            Message obtain = Message.obtain();
            obtain.what = UploadErrorCode.TIME_OUT.getValue();
            this.j.sendMessageDelayed(obtain, l2.longValue());
        }
        this.g = e.b(ro.a(da0.b()), null, null, new FileUploader$uploadGroup$1(this, list, null), 3, null);
    }

    public final void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-895211123")) {
            ipChange.ipc$dispatch("-895211123", new Object[]{this});
            return;
        }
        for (wu2 wu2Var : this.b) {
            if (wu2Var.a().b() != null) {
                com.uploader.export.a.a().cancelAsync(wu2Var);
            }
        }
        Job job = this.g;
        if (job == null || !job.isActive()) {
            return;
        }
        Job.a.b(job, null, 1, null);
    }

    @Nullable
    public final String r() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1794624849") ? (String) ipChange.ipc$dispatch("-1794624849", new Object[]{this}) : this.k;
    }

    public final void t(@Nullable IUploaderTask iUploaderTask) {
        FileUploadListener fileUploadListener;
        uu2 a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1067112244")) {
            ipChange.ipc$dispatch("-1067112244", new Object[]{this, iUploaderTask});
            return;
        }
        if (!(iUploaderTask instanceof wu2)) {
            iUploaderTask = null;
        }
        wu2 wu2Var = (wu2) iUploaderTask;
        if (wu2Var != null && (a2 = wu2Var.a()) != null) {
            a2.k(UploadStatus.CANCEL);
        }
        if (this.c.decrementAndGet() > 0 || (fileUploadListener = this.f) == null) {
            return;
        }
        fileUploadListener.onFailure(UploadErrorCode.FAIL, this.a);
    }

    public final void u(@Nullable IUploaderTask iUploaderTask, @Nullable fl2 fl2Var) {
        FileUploadListener fileUploadListener;
        uu2 a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1073050430")) {
            ipChange.ipc$dispatch("1073050430", new Object[]{this, iUploaderTask, fl2Var});
            return;
        }
        if (!(iUploaderTask instanceof wu2)) {
            iUploaderTask = null;
        }
        wu2 wu2Var = (wu2) iUploaderTask;
        if (wu2Var != null && (a2 = wu2Var.a()) != null) {
            a2.k(UploadStatus.FAILURE);
            a2.f(fl2Var);
        }
        if (this.c.decrementAndGet() > 0 || (fileUploadListener = this.f) == null) {
            return;
        }
        fileUploadListener.onFailure(UploadErrorCode.FAIL, this.a);
    }

    public final void v(@Nullable IUploaderTask iUploaderTask, @Nullable UploadStatus uploadStatus) {
        uu2 a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1309913608")) {
            ipChange.ipc$dispatch("1309913608", new Object[]{this, iUploaderTask, uploadStatus});
            return;
        }
        if (!(iUploaderTask instanceof wu2)) {
            iUploaderTask = null;
        }
        wu2 wu2Var = (wu2) iUploaderTask;
        if (wu2Var == null || (a2 = wu2Var.a()) == null) {
            return;
        }
        a2.k(uploadStatus);
    }

    public final void w(@Nullable IUploaderTask iUploaderTask, int i) {
        uu2 a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1431548708")) {
            ipChange.ipc$dispatch("1431548708", new Object[]{this, iUploaderTask, Integer.valueOf(i)});
            return;
        }
        if (!(iUploaderTask instanceof wu2)) {
            iUploaderTask = null;
        }
        wu2 wu2Var = (wu2) iUploaderTask;
        if (wu2Var == null || (a2 = wu2Var.a()) == null) {
            return;
        }
        a2.k(UploadStatus.UPLOADING);
        a2.i(i);
        FileUploadListener fileUploadListener = this.f;
        if (fileUploadListener != null) {
            fileUploadListener.onSingleTaskProgress(a2);
        }
    }

    public final void x(@Nullable IUploaderTask iUploaderTask, @Nullable ITaskResult iTaskResult) {
        uu2 a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-353463395")) {
            ipChange.ipc$dispatch("-353463395", new Object[]{this, iUploaderTask, iTaskResult});
            return;
        }
        if (!(iUploaderTask instanceof wu2)) {
            iUploaderTask = null;
        }
        wu2 wu2Var = (wu2) iUploaderTask;
        if (wu2Var != null && (a2 = wu2Var.a()) != null) {
            a2.k(UploadStatus.SUCCESS);
            a2.j(iTaskResult);
        }
        int decrementAndGet = this.d.decrementAndGet();
        int i = this.e;
        float f = i > 0 ? ((i - decrementAndGet) * 1.0f) / i : 1.0f;
        FileUploadListener fileUploadListener = this.f;
        if (fileUploadListener != null) {
            fileUploadListener.onAllTaskProgress(f);
        }
        if (this.c.decrementAndGet() <= 0) {
            if (decrementAndGet <= 0) {
                FileUploadListener fileUploadListener2 = this.f;
                if (fileUploadListener2 != null) {
                    fileUploadListener2.onAllSuccess(this.a);
                    return;
                }
                return;
            }
            FileUploadListener fileUploadListener3 = this.f;
            if (fileUploadListener3 != null) {
                fileUploadListener3.onFailure(UploadErrorCode.FAIL, this.a);
            }
        }
    }

    @JvmOverloads
    @NotNull
    public final FileUploader y() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2022835651") ? (FileUploader) ipChange.ipc$dispatch("2022835651", new Object[]{this}) : A(this, null, 1, null);
    }

    @JvmOverloads
    @NotNull
    public final FileUploader z(@Nullable qu2 qu2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-511929856")) {
            return (FileUploader) ipChange.ipc$dispatch("-511929856", new Object[]{this, qu2Var});
        }
        this.h = Boolean.TRUE;
        this.i = qu2Var;
        return this;
    }

    public /* synthetic */ FileUploader(String str, k50 k50Var) {
        this(str);
    }
}
