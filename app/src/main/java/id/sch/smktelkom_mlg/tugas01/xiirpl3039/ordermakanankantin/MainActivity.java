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


        kondisiawal();
        findViewById(R.id.buttonPesan).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                proses();
            }
        });
    }

    private void kondisiawal()
    {
        edNama.setText("");
        edKelas.setText("");
        edNo.setText("");
        cb11.setChecked(false);
        cb12.setChecked(false);
        cb21.setChecked(false);
        cb22.setChecked(false);
        cb23.setChecked(false);
        rgMinum.clearCheck();
        spKantin.setSelection(0);
        cbHasil1="";
        cbHasil2="";
    }

    private void proses()
    {
        if(isValid())
        {
            String nm = edNama.getText().toString();
            String kls = edKelas.getText().toString();
            String nab = edNo.getText().toString();
            int stratlen1 = cbHasil1.length();
            int stratlen2 = cbHasil2.length();
            String irb;

            if (cb11.isChecked()) cbHasil1 += "\t- "+ cb11.getText() +"\n";
            if (cb12.isChecked()) cbHasil1 += "\t- "+ cb12.getText() +"\n";
            if (cb21.isChecked()) cbHasil2 += "\t- "+ cb21.getText() +"\n";
            if (cb22.isChecked()) cbHasil2 += "\t- "+ cb22.getText() +"\n";
            if (cb23.isChecked()) cbHasil2 += "\t- "+ cb23.getText() +"\n";
            if (cbHasil1.length()==stratlen1)
            {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Anda harus memesan makanan!!");
                builder1.setCancelable(true);

                builder1.setNeutralButton(
                        "Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                                //startActivity(new Intent(CourseActivity.this, MainActivity.class));
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
            if (cbHasil2.length()==stratlen2) cbHasil2+= "Tidak memilih Lauk";

            if (rgMinum.getCheckedRadioButtonId()!= -1)
            {
                RadioButton rb = (RadioButton) findViewById(rgMinum.getCheckedRadioButtonId());
                irb = rb.getText().toString();
            }
            else
            {
                irb = null;
            }

            if (irb == null)
            {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("Anda harus memesan minuman!!");
                builder1.setCancelable(true);

                builder1.setNeutralButton(
                        "Ok",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                                //startActivity(new Intent(CourseActivity.this, MainActivity.class));
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
            else
            {
                tvHasil.setText("-> Siswa yang memesan di kantin : \n\t- Nama\t\t\t: "+ nm +"\n\t- Kelas\t\t\t: "+ kls + "\n\t- No Absen\t: "+ nab
                        + "\n-> Pesan di "+ spKantin.getSelectedItem().toString()+"\n-> Memesan Makan : \n"+ cbHasil1 +"-> Dengan Lauk :\n"+ cbHasil2
                        +"-> dan juga memesan "+ irb+" ");
                kondisiawal();
            }
        }
    }

    private boolean isValid()
    {
        boolean valid = true;

        String nm = edNama.getText().toString();
        String kls = edKelas.getText().toString();
        String nab = edNo.getText().toString();


        if (nm.isEmpty())
        {
            edNama.setError("Nama belum diisi");
            valid =false;
        }
        else if (nm.length()<5)
        {
            edNama.setError("Nama Minimal 5 karakter");
            valid =false;
        }
        else
        {
            edNama.setError(null);
        }

        if (kls.isEmpty())
        {
            edKelas.setError("Kelas belum diisi");
            valid =false;
        }
        else if (kls.length() <= 5)
        {
            edKelas.setError("Format kelas harus kkkjjjnn");
            valid =false;
        }
        else
        {
            edKelas.setError(null);
        }

        if (nab.isEmpty())
        {
            edNo.setError("No harus di isi");
            valid =false;
        }
        else if (nab.length() != 2)
        {
            edNo.setError("Format no harus nn");
            valid =false;
        }
        else
        {
            edNo.setError(null);
        }

        return  valid;
    }

}
