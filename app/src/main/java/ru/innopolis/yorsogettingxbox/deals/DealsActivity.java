package ru.innopolis.yorsogettingxbox.deals;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.net.UnknownHostException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.innopolis.yorsogettingxbox.R;
import ru.innopolis.yorsogettingxbox.models.Deal;
import ru.innopolis.yorsogettingxbox.repository.RepositoryProvider;
import timber.log.Timber;

public class DealsActivity extends AppCompatActivity {

    @BindView(R.id.fab)
    FloatingActionButton fab;

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        Timber.d("Test");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_deals, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    void addDocument(View view) {
        Timber.d("Button pressed");
        i++;
        if (i % 2 == 0) {
            RepositoryProvider.provideDataRepository().getDeals()
                    .subscribe(
                            deals -> {for (Deal deal : deals) {Timber.d(deal.toString());}}
                    );

        } else {
            RepositoryProvider.provideDataRepository().putDeal(new Deal("ss", "ff"))
                    .subscribe(
                            deal -> {
                                Timber.d("On next item");
                                Timber.d(deal.toString());
                            },
                            throwable -> {
                                if (throwable instanceof UnknownHostException) {
                                    showError("Check your wi-fi connection");
                                } else Timber.e(throwable);
                            },
                            () -> {
                                Timber.d("Data downloaded");
                            });
        }
    }

    void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
