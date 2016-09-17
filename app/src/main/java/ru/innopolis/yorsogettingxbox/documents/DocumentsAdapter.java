package ru.innopolis.yorsogettingxbox.documents;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.numberprogressbar.NumberProgressBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.innopolis.yorsogettingxbox.R;
import ru.innopolis.yorsogettingxbox.models.Document;

public class DocumentsAdapter extends RecyclerView.Adapter<DocumentsAdapter.DocumentViewHolder> {


    private List<Document> documents;
    private final LayoutInflater layoutInflater;
    private final Context context;

    public DocumentsAdapter(Activity activity) {
        this(activity, new ArrayList<Document>());
    }

    public DocumentsAdapter(Activity activity, List<Document> documents) {
        this.context = activity;
        this.documents = documents;
        this.layoutInflater = activity.getLayoutInflater();
    }

    @Override
    public DocumentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = layoutInflater.inflate(R.layout.item_document_layout, parent, false);
        return new DocumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DocumentViewHolder holder, int position) {
        Document document = documents.get(position);
        holder.viewDocumentName.setText(document.getName());
        holder.numberProgressBar.setProgress(document.getPercentDone());
//        int resId = (document.isChainStatus()) ? R.drawable.ic_check_circle_black_24dp : R.drawable.ic_remove_circle_black_24dp;
//        holder.documentStatus.setImageResource(resId);
        holder.viewDocumentBlockchain.setText(
                document.isChainStatus() ? R.string.text_in_blockchain : R.string.text_not_in_bllockchain);
    }

    @Override
    public int getItemCount() {
        return documents.size();
    }

    public void setDocuments(List<Document> newDocuments) {
        documents = newDocuments;
        notifyDataSetChanged();
    }

    public class DocumentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_document_name)
        TextView viewDocumentName;
        @BindView(R.id.text_document_blockchain)
        TextView viewDocumentBlockchain;
        @BindView(R.id.number_progress_bar)
        NumberProgressBar numberProgressBar;
//        @BindView(R.id.image_document_status)
//        ImageView documentStatus;

        public DocumentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
