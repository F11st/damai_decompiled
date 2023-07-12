package io.flutter.plugins.share;

import com.youku.passport.family.Relation;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
class MethodCallHandler implements MethodChannel.MethodCallHandler {
    private Share share;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodCallHandler(Share share) {
        this.share = share;
    }

    private void expectMapArguments(MethodCall methodCall) throws IllegalArgumentException {
        if (!(methodCall.arguments instanceof Map)) {
            throw new IllegalArgumentException("Map argument expected");
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        if (!str.equals("shareFiles")) {
            if (!str.equals("share")) {
                result.notImplemented();
                return;
            }
            expectMapArguments(methodCall);
            this.share.share((String) methodCall.argument("text"), (String) methodCall.argument(Relation.RelationType.SUBJECT));
            result.success(null);
            return;
        }
        expectMapArguments(methodCall);
        try {
            this.share.shareFiles((List) methodCall.argument("paths"), (List) methodCall.argument("mimeTypes"), (String) methodCall.argument("text"), (String) methodCall.argument(Relation.RelationType.SUBJECT));
            result.success(null);
        } catch (IOException e) {
            result.error(e.getMessage(), null, null);
        }
    }
}
