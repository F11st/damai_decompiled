package com.alibaba.security.realidentity.jsbridge;

import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.biometrics.image.RPWebViewMediaCacheManager;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.realidentity.a.AbstractC3841b;
import com.alibaba.security.realidentity.upload.C3918b;
import com.alibaba.security.realidentity.upload.UploadFileModel;
import com.alibaba.security.realidentity.upload.a.AbstractC3917a;
import com.alibaba.security.realidentity.upload.b.InterfaceC3921b;
import com.taomai.android.h5container.api.TMPhotoUploadPlugin;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import tb.m80;

/* compiled from: Taobao */
@InterfaceC3904f(a = TMPhotoUploadPlugin.ACTION_UPLOAD_PHOTO)
/* renamed from: com.alibaba.security.realidentity.jsbridge.o */
/* loaded from: classes8.dex */
public class C3914o extends AbstractC3893a {
    private AbstractC3917a as;

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    protected final String a() {
        return TMPhotoUploadPlugin.ACTION_UPLOAD_PHOTO;
    }

    @Override // com.alibaba.security.realidentity.jsbridge.AbstractC3893a
    public final boolean a(String str, final AbstractC3907h abstractC3907h) {
        if (C3800a.a()) {
            C3800a.a("AbsJavaScriptExecuter", "UploadApi execute params:".concat(String.valueOf(str)));
        }
        try {
            JSONObject parseObject = JSON.parseObject(str);
            String str2 = null;
            String string = (parseObject == null || !parseObject.containsKey(AbstractC3893a.r)) ? null : parseObject.getString(AbstractC3893a.r);
            if (parseObject != null && parseObject.containsKey(AbstractC3893a.N)) {
                str2 = parseObject.getString(AbstractC3893a.N);
            }
            final String str3 = str2;
            String str4 = RPWebViewMediaCacheManager.getInstance().get(string);
            if (str4 == null) {
                WVResult wVResult = new WVResult();
                wVResult.addData(AbstractC3893a.N, str3);
                wVResult.addData(AbstractC3893a.r, string);
                wVResult.addData("errorMsg", "");
                abstractC3907h.a(wVResult);
                a(wVResult, false);
                return false;
            }
            if (this.as == null) {
                C3918b unused = C3918b.C3919a.a;
                this.as = C3918b.a(this.ao);
            }
            final String md5 = RPWebViewMediaCacheManager.getInstance().getMd5(string);
            UploadFileModel uploadFileModel = new UploadFileModel();
            uploadFileModel.setLocalFilePath(str4);
            uploadFileModel.setFileType("jpeg");
            final String str5 = string;
            Object a = this.as.a(uploadFileModel, new InterfaceC3921b() { // from class: com.alibaba.security.realidentity.jsbridge.o.1
                @Override // com.alibaba.security.realidentity.upload.b.InterfaceC3921b
                public final void a(String str6) {
                    C3912m.a().b(str5);
                    if (md5 != null) {
                        String str7 = "sign=" + md5;
                        try {
                            str7 = URLEncoder.encode(str7, "UTF-8");
                        } catch (UnsupportedEncodingException unused2) {
                        }
                        str6 = str6 + m80.DINAMIC_PREFIX_AT + str7;
                    }
                    abstractC3907h.b("{\"photoType\":\"" + str3 + "\",\"sourceUrl\":\"" + str6 + "\"}");
                    C3914o.this.a(new WVResult("success"), true);
                }

                @Override // com.alibaba.security.realidentity.upload.b.InterfaceC3921b
                public final void b(String str6) {
                    if (C3800a.a()) {
                        C3800a.d("AbsJavaScriptExecuter", "arup upload fail: ".concat(String.valueOf(str6)));
                    }
                    C3912m.a().b(str5);
                    WVResult wVResult2 = new WVResult();
                    wVResult2.addData(AbstractC3893a.N, str3);
                    wVResult2.addData(AbstractC3893a.r, str5);
                    wVResult2.addData("errorMsg", str6);
                    abstractC3907h.a(wVResult2);
                    AbstractC3841b.a().a("RPException", "RPUpload", "upload fail.", str6, null, null);
                    C3914o.this.a(wVResult2, false);
                }

                @Override // com.alibaba.security.realidentity.upload.b.InterfaceC3921b
                public final void a(long j, long j2) {
                    WVResult wVResult2 = new WVResult();
                    wVResult2.addData(AbstractC3893a.aa, String.valueOf(j));
                    wVResult2.addData(AbstractC3893a.ab, String.valueOf(j2));
                    wVResult2.setSuccess();
                    C3914o.this.an.a("rpUploadProgress", wVResult2.toJsonString());
                }

                @Override // com.alibaba.security.realidentity.upload.b.InterfaceC3921b
                public final void a() {
                    C3912m.a().b(str5);
                }
            });
            C3912m a2 = C3912m.a();
            synchronized (a2.a) {
                if (string != null) {
                    a2.a.put(string, a);
                }
            }
            return true;
        } catch (Exception e) {
            if (C3800a.a()) {
                C3800a.b();
            }
            AbstractC3893a.a("UploadApi parse error", e);
            AbstractC3893a.a(abstractC3907h);
            return false;
        }
    }
}
