package com.alibaba.motu.tbrest.rest;

import android.content.Context;
import com.alibaba.motu.tbrest.SendService;
import com.alibaba.motu.tbrest.data.RestData;
import com.alibaba.motu.tbrest.data.RestDataBlocks;
import com.alibaba.motu.tbrest.data.RestDataQueue;
import com.alibaba.motu.tbrest.data.RestOrangeConfigure;
import com.alibaba.motu.tbrest.logger.LoggerAdapter;
import com.alibaba.motu.tbrest.request.BizRequest;
import com.alibaba.motu.tbrest.rest.RestSender;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class RestBlockHandler {
    private static final String TAG = "RestBlockHandler";
    private static final Executor dataThread = Executors.newSingleThreadExecutor();
    private final RestOrangeConfigure configure = RestOrangeConfigure.instance();
    private final RestDataBlocks dataBlocks = new RestDataBlocks();
    private final RestSender restSender = new RestSender();
    private final RestDataQueue<RestData> retryDataQueue = new RestDataQueue<>(100);
    private final Random random = new Random();
    private int succeedCount = 0;
    private int failedCount = 0;

    private boolean isNeedUpdate(int i) {
        return this.random.nextFloat() < this.configure.getSampleByEventID(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSendFailed(final RestData restData) {
        dataThread.execute(new Runnable() { // from class: com.alibaba.motu.tbrest.rest.RestBlockHandler.3
            @Override // java.lang.Runnable
            public void run() {
                RestData restData2 = (RestData) RestBlockHandler.this.retryDataQueue.push(restData);
                if (restData2 != null) {
                    int count = restData2.getCount();
                    RestBlockHandler.this.failedCount += count;
                    LoggerAdapter.log("fail", "totalCount", Integer.valueOf(RestBlockHandler.this.failedCount), "currentCount", Integer.valueOf(count));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSendSucceed(final RestData restData) {
        dataThread.execute(new Runnable() { // from class: com.alibaba.motu.tbrest.rest.RestBlockHandler.4
            @Override // java.lang.Runnable
            public void run() {
                int count = restData.getCount();
                RestBlockHandler.this.succeedCount += count;
                LoggerAdapter.log("success", "totalCount", Integer.valueOf(RestBlockHandler.this.succeedCount), "currentCount", Integer.valueOf(count));
                RestData restData2 = (RestData) RestBlockHandler.this.retryDataQueue.poll();
                if (restData2 != null) {
                    RestBlockHandler.this.restSender.sendRestDataAsync(restData2, new RestSender.Callback() { // from class: com.alibaba.motu.tbrest.rest.RestBlockHandler.4.1
                        @Override // com.alibaba.motu.tbrest.rest.RestSender.Callback
                        public void onFailed(RestData restData3) {
                            RestBlockHandler.this.onSendFailed(restData3);
                        }

                        @Override // com.alibaba.motu.tbrest.rest.RestSender.Callback
                        public void onSuccess(RestData restData3) {
                            RestBlockHandler.this.onSendSucceed(restData3);
                        }
                    });
                }
            }
        });
    }

    private byte[] packageRequest(String str, Context context, Map<String, String> map) {
        try {
            return BizRequest.getPackRequest(str, context, map);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendDataBlock(RestDataBlocks.RestDataBlock restDataBlock, Context context) {
        byte[] packageRequest = packageRequest(restDataBlock.getAppKey(), context, restDataBlock.data());
        if (packageRequest != null) {
            this.restSender.sendRestDataAsync(new RestData(restDataBlock.getAppKey(), restDataBlock.getUrl(), restDataBlock.getContextCount(), packageRequest), new RestSender.Callback() { // from class: com.alibaba.motu.tbrest.rest.RestBlockHandler.2
                @Override // com.alibaba.motu.tbrest.rest.RestSender.Callback
                public void onFailed(RestData restData) {
                    RestBlockHandler.this.onSendFailed(restData);
                }

                @Override // com.alibaba.motu.tbrest.rest.RestSender.Callback
                public void onSuccess(RestData restData) {
                    RestBlockHandler.this.onSendSucceed(restData);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendAllCacheData() {
        dataThread.execute(new Runnable() { // from class: com.alibaba.motu.tbrest.rest.RestBlockHandler.5
            @Override // java.lang.Runnable
            public void run() {
                for (RestDataBlocks.RestDataBlock restDataBlock : RestBlockHandler.this.dataBlocks.getAll().values()) {
                    RestBlockHandler.this.sendDataBlock(restDataBlock, SendService.getInstance().context);
                }
                RestBlockHandler.this.dataBlocks.clear();
            }
        });
    }

    public boolean sendAsyncInfo(final int i, final String str, final Context context, final String str2, final String str3) {
        if (isNeedUpdate(i)) {
            dataThread.execute(new Runnable() { // from class: com.alibaba.motu.tbrest.rest.RestBlockHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    RestDataBlocks.RestDataBlock createBlockIfNotExist = RestBlockHandler.this.dataBlocks.createBlockIfNotExist(str, str2);
                    createBlockIfNotExist.appendData(String.valueOf(i), str3);
                    if (createBlockIfNotExist.dataSize() >= RestBlockHandler.this.configure.getDataSize() || createBlockIfNotExist.getContextCount() >= RestBlockHandler.this.configure.getMessageCount()) {
                        RestBlockHandler.this.sendDataBlock(createBlockIfNotExist, context);
                        RestBlockHandler.this.dataBlocks.removeBlockIfExist(str, str2);
                    }
                }
            });
            return true;
        }
        return false;
    }
}
