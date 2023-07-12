package tb;

import android.graphics.BitmapFactory;
import com.alibaba.pictures.uploader.FileUploader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uploader.export.IUploaderTask;
import java.util.Map;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class wu2 implements IUploaderTask {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C9887a Companion = new C9887a(null);
    private String a;
    @Nullable
    private BitmapFactory.Options b;
    @NotNull
    private uu2 c;

    /* compiled from: Taobao */
    /* renamed from: tb.wu2$a */
    /* loaded from: classes8.dex */
    public static final class C9887a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C9887a() {
        }

        @NotNull
        public final String a(@Nullable String str, @Nullable String str2) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1752618352") ? (String) ipChange.ipc$dispatch("-1752618352", new Object[]{this, str, str2}) : str != null ? str : "task_default";
        }

        public /* synthetic */ C9887a(k50 k50Var) {
            this();
        }
    }

    public wu2(@NotNull uu2 uu2Var) {
        b41.i(uu2Var, "uploadInfo");
        this.c = uu2Var;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        wt2 wt2Var = wt2.INSTANCE;
        this.b = options;
        BitmapFactory.decodeFile(this.c.b(), this.b);
        Companion.a(getFilePath(), this.a);
    }

    @NotNull
    public final uu2 a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-939637940") ? (uu2) ipChange.ipc$dispatch("-939637940", new Object[]{this}) : this.c;
    }

    @Override // com.uploader.export.IUploaderTask
    @NotNull
    public String getBizType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "340389588")) {
            return (String) ipChange.ipc$dispatch("340389588", new Object[]{this});
        }
        String str = this.a;
        return str != null ? str : FileUploader.Companion.d();
    }

    @Override // com.uploader.export.IUploaderTask
    @NotNull
    public String getFilePath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1642572816")) {
            return (String) ipChange.ipc$dispatch("-1642572816", new Object[]{this});
        }
        String a = this.c.a();
        if (a == null) {
            a = this.c.b();
        }
        return a != null ? a : "";
    }

    @Override // com.uploader.export.IUploaderTask
    @NotNull
    public String getFileType() {
        boolean K;
        int f0;
        String str;
        boolean K2;
        int f02;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1122181765")) {
            return (String) ipChange.ipc$dispatch("1122181765", new Object[]{this});
        }
        BitmapFactory.Options options = this.b;
        if (options != null && (str = options.outMimeType) != null) {
            K2 = StringsKt__StringsKt.K(str, "/", false, 2, null);
            if (!K2) {
                str = null;
            }
            if (str != null) {
                f02 = StringsKt__StringsKt.f0(str, "/", 0, false, 6, null);
                String substring = str.substring(f02 + 1);
                b41.h(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        String b = this.c.b();
        if (b != null) {
            K = StringsKt__StringsKt.K(b, ".", false, 2, null);
            String str2 = K ? b : null;
            if (str2 != null) {
                f0 = StringsKt__StringsKt.f0(str2, ".", 0, false, 6, null);
                String substring2 = str2.substring(f0 + 1);
                b41.h(substring2, "(this as java.lang.String).substring(startIndex)");
                FileUploader.Companion.h("UploadTask-upload file【oriPath】 type:" + substring2);
                return substring2;
            }
            return "";
        }
        return "";
    }

    @Override // com.uploader.export.IUploaderTask
    @Nullable
    public Map<String, String> getMetaInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1922615661")) {
            return (Map) ipChange.ipc$dispatch("-1922615661", new Object[]{this});
        }
        return null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public wu2(@NotNull uu2 uu2Var, @Nullable String str) {
        this(uu2Var);
        b41.i(uu2Var, "uploadInfo");
        this.a = str;
    }
}
