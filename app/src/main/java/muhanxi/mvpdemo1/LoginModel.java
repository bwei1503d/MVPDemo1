package muhanxi.mvpdemo1;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by muhanxi on 17/11/2.
 */

public class LoginModel {





    public void login(String phone, String password, final ModelCallBack callBack){


        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody body = new FormBody.Builder()
                .add("pscid","39")
                .add("page","1")
                .build();
        Request request = new Request.Builder().url("http://120.27.23.105/product/getProducts")
                .post(body)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.failed(1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {


                String result = response.body().string() ;

//                callBack 接口回调 到presenter
                callBack.success(result);





            }
        });





    }




}
