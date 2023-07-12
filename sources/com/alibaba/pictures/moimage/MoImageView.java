package com.alibaba.pictures.moimage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import cn.damai.common.DamaiConstants;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.abilitykit.AKBaseAbility;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.ref.WeakReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.text.C8604o;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.jg1;
import tb.k50;
import tb.kg1;
import tb.lg1;
import tb.mg1;
import tb.ng1;
import tb.og1;
import tb.q11;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u0000 Æ\u00012\u00020\u0001:\nÇ\u0001È\u0001É\u0001Ê\u0001Ë\u0001B0\b\u0007\u0012\n\u0010À\u0001\u001a\u0005\u0018\u00010¿\u0001\u0012\f\b\u0002\u0010Â\u0001\u001a\u0005\u0018\u00010Á\u0001\u0012\t\b\u0002\u0010Ã\u0001\u001a\u00020\r¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0017\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0014\u001a\u00020\u0002J(\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0014J0\u0010 \u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rH\u0014J\u0012\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!H\u0014J\b\u0010$\u001a\u00020\u0002H\u0014J\b\u0010%\u001a\u00020\u0002H\u0015J\u0012\u0010(\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010&H\u0014J\u0010\u0010*\u001a\u00020\u001a2\b\u0010)\u001a\u0004\u0018\u00010\u0007J\u000e\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u001aJ\u000e\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u001aJ\u0016\u0010.\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u001aJ\u000e\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u000200J\u0006\u00103\u001a\u00020\u001aJ\u0010\u00106\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u000104J\u0006\u00107\u001a\u00020\u0002J\u0016\u0010:\u001a\u00020\u00022\u0006\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020\rJ\u0010\u0010<\u001a\u00020\u00022\b\u0010;\u001a\u0004\u0018\u00010\u0007J\u0016\u0010?\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\rJ\u001a\u0010D\u001a\u00020\u00022\b\u0010A\u001a\u0004\u0018\u00010@2\b\u0010C\u001a\u0004\u0018\u00010BJ\u0010\u0010D\u001a\u00020\u00022\b\u0010A\u001a\u0004\u0018\u00010@J\u001a\u0010E\u001a\u00020\u00022\b\u0010A\u001a\u0004\u0018\u00010@2\b\u0010C\u001a\u0004\u0018\u00010BJ\u0010\u0010E\u001a\u00020\u00022\b\u0010F\u001a\u0004\u0018\u00010@J\u001a\u0010J\u001a\u00020\u00022\b\u0010H\u001a\u0004\u0018\u00010G2\b\b\u0002\u0010I\u001a\u00020\rJ\b\u0010K\u001a\u00020\u0002H\u0014J\u0006\u0010L\u001a\u00020\u0002R\u0016\u0010M\u001a\u00020\u001a8\u0004@\u0004X\u0085\u000e¢\u0006\u0006\n\u0004\bM\u0010NR(\u0010)\u001a\u0004\u0018\u00010\u00072\b\u0010O\u001a\u0004\u0018\u00010\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b)\u0010P\u001a\u0004\bQ\u0010RR(\u0010S\u001a\u0004\u0018\u00010&2\b\u0010O\u001a\u0004\u0018\u00010&8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR$\u0010W\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020\u001a8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bW\u0010N\u001a\u0004\bX\u0010YR$\u0010Z\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R$\u0010`\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010[\u001a\u0004\ba\u0010]\"\u0004\bb\u0010_R\u0018\u0010c\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010[R$\u0010e\u001a\u0004\u0018\u00010d8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010k\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010N\u001a\u0004\bk\u0010Y\"\u0004\bl\u0010mR\u0018\u0010n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010q\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0018\u0010t\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR$\u0010v\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R$\u0010|\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R'\u0010\u0082\u0001\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0005\b\u0082\u0001\u0010}\u001a\u0005\b\u0083\u0001\u0010\u007f\"\u0006\b\u0084\u0001\u0010\u0081\u0001R3\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u001a2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u001a8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\b\u0086\u0001\u0010[\u001a\u0005\b\u0087\u0001\u0010]\"\u0005\b\u0088\u0001\u0010_R*\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R*\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R,\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R0\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u00012\n\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R+\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\u000f\u001a\u0005\b¤\u0001\u0010R\"\u0006\b¥\u0001\u0010¦\u0001R\u0017\u0010¨\u0001\u001a\u0004\u0018\u00010\u00078F@\u0006¢\u0006\u0007\u001a\u0005\b§\u0001\u0010RR,\u0010'\u001a\u0004\u0018\u00010&2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010&8F@FX\u0086\u000e¢\u0006\u000f\u001a\u0005\b©\u0001\u0010V\"\u0006\bª\u0001\u0010«\u0001R\u0016\u0010®\u0001\u001a\u00020\u00008F@\u0006¢\u0006\b\u001a\u0006\b¬\u0001\u0010\u00ad\u0001R0\u0010°\u0001\u001a\u0005\u0018\u00010¯\u00012\n\u0010°\u0001\u001a\u0005\u0018\u00010¯\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b±\u0001\u0010²\u0001\"\u0006\b³\u0001\u0010´\u0001R.\u0010µ\u0001\u001a\u0004\u0018\u00010\t2\t\u0010µ\u0001\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R.\u0010º\u0001\u001a\u0004\u0018\u00010B2\t\u0010º\u0001\u001a\u0004\u0018\u00010B8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b»\u0001\u0010¼\u0001\"\u0006\b½\u0001\u0010¾\u0001¨\u0006Ì\u0001"}, d2 = {"Lcom/alibaba/pictures/moimage/MoImageView;", "Landroid/widget/ImageView;", "Ltb/wt2;", "initHolderImage", "toggleSizeDetermined", "Landroid/graphics/Path;", "calculateRadiusPath", "", "url", "Lcom/alibaba/pictures/moimage/MoImageView$ImageViewType;", "judgeImageType", "fixUrl", "removeOnPreDrawListener", "", "resId", "setLocalDrawable", "(Ljava/lang/Integer;)V", "Landroid/graphics/Bitmap;", "bm", "setLocalImageBitmap", "onSizeDetermined", WXComponent.PROP_FS_WRAP_CONTENT, "h", "oldw", "oldh", "onSizeChanged", "", "changed", "left", "top", "right", "bottom", "onLayout", "Landroid/graphics/Canvas;", "canvas", "onDraw", "onDetachedFromWindow", "doSetUrl", "Landroid/net/Uri;", "uri", "doSetUri", "oriUrl", "isNeedUseOriUrl", "useOriginal", "setUseOriginalUrl", "userOriginalSize", "setLoadOriginImage", "skipBitmapProfessor", "Landroid/graphics/RectF;", "rectF", "getActualImageBounds", "hasHierarchy", "Ljava/lang/Exception;", AKBaseAbility.CALLBACK_FAILURE, "setFailure", "reset", "loadImageWidth", "loadImageHeight", "setForcedLoadImageSize", "uriString", "setImageURI", "width", "height", "setFixedWH", "Landroid/graphics/drawable/BitmapDrawable;", "bitmapDrawable", "Lcom/alibaba/pictures/moimage/MoImageView$GScaleType;", "scaleType", "setPlaceholderImage", "setFailureImage", "failureImage", "Landroid/view/View;", "view", "maxTime", "tryAlignWithParentSize", "onAttachedToWindow", "cancel", "mFullUrlFail", "Z", "<set-?>", "Ljava/lang/String;", "getOriUrl", "()Ljava/lang/String;", "mTargeturi", "Landroid/net/Uri;", "getMTargeturi", "()Landroid/net/Uri;", "mUseOriginalUrl", "getMUseOriginalUrl", "()Z", "forceReloadUrl", "Ljava/lang/Boolean;", "getForceReloadUrl", "()Ljava/lang/Boolean;", "setForceReloadUrl", "(Ljava/lang/Boolean;)V", "skipCache", "getSkipCache", "setSkipCache", "sizeChangedFlag", "Lcom/alibaba/pictures/moimage/MoImageView$SimpleRequestListener;", "requestListener", "Lcom/alibaba/pictures/moimage/MoImageView$SimpleRequestListener;", "getRequestListener", "()Lcom/alibaba/pictures/moimage/MoImageView$SimpleRequestListener;", "setRequestListener", "(Lcom/alibaba/pictures/moimage/MoImageView$SimpleRequestListener;)V", "isForcedShowErrorImg", "setForcedShowErrorImg", "(Z)V", "manualImageType", "Lcom/alibaba/pictures/moimage/MoImageView$ImageViewType;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "mOnPreDrawListener", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "Landroid/view/ViewTreeObserver;", "mAtattchThreeObserver", "Landroid/view/ViewTreeObserver;", "mClipPath", "Landroid/graphics/Path;", "getMClipPath", "()Landroid/graphics/Path;", "setMClipPath", "(Landroid/graphics/Path;)V", "maxPossibleViewHeight", "I", "getMaxPossibleViewHeight", "()I", "setMaxPossibleViewHeight", "(I)V", "maxPossibleViewWidth", "getMaxPossibleViewWidth", "setMaxPossibleViewWidth", "value", "radiusClipModel", "getRadiusClipModel", "setRadiusClipModel", "", "cTime", "J", "getCTime", "()J", "setCTime", "(J)V", "Ltb/og1;", "viewState", "Ltb/og1;", "getViewState", "()Ltb/og1;", "setViewState", "(Ltb/og1;)V", "Ltb/kg1;", "remoteUrlImageLoader", "Ltb/kg1;", "getRemoteUrlImageLoader", "()Ltb/kg1;", "setRemoteUrlImageLoader", "(Ltb/kg1;)V", "Ltb/og1$a;", "roundingParams", "getRoundingParams", "()Ltb/og1$a;", "setRoundingParams", "(Ltb/og1$a;)V", "getUrl", "setUrl", "(Ljava/lang/String;)V", "getTargeturl", "targeturl", "getUri", "setUri", "(Landroid/net/Uri;)V", "getHierarchy", "()Lcom/alibaba/pictures/moimage/MoImageView;", "hierarchy", "Landroid/graphics/PointF;", "actualImageFocusPoint", "getActualImageFocusPoint", "()Landroid/graphics/PointF;", "setActualImageFocusPoint", "(Landroid/graphics/PointF;)V", "imageType", "getImageType", "()Lcom/alibaba/pictures/moimage/MoImageView$ImageViewType;", "setImageType", "(Lcom/alibaba/pictures/moimage/MoImageView$ImageViewType;)V", "actualImageScaleType", "getActualImageScaleType", "()Lcom/alibaba/pictures/moimage/MoImageView$GScaleType;", "setActualImageScaleType", "(Lcom/alibaba/pictures/moimage/MoImageView$GScaleType;)V", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "a", "GScaleType", "ImageViewType", "b", "SimpleRequestListener", "moimage_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes7.dex */
public class MoImageView extends ImageView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C3616a Companion = new C3616a(null);
    private static final String TAG = "MoImageView";
    private long cTime;
    @Nullable
    private Boolean forceReloadUrl;
    private boolean isForcedShowErrorImg;
    private ViewTreeObserver mAtattchThreeObserver;
    @Nullable
    private Path mClipPath;
    @JvmField
    protected boolean mFullUrlFail;
    private ViewTreeObserver.OnPreDrawListener mOnPreDrawListener;
    @Nullable
    private Uri mTargeturi;
    private boolean mUseOriginalUrl;
    private ImageViewType manualImageType;
    private int maxPossibleViewHeight;
    private int maxPossibleViewWidth;
    @Nullable
    private String oriUrl;
    @Nullable
    private Boolean radiusClipModel;
    @Nullable
    private kg1 remoteUrlImageLoader;
    @Nullable
    private SimpleRequestListener requestListener;
    private Boolean sizeChangedFlag;
    @Nullable
    private Boolean skipCache;
    @NotNull
    private og1 viewState;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0019\u0010\u0005\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/alibaba/pictures/moimage/MoImageView$GScaleType;", "", "Landroid/widget/ImageView$ScaleType;", "convert2Ori", "", "nativeInt", "I", "getNativeInt", "()I", "<init>", "(Ljava/lang/String;II)V", "MATRIX", "FIT_XY", "FIT_START", "FIT_CENTER", "FIT_END", DamaiConstants.TAB_CENTER, "CENTER_CROP", "CENTER_INSIDE", "FOCUS_CROP", "FIT_WIDTH", "FIT_HEIGHT", "moimage_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes7.dex */
    public enum GScaleType {
        MATRIX(0),
        FIT_XY(1),
        FIT_START(2),
        FIT_CENTER(3),
        FIT_END(4),
        CENTER(5),
        CENTER_CROP(6),
        CENTER_INSIDE(7),
        FOCUS_CROP(8),
        FIT_WIDTH(9),
        FIT_HEIGHT(10);
        
        private final int nativeInt;

        GScaleType(int i) {
            this.nativeInt = i;
        }

        @NotNull
        public final ImageView.ScaleType convert2Ori() {
            switch (this.nativeInt) {
                case 0:
                    return ImageView.ScaleType.MATRIX;
                case 1:
                    return ImageView.ScaleType.FIT_XY;
                case 2:
                    return ImageView.ScaleType.FIT_START;
                case 3:
                    return ImageView.ScaleType.FIT_CENTER;
                case 4:
                    return ImageView.ScaleType.FIT_END;
                case 5:
                    return ImageView.ScaleType.CENTER;
                case 6:
                    return ImageView.ScaleType.CENTER_CROP;
                case 7:
                    return ImageView.ScaleType.CENTER_INSIDE;
                case 8:
                    return ImageView.ScaleType.CENTER_INSIDE;
                case 9:
                    return ImageView.ScaleType.CENTER_INSIDE;
                case 10:
                    return ImageView.ScaleType.CENTER_INSIDE;
                default:
                    return ImageView.ScaleType.CENTER_INSIDE;
            }
        }

        public final int getNativeInt() {
            return this.nativeInt;
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/alibaba/pictures/moimage/MoImageView$ImageViewType;", "", "", "value", "I", "getValue", "()I", "setValue", "(I)V", "<init>", "(Ljava/lang/String;II)V", "DEFAULT", "GIF", "WEBPANI", "moimage_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes7.dex */
    public enum ImageViewType {
        DEFAULT(0),
        GIF(1),
        WEBPANI(2);
        
        private int value;

        ImageViewType(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }

        public final void setValue(int i) {
            this.value = i;
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J,\u0010\f\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&¨\u0006\r"}, d2 = {"Lcom/alibaba/pictures/moimage/MoImageView$SimpleRequestListener;", "", "Ljava/lang/Exception;", "e", "", "oriUri", "", "onLoadFailed", "picResource", "", "resWidth", "resHeight", "onResourceReady", "moimage_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes7.dex */
    public interface SimpleRequestListener {
        boolean onLoadFailed(@Nullable Exception exc, @Nullable String str);

        boolean onResourceReady(@Nullable Object obj, @Nullable String str, int i, int i2);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.moimage.MoImageView$a */
    /* loaded from: classes7.dex */
    public static final class C3616a {
        private C3616a() {
        }

        public /* synthetic */ C3616a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.moimage.MoImageView$b */
    /* loaded from: classes7.dex */
    public static final class ViewTreeObserver$OnPreDrawListenerC3617b implements ViewTreeObserver.OnPreDrawListener {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private WeakReference<MoImageView> a;

        public ViewTreeObserver$OnPreDrawListenerC3617b(@Nullable MoImageView moImageView) {
            this.a = new WeakReference<>(moImageView);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            MoImageView moImageView;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "947976111")) {
                return ((Boolean) ipChange.ipc$dispatch("947976111", new Object[]{this})).booleanValue();
            }
            if (this.a.get() != null && (moImageView = this.a.get()) != null) {
                if (q11.INSTANCE.i(moImageView)) {
                    moImageView.onSizeDetermined();
                } else if (q11.e(moImageView)) {
                    moImageView.setForcedLoadImageSize(q11.d(moImageView), q11.c(moImageView));
                    moImageView.onSizeDetermined();
                } else if (q11.f(moImageView)) {
                    moImageView.onSizeDetermined();
                } else {
                    MoImageView.tryAlignWithParentSize$default(moImageView, moImageView, 0, 2, null);
                    moImageView.onSizeDetermined();
                }
            }
            return true;
        }
    }

    @JvmOverloads
    public MoImageView(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public MoImageView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @JvmOverloads
    public MoImageView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.viewState = new og1().a(context, attributeSet);
        Boolean bool = Boolean.FALSE;
        this.forceReloadUrl = bool;
        this.skipCache = bool;
        this.sizeChangedFlag = bool;
        this.maxPossibleViewHeight = -1;
        this.maxPossibleViewWidth = -1;
        this.radiusClipModel = bool;
    }

    private final Path calculateRadiusPath() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-360898447")) {
            return (Path) ipChange.ipc$dispatch("-360898447", new Object[]{this});
        }
        if (this.viewState.q().g()) {
            Rect rect = new Rect();
            getDrawingRect(rect);
            Path path = new Path();
            path.addRoundRect(rect.left, rect.top, rect.right, rect.bottom, this.viewState.q().d(), Path.Direction.CW);
            return path;
        }
        return null;
    }

    private final String fixUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045618452")) {
            return (String) ipChange.ipc$dispatch("-2045618452", new Object[]{this, str});
        }
        if (str != null) {
            jg1 jg1Var = jg1.INSTANCE;
            if (jg1Var.g(str)) {
                return str;
            }
            if (isNeedUseOriUrl(str)) {
                return jg1Var.a(this.oriUrl);
            }
            if (this.viewState.t()) {
                if (q11.f(this)) {
                    return jg1Var.b(this.oriUrl, Integer.valueOf(getMeasuredWidth()), Integer.valueOf(getMeasuredHeight()), null, null);
                }
                return jg1Var.b(this.oriUrl, Integer.valueOf(this.maxPossibleViewWidth), Integer.valueOf(this.maxPossibleViewHeight), null, null);
            }
            return jg1Var.b(this.oriUrl, Integer.valueOf(this.viewState.j()), Integer.valueOf(this.viewState.i()), null, null);
        }
        return str;
    }

    private final void initHolderImage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1792804025")) {
            ipChange.ipc$dispatch("-1792804025", new Object[]{this});
        } else if (this.viewState.p() != 0) {
            setLocalDrawable(Integer.valueOf(this.viewState.p()));
        }
    }

    private final ImageViewType judgeImageType(String str) {
        boolean p;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1830373008")) {
            return (ImageViewType) ipChange.ipc$dispatch("1830373008", new Object[]{this, str});
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return ImageViewType.DEFAULT;
        }
        ImageViewType imageViewType = this.manualImageType;
        ImageViewType imageViewType2 = ImageViewType.WEBPANI;
        if (imageViewType == imageViewType2) {
            return imageViewType2;
        }
        p = C8604o.p(str, "gif", false, 2, null);
        if (p) {
            return ImageViewType.GIF;
        }
        ImageViewType imageViewType3 = this.manualImageType;
        ImageViewType imageViewType4 = ImageViewType.GIF;
        return imageViewType3 == imageViewType4 ? imageViewType4 : ImageViewType.DEFAULT;
    }

    private final void removeOnPreDrawListener() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-152125650")) {
            ipChange.ipc$dispatch("-152125650", new Object[]{this});
            return;
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (this.mOnPreDrawListener == null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        ViewTreeObserver viewTreeObserver2 = this.mAtattchThreeObserver;
        if (viewTreeObserver2 != null && (!b41.d(viewTreeObserver2, viewTreeObserver))) {
            ViewTreeObserver viewTreeObserver3 = this.mAtattchThreeObserver;
            b41.f(viewTreeObserver3);
            if (viewTreeObserver3.isAlive()) {
                ViewTreeObserver viewTreeObserver4 = this.mAtattchThreeObserver;
                b41.f(viewTreeObserver4);
                viewTreeObserver4.removeOnPreDrawListener(this.mOnPreDrawListener);
                this.mAtattchThreeObserver = null;
            }
        }
        viewTreeObserver.removeOnPreDrawListener(this.mOnPreDrawListener);
    }

    private final void toggleSizeDetermined() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1501704578")) {
            ipChange.ipc$dispatch("-1501704578", new Object[]{this});
            return;
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (this.mOnPreDrawListener == null) {
            this.mOnPreDrawListener = new ViewTreeObserver$OnPreDrawListenerC3617b(this);
        }
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnPreDrawListener(this.mOnPreDrawListener);
        } else {
            onSizeDetermined();
        }
    }

    public static /* synthetic */ void tryAlignWithParentSize$default(MoImageView moImageView, View view, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 10;
            }
            moImageView.tryAlignWithParentSize(view, i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryAlignWithParentSize");
    }

    public final void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2083138442")) {
            ipChange.ipc$dispatch("2083138442", new Object[]{this});
            return;
        }
        kg1 kg1Var = this.remoteUrlImageLoader;
        if (kg1Var != null) {
            kg1Var.c();
        }
    }

    protected void doSetUri(@Nullable Uri uri) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-315693352")) {
            ipChange.ipc$dispatch("-315693352", new Object[]{this, uri});
            return;
        }
        Boolean bool = this.forceReloadUrl;
        Boolean bool2 = Boolean.TRUE;
        if (!b41.d(bool, bool2) && !b41.d(this.sizeChangedFlag, bool2) && !b41.d(this.skipCache, bool2)) {
            z = false;
        }
        lg1 lg1Var = lg1.INSTANCE;
        lg1Var.b("MoImageView", ":setUri【needReload=" + z + ",forceReload= " + this.forceReloadUrl + "&sizeChangedFlag=" + this.sizeChangedFlag + ",needSkipCache=" + this.skipCache + "】:" + uri);
        if (uri != null) {
            Uri uri2 = this.mTargeturi;
            if (uri2 != null && uri.compareTo(uri2) == 0 && !z) {
                lg1Var.f("MoImageView", "设置的Uri和上次的uri重复！" + uri);
                return;
            }
            this.mTargeturi = uri;
            kg1 kg1Var = this.remoteUrlImageLoader;
            if (kg1Var == null) {
                this.remoteUrlImageLoader = kg1.Companion.a(getContext());
            } else if (kg1Var != null) {
                kg1Var.o();
            }
            kg1 kg1Var2 = this.remoteUrlImageLoader;
            if (kg1Var2 != null) {
                kg1Var2.a(getRequestListener()).b(this.viewState).p(this.skipCache).i(this.mTargeturi).g(this);
            }
            this.sizeChangedFlag = Boolean.FALSE;
            return;
        }
        lg1Var.f("MoImageView", "设置的Uri为null！");
        reset();
        setImageDrawable(null);
    }

    @Deprecated(message = "兼容原有的SimpleDrawable中的,新版本不建议使用")
    protected void doSetUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "774869868")) {
            ipChange.ipc$dispatch("774869868", new Object[]{this});
        } else {
            setUrl(this.oriUrl);
        }
    }

    public final void getActualImageBounds(@NotNull RectF rectF) {
        ImageView.ScaleType scaleType;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1146750153")) {
            ipChange.ipc$dispatch("1146750153", new Object[]{this, rectF});
            return;
        }
        b41.i(rectF, "rectF");
        float height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        float width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        Drawable drawable = getDrawable();
        if (drawable == null || (scaleType = getScaleType()) == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        b41.h(bounds, "drawable.bounds");
        int width2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(bounds);
        int height2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(bounds);
        if (width2 == 0 || height2 == 0) {
            return;
        }
        float f = height2;
        float f2 = height / f;
        float f3 = width2;
        float f4 = width / f3;
        int i = ng1.$EnumSwitchMapping$0[scaleType.ordinal()];
        if (i == 1) {
            float min = Math.min(f2, f4);
            rectF.set(new RectF(0.0f, 0.0f, f3 * min, f * min));
        } else if (i == 2) {
            rectF.set(new RectF(0.0f, 0.0f, width, height));
        } else if (i == 3) {
            if (f2 <= f4) {
                f2 = f4;
            }
            rectF.set(new RectF(0.0f, 0.0f, f3 * f2, f * f2));
        } else if (i != 4) {
            if (f2 > f4) {
                f2 = f4;
            }
            rectF.set(new RectF(0.0f, 0.0f, f3 * f2, f * f2));
        } else {
            float f5 = 1;
            if (f2 < f5 && f4 < f5) {
                rectF.set(bounds);
                return;
            }
            if (f2 > f4) {
                f2 = f4;
            }
            rectF.set(new RectF(0.0f, 0.0f, f3 * f2, f * f2));
        }
    }

    @Nullable
    public final PointF getActualImageFocusPoint() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-439363796") ? (PointF) ipChange.ipc$dispatch("-439363796", new Object[]{this}) : this.viewState.b();
    }

    @Nullable
    public final GScaleType getActualImageScaleType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1104255496") ? (GScaleType) ipChange.ipc$dispatch("-1104255496", new Object[]{this}) : this.viewState.m();
    }

    public final long getCTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "939096606") ? ((Long) ipChange.ipc$dispatch("939096606", new Object[]{this})).longValue() : this.cTime;
    }

    @Nullable
    public final Boolean getForceReloadUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1394951550") ? (Boolean) ipChange.ipc$dispatch("-1394951550", new Object[]{this}) : this.forceReloadUrl;
    }

    @NotNull
    public final MoImageView getHierarchy() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1481984847") ? (MoImageView) ipChange.ipc$dispatch("-1481984847", new Object[]{this}) : this;
    }

    @Nullable
    public final ImageViewType getImageType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1013712453") ? (ImageViewType) ipChange.ipc$dispatch("-1013712453", new Object[]{this}) : this.viewState.k();
    }

    @Nullable
    public final Path getMClipPath() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1667602880") ? (Path) ipChange.ipc$dispatch("-1667602880", new Object[]{this}) : this.mClipPath;
    }

    @Nullable
    public final Uri getMTargeturi() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2091035193") ? (Uri) ipChange.ipc$dispatch("2091035193", new Object[]{this}) : this.mTargeturi;
    }

    public final boolean getMUseOriginalUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1133137306") ? ((Boolean) ipChange.ipc$dispatch("1133137306", new Object[]{this})).booleanValue() : this.mUseOriginalUrl;
    }

    public final int getMaxPossibleViewHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1927549108") ? ((Integer) ipChange.ipc$dispatch("-1927549108", new Object[]{this})).intValue() : this.maxPossibleViewHeight;
    }

    public final int getMaxPossibleViewWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1812919273") ? ((Integer) ipChange.ipc$dispatch("-1812919273", new Object[]{this})).intValue() : this.maxPossibleViewWidth;
    }

    @Nullable
    public final String getOriUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1937234119") ? (String) ipChange.ipc$dispatch("-1937234119", new Object[]{this}) : this.oriUrl;
    }

    @Nullable
    public final Boolean getRadiusClipModel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "898781136") ? (Boolean) ipChange.ipc$dispatch("898781136", new Object[]{this}) : this.radiusClipModel;
    }

    @Nullable
    public final kg1 getRemoteUrlImageLoader() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1112346045") ? (kg1) ipChange.ipc$dispatch("1112346045", new Object[]{this}) : this.remoteUrlImageLoader;
    }

    @Nullable
    public SimpleRequestListener getRequestListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1478224306") ? (SimpleRequestListener) ipChange.ipc$dispatch("1478224306", new Object[]{this}) : this.requestListener;
    }

    @Nullable
    public final og1.C9521a getRoundingParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1384157933") ? (og1.C9521a) ipChange.ipc$dispatch("-1384157933", new Object[]{this}) : this.viewState.q();
    }

    @Nullable
    public final Boolean getSkipCache() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-394916588") ? (Boolean) ipChange.ipc$dispatch("-394916588", new Object[]{this}) : this.skipCache;
    }

    @Nullable
    public final String getTargeturl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1101296732")) {
            return (String) ipChange.ipc$dispatch("-1101296732", new Object[]{this});
        }
        Uri uri = this.mTargeturi;
        if (uri != null) {
            return uri.toString();
        }
        return null;
    }

    @Nullable
    public final Uri getUri() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-238590075") ? (Uri) ipChange.ipc$dispatch("-238590075", new Object[]{this}) : this.mTargeturi;
    }

    @Nullable
    public String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1540161387") ? (String) ipChange.ipc$dispatch("-1540161387", new Object[]{this}) : this.oriUrl;
    }

    @NotNull
    public final og1 getViewState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "915994973") ? (og1) ipChange.ipc$dispatch("915994973", new Object[]{this}) : this.viewState;
    }

    public final boolean hasHierarchy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1317035411")) {
            return ((Boolean) ipChange.ipc$dispatch("-1317035411", new Object[]{this})).booleanValue();
        }
        return true;
    }

    public final boolean isForcedShowErrorImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-917501651") ? ((Boolean) ipChange.ipc$dispatch("-917501651", new Object[]{this})).booleanValue() : this.isForcedShowErrorImg;
    }

    public final boolean isNeedUseOriUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-741345852") ? ((Boolean) ipChange.ipc$dispatch("-741345852", new Object[]{this, str})).booleanValue() : this.mUseOriginalUrl;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-481312010")) {
            ipChange.ipc$dispatch("-481312010", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        this.mAtattchThreeObserver = getViewTreeObserver();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "406074521")) {
            ipChange.ipc$dispatch("406074521", new Object[]{this});
        } else {
            super.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(@Nullable Canvas canvas) {
        boolean K;
        IMoImageViewMonitor d;
        Path path;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-962666780")) {
            ipChange.ipc$dispatch("-962666780", new Object[]{this, canvas});
            return;
        }
        try {
            if (b41.d(this.radiusClipModel, Boolean.TRUE) && (path = this.mClipPath) != null && canvas != null) {
                b41.f(path);
                canvas.clipPath(path);
            }
            super.onDraw(canvas);
        } catch (Exception e) {
            String exc = e.toString();
            K = StringsKt__StringsKt.K(exc, "trying to draw too large", false, 2, null);
            if (K && (d = mg1.INSTANCE.d()) != null) {
                d.onError(getContext().getClass().getSimpleName(), 1001, exc);
            }
            lg1.INSTANCE.c(exc);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "719827065")) {
            ipChange.ipc$dispatch("719827065", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
        if (b41.d(this.radiusClipModel, Boolean.TRUE)) {
            this.mClipPath = calculateRadiusPath();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1733664014")) {
            ipChange.ipc$dispatch("-1733664014", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mTargeturi == null || !this.viewState.t()) {
            return;
        }
        if (Math.abs(i - i3) > 5 || Math.abs(i2 - i4) > 5) {
            this.sizeChangedFlag = Boolean.TRUE;
        }
        onSizeDetermined();
    }

    public final void onSizeDetermined() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2100944173")) {
            ipChange.ipc$dispatch("-2100944173", new Object[]{this});
            return;
        }
        lg1 lg1Var = lg1.INSTANCE;
        lg1Var.a("onSizeDetermined:" + this.oriUrl + "::" + (System.currentTimeMillis() - this.cTime));
        removeOnPreDrawListener();
        this.viewState.F(judgeImageType(this.oriUrl));
        if (!this.viewState.t()) {
            og1 og1Var = this.viewState;
            og1Var.O(og1Var.j(), this.viewState.i());
        } else {
            this.viewState.O(getMeasuredWidth(), getMeasuredHeight());
        }
        try {
            String fixUrl = fixUrl(this.oriUrl);
            if (fixUrl != null) {
                doSetUri(Uri.parse(fixUrl));
            }
        } catch (Exception e) {
            lg1 lg1Var2 = lg1.INSTANCE;
            lg1Var2.d("MoImageView", "parse -error onSizeDetermined: " + e);
        }
    }

    public final void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "394160407")) {
            ipChange.ipc$dispatch("394160407", new Object[]{this});
            return;
        }
        cancel();
        this.remoteUrlImageLoader = null;
        this.oriUrl = null;
        this.mTargeturi = null;
        Boolean bool = Boolean.FALSE;
        this.forceReloadUrl = bool;
        this.skipCache = bool;
        this.sizeChangedFlag = bool;
        this.maxPossibleViewWidth = -1;
        this.maxPossibleViewWidth = -1;
    }

    public final void setActualImageFocusPoint(@Nullable PointF pointF) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1137591654")) {
            ipChange.ipc$dispatch("1137591654", new Object[]{this, pointF});
        } else {
            this.viewState.w(pointF);
        }
    }

    public final void setActualImageScaleType(@Nullable GScaleType gScaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1888141502")) {
            ipChange.ipc$dispatch("-1888141502", new Object[]{this, gScaleType});
        } else {
            this.viewState.x(gScaleType);
        }
    }

    public final void setCTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "596247118")) {
            ipChange.ipc$dispatch("596247118", new Object[]{this, Long.valueOf(j)});
        } else {
            this.cTime = j;
        }
    }

    public final void setFailure(@Nullable Exception exc) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "77893386")) {
            ipChange.ipc$dispatch("77893386", new Object[]{this, exc});
        } else {
            this.viewState.A(exc);
        }
    }

    public final void setFailureImage(@Nullable BitmapDrawable bitmapDrawable, @Nullable GScaleType gScaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-283774361")) {
            ipChange.ipc$dispatch("-283774361", new Object[]{this, bitmapDrawable, gScaleType});
            return;
        }
        if (bitmapDrawable != null) {
            this.viewState.C(bitmapDrawable);
        }
        if (gScaleType != null) {
            this.viewState.D(gScaleType);
        }
    }

    public final void setFixedWH(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2822017")) {
            ipChange.ipc$dispatch("2822017", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        setVisibility(0);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        requestLayout();
    }

    public final void setForceReloadUrl(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "18800116")) {
            ipChange.ipc$dispatch("18800116", new Object[]{this, bool});
        } else {
            this.forceReloadUrl = bool;
        }
    }

    public final void setForcedLoadImageSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1260721897")) {
            ipChange.ipc$dispatch("1260721897", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        } else {
            this.viewState.E(i, i2);
        }
    }

    public final void setForcedShowErrorImg(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1759440769")) {
            ipChange.ipc$dispatch("1759440769", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isForcedShowErrorImg = z;
        }
    }

    public final void setImageType(@Nullable ImageViewType imageViewType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-205356261")) {
            ipChange.ipc$dispatch("-205356261", new Object[]{this, imageViewType});
            return;
        }
        if (imageViewType == null) {
            imageViewType = ImageViewType.DEFAULT;
        }
        this.manualImageType = imageViewType;
        this.viewState.F(imageViewType);
    }

    public final void setImageURI(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2018255459")) {
            ipChange.ipc$dispatch("-2018255459", new Object[]{this, str});
        } else {
            setImageURI(str != null ? Uri.parse(str) : null);
        }
    }

    public final void setLoadOriginImage(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "12684125")) {
            ipChange.ipc$dispatch("12684125", new Object[]{this, Boolean.valueOf(z)});
        } else {
            setLoadOriginImage(z, z);
        }
    }

    public final void setLocalDrawable(@Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-388224230")) {
            ipChange.ipc$dispatch("-388224230", new Object[]{this, num});
        } else if (num != null && num.intValue() != 0) {
            setUrl(String.valueOf(jg1.INSTANCE.j(getContext(), num)));
        } else {
            setImageDrawable(null);
            reset();
        }
    }

    public final void setLocalImageBitmap(@Nullable Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "266948841")) {
            ipChange.ipc$dispatch("266948841", new Object[]{this, bitmap});
        } else if (bitmap != null) {
            kg1.Companion.a(getContext()).b(this.viewState).m(bitmap, this);
        } else {
            lg1.INSTANCE.c("setLocalImageBitmap:bm==null");
            setImageDrawable(null);
            wt2 wt2Var = wt2.INSTANCE;
        }
    }

    public final void setMClipPath(@Nullable Path path) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-836610028")) {
            ipChange.ipc$dispatch("-836610028", new Object[]{this, path});
        } else {
            this.mClipPath = path;
        }
    }

    public final void setMaxPossibleViewHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1613678398")) {
            ipChange.ipc$dispatch("1613678398", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.maxPossibleViewHeight = i;
        }
    }

    public final void setMaxPossibleViewWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1711426453")) {
            ipChange.ipc$dispatch("-1711426453", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.maxPossibleViewWidth = i;
        }
    }

    public final void setPlaceholderImage(@Nullable BitmapDrawable bitmapDrawable, @Nullable GScaleType gScaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "847213022")) {
            ipChange.ipc$dispatch("847213022", new Object[]{this, bitmapDrawable, gScaleType});
            return;
        }
        if (bitmapDrawable != null) {
            this.viewState.J(bitmapDrawable);
        }
        if (gScaleType != null) {
            this.viewState.L(gScaleType);
        }
    }

    public final void setRadiusClipModel(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "951428558")) {
            ipChange.ipc$dispatch("951428558", new Object[]{this, bool});
            return;
        }
        this.viewState.M(bool);
        this.radiusClipModel = bool;
        this.mClipPath = calculateRadiusPath();
    }

    public final void setRemoteUrlImageLoader(@Nullable kg1 kg1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1932147281")) {
            ipChange.ipc$dispatch("1932147281", new Object[]{this, kg1Var});
        } else {
            this.remoteUrlImageLoader = kg1Var;
        }
    }

    public void setRequestListener(@Nullable SimpleRequestListener simpleRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1042783306")) {
            ipChange.ipc$dispatch("-1042783306", new Object[]{this, simpleRequestListener});
        } else {
            this.requestListener = simpleRequestListener;
        }
    }

    public final void setRoundingParams(@Nullable og1.C9521a c9521a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-613652515")) {
            ipChange.ipc$dispatch("-613652515", new Object[]{this, c9521a});
        } else if (c9521a != null) {
            this.viewState.N(c9521a);
        }
    }

    public final void setSkipCache(@Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1436583926")) {
            ipChange.ipc$dispatch("-1436583926", new Object[]{this, bool});
        } else {
            this.skipCache = bool;
        }
    }

    public final void setUri(@Nullable Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1773951443")) {
            ipChange.ipc$dispatch("-1773951443", new Object[]{this, uri});
        } else {
            doSetUri(uri);
        }
    }

    public void setUrl(@Nullable String str) {
        ImageView.ScaleType scaleType;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "918185345")) {
            ipChange.ipc$dispatch("918185345", new Object[]{this, str});
            return;
        }
        if (str == null || str.length() == 0) {
            Integer valueOf = Integer.valueOf(this.viewState.n());
            if (!(valueOf.intValue() != 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                int intValue = valueOf.intValue();
                GScaleType h = this.viewState.h();
                if (h == null || (scaleType = h.convert2Ori()) == null) {
                    scaleType = ImageView.ScaleType.FIT_XY;
                }
                setScaleType(scaleType);
                setLocalDrawable(Integer.valueOf(intValue));
            }
        } else if (mg1.INSTANCE.l()) {
        } else {
            this.oriUrl = str;
            this.cTime = System.currentTimeMillis();
            lg1 lg1Var = lg1.INSTANCE;
            lg1Var.a("setUrl:" + this.oriUrl);
            if (!q11.INSTANCE.i(this) && this.viewState.t() && !this.mUseOriginalUrl) {
                toggleSizeDetermined();
            } else {
                onSizeDetermined();
            }
        }
    }

    public final void setUseOriginalUrl(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "577900199")) {
            ipChange.ipc$dispatch("577900199", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mUseOriginalUrl = z;
        }
    }

    public final void setViewState(@NotNull og1 og1Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1680361403")) {
            ipChange.ipc$dispatch("-1680361403", new Object[]{this, og1Var});
            return;
        }
        b41.i(og1Var, "<set-?>");
        this.viewState = og1Var;
    }

    public final void tryAlignWithParentSize(@Nullable View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1822470022")) {
            ipChange.ipc$dispatch("-1822470022", new Object[]{this, view, Integer.valueOf(i)});
        } else if (view != null && i > 0) {
            if (view.getMeasuredWidth() > 0 && view.getMeasuredHeight() > 0) {
                lg1 lg1Var = lg1.INSTANCE;
                lg1Var.a("tryAlignWithParentSize-success=remainTime=" + i + '-' + view.getMeasuredWidth() + '-' + view.getMeasuredHeight());
                this.maxPossibleViewWidth = view.getMeasuredWidth();
                this.maxPossibleViewHeight = view.getMeasuredHeight();
                return;
            }
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                parent = null;
            }
            View view2 = (View) parent;
            if (view2 != null) {
                tryAlignWithParentSize(view2, i - 1);
            }
        } else {
            lg1 lg1Var2 = lg1.INSTANCE;
            lg1Var2.a("tryAlignWithParentSize-fail,remainTime=" + i);
        }
    }

    public final void setLoadOriginImage(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "393253655")) {
            ipChange.ipc$dispatch("393253655", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        setUseOriginalUrl(z);
        this.viewState.G(z2);
    }

    public final void setFailureImage(@Nullable BitmapDrawable bitmapDrawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "720317032")) {
            ipChange.ipc$dispatch("720317032", new Object[]{this, bitmapDrawable});
        } else {
            setFailureImage(bitmapDrawable, GScaleType.CENTER_INSIDE);
        }
    }

    public final void setPlaceholderImage(@Nullable BitmapDrawable bitmapDrawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-686165359")) {
            ipChange.ipc$dispatch("-686165359", new Object[]{this, bitmapDrawable});
        } else {
            setPlaceholderImage(bitmapDrawable, GScaleType.CENTER_INSIDE);
        }
    }

    public /* synthetic */ MoImageView(Context context, AttributeSet attributeSet, int i, int i2, k50 k50Var) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
