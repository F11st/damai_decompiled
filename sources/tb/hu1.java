package tb;

import com.alibaba.pictures.dolores.DoloresKernel;
import com.alibaba.pictures.dolores.business.AsyncResult;
import com.alibaba.pictures.dolores.preload.IPreloadRequest;
import com.alibaba.pictures.dolores.preload.PreloadState;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class hu1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int PRELOAD_CAPACITY = 50;
    @NotNull
    public static final String TAG = "PreloadManager";
    @NotNull
    public static final hu1 INSTANCE = new hu1();
    @NotNull
    private static Map<String, iu1<?>> a = new LinkedHashMap();

    private hu1() {
    }

    private final <BizResponse> boolean a(DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1285339258")) {
            return ((Boolean) ipChange.ipc$dispatch("1285339258", new Object[]{this, doloresRequest})).booleanValue();
        }
        if (doloresRequest == null) {
            rq.c(TAG, "preload:checkRequestValid:[false],request == null");
            return false;
        } else if (!(doloresRequest instanceof IPreloadRequest)) {
            rq.c(TAG, "preload:checkRequestValid:[false],request !is IPreloadRequest" + doloresRequest.getClass().getName());
            return false;
        } else {
            String preLoadCacheKey = ((IPreloadRequest) doloresRequest).preLoadCacheKey();
            if (preLoadCacheKey == null || preLoadCacheKey.length() == 0) {
                rq.c(TAG, "preload:checkRequestValid:[false],request.preLoadCacheKey().isNullOrEmpty()");
                return false;
            }
            return true;
        }
    }

    @Nullable
    public final <BizResponse> iu1<BizResponse> b(@Nullable DoloresKernel<BizResponse> doloresKernel) {
        String preLoadCacheKey;
        DoloresKernel f;
        Map.Entry<String, iu1<?>> next;
        DoloresRequest<BizResponse> m;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-515656342")) {
            return (iu1) ipChange.ipc$dispatch("-515656342", new Object[]{this, doloresKernel});
        }
        if (!a(doloresKernel != null ? doloresKernel.m() : null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("preload:markPreload:当前request不满足要求，，不执行预加载！");
            sb.append((doloresKernel == null || (m = doloresKernel.m()) == null) ? null : m.getClass().getSimpleName());
            rq.c(TAG, sb.toString());
            return null;
        }
        DoloresRequest<BizResponse> m2 = doloresKernel != null ? doloresKernel.m() : null;
        if (!(m2 instanceof IPreloadRequest)) {
            m2 = null;
        }
        IPreloadRequest iPreloadRequest = (IPreloadRequest) m2;
        if (iPreloadRequest == null || (preLoadCacheKey = iPreloadRequest.preLoadCacheKey()) == null) {
            return null;
        }
        iu1<BizResponse> iu1Var = new iu1<>(doloresKernel);
        a.put(preLoadCacheKey, iu1Var);
        try {
            if (a.size() > 50) {
                Iterator<Map.Entry<String, iu1<?>>> it = a.entrySet().iterator();
                String key = (!it.hasNext() || (next = it.next()) == null) ? null : next.getKey();
                Map<String, iu1<?>> map = a;
                if (map == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                }
                iu1 iu1Var2 = (iu1) tq2.c(map).remove(key);
                if (iu1Var2 != null && (f = iu1Var2.f()) != null) {
                    if (f.n() != 3 && f.n() != 2) {
                        z = true;
                    }
                    if (!z) {
                        f = null;
                    }
                    if (f != null) {
                        f.d(true);
                    }
                }
            }
        } catch (Exception e) {
            rq.c(TAG, "preload:限制预加载数量50，处理移除时报错：" + e);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("preload:当前request");
        DoloresRequest<BizResponse> m3 = doloresKernel.m();
        sb2.append(m3 != null ? m3.getClass().getSimpleName() : null);
        sb2.append("支持预加载！cachekey满足，记录完成");
        rq.a(TAG, sb2.toString());
        return iu1Var;
    }

    @Nullable
    public final <BizResponse> iu1<BizResponse> c(@Nullable DoloresRequest<BizResponse> doloresRequest) {
        String preLoadCacheKey;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1642580474")) {
            return (iu1) ipChange.ipc$dispatch("1642580474", new Object[]{this, doloresRequest});
        }
        IPreloadRequest iPreloadRequest = (IPreloadRequest) (!(doloresRequest instanceof IPreloadRequest) ? null : doloresRequest);
        if (iPreloadRequest != null && (preLoadCacheKey = iPreloadRequest.preLoadCacheKey()) != null) {
            iu1<BizResponse> iu1Var = (iu1<BizResponse>) a.remove(preLoadCacheKey);
            if (iu1Var == null) {
                try {
                    rq.c(TAG, "preload:obtainAndRemove=null " + doloresRequest.getClass().getSimpleName());
                } catch (Exception unused) {
                    rq.c(TAG, "preload:强转失败，请检查");
                }
            }
            if (iu1Var instanceof iu1) {
                return iu1Var;
            }
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("preload:obtainAndRemove:检查request:");
        sb.append(doloresRequest != null ? doloresRequest.getClass().getSimpleName() : null);
        sb.append(" 是否实现IPreloadRequest接口，且preLoadCacheKey()返回值非空");
        rq.c(TAG, sb.toString());
        return null;
    }

    public final <BizResponse> void d(@Nullable DoloresRequest<BizResponse> doloresRequest) {
        String preLoadCacheKey;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1776889749")) {
            ipChange.ipc$dispatch("1776889749", new Object[]{this, doloresRequest});
            return;
        }
        if (!(doloresRequest instanceof IPreloadRequest)) {
            doloresRequest = null;
        }
        IPreloadRequest iPreloadRequest = (IPreloadRequest) doloresRequest;
        if (iPreloadRequest == null || (preLoadCacheKey = iPreloadRequest.preLoadCacheKey()) == null) {
            return;
        }
        try {
            a.remove(preLoadCacheKey);
        } catch (Exception e) {
            rq.c(TAG, "preload: remove " + e);
            wt2 wt2Var = wt2.INSTANCE;
        }
    }

    @NotNull
    public final <BizResponse> gu1<BizResponse> e(@Nullable AsyncResult<BizResponse> asyncResult, @Nullable DoloresKernel<BizResponse> doloresKernel) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1751713532")) {
            return (gu1) ipChange.ipc$dispatch("-1751713532", new Object[]{this, asyncResult, doloresKernel});
        }
        gu1<BizResponse> gu1Var = new gu1<>();
        Boolean bool = Boolean.FALSE;
        gu1Var.c(bool);
        if (doloresKernel != null && asyncResult != null && a(doloresKernel.m()) && !doloresKernel.x()) {
            StringBuilder sb = new StringBuilder();
            sb.append("preload:handlePreloadData，----尝试读取预加载数据:");
            DoloresRequest<BizResponse> m = doloresKernel.m();
            sb.append(m != null ? m.getClass().getSimpleName() : null);
            rq.a(TAG, sb.toString());
            iu1<BizResponse> c = INSTANCE.c(doloresKernel.m());
            if (c != null) {
                if (c.h() != PreloadState.STATE_START && c.h() != PreloadState.STATE_HIT_CACHE) {
                    if (c.h() == PreloadState.STATE_FINISH) {
                        boolean z = c.e() > System.currentTimeMillis();
                        if (c.g() != null && z) {
                            rq.a(TAG, "preload:handlePreloadData，----预加载已经完成且有效，直接使用返回值");
                            gu1Var.d(c.g());
                        } else {
                            rq.a(TAG, "preload:handlePreloadData: 预加载已完成，但结果无效（超出有效期或者为null）！");
                        }
                        gu1Var.c(bool);
                    } else {
                        gu1Var.c(bool);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("preload:handlePreloadData: processRealRequest[");
                        DoloresRequest<BizResponse> m2 = doloresKernel.m();
                        sb2.append(m2 != null ? m2.getClass().getSimpleName() : null);
                        sb2.append("]: 无预加载！state=");
                        sb2.append(c.h());
                        rq.a(TAG, sb2.toString());
                    }
                } else {
                    rq.a(TAG, "preload:handlePreloadData，----尝试读取预加载数据，预加载已经开始没有返回，记录本次回调-return");
                    c.a(doloresKernel, asyncResult);
                    if (c.h() == PreloadState.STATE_HIT_CACHE) {
                        asyncResult.onHitCache(true, c.d());
                    }
                    gu1Var.c(Boolean.TRUE);
                }
            }
        }
        return gu1Var;
    }
}
