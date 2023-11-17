import axios from "axios";
const API_URL = "http://localhost:8090/public";

class BuildsService {
    save(builds){
        return axios.post(API_URL + "/create_builds", builds);
    }
}

export default BuildsService;