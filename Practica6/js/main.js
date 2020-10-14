var bLogeo = document.getElementById('signin');
bLogeo.addEventListener('click', function(){
    var p = document.getElementById('password').value;
    var e = document.getElementById('email').value;
    const parametros = new URLSearchParams();
    parametros.append('Prmemail', e);
    parametros.append('Prmpassword', p);
    axios.get('http://localhost/adios')
        .then(function(response){
            console.log(response)
            console.log('contenido: ' + response.data)
            console.log('estatus: ' + response.status)
            document.getElementById('titulo').innerHTML = response.data
        })
        .catch(function(error){
           console.log(error)
        })
})

