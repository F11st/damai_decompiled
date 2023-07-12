package com.opensource.svgaplayer;

import android.content.Context;
import android.os.Handler;
import com.opensource.svgaplayer.SVGAParser;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/wt2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes10.dex */
public final class SVGAParser$parse$5 implements Runnable {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ SVGAParser.ParseCompletion $callback;
    final /* synthetic */ boolean $closeInputStream;
    final /* synthetic */ InputStream $inputStream;
    final /* synthetic */ SVGAParser this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SVGAParser$parse$5(SVGAParser sVGAParser, InputStream inputStream, String str, boolean z, SVGAParser.ParseCompletion parseCompletion) {
        this.this$0 = sVGAParser;
        this.$inputStream = inputStream;
        this.$cacheKey = str;
        this.$closeInputStream = z;
        this.$callback = parseCompletion;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final SVGAVideoEntity h;
        Context context;
        h = this.this$0.h(this.$inputStream, this.$cacheKey);
        if (this.$closeInputStream) {
            this.$inputStream.close();
        }
        if (h == null) {
            context = this.this$0.b;
            new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAParser$parse$5.2
                @Override // java.lang.Runnable
                public final void run() {
                    SVGAParser$parse$5.this.$callback.onError();
                }
            });
            return;
        }
        h.i(new Function0<wt2>() { // from class: com.opensource.svgaplayer.SVGAParser$parse$5.1
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
                context2 = SVGAParser$parse$5.this.this$0.b;
                new Handler(context2.getMainLooper()).post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAParser.parse.5.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        SVGAParser$parse$5.this.$callback.onComplete(h);
                    }
                });
            }
        });
    }
}
