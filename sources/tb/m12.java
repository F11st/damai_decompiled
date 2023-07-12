package tb;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.taobao.phenix.cache.memory.ReleasableReferenceListener;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class m12 extends tq1 {
    private ReleasableReferenceListener a;
    private WeakReference<Drawable.Callback> b;
    private boolean c;

    public m12(Resources resources, Bitmap bitmap, Rect rect, String str, String str2, int i, int i2) {
        super(resources, bitmap, rect, str, str2, i, i2);
    }

    public synchronized void a() {
        ReleasableReferenceListener releasableReferenceListener = this.a;
        if (releasableReferenceListener != null) {
            releasableReferenceListener.onReferenceDowngrade2Passable(this);
        }
    }

    public void b() {
        setCallback(null);
        this.c = true;
        synchronized (this) {
            ReleasableReferenceListener releasableReferenceListener = this.a;
            if (releasableReferenceListener != null) {
                releasableReferenceListener.onReferenceReleased(this);
            }
        }
    }

    public synchronized void c(ReleasableReferenceListener releasableReferenceListener) {
        this.a = releasableReferenceListener;
    }

    @Override // tb.tq1
    public NinePatchDrawable convert2NinePatchDrawable() {
        NinePatchDrawable convert2NinePatchDrawable = super.convert2NinePatchDrawable();
        synchronized (this) {
            if (convert2NinePatchDrawable != null) {
                ReleasableReferenceListener releasableReferenceListener = this.a;
                if (releasableReferenceListener != null) {
                    releasableReferenceListener.onReferenceDowngrade2Passable(this);
                }
            }
        }
        return convert2NinePatchDrawable;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.c) {
            super.draw(canvas);
            Drawable.Callback callback = getCallback();
            Drawable.Callback callback2 = null;
            WeakReference<Drawable.Callback> weakReference = this.b;
            if (weakReference == null || (callback2 = weakReference.get()) != callback) {
                synchronized (this) {
                    if (callback2 != null) {
                        ReleasableReferenceListener releasableReferenceListener = this.a;
                        if (releasableReferenceListener != null) {
                            releasableReferenceListener.onReferenceDowngrade2Passable(this);
                        }
                    }
                }
                this.b = new WeakReference<>(callback);
                return;
            }
            return;
        }
        throw new RuntimeException("ReleasableBitmapDrawable has been released before drawing!");
    }
}
