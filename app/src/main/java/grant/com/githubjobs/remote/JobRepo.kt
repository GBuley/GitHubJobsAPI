package grant.com.githubjobs.remote

import grant.com.githubjobs.model.Job

object JobRepo {

    suspend fun getJobs() :List<Job>{
        return RetroFitInstance.jobService.getPositions();
    }
    suspend fun getJobsByDescription(description : String) :List<Job>{
        return RetroFitInstance.jobService.getPositionsByDescription(description);
    }
    suspend fun getJobsByLocation(location : String) :List<Job>{
        return RetroFitInstance.jobService.getPositionsByLocation(location);
    }
    suspend fun getJobs(description: String, location: String) :List<Job>{
        return RetroFitInstance.jobService.getPositionsByDescAndLocation(description, location);
    }
}