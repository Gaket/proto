package ru.innopolis.yorsogettingxbox.deals;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.innopolis.yorsogettingxbox.R;
import ru.innopolis.yorsogettingxbox.models.Deal;
import ru.innopolis.yorsogettingxbox.network.ApiFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;
import ru.innopolis.yorsogettingxbox.models.Deal;

public class DealsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_deals)
    RecyclerView recyclerDeals;
    @BindView(R.id.swipe_refresh_deals)
    SwipeRefreshLayout swipeRefreshDeals;
    @BindView(R.id.fab_deals)
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        Timber.d("Test");

        List<Deal> deals = new ArrayList<Deal>(){
            {
                add(new Deal());
                add(new Deal("Описание.pdf", true, 100));
            }
        };
        
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
        ApiFactory.getDealsApiService()
                .deals()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        deals -> {
                            for (Deal deal : deals) {
                                Timber.d(deals.toString());
                                Timber.d(deal.toString());
                            }
                        },
                        Timber::e,
                        () -> {
                            Timber.d("Data downloaded");
                        });
    }
}
