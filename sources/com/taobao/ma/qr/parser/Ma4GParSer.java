package com.taobao.ma.qr.parser;

import android.util.Base64;
import com.taobao.ma.analyze.helper.MaAnalyzeHelper;
import com.taobao.ma.common.result.MaResult;
import com.taobao.ma.common.result.MaWapperResult;
import com.taobao.ma.parser.MaParSer;
import com.taobao.ma.qr.common.result.Ma4GResult;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Ma4GParSer extends MaParSer {
    @Override // com.taobao.ma.parser.MaParSer
    public MaResult decode(MaWapperResult maWapperResult) {
        if (MaAnalyzeHelper.is4GCode(maWapperResult.type, maWapperResult.maType, maWapperResult.subType)) {
            return new Ma4GResult(maWapperResult.maType, maWapperResult.strCode, Base64.encodeToString(maWapperResult.decodeBytes, 0));
        }
        return null;
    }
}
