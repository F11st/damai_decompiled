package com.opensource.svgaplayer;

import android.os.Handler;
import com.opensource.svgaplayer.SVGAParser;
import java.net.URL;
import kotlin.Metadata;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/wt2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes10.dex */
final class SVGAImageView$loadAttrs$$inlined$let$lambda$1 implements Runnable {
    final /* synthetic */ boolean $antiAlias$inlined;
    final /* synthetic */ boolean $autoPlay$inlined;
    final /* synthetic */ String $it;
    final /* synthetic */ SVGAParser $parser;
    final /* synthetic */ SVGAImageView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SVGAImageView$loadAttrs$$inlined$let$lambda$1(String str, SVGAParser sVGAParser, SVGAImageView sVGAImageView, boolean z, boolean z2) {
        this.$it = str;
        this.$parser = sVGAParser;
        this.this$0 = sVGAImageView;
        this.$antiAlias$inlined = z;
        this.$autoPlay$inlined = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean F;
        boolean F2;
        SVGAParser.ParseCompletion parseCompletion = new SVGAParser.ParseCompletion() { // from class: com.opensource.svgaplayer.SVGAImageView$loadAttrs$$inlined$let$lambda$1.1
            @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(@NotNull final SVGAVideoEntity sVGAVideoEntity) {
                b41.j(sVGAVideoEntity, "videoItem");
                Handler handler = SVGAImageView$loadAttrs$$inlined$let$lambda$1.this.this$0.getHandler();
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.opensource.svgaplayer.SVGAImageView$loadAttrs$.inlined.let.lambda.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            sVGAVideoEntity.o(SVGAImageView$loadAttrs$$inlined$let$lambda$1.this.$antiAlias$inlined);
                            SVGAImageView$loadAttrs$$inlined$let$lambda$1.this.this$0.setVideoItem(sVGAVideoEntity);
                            SVGAImageView$loadAttrs$$inlined$let$lambda$1 sVGAImageView$loadAttrs$$inlined$let$lambda$1 = SVGAImageView$loadAttrs$$inlined$let$lambda$1.this;
                            if (sVGAImageView$loadAttrs$$inlined$let$lambda$1.$autoPlay$inlined) {
                                sVGAImageView$loadAttrs$$inlined$let$lambda$1.this$0.startAnimation();
                            }
                        }
                    });
                }
            }

            @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        };
        F = o.F(this.$it, "http://", false, 2, null);
        if (!F) {
            F2 = o.F(this.$it, "https://", false, 2, null);
            if (!F2) {
                this.$parser.j(this.$it, parseCompletion);
                return;
            }
        }
        this.$parser.k(new URL(this.$it), parseCompletion);
    }
}
