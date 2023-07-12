package cn.damai.onearch.token;

import android.content.Context;
import android.net.Uri;
import com.alient.resource.token.TokenManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public final class DMTokenManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final C1491a Companion = new C1491a(null);
    @NotNull
    private static final Lazy<DMTokenManager> a;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.onearch.token.DMTokenManager$a */
    /* loaded from: classes15.dex */
    public static final class C1491a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C1491a() {
        }

        public /* synthetic */ C1491a(k50 k50Var) {
            this();
        }

        @NotNull
        public final DMTokenManager a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1114021847") ? (DMTokenManager) ipChange.ipc$dispatch("-1114021847", new Object[]{this}) : (DMTokenManager) DMTokenManager.a.getValue();
        }
    }

    static {
        Lazy<DMTokenManager> a2;
        a2 = C8177b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<DMTokenManager>() { // from class: cn.damai.onearch.token.DMTokenManager$Companion$instance$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final DMTokenManager invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "1029114763") ? (DMTokenManager) ipChange.ipc$dispatch("1029114763", new Object[]{this}) : new DMTokenManager();
            }
        });
        a = a2;
    }

    public final void b(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-666273318")) {
            ipChange.ipc$dispatch("-666273318", new Object[]{this, context});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        TokenManager companion = TokenManager.Companion.getInstance();
        Uri parse = Uri.parse("android.resource://commonbusiness/raw/token");
        b41.h(parse, "parse(ContentResolver.SC…ommonbusiness/raw/token\")");
        companion.init(context, parse);
    }
}
