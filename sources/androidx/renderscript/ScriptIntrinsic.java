package androidx.renderscript;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class ScriptIntrinsic extends Script {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ScriptIntrinsic(long j, RenderScript renderScript) {
        super(j, renderScript);
        if (j == 0) {
            throw new RSRuntimeException("Loading of ScriptIntrinsic failed.");
        }
    }
}
