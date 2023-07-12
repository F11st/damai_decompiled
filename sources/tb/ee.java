package tb;

import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ee {
    @Nullable
    public final InputStream a(@NotNull String str) {
        b41.i(str, AbstractC3893a.V);
        ClassLoader classLoader = ee.class.getClassLoader();
        if (classLoader == null) {
            return ClassLoader.getSystemResourceAsStream(str);
        }
        URL resource = classLoader.getResource(str);
        if (resource == null) {
            return null;
        }
        URLConnection openConnection = resource.openConnection();
        openConnection.setUseCaches(false);
        return openConnection.getInputStream();
    }
}
