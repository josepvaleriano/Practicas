package test.valeriano.mx.empaquetado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import test.valeriano.mx.empaquetado.util.PreferenceUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*Declaración de variables*/
    private EditText mUser;
    private EditText mPassword;
    private View loading;
    private PreferenceUtil preferenceUtil;

    /* Actividad principal principal onCreate()*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUser = (EditText) findViewById(R.id.activity_main_user);
        mPassword = (EditText) findViewById(R.id.activity_main_password);
        findViewById(R.id.activity_main_btnLogin).setOnClickListener(
                (View.OnClickListener) this);
        loading = findViewById(R.id.progress);
    }


    /*Metodo para escuchar el onclick*/
    public void onClick(View v) {
        switch (v.getId())        {
            case R.id.activity_main_btnLogin:
                processLogin();
                break;
        }
    }

    private void processLogin() {

        String user = mUser.getText().toString();
        String password = mPassword.getText().toString();
        loading.setVisibility(View.VISIBLE);
        if(TextUtils.isEmpty(user)) {
            showError(R.string.login_empty);
        }
        else if(TextUtils.isEmpty(password)) {
            showError(R.string.password_empty);
        }
        else {
            validateLogin(user, password);
        }
        loading.setVisibility(View.INVISIBLE);
    }

    private void validateLogin(String user, String password) {
        if(user.equals("unam") && password.equals("curso")){
            Toast.makeText(getApplicationContext(),"Login",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),ActivityContent.class);
            intent.putExtra("key_user",user);
            startActivity(intent);
        }
        else {
            showError(R.string.wrong_credentials);
            mUser.setText("");
            mPassword.setText("");
        }
    }

    private void showError(int resourceString) {
        Toast.makeText(getApplicationContext(),resourceString,Toast.LENGTH_SHORT).show();
    }


}
