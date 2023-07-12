package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class zr {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final zr INSTANCE = new zr();

    /* compiled from: Taobao */
    /* renamed from: tb.zr$a */
    /* loaded from: classes4.dex */
    public static final class C10032a {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private String a;
        @Nullable
        private String b;
        @Nullable
        private String c;
        @Nullable
        private String d;
        @Nullable
        private String e;
        @Nullable
        private String f;
        @Nullable
        private Map<String, String> g;
        @Nullable
        private String h;
        @Nullable
        private String i;
        private boolean j;

        @NotNull
        public final C10032a a(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1996708533")) {
                return (C10032a) ipChange.ipc$dispatch("-1996708533", new Object[]{this, str});
            }
            this.a = str;
            return this;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
            if (r1 == null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x008f, code lost:
            if (r1 == null) goto L30;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b() {
            /*
                r5 = this;
                com.android.alibaba.ip.runtime.IpChange r0 = tb.zr.C10032a.$ipChange
                java.lang.String r1 = "472031520"
                boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                if (r2 == 0) goto L14
                r2 = 1
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r3 = 0
                r2[r3] = r5
                r0.ipc$dispatch(r1, r2)
                return
            L14:
                boolean r0 = tb.b23.j()
                if (r0 == 0) goto L1b
                return
            L1b:
                tb.ds r0 = new tb.ds     // Catch: java.lang.Exception -> La3
                r0.<init>()     // Catch: java.lang.Exception -> La3
                java.util.Map<java.lang.String, java.lang.String> r1 = r5.g     // Catch: java.lang.Exception -> La3
                if (r1 == 0) goto L27
                r0.setExtral(r1)     // Catch: java.lang.Exception -> La3
            L27:
                java.lang.String r1 = r5.e     // Catch: java.lang.Exception -> La3
                r0.setBizCode(r1)     // Catch: java.lang.Exception -> La3
                java.lang.String r1 = r5.f     // Catch: java.lang.Exception -> La3
                r0.setBizMsg(r1)     // Catch: java.lang.Exception -> La3
                java.lang.String r1 = r5.a     // Catch: java.lang.Exception -> La3
                if (r1 == 0) goto L5d
                java.lang.String r2 = "mtop.damai.mec.aristotle.get"
                boolean r2 = tb.b41.d(r2, r1)     // Catch: java.lang.Exception -> La3
                if (r2 == 0) goto L5d
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La3
                r1.<init>()     // Catch: java.lang.Exception -> La3
                java.lang.String r2 = r5.a     // Catch: java.lang.Exception -> La3
                r1.append(r2)     // Catch: java.lang.Exception -> La3
                r2 = 95
                r1.append(r2)     // Catch: java.lang.Exception -> La3
                java.lang.String r3 = r5.h     // Catch: java.lang.Exception -> La3
                r1.append(r3)     // Catch: java.lang.Exception -> La3
                r1.append(r2)     // Catch: java.lang.Exception -> La3
                java.lang.String r2 = r5.i     // Catch: java.lang.Exception -> La3
                r1.append(r2)     // Catch: java.lang.Exception -> La3
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> La3
            L5d:
                r0.setBizScene(r1)     // Catch: java.lang.Exception -> La3
                java.lang.String r1 = r5.c     // Catch: java.lang.Exception -> La3
                java.lang.String r2 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
                if (r1 == 0) goto L71
                java.util.Locale r3 = java.util.Locale.ROOT     // Catch: java.lang.Exception -> La3
                java.lang.String r1 = r1.toLowerCase(r3)     // Catch: java.lang.Exception -> La3
                tb.b41.h(r1, r2)     // Catch: java.lang.Exception -> La3
                if (r1 != 0) goto L93
            L71:
                java.lang.String r1 = r5.b     // Catch: java.lang.Exception -> La3
                if (r1 == 0) goto L91
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La3
                r3.<init>()     // Catch: java.lang.Exception -> La3
                java.lang.String r4 = "a2o4t."
                r3.append(r4)     // Catch: java.lang.Exception -> La3
                r3.append(r1)     // Catch: java.lang.Exception -> La3
                java.lang.String r1 = r3.toString()     // Catch: java.lang.Exception -> La3
                java.util.Locale r3 = java.util.Locale.ROOT     // Catch: java.lang.Exception -> La3
                java.lang.String r1 = r1.toLowerCase(r3)     // Catch: java.lang.Exception -> La3
                tb.b41.h(r1, r2)     // Catch: java.lang.Exception -> La3
                if (r1 != 0) goto L93
            L91:
                java.lang.String r1 = "a2o4t.null"
            L93:
                r0.setPageSpm(r1)     // Catch: java.lang.Exception -> La3
                java.lang.String r1 = r5.d     // Catch: java.lang.Exception -> La3
                r0.setPageName(r1)     // Catch: java.lang.Exception -> La3
                boolean r1 = r5.j     // Catch: java.lang.Exception -> La3
                r0.setResultExpected(r1)     // Catch: java.lang.Exception -> La3
                r0.release()     // Catch: java.lang.Exception -> La3
            La3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.zr.C10032a.b():void");
        }

        @NotNull
        public final C10032a c(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-331536101")) {
                return (C10032a) ipChange.ipc$dispatch("-331536101", new Object[]{this, str});
            }
            this.e = str;
            return this;
        }

        @NotNull
        public final C10032a d(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1719962779")) {
                return (C10032a) ipChange.ipc$dispatch("1719962779", new Object[]{this, str});
            }
            this.f = str;
            return this;
        }

        @NotNull
        public final C10032a e(@Nullable Map<String, String> map) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-974690911")) {
                return (C10032a) ipChange.ipc$dispatch("-974690911", new Object[]{this, map});
            }
            this.g = map;
            return this;
        }

        @NotNull
        public final C10032a f(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1718514345")) {
                return (C10032a) ipChange.ipc$dispatch("1718514345", new Object[]{this, Boolean.valueOf(z)});
            }
            this.j = z;
            return this;
        }

        @NotNull
        public final C10032a g(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "728906157")) {
                return (C10032a) ipChange.ipc$dispatch("728906157", new Object[]{this, str});
            }
            this.d = str;
            return this;
        }

        @NotNull
        public final C10032a h(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1040452033")) {
                return (C10032a) ipChange.ipc$dispatch("1040452033", new Object[]{this, str});
            }
            this.h = str;
            return this;
        }

        @NotNull
        public final C10032a i(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1027414422")) {
                return (C10032a) ipChange.ipc$dispatch("-1027414422", new Object[]{this, str});
            }
            this.i = str;
            return this;
        }

        @NotNull
        public final C10032a j(@Nullable String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "717991540")) {
                return (C10032a) ipChange.ipc$dispatch("717991540", new Object[]{this, str});
            }
            this.b = str;
            return this;
        }
    }

    private zr() {
    }

    @NotNull
    public final C10032a a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1375842605") ? (C10032a) ipChange.ipc$dispatch("-1375842605", new Object[]{this}) : new C10032a();
    }
}
