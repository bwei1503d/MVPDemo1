package muhanxi.mvpdemo1;

import android.text.TextUtils;

/**
 * Created by muhanxi on 17/11/2.
 */

public class LoginPresenter {


    private LoginView loginView ;
    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
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





    }

}
