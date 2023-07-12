package com.taomai.android.h5container.api;

import android.app.Application;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.pictures.uploader.UploadErrorCode;
import com.taobao.orange.util.FileUtil;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taomai.android.h5container.api.base.TaoMaiApiPlugin;
import com.uploader.export.ITaskResult;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.dv0;
import tb.k50;
import tb.q50;
import tb.uu2;
import tb.wt2;
import tb.yk2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¨\u0006\u0011"}, d2 = {"Lcom/taomai/android/h5container/api/TMPhotoUploadPlugin;", "Lcom/taomai/android/h5container/api/base/TaoMaiApiPlugin;", "", "params", "Landroid/taobao/windvane/jsbridge/WVCallBackContext;", WXBridgeManager.METHOD_CALLBACK, "Ltb/wt2;", TMPhotoUploadPlugin.ACTION_UPLOAD_PHOTO, "base64Data", "getBase64DataAsFile", "actionName", "", "execute", "<init>", "()V", "Companion", "a", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public final class TMPhotoUploadPlugin extends TaoMaiApiPlugin {
    @NotNull
    public static final String ACTION_UPLOAD_PHOTO = "uploadPhoto";
    @NotNull
    public static final String BRIDGE_NAME = "TMPhotoUpload";
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String TAG = "TMPhotoUploadPlugin";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class b extends q50 {
        final /* synthetic */ WVCallBackContext a;
        final /* synthetic */ Ref$ObjectRef b;

        b(WVCallBackContext wVCallBackContext, Ref$ObjectRef ref$ObjectRef) {
            this.a = wVCallBackContext;
            this.b = ref$ObjectRef;
        }

        @Override // tb.q50, com.alibaba.pictures.uploader.FileUploadListener
        public void onAllSuccess(@NotNull List<uu2> list) {
            String fileUrl;
            WVCallBackContext wVCallBackContext;
            b41.i(list, "uploadInfoGroup");
            boolean z = true;
            if (!list.isEmpty()) {
                ITaskResult d = list.get(0).d();
                if (d != null && (fileUrl = d.getFileUrl()) != null && (wVCallBackContext = this.a) != null) {
                    WVResult wVResult = WVResult.RET_SUCCESS;
                    wVResult.addData("data", fileUrl);
                    wt2 wt2Var = wt2.INSTANCE;
                    wVCallBackContext.success(wVResult);
                }
            } else {
                WVCallBackContext wVCallBackContext2 = this.a;
                if (wVCallBackContext2 != null) {
                    WVResult wVResult2 = WVResult.RET_FAIL;
                    wVResult2.addData("msg", "upload fail");
                    wt2 wt2Var2 = wt2.INSTANCE;
                    wVCallBackContext2.error(wVResult2);
                }
            }
            String str = (String) this.b.element;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (z) {
                return;
            }
            FileUtil.deleteConfigFile((String) this.b.element);
        }

        @Override // tb.q50, com.alibaba.pictures.uploader.FileUploadListener
        public void onFailure(@NotNull UploadErrorCode uploadErrorCode, @NotNull List<uu2> list) {
            b41.i(uploadErrorCode, "errorCode");
            b41.i(list, "uploadInfoGroup");
            WVCallBackContext wVCallBackContext = this.a;
            if (wVCallBackContext != null) {
                wVCallBackContext.error("msg", uploadErrorCode.toString());
            }
            String str = (String) this.b.element;
            if (str == null || str.length() == 0) {
                return;
            }
            FileUtil.deleteConfigFile((String) this.b.element);
        }
    }

    private final String getBase64DataAsFile(String str) {
        File filesDir;
        StringBuilder sb = new StringBuilder();
        Application application = yk2.a;
        sb.append((application == null || (filesDir = application.getFilesDir()) == null) ? null : filesDir.getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(TaoMaiFilePlugin.FILES_DIR);
        sb.append(str2);
        sb.append("sharedFiles");
        String sb2 = sb.toString();
        File file = new File(sb2);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(sb2 + str2 + System.currentTimeMillis());
        if (file2.exists()) {
            return null;
        }
        return dv0.c(str, file2);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045 A[Catch: all -> 0x00a2, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:10:0x0011, B:12:0x0027, B:19:0x0035, B:22:0x0045, B:24:0x004f, B:41:0x0077, B:46:0x0082, B:49:0x0089, B:32:0x005e, B:38:0x006a), top: B:57:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a A[Catch: all -> 0x00a2, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:10:0x0011, B:12:0x0027, B:19:0x0035, B:22:0x0045, B:24:0x004f, B:41:0x0077, B:46:0x0082, B:49:0x0089, B:32:0x005e, B:38:0x006a), top: B:57:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089 A[Catch: all -> 0x00a2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0009, B:10:0x0011, B:12:0x0027, B:19:0x0035, B:22:0x0045, B:24:0x004f, B:41:0x0077, B:46:0x0082, B:49:0x0089, B:32:0x005e, B:38:0x006a), top: B:57:0x0003 }] */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final synchronized void uploadPhoto(java.lang.String r8, android.taobao.windvane.jsbridge.WVCallBackContext r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            if (r8 == 0) goto La5
            com.alibaba.fastjson.JSONObject r8 = tb.kh2.a(r8)     // Catch: java.lang.Throwable -> La2
            if (r8 == 0) goto La5
            int r0 = r8.size()     // Catch: java.lang.Throwable -> La2
            if (r0 != 0) goto L11
            monitor-exit(r7)
            return
        L11:
            java.lang.String r0 = "dataURL"
            java.lang.String r0 = r8.getString(r0)     // Catch: java.lang.Throwable -> La2
            java.lang.String r1 = "localPath"
            java.lang.String r1 = r8.getString(r1)     // Catch: java.lang.Throwable -> La2
            java.lang.String r2 = "bizCode"
            java.lang.String r8 = r8.getString(r2)     // Catch: java.lang.Throwable -> La2
            r2 = 0
            r3 = 1
            if (r8 == 0) goto L30
            int r4 = r8.length()     // Catch: java.lang.Throwable -> La2
            if (r4 != 0) goto L2e
            goto L30
        L2e:
            r4 = 0
            goto L31
        L30:
            r4 = 1
        L31:
            if (r4 == 0) goto L45
            if (r9 == 0) goto L43
            android.taobao.windvane.jsbridge.WVResult r8 = android.taobao.windvane.jsbridge.WVResult.RET_PARAM_ERR     // Catch: java.lang.Throwable -> La2
            java.lang.String r0 = "msg"
            java.lang.String r1 = "bizCode cannot be null"
            r8.addData(r0, r1)     // Catch: java.lang.Throwable -> La2
            tb.wt2 r0 = tb.wt2.INSTANCE     // Catch: java.lang.Throwable -> La2
            r9.error(r8)     // Catch: java.lang.Throwable -> La2
        L43:
            monitor-exit(r7)
            return
        L45:
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch: java.lang.Throwable -> La2
            r4.<init>()     // Catch: java.lang.Throwable -> La2
            r5 = 0
            r4.element = r5     // Catch: java.lang.Throwable -> La2
            if (r1 == 0) goto L58
            int r6 = r1.length()     // Catch: java.lang.Throwable -> La2
            if (r6 != 0) goto L56
            goto L58
        L56:
            r6 = 0
            goto L59
        L58:
            r6 = 1
        L59:
            if (r6 != 0) goto L5c
            goto L75
        L5c:
            if (r0 == 0) goto L67
            int r1 = r0.length()     // Catch: java.lang.Throwable -> La2
            if (r1 != 0) goto L65
            goto L67
        L65:
            r1 = 0
            goto L68
        L67:
            r1 = 1
        L68:
            if (r1 != 0) goto L74
            java.lang.String r0 = r7.getBase64DataAsFile(r0)     // Catch: java.lang.Throwable -> La2
            r4.element = r0     // Catch: java.lang.Throwable -> La2
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> La2
            goto L75
        L74:
            r1 = r5
        L75:
            if (r1 == 0) goto L7d
            int r0 = r1.length()     // Catch: java.lang.Throwable -> La2
            if (r0 != 0) goto L7e
        L7d:
            r2 = 1
        L7e:
            if (r2 == 0) goto L89
            if (r9 == 0) goto L87
            android.taobao.windvane.jsbridge.WVResult r8 = android.taobao.windvane.jsbridge.WVResult.RET_PARAM_ERR     // Catch: java.lang.Throwable -> La2
            r9.error(r8)     // Catch: java.lang.Throwable -> La2
        L87:
            monitor-exit(r7)
            return
        L89:
            com.alibaba.pictures.uploader.FileUploader$a r0 = com.alibaba.pictures.uploader.FileUploader.Companion     // Catch: java.lang.Throwable -> La2
            com.alibaba.pictures.uploader.FileUploader r8 = r0.a(r8)     // Catch: java.lang.Throwable -> La2
            com.alibaba.pictures.uploader.FileUploader r8 = com.alibaba.pictures.uploader.FileUploader.A(r8, r5, r3, r5)     // Catch: java.lang.Throwable -> La2
            com.taomai.android.h5container.api.TMPhotoUploadPlugin$b r0 = new com.taomai.android.h5container.api.TMPhotoUploadPlugin$b     // Catch: java.lang.Throwable -> La2
            r0.<init>(r9, r4)     // Catch: java.lang.Throwable -> La2
            com.alibaba.pictures.uploader.FileUploader r8 = r8.C(r0)     // Catch: java.lang.Throwable -> La2
            r9 = 2
            com.alibaba.pictures.uploader.FileUploader.F(r8, r1, r5, r9, r5)     // Catch: java.lang.Throwable -> La2
            monitor-exit(r7)
            return
        La2:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        La5:
            monitor-exit(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taomai.android.h5container.api.TMPhotoUploadPlugin.uploadPhoto(java.lang.String, android.taobao.windvane.jsbridge.WVCallBackContext):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
        if (str != null && str.hashCode() == 1050794161 && str.equals(ACTION_UPLOAD_PHOTO)) {
            uploadPhoto(str2, wVCallBackContext);
            return true;
        }
        return false;
    }
}
