package me.ele.altriax.launcher.config.ab;

import android.content.Context;
import androidx.annotation.NonNull;
import com.taobao.android.launcher.config.Generator;
import me.ele.altriax.launcher.config.ab.generator.AltriaXBLinkGenerator;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Generators {
    public static String dagName;

    public static Generator<String> create(@NonNull Context context) {
        return AltriaXBLinkGenerator.createDaMaiNormal(context);
    }
}
