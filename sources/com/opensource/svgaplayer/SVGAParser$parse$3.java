package com.opensource.svgaplayer;

import android.content.Context;
import android.os.Handler;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.opensource.svgaplayer.SVGAParser;
import java.io.InputStream;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/io/InputStream;", AdvanceSetting.NETWORK_TYPE, "Ltb/wt2;", "invoke", "(Ljava/io/InputStream;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes10.dex */
public final class SVGAParser$parse$3 extends Lambda implements Function1<InputStream, wt2> {
    final /* synthetic */ SVGAParser.ParseCompletion $callback;
    final /* synthetic */ URL $url;
    final /* synthetic */ SVGAParser this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SVGAParser$parse$3(SVGAParser sVGAParser, URL url, SVGAParser.ParseCompletion parseCompletion) {
        super(1);
        this.this$0 = sVGAParser;
        this.$url = url;
        this.$callback = parseCompletion;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ wt2 invoke(InputStream inputStream) {
        invoke2(inputStream);
        return wt2.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull InputStream inputStream) {
        String f;
        final SVGAVideoEntity h;
        Context context;
        b41.j(inputStream, AdvanceSetting.NETWORK_TYPE);
        SVGAParser sVGAParser = this.this$0;
        f = sVGAParser.f(this.$url);
        h = sVGAParser.h(inputStream, f);
        if (h == null) {
            context = this.this$0.b;
            Boolean valueOf = Boolean.valueOf(new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAParser$parse$3$videoItem$1
                @Override // java.lang.Runnable
                public final void run() {
                    SVGAParser$parse$3.this.$callback.onError();
                }
            }));
            if (!(valueOf instanceof wt2)) {
                valueOf = null;
            }
            if (((wt2) valueOf) != null) {
                return;
            }
            wt2 wt2Var = wt2.INSTANCE;
            return;
        }
        h.i(new Function0<wt2>() { // from class: com.opensource.svgaplayer.SVGAParser$parse$3.1
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
                Context context2;
                context2 = SVGAParser$parse$3.this.this$0.b;
                new Handler(context2.getMainLooper()).post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAParser.parse.3.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        SVGAParser$parse$3.this.$callback.onComplete(h);
                    }
                });
            }
        });
    }
}
