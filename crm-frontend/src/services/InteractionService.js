import axios from "axios";

const BACKEND = process.env.REACT_APP_BACKEND;

const INTERACTION_API = 'http://' + BACKEND + (BACKEND === 'localhost' ? ':8081' : ':30011') + '/interactions';

class InteractionService {

    getAllInteractions() {
        return axios.get(INTERACTION_API);
    }

    saveInteraction(Interaction) {
        return axios.post(INTERACTION_API, Interaction);
    }

    getInteraction(id) {
        return axios.get(INTERACTION_API + "/" + id);
    }

    replaceInteraction(id, Interaction) {
        return axios.put(INTERACTION_API + "/" + id, Interaction);
    }

    deleteInteraction(id) {
        return axios.delete(INTERACTION_API + "/" + id)
    }

}

export default new InteractionService()

