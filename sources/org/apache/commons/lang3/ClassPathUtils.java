package org.apache.commons.lang3;

import io.flutter.wpkbridge.WPKFactory;
import tb.r10;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ClassPathUtils {
    public static String toFullyQualifiedName(Class<?> cls, String str) {
        Validate.notNull(cls, "Parameter '%s' must not be null!", WPKFactory.INIT_KEY_CONTEXT);
        Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
        return toFullyQualifiedName(cls.getPackage(), str);
    }

    public static String toFullyQualifiedPath(Class<?> cls, String str) {
        Validate.notNull(cls, "Parameter '%s' must not be null!", WPKFactory.INIT_KEY_CONTEXT);
        Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
        return toFullyQualifiedPath(cls.getPackage(), str);
    }

    public static String toFullyQualifiedName(Package r4, String str) {
        Validate.notNull(r4, "Parameter '%s' must not be null!", WPKFactory.INIT_KEY_CONTEXT);
        Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
        return r4.getName() + "." + str;
    }

    public static String toFullyQualifiedPath(Package r4, String str) {
        Validate.notNull(r4, "Parameter '%s' must not be null!", WPKFactory.INIT_KEY_CONTEXT);
        Validate.notNull(str, "Parameter '%s' must not be null!", "resourceName");
        return r4.getName().replace('.', r10.DIR) + "/" + str;
    }
}
