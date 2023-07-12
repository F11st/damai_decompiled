package android.taobao.windvane.jsbridge.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVContacts extends WVApiPlugin {
    private static final String KEY_NAME = "name";
    private static final String KEY_PHONE = "phone";
    private static final String[] PHONES_PROJECTION = {"display_name", "data1"};
    private static final String TAG = "WVContacts";
    private WVCallBackContext mCallback = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class ContactInfo {
        String name;
        String number;

        private ContactInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void authStatus(final WVCallBackContext wVCallBackContext) {
        new AsyncTask<Void, Integer, Void>() { // from class: android.taobao.windvane.jsbridge.api.WVContacts.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            public Void doInBackground(Void... voidArr) {
                Cursor cursor;
                WVResult wVResult = new WVResult();
                try {
                    cursor = ((WVApiPlugin) WVContacts.this).mContext.getContentResolver().query(Uri.parse("content://com.android.contacts/contacts"), new String[]{"_id"}, null, null, null);
                } catch (Exception unused) {
                    cursor = null;
                }
                if (cursor == null) {
                    wVResult.addData("isAuthed", "0");
                } else {
                    wVResult.addData("isAuthed", "1");
                }
                wVCallBackContext.success(wVResult);
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused2) {
                    }
                }
                return null;
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void choose(String str, WVCallBackContext wVCallBackContext) {
        this.mCallback = wVCallBackContext;
        Intent intent = new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
        Context context = this.mContext;
        if (context instanceof Activity) {
            try {
                ((Activity) context).startActivityForResult(intent, 4003);
            } catch (Exception e) {
                TaoLog.e("WVContacts", "open pick activity fail, " + e.getMessage());
                wVCallBackContext.error();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void find(java.lang.String r9, android.taobao.windvane.jsbridge.WVCallBackContext r10) {
        /*
            r8 = this;
            java.lang.String r0 = "phone"
            java.lang.String r1 = "name"
            java.lang.String r2 = "WVContacts"
            r3 = 0
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L21
            r4.<init>(r9)     // Catch: org.json.JSONException -> L21
            java.lang.String r5 = "filter"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch: org.json.JSONException -> L21
            if (r4 == 0) goto L1e
            java.lang.String r5 = r4.optString(r1)     // Catch: org.json.JSONException -> L21
            java.lang.String r9 = r4.optString(r0)     // Catch: org.json.JSONException -> L22
            goto L37
        L1e:
            r9 = r3
            r5 = r9
            goto L37
        L21:
            r5 = r3
        L22:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "find contacts when parse params to JSON error, params="
            r4.append(r6)
            r4.append(r9)
            java.lang.String r9 = r4.toString()
            android.taobao.windvane.util.TaoLog.e(r2, r9)
            r9 = r3
        L37:
            java.util.List r9 = r8.getPhoneContacts(r3, r5, r9)
            if (r9 != 0) goto L4b
            java.lang.String r9 = "find contacts failed"
            android.taobao.windvane.util.TaoLog.w(r2, r9)
            android.taobao.windvane.jsbridge.WVResult r9 = new android.taobao.windvane.jsbridge.WVResult
            r9.<init>()
            r10.error(r9)
            return
        L4b:
            android.taobao.windvane.jsbridge.WVResult r3 = new android.taobao.windvane.jsbridge.WVResult
            r3.<init>()
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>()
            java.util.Iterator r9 = r9.iterator()     // Catch: org.json.JSONException -> L78
        L59:
            boolean r5 = r9.hasNext()     // Catch: org.json.JSONException -> L78
            if (r5 == 0) goto L92
            java.lang.Object r5 = r9.next()     // Catch: org.json.JSONException -> L78
            android.taobao.windvane.jsbridge.api.WVContacts$ContactInfo r5 = (android.taobao.windvane.jsbridge.api.WVContacts.ContactInfo) r5     // Catch: org.json.JSONException -> L78
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: org.json.JSONException -> L78
            r6.<init>()     // Catch: org.json.JSONException -> L78
            java.lang.String r7 = r5.name     // Catch: org.json.JSONException -> L78
            r6.put(r1, r7)     // Catch: org.json.JSONException -> L78
            java.lang.String r5 = r5.number     // Catch: org.json.JSONException -> L78
            r6.put(r0, r5)     // Catch: org.json.JSONException -> L78
            r4.put(r6)     // Catch: org.json.JSONException -> L78
            goto L59
        L78:
            r9 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "put contacts error, "
            r0.append(r1)
            java.lang.String r9 = r9.getMessage()
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            android.taobao.windvane.util.TaoLog.e(r2, r9)
        L92:
            java.lang.String r9 = "contacts"
            r3.addData(r9, r4)
            r10.success(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.jsbridge.api.WVContacts.find(java.lang.String, android.taobao.windvane.jsbridge.WVCallBackContext):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d4 A[Catch: Exception -> 0x014a, all -> 0x0176, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0176, blocks: (B:22:0x00d4, B:29:0x00e5, B:30:0x00fd, B:32:0x0103, B:34:0x0111, B:37:0x0123, B:36:0x0117, B:50:0x0151), top: B:71:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e5 A[Catch: Exception -> 0x014a, all -> 0x0176, TRY_ENTER, TryCatch #4 {all -> 0x0176, blocks: (B:22:0x00d4, B:29:0x00e5, B:30:0x00fd, B:32:0x0103, B:34:0x0111, B:37:0x0123, B:36:0x0117, B:50:0x0151), top: B:71:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<android.taobao.windvane.jsbridge.api.WVContacts.ContactInfo> getPhoneContacts(java.lang.String r17, java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.jsbridge.api.WVContacts.getPhoneContacts(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, final String str2, final WVCallBackContext wVCallBackContext) {
        boolean z;
        if ("choose".equals(str)) {
            PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.READ_CONTACTS"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVContacts.2
                @Override // java.lang.Runnable
                public void run() {
                    WVThreadPool.getInstance().execute(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVContacts.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            WVContacts.this.choose(str2, wVCallBackContext);
                        }
                    });
                }
            }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVContacts.1
                @Override // java.lang.Runnable
                public void run() {
                    WVResult wVResult = new WVResult();
                    wVResult.addData("msg", AbstractC3893a.al);
                    wVCallBackContext.error(wVResult);
                }
            }).execute();
        } else if ("find".equals(str)) {
            PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.READ_CONTACTS"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVContacts.4
                @Override // java.lang.Runnable
                public void run() {
                    WVThreadPool.getInstance().execute(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVContacts.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            WVContacts.this.find(str2, wVCallBackContext);
                        }
                    });
                }
            }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVContacts.3
                @Override // java.lang.Runnable
                public void run() {
                    WVResult wVResult = new WVResult();
                    wVResult.addData("msg", AbstractC3893a.al);
                    wVCallBackContext.error(wVResult);
                }
            }).execute();
        } else if (!"authStatus".equals(str)) {
            return false;
        } else {
            try {
                z = new JSONObject(str2).optBoolean("autoAskAuth", true);
            } catch (JSONException unused) {
                TaoLog.e("WVContacts", "authStatus when parse params to JSON error, params=" + str2);
                z = true;
            }
            if (!z) {
                authStatus(wVCallBackContext);
                WVEventService.getInstance().onEvent(3014);
                return true;
            }
            PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.READ_CONTACTS"}).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVContacts.6
                @Override // java.lang.Runnable
                public void run() {
                    WVThreadPool.getInstance().execute(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVContacts.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            WVContacts.this.authStatus(wVCallBackContext);
                        }
                    });
                }
            }).setTaskOnPermissionDenied(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVContacts.5
                @Override // java.lang.Runnable
                public void run() {
                    WVResult wVResult = new WVResult();
                    wVResult.addData("msg", AbstractC3893a.al);
                    wVCallBackContext.error(wVResult);
                }
            }).execute();
        }
        WVEventService.getInstance().onEvent(3014);
        return true;
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onActivityResult(int i, int i2, Intent intent) {
        Uri data;
        if (i != 4003 || this.mCallback == null) {
            return;
        }
        if (i2 == -1) {
            if (intent != null && (data = intent.getData()) != null) {
                String lastPathSegment = data.getLastPathSegment();
                if (!TextUtils.isEmpty(lastPathSegment)) {
                    List<ContactInfo> phoneContacts = getPhoneContacts(lastPathSegment, null, null);
                    if (phoneContacts != null && !phoneContacts.isEmpty()) {
                        ContactInfo contactInfo = phoneContacts.get(0);
                        if (!TextUtils.isEmpty(contactInfo.number)) {
                            WVResult wVResult = new WVResult();
                            wVResult.addData("name", contactInfo.name);
                            wVResult.addData(KEY_PHONE, contactInfo.number);
                            this.mCallback.success(wVResult);
                            return;
                        }
                    } else {
                        TaoLog.w("WVContacts", "contact result is empty");
                        this.mCallback.error(new WVResult());
                        return;
                    }
                }
            } else {
                TaoLog.w("WVContacts", "contact data is null");
                return;
            }
        }
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVContacts", "choose contact failed");
        }
        this.mCallback.error(new WVResult());
    }
}
