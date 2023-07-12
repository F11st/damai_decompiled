package com.taobao.ma.qr.parser;

import com.taobao.ma.analyze.helper.MaAnalyzeHelper;
import com.taobao.ma.common.result.MaResult;
import com.taobao.ma.common.result.MaWapperResult;
import com.taobao.ma.parser.MaParSer;
import com.taobao.ma.qr.common.result.MaQrResult;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MaQrParSer extends MaParSer {
    @Override // com.taobao.ma.parser.MaParSer
    public MaResult decode(MaWapperResult maWapperResult) {
        if (MaAnalyzeHelper.isQrCode(maWapperResult.type, maWapperResult.maType, maWapperResult.subType)) {
            return new MaQrResult(maWapperResult.maType, maWapperResult.strCode, maWapperResult.xCorner, maWapperResult.yCorner, maWapperResult.x, maWapperResult.y, maWapperResult.width, maWapperResult.height);
        }
        return null;
    }
}
