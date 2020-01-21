const {Router} = require('express');
const routes = Router();

const DevController = require('./controllers/DevController');
const SearchController = require('./controllers/SearchController');


routes.get('/search', SearchController.index);

routes.get('/devs', DevController.index);
routes.post('/devs', DevController.store);
routes.delete('/devs', DevController.destroy);


routes.delete('/usuario/:id', (request, response) => {
    console.log(request.params);
    return response.json({message: 'Hello Uenderley =)'});
});

module.exports = routes;