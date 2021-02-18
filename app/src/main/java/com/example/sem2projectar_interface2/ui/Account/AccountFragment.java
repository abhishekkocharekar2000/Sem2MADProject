package com.example.sem2projectar_interface2.ui.Account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sem2projectar_interface2.R;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.concurrent.Executor;

public class AccountFragment extends Fragment {

    GoogleSignInClient googleSignInClient;
    private AccountViewModel accountViewModel;
    private Button b;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        accountViewModel =
                ViewModelProviders.of(this).get(AccountViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        b = root.findViewById(R.id.button2);

        return root;


    }
    private void signOut() {
        googleSignInClient.signOut()
                .addOnCompleteListener((Executor) this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(getContext(),"Signout Successful",Toast.LENGTH_SHORT).show();
                    }
                });
    }
}