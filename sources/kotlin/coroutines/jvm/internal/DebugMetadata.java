package kotlin.coroutines.jvm.internal;

import com.huawei.hms.opendevice.c;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.taobao.weex.ui.component.WXComponent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.SinceKotlin;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmName;

/* compiled from: Taobao */
@Target({ElementType.TYPE})
@SinceKotlin(version = "1.3")
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes3.dex */
public @interface DebugMetadata {
    @JvmName(name = c.a)
    String c() default "";

    @JvmName(name = "f")
    String f() default "";

    @JvmName(name = "i")
    int[] i() default {};

    @JvmName(name = NotifyType.LIGHTS)
    int[] l() default {};

    @JvmName(name = WXComponent.PROP_FS_MATCH_PARENT)
    String m() default "";

    @JvmName(name = "n")
    String[] n() default {};

    @JvmName(name = "s")
    String[] s() default {};

    @JvmName(name = "v")
    int v() default 1;
}
