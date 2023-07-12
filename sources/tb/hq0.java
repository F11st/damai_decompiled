package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@RequiresApi(api = 17)
/* loaded from: classes6.dex */
public final class hq0 {
    @Nullable
    private RenderScript a;
    @Nullable
    private ScriptIntrinsicBlur b;
    @Nullable
    private Allocation c;
    @Nullable
    private Allocation d;

    public final void a(@Nullable Bitmap bitmap, @Nullable Bitmap bitmap2) {
        Allocation allocation = this.c;
        if (allocation != null) {
            allocation.copyFrom(bitmap);
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.b;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.setInput(this.c);
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur2 = this.b;
        if (scriptIntrinsicBlur2 != null) {
            scriptIntrinsicBlur2.forEach(this.d);
        }
        Allocation allocation2 = this.d;
        if (allocation2 == null) {
            return;
        }
        allocation2.copyTo(bitmap2);
    }

    public final boolean b(@Nullable Context context, @Nullable Bitmap bitmap, float f) {
        if (this.a == null) {
            try {
                RenderScript create = RenderScript.create(context);
                this.a = create;
                this.b = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            } catch (RSRuntimeException unused) {
                c();
                return false;
            }
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.b;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.setRadius(f);
        }
        Allocation createFromBitmap = Allocation.createFromBitmap(this.a, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        this.c = createFromBitmap;
        if (createFromBitmap != null) {
            this.d = Allocation.createTyped(this.a, createFromBitmap.getType());
        }
        return true;
    }

    public final void c() {
        Allocation allocation = this.c;
        if (allocation != null) {
            allocation.destroy();
        }
        this.c = null;
        Allocation allocation2 = this.d;
        if (allocation2 != null) {
            allocation2.destroy();
        }
        this.d = null;
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.b;
        if (scriptIntrinsicBlur != null) {
            scriptIntrinsicBlur.destroy();
        }
        this.b = null;
        RenderScript renderScript = this.a;
        if (renderScript != null) {
            renderScript.destroy();
        }
        this.a = null;
    }
}
