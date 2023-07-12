package android.taobao.windvane.jsbridge.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.taobao.windvane.cache.WVCacheManager;
import android.taobao.windvane.cache.WVFileInfo;
import android.taobao.windvane.cache.WVFileInfoParser;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVCommonConfigData;
import android.taobao.windvane.file.FileManager;
import android.taobao.windvane.file.WVFileUtils;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVDeniedRunnable;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.util.CommonUtils;
import android.taobao.windvane.util.DigestUtils;
import android.taobao.windvane.util.EnvUtil;
import android.taobao.windvane.util.ImageTool;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.view.PopupWindowController;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.taobao.tao.remotebusiness.js.MtopJSBridge;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.view.gesture.WXGestureType;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import tb.h23;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVCamera extends WVApiPlugin {
    public static final String LOCAL_IMAGE = "//127.0.0.1/wvcache/photo.jpg?_wvcrc=1&t=";
    private static final String TAG = "WVCamera";
    public static int maxLength = 1024;
    private static String multiActivityClass;
    private static String uploadServiceClass;
    private UploadParams mParams;
    private PopupWindowController mPopupController;
    private WVUploadService uploadService;
    private WVCallBackContext mCallback = null;
    private String mLocalPath = null;
    private long lastAccess = 0;
    private boolean useCN = false;
    private String[] mPopupMenuTags = {"拍照", "从相册选择"};
    protected View.OnClickListener popupClickListener = new View.OnClickListener() { // from class: android.taobao.windvane.jsbridge.api.WVCamera.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WVCamera.this.mPopupController.hide();
            WVResult wVResult = new WVResult();
            if (WVCamera.this.mPopupMenuTags[0].equals(view.getTag())) {
                WVCamera.this.openCamara();
            } else if (WVCamera.this.mPopupMenuTags[1].equals(view.getTag())) {
                WVCamera.this.chosePhoto();
            } else {
                wVResult.addData("msg", "CANCELED_BY_USER");
                TaoLog.w("WVCamera", "take photo cancel, and callback.");
                WVCamera.this.mCallback.error(wVResult);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void chosePhoto() {
        String[] strArr;
        if (this.mParams.reducePermission) {
            WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
            if (wVCommonConfigData.fixCameraPermission) {
                WVCommonConfig.getInstance();
                if (wVCommonConfigData.reduceGalleryPermissionOfStorageWrite) {
                    strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
                } else {
                    strArr = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
                }
                PermissionProposer.buildPermissionTask(this.mContext, strArr).setTaskOnPermissionGranted(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVCamera.4
                    @Override // java.lang.Runnable
                    public void run() {
                        WVCamera.this.chosePhotoInternal();
                    }
                }).setTaskOnPermissionDenied(new WVDeniedRunnable(this.mCallback, AbstractC3893a.al)).execute();
                return;
            }
        }
        chosePhotoInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chosePhotoInternal() {
        Intent intent;
        int i;
        TaoLog.d("WVCamera", "start to pick photo from system album.");
        if ("1".equals(this.mParams.mutipleSelection)) {
            if (!this.mContext.getPackageName().equals("com.taobao.taobao")) {
                WVResult wVResult = new WVResult();
                wVResult.addData("msg", "mutipleSelection only support in taobao!");
                this.mCallback.error(wVResult);
                return;
            }
            intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("taobao://go/ImgFileListActivity"));
            intent.putExtra("maxSelect", this.mParams.maxSelect);
            i = 4003;
        } else {
            intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            i = 4002;
        }
        Context context = this.mContext;
        if (context instanceof Activity) {
            try {
                ((Activity) context).startActivityForResult(intent, i);
                Intent intent2 = new Intent("WVCameraFilter");
                intent2.putExtra("from-webview-id", this.mWebView.hashCode());
                LocalBroadcastManager.getInstance(GlobalConfig.context).sendBroadcast(intent2);
            } catch (Throwable th) {
                th.printStackTrace();
                WVResult wVResult2 = new WVResult();
                wVResult2.setResult("ERROR_STARTACTIVITY");
                wVResult2.addData("msg", "ERROR_STARTACTIVITY");
                this.mCallback.error(wVResult2);
            }
        }
    }

    private void initTakePhoto(WVCallBackContext wVCallBackContext, String str) {
        if (this.isAlive) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - this.lastAccess;
            this.lastAccess = currentTimeMillis;
            if (j < 1000) {
                TaoLog.w("WVCamera", "takePhoto, call this method too frequent,  " + j);
                return;
            }
            this.mCallback = wVCallBackContext;
            this.mParams = new UploadParams();
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.mParams.type = jSONObject.optInt("type", 1);
                this.mParams.mode = jSONObject.optString("mode");
                this.mParams.v = jSONObject.optString("v");
                this.mParams.bizCode = jSONObject.optString("bizCode");
                this.mParams.extraData = jSONObject.optString(h23.EXTRA_DATA_DIMEN);
                this.mParams.extraInfo = jSONObject.optJSONObject("extraInfo");
                this.mParams.identifier = jSONObject.optString(WXGestureType.GestureInfo.POINTER_ID);
                this.mParams.maxSelect = jSONObject.optInt("maxSelect");
                this.mParams.mutipleSelection = jSONObject.optString("mutipleSelection");
                this.mParams.needZoom = jSONObject.optBoolean("needZoom", true);
                UploadParams uploadParams = this.mParams;
                uploadParams.isLastPic = true;
                uploadParams.needLogin = jSONObject.optBoolean(MtopJSBridge.MtopJSParam.NEED_LOGIN, false);
                this.mParams.needBase64 = jSONObject.optBoolean("needBase64", false);
                this.mParams.reducePermission = jSONObject.optBoolean("reducePermission", GlobalConfig.getInstance().allowReducePermission());
                maxLength = jSONObject.optInt(Constants.Name.MAX_LENGTH, 1024);
                this.useCN = jSONObject.optBoolean("lang", false);
                if (jSONObject.has("localUrl")) {
                    this.mParams.localUrl = jSONObject.optString("localUrl");
                }
            } catch (Exception unused) {
                TaoLog.e("WVCamera", "takePhoto fail, params: " + str);
                WVResult wVResult = new WVResult();
                wVResult.setResult("HY_PARAM_ERR");
                wVResult.addData("msg", "PHOTO_INIT_ERROR ,params:" + str);
                this.mCallback.error(wVResult);
            }
        }
    }

    private boolean isHasCamaraPermission() {
        try {
            Camera.open().release();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openCamara() {
        if (this.mParams.reducePermission && WVCommonConfig.commonConfig.fixCameraPermission) {
            requestCameraPermission(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVCamera.3
                @Override // java.lang.Runnable
                public void run() {
                    WVCamera.this.openCamaraInternal();
                }
            }, new WVDeniedRunnable(this.mCallback, AbstractC3893a.al));
        } else {
            openCamaraInternal();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openCamaraInternal() {
        if (!isHasCamaraPermission()) {
            if (this.mCallback != null) {
                WVResult wVResult = new WVResult();
                wVResult.addData("msg", AbstractC3893a.al);
                this.mCallback.error(wVResult);
                return;
            }
            return;
        }
        TaoLog.d("WVCamera", "start to open system camera.");
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        UploadParams uploadParams = this.mParams;
        uploadParams.localUrl = "//127.0.0.1/wvcache/photo.jpg?_wvcrc=1&t=" + System.currentTimeMillis();
        String cacheDir = WVCacheManager.getInstance().getCacheDir(true);
        if (cacheDir == null) {
            if (this.mCallback != null) {
                WVResult wVResult2 = new WVResult();
                wVResult2.addData("msg", "NO_CACHEDIR");
                wVResult2.setResult("CAMERA_OPEN_ERROR");
                this.mCallback.error(wVResult2);
                return;
            }
            return;
        }
        File file = new File(cacheDir);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.mLocalPath = cacheDir + File.separator + DigestUtils.md5ToHex(this.mParams.localUrl);
        Uri fileUri = WVFileUtils.getFileUri(this.mContext, new File(this.mLocalPath));
        if (fileUri == null) {
            WVResult wVResult3 = new WVResult();
            wVResult3.addData("msg", "image uri is null,check provider auth");
            wVResult3.setResult("CAMERA_OPEN_ERROR");
            this.mCallback.error(wVResult3);
            return;
        }
        intent.putExtra("output", fileUri);
        intent.putExtra("from", this.mWebView.hashCode());
        Context context = this.mContext;
        if (context instanceof Activity) {
            try {
                ((Activity) context).startActivityForResult(intent, 4001);
            } catch (ActivityNotFoundException e) {
                TaoLog.e("WVCamera", "activity not found " + CommonUtils.getStackTrace(e));
            }
        }
        Intent intent2 = new Intent("WVCameraFilter");
        intent2.putExtra("from-webview-id", this.mWebView.hashCode());
        LocalBroadcastManager.getInstance(GlobalConfig.context).sendBroadcast(intent2);
    }

    public static void registerMultiActivity(Class<? extends Activity> cls) {
        if (cls != null) {
            multiActivityClass = cls.getName();
        }
    }

    public static void registerMultiActivityName(String str) {
        if (str != null) {
            multiActivityClass = str;
        }
    }

    public static void registerUploadService(Class<? extends WVUploadService> cls) {
        if (cls != null) {
            uploadServiceClass = cls.getName();
        }
    }

    private void requestCameraPermission(Runnable runnable, Runnable runnable2) {
        if (runnable == null || runnable2 == null) {
            return;
        }
        try {
            WVCommonConfig.getInstance();
            if (WVCommonConfig.commonConfig.reduceCameraPermissionOfStorage) {
                PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.CAMERA"}).setTaskOnPermissionGranted(runnable).setTaskOnPermissionDenied(runnable2).execute();
            } else {
                PermissionProposer.buildPermissionTask(this.mContext, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"}).setTaskOnPermissionGranted(runnable).setTaskOnPermissionDenied(runnable2).execute();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void takePhotoSuccess(String str, UploadParams uploadParams) {
        Bitmap readZoomImage;
        Bitmap readZoomImage2;
        if (uploadParams.type == 1) {
            String cacheDir = WVCacheManager.getInstance().getCacheDir(true);
            if (str != null && cacheDir != null && str.startsWith(cacheDir)) {
                uploadParams.filePath = str;
                upload(uploadParams);
                return;
            }
            WVResult wVResult = new WVResult();
            wVResult.setResult("PIC_PATH_ERROR");
            wVResult.addData("msg", "PIC_PATH_ERROR");
            this.mCallback.error(wVResult);
            return;
        }
        WVResult wVResult2 = new WVResult();
        wVResult2.setSuccess();
        if ("1".equals(uploadParams.mutipleSelection)) {
            if (!uploadParams.isLastPic) {
                return;
            }
            JSONArray jSONArray = uploadParams.images;
            if (jSONArray == null) {
                wVResult2.addData("url", uploadParams.localUrl);
                wVResult2.addData("localPath", str);
                if (uploadParams.needBase64 && (readZoomImage2 = ImageTool.readZoomImage(str, 1024)) != null) {
                    wVResult2.addData("base64Data", WVUtils.bitmapToBase64(readZoomImage2));
                }
            } else {
                wVResult2.addData("images", jSONArray);
            }
            this.mCallback.success(wVResult2);
        } else {
            wVResult2.addData("url", uploadParams.localUrl);
            wVResult2.addData("localPath", str);
            if (uploadParams.needBase64 && (readZoomImage = ImageTool.readZoomImage(str, 1024)) != null) {
                wVResult2.addData("base64Data", WVUtils.bitmapToBase64(readZoomImage));
            }
            TaoLog.d("WVCamera", "url:" + uploadParams.localUrl + " localPath:" + str);
            this.mCallback.success(wVResult2);
        }
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVCamera", "pic not upload and call success, retString: " + wVResult2.toJsonString());
        }
    }

    @SuppressLint({"NewApi"})
    private void zoomPicAndCallback(String str, final String str2, final UploadParams uploadParams) {
        final Bitmap bitmap;
        Bitmap bitmap2 = null;
        try {
            try {
                if (this.mParams.needZoom) {
                    int readRotationDegree = ImageTool.readRotationDegree(str);
                    Bitmap readZoomImage = ImageTool.readZoomImage(str, maxLength);
                    try {
                        if (readZoomImage == null) {
                            TaoLog.e("WVCamera", "bm == null, fail");
                            if (readZoomImage == null || readZoomImage.isRecycled()) {
                                return;
                            }
                            readZoomImage.recycle();
                            return;
                        }
                        bitmap = ImageTool.rotate(ImageTool.zoomBitmap(readZoomImage, maxLength), readRotationDegree);
                    } catch (Exception unused) {
                        bitmap2 = readZoomImage;
                        WVResult wVResult = new WVResult();
                        wVResult.addData("reason", "write photo io error.");
                        wVResult.setResult("WRITE_PHOTO_ERROR");
                        this.mCallback.error(wVResult);
                        TaoLog.e("WVCamera", "write photo io error.");
                        if (bitmap2 != null) {
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bitmap2 = readZoomImage;
                        if (bitmap2 != null) {
                            bitmap2.recycle();
                        }
                        throw th;
                    }
                } else {
                    if (!str2.equals(str)) {
                        File file = new File(str2);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        File file2 = new File(str);
                        if (!file2.exists()) {
                            WVResult wVResult2 = new WVResult();
                            wVResult2.addData("msg", "Failed to read file : " + str);
                            wVResult2.setResult("READ_FILE_ERROR");
                            this.mCallback.error(wVResult2);
                            return;
                        } else if (!FileManager.copy(file2, file)) {
                            WVResult wVResult3 = new WVResult();
                            wVResult3.addData("msg", "Failed to copy file!");
                            wVResult3.setResult("COPY_FILE_ERROR");
                            this.mCallback.error(wVResult3);
                            return;
                        }
                    }
                    bitmap = null;
                }
                try {
                    final WVFileInfo wVFileInfo = new WVFileInfo();
                    wVFileInfo.fileName = DigestUtils.md5ToHex(uploadParams.localUrl);
                    wVFileInfo.mimeType = "image/jpeg";
                    wVFileInfo.expireTime = System.currentTimeMillis() + WVFileInfoParser.DEFAULT_MAX_AGE;
                    if (TaoLog.getLogStatus()) {
                        TaoLog.d("WVCamera", "write pic to file, name: " + wVFileInfo.fileName);
                    }
                    AsyncTask.execute(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVCamera.6
                        @Override // java.lang.Runnable
                        public void run() {
                            WVResult wVResult4 = new WVResult();
                            if (bitmap != null) {
                                WVCacheManager.getInstance().writeToFile(wVFileInfo, new byte[]{0});
                                FileOutputStream fileOutputStream = null;
                                try {
                                    try {
                                        FileOutputStream fileOutputStream2 = new FileOutputStream(new File(WVCacheManager.getInstance().getCacheDir(true), wVFileInfo.fileName));
                                        try {
                                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                                            Bitmap bitmap3 = bitmap;
                                            if (bitmap3 != null && !bitmap3.isRecycled()) {
                                                bitmap.recycle();
                                            }
                                            try {
                                                fileOutputStream2.close();
                                            } catch (Exception unused2) {
                                            }
                                        } catch (Exception unused3) {
                                            fileOutputStream = fileOutputStream2;
                                            TaoLog.e("WVCamera", "fail to create bitmap file");
                                            wVResult4.addData("msg", "fail to create bitmap file");
                                            wVResult4.setResult("CREATE_BITMAP_ERROR");
                                            WVCamera.this.mCallback.error(wVResult4);
                                            Bitmap bitmap4 = bitmap;
                                            if (bitmap4 != null && !bitmap4.isRecycled()) {
                                                bitmap.recycle();
                                            }
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                    return;
                                                } catch (Exception unused4) {
                                                    return;
                                                }
                                            }
                                            return;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            fileOutputStream = fileOutputStream2;
                                            Bitmap bitmap5 = bitmap;
                                            if (bitmap5 != null && !bitmap5.isRecycled()) {
                                                bitmap.recycle();
                                            }
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Exception unused6) {
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                            WVCamera.this.takePhotoSuccess(str2, uploadParams);
                            wVResult4.setSuccess();
                            wVResult4.addData("url", uploadParams.localUrl);
                            wVResult4.addData("localPath", str2);
                            TaoLog.d("WVCamera", "url:" + uploadParams.localUrl + " localPath:" + str2);
                            WVCamera.this.mCallback.fireEvent("WVPhoto.Event.takePhotoSuccess", wVResult4.toJsonString());
                        }
                    });
                } catch (Exception unused2) {
                    bitmap2 = bitmap;
                    WVResult wVResult4 = new WVResult();
                    wVResult4.addData("reason", "write photo io error.");
                    wVResult4.setResult("WRITE_PHOTO_ERROR");
                    this.mCallback.error(wVResult4);
                    TaoLog.e("WVCamera", "write photo io error.");
                    if (bitmap2 != null || bitmap2.isRecycled()) {
                        return;
                    }
                    bitmap2.recycle();
                } catch (Throwable th2) {
                    th = th2;
                    bitmap2 = bitmap;
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        bitmap2.recycle();
                    }
                    throw th;
                }
            } catch (Exception unused3) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public synchronized void confirmUploadPhoto(WVCallBackContext wVCallBackContext, String str) {
        this.mCallback = wVCallBackContext;
        UploadParams uploadParams = new UploadParams();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(AbstractC3893a.V);
            uploadParams.identifier = jSONObject.optString(WXGestureType.GestureInfo.POINTER_ID);
            uploadParams.v = jSONObject.optString("v");
            uploadParams.bizCode = jSONObject.optString("bizCode");
            uploadParams.extraInfo = jSONObject.optJSONObject("extraInfo");
            String cacheDir = WVCacheManager.getInstance().getCacheDir(true);
            if (string != null && cacheDir != null && string.startsWith(cacheDir)) {
                uploadParams.filePath = string;
                upload(uploadParams);
            } else {
                wVCallBackContext.error(new WVResult("HY_PARAM_ERR"));
            }
        } catch (Exception e) {
            TaoLog.e("WVCamera", "confirmUploadPhoto fail, params: " + str);
            WVResult wVResult = new WVResult();
            wVResult.setResult("HY_PARAM_ERR");
            wVResult.addData("msg", "PARAM_ERROR :" + e.getMessage());
            wVCallBackContext.error(wVResult);
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, final String str2, final WVCallBackContext wVCallBackContext) {
        if ("takePhoto".equals(str)) {
            try {
                if (!WVCommonConfig.commonConfig.fixCameraPermission) {
                    requestCameraPermission(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVCamera.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ((WVApiPlugin) WVCamera.this).isAlive = true;
                            WVCamera.this.takePhoto(wVCallBackContext, str2);
                        }
                    }, new WVDeniedRunnable(wVCallBackContext, AbstractC3893a.al));
                } else {
                    this.isAlive = true;
                    initTakePhoto(wVCallBackContext, str2);
                    if (this.mParams.reducePermission) {
                        takePhoto(wVCallBackContext, str2);
                    } else {
                        requestCameraPermission(new Runnable() { // from class: android.taobao.windvane.jsbridge.api.WVCamera.2
                            @Override // java.lang.Runnable
                            public void run() {
                                ((WVApiPlugin) WVCamera.this).isAlive = true;
                                WVCamera.this.takePhoto(wVCallBackContext, str2);
                            }
                        }, new WVDeniedRunnable(wVCallBackContext, AbstractC3893a.al));
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } else if (!"confirmUploadPhoto".equals(str)) {
            return false;
        } else {
            confirmUploadPhoto(wVCallBackContext, str2);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0194, code lost:
        if (r7 == null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0196, code lost:
        r7.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01b5, code lost:
        if (r7 == null) goto L77;
     */
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r17, int r18, android.content.Intent r19) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.jsbridge.api.WVCamera.onActivityResult(int, int, android.content.Intent):void");
    }

    public synchronized void takePhoto(WVCallBackContext wVCallBackContext, String str) {
        View peekDecorView;
        if (!WVCommonConfig.commonConfig.fixCameraPermission) {
            initTakePhoto(wVCallBackContext, str);
        }
        Context context = this.mContext;
        if ((context instanceof Activity) && (peekDecorView = ((Activity) context).getWindow().peekDecorView()) != null) {
            ((InputMethodManager) this.mContext.getSystemService("input_method")).hideSoftInputFromWindow(peekDecorView.getWindowToken(), 0);
        }
        if ("camera".equals(this.mParams.mode)) {
            openCamara();
        } else if ("photo".equals(this.mParams.mode)) {
            chosePhoto();
        } else {
            try {
                if (!EnvUtil.isCN() && !this.useCN) {
                    String[] strArr = this.mPopupMenuTags;
                    strArr[0] = "Take pictures";
                    strArr[1] = "Select from album";
                }
                if (this.mPopupController == null) {
                    this.mPopupController = new PopupWindowController(this.mContext, this.mWebView.getView(), this.mPopupMenuTags, this.popupClickListener);
                }
                this.mPopupController.show();
            } catch (Exception e) {
                TaoLog.w("WVCamera", e.getMessage());
            }
        }
    }

    public void takePhotoPlus(WVCallBackContext wVCallBackContext, String str, String str2) {
        if (wVCallBackContext != null && str != null && str2 != null) {
            initTakePhoto(wVCallBackContext, str2);
            this.mLocalPath = str;
            zoomPicAndCallback(str, str, this.mParams);
            return;
        }
        TaoLog.e("WVCamera", "takePhotoPlus fail, params error");
    }

    protected void upload(UploadParams uploadParams) {
        String str;
        if (this.uploadService == null && (str = uploadServiceClass) != null) {
            try {
                Class<?> cls = Class.forName(str);
                if (WVUploadService.class.isAssignableFrom(cls)) {
                    WVUploadService wVUploadService = (WVUploadService) cls.newInstance();
                    this.uploadService = wVUploadService;
                    wVUploadService.initialize(this.mContext, this.mWebView);
                }
            } catch (Exception e) {
                TaoLog.e("WVCamera", "create upload service error: " + uploadServiceClass + ". " + e.getMessage());
            }
        }
        WVUploadService wVUploadService2 = this.uploadService;
        if (wVUploadService2 != null) {
            wVUploadService2.doUpload(uploadParams, this.mCallback);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class UploadParams {
        public String bizCode;
        public String extraData;
        public JSONObject extraInfo;
        public String filePath;
        public String identifier;
        public JSONArray images;
        public boolean isLastPic;
        public String localUrl;
        public int maxSelect;
        public String mode;
        public String mutipleSelection;
        public boolean needBase64;
        public boolean needLogin;
        public boolean needZoom;
        public boolean reducePermission;
        public int type;
        public String v;

        public UploadParams() {
            this.identifier = "";
            this.mode = "both";
            this.mutipleSelection = "0";
            this.maxSelect = 9;
            this.isLastPic = true;
            this.needZoom = true;
            this.needLogin = false;
            this.images = null;
            this.needBase64 = false;
            this.reducePermission = false;
        }

        public UploadParams(UploadParams uploadParams) {
            this.identifier = "";
            this.mode = "both";
            this.mutipleSelection = "0";
            this.maxSelect = 9;
            this.isLastPic = true;
            this.needZoom = true;
            this.needLogin = false;
            this.images = null;
            this.needBase64 = false;
            this.reducePermission = false;
            this.filePath = uploadParams.filePath;
            this.localUrl = uploadParams.localUrl;
            this.type = uploadParams.type;
            this.v = uploadParams.v;
            this.bizCode = uploadParams.bizCode;
            this.extraData = uploadParams.extraData;
            this.identifier = uploadParams.identifier;
            this.mode = uploadParams.mode;
            this.mutipleSelection = uploadParams.mutipleSelection;
            this.maxSelect = uploadParams.maxSelect;
            this.isLastPic = uploadParams.isLastPic;
            this.images = uploadParams.images;
            this.needZoom = uploadParams.needZoom;
            this.needLogin = uploadParams.needLogin;
            this.needBase64 = uploadParams.needBase64;
            this.reducePermission = uploadParams.reducePermission;
        }
    }
}
