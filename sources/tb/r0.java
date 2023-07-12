package tb;

import android.os.Looper;
import com.alibaba.ability.IAbility;
import com.alibaba.ability.builder.IAbilityBuilder;
import com.alibaba.ability.callback.IOnCallbackListener;
import com.alibaba.ability.env.IAbilityContext;
import com.alibaba.ability.env.IAbilityEnv;
import com.alibaba.ability.hub.IAbilityHub;
import com.alibaba.ability.middleware.IAbilityInvoker;
import com.taobao.analysis.v3.FalcoSpanLayer;
import com.taobao.weex.bridge.WXBridgeManager;
import io.flutter.wpkbridge.WPKFactory;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class r0 {
    @NotNull
    public static final a Companion = new a(null);
    private static final ReentrantReadWriteLock e = new ReentrantReadWriteLock();
    private static final Map<String, Map<String, IAbility>> f = new HashMap();
    private final Map<String, IAbility> a;
    private IAbilityHub b;
    private final IAbilityInvoker c;
    private final IAbilityEnv d;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class b implements IAbilityInvoker {
        b() {
        }

        @Override // com.alibaba.ability.middleware.IAbilityInvoker
        @Nullable
        public jg0 invoke(@NotNull String str, @NotNull String str2, @NotNull IAbilityContext iAbilityContext, @NotNull Map<String, ? extends Object> map, @NotNull IOnCallbackListener iOnCallbackListener) {
            b41.i(str, FalcoSpanLayer.ABILITY);
            b41.i(str2, "api");
            b41.i(iAbilityContext, WPKFactory.INIT_KEY_CONTEXT);
            b41.i(map, "params");
            b41.i(iOnCallbackListener, WXBridgeManager.METHOD_CALLBACK);
            try {
                IAbility b = r0.this.b(str);
                if (b != null) {
                    return b.execute(str2, iAbilityContext, map, new o0(iOnCallbackListener));
                }
                return new hf0("404", null, null, 6, null);
            } catch (Throwable th) {
                return new hf0("500", "call stack : " + th.getMessage(), null, 4, null);
            }
        }
    }

    public r0(@NotNull IAbilityEnv iAbilityEnv) {
        b41.i(iAbilityEnv, "env");
        this.d = iAbilityEnv;
        this.a = new LinkedHashMap();
        this.c = new b();
    }

    private final IAbilityBuilder c(String str, String str2) {
        IAbilityBuilder iAbilityBuilder;
        IAbilityHub iAbilityHub = this.b;
        return (iAbilityHub == null || (iAbilityBuilder = iAbilityHub.get(str, str2)) == null) ? s0.a().get(str, str2) : iAbilityBuilder;
    }

    @Nullable
    public final jg0 a(@NotNull String str, @NotNull String str2, @NotNull IAbilityContext iAbilityContext, @NotNull Map<String, ? extends Object> map, @NotNull IOnCallbackListener iOnCallbackListener) {
        b41.i(str, "name");
        b41.i(str2, "api");
        b41.i(iAbilityContext, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(map, "params");
        b41.i(iOnCallbackListener, WXBridgeManager.METHOD_CALLBACK);
        if (iAbilityContext.getEnv() == null) {
            iAbilityContext.setEnv(this.d);
        }
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        b41.h(mainLooper, "Looper.getMainLooper()");
        if (currentThread == mainLooper.getThread()) {
            return qf1.Companion.a(rf1.a().get(str, this.d.getNamespace()), this.c).invoke(str, str2, iAbilityContext, map, iOnCallbackListener);
        }
        throw new RuntimeException("Please use asyncCall in NonMain thread");
    }

    @Nullable
    public final IAbility b(@NotNull String str) {
        String str2;
        Map<String, IAbility> map;
        Map<String, IAbility> map2;
        IAbility iAbility;
        b41.i(str, "name");
        ReentrantReadWriteLock reentrantReadWriteLock = e;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        readLock.lock();
        try {
            IAbility iAbility2 = this.a.get(str);
            if (iAbility2 != null) {
                return iAbility2;
            }
            IAbilityBuilder c = c(str, this.d.getNamespace());
            IAbility iAbility3 = null;
            if (c != null) {
                if (c.getLifeCycle() == 4) {
                    return c.build();
                }
                int lifeCycle = c.getLifeCycle();
                if (lifeCycle != 1) {
                    str2 = lifeCycle != 2 ? null : this.d.getNamespace();
                } else {
                    str2 = "";
                }
                if (str2 == null || (map2 = f.get(str2)) == null || (iAbility = map2.get(str)) == null) {
                    ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
                    int i = 0;
                    int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                    for (int i2 = 0; i2 < readHoldCount; i2++) {
                        readLock2.unlock();
                    }
                    ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
                    writeLock.lock();
                    IAbility iAbility4 = this.a.get(str);
                    if (iAbility4 != null) {
                        iAbility3 = iAbility4;
                    } else if (str2 != null && (map = f.get(str2)) != null) {
                        iAbility3 = map.get(str);
                    }
                    if (iAbility3 != null) {
                        while (i < readHoldCount) {
                            readLock2.lock();
                            i++;
                        }
                        writeLock.unlock();
                        return iAbility3;
                    }
                    IAbility build = c.build();
                    b41.f(build);
                    if (str2 != null) {
                        Map<String, Map<String, IAbility>> map3 = f;
                        if (map3.get(str2) == null) {
                            map3.put(str2, new LinkedHashMap());
                        }
                        Map<String, IAbility> map4 = map3.get(str2);
                        if (map4 != null) {
                            map4.put(str, build);
                        }
                    }
                    this.a.put(str, build);
                    while (i < readHoldCount) {
                        readLock2.lock();
                        i++;
                    }
                    writeLock.unlock();
                    return build;
                }
                return iAbility;
            }
            return null;
        } finally {
            readLock.unlock();
        }
    }
}
