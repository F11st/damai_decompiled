package me.ele.altriax.launcher.config.ab.generator;

import android.content.Context;
import androidx.annotation.NonNull;
import com.taobao.android.launcher.config.Generator;
import me.ele.altriax.launcher.common.AltriaXLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AltriaXBLinkGenerator {
    public static Generator<String> create(@NonNull Context context, @NonNull String str) {
        try {
            Class<?> cls = Class.forName(str);
            AltriaXLog.v(AltriaXLog.ALTRIAX, AltriaXLog.formatLog(AltriaXLog.ALTRIAX, "DAG", null, "Generator " + str));
            return (Generator) cls.newInstance();
        } catch (Exception unused) {
            return null;
        }
    }

    public static Generator<String> createDaMaiNormal(@NonNull Context context) {
        return create(context, "me.ele.altriax.launcher.config.impl.DamaiGenerator");
    }
}
