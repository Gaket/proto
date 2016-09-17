package ru.innopolis.yorsogettingxbox.network;

import java.util.List;

import retrofit2.http.GET;
import ru.innopolis.yorsogettingxbox.models.Document;
import rx.Observable;

public interface DocumentsApi {
    @GET("deals")
    Observable<List<Document>> documents();
}
