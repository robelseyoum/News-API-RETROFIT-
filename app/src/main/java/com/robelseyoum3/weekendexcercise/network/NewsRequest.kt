package com.robelseyoum3.weekendexcercise.network

import com.robelseyoum3.weekendexcercise.models.NewsSource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsRequest {
/*


//    const val BASE_URL_TEAM = "https://www.thesportsdb.com/api/v1/json/1/"
//    const val TEAMVALUE = "English Premier League"
//    const val TEAM_ID = "TEAM_ID"


    @GET("search_all_teams.php")
    fun getTeams(@Query("l") leagues: String): Call<TeamModel>

    //https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English%20Premier%20League

    //https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=133604

    @GET("lookupteam.php")
    fun getTeamDetails(@Query("id") teamID : String): Call<TeamDetailModel>

    //https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY

 */

    @GET("top-headlines")
    fun getNews(@Query("country") country: String, @Query("apiKey") apiKey: String): Call<NewsSource>
}