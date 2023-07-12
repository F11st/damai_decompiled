package tb;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import com.alibaba.pictures.moimage.MoImageLoadException;
import com.alibaba.pictures.moimage.MoImageView;
import com.alibaba.pictures.moimage.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.animate.AnimatedImageDrawable;
import com.taobao.phenix.intf.event.IPhenixListener;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.xr1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class yr1<T extends xr1> implements IPhenixListener<T> {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private ObjectAnimator a;
    private WeakReference<ImageView> b;
    private String c;
    @Nullable
    private final ImageView d;
    @Nullable
    private final og1 e;
    @Nullable
    private final MoImageView.SimpleRequestListener f;
    @Nullable
    private final String g;

    public yr1(@Nullable ImageView imageView, @Nullable og1 og1Var, @Nullable MoImageView.SimpleRequestListener simpleRequestListener, @Nullable String str) {
        this.d = imageView;
        this.e = og1Var;
        this.f = simpleRequestListener;
        this.g = str;
        this.b = new WeakReference<>(imageView);
        this.c = og1Var != null ? og1Var.l() : null;
    }

    public boolean a(@NotNull ui2 ui2Var, boolean z) {
        ImageView imageView;
        og1 og1Var;
        og1 og1Var2;
        Bitmap bitmap;
        og1 og1Var3;
        IpChange ipChange = $ipChange;
        boolean z2 = false;
        if (AndroidInstantRuntime.support(ipChange, "-95022333")) {
            return ((Boolean) ipChange.ipc$dispatch("-95022333", new Object[]{this, ui2Var, Boolean.valueOf(z)})).booleanValue();
        }
        b41.i(ui2Var, "event");
        lg1 lg1Var = lg1.INSTANCE;
        StringBuilder sb = new StringBuilder();
        sb.append("PhenixImageViewTarget:applySuccessEvent: ");
        sb.append(this.g);
        sb.append(" ,viewState-w-h=");
        og1 og1Var4 = this.e;
        sb.append(og1Var4 != null ? Integer.valueOf(og1Var4.d()) : null);
        sb.append('-');
        og1 og1Var5 = this.e;
        sb.append(og1Var5 != null ? Integer.valueOf(og1Var5.c()) : null);
        sb.append(",view-w-h=");
        ImageView imageView2 = this.d;
        sb.append(imageView2 != null ? Integer.valueOf(imageView2.getWidth()) : null);
        sb.append('-');
        ImageView imageView3 = this.d;
        sb.append(imageView3 != null ? Integer.valueOf(imageView3.getHeight()) : null);
        lg1Var.a(sb.toString());
        WeakReference<ImageView> weakReference = this.b;
        if (weakReference != null && (imageView = weakReference.get()) != null) {
            og1 og1Var6 = this.e;
            if (og1Var6 != null && og1Var6.p() != 0) {
                imageView.setBackground(null);
            }
            Object tag = imageView.getTag(R$id.moimage_target_uri);
            if (!(tag instanceof String)) {
                tag = null;
            }
            String str = (String) tag;
            String str2 = ui2Var.b() + this.c;
            if (str2 != null && str != null && (!b41.d(str2, str))) {
                lg1Var.e("PhenixImageViewTarget:applySuccessEvent:callback url not match target url, callbackUrlFeature=" + str2 + ", currentViewTargetPathFeature=" + str);
                return true;
            }
            BitmapDrawable f = ui2Var.f();
            if (f != null && f.getIntrinsicHeight() == 1 && f.getIntrinsicWidth() == 1 && (og1Var3 = this.e) != null && og1Var3.o() && this.e.n() != 0) {
                ImageView imageView4 = this.d;
                if (imageView4 != null) {
                    imageView4.setImageResource(this.e.n());
                }
                return true;
            }
            MoImageView.SimpleRequestListener simpleRequestListener = this.f;
            if (simpleRequestListener != null) {
                if (f == null || (bitmap = f.getBitmap()) == null) {
                    bitmap = f;
                }
                if (simpleRequestListener.onResourceReady(bitmap, this.g, f != null ? f.getIntrinsicWidth() : -1, f != null ? f.getIntrinsicHeight() : -1)) {
                    lg1Var.e("PhenixImageViewTarget:applySuccessEvent:cusRequestListener return true,finish progress " + this.g);
                    return true;
                }
            }
            if (f != null) {
                og1 og1Var7 = this.e;
                if (b41.d(og1Var7 != null ? og1Var7.f() : null, Boolean.TRUE)) {
                    AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) (!(f instanceof AnimatedImageDrawable) ? null : f);
                    if (animatedImageDrawable != null) {
                        animatedImageDrawable.stop();
                    }
                }
                if ((mg1.INSTANCE.b() || (og1Var2 = this.e) == null || og1Var2.g() <= 0) ? true : true) {
                    imageView.setImageDrawable(f);
                } else {
                    ObjectAnimator objectAnimator = this.a;
                    if (objectAnimator == null) {
                        ObjectAnimator ofInt = ObjectAnimator.ofInt(imageView, "alpha", 0, 255);
                        if (ofInt != null) {
                            ofInt.setInterpolator(new AccelerateInterpolator());
                            ofInt.setDuration(this.e != null ? og1Var.g() : 300L);
                            wt2 wt2Var = wt2.INSTANCE;
                            r2 = ofInt;
                        }
                        this.a = r2;
                        if (r2 != null) {
                            r2.start();
                        }
                    } else if (objectAnimator != null) {
                        r2 = objectAnimator.isRunning() ^ true ? objectAnimator : null;
                        if (r2 != null) {
                            r2.start();
                        }
                    }
                    imageView.setImageDrawable(f);
                }
                return true;
            }
            lg1Var.f("PhenixImageViewTarget", "resultDrawable=null,callbackUrlFeature=" + str2 + ", target=" + this.g);
        }
        return false;
    }

    @Override // com.taobao.phenix.intf.event.IPhenixListener
    public boolean onHappen(@Nullable T t) {
        ImageView imageView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2081556223")) {
            return ((Boolean) ipChange.ipc$dispatch("-2081556223", new Object[]{this, t})).booleanValue();
        }
        WeakReference<ImageView> weakReference = this.b;
        if (weakReference != null && (imageView = weakReference.get()) != null) {
            if (t instanceof nh0) {
                lg1 lg1Var = lg1.INSTANCE;
                lg1Var.a("PhenixImageViewTarget:onHappen-FailPhenixEvent: " + this.g);
                MoImageLoadException moImageLoadException = new MoImageLoadException("phenix load url fail");
                moImageLoadException.setTag(t);
                MoImageView.SimpleRequestListener simpleRequestListener = this.f;
                if (simpleRequestListener == null || !simpleRequestListener.onLoadFailed(moImageLoadException, this.g)) {
                    og1 og1Var = this.e;
                    if (og1Var != null && og1Var.p() != 0) {
                        imageView.setBackground(null);
                    }
                    og1 og1Var2 = this.e;
                    if (og1Var2 != null && og1Var2.n() != 0) {
                        if (imageView instanceof MoImageView) {
                            ((MoImageView) imageView).setLocalDrawable(Integer.valueOf(this.e.n()));
                        } else {
                            imageView.setImageResource(this.e.n());
                        }
                    }
                    return true;
                }
                return true;
            } else if (t instanceof ce1) {
                lg1.INSTANCE.a("PhenixImageViewTarget:onHappen-cacheMiss");
                return false;
            } else if (t instanceof ui2) {
                ui2 ui2Var = (ui2) t;
                return a(ui2Var, ui2Var.h());
            }
        }
        return false;
    }
}
