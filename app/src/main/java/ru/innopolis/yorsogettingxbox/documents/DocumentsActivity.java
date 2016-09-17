package ru.innopolis.yorsogettingxbox.documents;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.innopolis.yorsogettingxbox.R;
import ru.innopolis.yorsogettingxbox.common.DividerItemDecoration;
import ru.innopolis.yorsogettingxbox.models.Document;

public class DocumentsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recycler_documents)
    RecyclerView recyclerDocuments;
    @BindView(R.id.swipe_refresh_documents)
    SwipeRefreshLayout swipeRefreshDocuments;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documents);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        List<Document> documents = new ArrayList<Document>() {
            {
                add(new Document("Договор", true, 20));
                add(new Document("Свидетельство", true, 100));
                add(new Document("Очень важная бумажка", true, 20));
            }
        };

        recyclerDocuments.setAdapter(new DocumentsAdapter(getLayoutInflater(), documents));
        recyclerDocuments.setLayoutManager(new LinearLayoutManager(this));
        recyclerDocuments.setItemAnimator(new DefaultItemAnimator());
        recyclerDocuments.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }


    @OnClick(R.id.fab)
    void addDocument(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

}
