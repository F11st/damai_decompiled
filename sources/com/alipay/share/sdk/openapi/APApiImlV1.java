package com.alipay.share.sdk.openapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Log;
import com.alipay.share.sdk.Constant;
import com.alipay.share.sdk.openapi.SendMessageToZFB;
import com.alipay.share.sdk.openapi.algorithm.MD5;
import com.alipay.share.sdk.openapi.channel.APMessageAct;
import com.alipay.share.sdk.plugin.APVersionCheck;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class APApiImlV1 implements IAPApi {
    private Context a;
    private String b;
    private boolean c;

    public APApiImlV1(Context context, String str) {
        this(context, str, false);
    }

    private boolean a(String str) {
        if (!this.c) {
            Log.d("APSDK.ZFBApiImlV1", "ignore alipay app signature validation");
            return true;
        }
        try {
            return c(this.a.getPackageManager().getPackageInfo(str, 64).signatures);
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static boolean b(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            if (bArr.length != bArr2.length) {
                Log.e("APSDK.ZFBApiImlV1", "checkSumConsistent fail, length is different");
                return false;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
            }
            return true;
        }
        Log.e("APSDK.ZFBApiImlV1", "checkSumConsistent fail, invalid arguments");
        return false;
    }

    private boolean c(Signature[] signatureArr) {
        if (!this.c) {
            Log.d("APSDK.ZFBApiImlV1", "ignore alipay app signature validation");
            return true;
        }
        for (Signature signature : signatureArr) {
            String charsString = signature.toCharsString();
            Log.d("APSDK.ZFBApiImlV1", "check signature:" + charsString);
            if (charsString.equals("30820244308201ad02044b28a3c9300d06092a864886f70d01010405003068310b300906035504061302636e3110300e060355040813076265696a696e673110300e060355040713076265696a696e67310f300d060355040a1306616c69706179310f300d060355040b1306616c69706179311330110603550403130a73686971756e2e7368693020170d3039313231363039303932395a180f32303531303131303039303932395a3068310b300906035504061302636e3110300e060355040813076265696a696e673110300e060355040713076265696a696e67310f300d060355040a1306616c69706179310f300d060355040b1306616c69706179311330110603550403130a73686971756e2e73686930819f300d06092a864886f70d010101050003818d0030818902818100b6cbad6cbd5ed0d209afc69ad3b7a617efaae9b3c47eabe0be42d924936fa78c8001b1fd74b079e5ff9690061dacfa4768e981a526b9ca77156ca36251cf2f906d105481374998a7e6e6e18f75ca98b8ed2eaf86ff402c874cca0a263053f22237858206867d210020daa38c48b20cc9dfd82b44a51aeb5db459b22794e2d6490203010001300d06092a864886f70d010104050003818100b6b5e3854b2d5daaa02d127195d13a1927991176047982feaa3d1625740788296443e9000fe14dfe6701d7e86be06b9282e68d4eff32b19d48555b8a0838a6e146238f048aca986715d7eab0fb445796bbd19360a7721b8d99ba04581af957a290c47302055f813862f3c40b840e95898e72a1de03b6257a1acad4b482cd815c")) {
                Log.d("APSDK.ZFBApiImlV1", "checkSumConsistent pass");
                return true;
            }
        }
        return false;
    }

    @Override // com.alipay.share.sdk.openapi.IAPApi
    public int getZFBVersionCode() {
        return new APVersionCheck(this.a).getZFBAppVersionCode();
    }

    @Override // com.alipay.share.sdk.openapi.IAPApi
    public final boolean handleIntent(Intent intent, IAPAPIEventHandler iAPAPIEventHandler) {
        String stringExtra = intent.getStringExtra(Constant.EXTRA_MESSAGE_CONTENT);
        int intExtra = intent.getIntExtra(Constant.EXTRA_MESSAGE_SDK_VERSION, 0);
        String stringExtra2 = intent.getStringExtra(Constant.EXTRA_MESSAGE_APP_PACKAGE_NAME);
        if (stringExtra2 != null && stringExtra2.length() != 0) {
            byte[] byteArrayExtra = intent.getByteArrayExtra(Constant.EXTRA_MESSAGE_CHECK_SUM);
            StringBuffer stringBuffer = new StringBuffer();
            if (stringExtra != null) {
                stringBuffer.append(stringExtra);
            }
            stringBuffer.append(intExtra);
            stringBuffer.append(stringExtra2);
            stringBuffer.append("alipay");
            if (!b(byteArrayExtra, MD5.getMessageDigest(stringBuffer.toString().substring(1, 9).getBytes()).getBytes())) {
                Log.e("APSDK.ZFBApiImlV1", "checksum fail");
                return false;
            }
            int intExtra2 = intent.getIntExtra(Constant.EXTRA_COMMAND_TYPE, 0);
            if (intExtra2 == 1) {
                iAPAPIEventHandler.onResp(new SendMessageToZFB.Resp(intent.getExtras()));
                return true;
            } else if (intExtra2 == 2) {
                iAPAPIEventHandler.onResp(new SendMessageToZFB.Resp(intent.getExtras()));
                return true;
            } else if (intExtra2 == 3) {
                iAPAPIEventHandler.onReq(new SendMessageToZFB.Req(intent.getExtras()));
                return true;
            } else if (intExtra2 != 4) {
                return false;
            } else {
                iAPAPIEventHandler.onReq(new SendMessageToZFB.Req(intent.getExtras()));
                return true;
            }
        }
        Log.e("APSDK.ZFBApiImlV1", "invalid argument");
        return false;
    }

    @Override // com.alipay.share.sdk.openapi.IAPApi
    public boolean isZFBAppInstalled() {
        try {
            PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 64);
            if (packageInfo != null) {
                return c(packageInfo.signatures);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.alipay.share.sdk.openapi.IAPApi
    public boolean isZFBSupportAPI() {
        return getZFBVersionCode() >= 77;
    }

    @Override // com.alipay.share.sdk.openapi.IAPApi
    public boolean openZFBApp() {
        if (!isZFBAppInstalled()) {
            Log.e("APSDK.ZFBApiImlV1", "open Alipay app failed, not installed or signature check failed");
            return false;
        }
        try {
            Context context = this.a;
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage("com.eg.android.AlipayGphone"));
            return true;
        } catch (Exception e) {
            Log.e("APSDK.ZFBApiImlV1", "start Alipay Main Activity fail, exception = " + e.getMessage());
            return false;
        }
    }

    @Override // com.alipay.share.sdk.openapi.IAPApi
    public boolean sendReq(BaseReq baseReq) {
        if (!a("com.eg.android.AlipayGphone")) {
            Log.e("APSDK.ZFBApiImlV1", "sendReq failed for alipay app signature check failed");
            return false;
        } else if (!baseReq.a()) {
            Log.e("APSDK.ZFBApiImlV1", "sendReq checkArgs fail");
            return false;
        } else {
            Bundle bundle = new Bundle();
            baseReq.toBundle(bundle);
            Context context = this.a;
            return APMessageAct.sendToZFB(context, String.valueOf(Constant.SEND_REQUEST_CONTENT_APPID) + this.b, bundle);
        }
    }

    public APApiImlV1(Context context, String str, boolean z) {
        this.a = context;
        this.b = str;
        this.c = z;
    }
}
