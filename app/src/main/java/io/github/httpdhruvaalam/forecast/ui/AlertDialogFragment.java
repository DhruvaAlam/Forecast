package io.github.httpdhruvaalam.forecast.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

import io.github.httpdhruvaalam.forecast.R;

/**
 * Created by naqib on 4/27/2016.
 */
public class AlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //getActivity() passes in the context from the other class
        //that this dialog fragment is created in
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.error_title)//title of dialog
        .setMessage(R.string.error_message)
        .setPositiveButton(R.string.error_ok_button, null); //null does nothing when ok is clicked, but onclicklistener can be set to do something
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
