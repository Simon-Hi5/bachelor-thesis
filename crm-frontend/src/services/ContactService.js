import axios from "axios";

const BACKEND = process.env.REACT_APP_BACKEND;

const CONTACT_API = 'http://' + BACKEND + '/contacts';

class ContactService {

    getAllContacts() {
        return axios.get(CONTACT_API);
    }

    saveContact(contact) {
        return axios.post(CONTACT_API, contact);
    }

    getContact(id) {
        return axios.get(CONTACT_API + "/" + id);
    }

    replaceContact(id, contact) {
        return axios.put(CONTACT_API + "/" + id, contact);
    }

    deleteContact(id) {
        return axios.delete(CONTACT_API + "/" + id)
    }

}

export default new ContactService()

