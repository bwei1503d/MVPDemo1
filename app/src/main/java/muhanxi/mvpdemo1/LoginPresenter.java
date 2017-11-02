package muhanxi.mvpdemo1;

import android.text.TextUtils;

/**
 * Created by muhanxi on 17/11/2.
 */

public class LoginPresenter {


    private LoginView loginView ;
    private LoginModel loginModel ;
    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
        loginModel = new LoginModel();
    }


    public void detach(){
        this.loginView = null;
    }




    public void login(String phone,String password){

        if(TextUtils.isEmpty(phone)){
            loginView.phoneEmpty();
            return;
        }

        if(TextUtils.isEmpty(password)){
            loginView.passwordEmpty();
            return;
        }


        loginModel.login(phone, password, new ModelCallBack() {
            @Override
            public void success(String data) {
                loginView.loginSuccess(data);

            }

            @Override
            public void failed(int code) {
                loginView.loginFailed(code);
            }
        });




    }

}
