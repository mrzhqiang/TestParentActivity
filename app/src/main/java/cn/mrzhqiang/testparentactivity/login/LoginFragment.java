package cn.mrzhqiang.testparentactivity.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.mrzhqiang.testparentactivity.R;


public class LoginFragment extends Fragment {

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Button btnReLogin = (Button) view.findViewById(R.id.btn_login);
        final String mobile = getActivity().getIntent().getStringExtra("mobile");
        if (!TextUtils.isEmpty(mobile)) {
            btnReLogin.setText(mobile);
        }

        btnReLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new CardLoginFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
