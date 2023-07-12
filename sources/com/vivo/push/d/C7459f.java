package com.vivo.push.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.vivo.push.AbstractC7496o;
import com.vivo.push.AbstractRunnableC7491l;
import com.vivo.push.b.C7422j;
import com.vivo.push.sdk.C7501a;
import com.vivo.push.util.C7523p;
import com.vivo.push.util.C7527t;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.vivo.push.d.f */
/* loaded from: classes11.dex */
public final class C7459f extends AbstractRunnableC7491l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C7459f(AbstractC7496o abstractC7496o) {
        super(abstractC7496o);
    }

    public static boolean a(Context context) {
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (queryIntentServices != null && queryIntentServices.size() > 0) {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
            if (packageManager.getComponentEnabledSetting(componentName) != 1) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
                C7523p.d("OnChangePushStatusTask", "enableService push service.");
                return true;
            }
            C7523p.d("OnChangePushStatusTask", "push service has enabled");
            return false;
        }
        C7523p.a("OnChangePushStatusTask", "enableService error: can not find push service.");
        return false;
    }

    public static boolean b(Context context) {
        Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
        if (queryIntentServices != null && queryIntentServices.size() > 0) {
            PackageManager packageManager = context.getPackageManager();
            ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
                C7523p.d("OnChangePushStatusTask", "disableService push service.");
                return true;
            }
            C7523p.d("OnChangePushStatusTask", "push service has disabled");
            return false;
        }
        C7523p.a("OnChangePushStatusTask", "disableService error: can not find push service.");
        return false;
    }

    private static List<ResolveInfo> c(Context context) {
        List<ResolveInfo> list;
        Intent intent = new Intent("com.vivo.pushservice.action.RECEIVE");
        intent.setPackage(context.getPackageName());
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (Exception unused) {
            list = null;
        }
        if (list == null || list.size() <= 0) {
            Intent intent2 = new Intent("com.vivo.pushclient.action.RECEIVE");
            intent2.setPackage(context.getPackageName());
            try {
                return context.getPackageManager().queryBroadcastReceivers(intent2, 576);
            } catch (Exception unused2) {
                return list;
            }
        }
        return list;
    }

    @Override // com.vivo.push.AbstractRunnableC7491l
    protected final void a(AbstractC7496o abstractC7496o) {
        if (this.a.getPackageName().equals(C7527t.b(this.a))) {
            return;
        }
        C7422j c7422j = (C7422j) abstractC7496o;
        int d = c7422j.d();
        int e = c7422j.e();
        C7523p.d("OnChangePushStatusTask", "OnChangePushStatusTask serviceStatus is " + d + " ; receiverStatus is " + e);
        if (d == 2) {
            b(this.a);
        } else if (d == 1) {
            a(this.a);
        } else if (d == 0) {
            Context context = this.a;
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 576);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                PackageManager packageManager = context.getPackageManager();
                ComponentName componentName = new ComponentName(context, queryIntentServices.get(0).serviceInfo.name);
                if (packageManager.getComponentEnabledSetting(componentName) != 0) {
                    packageManager.setComponentEnabledSetting(componentName, 0, 1);
                    C7523p.d("OnChangePushStatusTask", "defaultService push service.");
                } else {
                    C7523p.d("OnChangePushStatusTask", "push service has defaulted");
                }
            } else {
                C7523p.a("OnChangePushStatusTask", "defaultService error: can not find push service.");
            }
        }
        if (e == 2) {
            Context context2 = this.a;
            List<ResolveInfo> c = c(context2);
            if (c != null && c.size() > 0) {
                String str = c.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str)) {
                    C7523p.d("OnChangePushStatusTask", "disableReceiver error: className is null. ");
                } else {
                    PackageManager packageManager2 = context2.getPackageManager();
                    ComponentName componentName2 = new ComponentName(context2, str);
                    if (packageManager2.getComponentEnabledSetting(componentName2) != 2) {
                        packageManager2.setComponentEnabledSetting(componentName2, 2, 1);
                        C7523p.d("OnChangePushStatusTask", "push service disableReceiver ");
                    } else {
                        C7523p.d("OnChangePushStatusTask", "push service has disableReceiver ");
                    }
                }
            } else {
                C7523p.a("OnChangePushStatusTask", "disableReceiver error: can not find push service.");
            }
            C7501a.a().b();
        } else if (e == 1) {
            Context context3 = this.a;
            List<ResolveInfo> c2 = c(context3);
            if (c2 != null && c2.size() > 0) {
                String str2 = c2.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str2)) {
                    C7523p.d("OnChangePushStatusTask", "enableReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager3 = context3.getPackageManager();
                ComponentName componentName3 = new ComponentName(context3, str2);
                if (packageManager3.getComponentEnabledSetting(componentName3) != 1) {
                    packageManager3.setComponentEnabledSetting(componentName3, 1, 1);
                    C7523p.d("OnChangePushStatusTask", "push service enableReceiver ");
                    return;
                }
                C7523p.d("OnChangePushStatusTask", "push service has enableReceiver ");
                return;
            }
            C7523p.a("OnChangePushStatusTask", "enableReceiver error: can not find push service.");
        } else if (e == 0) {
            Context context4 = this.a;
            List<ResolveInfo> c3 = c(context4);
            if (c3 != null && c3.size() > 0) {
                String str3 = c3.get(0).activityInfo.name;
                if (TextUtils.isEmpty(str3)) {
                    C7523p.d("OnChangePushStatusTask", "defaultReceiver error: className is null. ");
                    return;
                }
                PackageManager packageManager4 = context4.getPackageManager();
                ComponentName componentName4 = new ComponentName(context4, str3);
                if (packageManager4.getComponentEnabledSetting(componentName4) != 0) {
                    packageManager4.setComponentEnabledSetting(componentName4, 0, 1);
                    C7523p.d("OnChangePushStatusTask", "push service defaultReceiver ");
                    return;
                }
                C7523p.d("OnChangePushStatusTask", "push service has defaulted");
                return;
            }
            C7523p.a("OnChangePushStatusTask", "defaultReceiver error: can not find push service.");
        }
    }
}
