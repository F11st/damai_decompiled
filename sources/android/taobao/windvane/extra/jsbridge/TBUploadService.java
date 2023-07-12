package android.taobao.windvane.extra.jsbridge;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.WindVaneSDKForTB;
import android.taobao.windvane.cache.WVCacheManager;
import android.taobao.windvane.connect.HttpConnectListener;
import android.taobao.windvane.extra.WVIAdapter;
import android.taobao.windvane.extra.upload.UploadFileConnection;
import android.taobao.windvane.extra.upload.UploadFileData;
import android.taobao.windvane.file.FileManager;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.WVCamera;
import android.taobao.windvane.jsbridge.api.WVUploadService;
import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.thread.WVThreadPool;
import android.taobao.windvane.util.ImageTool;
import android.taobao.windvane.util.MimeTypeEnum;
import android.taobao.windvane.util.TaoLog;
import com.amap.api.maps.model.MyLocationStyle;
import com.taobao.weex.ui.view.gesture.WXGestureType;
import com.uploader.export.ITaskListener;
import com.uploader.export.ITaskResult;
import com.uploader.export.IUploaderTask;
import com.uploader.export.a;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mtopsdk.mtop.upload.FileUploadBaseListener;
import mtopsdk.mtop.upload.FileUploadMgr;
import mtopsdk.mtop.upload.domain.UploadFileInfo;
import tb.fl2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class TBUploadService extends WVUploadService implements Handler.Callback {
    private static final String LAST_PIC = "\"isLastPic\":\"true\"";
    private static final String MUTI_SELECTION = "\"mutipleSelection\":\"1\"";
    private static final int NOTIFY_ERROR = 2003;
    private static final int NOTIFY_FINISH = 2002;
    private static final int NOTIFY_START = 2001;
    private static final String TAG = "TBUploadService";
    private WVCallBackContext mCallback;
    private Handler mHandler;

    public TBUploadService() {
        this.mHandler = null;
        this.mHandler = new Handler(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doMtopUpload(final WVCamera.UploadParams uploadParams) {
        try {
            final File createTempFile = File.createTempFile("windvane", "." + MimeTypeEnum.JPG.getSuffix(), WVCacheManager.getInstance().getTempDir(true));
            if (!FileManager.copy(new File(uploadParams.filePath), createTempFile)) {
                WVResult wVResult = new WVResult();
                wVResult.addData(MyLocationStyle.ERROR_INFO, "Failed to copy file!");
                this.mCallback.error(wVResult);
                return;
            }
            final WVResult wVResult2 = new WVResult();
            try {
                a.a().uploadAsync(new IUploaderTask() { // from class: android.taobao.windvane.extra.jsbridge.TBUploadService.3
                    @Override // com.uploader.export.IUploaderTask
                    public String getBizType() {
                        return uploadParams.bizCode;
                    }

                    @Override // com.uploader.export.IUploaderTask
                    public String getFilePath() {
                        return createTempFile.getAbsolutePath();
                    }

                    @Override // com.uploader.export.IUploaderTask
                    public String getFileType() {
                        return ".jpg";
                    }

                    @Override // com.uploader.export.IUploaderTask
                    public Map<String, String> getMetaInfo() {
                        if (uploadParams.extraInfo == null) {
                            return null;
                        }
                        HashMap hashMap = new HashMap();
                        Iterator<String> keys = uploadParams.extraInfo.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, uploadParams.extraInfo.optString(next));
                        }
                        return hashMap;
                    }
                }, new ITaskListener() { // from class: android.taobao.windvane.extra.jsbridge.TBUploadService.4
                    @Override // com.uploader.export.ITaskListener
                    public void onCancel(IUploaderTask iUploaderTask) {
                    }

                    @Override // com.uploader.export.ITaskListener
                    public void onFailure(IUploaderTask iUploaderTask, fl2 fl2Var) {
                        wVResult2.addData("subCode", fl2Var.b);
                        wVResult2.addData("errorCode", fl2Var.a);
                        wVResult2.addData("errorMsg", fl2Var.c);
                        wVResult2.addData("localPath", uploadParams.filePath);
                        Message.obtain(TBUploadService.this.mHandler, 2003, wVResult2).sendToTarget();
                    }

                    @Override // com.uploader.export.ITaskListener
                    public void onPause(IUploaderTask iUploaderTask) {
                    }

                    @Override // com.uploader.export.ITaskListener
                    public void onProgress(IUploaderTask iUploaderTask, int i) {
                        String valueOf = String.valueOf(i);
                        TaoLog.e(TBUploadService.TAG, "uploadFile onProgress " + valueOf);
                    }

                    @Override // com.uploader.export.ITaskListener
                    public void onResume(IUploaderTask iUploaderTask) {
                    }

                    @Override // com.uploader.export.ITaskListener
                    public void onStart(IUploaderTask iUploaderTask) {
                    }

                    @Override // com.uploader.export.ITaskListener
                    public void onSuccess(IUploaderTask iUploaderTask, ITaskResult iTaskResult) {
                        Bitmap readZoomImage;
                        wVResult2.setSuccess();
                        wVResult2.addData("url", uploadParams.localUrl);
                        wVResult2.addData("localPath", uploadParams.filePath);
                        String fileUrl = iTaskResult.getFileUrl();
                        wVResult2.addData("resourceURL", fileUrl);
                        wVResult2.addData("isLastPic", String.valueOf(uploadParams.isLastPic));
                        wVResult2.addData("mutipleSelection", uploadParams.mutipleSelection);
                        WVCamera.UploadParams uploadParams2 = uploadParams;
                        if (uploadParams2.needBase64 && (readZoomImage = ImageTool.readZoomImage(uploadParams2.filePath, 1024)) != null) {
                            wVResult2.addData("base64Data", WVUtils.bitmapToBase64(readZoomImage));
                        }
                        int lastIndexOf = fileUrl.lastIndexOf("/") + 1;
                        if (lastIndexOf != 0) {
                            wVResult2.addData("tfsKey", fileUrl.substring(lastIndexOf));
                        }
                        WVCamera.UploadParams uploadParams3 = uploadParams;
                        if (uploadParams3.isLastPic) {
                            wVResult2.addData("images", uploadParams3.images);
                        }
                        Message.obtain(TBUploadService.this.mHandler, 2002, wVResult2).sendToTarget();
                    }

                    @Override // com.uploader.export.ITaskListener
                    public void onWait(IUploaderTask iUploaderTask) {
                    }
                }, this.mHandler);
                TaoLog.i(TAG, "do aus upload " + uploadParams.filePath);
            } catch (Throwable th) {
                TaoLog.w(TAG, "try aus upload error : " + th.getMessage());
                try {
                    UploadFileInfo uploadFileInfo = new UploadFileInfo();
                    uploadFileInfo.setFilePath(createTempFile.getAbsolutePath());
                    uploadFileInfo.setBizCode(uploadParams.bizCode);
                    uploadFileInfo.setPrivateData(uploadParams.extraData);
                    wVResult2.addData(WXGestureType.GestureInfo.POINTER_ID, uploadParams.identifier);
                    wVResult2.addData("isLastPic", String.valueOf(uploadParams.isLastPic));
                    wVResult2.addData("mutipleSelection", uploadParams.mutipleSelection);
                    FileUploadMgr.getInstance().addTask(uploadFileInfo, new FileUploadBaseListener() { // from class: android.taobao.windvane.extra.jsbridge.TBUploadService.5
                        public void onError(String str, String str2) {
                            if (TaoLog.getLogStatus()) {
                                TaoLog.w(TBUploadService.TAG, "mtop upload file error. code: " + str + ";msg: " + str2);
                            }
                            wVResult2.addData("errorCode", str);
                            wVResult2.addData("errorMsg", str2);
                            wVResult2.addData("localPath", uploadParams.filePath);
                            Message.obtain(TBUploadService.this.mHandler, 2003, wVResult2).sendToTarget();
                        }

                        public void onFinish(UploadFileInfo uploadFileInfo2, String str) {
                            Bitmap readZoomImage;
                            wVResult2.setSuccess();
                            wVResult2.addData("url", uploadParams.localUrl);
                            wVResult2.addData("localPath", uploadParams.filePath);
                            wVResult2.addData("resourceURL", str);
                            WVCamera.UploadParams uploadParams2 = uploadParams;
                            if (uploadParams2.needBase64 && (readZoomImage = ImageTool.readZoomImage(uploadParams2.filePath, 1024)) != null) {
                                wVResult2.addData("base64Data", WVUtils.bitmapToBase64(readZoomImage));
                            }
                            int lastIndexOf = str.lastIndexOf("/") + 1;
                            if (lastIndexOf != 0) {
                                wVResult2.addData("tfsKey", str.substring(lastIndexOf));
                            }
                            WVCamera.UploadParams uploadParams3 = uploadParams;
                            if (uploadParams3.isLastPic) {
                                wVResult2.addData("images", uploadParams3.images);
                            }
                            Message.obtain(TBUploadService.this.mHandler, 2002, wVResult2).sendToTarget();
                        }

                        public void onProgress(int i) {
                        }

                        public void onStart() {
                            wVResult2.setResult("");
                            Message.obtain(TBUploadService.this.mHandler, 2001, wVResult2).sendToTarget();
                        }

                        public void onError(String str, String str2, String str3) {
                            if (TaoLog.getLogStatus()) {
                                TaoLog.w(TBUploadService.TAG, "mtop upload file error. code: " + str2 + ";msg: " + str3 + ";type: " + str);
                            }
                            wVResult2.addData("errorType", str);
                            wVResult2.addData("errorCode", str2);
                            wVResult2.addData("errorMsg", str3);
                            wVResult2.addData("localPath", uploadParams.filePath);
                            Message.obtain(TBUploadService.this.mHandler, 2003, wVResult2).sendToTarget();
                        }

                        public void onFinish(String str) {
                            wVResult2.setSuccess();
                            wVResult2.addData("url", uploadParams.localUrl);
                            wVResult2.addData("localPath", uploadParams.filePath);
                            wVResult2.addData("resourceURL", str);
                            int lastIndexOf = str.lastIndexOf("/") + 1;
                            if (lastIndexOf != 0) {
                                wVResult2.addData("tfsKey", str.substring(lastIndexOf));
                            }
                            WVCamera.UploadParams uploadParams2 = uploadParams;
                            if (uploadParams2.isLastPic) {
                                wVResult2.addData("images", uploadParams2.images);
                            }
                            Message.obtain(TBUploadService.this.mHandler, 2002, wVResult2).sendToTarget();
                        }
                    }, uploadParams.needLogin);
                    TaoLog.i(TAG, "do mtop upload " + uploadParams.filePath);
                } catch (Throwable th2) {
                    TaoLog.e(TAG, "mtop sdk not exist." + th2.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doNormalUpload(final WVCamera.UploadParams uploadParams) {
        WVThreadPool.getInstance().execute(new UploadFileConnection(uploadParams.filePath, MimeTypeEnum.JPG.getSuffix(), new HttpConnectListener<UploadFileData>() { // from class: android.taobao.windvane.extra.jsbridge.TBUploadService.2
            @Override // android.taobao.windvane.connect.HttpConnectListener
            public void onError(int i, String str) {
                if (TaoLog.getLogStatus()) {
                    TaoLog.d(TBUploadService.TAG, "upload file error. code: " + i + ";msg: " + str);
                }
                WVResult wVResult = new WVResult();
                wVResult.addData("errorCode", Integer.valueOf(i));
                wVResult.addData("errorMsg", str);
                wVResult.addData("localPath", uploadParams.filePath);
                wVResult.addData("isLastPic", String.valueOf(uploadParams.isLastPic));
                wVResult.addData("mutipleSelection", uploadParams.mutipleSelection);
                Message obtain = Message.obtain();
                obtain.what = 2003;
                obtain.obj = wVResult;
                TBUploadService.this.mHandler.sendMessage(obtain);
            }

            @Override // android.taobao.windvane.connect.HttpConnectListener
            public void onStart() {
                TBUploadService.this.mHandler.sendEmptyMessage(2001);
            }

            @Override // android.taobao.windvane.connect.HttpConnectListener
            public void onFinish(UploadFileData uploadFileData, int i) {
                Bitmap readZoomImage;
                if (uploadFileData == null) {
                    return;
                }
                Message obtain = Message.obtain();
                obtain.what = 2002;
                WVResult wVResult = new WVResult();
                wVResult.setSuccess();
                WVCamera.UploadParams uploadParams2 = uploadParams;
                if (uploadParams2.needBase64 && (readZoomImage = ImageTool.readZoomImage(uploadParams2.filePath, 1024)) != null) {
                    wVResult.addData("base64Data", WVUtils.bitmapToBase64(readZoomImage));
                }
                wVResult.addData("url", uploadParams.localUrl);
                wVResult.addData("localPath", uploadParams.filePath);
                wVResult.addData("resourceURL", uploadFileData.resourceUri);
                wVResult.addData("isLastPic", String.valueOf(uploadParams.isLastPic));
                wVResult.addData("mutipleSelection", uploadParams.mutipleSelection);
                wVResult.addData("tfsKey", uploadFileData.tfsKey);
                WVCamera.UploadParams uploadParams3 = uploadParams;
                if (uploadParams3.isLastPic) {
                    wVResult.addData("images", uploadParams3.images);
                }
                obtain.obj = wVResult;
                TBUploadService.this.mHandler.sendMessage(obtain);
            }
        }));
    }

    @Override // android.taobao.windvane.jsbridge.api.WVUploadService
    public void doUpload(final WVCamera.UploadParams uploadParams, WVCallBackContext wVCallBackContext) {
        if (uploadParams == null) {
            TaoLog.d(TAG, "UploadParams is null.");
            wVCallBackContext.error(new WVResult());
            return;
        }
        this.mCallback = wVCallBackContext;
        try {
            String url = wVCallBackContext.getWebview().getUrl();
            AppMonitorUtil.commitOffMonitor(url, "TBUploadService bizCode:" + uploadParams.bizCode, uploadParams.v);
        } catch (Throwable unused) {
        }
        if ("2.0".equals(uploadParams.v)) {
            WVIAdapter wVIAdapter = WindVaneSDKForTB.wvAdapter;
            if (wVIAdapter != null) {
                wVIAdapter.getLoginInfo(null);
            }
            WVThreadPool.getInstance().execute(new Runnable() { // from class: android.taobao.windvane.extra.jsbridge.TBUploadService.1
                @Override // java.lang.Runnable
                public void run() {
                    TBUploadService.this.doMtopUpload(uploadParams);
                }
            });
            return;
        }
        doNormalUpload(uploadParams);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:17|(1:19)|20|(2:21|22)|(11:23|24|26|27|28|29|30|31|32|33|(2:35|36))|38|39|40|(1:42)|44|(1:46)(3:49|(1:(1:52)(1:53))|54)|47|48) */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00dd, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00de, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d9 A[Catch: JSONException -> 0x00dd, TRY_LEAVE, TryCatch #5 {JSONException -> 0x00dd, blocks: (B:48:0x00cb, B:50:0x00d9), top: B:78:0x00cb }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f1  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleMessage(android.os.Message r20) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.jsbridge.TBUploadService.handleMessage(android.os.Message):boolean");
    }
}
