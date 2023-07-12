package com.alibaba.pictures.dolores;

import android.content.Context;
import android.os.SystemClock;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.alibaba.pictures.dolores.DoloresKernel;
import com.alibaba.pictures.dolores.business.AsyncRequestFuture;
import com.alibaba.pictures.dolores.business.AsyncResult;
import com.alibaba.pictures.dolores.business.IRequestInterceptor;
import com.alibaba.pictures.dolores.business.Result;
import com.alibaba.pictures.dolores.config.IGlobalConfig;
import com.alibaba.pictures.dolores.convert.IJSONConverter;
import com.alibaba.pictures.dolores.lifecycle.DoloresClearStoreProvider;
import com.alibaba.pictures.dolores.lifecycle.DoloresViewModel;
import com.alibaba.pictures.dolores.login.DoloresLoginHandler;
import com.alibaba.pictures.dolores.preload.IPreloadListener;
import com.alibaba.pictures.dolores.preload.PreloadState;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alibaba.pictures.dolores.response.BizResponseType;
import com.alibaba.pictures.dolores.time.TimeSyncer;
import com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.common.Constants;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Locale;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.ErrorConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.bf;
import tb.bo2;
import tb.dc0;
import tb.ec0;
import tb.hu1;
import tb.iu1;
import tb.jn1;
import tb.k50;
import tb.rq;
import tb.sb0;
import tb.ub0;
import tb.wt2;
import tb.xh0;
import tb.y12;
import tb.zb0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class DoloresKernel<BizResponse> implements Closeable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C3603a Companion = new C3603a(null);
    public static final int NODE_REQUEST_COMPLETE = 4;
    public static final int NODE_REQUEST_PREPARE = 1;
    public static final int NODE_REQUEST_REQUEST = 2;
    public static final int NODE_REQUEST_RESPONSE = 3;
    public static final int NODE_REQUEST_START = 0;
    public static final int STATE_CANCEL = 2;
    public static final int STATE_FINISH = 3;
    public static final int STATE_ING = 1;
    public static final int STATE_INIT = 0;
    public static final int STATE_RECYCLED = -1;
    @NotNull
    private static final String s;
    @NotNull
    private final Lazy a;
    @Nullable
    private Object b;
    private int c;
    @Nullable
    private Type d;
    @Nullable
    private IRequestInterceptor e;
    private boolean f;
    private DoloresClearStoreProvider g;
    @Nullable
    private y12 h;
    @Nullable
    private bf i;
    @Nullable
    private Boolean j;
    @Nullable
    private Boolean k;
    @Nullable
    private Boolean l;
    @Nullable
    private String m;
    @NotNull
    private IJSONConverter n;
    @Nullable
    private String o;
    @Nullable
    private String p;
    @Nullable
    private AsyncRequestFuture<BizResponse> q;
    private boolean r;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.dolores.DoloresKernel$a */
    /* loaded from: classes7.dex */
    public static final class C3603a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3603a() {
        }

        @NotNull
        public final String a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "285095566") ? (String) ipChange.ipc$dispatch("285095566", new Object[]{this}) : DoloresKernel.s;
        }

        public /* synthetic */ C3603a(k50 k50Var) {
            this();
        }
    }

    static {
        String simpleName = DoloresKernel.class.getSimpleName();
        b41.h(simpleName, "DoloresKernel::class.java.simpleName");
        s = simpleName;
    }

    public DoloresKernel() {
        Lazy b;
        String str;
        String str2;
        String str3;
        b = C8177b.b(new Function0<bo2>() { // from class: com.alibaba.pictures.dolores.DoloresKernel$timeMonitor$2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final bo2 invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-495268938") ? (bo2) ipChange.ipc$dispatch("-495268938", new Object[]{this}) : new bo2();
            }
        });
        this.a = b;
        sb0.C9690a c9690a = sb0.Companion;
        IJSONConverter c = c9690a.c();
        this.n = c == null ? xh0.INSTANCE : c;
        if (this.j == null) {
            String k = c9690a.g().k(IGlobalConfig.Key.WUA_SWITCH, "off");
            if (k != null) {
                Locale locale = Locale.ROOT;
                b41.h(locale, "Locale.ROOT");
                str3 = k.toLowerCase(locale);
                b41.h(str3, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str3 = null;
            }
            this.j = Boolean.valueOf(b41.d(str3, "on"));
        }
        if (this.k == null) {
            String k2 = c9690a.g().k(IGlobalConfig.Key.IS_USE_HTTPS, "true");
            if (k2 != null) {
                Locale locale2 = Locale.ROOT;
                b41.h(locale2, "Locale.ROOT");
                str2 = k2.toLowerCase(locale2);
                b41.h(str2, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str2 = null;
            }
            this.k = Boolean.valueOf(b41.d(str2, "true"));
        }
        if (this.l == null) {
            String k3 = c9690a.g().k(IGlobalConfig.Key.IS_GET, "false");
            if (k3 != null) {
                Locale locale3 = Locale.ROOT;
                b41.h(locale3, "Locale.ROOT");
                str = k3.toLowerCase(locale3);
                b41.h(str, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            this.l = Boolean.valueOf(b41.d(str, "true"));
        }
        if (this.m == null) {
            this.m = c9690a.g().k(IGlobalConfig.Key.PROJECT_NAME, null);
        }
    }

    private final void L() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1309718061")) {
            ipChange.ipc$dispatch("-1309718061", new Object[]{this});
        } else {
            TimeSyncer.INSTANCE.j();
        }
    }

    private final void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1015947792")) {
            ipChange.ipc$dispatch("1015947792", new Object[]{this});
            return;
        }
        try {
            C("commitLoginCancel");
            zb0.i(this.o, this.p);
        } catch (Exception e) {
            String str = s;
            rq.c(str, "commitLoginCancel:" + e.getMessage());
        }
    }

    private final void t(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-284144235")) {
            ipChange.ipc$dispatch("-284144235", new Object[]{this, obj});
            return;
        }
        if (this.d == null && obj != null) {
            Type genericSuperclass = obj.getClass().getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                this.d = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("initBizClass bizTypeClass=");
        Type type = this.d;
        sb.append(type != null ? type.toString() : null);
        C(sb.toString());
    }

    public final void A(final long j, @Nullable final IPreloadListener<BizResponse> iPreloadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1996293088")) {
            ipChange.ipc$dispatch("1996293088", new Object[]{this, Long.valueOf(j), iPreloadListener});
            return;
        }
        final iu1<BizResponse> b = hu1.INSTANCE.b(this);
        if (b == null) {
            rq.c(s, "preload:预加载失败，request 不满足需求！");
            if (iPreloadListener != null) {
                iPreloadListener.onFail();
                return;
            }
            return;
        }
        String str = s;
        StringBuilder sb = new StringBuilder();
        sb.append("preload:开始预加载：request:");
        DoloresRequest<BizResponse> m = m();
        sb.append(m != null ? m.getClass().getSimpleName() : null);
        sb.append('-');
        sb.append(this);
        rq.a(str, sb.toString());
        b.m(Long.valueOf(j));
        b.l(PreloadState.STATE_START);
        this.r = true;
        final AsyncResult dispatchOnOri$default = AsyncResult.dispatchOnOri$default(b(false), null, 1, null);
        dispatchOnOri$default.doOnKTStart(new Function1<DoloresRequest<BizResponse>, wt2>() { // from class: com.alibaba.pictures.dolores.DoloresKernel$preload$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(Object obj) {
                invoke((DoloresRequest) ((DoloresRequest) obj));
                return wt2.INSTANCE;
            }

            public final void invoke(@Nullable DoloresRequest<BizResponse> doloresRequest) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1123902970")) {
                    ipChange2.ipc$dispatch("-1123902970", new Object[]{this, doloresRequest});
                    return;
                }
                String a = DoloresKernel.Companion.a();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("preload:doOnKTStart:");
                sb2.append(doloresRequest != null ? doloresRequest.getClass().getSimpleName() : null);
                rq.a(a, sb2.toString());
            }
        }).doOnKTHitCache(new Function2<Boolean, BizResponse, wt2>() { // from class: com.alibaba.pictures.dolores.DoloresKernel$preload$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ wt2 invoke(Boolean bool, Object obj) {
                invoke(bool.booleanValue(), (boolean) obj);
                return wt2.INSTANCE;
            }

            public final void invoke(boolean z, @Nullable BizResponse bizresponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1137436263")) {
                    ipChange2.ipc$dispatch("1137436263", new Object[]{this, Boolean.valueOf(z), bizresponse});
                    return;
                }
                b.l(PreloadState.STATE_HIT_CACHE);
                b.i(bizresponse);
                IPreloadListener iPreloadListener2 = iPreloadListener;
                if (iPreloadListener2 != null) {
                    iPreloadListener2.onHitCache(bizresponse);
                }
                String a = DoloresKernel.Companion.a();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("preload:doOnKTHitCache:");
                DoloresRequest<BizResponse> m2 = DoloresKernel.this.m();
                sb2.append(m2 != null ? m2.getClass().getSimpleName() : null);
                rq.a(a, sb2.toString());
            }
        }).doOnKTFinish(new Function0<wt2>() { // from class: com.alibaba.pictures.dolores.DoloresKernel$preload$3
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1754151722")) {
                    ipChange2.ipc$dispatch("1754151722", new Object[]{this});
                    return;
                }
                DoloresKernel.C3603a c3603a = DoloresKernel.Companion;
                String a = c3603a.a();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("preload:doOnKTFinish:");
                DoloresRequest m2 = DoloresKernel.this.m();
                sb2.append(m2 != null ? m2.getClass().getSimpleName() : null);
                rq.a(a, sb2.toString());
                dc0<BizResponse> response = dispatchOnOri$default.getResponse();
                if (response != 0) {
                    response.k(true);
                }
                b.k(response);
                b.j(System.currentTimeMillis() + j);
                b.l(PreloadState.STATE_FINISH);
                AsyncResult b2 = b.b();
                DoloresKernel c = b.c();
                if (c != null && b2 != null && response != 0) {
                    hu1.INSTANCE.d(DoloresKernel.this.m());
                    b2.setResponse(response);
                    response.o(b2.getTag());
                    if (c.u()) {
                        String a2 = c3603a.a();
                        rq.d(a2, "preload:[" + c.g() + "]->该请求被取消||返回时业务调用页面生命周期已结束");
                        b2.onFinish();
                        c.z();
                        return;
                    }
                    rq.a(c3603a.a(), "preload:doOnKTFinish:真实业务已经发出,处理onFail或success!");
                    if (response.b() == BizResponseType.RESULT_SUCCESS.getCode()) {
                        String a3 = c3603a.a();
                        rq.a(a3, jn1.ARRAY_START + c.g() + "]->onSuccess call back");
                        if (response.a() == null) {
                            if (!b2.onSuccessNull(response)) {
                                b2.onFail(response);
                            }
                        } else {
                            Object a4 = response.a();
                            b41.f(a4);
                            b2.onSuccess(a4);
                        }
                    } else {
                        String a5 = c3603a.a();
                        rq.a(a5, "preload:[" + c.g() + "]->onFail call back");
                        b2.onFail(response);
                    }
                    b2.onFinish();
                    IPreloadListener iPreloadListener2 = iPreloadListener;
                    if (iPreloadListener2 != null) {
                        iPreloadListener2.onPreloadOver(response, true);
                    }
                    c.z();
                    String a6 = c3603a.a();
                    rq.a(a6, "preload:[" + c.g() + "]->AsyncRequestFuture done");
                    return;
                }
                IPreloadListener iPreloadListener3 = iPreloadListener;
                if (iPreloadListener3 != null) {
                    iPreloadListener3.onPreloadOver(response, false);
                }
                rq.a(c3603a.a(), "preload:doOnKTFinish:真实业务请求还没有发出,只缓存!");
            }
        });
    }

    public final void B(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1516941311")) {
            ipChange.ipc$dispatch("1516941311", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.c = 0;
        t(m());
        if (z) {
            L();
        }
        this.c = 1;
    }

    public final void C(@NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2002241")) {
            ipChange.ipc$dispatch("2002241", new Object[]{this, str});
            return;
        }
        b41.i(str, "msg");
        String str2 = s;
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.ARRAY_START);
        sb.append(this);
        sb.append("]@[");
        DoloresRequest<BizResponse> m = m();
        sb.append(m != null ? m.getClass().getSimpleName() : null);
        sb.append('-');
        sb.append(this.o);
        sb.append("]:: ");
        sb.append(str);
        rq.a(str2, sb.toString());
    }

    @NotNull
    public abstract dc0<BizResponse> D(@NotNull Result<BizResponse> result);

    public void E() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "966807657")) {
            ipChange.ipc$dispatch("966807657", new Object[]{this});
            return;
        }
        C(Constants.Name.RECYCLE);
        this.c = -1;
        this.i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.h = null;
        this.g = null;
        H(null);
        this.o = null;
        this.p = null;
        this.f = false;
        this.d = null;
        this.q = null;
        this.r = false;
    }

    public final void F(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2005750059")) {
            ipChange.ipc$dispatch("-2005750059", new Object[]{this, str});
        } else {
            this.o = str;
        }
    }

    public final void G(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-122745338")) {
            ipChange.ipc$dispatch("-122745338", new Object[]{this, str});
        } else {
            this.p = str;
        }
    }

    public abstract void H(@Nullable DoloresRequest<BizResponse> doloresRequest);

    public abstract void I(@Nullable IRemoteDataTransformer<BizResponse> iRemoteDataTransformer);

    public final void J(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1144347880")) {
            ipChange.ipc$dispatch("1144347880", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.f = z;
        }
    }

    public final void K(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-641762364")) {
            ipChange.ipc$dispatch("-641762364", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    @NotNull
    public final AsyncResult<BizResponse> b(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1500722870")) {
            return (AsyncResult) ipChange.ipc$dispatch("-1500722870", new Object[]{this, Boolean.valueOf(z)});
        }
        y(0);
        C("asyncRequest");
        B(z);
        AsyncResult<BizResponse> asyncResult = new AsyncResult<>();
        asyncResult.setTag(this.b);
        AsyncRequestFuture<BizResponse> asyncRequestFuture = new AsyncRequestFuture<>(asyncResult, this);
        this.q = asyncRequestFuture;
        ec0.INSTANCE.b(asyncRequestFuture);
        return asyncResult;
    }

    public final void c(@Nullable Context context) {
        ub0 doloresClearStore;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "237792058")) {
            ipChange.ipc$dispatch("237792058", new Object[]{this, context});
            return;
        }
        C("attachTo context");
        if (context instanceof ViewModelStoreOwner) {
            DoloresClearStoreProvider doloresClearStoreProvider = (DoloresClearStoreProvider) new ViewModelProvider((ViewModelStoreOwner) context).get(DoloresViewModel.class);
            this.g = doloresClearStoreProvider;
            if (doloresClearStoreProvider == null || (doloresClearStore = doloresClearStoreProvider.getDoloresClearStore()) == null) {
                return;
            }
            doloresClearStore.a(String.valueOf(hashCode()), this);
            return;
        }
        rq.d(s, "attachTo(context),context==null||context is not ViewModelStoreOwner,生命周期无绑定");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-193995612")) {
            ipChange.ipc$dispatch("-193995612", new Object[]{this});
            return;
        }
        C("页面生命周期结束 触发 close");
        d(false);
    }

    public boolean d(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2039251996")) {
            return ((Boolean) ipChange.ipc$dispatch("-2039251996", new Object[]{this, Boolean.valueOf(z)})).booleanValue();
        }
        C("cancel by user = " + z);
        this.c = 2;
        AsyncRequestFuture<BizResponse> asyncRequestFuture = this.q;
        if (asyncRequestFuture != null) {
            asyncRequestFuture.cancel(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final dc0<BizResponse> e(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1679081604")) {
            return (dc0) ipChange.ipc$dispatch("-1679081604", new Object[]{this, Boolean.valueOf(z)});
        }
        C("checkSessionValid[checkLocal=" + z + jn1.ARRAY_END);
        if (!this.f && (!b41.d(sb0.Companion.g().k(IGlobalConfig.Key.NEED_LOGIN_FOR_ALL_REQ, "false"), "true"))) {
            C("not needEcode && not isNeedLoginForAllRequest");
            return null;
        } else if (z && DoloresLoginHandler.Companion.a().c()) {
            C("isSessionValid = true");
            return null;
        } else {
            DoloresLoginHandler.C3607a c3607a = DoloresLoginHandler.Companion;
            int b = c3607a.a().b();
            if (b == 3) {
                f();
            }
            if (!this.f || c3607a.a().c()) {
                return null;
            }
            C("isSessionValid = false,Session过期");
            dc0<BizResponse> dc0Var = new dc0<>();
            dc0Var.l(new MtopResponse("FAIL_SYS_SESSION_EXPIRED", ErrorConstant.ERRMSG_FAIL_SYS_SESSION_EXPIRED));
            dc0Var.h((b == 3 ? BizResponseType.RESULT_CODE_SESSION_EXPIRED : BizResponseType.RESULT_CODE_LOGIN_CANCELED).getCode());
            dc0Var.j(BizResponseType.RESULT_CODE_SESSION_EXPIRED.getDesc());
            return dc0Var;
        }
    }

    @Nullable
    public final String g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-428206399") ? (String) ipChange.ipc$dispatch("-428206399", new Object[]{this}) : this.o;
    }

    @Nullable
    public final String j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-628635432") ? (String) ipChange.ipc$dispatch("-628635432", new Object[]{this}) : this.p;
    }

    @Nullable
    public final Type k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-681429137") ? (Type) ipChange.ipc$dispatch("-681429137", new Object[]{this}) : this.d;
    }

    @Nullable
    public final bf l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1535957948") ? (bf) ipChange.ipc$dispatch("-1535957948", new Object[]{this}) : this.i;
    }

    @Nullable
    public abstract DoloresRequest<BizResponse> m();

    public final int n() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "515044343") ? ((Integer) ipChange.ipc$dispatch("515044343", new Object[]{this})).intValue() : this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final String o() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "516250176") ? (String) ipChange.ipc$dispatch("516250176", new Object[]{this}) : this.m;
    }

    @Nullable
    public final y12 p() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "209186938") ? (y12) ipChange.ipc$dispatch("209186938", new Object[]{this}) : this.h;
    }

    @Nullable
    public final IRequestInterceptor q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1723801957")) {
            return (IRequestInterceptor) ipChange.ipc$dispatch("-1723801957", new Object[]{this});
        }
        if (this.e == null) {
            this.e = sb0.Companion.b();
        }
        return this.e;
    }

    @NotNull
    public final bo2 r() {
        IpChange ipChange = $ipChange;
        return (bo2) (AndroidInstantRuntime.support(ipChange, "-2078869332") ? ipChange.ipc$dispatch("-2078869332", new Object[]{this}) : this.a.getValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Boolean s() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-950625174") ? (Boolean) ipChange.ipc$dispatch("-950625174", new Object[]{this}) : this.j;
    }

    public final boolean u() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1141604625") ? ((Boolean) ipChange.ipc$dispatch("-1141604625", new Object[]{this})).booleanValue() : this.c == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Boolean v() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1357155951") ? (Boolean) ipChange.ipc$dispatch("1357155951", new Object[]{this}) : this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Boolean w() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1508772666") ? (Boolean) ipChange.ipc$dispatch("1508772666", new Object[]{this}) : this.k;
    }

    public final boolean x() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-422668223") ? ((Boolean) ipChange.ipc$dispatch("-422668223", new Object[]{this})).booleanValue() : this.r;
    }

    public final void y(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-251447159")) {
            ipChange.ipc$dispatch("-251447159", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 0) {
            r().e(SystemClock.elapsedRealtime());
        } else if (i == 1) {
            r().b(SystemClock.elapsedRealtime());
        } else if (i == 2) {
            r().c(SystemClock.elapsedRealtime());
        } else if (i == 3) {
            r().d(SystemClock.elapsedRealtime());
        } else if (i != 4) {
        } else {
            r().a(SystemClock.elapsedRealtime());
            String str = this.o;
            if (str == null) {
                str = toString();
            }
            String str2 = this.p;
            if (str2 == null) {
                str2 = "unknown";
            }
            zb0.g(str, str2, r());
        }
    }

    public final void z() {
        ub0 doloresClearStore;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1627826775")) {
            ipChange.ipc$dispatch("1627826775", new Object[]{this});
            return;
        }
        C("onTaskFinish");
        y(4);
        DoloresClearStoreProvider doloresClearStoreProvider = this.g;
        if (doloresClearStoreProvider != null && (doloresClearStore = doloresClearStoreProvider.getDoloresClearStore()) != null) {
            doloresClearStore.d(String.valueOf(hashCode()));
        }
        this.c = 3;
        m();
        E();
    }
}
