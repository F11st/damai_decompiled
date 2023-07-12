package tb;

import com.youku.live.livesdk.wkit.component.Constants;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class zh0 {
    public static final zh0 INSTANCE = new zh0();

    private zh0() {
    }

    private final <S> S a(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        List<S> A0;
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            A0 = CollectionsKt___CollectionsKt.A0(ServiceLoader.load(cls, classLoader));
            return A0;
        }
    }

    private final List<String> e(URL url) {
        boolean F;
        String E0;
        String J0;
        String E02;
        String url2 = url.toString();
        F = kotlin.text.o.F(url2, "jar", false, 2, null);
        if (F) {
            E0 = StringsKt__StringsKt.E0(url2, "jar:file:", null, 2, null);
            J0 = StringsKt__StringsKt.J0(E0, '!', null, 2, null);
            E02 = StringsKt__StringsKt.E0(url2, "!/", null, 2, null);
            JarFile jarFile = new JarFile(J0, false);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(E02)), "UTF-8"));
                List<String> f = INSTANCE.f(bufferedReader);
                xj.a(bufferedReader, null);
                jarFile.close();
                return f;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        jarFile.close();
                        throw th2;
                    } catch (Throwable th3) {
                        hg0.a(th, th3);
                        throw th;
                    }
                }
            }
        }
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(url.openStream()));
        try {
            List<String> f2 = INSTANCE.f(bufferedReader2);
            xj.a(bufferedReader2, null);
            return f2;
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                xj.a(bufferedReader2, th4);
                throw th5;
            }
        }
    }

    private final List<String> f(BufferedReader bufferedReader) {
        List<String> A0;
        String K0;
        CharSequence M0;
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                K0 = StringsKt__StringsKt.K0(readLine, Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX, null, 2, null);
                Objects.requireNonNull(K0, "null cannot be cast to non-null type kotlin.CharSequence");
                M0 = StringsKt__StringsKt.M0(K0);
                String obj = M0.toString();
                int i = 0;
                while (true) {
                    if (i >= obj.length()) {
                        z = true;
                        break;
                    }
                    char charAt = obj.charAt(i);
                    if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (z) {
                    if (obj.length() > 0) {
                        linkedHashSet.add(obj);
                    }
                } else {
                    throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
                }
            } else {
                A0 = CollectionsKt___CollectionsKt.A0(linkedHashSet);
                return A0;
            }
        }
    }

    @NotNull
    public final List<MainDispatcherFactory> c() {
        MainDispatcherFactory mainDispatcherFactory;
        if (!ai0.a()) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            MainDispatcherFactory mainDispatcherFactory2 = null;
            try {
                mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (mainDispatcherFactory2 != null) {
                arrayList.add(mainDispatcherFactory2);
                return arrayList;
            }
            return arrayList;
        } catch (Throwable unused3) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
    }

    @NotNull
    public final <S> List<S> d(@NotNull Class<S> cls, @NotNull ClassLoader classLoader) {
        Set<String> E0;
        int q;
        ArrayList<URL> list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        b41.h(list, "java.util.Collections.list(this)");
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            kotlin.collections.r.v(arrayList, INSTANCE.e(url));
        }
        E0 = CollectionsKt___CollectionsKt.E0(arrayList);
        if (!E0.isEmpty()) {
            q = kotlin.collections.n.q(E0, 10);
            ArrayList arrayList2 = new ArrayList(q);
            for (String str : E0) {
                arrayList2.add(INSTANCE.a(str, classLoader, cls));
            }
            return arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}
