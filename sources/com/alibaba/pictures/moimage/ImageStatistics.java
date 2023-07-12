package com.alibaba.pictures.moimage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.ali.user.mobile.login.model.LoginConstant;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b*\u0010+J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\fR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\fR\u0013\u0010!\u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0013\u0010#\u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0013\u0010%\u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010 R\u0013\u0010'\u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b&\u0010 R\u0013\u0010)\u001a\u00020\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b(\u0010 ¨\u0006."}, d2 = {"Lcom/alibaba/pictures/moimage/ImageStatistics;", "Ljava/io/Serializable;", "", "model", "Ltb/wt2;", "updatePath", "", "getPageName", "", "getTotalTime", "", "imageType", "I", "connType", "getConnType", "()I", "setConnType", "(I)V", LoginConstant.START_TIME, "J", "endTime", com.taobao.phenix.request.ImageStatistics.KEY_TOTAL_TIME, AbstractC3893a.V, "Ljava/lang/String;", "dataSource", "", "isFirstResource", "Z", "size", "pageName", "businessType", "getImgTypeName", "()Ljava/lang/String;", "imgTypeName", "getDataSourceName", "dataSourceName", "getBusinessTypeName", "businessTypeName", "getFormat", "format", "getConnTypeName", "connTypeName", "<init>", "()V", "Companion", "a", "moimage_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class ImageStatistics implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int BUSINESS_TYPE_DOWNLOAD = 1;
    public static final int BUSINESS_TYPE_LOAD_PRELOADED = 3;
    public static final int BUSINESS_TYPE_NORMAL = 0;
    public static final int BUSINESS_TYPE_PRELOAD = 2;
    @NotNull
    public static final C3609a Companion = new C3609a(null);
    public static final int IMG_TYPE_GIF = 1;
    public static final int IMG_TYPE_NORMAL = 0;
    public static final int IMG_TYPE_WEBANI = 2;
    @JvmField
    public int businessType;
    private int connType;
    @JvmField
    @Nullable
    public String dataSource;
    @JvmField
    public long endTime;
    @JvmField
    public int imageType;
    @JvmField
    public boolean isFirstResource;
    @JvmField
    @Nullable
    public String pageName;
    @JvmField
    @Nullable
    public String path;
    @JvmField
    public int size;
    @JvmField
    public long startTime;
    @JvmField
    public long totalTime;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.moimage.ImageStatistics$a */
    /* loaded from: classes7.dex */
    public static final class C3609a {
        private C3609a() {
        }

        public /* synthetic */ C3609a(k50 k50Var) {
            this();
        }
    }

    @NotNull
    public final String getBusinessTypeName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "143619669")) {
            return (String) ipChange.ipc$dispatch("143619669", new Object[]{this});
        }
        int i = this.businessType;
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? String.valueOf(i) : "LOADPRE" : "PRELOAD" : "DOWNLOAD" : "NORMAL";
    }

    public final int getConnType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1149225277") ? ((Integer) ipChange.ipc$dispatch("1149225277", new Object[]{this})).intValue() : this.connType;
    }

    @NotNull
    public final String getConnTypeName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-665831871") ? (String) ipChange.ipc$dispatch("-665831871", new Object[]{this}) : "";
    }

    @NotNull
    public final String getDataSourceName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "42650592")) {
            return (String) ipChange.ipc$dispatch("42650592", new Object[]{this});
        }
        String str = this.dataSource;
        if (str == null) {
            return "UNKNOW";
        }
        b41.f(str);
        return str;
    }

    @NotNull
    public final String getFormat() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-638202169") ? (String) ipChange.ipc$dispatch("-638202169", new Object[]{this}) : "";
    }

    @NotNull
    public final String getImgTypeName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "148642862")) {
            return (String) ipChange.ipc$dispatch("148642862", new Object[]{this});
        }
        int i = this.imageType;
        return i != 0 ? i != 1 ? i != 2 ? String.valueOf(i) : "WEPANI" : "GIF" : "DEFAULT";
    }

    @Nullable
    public final String getPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "77216714") ? (String) ipChange.ipc$dispatch("77216714", new Object[]{this}) : TextUtils.isEmpty(this.pageName) ? "UNKNOW" : this.pageName;
    }

    public final long getTotalTime() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217351389")) {
            return ((Long) ipChange.ipc$dispatch("217351389", new Object[]{this})).longValue();
        }
        long j = this.totalTime;
        if (j > 0) {
            return j;
        }
        long j2 = this.startTime;
        if (j2 != 0) {
            long j3 = this.endTime;
            if (j3 != 0) {
                return j3 - j2;
            }
        }
        return -1L;
    }

    public final void setConnType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2117939707")) {
            ipChange.ipc$dispatch("-2117939707", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.connType = i;
        }
    }

    public final void updatePath(@NotNull Object obj) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2057770222")) {
            ipChange.ipc$dispatch("-2057770222", new Object[]{this, obj});
            return;
        }
        b41.i(obj, "model");
        if (obj instanceof Uri) {
            str = obj.toString();
        } else if (obj instanceof String) {
            str = (String) obj;
        } else if (obj instanceof Integer) {
            str = "local_id_" + obj;
        } else if (obj instanceof Drawable) {
            str = "local_drawable";
        } else {
            str = obj instanceof Bitmap ? "local_Bitmap" : "UNKNOW";
        }
        this.path = str;
    }
}
