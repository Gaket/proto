package ru.innopolis.yorsogettingxbox.network;

import java.util.List;

import retrofit2.http.GET;
import ru.innopolis.yorsogettingxbox.models.Deal;
import ru.innopolis.yorsogettingxbox.models.Document;
import rx.Observable;

public interface DealsApi {
    @GET("deals")
    Observable<List<Deal>> deals();
}
