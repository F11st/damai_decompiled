package com.alibaba.pictures.cornerstone.protocol;

import android.content.Context;
import com.uc.webview.export.extension.UCCore;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tb.hb;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H&J\"\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005H&J\b\u0010\u000b\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/alibaba/pictures/cornerstone/protocol/IInitProxy;", "T", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Ltb/hb;", "serviceProxy", "Ltb/wt2;", "preInit", "", UCCore.LEGACY_EVENT_INIT, "afterInit", "cornerstone_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public interface IInitProxy<T> {
    void afterInit();

    boolean init(@Nullable Context context, @Nullable hb<T> hbVar);

    void preInit(@Nullable Context context, @Nullable hb<T> hbVar);
}
