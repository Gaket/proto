package ru.innopolis.yorsogettingxbox.repository.network;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import ru.innopolis.yorsogettingxbox.models.Document;
import rx.Observable;

public interface DocumentsApi {
    @GET("documents")
    Observable<List<Document>> documents();

    @Multipart
    @POST("deals/{id}/documents")
    Call<ResponseBody> upload(int id,
                              @Part("description") RequestBody description,
                              @Part MultipartBody.Part file);
}
