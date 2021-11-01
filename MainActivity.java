package lv.lauris.pd2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button act2Button, dialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        act2Button=findViewById(R.id.button0);
        act2Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent activity2Intent = new Intent(getApplicationContext(), Act2.class);
                startActivity(activity2Intent);
            }
        });

        dialogButton=findViewById(R.id.button1);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogs = new DialogFragment();
                dialogs.show(getSupportFragmentManager(),"dialogs");
            }
        });

    }
}