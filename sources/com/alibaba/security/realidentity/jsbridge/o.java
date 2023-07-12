package com.alibaba.security.realidentity.jsbridge;

import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.biometrics.image.RPWebViewMediaCacheManager;
import com.alibaba.security.realidentity.upload.UploadFileModel;
import com.alibaba.security.realidentity.upload.b;
import com.taomai.android.h5container.api.TMPhotoUploadPlugin;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import tb.m80;

/* compiled from: Taobao */
@f(a = TMPhotoUploadPlugin.ACTION_UPLOAD_PHOTO)
/* loaded from: classes8.dex */
public class o extends a {
    private com.alibaba.security.realidentity.upload.a.a as;

    @Override // com.alibaba.security.realidentity.jsbridge.a
    protected final String a() {
        return TMPhotoUploadPlugin.ACTION_UPLOAD_PHOTO;
    }

    @Override // com.alibaba.security.realidentity.jsbridge.a
    public final boolean a(String str, final h hVar) {
        if (com.alibaba.security.common.c.a.a()) {
            com.alibaba.security.common.c.a.a("AbsJavaScriptExecuter", "UploadApi execute params:".concat(String.valueOf(str)));
        }
        try {
            JSONObject parseObject = JSON.parseObject(str);
            String str2 = null;
            String string = (parseObject == null || !parseObject.containsKey(a.r)) ? null : parseObject.getString(a.r);
            if (parseObject != null && parseObject.containsKey(a.N)) {
                str2 = parseObject.getString(a.N);
            }
            final String str3 = str2;
            String str4 = RPWebViewMediaCacheManager.getInstance().get(string);
            if (str4 == null) {
                WVResult wVResult = new WVResult();
                wVResult.addData(a.N, str3);
                wVResult.addData(a.r, string);
                wVResult.addData("errorMsg", "");
                hVar.a(wVResult);
                a(wVResult, false);
                return false;
            }
            if (this.as == null) {
                com.alibaba.security.realidentity.upload.b unused = b.a.a;
                this.as = com.alibaba.security.realidentity.upload.b.a(this.ao);
            }
            final String md5 = RPWebViewMediaCacheManager.getInstance().getMd5(string);
            UploadFileModel uploadFileModel = new UploadFileModel();
            uploadFileModel.setLocalFilePath(str4);
            uploadFileModel.setFileType("jpeg");
            final String str5 = string;
            Object a = this.as.a(uploadFileModel, new com.alibaba.security.realidentity.upload.b.b() { // from class: com.alibaba.security.realidentity.jsbridge.o.1
                @Override // com.alibaba.security.realidentity.upload.b.b
                public final void a(String str6) {
                    m.a().b(str5);
                    if (md5 != null) {
                        String str7 = "sign=" + md5;
                        try {
                            str7 = URLEncoder.encode(str7, "UTF-8");
                        } catch (UnsupportedEncodingException unused2) {
                        }
                        str6 = str6 + m80.DINAMIC_PREFIX_AT + str7;
                    }
                    hVar.b("{\"photoType\":\"" + str3 + "\",\"sourceUrl\":\"" + str6 + "\"}");
                    o.this.a(new WVResult("success"), true);
                }

                @Override // com.alibaba.security.realidentity.upload.b.b
                public final void b(String str6) {
                    if (com.alibaba.security.common.c.a.a()) {
                        com.alibaba.security.common.c.a.d("AbsJavaScriptExecuter", "arup upload fail: ".concat(String.valueOf(str6)));
                    }
                    m.a().b(str5);
                    WVResult wVResult2 = new WVResult();
                    wVResult2.addData(a.N, str3);
                    wVResult2.addData(a.r, str5);
                    wVResult2.addData("errorMsg", str6);
                    hVar.a(wVResult2);
                    com.alibaba.security.realidentity.a.b.a().a("RPException", "RPUpload", "upload fail.", str6, null, null);
                    o.this.a(wVResult2, false);
                }

                @Override // com.alibaba.security.realidentity.upload.b.b
                public final void a(long j, long j2) {
                    WVResult wVResult2 = new WVResult();
                    wVResult2.addData(a.aa, String.valueOf(j));
                    wVResult2.addData(a.ab, String.valueOf(j2));
                    wVResult2.setSuccess();
                    o.this.an.a("rpUploadProgress", wVResult2.toJsonString());
                }

                @Override // com.alibaba.security.realidentity.upload.b.b
                public final void a() {
                    m.a().b(str5);
                }
            });
            m a2 = m.a();
            synchronized (a2.a) {
                if (string != null) {
                    a2.a.put(string, a);
                }
            }
            return true;
        } catch (Exception e) {
            if (com.alibaba.security.common.c.a.a()) {
                com.alibaba.security.common.c.a.b();
            }
            a.a("UploadApi parse error", e);
            a.a(hVar);
            return false;
        }
    }
}
