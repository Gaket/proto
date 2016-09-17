package ru.innopolis.yorsogettingxbox.documents;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import ru.innopolis.yorsogettingxbox.R;
import ru.innopolis.yorsogettingxbox.models.Document;

public class DocumentsAdapter extends RecyclerView.Adapter<DocumentsAdapter.DocumentViewHolder> {

    private List<Document> documents;
    private final LayoutInflater layoutInflater;

    public DocumentsAdapter(LayoutInflater layoutInflater) {
        this(layoutInflater, new ArrayList<Document>());
    }

    public DocumentsAdapter(LayoutInflater layoutInflater, List<Document> documents) {
        this.layoutInflater = layoutInflater;
        this.documents = documents;
    }

    @Override
    public DocumentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = layoutInflater.inflate(R.layout.item_document_layout, parent, false);
        return new DocumentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DocumentViewHolder holder, int position) {
        Document document = documents.get(position);

    }

    @Override
    public int getItemCount() {
        return documents.size();
    }

    public void setDocuments(List<Document> newDocuments){
        documents = newDocuments;
        notifyDataSetChanged();
    }

    public class DocumentViewHolder extends RecyclerView.ViewHolder {

        public DocumentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
