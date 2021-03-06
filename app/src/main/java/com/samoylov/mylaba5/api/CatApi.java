package com.samoylov.mylaba5.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import com.samoylov.mylaba5.api.model.BreedDTO;
import com.samoylov.mylaba5.api.model.PhotoDTO;
import com.samoylov.mylaba5.api.model.PostCreate;
import com.samoylov.mylaba5.api.model.PostGet;
import com.samoylov.mylaba5.api.model.Vote;

public interface CatApi {
    @Headers("x-api-key: 48dc50ad-def4-4068-a19e-7a3e95d0afb0")
    @GET("breeds")
    Call<List<BreedDTO>> getBreeds();

    @Headers("x-api-key: 48dc50ad-def4-4068-a19e-7a3e95d0afb0")
    @GET("images/search?mime_types=gif,jpg,png")
    Call<List<PhotoDTO>> getPhotoForBreed(@Query("breed_ids") String breed,
                                          @Query("limit") int limit,
                                          @Query("order") String desc,
                                          @Query("page") int page
    );

    @Headers("x-api-key: 48dc50ad-def4-4068-a19e-7a3e95d0afb0")
    @GET("votes")
    Call<List<PostGet>> getVotes(@Query("sub_id") String sub_id);

    @Headers("x-api-key: 48dc50ad-def4-4068-a19e-7a3e95d0afb0")
    @GET("images/{image_id}")
    Call<PhotoDTO> getVotesLike(@Path("image_id") String image_id
    );

    @Headers("x-api-key: 48dc50ad-def4-4068-a19e-7a3e95d0afb0")
    @DELETE("votes/{vote_id}")
    Call<Void> delVote(@Path("vote_id") int vote_id
    );

    @Headers("x-api-key: 48dc50ad-def4-4068-a19e-7a3e95d0afb0")
    @POST("votes")
    Call<Vote> setPostFavourites(@Body PostCreate postCreate);

}