
const Dev = require('../models/Dev');
const axios = require('axios');
const parseStringAsArray = require('../utils/parseStringAsArray');

//index: mostra uma lista
//store: armazena
//show: mostra um unico valor
//update: alterar
//destroy: deletar

module.exports = {
    async index (request, response) {
        const devs = await Dev.find();
        return response.json(devs);
    },
    async destroy (request, response) {
        const { github_username} = request.query;
        await Dev.remove({github_username})
        return response.json({});
    },
    async store (request, response) {
        const { github_username, techs, latitude, longitude } = request.body;
        
        
        let dev = await Dev.findOneAndDelete({github_username});

        if(!dev) {
            const apiResponse = await axios.get(`https://api.github.com/users/${github_username}`);
        
            //Se o nome for fazio ele pega o valor da propriedade login
            const {name = login, avatar_url, bio} = apiResponse.data;
            const techsArray = parseStringAsArray(techs)
        
            const location = {
                type: 'Point',
                coordinates: [longitude, latitude],
        
            }
        
            dev = await Dev.create({
                github_username,
                name,
                avatar_url,
                bio,
                techs: techsArray,
                location
            })
        }
        return response.json(dev);
    }
};