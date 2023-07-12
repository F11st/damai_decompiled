package com.youku.playerservice.axp.playinfo.request.task;

import android.content.Context;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.network.INetworkTask;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class MockTask implements INetworkTask {
    private ConnectStat connectStat = new ConnectStat();
    private Context mContext;

    public MockTask(Context context) {
        this.mContext = context;
    }

    private static String file2String(Context context, String str) {
        try {
            FileReader fileReader = new FileReader(new File(context.getApplicationContext().getExternalFilesDir(null), str));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            LineNumberReader lineNumberReader = new LineNumberReader(bufferedReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = lineNumberReader.readLine();
                if (readLine == null) {
                    lineNumberReader.close();
                    bufferedReader.close();
                    fileReader.close();
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.youku.upsplayer.network.INetworkTask
    public GetInfoResult getData(RequestData requestData) {
        String file2String = file2String(this.mContext, "get.json");
        ConnectStat connectStat = this.connectStat;
        connectStat.connect_success = true;
        return new GetInfoResult(file2String, null, connectStat);
    }

    public String getR1() {
        return file2String(this.mContext, "r1.json");
    }
}
