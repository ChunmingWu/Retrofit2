package lotcom.zhpan.idea.net.common;


import io.reactivex.Observable;
import lotcom.zhpan.idea.net.token.RefreshTokenResponse;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by zhpan on 2017/4/1.
 */

public interface CommonService {
    @Streaming
    @GET
    Observable<ResponseBody> download(@Url String url);

    @GET("refresh_token")
    Observable<RefreshTokenResponse> refreshToken();
}
