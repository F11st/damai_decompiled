package cn.damai.musicfestival.model;

import android.text.TextUtils;
import android.util.Pair;
import cn.damai.musicfestival.bean.AtmosphereBean;
import cn.damai.musicfestival.bean.AtmosphereShell;
import cn.damai.tetris.DMMtopWarningListener;
import cn.damai.tetris.componentplugin.OnBizListener;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.tetris.core.NodeData;
import cn.damai.tetris.core.mtop.BaseResponse;
import cn.damai.tetris.request.TetrisRequest;
import cn.damai.tetris.v2.common.ContainerArg;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.cb2;
import tb.e11;
import tb.m61;
import tb.mu0;
import tb.xl2;
import tb.y13;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class MusicFestivalModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private ContainerArg mArg;

    /* JADX INFO: Access modifiers changed from: private */
    public AtmosphereBean getAtmosphere(BaseResponse baseResponse) {
        AtmosphereShell atmosphereShell;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1397779872")) {
            return (AtmosphereBean) ipChange.ipc$dispatch("1397779872", new Object[]{this, baseResponse});
        }
        if (baseResponse != null) {
            ArrayList<BaseLayer> arrayList = baseResponse.layers;
            if (!cb2.d(arrayList)) {
                Iterator<BaseLayer> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    List<BaseSection> sections = it.next().getSections();
                    if (!cb2.d(sections)) {
                        for (BaseSection baseSection : sections) {
                            if (TextUtils.equals(xl2.MUSIC_FESTIVAL_MAP_COMPONENT_ID, baseSection.getComponentId())) {
                                NodeData item = baseSection.getItem();
                                if (item != null && (atmosphereShell = (AtmosphereShell) m61.d(item, AtmosphereShell.class)) != null) {
                                    return atmosphereShell.atmosphere;
                                }
                            }
                        }
                        continue;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r7v0, types: [int] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.InputStream] */
    public static String read(int i) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        IpChange ipChange = $ipChange;
        ?? r1 = "-2120354269";
        if (AndroidInstantRuntime.support(ipChange, "-2120354269")) {
            return (String) ipChange.ipc$dispatch("-2120354269", new Object[]{Integer.valueOf((int) i)});
        }
        try {
            try {
                i = mu0.a().getResources().openRawResource(i);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e) {
                    e = e;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    r1 = 0;
                    th = th2;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (i != 0) {
                        try {
                            i.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                i = 0;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                r1 = 0;
                th = th3;
                i = 0;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = i.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                String str = new String(byteArrayOutputStream.toByteArray());
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
                try {
                    i.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                return str;
            } catch (Exception e7) {
                e = e7;
                e.printStackTrace();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                if (i != 0) {
                    try {
                        i.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public void load(final OnBizListener<Pair<BaseResponse, AtmosphereBean>> onBizListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1863717757")) {
            ipChange.ipc$dispatch("1863717757", new Object[]{this, onBizListener});
            return;
        }
        TetrisRequest tetrisRequest = new TetrisRequest(new MusicFestivalParams(1, this.mArg));
        TetrisRequest.overrideParams(tetrisRequest, this.mArg);
        tetrisRequest.request(new DMMtopWarningListener<BaseResponse>(BaseResponse.class, tetrisRequest.toJsonString()) { // from class: cn.damai.musicfestival.model.MusicFestivalModel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onFailWithWarning(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1390363844")) {
                    ipChange2.ipc$dispatch("-1390363844", new Object[]{this, str, str2});
                    return;
                }
                onBizListener.onFail(str, str2);
                if (e11.b().c(str) || MusicFestivalModel.this.mArg == null) {
                    return;
                }
                y13.d("mtop.damai.mec.aristotle.get", str, "首屏加载失败:" + str2 + " " + MusicFestivalModel.this.mArg.patternName + " " + MusicFestivalModel.this.mArg.patternVersion);
            }

            @Override // cn.damai.tetris.DMMtopWarningListener
            public void onSuccessWithWarning(BaseResponse baseResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1453616254")) {
                    ipChange2.ipc$dispatch("-1453616254", new Object[]{this, baseResponse});
                } else {
                    onBizListener.onSuccess(new Pair(baseResponse, MusicFestivalModel.this.getAtmosphere(baseResponse)));
                }
            }
        });
    }

    public void setArg(ContainerArg containerArg) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1338339466")) {
            ipChange.ipc$dispatch("-1338339466", new Object[]{this, containerArg});
        } else {
            this.mArg = containerArg;
        }
    }
}
