package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ee implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ ed f299a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ String f300a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ee(ed edVar, String str, Context context, String str2, String str3) {
        this.f299a = edVar;
        this.f300a = str;
        this.a = context;
        this.b = str2;
        this.c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        String str;
        String str2;
        Context context2;
        String str3;
        String str4;
        ed edVar;
        Context context3;
        ed edVar2;
        ef efVar;
        Context context4;
        if (TextUtils.isEmpty(this.f300a)) {
            context = this.a;
            str = "null";
            str2 = "A receive a incorrect message with empty info";
        } else {
            try {
                dz.a(this.a, this.f300a, 1001, "get message");
                JSONObject jSONObject = new JSONObject(this.f300a);
                String optString = jSONObject.optString("action");
                String optString2 = jSONObject.optString("awakened_app_packagename");
                String optString3 = jSONObject.optString("awake_app_packagename");
                String optString4 = jSONObject.optString("awake_app");
                String optString5 = jSONObject.optString("awake_type");
                int optInt = jSONObject.optInt("awake_foreground", 0);
                if (this.b.equals(optString3) && this.c.equals(optString4)) {
                    if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString2)) {
                        this.f299a.b(optString3);
                        this.f299a.a(optString4);
                        ec ecVar = new ec();
                        ecVar.b(optString);
                        ecVar.a(optString2);
                        ecVar.a(optInt);
                        ecVar.d(this.f300a);
                        if ("service".equals(optString5)) {
                            if (TextUtils.isEmpty(optString)) {
                                ecVar.c("com.xiaomi.mipush.sdk.PushMessageHandler");
                                edVar2 = this.f299a;
                                efVar = ef.SERVICE_COMPONENT;
                                context4 = this.a;
                            } else {
                                edVar2 = this.f299a;
                                efVar = ef.SERVICE_ACTION;
                                context4 = this.a;
                            }
                            edVar2.a(efVar, context4, ecVar);
                            return;
                        }
                        ef efVar2 = ef.ACTIVITY;
                        if (efVar2.f302a.equals(optString5)) {
                            edVar = this.f299a;
                            context3 = this.a;
                        } else {
                            efVar2 = ef.PROVIDER;
                            if (efVar2.f302a.equals(optString5)) {
                                edVar = this.f299a;
                                context3 = this.a;
                            } else {
                                context2 = this.a;
                                str3 = this.f300a;
                                str4 = "A receive a incorrect message with unknown type " + optString5;
                            }
                        }
                        edVar.a(efVar2, context3, ecVar);
                        return;
                    }
                    context2 = this.a;
                    str3 = this.f300a;
                    str4 = "A receive a incorrect message with empty type";
                    dz.a(context2, str3, 1008, str4);
                    return;
                }
                dz.a(this.a, this.f300a, 1008, "A receive a incorrect message with incorrect package info" + optString3);
                return;
            } catch (JSONException e) {
                AbstractC7535b.a(e);
                context = this.a;
                str = this.f300a;
                str2 = "A meet a exception when receive the message";
            }
        }
        dz.a(context, str, 1008, str2);
    }
}
