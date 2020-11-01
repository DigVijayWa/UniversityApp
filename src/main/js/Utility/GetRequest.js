import axios from 'axios';


function GetRequest(url) {
        return new Promise((resolve, reject)=> {
            axios.get(url).then(res => {
                resolve(res);
            }
        ).catch(err=> {
            reject(res);
        });
    });
}

export default GetRequest;