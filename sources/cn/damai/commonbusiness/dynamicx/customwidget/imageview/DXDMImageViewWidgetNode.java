package cn.damai.commonbusiness.dynamicx.customwidget.imageview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import cn.damai.uikit.view.RoundImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXGlobalCenter;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.IDXWebImageInterface;
import java.lang.ref.WeakReference;
import tb.a90;
import tb.du;
import tb.y00;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class DXDMImageViewWidgetNode extends DXWidgetNode {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_DMIMAGEVIEW = 6122288056951898906L;
    public static final long DX_DMIMAGEVIEW_DEFAULTIMAGENAME = 7673813157303070297L;
    public static final String HEIGHT_LIMIT = "heightLimit";
    public static final String TAG = "DXDMImageViewWidgetNode";
    public static final String WIDTH_LIMIT = "widthLimit";
    static LruCache<String, Double> i = new LruCache<>(1024);
    private String a;
    private String b;
    private int c;
    private Drawable d;
    private String f;
    private boolean g;
    private double e = -1.0d;
    private boolean h = true;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface ImageLoadListener {
        boolean onHappen(C0662d c0662d);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.dynamicx.customwidget.imageview.DXDMImageViewWidgetNode$a */
    /* loaded from: classes4.dex */
    public class C0659a implements ImageLoadListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C0659a() {
        }

        @Override // cn.damai.commonbusiness.dynamicx.customwidget.imageview.DXDMImageViewWidgetNode.ImageLoadListener
        public boolean onHappen(C0662d c0662d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1506825874")) {
                return ((Boolean) ipChange.ipc$dispatch("-1506825874", new Object[]{this, c0662d})).booleanValue();
            }
            throw null;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.dynamicx.customwidget.imageview.DXDMImageViewWidgetNode$b */
    /* loaded from: classes4.dex */
    public static class C0660b implements IDXBuilderWidgetNode {
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(@Nullable Object obj) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-743664298") ? (DXWidgetNode) ipChange.ipc$dispatch("-743664298", new Object[]{this, obj}) : new DXDMImageViewWidgetNode();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.dynamicx.customwidget.imageview.DXDMImageViewWidgetNode$c */
    /* loaded from: classes14.dex */
    public static class C0661c {
        private static transient /* synthetic */ IpChange $ipChange;
        public int[] a;
        public String b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;

        public boolean i() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-523907040") ? ((Boolean) ipChange.ipc$dispatch("-523907040", new Object[]{this})).booleanValue() : this.j;
        }

        public boolean j() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1619102648") ? ((Boolean) ipChange.ipc$dispatch("1619102648", new Object[]{this})).booleanValue() : this.f;
        }

        public boolean k() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2116753979") ? ((Boolean) ipChange.ipc$dispatch("-2116753979", new Object[]{this})).booleanValue() : this.i;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.dynamicx.customwidget.imageview.DXDMImageViewWidgetNode$d */
    /* loaded from: classes14.dex */
    public static class C0662d {
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.dynamicx.customwidget.imageview.DXDMImageViewWidgetNode$e */
    /* loaded from: classes14.dex */
    public static class AsyncTaskC0663e extends AsyncTask<Void, Void, Drawable> {
        private static transient /* synthetic */ IpChange $ipChange;
        private String a;
        private WeakReference<ImageView> b;
        private Context c;

        public AsyncTaskC0663e(ImageView imageView, String str) {
            this.b = new WeakReference<>(imageView);
            this.a = str;
            this.c = imageView.getContext().getApplicationContext();
        }

        private int b(Context context, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1286047361")) {
                return ((Integer) ipChange.ipc$dispatch("-1286047361", new Object[]{this, context, str})).intValue();
            }
            if (context == null || TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
            } catch (Exception e) {
                Log.e(DXDMImageViewWidgetNode.TAG, "getDrawableId exception", e);
                return 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Drawable doInBackground(Void... voidArr) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1952050475")) {
                return (Drawable) ipChange.ipc$dispatch("-1952050475", new Object[]{this, voidArr});
            }
            int b = b(this.c, this.a);
            if (b == 0) {
                return null;
            }
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    drawable = this.c.getDrawable(b);
                } else {
                    drawable = this.c.getResources().getDrawable(b);
                }
                return drawable;
            } catch (Exception e) {
                Log.e(DXDMImageViewWidgetNode.TAG, "Get layout parser exception", e);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onPostExecute(Drawable drawable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-179970173")) {
                ipChange.ipc$dispatch("-179970173", new Object[]{this, drawable});
                return;
            }
            ImageView imageView = this.b.get();
            if (imageView != null && this.a.equals((String) imageView.getTag(a90.TAG_CURRENT_IMAGE_NAME))) {
                imageView.setImageDrawable(drawable);
                imageView.setTag(a90.TAG_IMAGE_NAME, this.a);
            }
        }
    }

    public DXDMImageViewWidgetNode() {
        setCornerRadius(-1);
        setCornerRadiusLeftBottom(-1);
        setCornerRadiusRightBottom(-1);
        setCornerRadiusRightTop(-1);
        setCornerRadiusLeftTop(-1);
    }

    protected void a(ImageView imageView, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-424156972")) {
            ipChange.ipc$dispatch("-424156972", new Object[]{this, imageView, Integer.valueOf(i2)});
        } else if (i2 == 0) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else if (i2 == 1) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } else if (i2 != 2) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    protected void b(ImageView imageView, Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-818060052")) {
            ipChange.ipc$dispatch("-818060052", new Object[]{this, imageView, drawable});
        } else {
            imageView.setImageDrawable(drawable);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-914969139") ? (DXWidgetNode) ipChange.ipc$dispatch("-914969139", new Object[]{this, obj}) : new DXDMImageViewWidgetNode();
    }

    protected void c(ImageView imageView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1234647891")) {
            ipChange.ipc$dispatch("-1234647891", new Object[]{this, imageView, str});
            return;
        }
        imageView.setTag(a90.TAG_CURRENT_IMAGE_NAME, str);
        if (str == null) {
            imageView.setImageDrawable(null);
            imageView.setTag(a90.TAG_IMAGE_NAME, null);
        } else if (str.equals((String) imageView.getTag(a90.TAG_IMAGE_NAME))) {
        } else {
            y00.q(new AsyncTaskC0663e(imageView, str), new Void[0]);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1820247692")) {
            return ((Integer) ipChange.ipc$dispatch("-1820247692", new Object[]{this, Long.valueOf(j)})).intValue();
        }
        if (-2989625047271068027L == j) {
            return 1;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1515520327")) {
            ipChange.ipc$dispatch("1515520327", new Object[]{this, dXWidgetNode, Boolean.valueOf(z)});
            return;
        }
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof DXDMImageViewWidgetNode) {
            DXDMImageViewWidgetNode dXDMImageViewWidgetNode = (DXDMImageViewWidgetNode) dXWidgetNode;
            this.e = dXDMImageViewWidgetNode.e;
            this.f = dXDMImageViewWidgetNode.f;
            this.b = dXDMImageViewWidgetNode.b;
            this.c = dXDMImageViewWidgetNode.c;
            this.d = dXDMImageViewWidgetNode.d;
            this.g = dXDMImageViewWidgetNode.g;
            this.h = dXDMImageViewWidgetNode.h;
            this.a = dXDMImageViewWidgetNode.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1850619584")) {
            return (View) ipChange.ipc$dispatch("1850619584", new Object[]{this, context});
        }
        IDXWebImageInterface e = DXGlobalCenter.e();
        if (e == null) {
            return new RoundImageView(context);
        }
        return e.buildView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i2, int i3) {
        int i4;
        int max;
        int i5;
        IpChange ipChange = $ipChange;
        int i6 = 0;
        if (AndroidInstantRuntime.support(ipChange, "-2117468607")) {
            ipChange.ipc$dispatch("-2117468607", new Object[]{this, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        int a = DXWidgetNode.DXMeasureSpec.a(i2);
        int a2 = DXWidgetNode.DXMeasureSpec.a(i3);
        boolean z = a != 1073741824;
        boolean z2 = a2 != 1073741824;
        if (!z && !z2) {
            i5 = DXWidgetNode.DXMeasureSpec.b(i2);
            max = DXWidgetNode.DXMeasureSpec.b(i3);
        } else {
            double d = this.e;
            if (d <= 0.0d) {
                if (!TextUtils.isEmpty(this.b)) {
                    Double d2 = i.get(this.b);
                    if (d2 != null) {
                        d = d2.doubleValue();
                    }
                } else {
                    Drawable drawable = this.d;
                    if (drawable != null) {
                        int intrinsicWidth = drawable.getIntrinsicWidth();
                        int intrinsicHeight = this.d.getIntrinsicHeight();
                        if (intrinsicHeight > 0) {
                            d = intrinsicWidth / intrinsicHeight;
                        }
                    }
                }
            }
            if (!z || z2) {
                if (!z && z2) {
                    int size = View.MeasureSpec.getSize(i2);
                    if (d > 0.0d) {
                        i6 = size;
                        i4 = (int) (size / d);
                    } else {
                        i6 = size;
                    }
                }
                i4 = 0;
            } else {
                i4 = View.MeasureSpec.getSize(i3);
                if (d > 0.0d) {
                    i6 = (int) (i4 * d);
                }
            }
            int max2 = Math.max(i6, getSuggestedMinimumWidth());
            max = Math.max(i4, getSuggestedMinimumHeight());
            i5 = max2;
        }
        setMeasuredDimension(DXWidgetNode.resolveSize(i5, i2), DXWidgetNode.resolveSize(max, i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-777640134")) {
            ipChange.ipc$dispatch("-777640134", new Object[]{this, context, view});
        } else if (view == null || !(view instanceof RoundImageView)) {
        } else {
            RoundImageView roundImageView = (RoundImageView) view;
            C0661c c0661c = new C0661c();
            a(roundImageView, this.c);
            if (!TextUtils.isEmpty(this.b)) {
                c0661c.h = true;
                if (getMeasuredHeight() == 0 || getMeasuredWidth() == 0) {
                    new C0659a();
                }
            } else {
                Drawable drawable = this.d;
                if (drawable != null) {
                    b(roundImageView, drawable);
                } else if (!TextUtils.isEmpty(this.f)) {
                    c(roundImageView, this.f);
                } else {
                    roundImageView.setImageDrawable(null);
                    c0661c.h = true;
                }
            }
            if (!TextUtils.isEmpty(this.a)) {
                c0661c.i = true;
                c0661c.b = this.a;
            }
            if (isNeedSetBackground()) {
                c0661c.a = getCornerRadius() > 0 ? new int[]{getCornerRadius(), getCornerRadius(), getCornerRadius(), getCornerRadius()} : new int[]{getCornerRadiusLeftTop(), getCornerRadiusRightTop(), getCornerRadiusRightBottom(), getCornerRadiusLeftBottom()};
                c0661c.f = true;
            }
            if (isNeedSetBackground()) {
                getBorderColor();
                getBorderWidth();
                c0661c.e = true;
                c0661c.d = true;
            }
            if (getLayoutWidth() == -2 && getLayoutHeight() != -2) {
                c0661c.g = true;
            } else if (getLayoutWidth() != -2 && getLayoutHeight() == -2) {
                c0661c.g = true;
            }
            c0661c.c = this.g;
            if (getLayoutWidth() == getLayoutHeight() && getLayoutWidth() / 2 <= getCornerRadius()) {
                c0661c.j = true;
            }
            DMDXWebImageInterface dMDXWebImageInterface = (DMDXWebImageInterface) DXGlobalCenter.e();
            if (dMDXWebImageInterface == null) {
                return;
            }
            dMDXWebImageInterface.setImageWithPlaceHolder(roundImageView, this.b, c0661c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1986503740")) {
            ipChange.ipc$dispatch("1986503740", new Object[]{this, Long.valueOf(j), Double.valueOf(d)});
        } else if (7594222789952419722L == j) {
            this.e = d;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-613350481")) {
            ipChange.ipc$dispatch("-613350481", new Object[]{this, Long.valueOf(j), Integer.valueOf(i2)});
        } else if (1015096712691932083L == j) {
            this.c = i2;
        } else if (1166125168016292427L == j) {
            this.g = i2 == 1;
        } else if (-2989625047271068027L == j) {
            this.h = i2 == 1;
        } else {
            super.onSetIntAttribute(j, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetObjAttribute(long j, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-3631448")) {
            ipChange.ipc$dispatch("-3631448", new Object[]{this, Long.valueOf(j), obj});
        } else if (18039699017736L == j && (obj instanceof Drawable)) {
            this.d = (Drawable) obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-308267700")) {
            ipChange.ipc$dispatch("-308267700", new Object[]{this, Long.valueOf(j), str});
        } else if (du.DXDMCOLORFRAMELAYOUT_IMAGEURL == j) {
            this.b = str;
        } else if (8842287408427345805L == j) {
            this.f = str;
        } else if (j == DX_DMIMAGEVIEW_DEFAULTIMAGENAME) {
            this.a = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void setBackground(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1148727166")) {
            ipChange.ipc$dispatch("-1148727166", new Object[]{this, view});
        } else if (isNeedSetBackground()) {
            view.setBackgroundColor(getBackGroundColor());
        }
    }
}
