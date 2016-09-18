package ru.innopolis.yorsogettingxbox.presentation.signers;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.innopolis.yorsogettingxbox.R;
import ru.innopolis.yorsogettingxbox.models.SignerEntity;
import ru.innopolis.yorsogettingxbox.presentation.documents.DocumentsAdapter;

/**
 * Created by enspa on 18.09.2016.
 */
public class DocumentSignersAdapter extends RecyclerView.Adapter<DocumentSignersAdapter.DocumentSignersViewHolder> {
    private List<SignerEntity> signers;
    private final LayoutInflater layoutInflater;
    private final Context context;

    public DocumentSignersAdapter(Activity activity){this(activity,new ArrayList<SignerEntity>());}

    public DocumentSignersAdapter(Activity activity, List<SignerEntity> signers) {
        this.context = activity;
        this.signers = signers;
        this.layoutInflater = activity.getLayoutInflater();
    }

    @Override
    public DocumentSignersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = layoutInflater.inflate(R.layout.item_document_layout, parent, false);
        return new DocumentSignersViewHolder(view);
    }


    public void onBindViewHolder(DocumentSignersAdapter.DocumentSignersViewHolder holder, int position) {
        SignerEntity signer = signers.get(position);


    }

    @Override
    public int getItemCount() {
        return signers.size();
    }

    public void setSigner(List<SignerEntity> newSigner){
        signers = newSigner;
        notifyDataSetChanged();
    }

    public class DocumentSignersViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.signer_name)
        TextView signerName;
        @BindView(R.id.signs)
        TextView signs;


        DocumentSignersViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);

        }

    }
}
