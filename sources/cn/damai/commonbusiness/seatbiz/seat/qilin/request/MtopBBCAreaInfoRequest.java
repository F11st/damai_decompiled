package cn.damai.commonbusiness.seatbiz.seat.qilin.request;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMBaseMtopRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.real.svg.decrypt.SvgDecrypt;
import com.taobao.orange.util.MD5Util;
import tb.cr;
import tb.u9;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MtopBBCAreaInfoRequest extends DMBaseMtopRequest {
    private static transient /* synthetic */ IpChange $ipChange;
    public String cityId;
    public String excludestatus;
    public String pfId;
    public String seatAcceptEncoding;
    public String seatEncodeVersion;
    public String svgDT;
    public String svgEncVer;
    public String vr3dDT;

    public MtopBBCAreaInfoRequest(String str, long j, @Nullable String str2, String str3) {
        this(str, j + "", str2, str3);
    }

    private String getMD5DegradeToken(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2056010283")) {
            return (String) ipChange.ipc$dispatch("2056010283", new Object[]{this, str, str2});
        }
        return MD5Util.md5(str + str2).toUpperCase();
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-802632541") ? (String) ipChange.ipc$dispatch("-802632541", new Object[]{this}) : "mtop.damai.wireless.project.getB2B2CAreaInfo";
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedEcode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1941873174")) {
            return ((Boolean) ipChange.ipc$dispatch("-1941873174", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public boolean getNeedSession() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-909421594")) {
            return ((Boolean) ipChange.ipc$dispatch("-909421594", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // cn.damai.common.net.mtop.netfit.DMBaseMtopRequest
    public String getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1365104182") ? (String) ipChange.ipc$dispatch("1365104182", new Object[]{this}) : u9.b().a();
    }

    public MtopBBCAreaInfoRequest(String str, String str2, @Nullable String str3, String str4) {
        this.excludestatus = "true";
        this.svgEncVer = SvgDecrypt.c();
        this.cityId = str;
        this.pfId = str2;
        this.seatAcceptEncoding = str4;
        this.seatEncodeVersion = cr.e();
        if (TextUtils.isEmpty(str3)) {
            this.svgDT = null;
        } else {
            this.svgDT = getMD5DegradeToken(str3, str2);
        }
    }

    public MtopBBCAreaInfoRequest(String str, String str2, @Nullable String str3, @Nullable String str4, String str5) {
        this.excludestatus = "true";
        this.svgEncVer = SvgDecrypt.c();
        this.cityId = str;
        this.pfId = str2;
        this.seatAcceptEncoding = str5;
        this.seatEncodeVersion = cr.e();
        this.vr3dDT = str4;
    }

    public MtopBBCAreaInfoRequest(String str, String str2, @Nullable String str3) {
        this.excludestatus = "true";
        this.svgEncVer = SvgDecrypt.c();
        this.cityId = str;
        this.pfId = str2;
        if (TextUtils.isEmpty(str3)) {
            this.svgDT = null;
        } else {
            this.svgDT = getMD5DegradeToken(str3, str2);
        }
    }
}
