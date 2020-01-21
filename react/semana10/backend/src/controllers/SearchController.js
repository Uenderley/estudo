const Dev = require('../models/Dev');
const parseStringAsArray = require('../utils/parseStringAsArray');
const axios = require('axios');

module.exports = {
    async index(request, response) {
        const { latitude, longitude, techs} = request.query;
        const techsArray = parseStringAsArray(techs);

        let lon = parseFloat(longitude);
        let lat = parseFloat(latitude);

        const devs = await Dev.find({
            techs:{
                $in: techsArray
            },
            location: {
                $near: {
                    $geometry: {
                        type: 'Point',
                        coordinates: [lon, lat],
                    },
                    $maxDistance: 10000
                },
            },
        });

        return response.json(devs);
    }
}