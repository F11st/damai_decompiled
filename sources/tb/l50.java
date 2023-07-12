package tb;

import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.alibaba.pictures.dolores.transfer.IDataTransformerFactory;
import com.alibaba.pictures.dolores.transfer.IRemoteDataTransformer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.playerservice.axp.playinfo.Point;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class l50 implements IDataTransformerFactory {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.alibaba.pictures.dolores.transfer.IDataTransformerFactory
    @NotNull
    public <BizResponse> IRemoteDataTransformer<BizResponse> createDataTransformer(@Nullable DoloresRequest<BizResponse> doloresRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-436959147")) {
            return (IRemoteDataTransformer) ipChange.ipc$dispatch("-436959147", new Object[]{this, doloresRequest});
        }
        String markRequestLabel = doloresRequest != null ? doloresRequest.markRequestLabel() : null;
        if (markRequestLabel != null) {
            switch (markRequestLabel.hashCode()) {
                case -1425371906:
                    if (markRequestLabel.equals("shawshank")) {
                        return new ip2();
                    }
                    break;
                case -1335396889:
                    if (markRequestLabel.equals("dengta")) {
                        return new sf2();
                    }
                    break;
                case 66857:
                    if (markRequestLabel.equals("CMS")) {
                        return new sf2();
                    }
                    break;
                case 115060:
                    if (markRequestLabel.equals("tpp")) {
                        return new hp2();
                    }
                    break;
                case 95349688:
                    if (markRequestLabel.equals("damai")) {
                        return new sf2();
                    }
                    break;
                case 1312628413:
                    if (markRequestLabel.equals(Point.STANDARD)) {
                        return new sf2();
                    }
                    break;
            }
        }
        return new sf2();
    }
}
