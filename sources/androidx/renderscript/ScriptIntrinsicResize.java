package androidx.renderscript;

import android.os.Build;
import androidx.renderscript.Script;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ScriptIntrinsicResize extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 21;
    private Allocation mInput;

    protected ScriptIntrinsicResize(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public static ScriptIntrinsicResize create(RenderScript renderScript) {
        boolean z = renderScript.isUseNative() && Build.VERSION.SDK_INT < 21;
        ScriptIntrinsicResize scriptIntrinsicResize = new ScriptIntrinsicResize(renderScript.nScriptIntrinsicCreate(12, 0L, z), renderScript);
        scriptIntrinsicResize.setIncSupp(z);
        return scriptIntrinsicResize;
    }

    public void forEach_bicubic(Allocation allocation) {
        if (allocation != this.mInput) {
            forEach_bicubic(allocation, null);
            return;
        }
        throw new RSIllegalArgumentException("Output cannot be same as Input.");
    }

    public Script.FieldID getFieldID_Input() {
        return createFieldID(0, null);
    }

    public Script.KernelID getKernelID_bicubic() {
        return createKernelID(0, 2, null, null);
    }

    public void setInput(Allocation allocation) {
        Element element = allocation.getElement();
        if (!element.isCompatible(Element.U8(this.mRS)) && !element.isCompatible(Element.U8_2(this.mRS)) && !element.isCompatible(Element.U8_3(this.mRS)) && !element.isCompatible(Element.U8_4(this.mRS)) && !element.isCompatible(Element.F32(this.mRS)) && !element.isCompatible(Element.F32_2(this.mRS)) && !element.isCompatible(Element.F32_3(this.mRS)) && !element.isCompatible(Element.F32_4(this.mRS))) {
            throw new RSIllegalArgumentException("Unsuported element type.");
        }
        this.mInput = allocation;
        setVar(0, allocation);
    }

    public void forEach_bicubic(Allocation allocation, Script.LaunchOptions launchOptions) {
        forEach(0, null, allocation, null, launchOptions);
    }
}
