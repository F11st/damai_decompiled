package com.alibaba.pictures.share.common.share;

import com.ali.user.mobile.login.model.LoginConstant;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\t\b\u0016¢\u0006\u0004\b\u0010\u0010\u0011B\u0013\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0010\u0010\u000fB\u0019\b\u0016\u0012\u000e\u0010\u0015\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014¢\u0006\u0004\b\u0010\u0010\u0016B\u0013\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0010\u0010\u0019B\u001b\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u001aB#\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\u0015\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014¢\u0006\u0004\b\u0010\u0010\u001bB+\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\u0015\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u001cB\u001d\b\u0016\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0010\u0010\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/alibaba/pictures/share/common/share/ShareException;", "Ljava/lang/RuntimeException;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "I", "getStatusCode", "()I", "setStatusCode", "(I)V", "", "statusMsg", "Ljava/lang/String;", "getStatusMsg", "()Ljava/lang/String;", "setStatusMsg", "(Ljava/lang/String;)V", "<init>", "()V", "msg", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cause", "(Ljava/lang/Exception;)V", "", "throwable", "(Ljava/lang/Throwable;)V", "(Ljava/lang/String;I)V", "(Ljava/lang/String;Ljava/lang/Exception;)V", "(Ljava/lang/String;Ljava/lang/Exception;I)V", "detailMessage", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "Companion", "a", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public class ShareException extends RuntimeException {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int APP_UNINSTALL = 40501;
    public static final int APP_UNSUPPORT_VERSION = 40502;
    public static final int AUTH_ERROR = 1002;
    @NotNull
    public static final C3633a Companion = new C3633a(null);
    public static final int UNKNOWN_ERROR = 1003;
    public static final int USER_CANCEL = 1001;
    private static final long serialVersionUID = 475022994858770424L;
    private int statusCode;
    @NotNull
    private String statusMsg;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.share.common.share.ShareException$a */
    /* loaded from: classes8.dex */
    public static final class C3633a {
        private C3633a() {
        }

        public /* synthetic */ C3633a(k50 k50Var) {
            this();
        }
    }

    public ShareException() {
        this.statusCode = -1;
        this.statusMsg = "UNKNOWN_ERROR";
    }

    public final int getStatusCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "103690328") ? ((Integer) ipChange.ipc$dispatch("103690328", new Object[]{this})).intValue() : this.statusCode;
    }

    @NotNull
    public final String getStatusMsg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "378337993") ? (String) ipChange.ipc$dispatch("378337993", new Object[]{this}) : this.statusMsg;
    }

    public final void setStatusCode(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2020690102")) {
            ipChange.ipc$dispatch("-2020690102", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.statusCode = i;
        }
    }

    public final void setStatusMsg(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1173338317")) {
            ipChange.ipc$dispatch("1173338317", new Object[]{this, str});
            return;
        }
        b41.i(str, "<set-?>");
        this.statusMsg = str;
    }

    public ShareException(@Nullable String str) {
        super(str);
        this.statusCode = -1;
        this.statusMsg = "UNKNOWN_ERROR";
    }

    public ShareException(@Nullable Exception exc) {
        super(exc);
        this.statusCode = -1;
        this.statusMsg = "UNKNOWN_ERROR";
    }

    public ShareException(@Nullable Throwable th) {
        super(th);
        this.statusCode = -1;
        this.statusMsg = "UNKNOWN_ERROR";
    }

    public ShareException(@Nullable String str, int i) {
        super(str);
        this.statusCode = -1;
        this.statusMsg = "UNKNOWN_ERROR";
        this.statusCode = i;
    }

    public ShareException(@Nullable String str, @Nullable Exception exc) {
        super(str, exc);
        this.statusCode = -1;
        this.statusMsg = "UNKNOWN_ERROR";
    }

    public ShareException(@Nullable String str, @Nullable Exception exc, int i) {
        super(str, exc);
        this.statusCode = -1;
        this.statusMsg = "UNKNOWN_ERROR";
        this.statusCode = i;
    }

    public ShareException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
        this.statusCode = -1;
        this.statusMsg = "UNKNOWN_ERROR";
    }

    public ShareException(int i) {
        this.statusCode = -1;
        String str = "UNKNOWN_ERROR";
        this.statusMsg = "UNKNOWN_ERROR";
        this.statusCode = i;
        if (i == 1001) {
            str = LoginConstant.FETCH_IV_FAIL_CANCEL;
        } else if (i == 1002) {
            str = "AUTH_ERROR";
        } else if (i == 40501) {
            str = "APP_UNINSTALL";
        } else if (i == 40502) {
            str = "APP_UNSUPPORT_VERSION";
        }
        this.statusMsg = str;
    }
}
