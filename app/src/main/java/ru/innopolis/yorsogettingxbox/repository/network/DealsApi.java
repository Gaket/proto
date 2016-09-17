package ru.innopolis.yorsogettingxbox.repository.network;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import ru.innopolis.yorsogettingxbox.models.Deal;
import rx.Observable;

public interface DealsApi {
    @GET("deals/")
    Observable<List<Deal>> deals();

    @POST("deals/")
    Observable<Deal> newDeal(@Body Deal deal);
}
