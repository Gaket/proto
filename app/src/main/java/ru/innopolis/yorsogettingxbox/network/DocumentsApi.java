package ru.innopolis.yorsogettingxbox.network;

import java.util.List;

import retrofit2.http.GET;
import ru.innopolis.yorsogettingxbox.models.Document;
import rx.Observable;

public interface DocumentsApi {
    @GET("documents")
    Observable<List<Document>> documents();
}
