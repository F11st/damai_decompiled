package tb;

import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class qm {
    @NotNull
    public static final C9608a Companion = new C9608a(null);
    private static Pattern a = Pattern.compile("^(http|https):.*(\\.|//)((taopiaopiao|youku|tmall|taobao|alipay|alipay-eco|shuqiread|pstatp|dushemovie|tudou|fliggy|koubei|yuekeyun|mikecrm|ankerjiedian|laiwang|xiami|alimei|dongting|goofish|alibaba|aliresearch|alibabagroup|aliexpress|alimama|aliyun|juhuasuan|dingtalk|etao|hitao|95095|alicdn|myqcloud|taohua|shuqi|azusasoft|agtcdn|kuaishou|b1yq|iqima|(public-oss\\\\\\\\.futurehotel)|diditaxi|alibaba-inc)\\.com|(damai|tb|piao|uc|5zhua|mashort|html5case\\.com|hsbc\\.com|duiba\\.com|xianshang\\.hydron\\.com|catchme\\.com)\\.cn|(alipay|alibaba|agtcdn)\\.net|(tmall)\\.hk|(ele)\\.me)(\\?|#|/|:|$)", 2);
    @Nullable
    private static Pattern b;

    /* compiled from: Taobao */
    /* renamed from: tb.qm$a */
    /* loaded from: classes11.dex */
    public static final class C9608a {

        /* compiled from: Taobao */
        /* renamed from: tb.qm$a$a */
        /* loaded from: classes11.dex */
        static final class C9609a implements OConfigListener {
            public static final C9609a INSTANCE = new C9609a();

            C9609a() {
            }

            /* JADX WARN: Removed duplicated region for block: B:53:0x00a6  */
            /* JADX WARN: Removed duplicated region for block: B:54:0x00a7 A[Catch: Exception -> 0x00a1, TryCatch #1 {Exception -> 0x00a1, blocks: (B:46:0x009a, B:55:0x00ab, B:54:0x00a7), top: B:61:0x009a }] */
            @Override // com.taobao.orange.OConfigListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void onConfigUpdate(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) {
                /*
                    r6 = this;
                    java.lang.String r8 = "movie_windvane"
                    boolean r8 = tb.b41.d(r7, r8)
                    if (r8 == 0) goto Lb2
                    com.taobao.orange.OrangeConfig r8 = com.taobao.orange.OrangeConfig.getInstance()
                    java.lang.String r0 = "domain"
                    r1 = 0
                    java.lang.String r8 = r8.getConfig(r7, r0, r1)
                    r0 = 0
                    r2 = 1
                    if (r8 == 0) goto L20
                    int r3 = r8.length()
                    if (r3 != 0) goto L1e
                    goto L20
                L1e:
                    r3 = 0
                    goto L21
                L20:
                    r3 = 1
                L21:
                    if (r3 != 0) goto L27
                    android.taobao.windvane.config.WVServerConfig.DOMAIN_PATTERN = r8
                    android.taobao.windvane.config.WVServerConfig.domainPat = r1
                L27:
                    com.taobao.orange.OrangeConfig r8 = com.taobao.orange.OrangeConfig.getInstance()
                    java.lang.String r3 = "forbidden_domain"
                    java.lang.String r8 = r8.getConfig(r7, r3, r1)
                    if (r8 == 0) goto L3c
                    int r3 = r8.length()
                    if (r3 != 0) goto L3a
                    goto L3c
                L3a:
                    r3 = 0
                    goto L3d
                L3c:
                    r3 = 1
                L3d:
                    if (r3 != 0) goto L43
                    android.taobao.windvane.config.WVServerConfig.FORBIDDEN_DOMAIN_PATTERN = r8
                    android.taobao.windvane.config.WVServerConfig.forbiddenDomain = r1
                L43:
                    com.taobao.orange.OrangeConfig r8 = com.taobao.orange.OrangeConfig.getInstance()
                    java.lang.String r3 = "third_party_domain"
                    java.lang.String r8 = r8.getConfig(r7, r3, r1)
                    if (r8 == 0) goto L58
                    int r3 = r8.length()
                    if (r3 != 0) goto L56
                    goto L58
                L56:
                    r3 = 0
                    goto L59
                L58:
                    r3 = 1
                L59:
                    if (r3 != 0) goto L5f
                    android.taobao.windvane.config.WVServerConfig.THIRD_PARTY_DOMAIN_PATTERN = r8
                    android.taobao.windvane.config.WVServerConfig.thirdPartyDomain = r1
                L5f:
                    com.taobao.orange.OrangeConfig r8 = com.taobao.orange.OrangeConfig.getInstance()
                    java.lang.String r3 = "redirect_domain"
                    java.lang.String r8 = r8.getConfig(r7, r3, r1)
                    tb.qm$a r3 = tb.qm.Companion
                    java.util.regex.Pattern r4 = r3.b()
                    r5 = 2
                    if (r4 != 0) goto L8c
                    if (r8 == 0) goto L7d
                    int r4 = r8.length()
                    if (r4 != 0) goto L7b
                    goto L7d
                L7b:
                    r4 = 0
                    goto L7e
                L7d:
                    r4 = 1
                L7e:
                    if (r4 != 0) goto L8c
                    java.util.regex.Pattern r8 = java.util.regex.Pattern.compile(r8, r5)     // Catch: java.lang.Exception -> L88
                    r3.e(r8)     // Catch: java.lang.Exception -> L88
                    goto L8c
                L88:
                    r8 = move-exception
                    r8.printStackTrace()
                L8c:
                    com.taobao.orange.OrangeConfig r8 = com.taobao.orange.OrangeConfig.getInstance()
                    java.lang.String r3 = "apiWhiteList"
                    java.lang.String r4 = "^(http|https):.*(\\.|//)((taopiaopiao|youku|tmall|taobao|alipay|alipay-eco|shuqiread|pstatp|dushemovie|tudou|fliggy|koubei|yuekeyun|mikecrm|ankerjiedian|laiwang|xiami|alimei|dongting|goofish|alibaba|aliresearch|alibabagroup|aliexpress|alimama|aliyun|juhuasuan|dingtalk|etao|hitao|95095|alicdn|myqcloud|taohua|shuqi|azusasoft|agtcdn|kuaishou|b1yq|iqima|(public-oss\\\\\\\\.futurehotel)|diditaxi|alibaba-inc)\\.com|(damai|tb|piao|uc|5zhua|mashort|html5case\\.com|hsbc\\.com|duiba\\.com|xianshang\\.hydron\\.com|catchme\\.com)\\.cn|(alipay|alibaba|agtcdn)\\.net|(tmall)\\.hk|(ele)\\.me)(\\?|#|/|:|$)"
                    java.lang.String r7 = r8.getConfig(r7, r3, r4)
                    if (r7 == 0) goto La3
                    int r8 = r7.length()     // Catch: java.lang.Exception -> La1
                    if (r8 != 0) goto La4
                    goto La3
                La1:
                    r7 = move-exception
                    goto Laf
                La3:
                    r0 = 1
                La4:
                    if (r0 == 0) goto La7
                    goto Lab
                La7:
                    java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r7, r5)     // Catch: java.lang.Exception -> La1
                Lab:
                    tb.qm.c(r1)     // Catch: java.lang.Exception -> La1
                    goto Lb2
                Laf:
                    r7.printStackTrace()
                Lb2:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: tb.qm.C9608a.C9609a.onConfigUpdate(java.lang.String, java.util.Map):void");
            }
        }

        private C9608a() {
        }

        public final void a() {
            OrangeConfig.getInstance().registerListener(new String[]{"movie_windvane"}, C9609a.INSTANCE, true);
        }

        @Nullable
        public final Pattern b() {
            return qm.b;
        }

        public final boolean c(@Nullable String str) {
            if (qm.a != null) {
                try {
                    Pattern pattern = qm.a;
                    if (pattern != null) {
                        b41.f(str);
                        Matcher matcher = pattern.matcher(str);
                        if (matcher != null) {
                            if (matcher.find()) {
                                return true;
                            }
                        }
                    }
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            }
            return true;
        }

        public final boolean d(@Nullable String str) {
            Matcher matcher;
            if (str != null) {
                try {
                    Pattern b = qm.Companion.b();
                    if (b == null || (matcher = b.matcher(str)) == null) {
                        return false;
                    }
                    return matcher.find();
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }

        public final void e(@Nullable Pattern pattern) {
            qm.b = pattern;
        }

        public /* synthetic */ C9608a(k50 k50Var) {
            this();
        }
    }
}
