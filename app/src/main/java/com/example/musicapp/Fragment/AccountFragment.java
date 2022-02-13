package com.example.musicapp.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.musicapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button login, register;
    private EditText username, password;
    String ten, mk;


    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_account, container, false);
        login = v.findViewById(R.id.login_btn);
        register = v.findViewById(R.id.register_btn);
        username = v.findViewById(R.id.et_user);
        password = v.findViewById(R.id.et_pw);
        controlButton();

        return v;
    }

    private void controlButton() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdialog);

                final EditText dkuser = (EditText) dialog.findViewById(R.id.et_dk_user);
                final EditText dkpwd = (EditText) dialog.findViewById(R.id.et_dk_pw);
                Button cancel = (Button) dialog.findViewById(R.id.cancel_btn);
                Button agree = (Button) dialog.findViewById(R.id.agree_btn);

                agree.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten = dkuser.getText().toString().trim();
                        mk = dkpwd.getText().toString().trim();

                        username.setText(ten);
                        password.setText(mk);

                        dialog.cancel();
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
                dialog.show();

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().length() != 0 && password.getText().length() != 0) {
                    if (username.getText().toString().equals(ten) && password.getText().toString().equals(mk)) {
                        Toast.makeText(getContext(), "Ban da dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    } else if (username.getText().toString().equals("hai") && password.getText().toString().equals("123")) {
                        Toast.makeText(getContext(), "Ban da dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Ban da dang nhap that bai", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(getContext(), "Ban khong nhap du thong tin", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}