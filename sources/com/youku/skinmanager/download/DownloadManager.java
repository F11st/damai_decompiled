package com.youku.skinmanager.download;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.youku.analytics.AnalyticsAgent;
import com.youku.skinmanager.SkinManager;
import com.youku.skinmanager.entity.SkinDTO;
import com.youku.skinmanager.utils.FileUtils;
import com.youku.skinmanager.utils.Utils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DownloadManager {
    public static final int DOWN_FAIL = 4;
    public static final int DOWN_START = 1;
    public static final int DOWN_SUCCESS = 3;
    public static final int DOWN_UPDATE = 2;
    private static final String SKIN_SAVE_COMMON_DIRECTORY_NAME = "common/";
    private static final String SKIN_SAVE_ZIP_FILE_NAME = "skin.zip";
    public static final String TAG = "DownloadManager_skin";
    public static final String URL_EXTRA = "url_extra";
    private static DownloadManager instance;
    private IDownloadListener mDownloadListener;
    private DownloadThread mDownloadThread;
    private String mFinalDownloadPath;
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.youku.skinmanager.download.DownloadManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 3) {
                if (i != 4) {
                    return;
                }
                Log.d(DownloadManager.TAG, "get handler fail msg");
                if (DownloadManager.this.mSkinDto != null) {
                    if (DownloadManager.this.mDownloadListener != null) {
                        DownloadManager.this.mDownloadListener.onFail(DownloadManager.this.mSkinDto);
                    }
                    DownloadManager.this.sendData(0);
                }
                DownloadManager.this.clear();
                return;
            }
            DownloadManager.this.mFinalDownloadPath = message.getData().getString(AbstractC3893a.V);
            Log.d(DownloadManager.TAG, "get handler success msg, " + DownloadManager.this.mFinalDownloadPath);
            SkinManager.getInstance().loadSkin(DownloadManager.this.mSkinDto, DownloadManager.this.mFinalDownloadPath, null);
            if (DownloadManager.this.mSkinDto != null) {
                if (DownloadManager.this.mDownloadListener != null) {
                    DownloadManager.this.mDownloadListener.onSuccess(DownloadManager.this.mSkinDto);
                }
                DownloadManager.this.sendData(1);
            }
            DownloadManager.this.clear();
        }
    };
    private SkinDTO mSkinDto;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class DownloadThread extends Thread {
        boolean isCancel = false;
        private int progress;
        private String skinUrl;

        public DownloadThread(String str) {
            this.skinUrl = str;
        }

        private void download() {
            FileOutputStream fileOutputStream;
            InputStream inputStream;
            int read;
            Log.d(DownloadManager.TAG, "skin download thread start");
            File createZipFile = DownloadManager.this.createZipFile();
            if (createZipFile == null) {
                Log.d(DownloadManager.TAG, "skin file is null");
                return;
            }
            Log.d(DownloadManager.TAG, "service download file created" + createZipFile.getAbsolutePath());
            BufferedOutputStream bufferedOutputStream = null;
            try {
                try {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.skinUrl).openConnection();
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(10000);
                        httpURLConnection.connect();
                        int contentLength = httpURLConnection.getContentLength();
                        long availableInternalMemorySize = Utils.getAvailableInternalMemorySize();
                        if (contentLength > availableInternalMemorySize) {
                            Log.d(DownloadManager.TAG, "service download fail length = " + contentLength + " availableMemorySize is " + availableInternalMemorySize);
                            DownloadManager.this.mHandler.sendEmptyMessage(4);
                        } else if (contentLength > 0) {
                            DownloadManager.this.mHandler.sendEmptyMessage(1);
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                fileOutputStream = new FileOutputStream(createZipFile);
                                try {
                                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                                    try {
                                        byte[] bArr = new byte[1024];
                                        int i = 0;
                                        while (!this.isCancel && (read = inputStream.read(bArr)) != -1) {
                                            bufferedOutputStream2.write(bArr, 0, read);
                                            i += read;
                                            int i2 = (int) ((i / contentLength) * 100.0f);
                                            if (i2 > this.progress) {
                                                this.progress = i2;
                                                Log.d(DownloadManager.TAG, "service download loop update " + this.progress);
                                            }
                                        }
                                        bufferedOutputStream2.close();
                                        fileOutputStream.close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (this.isCancel) {
                                            Log.d(DownloadManager.TAG, "skin download cancel");
                                            if (createZipFile.exists()) {
                                                Log.d(DownloadManager.TAG, "skin download cancel delete file");
                                                createZipFile.delete();
                                            }
                                        } else if (i >= contentLength) {
                                            Log.d(DownloadManager.TAG, this.skinUrl);
                                            String unZipFolder = FileUtils.unZipFolder(createZipFile.getAbsolutePath(), createZipFile.getParent());
                                            if (TextUtils.isEmpty(unZipFolder)) {
                                                DownloadManager.this.mHandler.sendEmptyMessage(4);
                                            } else {
                                                Bundle bundle = new Bundle();
                                                bundle.putString(AbstractC3893a.V, unZipFolder);
                                                Message obtainMessage = DownloadManager.this.mHandler.obtainMessage();
                                                obtainMessage.what = 3;
                                                obtainMessage.setData(bundle);
                                                DownloadManager.this.mHandler.sendMessage(obtainMessage);
                                            }
                                        }
                                        bufferedOutputStream2.close();
                                        fileOutputStream.close();
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (MalformedURLException e) {
                                        e = e;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        Log.d(DownloadManager.TAG, "service download fail MalformedURLException" + e.getMessage());
                                        e.printStackTrace();
                                        DownloadManager.this.mHandler.sendEmptyMessage(4);
                                        if (bufferedOutputStream != null) {
                                            bufferedOutputStream.close();
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (IOException e2) {
                                        e = e2;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        Log.d(DownloadManager.TAG, "service download fail IOException" + e.getMessage());
                                        e.printStackTrace();
                                        DownloadManager.this.mHandler.sendEmptyMessage(4);
                                        if (bufferedOutputStream != null) {
                                            bufferedOutputStream.close();
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        Log.d(DownloadManager.TAG, "service download fail Exception" + e.getMessage());
                                        e.printStackTrace();
                                        DownloadManager.this.mHandler.sendEmptyMessage(4);
                                        if (bufferedOutputStream != null) {
                                            bufferedOutputStream.close();
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        bufferedOutputStream = bufferedOutputStream2;
                                        if (bufferedOutputStream != null) {
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (IOException e4) {
                                                e4.printStackTrace();
                                                throw th;
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        throw th;
                                    }
                                } catch (MalformedURLException e5) {
                                    e = e5;
                                } catch (IOException e6) {
                                    e = e6;
                                } catch (Exception e7) {
                                    e = e7;
                                }
                            } catch (MalformedURLException e8) {
                                e = e8;
                                fileOutputStream = null;
                            } catch (IOException e9) {
                                e = e9;
                                fileOutputStream = null;
                            } catch (Exception e10) {
                                e = e10;
                                fileOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = null;
                            }
                        } else {
                            Log.d(DownloadManager.TAG, "service download fail length = " + contentLength);
                            DownloadManager.this.mHandler.sendEmptyMessage(4);
                        }
                    } catch (MalformedURLException e11) {
                        e = e11;
                        inputStream = null;
                        fileOutputStream = null;
                    } catch (IOException e12) {
                        e = e12;
                        inputStream = null;
                        fileOutputStream = null;
                    } catch (Exception e13) {
                        e = e13;
                        inputStream = null;
                        fileOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                        fileOutputStream = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (IOException e14) {
                e14.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            download();
        }
    }

    private DownloadManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clear() {
        this.mDownloadThread = null;
        this.mSkinDto = null;
        this.mFinalDownloadPath = null;
        this.mDownloadListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File createZipFile() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(getDirectory(SkinManager.sContext));
            sb.append(System.currentTimeMillis());
            String str = File.separator;
            sb.append(str);
            File file = new File(sb.toString());
            FileUtils.deleteFiles(file, (File) null);
            file.mkdirs();
            File file2 = new File(file.getAbsolutePath() + str + SKIN_SAVE_ZIP_FILE_NAME);
            file2.createNewFile();
            return file2;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, TAG, e);
            return null;
        }
    }

    public static synchronized DownloadManager getInstance() {
        DownloadManager downloadManager;
        synchronized (DownloadManager.class) {
            if (instance == null) {
                instance = new DownloadManager();
            }
            downloadManager = instance;
        }
        return downloadManager;
    }

    private String getRealUrl(SkinDTO skinDTO) {
        return skinDTO.getAndroidNewUrl();
    }

    private boolean isDownLoading() {
        DownloadThread downloadThread = this.mDownloadThread;
        return downloadThread != null && downloadThread.isAlive();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendData(int i) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("state", "" + i);
        hashMap.put("skinID", this.mSkinDto.getId());
        AnalyticsAgent.utCustomEvent("page_skinshop", 19999, "skinstate", (String) null, (String) null, hashMap);
    }

    public String getCurrentSkinPath() {
        return this.mFinalDownloadPath;
    }

    public String getDirectory(Context context) {
        return context.getFilesDir() + "/skin/" + SKIN_SAVE_COMMON_DIRECTORY_NAME;
    }

    public SkinDTO getDownloadingDto(IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            this.mDownloadListener = iDownloadListener;
        }
        return this.mSkinDto;
    }

    public void startDownload(SkinDTO skinDTO, IDownloadListener iDownloadListener) {
        if (skinDTO == null) {
            Log.d(TAG, "dto is null");
            return;
        }
        String realUrl = getRealUrl(skinDTO);
        if (TextUtils.isEmpty(realUrl)) {
            Log.d(TAG, "url is empty");
            if (iDownloadListener != null) {
                iDownloadListener.onFail(skinDTO);
                return;
            }
            return;
        }
        if (iDownloadListener != null) {
            this.mDownloadListener = iDownloadListener;
        }
        if (isDownLoading()) {
            SkinDTO skinDTO2 = this.mSkinDto;
            if (skinDTO2 != null && skinDTO2.getId().equalsIgnoreCase(skinDTO.getId())) {
                Log.d(TAG, "the same skin id, return");
                return;
            } else {
                Log.d(TAG, "is downloading now, cancel");
                this.mDownloadThread.isCancel = true;
            }
        }
        this.mSkinDto = skinDTO;
        DownloadThread downloadThread = new DownloadThread(realUrl);
        this.mDownloadThread = downloadThread;
        downloadThread.start();
        Log.d(TAG, "start download thread ---");
    }
}
