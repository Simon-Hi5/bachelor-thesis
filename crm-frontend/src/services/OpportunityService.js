import axios from "axios";

const BACKEND = process.env.REACT_APP_BACKEND;

const INTERACTION_API = 'http://' + BACKEND + (BACKEND === 'localhost' ? ':8082' : ':30012') + '/opportunities';

class OpportunityService {

    getAllOpportunities() {
        return axios.get(INTERACTION_API);
    }

    saveOpportunity(Opportunity) {
        return axios.post(INTERACTION_API, Opportunity);
    }

    getOpportunity(id) {
        return axios.get(INTERACTION_API + "/" + id);
    }

    replaceOpportunity(id, Opportunity) {
        return axios.put(INTERACTION_API + "/" + id, Opportunity);
    }

    deleteOpportunity(id) {
        return axios.delete(INTERACTION_API + "/" + id)
    }

}

export default new OpportunityService()

