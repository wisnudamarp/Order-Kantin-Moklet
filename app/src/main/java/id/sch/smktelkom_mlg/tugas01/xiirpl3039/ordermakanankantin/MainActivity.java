package id.sch.smktelkom_mlg.tugas01.xiirpl3039.ordermakanankantin;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView tvHasil;
    EditText edNama, edKelas, edNo;
    Spinner spKantin;
    CheckBox cb11, cb12, cb21, cb22, cb23;
    RadioGroup rgMinum;
    String cbHasil1="";
    String cbHasil2="";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Kantin SMK Telkom Malang");
        getSupportActionBar().setSubtitle("Pesan Makan");

        edNama = (EditText) findViewById(R.id.editTextNama);
        edKelas = (EditText) findViewById(R.id.editTextKelas);
        edNo = (EditText) findViewById(R.id.editTextNo);
        spKantin = (Spinner) findViewById(R.id.spinnerKantin);
        cb11 = (CheckBox) findViewById(R.id.checkBoxNs);
        cb12 = (CheckBox) findViewById(R.id.checkBoxSy);
        cb21 = (CheckBox) findViewById(R.id.checkBoxTl);
        cb22 = (CheckBox) findViewById(R.id.checkBoxTm);
        cb23 = (CheckBox) findViewById(R.id.checkBoxTh);
        rgMinum = (RadioGroup) findViewById(R.id.radioGroupMinum);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);



    }

}
