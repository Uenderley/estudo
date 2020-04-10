axios.get('https://api.github.com/users/Uenderley')
    .then(function(response) {
        console.log(response.data); 
    })
    .catch(function(error) {
        console.log(error); 
});
