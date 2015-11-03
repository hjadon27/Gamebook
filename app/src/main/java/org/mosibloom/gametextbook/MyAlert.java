package org.mosibloom.gametextbook;

/**
 * Created by narendra on 11/4/2015.
 */
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;



/**
 * Created by narendra on 11/3/2015.
 *
 */
public class MyAlert extends DialogFragment {



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

        /*alert.setTitle("Want to exit? :(");
        alert.setMessage("Are you sure you want to exit?");*/
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_alert, null);


        alert.setView(view);

        ImageView no = (ImageView)view.findViewById(R.id.noButton);


        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onDestroyView();
            }
        });

        ImageView yes = (ImageView)view.findViewById(R.id.yesButton);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        Dialog dialog = alert.create();

        return dialog;
        //alert.show();
    }

}

