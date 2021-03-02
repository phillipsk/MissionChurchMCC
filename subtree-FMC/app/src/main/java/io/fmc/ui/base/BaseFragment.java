package io.fmc.ui.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dagger.hilt.android.AndroidEntryPoint;
import io.fmc.R;

/**
 * Created by  Kevin Phillips and Sunday Akinsete on 16/05/2018.
 */

@AndroidEntryPoint
public class BaseFragment extends Fragment {

    ProgressDialog progressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }



    public void showLoading(String message){
        progressDialog = ProgressDialog.show(getContext(),null,message,false,false);
    }

    public void hideLaoding(){
        if(progressDialog != null){
            if(progressDialog.isShowing()){
                progressDialog.cancel();
            }
        }
    }

    public void showMessage(String message, DialogInterface.OnClickListener positiveListener, DialogInterface.OnClickListener negativeListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(null);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.ok,positiveListener);
        builder.setPositiveButton(R.string.cancel,negativeListener);
        builder.create().show();
    }

    public void showMessage(String message, DialogInterface.OnClickListener positiveListener){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(null);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.ok,positiveListener);
        builder.create().show();
    }


}
