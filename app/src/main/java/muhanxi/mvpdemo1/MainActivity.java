package muhanxi.mvpdemo1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity implements LoginView{


    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button login;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


//        this  代表 LoginView
        presenter = new LoginPresenter(this);







    }

    // 登陆按钮的点击事件
    @OnClick(R.id.login)
    public void onClick() {
        presenter.login(phone.getText().toString(),password.getText().toString());
    }

    @Override
    public void phoneEmpty() {

        Toast.makeText(this, "phone is empty", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void passwordEmpty() {
        Toast.makeText(this, "password is empty", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginSuccess(Object object) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "loginSuccess", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void loginFailed(int code) {
        Toast.makeText(this, "loginFailed", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        ／ 页面关闭  销毁 Presenter 中所持有的LoginView 对象
        presenter.detach();
    }
}
