package ru.innopolis.yorsogettingxbox.presentation.newdeal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.innopolis.yorsogettingxbox.R;
import timber.log.Timber;

public class AddingDealActivity extends AppCompatActivity {

    @BindView(R.id.new_title)
    EditText title;
    @BindView(R.id.new_description)
    EditText description;
    @BindView(R.id.submit)
    Button submit;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_deal);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else {
            Timber.e("Action bar is null");
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submit = new Intent();
                submit.putExtra("title",title.getText().toString());
                submit.putExtra("description",description.getText().toString());
                setResult(RESULT_OK,submit);
                finish();
            }
        });
    }
}
