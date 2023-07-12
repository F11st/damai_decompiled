package com.opensource.svgaplayer;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.uc.webview.export.media.MessageID;
import kotlin.Metadata;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¨\u0006\u000b"}, d2 = {"Lcom/opensource/svgaplayer/SVGACallback;", "", "Ltb/wt2;", MessageID.onPause, "onFinished", "onRepeat", "", TypedValues.Attributes.S_FRAME, "", "percentage", "onStep", "library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes10.dex */
public interface SVGACallback {
    void onFinished();

    void onPause();

    void onRepeat();

    void onStep(int i, double d);
}
