package grant.com.githubjobs.remote

import grant.com.githubjobs.model.Job
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubJobService {

    @GET("/positions.json")
    suspend fun getPositions() : List<Job>
    @GET("/positions.json")
    suspend fun getPositionsByDescription(@Query("description") description : String) : List<Job>
    @GET("/positions.json")
    suspend fun getPositionsByLocation(@Query("location") location : String) : List<Job>
    @GET("/positions.json")
    suspend fun getPositionsByDescAndLocation(@Query("description") description : String, @Query("location") location : String) : List<Job>
}