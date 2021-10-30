package lv.ievalauga.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button btnDialog;
    TextView chosenOption;
    List<String> list;
    //Saraksts satur visus iespejamos atbildes variantus
    String[] options;
    boolean[] checkedOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Starting.");

        //Poga, lai atvertu otru ekrānu
        Button btnNavToSecond = findViewById(R.id.btntoSecondScreen);
        btnNavToSecond.setOnClickListener(view -> {
            Log.d(TAG, "onClick: Clicked btnToSecondScreen.");

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        //DIALOGS
        btnDialog =  findViewById(R.id.btnopenDialog);
        chosenOption = findViewById(R.id.chosenOOption);
        options = getResources().getStringArray(R.array.choices);
        checkedOptions = new boolean[options.length];
        list = new ArrayList<>();
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Te sagramā atzīmētos
                //list = new ArrayList<>();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.dialogTitle);
                builder.setMultiChoiceItems(R.array.choices, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                       String[] arr= getResources().getStringArray(R.array.choices);
                       if(isChecked){
                               list.add(arr[position]);
                               Toast.makeText(MainActivity.this, arr[position]+ " checked",Toast.LENGTH_SHORT).show();
                       }else{
                           list.remove(arr[position]);
                           Toast.makeText(MainActivity.this, arr[position]+ " unchecked",Toast.LENGTH_SHORT).show();
                       }

                    }
                });

                builder.setCancelable(false);
                builder.setPositiveButton(R.string.btn_dialog_ok, new DialogInterface.OnClickListener()  {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {
                        Toast.makeText(MainActivity.this, R.string.btn_ok_toast,Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton(R.string.btn_dialog_close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, R.string.btn_close_toast,Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

}
