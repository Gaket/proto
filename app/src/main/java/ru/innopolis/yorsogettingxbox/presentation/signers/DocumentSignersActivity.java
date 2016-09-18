package ru.innopolis.yorsogettingxbox.presentation.signers;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.innopolis.yorsogettingxbox.R;
import ru.innopolis.yorsogettingxbox.models.SignInfoEntity;
import ru.innopolis.yorsogettingxbox.models.SignerEntity;
import ru.innopolis.yorsogettingxbox.presentation.common.DividerItemDecoration;

public class DocumentSignersActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.signers_toolbar)
    Toolbar signersToolbar;
    @BindView(R.id.recycler_signers)
    RecyclerView recyclerSigners;
    @BindView(R.id.swipe_refresh_signers)
    SwipeRefreshLayout swipeRefreshSigners;
//    @BindView(R.id.signers_fab)
//    FloatingActionButton signers_fab;

    private DocumentSignersAdapter docSignersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_signers);
        ButterKnife.bind(this);
        setSupportActionBar(signersToolbar);

        List<SignInfoEntity> signers = new ArrayList<SignInfoEntity>() {
            {
                add(new SignInfoEntity(new SignerEntity("Smb1"), true));
                add(new SignInfoEntity(new SignerEntity("smb2"),false));
                add(new SignInfoEntity(new SignerEntity("smb3"),true));
            }
        };

        swipeRefreshSigners.setColorSchemeResources(R.color.primary, R.color.primary_dark, R.color.accent);

        docSignersAdapter = new DocumentSignersAdapter(this);
        recyclerSigners.setAdapter(docSignersAdapter);
        recyclerSigners.setLayoutManager(new LinearLayoutManager(this));
        recyclerSigners.setItemAnimator(new DefaultItemAnimator());
        recyclerSigners.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        swipeRefreshSigners.setOnRefreshListener(this);


    }

    @Override
    public void onRefresh() {

    }
}
