const express = require('express');
const cors = require('cors');
const mongoose = require('mongoose');
const routes = require('./routes');
const app = express();

mongoose.connect('mongodb+srv://uenderley:UR_160791@cluster0-vijxb.mongodb.net/week10?retryWrites=true&w=majority', {
    useNewUrlParser: true,
    useUnifiedTopology: true
})

//User serve para todos os metodos HTTP
app.use(cors());
app.use(express.json())
app.use(routes);
app.listen(3333);